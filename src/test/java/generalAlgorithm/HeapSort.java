package generalAlgorithm;
//堆排序:首先确定初始堆，即保证根元素大于左右子树的元素值
//根顶最大值与根底元素交换，输出新的根底，重新确定根顶最大值元素
public class HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr,i);
        }
        //根顶最大值与根底元素交换
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }

    }

    //新的根顶元素与左右子树比较，确定新的根顶最大值元素
    private static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        int right = left + 1;
        while (left < size) {
            int largest = right < size && arr[right] > arr[left] ? right : left;//确定左右子树中的最大值
            largest = arr[largest] > arr[index] ? largest : index;  //左右子树中的最大值与父节点比较
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            //到上一层继续比较
            index = largest;
            left = index * 2 + 1;
        }

    }

    //建立初始大根堆，保证父节点大于子节点的值
    private static void heapInsert(int[] arr, int index) {
        while(arr[index] > arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index = (index-1)/2;
        }

    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {3,5,2,1,5,7,1,4};
        heapSort(arr);
        printArray(arr);
    }
}
