package com.yghhz.io.stream.study.bio.combine;

import java.io.*;
import java.util.Properties;

/**
 * @author wanghongwei
 * @Title: properties操作类
 * @Description:
 * @date 2022/10/3 17:12
 */
public class PropertiesOperate {
    public static void main(String[] args) {
        PropertiesOperate.setValue("1111","333");

    }
    /**
     * 获取Properties对象
     * @return
     */
    public static Properties getProperties(){
        String url = System.getenv("G800WEB_HOME")+ File.separator+"config"+File.separator+"report_group.properties";
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            //data.properties在resources目录下
            inputStream = new FileInputStream(url);
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           if(inputStream != null){
               try {
                   inputStream.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
        }
        return properties;
    }

    /**
     * 根据key查询value值
     * @param key key
     * @return
     */
    public static String getValue(String key){
        Properties properties = getProperties();
        String value = properties.getProperty(key);
        return value;
    }

    /**
     * 新增/修改数据
     * @param key
     * @param value
     */
    public static void setValue(String key, String value){
        Properties properties = getProperties();
        properties.setProperty(key, value);
        //此处获取的路径是target下classes

        //这里的path是项目文件的绝对路径
        //先获取项目绝对路径：Thread.currentThread().getContextClassLoader().getResource("").getPath();
        //然后在项目路径后面拼接"properties/sysConfig.properties";
        // 原注释
        String url = System.getenv("G800WEB_HOME")+ File.separator+"config"+File.separator+"report_group.properties";
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(url);
            properties.store(fileOutputStream, "注释");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fileOutputStream){
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                System.out.println("data.properties文件流关闭出现异常");
            }
        }
    }

}
