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

| 执行异常| 抛出异常       | 入false/出null | 抛出异常      | 入false/出null|
|  ------ | ------------- | ------------- | ------------ | ------------ |
| 入队    | addFirst(e)   | offerFirst(e) | addLast(e)   | offerLast(e) |
| 出队    | removeFirst() | pollFirst()   | removeLast() | pollLast()   |
| 取值    | getFirst()    | peekFirst()   | getLast()    | peekLast()   |

offer:提供
poll: pull?
peek：偷看

**作为双端队列使用**，后面跟First或Last：
- 返回boolean的出入队：offer/poll
- 返回boolean的查看：  peek。注意：dequeue为空时，dequeue.peek()会抛空指针错误！这里不准确。源代码里不会报错，但是实际操作下来报错了！
- 返回异常的出入队：add/remove
- 返回异常的查看：  get

**作为栈使用**：push()、pop()、peek()。

char类型的比较：可以直接用 == 比较，包装类也一样。注意用单引号：if (st.peek() == 'a') {}