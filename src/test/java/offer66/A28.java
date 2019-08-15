package offer66;

/**
 * 数组中出现次数操作一半的数字
 * //数组中有一个数字出现的次数超过数组长度的一半，说明该数字出现的次数比其它所有数字出现次数的
 * //和还要多。因此，在遍历数组时保存两个值：一个是数组中的数字，一个是该数字出现的次数；
 * //当遍历到下一个数字时，如果数字和我们保存的数字值相同，数字出现次数+1；如果不同，保存数字次数-1；
 * //如果保存的数字次数为0，替换保存数字为最新遍历的数组中的数字。
 */
public class A28 {

    public static int solution(int [] numbers) {
        int len = numbers.length;
        if(len == 0)
            return 0;
        int num = numbers[0];
        int count = 1;
        for(int i=1;i<len;i++){
            if(numbers[i]==num){
                count++;
            }else
                count--;
            if(count == 0){
                num = numbers[i];
                count = 1;
            }
        }
        //验证
        count = 0;
        for(int i=0;i<len;i++){
            if(numbers[i] == num)
                count++;
        }
        if(count*2 > len){
            return num;
        }else
            return 0;
    }
    public static void main(String[] args) {
        int[] numbers = {2,3,2,7,3,2,2,3,2,2};
        System.out.println(solution(numbers));
    }
}
