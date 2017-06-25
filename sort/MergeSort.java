package sort;


public class MergeSort {
    //归并排序
    public static void mergeSort(int[] nums) {
        int[] temp = new int[nums.length]; //需要额外的O(n)空间
        //先分割数组
        initSpilt(nums, temp, 0, nums.length - 1);
    }

    //分割数组,并进行归并排序,是一种分而治之的思想
    public static void initSpilt(int[] nums, int[] temp, int left, int right) {
        if (left < right) {
            int middle = (left + right) >> 1;
            initSpilt(nums, temp, left, middle);
            initSpilt(nums, temp, middle + 1, right);
            mergeSort(nums, temp, left, middle, right);
        }
    }

    //合并两个已排序的数组nums[left~middle - 1] nums[middle~right]
    private static void mergeSort(int[] nums, int[] temp, int left, int middle, int right) {
        int i = left; //确定数组边界
        int j = middle + 1;
        int k = left;

        while (i <= middle && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= middle) {
            temp[k++] = nums[i++];
        }

        while (j <= right) {
            temp[k++] = nums[j++];
        }

        for (int m = left; m < k; ++m) { //复制回原数组
            nums[m] = temp[m];
        }
    }


    public static void main(String[] args) {
        int[] a = {2, 1, 3, 0, 6, 4, -1};
        mergeSort(a);
        for (int i = 0; i < a.length; ++i) {
            System.out.print(a[i] + " ");
        }

        System.out.println();
    }
}
