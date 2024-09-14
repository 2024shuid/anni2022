package main.others;

import java.io.*;

public class Files {
    /*
    进行文件的读写
     */
    public static String read(String str) {
        //文件的读取
        String txt="";
        try {
            InputStreamReader isr=new InputStreamReader(new FileInputStream(str),"UTF-8");
            // 建立一个对象
            BufferedReader br = new BufferedReader(isr);
            String line="";
            // 一次读入一行数据
            while ((line = br.readLine()) != null) {
                txt+=line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return txt;
    }

    public static void write(double txt,String Path){
        //文件的写入
        File file = new File(Path);
        String str = Double.toString(txt);
        try {

            FileWriter writer = new FileWriter(file,true);
            BufferedWriter br = new BufferedWriter(writer);
            br.write(str, 0, (str.length() > 3 ? 4 : str.length()));
            br.write("\r\n");
            br.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
