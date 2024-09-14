package test.others;

import main.others.Files;
import main.others.getSimHash;
import org.junit.Test;

public class getSimHashTest {
    /*
    计算局部敏感哈希值
    */
    @Test
    public void getHashTestOK(){
        String str="E:\\新建文件夹\\anni2022\\3122004909\\main\\txt\\orig.txt";
        getSimHash.getHash(Files.read(str));
    }

    @Test
    public void getHashTestNotOK(){
        String str="E:\\新建文件夹\\anni2022\\3122004909\\main\\txt\\no.txt";
        getSimHash.getHash(Files.read(str));

    }
    @Test
    public void simHashTestOK() {
        String str="E:\\新建文件夹\\anni2022\\3122004909\\main\\txt\\orig.txt";
        getSimHash.simHash(Files.read(str));
    }
    @Test
    public void simHashTestNotOK() {
        String str="E:\\新建文件夹\\anni2022\\3122004909\\main\\txt\\no.txt";
        getSimHash.simHash(Files.read(str));
    }


}
