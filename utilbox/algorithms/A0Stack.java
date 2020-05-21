package algorithms;

/**
 * @Desc 数据结构：栈的接口
 * @Author zh wu
 * @Date 2019/8/15 14:43
 */
public interface A0Stack<Item> extends Iterable<Item> {

    A0Stack push(Item item);

    Item pop();

    boolean isEmpty();

    int size();
}