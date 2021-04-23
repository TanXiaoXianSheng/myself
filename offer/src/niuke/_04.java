package niuke;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/4/22 3:18 下午
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class _04 {

    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode list03 = null;
        list03 = merge(list1, list2, list03);
        return list03;
    }

    private ListNode merge(ListNode list01, ListNode list02, ListNode list03) {
        if (list01 == null && list02 == null) {
            return list03;
        }
        if (list01 == null) {
            if (list03 == null) {
                list03 = list02;
            } else {
                ListNode temp = list03;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = list02;
            }
            return list03;
        }
        if (list02 == null) {
            if (list03 == null) {
                list03 = list01;
            } else {
                ListNode temp = list03;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = list01;
            }
            return list03;
        }

        while(list01 != null && list02 != null && list01.val <= list02.val) {
            int val = list01.val;
            list03 = add(list03, val);;
            list01 = list01.next;
        }

        while(list01 != null && list02 != null && list02.val <= list01.val) {
            int val = list02.val;
            list03 = add(list03, val);
            list02 = list02.next;
        }

        return merge(list01, list02, list03);

    }

    private ListNode add(ListNode list, int val) {
        if (list == null) {
            list = new ListNode(val);
        } else {
            ListNode temp = list;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(val);
        }

        return list;
    }


    public static void main(String[] args) {
        ListNode list01 = new ListNode(1);
        list01.next = new ListNode(3);
        list01.next.next = new ListNode(5);

        ListNode list02 = new ListNode(2);
        list02.next = new ListNode(4);
        list02.next.next = new ListNode(6);

        _04 obj = new _04();
        ListNode list03 = obj.Merge(list01, list02);
        int a = 1;
    }

}
