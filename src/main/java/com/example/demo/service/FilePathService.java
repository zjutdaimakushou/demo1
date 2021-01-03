package com.example.demo.service;

import java.io.IOException;
import java.util.Random;

import com.example.demo.model.FilePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.util.FileUtil;

@Service
public class FilePathService {

    public String Upload(@RequestParam("upload") MultipartFile file) {
        if (!file.isEmpty()) {
            // ��ȡ�ļ�����,������׺
            String fileName = file.getOriginalFilename();
            // ����һ������ַ���
            String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            Random random=new Random();
            StringBuffer sb=new StringBuffer();
            for(int i=0;i<16;i++){
                int number=random.nextInt(62);
                sb.append(str.charAt(number));
            }
            String newstring=sb.toString();
            fileName=newstring+fileName;
            try {
                // �÷����Ƕ��ļ�д��ķ�װ����util���У�����ð�����ʹ�ã�������������
                FileUtil.fileupload(file.getBytes(), fileName);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            // ���Ŵ�����Ӧ��ʵ���࣬������·��������ӣ�Ȼ��ͨ�����ݿ��������д��
            FilePath biaopath = new FilePath();
            biaopath.setPath("http://localhost:8080/" + fileName);
            return biaopath.getPath();
        } else
            return null;
    }

    public String update(@RequestParam("upload") MultipartFile file,@RequestParam("originpath") String originpath){
        if (!file.isEmpty()) {
            // ��ȡ�ļ�����,������׺
            String fileName = file.getOriginalFilename();
            String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            Random random=new Random();
            StringBuffer sb=new StringBuffer();
            for(int i=0;i<16;i++){
                int number=random.nextInt(62);
                sb.append(str.charAt(number));
            }
            String newstring=sb.toString();
            fileName=newstring+fileName;
            try {
                // �÷����Ƕ��ļ�д��ķ�װ����util���У�����ð�����ʹ�ã�������������
                originpath=originpath.replace("http://localhost:8080/","");
                FileUtil.deletefile(originpath);
                FileUtil.fileupload(file.getBytes(), fileName);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            // ���Ŵ�����Ӧ��ʵ���࣬������·��������ӣ�Ȼ��ͨ�����ݿ��������д��
            FilePath biaopath = new FilePath();
            biaopath.setPath("http://localhost:8080/" + fileName);
            return biaopath.getPath();
        } else
            return null;
    }
}

