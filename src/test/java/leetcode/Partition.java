package leetcode;



/**
 * 荷兰国旗问题：
 * 小于num的数在左边，大于num的数在右边，等于num的数在中间
 */
public class Partition {
    public static int[] partiotion(int[] array, int L, int R, int num){
        int less = L - 1;
        int more = R + 1;
        int cur = L;
        while (cur < more){
            if(array[cur] < num){
                swap(array, ++less, cur++);
            }else if(array[cur] > num){
                swap(array, --more, cur);
            }else {
                cur++;
            }
        }
        return new int[] {less + 1, more - 1};
    }
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {3,4,6,5,1,2,3,5};
        int num = 5;
        int[] res = partiotion(array,0,array.length-1,num);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
