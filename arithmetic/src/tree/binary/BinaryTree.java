package tree.binary;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/4/1 15:56
 **/
public class BinaryTree {

    public BinaryNode rootNode = new BinaryNode();

    public int depth;

    public BinaryTree(int[] a){
        depth = (int) (Math.log(a.length)/ Math.log(2)) + 1;
        this.rootNode = this.init(a,0,depth);
    }

    public BinaryNode init(int[] a,int i,int high){
        if (i >= a.length){
            return null;
        }
        BinaryNode node = new BinaryNode();
        if (2 * i + 1 < a.length){
            node.left = this.init(a,2 * i + 1,high);
        }
        if (2 * i + 2 < a.length){
            node.right = this.init(a,2 * i + 2,high);
        }
        node.value = a[i];
        return node;
    }

    //先序遍历 （根左右）
    public List<Integer> preorderTraversal(){
        List<Integer> list = new LinkedList<>();
        BinaryNode first = rootNode;
        this.preorderTraversal(first,list);
        return list;
    }

    private void preorderTraversal(BinaryNode node,List<Integer> list){
        list.add(node.value);
        if (node.left != null){
            preorderTraversal(node.left,list);
        }
        if (node.right != null){
            preorderTraversal(node.right,list);
        }
    }

    //中序遍历 (左根右)
    public List<Integer> inorderTraversal(){
        List<Integer> list = new LinkedList<>();
        BinaryNode node = rootNode;
        inorderTraversal(node,list);
        return list;
    }

    private void inorderTraversal(BinaryNode node,List<Integer> list){
        if (node.left != null)
            inorderTraversal(node.left,list);
        list.add(node.value);
        if (node.right != null)
            inorderTraversal(node.right,list);
    }

    //后续遍历 (左右根)
    public List<Integer> postorderTraversal(){
        List<Integer> list = new LinkedList<>();
        BinaryNode node = rootNode;
        postorderTraversal(node,list);
        return list;
    }

    private void postorderTraversal(BinaryNode node,List<Integer> list){
        if (node.left != null)
            postorderTraversal(node.left,list);
        if (node.right != null)
            postorderTraversal(node.right,list);
        list.add(node.value);
    }

    //逐层遍历
    public List<Integer> layerTraversal(){
        List<Integer> list = new LinkedList<>();
        BinaryNode node = rootNode;
        layerTraversal(node,list);
        return list;
    }

    private void layerTraversal(BinaryNode node,List<Integer> list){
        for (int i = 0;i < depth;i ++){
            layerTraversal(node,i,list);
        }
    }

    private void layerTraversal(BinaryNode node,int level,List<Integer> list){
        if (node == null || level < 0)
            return;
        if (level == 0) {
            list.add(node.value);
        }
        if (level > 0){
            if (node.left != null)
                layerTraversal(node.left,level - 1,list);
            if (node.right != null)
                layerTraversal(node.right,level - 1,list);
        }
    }

    //二叉树反转
    public void reversal(){
        BinaryNode node = rootNode;
        if (node != null)
            reversal(node);
        //测试，输出先序遍历
        List<Integer> list = new LinkedList<>();
        this.preorderTraversal(node,list);
        System.out.println("二叉树反转（先序输出）:" + list);
    }

    private void reversal(BinaryNode node){
        if (node.left != null)
            reversal(node.left);
        if (node.right != null)
            reversal(node.right);
        reversalNode(node);
        return;
    }

    //根据节点，反转子节点
    private void reversalNode(BinaryNode node){
        if (node == null || (node.left == null && node.right == null))
            return;
        if (node.left == null){
            node.left = node.right;
        }
        if (node.right == null){
            node.right = node.left;
        }
        if (node.left != null && node.right != null){
            BinaryNode middle = node.left;
            node.left = node.right;
            node.right = middle;
        }
    }

    //深度有限

    //广度优先

    public static void main(String[] args){
        int a[] = {2,6,1,3,9,8,10,11,6,4,2};
        BinaryTree binaryTree = new BinaryTree(a);
        System.out.println("先序遍历:" + binaryTree.preorderTraversal());
        System.out.println("中序遍历:" + binaryTree.inorderTraversal());
        System.out.println("后序遍历:" + binaryTree.postorderTraversal());
        System.out.println("逐层遍历:" + binaryTree.layerTraversal());
        binaryTree.reversal();
    }
}
