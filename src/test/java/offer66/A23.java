package offer66;

/**
 * 二叉搜索树的后序遍历序列
 * 任意节点x，其左子树中的key不大于x.key，其右子树中的key不小于x.key。
 * BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （也就是根），如果去掉最后一个元素的序列为T，
 * 那么T满足：T可以分成两段，前一段（左子树）小于x，后一段（右子树）大于x，且这两段（子树）都是合法的后序序列。
 */
public class A23 {
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0) return false;
        return IsTreeBST(sequence, 0, sequence.length-1);
    }
    public static boolean IsTreeBST(int [] sequence,int start,int end ){
        if(end <= start) return true;
        int i = start;
        for (; i < end; i++) {//如果前半段大于end，看后半段情况
            if(sequence[i] > sequence[end]) break;
        }
        for (int j = i; j < end; j++) {//如果后半段小于end，整体不是合法序列
            if(sequence[j] < sequence[end]) return false;
        }
        return IsTreeBST(sequence, start, i-1) && IsTreeBST(sequence, i, end-1);
    }


    public static void main(String[] args) {
        int[] input = {8,14,10,10,16,25,20,15};
        System.out.println(VerifySquenceOfBST(input));
    }
}
