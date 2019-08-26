package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 根据身高重建队列
 * //先按照身高降序排序，按照个数进行升序排序
 * //插入操作，将整数对放到对应的k位置
 */
public class ReconstructQueue {
    public static int[][] reconstructQueue(int[][] people) {
        if(people == null)
            return null;
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] < o2[0])
                    return 1;
                else if(o1[0] > o2[0])
                    return -1;
                else
                    return 0;
            }
        });

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            list.add(people[i][1],people[i]);
        }
//        for (int[] ints : list) {
//            System.out.println(ints[0] +":"+ ints[1]);
//        }

        return list.toArray(new int[list.size()][]);
    }
    public static void main(String[] args) {
        int[][] array = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] results =  reconstructQueue(array);
        for (int[] result : results) {
            System.out.println(result[0] +":"+ result[1]);
        }
    }
}
