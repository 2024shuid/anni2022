package test.others;

import main.others.Files;
import main.others.getDistance;
import main.others.getSimHash;
import org.junit.Test;

public class getDistanceTest {
    /*
    通过得到的哈希向量，计算两个文本的海明距离并返回该值
     */
    @Test
    public void getHammingDistanceTestOK() {
        String str0="D:\\code\\projects\\tests\\orig.txt";
        String str1="D:\\code\\projects\\tests\\orig_0.8_add.txt";
        getDistance.getHammingDistance(getSimHash.simHash(Files.read(str0)),getSimHash.simHash(Files.read(str1)));
    }

    @Test
    //输入两个simHash值，返回相似度
    public void getSimilarityTest() {
        // 获得它们的相似度
        String str0="D:\\code\\projects\\tests\\orig.txt";
        String str1="D:\\code\\projects\\tests\\orig_0.8_del.txt";
        double answer = getDistance.getSimilarity(getSimHash.simHash(Files.read(str0)), getSimHash.simHash(Files.read(str1)));
        System.out.println(answer);
    }

}
