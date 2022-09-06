package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-05
 * Time: 10:54
 */
public class TestMySort {

    public static void main(String[] args) {


        int[] array1 = new int[]{1,34,22,5,11,27,455,35,324,546};
        MySort mySort = new MySort();
        mySort.insertSort(array1);
        System.out.println(Arrays.toString(array1));

        int[] array2 = new int[]{1,34,22,5,11,27,455,35,324,546};
        mySort.shellSort(array2);
        System.out.println(Arrays.toString(array2));

        int[] array3 = new int[]{1,34,22,5,11,27,455,35,324,546};
        mySort.selectSort(array3);
        System.out.println(Arrays.toString(array3));

        int[] array4 = new int[]{1,34,22,5,11,27,455,35,324,546};
        mySort.quickSortHoare(array4);
        System.out.println(Arrays.toString(array4));

        int[] array5 = new int[]{1,34,22,5,11,27,455,35,324,546};
        mySort.quickSortPit(array5);
        System.out.println(Arrays.toString(array5));

        int[] array6 = new int[]{1,34,22,5,11,27,455,35,324,546};
        mySort.quickSortPointer(array6);
        System.out.println(Arrays.toString(array6));



        int[] array7 = new int[10_000];
        Random random = new Random();
        for (int i = 0; i < array7.length; i++) {
            //array7[i] = i;
            array7[i] = random.nextInt(1000_0000);
        }
        long startTime1 = System.currentTimeMillis();
        mySort.quickSort(array7);
        long endTime1 = System.currentTimeMillis();
        System.out.println(endTime1 - startTime1);


        int[] array8 = new int[10_000];
        for (int i = 0; i < array8.length; i++) {
            //array8[i] = i;
            array8[i] = random.nextInt(10_000);
        }
        long startTime2 = System.currentTimeMillis();
        mySort.quickSortPit(array8);
        long endTime2 = System.currentTimeMillis();
        System.out.println(endTime2 - startTime2);


        int[] array9 = new int[10_000];
        for (int i = 0; i < array9.length; i++) {
            //array9[i] = i;
            array9[i] = random.nextInt(10_000);
        }
        long startTime3 = System.currentTimeMillis();
        mySort.quickSortHoare(array9);
        long endTime3 = System.currentTimeMillis();
        System.out.println(endTime3 - startTime3);



        int[] array10 = new int[]{1,34,22,5,11,27,455,35,324,546};
        mySort.quickSortNor(array10);
        System.out.println(Arrays.toString(array10));


        int[] array11 = new int[]{1,34,22,5,11,27,455,35,324,546};
        mySort.mergeSort(array11);
        System.out.println(Arrays.toString(array11));


    }
}
