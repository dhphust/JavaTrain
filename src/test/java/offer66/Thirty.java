package offer66;
//遍历数组，累加各元素，如果累加值<0,放弃之前的子数组，新数组从当前值（导致累加<0）的下一位开始；
//定义变量sum记录最大值，tempsum记录当前累加值
public class Thirty {
    public static int FindGreatestSumOfSubArray(int[] array) {
        if(array.length<0)
            return 0;
        int sum = array[0];
        int tempsum = array[0];
        for (int i = 0; i < array.length; i++) {
            if(tempsum <= 0){
                tempsum = array[i];
            }else {
                tempsum += array[i];
            }
            if(sum < tempsum){
                sum = tempsum;
            }

        }
        return sum;

    }

    public static void main(String[] args) {
        int[] array = {1,-2,3,10,-4,7,2,-5};
        int result = FindGreatestSumOfSubArray(array);
        System.out.println(result);

    }
}
