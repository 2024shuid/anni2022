package main.others;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;
import com.qianxinyao.analysis.jieba.keyword.Keyword;
import com.qianxinyao.analysis.jieba.keyword.TFIDFAnalyzer;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;

public class getSimHash {
    /*
    计算局部敏感哈希值
    */
    public static String getHash(String str){
        try{
            // 使用 MD5 获得 hash 值
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            return new BigInteger(1, messageDigest.digest(str.getBytes("UTF-8"))).toString(2);
        }catch(Exception e){
            e.printStackTrace();
            return str;
        }
    }

    public static String simHash(String str) {
        int[] v = new int[128];

        if(str==null || str.length()==0){
            return null;
        }
        //进行文本过滤，将标点与停用词去掉
        String regEx = "[\n\r\t`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。， 、？^p]";
        String aa = "";
        str= str.replaceAll(regEx, aa).replaceAll("　", "").replaceAll(" ", "");
        str = str.replaceAll("的|了|在|是|有|和|不|这|也|人|说|要|就|但|还|你|我|他|它","");

        JiebaSegmenter segmenter = new JiebaSegmenter();
        List<SegToken> tokens = segmenter.process(str, JiebaSegmenter.SegMode.SEARCH);
        int topN=tokens.size()/4*3;
        //分词并计算关键词权重
        TFIDFAnalyzer tfidfAnalyzer=new TFIDFAnalyzer();
        List<Keyword> list=tfidfAnalyzer.analyze(str,topN);


        for(Keyword word:list){
            //System.out.println(word.getName()+":"+word.getTfidfvalue()+",");
            //得到每个关键词的哈希值
            String keywordHash = getHash(word.getName());

            if (keywordHash.length() < 128) {

                int dif = 128 - keywordHash.length();
                //如果哈希值不足128位，则补足低位0
                for (int j = 0; j < dif; j++) {
                    keywordHash += "0";
                }
            }
            //计算关键词的128位向量值之和
            for (int j = 0; j < v.length; j++) {
                if (keywordHash.charAt(j) == '1') {
                    //v[j] += (10 - (i / (size / 10)));
                    v[j] += word.getTfidfvalue()*10000;
                } else {
                    // v[j] -= (10 - (i / (size / 10)));
                    v[j] -= word.getTfidfvalue()*10000;
                }
            }
        }
        //将总的哈希值降维，向量变 0 或 1，返回 simHash 值
        String simHash = "";
        for (int j = 0; j < v.length; j++) {
            if (v[j] <= 0) {
                simHash += "0";
            } else {
                simHash += "1";
            }
        }
        return simHash;

    }


}
