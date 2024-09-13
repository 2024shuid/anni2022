package javas.getTXT;
import java.io.*;

public class Files {

    public static String read(String str) {
        String txt=null;
        // 绝对路径或相对路径都可以，写入文件时演示相对路径,读取以上路径的input.txt文件
        //防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw;
        //不关闭文件会导致资源的泄露，读写文件都同理
        //Java7的try-with-resources可以优雅关闭文件，异常时自动关闭文件；详细解读https://stackoverflow.com/a/12665271
        try (FileReader reader = new FileReader(str);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            String line;
            if ((line = br.readLine()) != null) txt=line;
            //网友推荐更加简洁的写法
            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
                //System.out.println(line);
                txt+=line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return txt;
    }

    public static void write(double txt,String Path){

        File file = new File(Path);
        String str = Double.toString(txt);
        try {

            FileWriter writer = new FileWriter(file,true);
            BufferedWriter br = new BufferedWriter(writer);
           for(int i=0;i<4;i++)
             br.write(str.charAt(i));
            br.write("\r\n");
            br.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}








