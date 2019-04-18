package offer66;
//从第一个依次求出所有的丑数，直到下标为index为止
public class GetUglyNumber {
    public static int test(int index) {
        if (index < 7) {
            return index;
        }
        int[] res = new int[index];
        int t2 = 0;
        int t3 = 0;
        int t5 = 0;
        res[0] = 1;
        for (int i = 1; i < index; i++) {
            res[i] = Math.min(res[t2] * 2, Math.min(res[t3] * 3, res[t5] * 5));
            if (res[i] == res[t2] * 2)
                t2++;
            if (res[i] == res[t3] * 3)
                t3++;
            if (res[i] == res[t5] * 5)
                t5++;
        }
        return res[index - 1];
    }

    public static void main(String[] args) {
        int result = GetUglyNumber.test(11);
        System.out.println(result);

    }

}

