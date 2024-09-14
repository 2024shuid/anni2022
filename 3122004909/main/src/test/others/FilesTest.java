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
        Files.read("D:\\code\\projects\\tests\\orig.txt");
        Files.read("D:\\code\\projects\\tests\\orig_0.8_add.txt");
    }
    @Test
    public void readTestNotOK() {
        //文件的读取
        Files.read("D:\\code\\projects\\tests\\del58.txt");

    }
    @Test
    public  void writeTestOK(){
        //文件的写入
        String path = "D:\\code\\projects\\tests\\test.txt";
        String str0="D:\\code\\projects\\tests\\orig.txt";
        String str1="D:\\code\\projects\\tests\\orig_0.8_del.txt";
        double Similarity= getDistance.getSimilarity(getSimHash.simHash(Files.read(str0)),getSimHash.simHash(Files.read(str1)));
        Files.write(Similarity,path);

    }
    @Test
    public  void writeTestNotOK1(){
        String path = "G:\\code\\projects\\tests\\test.txt";
        String str0="D:\\code\\projects\\tests\\orig.txt";
        String str1="D:\\code\\projects\\tests\\orig_0.8_del.txt";
        double Similarity=getDistance.getSimilarity(getSimHash.simHash(Files.read(str0)),getSimHash.simHash(Files.read(str1)));
        Files.write(Similarity,path);
    }

    @Test
    public  void writeTestNotOK2(){
        String path = "G:\\code\\projects\\tests\\test.txt";
        double Similarity=1;
        Files.write(Similarity,path);
    }

}
