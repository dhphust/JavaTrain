package generalAlgorithm;
//堆排序:首先确定初始堆，即保证根元素大于左右子树的元素值
//根顶最大值与根底元素交换，输出新的根底，重新确定根顶最大值元素
public class HeapSort {

    public static void heapSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            heapInsert(array,i);
        }
        //根顶最大值与根底元素交换
        int size = array.length;
        swap(array, 0, --size);
        while (size > 0) {
            heapify(array, 0, size);
            swap(array, 0, --size);
        }

    }

    //新的根顶元素与左右子树比较，确定新的根顶最大值元素
    private static void heapify(int[] array, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int right = left + 1;
            int largest = right < size && array[right] > array[left] ? right : left;//确定左右子树中的最大值
            largest = array[largest] > array[index] ? largest : index;  //左右子树中的最大值与父节点比较
            if (largest == index) {
                break;
            }
            swap(array, largest, index);
            //下一层继续比较
            index = largest;
            left = index * 2 + 1;
        }

    }

    //建立初始大根堆，保证父节点大于子节点的值
    private static void heapInsert(int[] array, int index) {
        while(array[index] > array[(index-1)/2]){
            swap(array,index,(index-1)/2);
            index = (index-1)/2;
        }

    }


    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    // for test
    public static void printArray(int[] array) {
        if (array == null) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {3,5,2,1,5,7,1,4};
        heapSort(array);
        printArray(array);
    }
}
