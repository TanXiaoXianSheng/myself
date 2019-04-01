import java.util.ArrayList;

/**
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/3/25 16:21
 **/
public class _03 {

    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null){
            return list;
        }
        printListFromTailToHead(listNode.next);
        list.add(listNode.val);
        return list;
    }
}
