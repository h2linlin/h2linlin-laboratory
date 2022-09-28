package utilbox.txtprocess;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;


/**
 * @Author h2linlin
 * QQ空间，日志评论json：提取提交时间及内容
 */
public class TxtProcessUtil {
    private static String inFilePath = "D:\\test-in.txt";     // 输入文件路径
    private static String outFilePath = "D:\\test-out.txt";    // 输出文件路径

    /**
     * 引入文件，处理，输入结果
     */
    public static void IPO(String inPath, String outPath, ITxtProcessor txtProcessor) throws IOException {
        if (inPath != null && !inPath.equals("")) { inFilePath = inPath; }
        if (outPath != null && !outPath.equals("")) { outFilePath = outPath; }
        writeTxt(txtProcessor.process(readTxt()));
    }

    // 读入文件字符串。逐行读取文件内容，不读取换行符和末尾的空格。
    private static String readTxt() throws IOException {
        // 读入文件
        File file = new File(inFilePath);           //定义一个file对象，用来初始化FileReader
        FileReader reader = new FileReader(file);   //定义一个fileReader对象，用来初始化BufferedReader
        BufferedReader bReader = new BufferedReader(reader);//new一个BufferedReader对象，将文件内容读取到缓存
        StringBuilder sb = new StringBuilder();     //定义一个字符串缓存，将字符串存放缓存中
        String s = "";
        while ((s = bReader.readLine()) != null) {   //逐行读取文件内容，不读取换行符和末尾的空格
            sb.append(s);//将读取的字符串累加存放在缓存中
//            System.out.println(s);
        }
        bReader.close();
        String str = sb.toString();
//        System.out.println(str);

        return str;
    }

    // 输出文件字符串
    private static void writeTxt (String str) throws IOException {
        String filePath = outFilePath;
        FileOutputStream fos = new FileOutputStream(filePath);
        fos.write(str.getBytes());
        fos.close();
    }
}
