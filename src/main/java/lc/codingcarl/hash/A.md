哈希表
但凡是需要找某个东西的题目，第一时间要想到哈希表。
双指针就是用来降时间复杂度的，能够降低一个级别。

HashSet的常用Api：
```java
        "ss".length();
        "ss".charAt(0);
        "ss".toCharArray();

        HashSet<Integer> set =  new HashSet<Integer>();
        set.contains(12);
        set.toArray();
        set.add(11);

        for (int x : set) {
        System.out.println(x);
        }

        HashMap map = new HashMap();
        map.containsKey("");
        map.get("objKey");
        map.put("objKey", "value");

        // 排序
        Arrays.sort(new int[12]);
```