package test.main;

import main.main.MainCheck;
import org.junit.Test;

public class MainCheckTest {
    @Test
    public void mainTest_dis1() {
        String[] content={"D:\\code\\projects\\tests\\orig.txt","D:\\code\\projects\\tests\\orig_0.8_dis_1.txt",
                "D:\\code\\projects\\tests\\text.txt"};
        MainCheck.main(content);
    }

    @Test
    public void mainTest_kong() {
        String[] content={"D:\\code\\projects\\tests\\orig.txt","D:\\code\\projects\\tests\\kong.txt",
                "D:\\code\\projects\\tests\\text.txt"};
        MainCheck.main(content);
    }
    @Test
    public void mainTest_notOK() {
        String[] content={"D:\\code\\projects\\tests\\orig.txt","D:\\code\\projects\\tests\\kong.txt",
                };
        MainCheck.main(content);
    }

}
