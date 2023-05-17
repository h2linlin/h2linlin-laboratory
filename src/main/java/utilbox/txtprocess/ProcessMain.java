package utilbox.txtprocess;

import java.io.IOException;

/**
 * 处理器入口
 */
public class ProcessMain {
    public static void main(String[] args) throws IOException {
//        qingTingJsonProcessor();

        String wordEx = "0:set/1:i/s:settings";
        // 提取原型。原型处于 0: 和 / 之间
        String w1 = wordEx.split("0:")[1];
        if (w1 != null && w1 != "") { w1 = w1.split("/")[0];}
        System.out.println(w1);
    }

    // QQ空间日志评论内容处理
    public static void qqJournalJsonProcessor() throws IOException {
        TxtProcessUtil.IPO("D:\\test-in.txt", "D:\\test-out.txt", new QQJournalJsonProcessor());
    }

    // 轻听英语生词例句提取
    public static void qingTingJsonProcessor() throws IOException {
        TxtProcessUtil.IPO("D:\\test-in.txt", "D:\\test-out.txt", new QingTingJsonProcessor());
    }


}
