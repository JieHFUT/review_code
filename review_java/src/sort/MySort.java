package sort;

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
     * @param left
     * @param right
     * @return
     */
    public int partition(int[] array, int left, int right){

    }

    public void quickHoare(int[] array, int left, int right){
        if (left >= right) return;
        int pivot = this.partition(array, left, right);
        this.quickHoare(array, left, pivot-1);
        this.quickHoare(array, pivot + 1, right);
    }
    public void quickSortHoare(int[] array){
        this.quickHoare(array, 0, array.length-1);
    }





















}
