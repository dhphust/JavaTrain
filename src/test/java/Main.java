import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static java.util.Arrays.sort;

//public class Main {
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        while (input.hasNext()){
//            String ip1 = input.nextLine();
//            String ip2 = input.nextLine();
//            String mask = input.nextLine();
//            if(ip1 == null || ip1.length() == 0 || ip2 == null || ip2.length() == 0 || mask == null || mask.length() == 0){
//                System.out.println(1);
//                break;
//            }
//            boolean flag = false;
//            //取数字
//            String sip1[] = ip1.split("\\.");
//            String sip2[] = ip2.split("\\.");
//            String smask[] = mask.split("\\.");
//            StringBuilder result = new StringBuilder();
//            //判断越界
//            for (int i = 0; i < sip1.length; i++) {
//                if(Integer.valueOf(sip1[i]) < 0 || Integer.valueOf(sip1[i]) > 255 || Integer.valueOf(sip2[i]) < 0 || Integer.valueOf(sip2[i]) > 255
//                        || Integer.valueOf(smask[i]) < 0 || Integer.valueOf(smask[i]) > 255){
//                    System.out.println(1);
//                    break;
//                }
//            }
//
//            //按位与运算
//            for (int i = 0; i < sip1.length; i++) {
//                Integer result1 = Integer.valueOf(sip1[i]) & Integer.valueOf(smask[i]);
//                Integer result2 = Integer.valueOf(sip2[i]) & Integer.valueOf(smask[i]);
//                if(result1 == result2){
//                    flag = true;
//                }
//                else {
//
//                    flag = false;
//                    break;
//                }
//            }
//            for (int i = 0; i < sip1.length; i++) {
//                Integer result1 = Integer.valueOf(sip1[i]) & Integer.valueOf(smask[i]);
//                result.append(result1).append(".");
//            }
//
//            if(flag){
//                System.out.println(0 + " " + result.substring(0,result.length()-1));
//                break;
//            }else {
//                System.out.println(1 + " " + result.substring(0,result.length()-1));
//                break;
//            }
//        }
//
//    }
//}

//求最大正方形面积转化为求最大边长
//定义一个初始化最大边长maxLength=0
//对每个值=1的点进行遍历
//判断它能否作为最小正方形矩阵右上顶点
//public class Main {
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int N = input.nextInt();//输入行数
//        int M = input.nextInt();//输入列数
//        int[][] array = new int[N][];
//        //输入矩阵
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                array[i][j] = input.nextInt();
//            }
//        }
//        int maxLength = 0; //定义最大边长
//        for (int i = 1; i < N; i++) {
//            for (int j = 1; j < M; j++) {
//                if (array[i][j] == 1){
//                    //以array[i][j]为定点求右上最小正方形
//                    int temp = minValue(array[i][j-1],array[i-1][j],array[i-1][j-1]);
//                    if(temp != 0){
//                        array[i][j] = temp + 1;
//                        if(array[i][j] > maxLength)//判断右上顶点值>当前最大边长
//                            maxLength = array[i][j];
//                    }
//                }
//
//            }
//        }
//
//    }
//
//    //取三个整数的最小值
//    private static int minValue(int i, int i1, int i2) {
//        i = i < i1 ? i : i1;
//        i = i < i2 ? i : i2;
//        return i;
//    }
//}


public class Main {
    public static void main(String[] args) {

        String classFile = "com.jd.". replaceAll(".", "/") + "MyClass.class";
        System.out.println(classFile);
        ReentrantReadWriteLock
    }
}







































