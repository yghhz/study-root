package com.yghhz.io.stream.study.bio;

import java.io.*;

/**
 * @author wanghongwei
 * @Title:
 * @Description: 字符输入流练习
 * @date 2022/10/1 15:47
 */
public class ReaderStudy {

    /** 
     * @description  单字符输入流
     * @author wanghongwei 
     * @date 2023/2/2 19:35  
     * @return void
    **/
    public static void inputStreamReaderCharsetStudy(){
        InputStreamReader inputStreamReader = null;
        FileInputStream fileInputStream = null;
        try{
            fileInputStream = new FileInputStream("D:\\work\\zip\\text3.txt");
            inputStreamReader = new InputStreamReader(fileInputStream,"utf-8");
            int i = 0;
            //这里也是读取的ascii码
            while ((i = inputStreamReader.read()) != -1){
                System.out.println((char) i);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @description  多字符读取
     * @author wanghongwei
     * @date 2023/2/2 19:45
     * @return void
    **/
    public static void inputStreamReaderCharsetManyStudy(){
        InputStreamReader inputStreamReader = null;
        FileInputStream fileInputStream = null;
        try{
            fileInputStream = new FileInputStream("D:\\work\\zip\\text3.txt");
            inputStreamReader = new InputStreamReader(fileInputStream,"utf-8");
            int len = 0;
            char[] c = new char[20];
            //这里也是读取的ascii码
            while ((len = inputStreamReader.read(c)) != -1){
                System.out.println(new String(c,0,len));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @description 缓冲流单字符读取
     * @author wanghongwei
     * @date 2023/2/2 19:46
     * @return void
    **/
    public static void bufferedReaderSingleStudy(){
        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("D:\\work\\zip\\text3.txt");
            inputStreamReader = new InputStreamReader(fileInputStream,"utf-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            int i = 0;
            while ((i = bufferedReader.read()) != -1){
                System.out.println((char) i);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @description 缓冲流多字符读取
     * @author wanghongwei
     * @date 2023/2/2 19:46
     * @return void
    **/
    public static void bufferedReaderManyStudy(){
        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("D:\\work\\zip\\text3.txt");
            inputStreamReader = new InputStreamReader(fileInputStream,"utf-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            int len = 0;
            char[] c = new char[20];
            while ((len = bufferedReader.read(c)) != -1){
                System.out.println(new String(c,0,len));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @description 缓冲流按行读取
     * @author wanghongwei
     * @date 2023/2/2 19:46
     * @return void
    **/
    public static void bufferedReaderLineStudy(){
        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("D:\\work\\zip\\text3.txt");
            inputStreamReader = new InputStreamReader(fileInputStream,"utf-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            String str;
            while ((str = bufferedReader.readLine()) != null){
                System.out.println(str);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @description 用来读取字符文件的便捷类，使用默认字符编码 （单字符）
     * @author wanghongwei
     * @date 2023/2/2 19:48
     * @return void
    **/
    public static void fileReaderStudy(){
        FileReader fileReader = null;
        try{
            fileReader = new FileReader("D:\\work\\zip\\text4.txt");
            int i;
            while ((i = fileReader.read()) != -1){
                System.out.println((char) i);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @description 用来读取字符文件的便捷类，使用默认字符编码 （多字符）
     * @author wanghongwei
     * @date 2023/2/2 19:48
     * @return void
     **/
    public static void fileReaderManyStudy(){
        FileReader fileReader = null;
        try{
            fileReader = new FileReader("D:\\work\\zip\\text3.txt");
            int len;
            char[] c = new char[20];
            while ((len = fileReader.read(c)) != -1){
                System.out.println(new String(c,0,len));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ReaderStudy.fileReaderManyStudy();
    }
}
