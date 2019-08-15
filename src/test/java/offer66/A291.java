package offer66;

/**
 * 求最小的K个数
 * 初始化大根堆
 * 堆排序
 */
public class A291 {
    private int[] data;//初始大根堆数组

    public A291() {
    }

    public A291(int[] data) {
        this.data = data;
        buildMaxHeap(data);
    }

    //初始化大根对
    public void buildMaxHeap(int[] data){
        for (int i = data.length/2-1; i >= 0; i--) {
            //对有孩子节点的元素heapify
            heapify(i);
        }
    }
    //每个节点堆化操作
    public void heapify(int i){
        int left = i * 2 + 1;
        int right = left + 1;
        int max = i;
        if(left < data.length && data[left] > data[i]) max = left;
        if(right < data.length && data[right] > data[max]) max = right;
        if(max == i)  //说明i位置已经元素最小，不需要交换
            return;
        swap(data,i,max);
        heapify(max);//继续进行堆化操作
    }

    //依次与堆顶元素比较，小于堆顶元素就替换
    public void setRoot(int num){
        if(num >= data[0])return;
        data[0] = num;
        heapify(0);//从新堆化
    }

    //最小的k个数
    public int[] findSmallest(int[] nums, int k){
        //先取K个元素放入数组中
        int[] topk = new int[k];
        for (int i = 0; i < k; i++) {
            topk[i] = nums[i];
        }
        A291 a291= new A291(topk);
        //依次与堆顶比较
        for (int i = k; i < nums.length; i++) {
            a291.setRoot(nums[i]);
        }
        return topk;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,7,1,2,2,5};
        int k =3;
        A291 a291 = new A291();
        int[] result = a291.findSmallest(nums,k);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);

        }
    }
}
