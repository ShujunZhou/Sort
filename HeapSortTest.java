package sort;

/**
 * Created by shu on 2017/4/12.
 */
public class HeapSortTest {

    private static void heapSort(int[] nums) {
        if (nums == null && nums.length == 0) {
            return;
        }

        buildHeap(nums); //构建一个最大堆
        int length = nums.length;
        for (int i = length - 1; i > 0; --i) {
            swap(nums, i, 0);//将第一个元素与最后一个元素交换
            --length; //缩小范围
            maxNums(nums, 0, length); //调整堆
        }
    }

    private static void maxNums(int[] nums, int i, int length) {
        int left = (i << 1) + 1;
        int right = (i << 1) + 2;
        int max = i;

        if (right < length && nums[right] > nums[max]) {
            max = right;
        }

        if (left < length && nums[left] > nums[max]) {
            max = left;
        }

        if (max != i) {
            swap(nums, max, i);
            maxNums(nums, max, length);
        }
    }

    private static void buildHeap(int[] nums) {
        for (int i = (nums.length >> 1) - 1; i >= 0; --i) {
            maxNums(nums, i, nums.length);
        }
    }

    private static void swap(int[] nums, int a, int b) {
        if (nums[a] != nums[b]) {
            nums[a] ^= nums[b];
            nums[b] ^= nums[a];
            nums[a] ^= nums[b];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, 2, 5, 3, 4};
        heapSort(nums);
        for (int i = 0; i < nums.length; ++i) {
            System.out.print(nums[i] + " ");
        }
    }
}
