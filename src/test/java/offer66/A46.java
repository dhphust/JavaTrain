package offer66;

/**
 * 圆圈中最后剩下的数
 */
public class A46 {

    public static int findLastNumber(int n,int m){
        if(n<1||m<1) return -1;
        int[] array = new int[n];//标记淘汰的元素，-1
        int i = -1;
        int step = 0;//标记步数
        int count = n;//记录当前还剩多少未被淘汰的元素
        while(count>0){
            i++;          //指向上一个被删除对象的下一个元素。
            if(i>=n) i=0;  //模拟环
            if(array[i] == -1) continue; //跳过被淘汰的对象。
            step++;                     //记录走过的步数
            if(step==m) {               //找到待删除的元素
                array[i]=-1;
                step = 0;
                count--;
            }
        }
        return i;//返回下标（从0开始）
    }

    public static void main(String[] args) {
        System.out.println(findLastNumber(8,3));
    }
}
