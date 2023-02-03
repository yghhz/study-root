package com.yghhz.io.stream.study.bio;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author wanghongwei
 * @Title:
 * @Description: 字节输出流练习
 * @date 2022/10/1 15:36
 */
public class OutStreamStudy {
    /**
     * @description FileOutputStream输出不追加
     * @author wanghongwei
     * @date 2023/2/2 19:32
     * @return void
    **/
    public static void outputStreamStudy(){
        FileOutputStream fileOutputStream = null;
        try{
            fileOutputStream = new FileOutputStream(new File("D:\\work\\doc\\text3.txt"));
            fileOutputStream.write("哈哈！".getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * @description  FileOutputStream输出追加到末尾
     * @author wanghongwei
     * @date 2023/2/2 19:32
     * @return void
    **/
    public static void outputStreamAppendStudy(){
        FileOutputStream fileOutputStream = null;
        try{
            fileOutputStream = new FileOutputStream(new File("D:\\work\\zip\\text3.txt"),true);
            fileOutputStream.write("测试".getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * @description 缓冲流输出
     * @author wanghongwei
     * @date 2023/2/2 19:34
     * @return void
    **/
    public static void bufferedOutputStreamStudy(){
        BufferedOutputStream bufferedOutputStream = null;
        FileOutputStream fileOutputStream = null;
        try{
            fileOutputStream = new FileOutputStream("D:\\work\\zip\\text3.txt",true);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            bufferedOutputStream.write("缓存流".getBytes());
            bufferedOutputStream.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(bufferedOutputStream != null){
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        OutStreamStudy.bufferedOutputStreamStudy();
    }
}
