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
        String str="D:\\code\\projects\\tests\\orig.txt";
        getSimHash.getHash(Files.read(str));
    }

    @Test
    public void getHashTestNotOK(){
        String str="D:\\code\\projects\\tests\\o.txt";
        getSimHash.getHash(Files.read(str));

    }
    @Test
    public void simHashTestOK() {
        String str="D:\\code\\projects\\tests\\orig.txt";
        getSimHash.simHash(Files.read(str));

        str="D:\\code\\projects\\tests\\o.txt";
        getSimHash.simHash(Files.read(str));
    }
    @Test
    public void simHashTestNotOK() {
        String str="D:\\code\\projects\\tests\\o.txt";
        getSimHash.simHash(Files.read(str));
    }


}
