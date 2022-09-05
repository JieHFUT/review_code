package sort;

import java.util.Arrays;

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


    }
}
