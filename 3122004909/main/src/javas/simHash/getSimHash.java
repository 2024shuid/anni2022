package javas.simHash;
import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
public class  getSimHash {

    public static String getHash(String str){
        try{
            // 这里使用了MD5获得hash值
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            return new BigInteger(1, messageDigest.digest(str.getBytes("UTF-8"))).toString(2);
        }catch(Exception e){
            e.printStackTrace();
            return str;
        }
    }

    public static String simHash(String str) {
        int[] v = new int[128];
        JiebaSegmenter segmenter = new JiebaSegmenter();
        List<SegToken> tokens = segmenter.process(str, JiebaSegmenter.SegMode.SEARCH);


        /*for (SegToken token : tokens) {
            System.out.println(token.word);
        }*/
        int i = 0;
        int size = tokens.size();

        for (SegToken keyword : tokens) {
            //2. 获取hash值
            String keywordHash = getHash(keyword.word);
            if (keywordHash.length() < 128) {

                int dif = 128 - keywordHash.length();
                for (int j = 0; j < dif; j++) {
                    keywordHash += "0";         //如果哈希值不足128位，则补足低位0
                }
            }

            for (int j = 0; j < v.length; j++) {
                if (keywordHash.charAt(j) == '1') {
                    v[j] += (10 - (i / (size / 10)));
                } else {
                    v[j] -= (10 - (i / (size / 10)));
                }
            }
            i++;
        }
        //4. 降维
        //储存返回的simHash值
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




