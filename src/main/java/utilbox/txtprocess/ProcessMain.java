package utilbox.txtprocess;

import java.io.IOException;

/**
 * 处理器入口
 */
public class ProcessMain {
    public static void main(String[] args) throws IOException {
        qingTingJsonProcessor();
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
