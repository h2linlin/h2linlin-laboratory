package lc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * @Desc 模板
 * @Author wuzh
 * @Date 2020/12/4
 */
public class Solution {
    public static void main(String[] args) {

        solve();

        printResult();
    }

    private static void printResult() {

    }

    private static void solve() {
        System.out.println("adsb".equals("adsb") && !("ZGSZ".equals("aZGSZ")));
        System.out.println("adsb".equals("adsb") && !"ZGSZ".equals("ZaGSZ"));
//        System.out.println(takeAliveTime("2021-01-29T07:34:50.9921875"));// 2021-01-29T02:22:40.203125
    }

    private static Long takeAliveTime(String dateStr){
        try {
            System.out.println("***************datestr before: " + dateStr);
            dateStr = dateStr.substring(0, 19); // 处理第三方日期格式“2021-01-29T02:22:40.203125”，后三位不一定有
            System.out.println("***************datestr after: " + dateStr);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

            System.out.println(sdf.parse(dateStr));

            return System.currentTimeMillis() - sdf.parse(dateStr).getTime();
        } catch (ParseException e) {
            throw new RuntimeException("^^^^^^^^^^ 日期转换失败。DateStr: " + dateStr);
        }
    }
}
