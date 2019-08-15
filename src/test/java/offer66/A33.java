package offer66;

/**
 * 丑数
 * 一个丑数的因子只有2,3,5，一个丑数一定由另一个丑数乘以2或者乘以3或者乘以5得到，
 * 那么我们从1开始乘以2,3,5，就得到2,3,5三个丑数，
 * 在从这三个丑数出发乘以2,3,5就得到4，6,10,6，9,15,10,15,25九个丑数，
 * 我们发现这种方法会得到重复的丑数，而且我们题目要求第N个丑数，这样的方法得到的丑数也是无序的。
 * 那么我们可以维护三个队列：
 * https://www.nowcoder.com/profile/9521762/codeBookDetail?submissionId=18795793
 */
public class A33 {

    public static int GetUglyNumber_Solution(int index) {
        if (index < 7){
            return index;
        }
        int[] res = new int[index];
        res[0] = 1;
        int t2 = 0;
        int t3 = 0;
        int t5 = 0;
        for(int i=1;i<index;i++){
            res[i] = Math.min(res[t2]*2, Math.min(res[t3]*3, res[t5]*5));
            if(res[i] == res[t2] * 2)
                t2++;
            if(res[i] == res[t3] * 3)
                t3++;
            if(res[i] == res[t5] * 5)
                t5++;
        }
        return res[index-1];
    }

    public static void main(String[] args) {
        int result = GetUglyNumber_Solution(11);
        System.out.println(result);
    }
}
