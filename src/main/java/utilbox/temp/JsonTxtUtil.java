package utilbox.temp;

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
public class JsonTxtUtil {
    private static String inFilePath = "D:\\space_rizhi.json";     // 输入文件路径
    private static String outFilePath = "D:\\space_rizhi.txt";    // 输出文件路径

    public static void main(String[] args) {

        try {
            writeTxt(processContent(readTxt()));
            // writeTest(processRepet(processOnlyEnglish(readTest())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 读入文件字符串
    public static String readTxt() throws IOException {
        // 读入文件
        File file = new File(inFilePath);           //定义一个file对象，用来初始化FileReader
        FileReader reader = new FileReader(file);   //定义一个fileReader对象，用来初始化BufferedReader
        BufferedReader bReader = new BufferedReader(reader);//new一个BufferedReader对象，将文件内容读取到缓存
        StringBuilder sb = new StringBuilder();     //定义一个字符串缓存，将字符串存放缓存中
        String s = "";
        while ((s =bReader.readLine()) != null) {   //逐行读取文件内容，不读取换行符和末尾的空格
            sb.append(s);//将读取的字符串累加存放在缓存中
//            System.out.println(s);
        }
        bReader.close();
        String str = sb.toString();
//        System.out.println(str);

        return str;
    }

    // 文本转换为Json对象，提取需要的信息，并处理为需要的文本格式
    public static String processContent(String str) {
        // 转换为数组
        JSONArray jsonArray = JSON.parseArray(str);
        List<ContentObj> contentList = jsonArray.toJavaList(ContentObj.class);

        // 遍历数组，提取时间和内容
        StringBuilder sb = new StringBuilder();
        contentList.forEach(c -> {
            sb.append(dateParseUtil(c.getPostTime()) + "\t" + c.getContent() + "\n");
        });

        return sb.toString();
    }

    // 输出文件字符串
    public static void writeTxt (String str) throws IOException {
        String filePath = outFilePath;
        FileOutputStream fos = new FileOutputStream(filePath);
        fos.write(str.getBytes());
        fos.close();
    }

    // 将10位时间戳转换为日期时间文本。格式：yyyy/MM/dd HH:mm:ss，如 2013/11/04 20:28:28
    private static String dateParseUtil(Long dateLong) {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date(dateLong * 1000));

    }

    // ==Bean =========================================
    public static class ContentObj {
        private Long postTime;
        private String content;
        private String postTimeStr;



        public Long getPostTime() {
            return postTime;
        }

        public String getContent() {
            return content;
        }

        public String getPostTimeStr() {
            return postTimeStr;
        }

        public void setPostTime(Long postTime) {
            this.postTime = postTime;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setPostTimeStr(String postTimeStr) {
            this.postTimeStr = postTimeStr;
        }
    }
}
