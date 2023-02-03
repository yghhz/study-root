package com.yghhz.io.stream.study.bio.combine;

import java.io.*;

/**
 * @version V1.0
 * @Title: 缓冲字符流输入输出操作
 * @Package com.study.io
 * @Description: TODO
 * @author: wanghongwei
 * @date 2021/1/28
 */
public class BufferReader {
    public static void main(String[] args) {
        File oldFile = new File("D:\\work\\图片\\123.txt");
        File newFile = new File("D:\\work\\图片\\123copy.txt");
        copyFile(oldFile, newFile);
    }

    private static void copyFile(File oldFile, File newFile) {
        Reader reader = null;
        Writer writer = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            reader = new FileReader(oldFile);
            bufferedReader = new BufferedReader(reader);
            writer = new FileWriter(newFile);
            bufferedWriter = new BufferedWriter(writer);
            char[] chars = new char[1024];
            int length = 0;
            while ((length = bufferedReader.read(chars)) != -1) {
                bufferedWriter.write(chars, 0, length);
                bufferedWriter.newLine();
            }
 /*           String result = null;
            while ((result = bufferedReader.readLine()) != null){
                bufferedWriter.write(result);
                bufferedWriter.newLine();
            }*/
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
