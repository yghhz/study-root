package com.yghhz.io.stream.study.bio.combine;

import java.io.*;

/**
 * @version V1.0
 * @Title:  缓冲字节流输入输出
 * @Package com.study.io
 * @Description: TODO
 * @author: wanghongwei
 * @date 2021/1/28
 */
public class Buffer {
    public static void main(String[] args) {
        File oldFile = new File("D:\\work\\图片\\结构图.png");
        File newfile = new File("D:\\work\\图片\\结构图copy.png");
        copyFile(oldFile, newfile);
    }
    /**
     * @description 拷贝文件
     * @author wanghongwei
     * @date 2023/2/2 19:19
     * @param oldFile
     * @param newfile
     * @return void
    **/
    private static void copyFile(File oldFile, File newfile) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        //缓冲字节流
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            fileInputStream = new FileInputStream(oldFile);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            fileOutputStream = new FileOutputStream(newfile);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            //建立缓冲区
            byte[] bytes = new byte[1024 * 300];
            int length = 0;
            while ((length = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, length);
            }
            //清空缓冲区数据
            bufferedOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
