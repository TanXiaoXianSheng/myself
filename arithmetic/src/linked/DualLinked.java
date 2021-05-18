package linked;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/4/25 3:27 下午
 */
public class DualLinked {

    public LinkedNode node = new LinkedNode();

    public LinkedNode firstNode = node;

    //初始化，第一个节点value为空,指向第一个存放数据的节点
    public DualLinked(int[] a) {
        for (int i = 0; i < a.length; i++) {
            LinkedNode linkedNode = new LinkedNode();
            linkedNode.value = a[i];
            linkedNode.front = node;
            node.next = linkedNode;
            node = linkedNode;
        }
    }

    public static void main(String[] args) {
        int a[] = {2, 6, 1, 3, 9, 8, 10, 11, 6, 4, 3};
        DualLinked dualLinked = new DualLinked(a);
        int b = 1;
    }

}
