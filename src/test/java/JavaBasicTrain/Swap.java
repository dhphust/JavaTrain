package JavaBasicTrain;

/**
 * 传值与传引用
 * （1）基本数据类型传值，对形参的修改不会影响实参；
 * （2）引用类型传引用，形参和实参指向同一个内存地址（同一个对象），所以对参数的修改会影响到实际的对象；
 * （3）String, Integer, Double等immutable的类型特殊处理，可以理解为传值，最后的操作不会修改实参对象。
 */
public class Swap {

    public static void swap(String str1, String str2){
        String temp = str1;
        str1 = str2;
        str2 = temp;
    }

    public static void swap1(String[] strs){
        String temp = strs[0];
        strs[0] = strs[1];
        strs[1] = temp;
    }

    public static void swap2(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }

    public static void swap3(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "def";
        swap(str1,str2);
        System.out.println(str1 +"-"+ str2);

        String[] strs = new String[2];
        strs[0] = "abc";
        strs[1] = "def";
        swap1(strs);
        System.out.println(strs[0] +"-"+ strs[1]);

        int a = 3;
        int b = 4;
        swap2(a,b);
        System.out.println(a + "-" + b);

        int[] nums = new int[2];
        nums[0] = 1;
        nums[1] = 2;
        swap3(nums,0,1);
        System.out.println(nums[0] + "-" + nums[1]);
    }
}
