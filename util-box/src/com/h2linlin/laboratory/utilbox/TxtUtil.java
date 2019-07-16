package com.h2linlin.laboratory.utilbox;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Desc 用于处理txt文本。输入一个文本，提取出里面不重复的单词，并按单词出现的顺序排序。
 * @Author zh wu
 * @Date 2019/7/16 10:38
 */
public class TxtUtil {
    private static String inFilePath = "D:\\a30.txt";     // 输入文件路径
    private static String outFilePath = "D:\\a30Out.txt";    // 输出文件路径

    public static void main(String[] args) {

        try {
            writeTest(processRepet(processOnlyEnglish(readTest())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 读入文件字符串
    public static String readTest() throws IOException {
        // 读入文件
        File file = new File(inFilePath);           //定义一个file对象，用来初始化FileReader
        FileReader reader = new FileReader(file);   //定义一个fileReader对象，用来初始化BufferedReader
        BufferedReader bReader = new BufferedReader(reader);//new一个BufferedReader对象，将文件内容读取到缓存
        StringBuilder sb = new StringBuilder();     //定义一个字符串缓存，将字符串存放缓存中
        String s = "";
        while ((s =bReader.readLine()) != null) {   //逐行读取文件内容，不读取换行符和末尾的空格
            sb.append(s + "\n");//将读取的字符串添加换行符后累加存放在缓存中
//            System.out.println(s);
        }
        bReader.close();
        String str = sb.toString();
        System.out.println(str.length() );

        return str;
    }

    // 文本去重处理：去除重复单词，按出现顺序排序
    public static String processRepet(String str) {
        String[] strArray = str.split(" ");
        System.out.println(strArray.length);

        List<String> outStrList = new ArrayList<>();

        A:for (int i = 0; i < strArray.length; i++) {   // 按单词出现的顺序输出，若之前已有过该单词，则不输出
            for (int j = i - 1; j > 0 ; j--) {
                if (strArray[i].equals(strArray[j])) {
                    continue A;
                }
            }
            outStrList.add(strArray[i]);
        }

        System.out.println(outStrList.size());

        // 输出
        String outStr = new String();
        StringBuilder sbOut = new StringBuilder();
        for (String ss : outStrList) {
            sbOut.append(ss + "\r\n");
        }
        outStr = sbOut.toString();

        return outStr;
    }

    // 去除多余空格及英文标点符号，以及中文
    public static String processOnlyEnglish(String str) {

        // 去掉英文标点符号
        Pattern p = Pattern.compile("[.,\"\\?!:]");//增加对应的标点,'留着
        Matcher m = p.matcher(str);
        String first = m.replaceAll("");

        // 去掉双字节字符
        /*p = Pattern.compile("[^x00-xff]");
        m = p.matcher(first);
        String second = m.replaceAll(" ");*/

        // 去掉多余空格
        p = Pattern.compile(" {2,}");
        m = p.matcher(first);
        String third = m.replaceAll(" ");

        return third;
    }

    // 转换大小写
    public static String processParseLower(String str) {
        return str.toLowerCase();
    }

    // 输出文件字符串
    public static void writeTest (String str) throws IOException {
        String filePath = outFilePath;
        FileOutputStream fos = new FileOutputStream(filePath);
        fos.write(str.getBytes());
        fos.close();
    }
}
