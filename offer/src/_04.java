import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/3/25 17:13
 **/
public class _04 {

    /**
     * 先序遍历第一个值，找到中序遍历对应的下标，分成两半，找到再先序遍历中对应的下标，然后递归此方法
     * 把第一个设置为根节点
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre,int[] in) {
        TreeNode treeNode = null;
        if (pre == null || in == null){
            return null;
        }
        int first = pre[0];
        Map<Integer,Integer> inMap = new HashMap<>();
        int index = 0;
        for (int i : in){
            inMap.put(i,index ++);
        }
        int rootIndex = inMap.get(first);
        preIn(pre,0,pre.length - 1,in,0,in.length - 1,inMap);
       return treeNode;
    }

    public TreeNode preIn(int[] pre,int pi,int pj,
                          int[] in,int ii,int ij,
                          Map<Integer,Integer> map){
        if (pi >= pj){
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[pi]);
        int index = map.get(pre[pi]);
        treeNode.left = preIn(pre,pi + 1,pi + index,in,ii,index - 1,map);
        treeNode.right = preIn(pre,pi + index + 1,pj,in,index + 1,ij,map);
        return treeNode;
    }



    public static void main(String[] args){
        //int[] pre = [];
    }
}
