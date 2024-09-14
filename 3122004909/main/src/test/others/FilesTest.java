package test.others;

import main.others.Files;
import main.others.getDistance;
import main.others.getSimHash;
import org.junit.Test;

public class FilesTest {
    /*
    进行文件的读写
     */
    @Test
    public void readTestOK() {
        //文件的读取
        Files.read("E:\\新建文件夹\\anni2022\\3122004909\\main\\txt\\orig.txt");
        Files.read("E:\\新建文件夹\\anni2022\\3122004909\\main\\txt\\orig_0.8_add.txt");
    }
    @Test
    public void readTestNotOK() {
        //文件的读取
        Files.read("E:\\新建文件夹\\anni2022\\3122004909\\main\\txt\\no.txt");

    }
    @Test
    public  void writeTestOK(){
        //文件的写入
        String path = "E:\\新建文件夹\\anni2022\\3122004909\\main\\txt\\test.txt";
        String str0="E:\\新建文件夹\\anni2022\\3122004909\\main\\txt\\orig.txt";
        String str1="E:\\新建文件夹\\anni2022\\3122004909\\main\\txt\\orig_0.8_del.txt";
        double Similarity= getDistance.getSimilarity(getSimHash.simHash(Files.read(str0)),getSimHash.simHash(Files.read(str1)));
        Files.write(Similarity,path);

    }
    @Test
    public  void writeTestNotOK1(){
        String path = "G:\\code\\projects\\tests\\test.txt";
        String str0="E:\\新建文件夹\\anni2022\\3122004909\\main\\txt\\orig.txt";
        String str1="E:\\新建文件夹\\anni2022\\3122004909\\main\\txt\\orig_0.8_del.txt";
        double Similarity=getDistance.getSimilarity(getSimHash.simHash(Files.read(str0)),getSimHash.simHash(Files.read(str1)));
        Files.write(Similarity,path);
    }

    @Test
    public  void writeTestNotOK2(){
        String path = "E:\\新建文件夹\\anni2022\\3122004909\\main\\txt\\test.txt";
        double Similarity=1;
        Files.write(Similarity,path);
    }

}
