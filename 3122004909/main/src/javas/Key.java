package javas;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;
import javas.getTXT.Files;
import java.util.List;

public class Key {

    public static void main(String[] args) {
        JiebaSegmenter segmenter = new JiebaSegmenter();
        String str= Files.read("D:\\code\\main\\tests\\orig.txt");
        List<SegToken> tokens= segmenter.process(str,JiebaSegmenter.SegMode.SEARCH);

        for (String sentence : str.split("\n")) {
            System.out.println(segmenter.process(sentence, JiebaSegmenter.SegMode.INDEX).toString());
        }

        /*for(SegToken token:tokens){
            System.out.println(token.word);
        }*/
    }


}
