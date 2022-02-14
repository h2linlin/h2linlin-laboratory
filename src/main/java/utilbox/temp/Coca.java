package utilbox.temp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

//import org.apache.commons.lang3.StringUtils;

/**
 * 词频覆盖率计算
 * @Author h2linlin
 */
public class Coca {
//    public static void main(String[] args) {
//        Map<String, String> cocaMap = readFileMapByLines("D:\\COCA20000.txt");
//        Map<String, String> testMap = readFileMapByLines("D:\\tuofu.txt");// Tofit 84%, kaoyan 96%, cet6 95%
//        testRate(cocaMap, testMap, "testMap");
//    }
//
//    // 所占比例
//    public static void testRate(Map<String, String> cocaMap, Map<String, String> testMap, String testName) {
//        System.out.println("===============");
//        System.out.println("coca size: " + cocaMap.size());
//        System.out.println(testName + " size: " + testMap.size());
//
//        int getIt = 0;  // 命中数量
//        for (String word : testMap.keySet()) {
//            if (cocaMap.get(word) != null) {
//                getIt ++;
//            }
//        }
//        System.out.println(
//                testName + "/total = "
//                + getIt + "/" + testMap.size() + " = "
//                + ((getIt+0.0)/testMap.size())*100 + "%"
//        );
//    }
//
//    /**
//     * 以行为单位读取文件，常用于读面向行的格式化文件
//     */
//    public static Map<String, String> readFileMapByLines(String fileName) {
//        File file = new File(fileName);
//        BufferedReader reader = null;
//        Map<String, String> map = new HashMap<>();
//        int line = 1;
//
//        try {
////            System.out.println("以行为单位读取文件内容，一次读一整行：");
//            reader = new BufferedReader(new FileReader(file));
//
//            String tempString = null;
//            // 一次读入一行，直到读入null为文件结束
//            while ((tempString = reader.readLine()) != null) {
//                // 显示行号
//                tempString = StringUtils.lowerCase(tempString);
//                map.put(tempString, tempString);
////                System.out.println("line " + line + ": " + tempString);
//                line ++;
//            }
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e1) {
//                }
//            }
//        }
//        System.out.println("---------------" + fileName + " origin lines: " + line);
//        return map;
//    }
//
//    /**
//     * 以行为单位读取文件，常用于读面向行的格式化文件
//     */
//    public static void readFileByLines(String fileName) {
//        File file = new File(fileName);
//        BufferedReader reader = null;
//        try {
//            System.out.println("以行为单位读取文件内容，一次读一整行：");
//            reader = new BufferedReader(new FileReader(file));
//            String tempString = null;
//            int line = 1;
//            // 一次读入一行，直到读入null为文件结束
//            while ((tempString = reader.readLine()) != null) {
//                // 显示行号
//                System.out.println("line " + line + ": " + tempString);
//                line++;
//            }
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e1) {
//                }
//            }
//        }
//    }
}
