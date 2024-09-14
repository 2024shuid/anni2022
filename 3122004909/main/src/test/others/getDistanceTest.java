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
        String str0="E:\\新建文件夹\\anni2022\\3122004909\\main\\txt\\orig.txt";
        String str1="E:\\新建文件夹\\anni2022\\3122004909\\main\\txt\\orig_0.8_add.txt";
        getDistance.getHammingDistance(getSimHash.simHash(Files.read(str0)),getSimHash.simHash(Files.read(str1)));
    }

    @Test
    //输入两个simHash值，返回相似度
    public void getSimilarityTest() {
        // 获得它们的相似度
        String str0="E:\\新建文件夹\\anni2022\\3122004909\\main\\txt\\orig.txt";
        String str1="E:\\新建文件夹\\anni2022\\3122004909\\main\\txt\\orig_0.8_add.txt";
        double answer = getDistance.getSimilarity(getSimHash.simHash(Files.read(str0)), getSimHash.simHash(Files.read(str1)));
        System.out.println(answer);
    }

}
