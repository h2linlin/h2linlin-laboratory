package utilbox.txtprocess;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * QQ空间日志评论处理。
 * 提取评论日期、评论内容
 */
public class QQJournalJsonProcessor implements ITxtProcessor {

    // 文本转换为Json对象，提取需要的信息，并处理为需要的文本格式
    @Override
    public String process(String jsonStr) {
        // 转换为数组
        JSONArray jsonArray = JSON.parseArray(jsonStr);
        List<ContentObj> contentList = jsonArray.toJavaList(ContentObj.class);

        // 遍历数组，提取时间和内容
        StringBuilder sb = new StringBuilder();
        contentList.forEach(c -> {
            sb.append(dateParseUtil(c.getPostTime()) + "\t" + c.getContent() + "\n");
        });

        return sb.toString();
    }

    // 将10位时间戳转换为日期时间文本。格式：yyyy/MM/dd HH:mm:ss，如 2013/11/04 20:28:28
    private static String dateParseUtil(Long dateLong) {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date(dateLong * 1000));
    }

    // QQ空间评论Bean
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
