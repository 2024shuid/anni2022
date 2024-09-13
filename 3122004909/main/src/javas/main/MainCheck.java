package javas.main;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;
import javas.getTXT.Files;
import javas.hammingDistance.getDistance;
import javas.simHash.getSimHash;
import java.util.List;

public class MainCheck {

        public void check() {
            String[] str = new String[6];
            str[0] = Files.read("D:\\code\\main\\tests\\orig.txt");
            str[1] = Files.read("D:\\code\\main\\tests\\orig_0.8_add.txt");
            str[2] = Files.read("D:\\code\\main\\tests\\orig_0.8_del.txt");
            str[3] = Files.read("D:\\code\\main\\tests\\orig_0.8_dis_1.txt");
            str[4] = Files.read("D:\\code\\main\\tests\\orig_0.8_dis_10.txt");
            str[5] = Files.read("D:\\code\\main\\tests\\orig_0.8_dis_15.txt");
            //String ansFileName = "D:\\code\\main\\tests\\text.txt";
            //System.out.println(str[0]);

            /*for (int i = 0; i <= 5; i++) {
                Double similarity = HammingUtils.getSimilarity(SimHashUtils.getSimHash(str[0]), SimHashUtils.getSimHash(str[i]));
                String resultSimilarity = String.format("%.2f", similarity);
                String result = "时间：" + DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss").format(LocalDateTime.now()) + "\n" + "原文件与文件" + i + "的相似度为：" + resultSimilarity + "\r\n";
                TxtIOUtils.writeTxt(result, ansFileName);
                System.out.println(result);
            }*/

        }

    public static void main(String[] args) {
        // 从命令行输入的路径名读取对应的文件，将文件的内容转化为对应的字符串
       // String str0 = Files.read(args[0]);
        //String str1 = Files.read(args[1]);
        String str0 = Files.read("D:\\code\\main\\tests\\orig.txt");
        String str1 = Files.read("D:\\code\\main\\tests\\orig_0.8_del.txt");
        String resultFileName ="D:\\code\\main\\tests\\text.txt";
        //String resultFileName = args[2];
        // 由字符串得出对应的 simHash值
        String simHash0 = getSimHash.simHash(str0);
        String simHash1 = getSimHash.simHash(str1);
        // 由 simHash值求出相似度
        double similarity = getDistance.getSimilarity(simHash0, simHash1);
        // 把相似度写入最后的结果文件中
        Files.write(similarity, resultFileName);
        // 退出程序
        System.exit(0);
    }


}
