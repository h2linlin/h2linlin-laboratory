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

string -> char[]：如果String不熟悉，可以转换为Array来执行
```java
    str.toCharArray();
```

char -> string：新建字符串，注意最后一个参数是长度，而不是结束标记位
String s = new String(char[] chars, int startIndex, int length);
// 或
String s = String(char value[]);

分割子字符串，endIndex下标是不包括的：
```java
System.out.println("abc".substring(1,2));   // 返回下标 start 到 (end -1)。结果：b
```

拼接字符串：
```java

String.join(".", sunIpList)
// [192,14,11,11] -> 192.14.11.11
```

字符串List排序：
- list的对象实现Comparable<>接口
- 直接用匿名排序来排：
  - Collections.sort(list, new Comparator<User>() { public int compare(User u1, User u2) {}});

Comparator接口可以实现自定义排序，实现Comparator接口时，要重写compare方法：

int compare(Object o1, Object o2) 返回一个基本类型的整型

- **如果按升序排序：此时如果 o1 小于 o2，应该返回-1（负数）**。相等返回0，o1大于o2返回1（正数）

- **如果按降序排序：此时如果 o1 小于 o2，应该返回1（正数）**，相等返回0，01大于02返回-1（负数）

```java
// list进行排序的几种方式

// 1、先来个简单的，上代码

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class sort {
　　public static void main(String[] args) {
　　List<Integer> list = new ArrayList<Integer>();
　　list.add(new Integer(5));
　　list.add(new Integer(13));
　　list.add(new Integer(4));
　　list.add(new Integer(9));
　　Collections.sort(list);
　　System.out.println(list.toString());
　　}
}

// 程序运行结果：

// [4, 5, 9, 13]，这种简单的排序直接按照自然顺序进行升序排列。

// 2、list参数类型相对复杂的排序

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class sort {
　　public static void main(String[] args) {
　　List<User> list = new ArrayList<User>();
　　list.add(new User("张三", 5));
　　list.add(new User("李四", 30));
　　list.add(new User("王五", 19));
　　list.add(new User("陈十七", 17)); // 陈十七永远十七岁
　　Collections.sort(list); // 按年龄排序
　　System.out.println(list.toString());
　　}
}


class User implements Comparable<User>{

　　private String name; //姓名

　　private int age; // 年龄


　　public User(String name, int age) {
　　　　this.name = name;
　　　　this.age = age;
　　}

　　// getter && setter
　　public String getName() {
　　　　return name;
　　}
　　public void setName(String name) {
　　　　this.name = name;
　　}
　　public int getAge() {
　　　　return age;
　　}
　　public void setAge(int age) {
　　this.age = age;
　　}
　　@Override
　　public String toString() {
　　　　return "User [name=" + name + ", age=" + age + "]";
　　}

　　@Override
　　public int compareTo(User user) {           //重写Comparable接口的compareTo方法，
　　　　return this.age - user.getAge();　　// 根据年龄升序排列，降序修改相减顺序即可
　　}
}

// 程序运行结果：根据年龄升序排列

// [User [name=张三, age=5], User [name=陈十七, age=17], User [name=王五, age=19], User [name=李四, age=30]]

3、匿名内部类实现排序

public class sort {
　　public static void main(String[] args) {
　　List<User> list = new ArrayList<User>();
　　list.add(new User("张三", 5));
　　list.add(new User("李四", 30));
　　list.add(new User("王五", 19));
　　list.add(new User("陈十七", 17)); // 陈十七永远十七岁
　　Collections.sort(list, new Comparator<User>() {
　　　　@Override
　　　　public int compare(User u1, User u2) {
　　　　　　int diff = u1.getAge() - u2.getAge();
　　　　　　if (diff > 0) {
　　　　　　　　return 1;
　　　　　　}else if (diff < 0) {
　　　　　　　　return -1;
　　　　　　}
　　　　　　return 0; //相等为0
　　　　}
　　}); // 按年龄排序
　　System.out.println(list.toString());
　　}
}

// 运行结果：[User [name=张三, age=5], User [name=陈十七, age=17], User [name=王五, age=19], User [name=李四, age=30]]

```



