package leetcode;

/**
 * 利用数组实现stack、queue
 */
public class Array_To_Stack_Queue {
    /**
     * 利用数组实现stack
     */
    public static class ArrayStack {
        private Integer[] arr;
        private Integer size; //数组中元素个数

        public ArrayStack(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            size = 0;
        }

        /**
         * 获取栈顶元素
         * @return
         */
        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[size - 1];
        }

        public void push(int obj) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            arr[size++] = obj;
        }

        public Integer pop() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            return arr[--size];
        }
    }

    /**
     * 利用数组实现queue
     */
    public static class ArrayQueue {
        private Integer[] arr;
        private Integer size;//队列中元素个数
        private Integer first;//队首
        private Integer last;//队尾

        public ArrayQueue(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            size = 0;
            first = 0;
            last = 0;
        }

        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[first];
        }

        public void push(int obj) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            size++;
            arr[last] = obj;
            //如果队尾指针已经移到数组尾部，将队尾指针移到数组首部，即队首；
            //因为队列poll操作是从队首进行的，即队首。所以，数组首部元素可能已经poll，下次再插入时可以覆盖
            last = (last == arr.length - 1) ? 0 : last + 1;
        }

        public Integer poll() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            size--;
            int tmp = first;
            //同理，如果队首指针已经移到数组尾部，将队首指针移到数组首部，即队首；
            //因为队首可能因为push操作，新添加了一些元素
            first = (first == arr.length - 1) ? 0 : first + 1;
            return arr[tmp];
        }
    }

    public static void main(String[] args) {

    }
}
