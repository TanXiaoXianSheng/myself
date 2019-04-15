package train;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 没写出来
 * 给一个数组，一个栈，数组进栈和出栈可以穿插进行，输出所有出栈可能
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/4/4 11:03
 **/
public class _01 {

    private static class Node{
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        Node left;
        Node right;
    }

    public static void find(int[] a){
        if (a.length < 1){
            return;
        }
        Node firstNode = new Node();
        find(firstNode,a,0);
        int b = 1;
    }

    public static void find(Node node,int[] a,int i){
        if (i < a.length - 1){
            int nextIndex = i + 1;
            Node left = new Node();
            left.stack = (Stack<Integer>) node.stack.clone();
            left.stack.push(a[i]);
            left.list.addAll(node.list);

            node.left = left;
            find(node.left,a,nextIndex);

            Node right = new Node();
            right.stack = (Stack<Integer>) node.stack.clone();
            right.list = node.list;
            right.list.addAll(node.list);

            node.right = right;
            find(node.right,a,nextIndex);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0;i < n;i ++){
            a[i] = sc.nextInt();
        }
        find(a);
    }
}
