package generalAlgorithm;

/**
 * 选择排序
 * 定义：选择最小的元素与未排序的部分的首部交换，使得序列的前半部分有序
 * 具体做法：
 * 从第二个元素开始，依次与队首元素比较，小于队首元素后替换，保证依次遍历后队首
 * 元素最小；之后以此类推，从第三个元素开始，分别与第二个元素比较后替换。。。。
 */
public class SelectSort {

    public static void selectSort(int[] array) {
        if (array == null || array.length < 2)
            return;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) { //每次与队首元素比较
                    swap(array, i, j);
                }
            }
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {3, 5, 2, 4, 2, -3, 23, 5, 7};
        selectSort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}