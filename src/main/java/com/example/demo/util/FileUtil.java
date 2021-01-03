package com.example.demo.util;

import java.io.*;

public class FileUtil {
    //静态方法：三个参数：文件的二进制，文件路径，文件名
    //通过该方法将在指定目录下添加指定文件
    public static void fileupload(byte[] file, String fileName) throws IOException {
        File target = new File("C:/Program Files/Apache Software Foundation/Tomcat 9.0/webapps/demo1/build/classes/java/main/static/"+fileName);
        FileOutputStream out = null;
        try {
            if (!target.exists()) {
                // 先得到文件的上级目录，并创建上级目录，在创建文件
                target.getParentFile().mkdir();
                target.createNewFile();
            }

            //创建文件输出流
            out = new FileOutputStream(target);
            //将字符串转化为字节
            out.write(file);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deletefile(String originpath){
        File target = new File("C:/Program Files/Apache Software Foundation/Tomcat 9.0/webapps/demo1/build/classes/java/main/static/"+originpath);
        target.delete();
    }
}
