package sort;

public class HeapSort {

    //构建最大堆，维护堆序性
    private static void maxHeap(int[] a, int i, int length) {
        int leftChild =  (i << 1) + 1; //不加括号会导致先进行加法运算
        int rightChild = (i << 1) + 2;
        int max = i;

        if (leftChild < length && a[i] < a[leftChild]) {
            max = leftChild;
        }

        if (rightChild < length && a[max] < a[rightChild]) {
            max = rightChild;
        }

        if (max != i) {
            swap(a, max, i);
            maxHeap(a, max, length);
        }
    }

    //构建堆
    private static void buildHeap(int[] a) {
        for (int i = (a.length >> 1) - 1; i >= 0; --i) {
            maxHeap(a, i, a.length);
        }
    }

    //堆排序
    private static void heapSort(int[] a) {
        int length = a.length;
        buildHeap(a); //构建最大堆
        for (int i = length - 1; i >= 1; --i) {
            swap(a, i, 0); //将第一个最大的节点交换到最后。
            length--;
            maxHeap(a, 0, length);// 重新整理堆
        }
    }

    //交换
    private static void swap(int[] a, int m, int k) {
        if (a[m] != a[k]) {
            a[m] ^= a[k];
            a[k] ^= a[m];
            a[m] ^= a[k];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, 6, 4, 2, 10, 5, 0};
        heapSort(nums);
        for (int i = 0; i < nums.length; ++i) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
