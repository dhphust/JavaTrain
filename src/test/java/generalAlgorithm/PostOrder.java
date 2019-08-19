package generalAlgorithm;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Stack;

/**
 * 后序遍历
 */
public class PostOrder {

    public static List<TreeNode> postOrder(TreeNode root){
        if(root == null)
            return null;
        List<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        TreeNode preNode = null; //记录之前遍历的右节点
        while(curNode != null || !stack.isEmpty()){
            while(curNode != null) { //左子树一直入栈
                stack.push(curNode);
                curNode = curNode.left;
            }
            curNode = stack.peek();//获取栈顶元素
            //如果右节点为空，或者右节点之前遍历过，打印根节点
            if(curNode.right == null || curNode.right == preNode){
                list.add(curNode);
                curNode = stack.pop();
                preNode = curNode;
                curNode = null;
            }
            else {
                curNode = curNode.right;
            }
        }
        return list;
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public static TreeNode initTreeNode(int[] array){
        return createBinaryTreeByArray(array,0);
    }

    public static TreeNode createBinaryTreeByArray(int[] array,int index){
        TreeNode tn = null;
        if(index < array.length && array[index] != 0){
            tn = new TreeNode(array[index]);
            tn.left = createBinaryTreeByArray(array, 2 * index + 1);
            tn.right = createBinaryTreeByArray(array, 2 * index + 2);
            return tn;
        }
        return tn;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        TreeNode root = initTreeNode(array);
        List<TreeNode> result = postOrder(root);
        for (TreeNode node : result) {
            System.out.print(node.val);
        }
    }
}
