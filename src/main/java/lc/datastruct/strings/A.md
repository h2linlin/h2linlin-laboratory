### 字符串
字符串也是一种特别的数据。区别在于字符串的基本操作对象通常是**字符串整体或者其子串**。
字符串的主要操作有两种：
- 比较：Java不能用“==”比较。
- 连接：Java中的String是不可变的。所以修改字符串就是生成新的字符串，效率不高。建议用以下措施优化：
    - 如果你确实希望你的字符串是可变的，则可以使用 toCharArray 将其转换为字符数组。
    - 如果你经常必须连接字符串，使用StringBuilder等来替换。
    
技巧：
- 使用flag移动代替StringBuilder不断创建新字符串，使程序简洁。
    
- StringBuilder删除所有元素：sb.delete(0, sb.length());
- 下标参考："123456".substring(0, 3) = "123";

位运算：快速交换两个数的值，可以连续异或两次即可。
continue不要老是忘。

双指针：降低时间复杂度的神器，能降低一个N^2。

三次翻转：字符串处理时比较好用的技巧。要经常学会倒着思考。

StringBuffer和StringBuilder区别：
- StringBuffer：速度慢，线程安全
- StringBuilder：速度快，线程不安全

新建字符串，注意最后一个参数是长度，而不是结束标记位
String s = new String(char[] chars, int startIndex, int length);
