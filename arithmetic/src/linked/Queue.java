package linked;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/4/25 4:13 下午
 */
public class Queue {

    private TwoHeadLinked linked = new TwoHeadLinked();

    private Queue () {

    }

    public int push(int a) {
        linked.push(a);
        return a;
    }

    public int pop() {
        LinkedNode node = linked.pop();
        return node.value;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.push(1);
        //queue.push(2);
        queue.pop();
        int a = 1;
    }

}
