package sort;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-05
 * Time: 10:19
 */
public class MySort {

    /**
     * 插入排序
     * * 适合于数据量小并且已经趋于有序的情况下
     * @param array
     */
    public void insertSort(int[] array){
        int j = 0;
        int tmp = 0;
        for (int i = 0; i < array.length; i++) {
            j = i - 1;
            tmp = array[i];
            while (j >= 0){
                if (array[j] > tmp){
                    array[j + 1] = array[j];
                    j--;
                }else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }


    public void swap(int[] array, int x, int y){
        int tmp = array[y];
        array[y] = array[x];
        array[x] = tmp;
    }

    public void insertSort1(int[] array){
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            j = 0;
            while (j < i){
                if (array[j] > array[i]){
                    this.swap(array, i, j);
                }
                j++;
            }
        }
    }



    /**
     * 希尔排序，是一种不稳定排序
     * @param array
     */
    public void realShellSort(int[] array, int gap){
        int j = 0;
        for(int k = 0; k < gap; k++){
            for (int i = k; i < array.length; i += gap) {
                j = k;
                while (j < i){
                    if (array[j] > array[i]){
                        this.swap(array, i, j);
                    }
                    j += gap;
                }
            }
        }

    }

    public void shellSort(int[] array){
        int gap = array.length;
        while (gap > 0){
            this.realShellSort(array, gap);
            gap /= 2;
        }
    }


    /**
     * 直接选择排序 不稳定
     * 时间复杂度 O(n2)
     * 空间复杂度 O(1)
     * @param array
     */
    public void selectSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int record = 0;
            int min = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    record = j;
                }
            }
            if (record != 0){
                array[record] = array[i];
                array[i] = min;
            }
        }
    }


    /**
     * 快排的 Hoare方法
     * @param array
     * @param low
     * @param high
     * @return
     */
    private int partitionHoare(int[] array, int low, int high){
        int i = low;
        int pivot = array[low];
        while (low < high){

            while(low < high && array[high] >= pivot){
                high--;
            }

            while (low < high && array[low] <= pivot){
                low++;
            }

            swap(array,low,high);
        }
        swap(array,low,i);

        return low;
    }

    public void quickHoare(int[] array, int left, int right){
        if (left >= right) return;
        int pivot = this.partitionHoare(array, left, right);
        this.quickHoare(array, left, pivot-1);
        this.quickHoare(array, pivot + 1, right);
    }
    public void quickSortHoare(int[] array){
        this.quickHoare(array, 0, array.length-1);
    }


    /**
     * 挖坑法
     * @param array
     * @param left
     * @param right
     * @return
     */
    public int partitionPit(int[] array, int left, int right){
        int pit = left;
        int tmp = array[left];
        while (left < right){
            while (left < right && array[right] >= tmp){
                right--;
            }
            array[pit] = array[right];
            pit = right;
            while (left < right && array[left] <= tmp){
                left++;
            }
            array[pit] = array[left];
            pit = left;
        }
        array[pit] = tmp;
        return pit;
    }
    public void quickPit(int[] array, int left, int right){
        if (left >= right) return;
        int pivot = this.partitionPit(array, left, right);
        this.quickPit(array, left, pivot-1);
        this.quickPit(array, pivot + 1, right);
    }
    public void quickSortPit(int[] array){
        this.quickPit(array, 0, array.length-1);
    }



    /**
     * 双指针法
     * @param array
     * @param low
     * @param high
     */
    private void partitionPointer(int[] array, int low, int high){
        int cur = low + 1;
        int prev = low;
        while(cur <= high){
            while (array[cur] < array[low] && array[++prev] != array[low]){
                swap(array,cur,prev);
            }
            cur++;
        }
    }

    private int partitionPointer2(int[] array, int left, int right) {
        int d = left + 1;
        int pivot = array[left];
        for (int i = left + 1; i <= right; i++) {
            if (array[i] < pivot) {
                swap(array, i, d);
                d++;
            }
        }
        swap(array, d - 1, left);
        return d - 1;
    }

    private void quickPointer(int[] array, int low, int high){
        while(low >= high) return;
        int pivot = partitionHoare(array,low,high);
        quickHoare(array,low,pivot-1);
        quickHoare(array,pivot+1,high);
    }

    public void quickSortPointer(int[] array){
        quickHoare(array,0,array.length-1);
    }



    /**
     * 优化后的快排
     * @param array
     */
    public void quickSort(int[] array){
        this.quickPitForquickSort(array, 0, array.length-1);
    }


    /**
     * 找到中间的基准的下标
     * @param array
     * @param left
     * @param right
     */
    public int medianOfThreeIndex(int[] array, int left, int right){
        int mid = left + (right - left) >>> 1;
        if (array[left] < array[mid]){
            if (array[left] > array[right]) return left;
            if (array[mid] < array[right]) return mid;
            return right;
        }else {
            if (array[mid] > array[right]) return mid;
            if (array[left] < array[right]) return left;
            return right;
        }
    }
    public void quickPitForquickSort(int[] array, int left, int right){
        if (left >= right) return;

        //1、在某一个区间内部的直接插入排序
        if (right - left + 1 < 60){
            this.insertSortForQuickSort(array, left, right);
            return;
        }
        //2、三数取中法
        int index = this.medianOfThreeIndex(array, left, right);
        this.swap(array, left, index);

        //3、可以将基准相同的数字放到一起，从而可以减少递归的次数


        int pivot = this.partitionPitForQuickSort(array, left, right);
        this.quickPitForquickSort(array, left, pivot-1);
        this.quickPitForquickSort(array, pivot + 1, right);
    }


    public int partitionPitForQuickSort(int[] array, int left, int right){
        int pit = left;
        int tmp = array[left];
        while (left < right){
            while (left < right && array[right] >= tmp){
                right--;
            }
            array[pit] = array[right];
            pit = right;
            while (left < right && array[left] <= tmp){
                left++;
            }
            array[pit] = array[left];
            pit = left;
        }
        array[pit] = tmp;
        return pit;
    }


    public void insertSortForQuickSort(int[] array, int left, int right){
        int j = 0;
        int tmp = 0;
        for (int i = left + 1; i <= right; i++) {
            j = i - 1;
            tmp = array[i];
            while (j >= left){
                if (array[j] > tmp){
                    array[j + 1] = array[j];
                    j--;
                }else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }


    /**
     * 非递归实现快排
     * @param array
     */
    public void quickSortNor(int[] array){
        this.partitionForQuickSortNor(array, 0, array.length-1);
    }

    public void partitionForQuickSortNor(int[] array, int left, int right){
        if (left >= right) return;
        Stack<Integer> stack = new Stack<>();

        int pivot = this.partitionHoare(array, left, right);
        if (pivot > left + 1){
            stack.push(left);
            stack.push(pivot - 1);
        }
        if (pivot < right - 1){
            stack.push(pivot + 1);
            stack.push(right);
        }
        while (!stack.isEmpty()){
            right = stack.pop();
            left = stack.pop();
            pivot = this.partitionHoare(array, left, right);
            if (pivot > left + 1){
                stack.push(left);
                stack.push(pivot - 1);
            }
            if (pivot < right - 1){
                stack.push(pivot + 1);
                stack.push(right);
            }
        }
    }










    /**
     * 归并排序
     * @param array
     */
    public void mergeSort(int[] array){
        this.partitionForMergeSort(array, 0, array.length-1);
    }

    public void partitionForMergeSort(int[] array, int left, int right){
        if (left >= right) return;

        int mid = left + ((right - left) >>> 2);
        this.partitionForMergeSort(array, left, mid);
        this.partitionForMergeSort(array, mid+1, right);

        this.merge(array, left, mid, right);
    }

    public void merge(int[] array, int low, int mid, int high){
        int s1 = low;
        int e1 = mid;
        int s2 = mid + 1;
        int e2 = high;
        int[] arr = new int[high - low + 1];
        int j = 0;

        while (s1 <= e1 && s2 <= e2){
            if (array[s1] <= array[s2]){
                arr[j++] = array[s1++];
            }else {
                arr[j++] = array[s2++];
            }
        }
        if (s1 > e1){
            while (s2 <= e2){
                arr[j++] = array[s2++];
            }
        }
        if (s2 > e2){
            while (s1 <= e1){
                arr[j++] = array[s1++];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            array[i + low] = arr[i];
        }
    }


    /**
     * 非递归实现归并排序
     * @param array
     */
    public  void mergeSortNor(int[] array) {
        int gap = 1;
        while (gap < array.length) {
            for (int i = 0; i < array.length; i += 2*gap) {
                int left = i;
                int mid = left + gap - 1;
                //修正mid
                if(mid >= array.length) {
                    mid = array.length-1;
                }
                int right = mid + gap;
                //修正right
                if(right >= array.length) {
                    right = array.length-1;
                }
                merge(array, left, mid, right);
            }
            gap *= 2;
        }
    }


    /**
     * 计数排序：
     * 时间复杂度：O(范围+N)
     * 空间复杂度：O(范围)
     * 计数排序和当前数据给定的范围是有关系的。
     *         int range = maxVal-minVal+1;
     *         集中的就好点；  0-100-》10
     * 稳定性：
     * @param array
     */
    public static void countSort(int[] array) {
        //1、获取最大值和最小值
        int maxVal = array[0];
        int minVal = array[0];
        //O(N)
        for (int i = 1; i < array.length; i++) {
            if(array[i] < minVal) {
                minVal = array[i];
            }
            if(array[i] > maxVal) {
                maxVal = array[i];
            }
        }
        //2、开始计数
        int range = maxVal-minVal+1;
        int[] count = new int[range];
        //O(N)
        for (int i = 0; i < array.length; i++) {
            count[array[i]-minVal]++;
        }
        //3、遍历这个计数数组，把数据放回array
        //O(范围 + n), 某一次 可能是n次
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                array[index++] = i+minVal;
                count[i]--;
            }
        }
    }

}