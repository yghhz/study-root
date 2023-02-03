package com.yghhz.io.stream.study.bio;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author wanghongwei
 * @Title:
 * @Description: 字节输入流练习
 * @date 2022/10/1 15:36
 */
public class InputStreamStudy {
    /**
     * @description  FileInputStream单字节读取
     * @author wanghongwei
     * @date 2023/2/2 19:25
     * @return void
    **/
    public static void fileInputStreamStudySingleByte(){
        FileInputStream fileInputStream = null;
        try{
            fileInputStream = new FileInputStream(new File("D:\\work\\zip\\text2.txt"));
            //单个字节读取
            int i = 0;
            while ((i = fileInputStream.read()) != -1){
                //read()方法不带参数的时候，将会返回该字符对应的ASCII码
                System.out.print((char) i + " ");
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @description  FileInputStream多字节读取，数组长度会影响读取效率，一般设置1024，具体多少效率最高没验证过
     * @author wanghongwei
     * @date 2023/2/2 19:26
     * @return void
    **/
    public static void fileInputStreamStudyManyBytes(){
        FileInputStream fileInputStream = null;
        try{
            fileInputStream = new FileInputStream(new File("D:\\work\\zip\\text2.txt"));
            //多个字节读取
            byte[] b = new byte[2];
            int len = 0;
            while ((len = (fileInputStream.read(b))) != -1){
                //当传入byte数组时，read方法会返回一个int型的整数，该整数读入的数据在数组中的长度
                System.out.print(new String(b, 0, len) + " ");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * @description  bufferedInputStream单字节读取
     * @author wanghongwei
     * @date 2023/2/2 19:31
     * @return void
    **/
    public static void bufferedInputStreamSingleStudy(){
        BufferedInputStream bufferedInputStream = null;
        FileInputStream fileInputStream = null;
        try{
            fileInputStream = new FileInputStream(new File("D:\\work\\zip\\text2.txt"));
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            int i = 0;
            while ((i = bufferedInputStream.read()) != -1){
                System.out.println((char) i + " ");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(bufferedInputStream != null){
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * @description  bufferedInputStream多字节读取
     * @author wanghongwei
     * @date 2023/2/2 19:31
     * @return void
    **/
    public static void bufferedInputStreamManyStudy(){
        BufferedInputStream bufferedInputStream = null;
        FileInputStream fileInputStream = null;
        try{
            fileInputStream = new FileInputStream(new File("D:\\work\\zip\\text2.txt"));
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            byte[] b = new byte[2];
            int len = 0;
            while ((len = bufferedInputStream.read(b)) != -1){
                System.out.println(new String(b, 0, len));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(bufferedInputStream != null){
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        InputStreamStudy.bufferedInputStreamManyStudy();
    }
}
