package com.yghhz.io.stream.study.bio;

import java.io.*;

/**
 * @author wanghongwei
 * @Title:
 * @Description: 字符输出流练习
 * @date 2022/10/1 15:47
 */
public class WriterStudy {

    /** 
     * @description 字符输出流 
     * @author wanghongwei 
     * @date 2023/2/2 19:49  
     * @return void
    **/
    public static void outputStreanReadreStudy(){
        OutputStreamWriter outputStreamWriter =null;
        FileOutputStream fileOutputStream = null;
        try{
            fileOutputStream = new FileOutputStream("D:\\work\\zip\\text4.txt");
            outputStreamWriter = new OutputStreamWriter(fileOutputStream,"UTF-8");
            outputStreamWriter.write("测试字符");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(outputStreamWriter != null){
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    /** 
     * @description 缓冲字符输出流  
     * @author wanghongwei 
     * @date 2023/2/2 19:50  
     * @return void
    **/
    public static void bufferedWriterStudy(){
        BufferedWriter bufferedWriter = null;
        OutputStreamWriter outputStreamWriter = null;
        FileOutputStream fileOutputStream = null;
        try{
            fileOutputStream = new FileOutputStream(new File("D:\\work\\zip\\text4.txt"),true);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream,"utf-8");
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write("测试追加");
            bufferedWriter.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(bufferedWriter != null){
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    /** 
     * @description 字符输出流便捷类 
     * @author wanghongwei 
     * @date 2023/2/2 19:52
     * @return void
    **/
    public static void fileWriterStudy(){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("D:\\work\\zip\\text4.txt",true);
            fileWriter.write("测试追加2");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(fileWriter != null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        WriterStudy.fileWriterStudy();
    }
}
