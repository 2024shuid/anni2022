package test.main;

import main.main.MainCheck;
import org.junit.Test;

public class MainCheckTest {
    @Test
    public void mainTest_dis1() {
        String[] content={"E:\\新建文件夹\\anni2022\\3122004909\\main\\txt\\orig.txt","E:\\新建文件夹\\anni2022\\3122004909\\main\\txt\\orig_0.8_dis_1.txt",
                "E:\\新建文件夹\\anni2022\\3122004909\\main\\txt\\test.txt"};
        MainCheck.main(content);
    }

    @Test
    public void mainTest_kong() {
        String[] content={"E:\\新建文件夹\\anni2022\\3122004909\\main\\txt\\orig.txt","E:\\新建文件夹\\anni2022\\3122004909\\main\\txt\\kong.txt",
                "E:\\新建文件夹\\anni2022\\3122004909\\main\\txt\\test.txt"};
        MainCheck.main(content);
    }
    @Test
    public void mainTest_notOK() {
        String[] content={"E:\\新建文件夹\\anni2022\\3122004909\\main\\txt\\orig.txt","E:\\新建文件夹\\anni2022\\3122004909\\main\\txt\\kong.txt"
                };
        MainCheck.main(content);
    }

}
