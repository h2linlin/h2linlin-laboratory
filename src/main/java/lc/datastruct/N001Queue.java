package lc.datastruct;

/**
 * @Desc 简单队列：数组实现
 * 方法：
 *  入队
 *  出队
 * @Author zh wu
 * @Date 2019/9/19
 */
public class N001Queue {
    private int length;     // 队列长度
    private Integer[] queue;    // 队列容器
    private int tailAddr;   // 队尾地址

    // 初始化
    public N001Queue(int length) {
        this.length = length;
        queue = new Integer[length];
        tailAddr = 0;
    }

    // 入队
    public boolean inQueue(int ele) {
        // 1.判断当前队列是否已满
        if (tailAddr > length - 1) {
            System.out.println("入队失败，队列已满");
            return false;
        }
        // 2.队尾入队
        queue[tailAddr] = ele;
        tailAddr++;
        return true;
    }

    // 出队
    public Integer outQueue() {
        // 1.判断当前队列是否为空
        if (tailAddr == 0) {
            System.out.println("队列为空");
            return null;
        }
        // 2.队头出队
        int result = queue[0];
        // 3.其余元素前移一位
        for (int i = 0; i < tailAddr - 1; i++) {
            queue[i] = queue[i + 1];
        }
        // 4.更新队尾
        tailAddr--;
        return result;
    }

    // 测试
    public static void main(String[] args) {
        // 准备数据
        int[] in = new int[20];
        for (int i = 0; i < 20; i++) {
            in[i] = i+1;
        }

        N001Queue queue = new N001Queue(16);
        // 入队
        int j = 0;
        while (queue.inQueue(in[j++])) {}

        // 出队
        for (int i = 0; i < 16; i++) {
            System.out.print(queue.outQueue() + ",");
        }
    }
}

