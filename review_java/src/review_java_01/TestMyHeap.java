package review_java_01;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-04
 * Time: 19:56
 */
public class TestMyHeap {

    public static void main(String[] args) {


       /* int[] array1 = {12,2,3,54,26,47,22,16};
        MyHeap heap = new MyHeap();
        heap.createHeap(array1);
        heap.heapSort();
        heap.disPlay();*/

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int[] array = {1,23,4,24,55,64,75,666,43,267,8,66,45,9};
        int k = 4;
        for (int i = 0; i < array.length; i++) {
            if (priorityQueue.size() < k){
                priorityQueue.offer(array[i]);
            }else {
                if (array[i] < priorityQueue.peek()){
                    priorityQueue.poll();
                    priorityQueue.offer(array[i]);
                }
            }
        }

        for (int i = 0; i < k; i++) {
            System.out.print(priorityQueue.poll() + " ");
        }
        System.out.println();



        int[] arr = {2,5,76,34,55,6,98,79,2,67,88};
        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            priorityQueue1.offer(arr[i]);
        }
        int size = priorityQueue1.size();
        for (int i = 0; i < size; i++) {
            System.out.print(priorityQueue1.poll() + " ");
        }
        System.out.println();
    }
}






























