package utilbox.txtprocess;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 轻听英语生词处理。
 * 提取单词、例句、中文翻译
 */
public class QingTingJsonProcessor implements ITxtProcessor {
    /**
     * 输入格式示例：
     * {pageList:[
     *      {"wordList"....}
     *      ,{"wordList"....}
     *      ,{"wordList"....}
     *      ,...
     *  ]}
     */

    /*@Override
    public String process(String jsonStr) {
        Txt txt = JSON.parseObject(jsonStr, Txt.class);
        List<QtPage> pages = txt.getPageList();

        // 遍历数组，提取时间和内容
        StringBuilder sb = new StringBuilder();
        pages.forEach(p -> {
            if (p == null || p.wordList == null || p.wordList.size() == 0) { return; }

            // 该页面的每个单词
            for (Word w : p.wordList) {
                sb.append(w.word + "\n");

                if (w.sentenceList == null || w.sentenceList.size() == 0) { continue; }
                for (Sentence st : w.sentenceList) {
                    sb.append(st.originalContext + "\n");
                    sb.append(st.translationContext + "\n");
                }

                sb.append("\n");
            }
        });

         return sb.toString();
    }*/

    // 改为用Arraylist，最后重新进行排序
    @Override
    public String process(String jsonStr) {
        Txt txt = JSON.parseObject(jsonStr, Txt.class);
        List<QtPage> pages = txt.getPageList();

        // 遍历数组，提取时间和内容
//        StringBuilder sb = new StringBuilder();
//        pages.forEach(p -> {
//            if (p == null || p.wordList == null || p.wordList.size() == 0) { return; }
//
//            // 该页面的每个单词
//            for (Word w : p.wordList) {
//                sb.append(w.word + "\n");
//
//                if (w.sentenceList == null || w.sentenceList.size() == 0) { continue; }
//                for (Sentence st : w.sentenceList) {
//                    sb.append(st.originalContext + "\n");
//                    sb.append(st.translationContext + "\n");
//                }
//
//                sb.append("\n");
//            }
//        });

        ArrayList<String> strings = new ArrayList<>(2000);
        pages.forEach(p -> {
            if (p == null || p.wordList == null || p.wordList.size() == 0) { return; }

            // 该页面的每个单词
            for (Word w : p.wordList) {
                String wordinfo = w.word + "\n" + "\n";                                 // 单词

                if (w.sentenceList == null || w.sentenceList.size() == 0) { continue; }
                for (Sentence st : w.sentenceList) {
                    wordinfo = wordinfo + st.originalContext + "\n";              // 英文例句
                    wordinfo = wordinfo + st.translationContext + "\n" + "\n" + "\n";   // 中文例句
                }

                strings.add(wordinfo);
            }
        });

        // 所有单词信息倒序排列
        StringBuilder sb = new StringBuilder();
        for (int i = strings.size() - 1; i >= 0; i--) {
            String wordinfo = strings.get(i);
            if (wordinfo == null || (wordinfo.equals(""))) {
                continue;
            }
            sb.append(wordinfo);
            sb.append("--------------------------------------------------");
            sb.append("\n");
            sb.append("\n");
        }

        return sb.toString();
    }

    // ===== Beans
    @Data
    private static class Txt {
        List<QtPage> pageList;
    }

    @Data
    private static class QtPage {
        List<Word> wordList;
    }

    @Data
    private static class Word {
        String word;                    // 单词
        List<Sentence> sentenceList;    // 例句
    }

    @Data
    private static class Sentence {
        String originalContext;     // 例句
        String translationContext;  // 例句翻译

    }
}
