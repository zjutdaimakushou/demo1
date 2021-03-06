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
            // 获取文件名称,包含后缀
            String fileName = file.getOriginalFilename();
            // 生成一个随机字符串
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
                // 该方法是对文件写入的封装，在util类中，导入该包即可使用，后面会给出方法
                FileUtil.fileupload(file.getBytes(), fileName);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            // 接着创建对应的实体类，将以下路径进行添加，然后通过数据库操作方法写入
            FilePath biaopath = new FilePath();
            biaopath.setPath("http://localhost:8080/" + fileName);
            return biaopath.getPath();
        } else
            return null;
    }

    public String update(@RequestParam("upload") MultipartFile file,@RequestParam("originpath") String originpath){
        if (!file.isEmpty()) {
            // 获取文件名称,包含后缀
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
                // 该方法是对文件写入的封装，在util类中，导入该包即可使用，后面会给出方法
                originpath=originpath.replace("http://localhost:8080/","");
                FileUtil.deletefile(originpath);
                FileUtil.fileupload(file.getBytes(), fileName);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            // 接着创建对应的实体类，将以下路径进行添加，然后通过数据库操作方法写入
            FilePath biaopath = new FilePath();
            biaopath.setPath("http://localhost:8080/" + fileName);
            return biaopath.getPath();
        } else
            return null;
    }
}

