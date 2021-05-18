package linked;

import java.util.LinkedList;
import java.util.List;

/**
 * 单链表
 *
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/4/1 11:41
 **/
public class Linked {

    public LinkedNode node = new LinkedNode();

    public LinkedNode firstNode = node;

    //初始化，第一个节点value为空,指向第一个存放数据的节点
    public Linked(int[] a) {
        for (int i = 0; i < a.length; i++) {
            LinkedNode linkedNode = new LinkedNode();
            linkedNode.value = a[i];
            node.next = linkedNode;
            node = linkedNode;
        }
    }

    //链表翻转 方法一
    //参考博客：https://www.cnblogs.com/byrhuangqiang/p/4311336.html
    public void reversal() {
        LinkedNode flagNode = firstNode.next;
        LinkedNode targetNode = flagNode.next;
        while (flagNode.next != null) {
            flagNode.next = targetNode.next;
            targetNode.next = firstNode.next;
            firstNode.next = targetNode;
            targetNode = flagNode.next;
        }
        this.out();
    }

    //输出链表
    public List<Integer> out() {
        LinkedNode linkedNode = firstNode;
        List<Integer> list = new LinkedList<>();
        while (linkedNode.next != null) {
            linkedNode = linkedNode.next;
            list.add(linkedNode.value);
        }
        System.out.println(list);
        return list;
    }

    public static void main(String[] args) {
        int a[] = {2, 6, 1, 3, 9, 8, 10, 11, 6, 4, 3};
        Linked linked = new Linked(a);
        //System.out.println(linked.out());
        linked.reversal();
    }
}
