栈与队列

Deque（double ended queue双端队列）有三种用途：
- 普通队列(一端进另一端出):
`Queue queue = new LinkedList()或Deque deque = new LinkedList()`
- 双端队列(两端都可进出)
`Deque deque = new LinkedList()`
- 堆栈
`Deque deque = new LinkedList()`
注意：Java堆栈Stack类已经过时，Java官方推荐使用Deque替代Stack使用。

Deque堆栈操作方法：push()、pop()、peek()。

Deque队列操作方法：

| 抛出异常      | 返回特殊值    | 抛出异常     | 返回特殊值   |
| ------------- | ------------- | ------------ | ------------ |
| addFirst(e)   | offerFirst(e) | addLast(e)   | offerLast(e) |
| removeFirst() | pollFirst()   | removeLast() | pollLast()   |
| getFirst()    | peekFirst()   | getLast()    | peekLast()   |
