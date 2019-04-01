package linked;

/**
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/4/1 11:40
 **/
public class LinkedNode {

    public int value;

    public LinkedNode next;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }
}
