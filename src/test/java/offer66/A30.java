package offer66;

/**
 * 连续子数组的最大和
 */
public class A30 {

    public static int FindGreatestSumOfSubArray(int[] array) {
        if(array.length<0)
            return 0;
        int sum = array[0];
        int tempsum = array[0];
        int begin = 0;
        int end = 0;
        int count = 0;
        for(int i =1 ;i<array.length;i++){
            if(tempsum<=0){
                tempsum = array[i];
                count = 0;
            }else {
                tempsum += array[i];
                count++;
            }
            if(sum<tempsum){
                end = i;  //结束为止
                begin = end - count;//起始位置
                sum = tempsum;
            }

        }
        System.out.println("最小值范围：" + begin +":"+ end);
        return sum;
    }
    public static void main(String[] args) {
        int[] array = {2,-3,-2,-7,2,-1,2,2};
        System.out.println(FindGreatestSumOfSubArray(array));
    }
}
