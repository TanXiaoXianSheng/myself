package linked;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/4/25 4:12 下午
 */
public class TwoHeadLinked {

    private LinkedNode node = new LinkedNode();

    public LinkedNode firstNode = node;

    public LinkedNode endNode = node;

    public TwoHeadLinked() {

    }

    //初始化，第一个节点value为空,指向第一个存放数据的节点
    public TwoHeadLinked(int[] a) {
        for (int i = 0; i < a.length; i++) {
            LinkedNode linkedNode = new LinkedNode();
            linkedNode.value = a[i];
            linkedNode.front = node;
            node.next = linkedNode;
            node = linkedNode;
        }
        endNode = node;
    }

    public LinkedNode pushFirst(int a) {
        LinkedNode temp = firstNode.next;
        LinkedNode newNode = new LinkedNode(a);
        newNode.next = temp;
        newNode.front = firstNode;
        firstNode.next = newNode;
        return newNode;
    }

    public LinkedNode push(int a) {
        LinkedNode newNode = new LinkedNode(a);
        newNode.front = endNode;
        endNode.next = newNode;
        endNode = newNode;
        return newNode;
    }

    public LinkedNode pop() {
        LinkedNode first = firstNode.next;
        LinkedNode second = first.next;
        firstNode.next = second;
        second.front = firstNode;
        first.next = null;
        first.front = null;
        return first;
    }

    public LinkedNode popEnd() {
        LinkedNode temp = endNode;
        LinkedNode second = endNode.front;
        second.next = null;
        endNode = second;
        temp.front = null;
        return temp;
    }

    public static void main(String[] args) {
        //int arr[] = {2, 6, 1, 3, 9, 8, 10, 11, 6, 4, 3};
        int arr[] = {2};
        TwoHeadLinked dualLinked = new TwoHeadLinked(arr);
        int b = 1;
    }

}
