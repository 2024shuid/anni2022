package main.main;

import main.others.Files;
import main.others.getDistance;
import main.others.getSimHash;

import java.io.*;

public class MainCheck {
    /*
    主函数，获得源文件与抄袭文件和结果文件的位置，计算相似度并输出到结果文件
     */
    public static void main(String[] args) {
        // 从命令行输入的路径名读取对应的文件，将文件的内容转化为对应的字符串
        
        String str0=args[0];
        String str1=args[1];
        String resultFileName=args[2];
        String simHash0 = getSimHash.simHash(Files.read(str0));
        String simHash1 = getSimHash.simHash(Files.read(str1));
        if (simHash1==null||simHash0==null) {
            System.out.println("simHash Error,有一文本为空");
        }else {
            // 由 simHash 值求出相似度
            double similarity = getDistance.getSimilarity(simHash0, simHash1);
            Files.write(similarity, resultFileName);
            System.out.println("相似度为"+String.format("%.2f",similarity));
    }



}


