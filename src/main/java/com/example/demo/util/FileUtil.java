package com.example.demo.util;

import java.io.*;

public class FileUtil {
    //��̬�����������������ļ��Ķ����ƣ��ļ�·�����ļ���
    //ͨ���÷�������ָ��Ŀ¼�����ָ���ļ�
    public static void fileupload(byte[] file, String fileName) throws IOException {
        File target = new File("C:/Program Files/Apache Software Foundation/Tomcat 9.0/webapps/demo1/build/classes/java/main/static/"+fileName);
        FileOutputStream out = null;
        try {
            if (!target.exists()) {
                // �ȵõ��ļ����ϼ�Ŀ¼���������ϼ�Ŀ¼���ڴ����ļ�
                target.getParentFile().mkdir();
                target.createNewFile();
            }

            //�����ļ������
            out = new FileOutputStream(target);
            //���ַ���ת��Ϊ�ֽ�
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
