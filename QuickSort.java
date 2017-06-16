package sort;

public class QuickSort {
    private static void quickSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        qSort(nums, 0, nums.length - 1);
    }

    private static void qSort(int[] nums, int left, int right) {
        if (left < right) {
            int povit = paration(nums, left, right);
            qSort(nums, left, povit);
            qSort(nums, povit + 1, right);
        }
    }

    private static int paration(int[] nums, int first, int last) {
        int pivot = nums[first];
        while (first < last) {
            while (first < last  && nums[last] > pivot) {
                --last;
            }
            nums[first] = nums[last];
            while (first < last && nums[first] < pivot) {
                ++first;
            }
            nums[last] = nums[first];
        }

        nums[first] = pivot;
        return first;
    }

    public static void main(String[] args) {
        int[] nums = {-1, -2, 3, 4, 1, 5};
        quickSort(nums);
        for (int i = 0; i < nums.length; ++i) {
            System.out.println(nums[i]);
        }
    }
}
