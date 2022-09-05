package heap;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-04
 * Time: 19:56
 */
public class MyHeap {


    public int[] elem;

    public int size;

    public MyHeap(){
        this.elem = new int[10];
    }

    public int size(){
        return this.size;
    }

    public boolean isFull(){
        return this.elem.length == this.size;
    }
    public boolean isEmpty() { return this.size == 0; }
    public void createHeap(int[] elem){
        for (int i = 0; i < elem.length; i++) {
            this.elem[i] = elem[i];
            this.size++;
        }
        for (int i = (this.size-1-1)/2; i >= 0 ; i--) {
            this.shiftDown(i, this.size);
        }
    }

    private void shiftDown(int root, int len){
        int parent = root;
        int child = 2*parent + 1;
        while (child < len){
            if (child + 1 < len && this.elem[child] < this.elem[child + 1])
                child++;
            if (this.elem[child] > this.elem[root]){
                int tmp = this.elem[root];
                this.elem[root] = this.elem[child];
                this.elem[child] = tmp;
                parent = child;
                child = 2*parent + 1;
            }else {
                break;
            }
        }
    }

    public void push(int val){
        if (this.isFull()) this.elem = Arrays.copyOf(this.elem, 2*this.elem.length);
        this.elem[this.size] = val;
        this.shiftUp(this.size);
        this.size++;
    }


    public void shiftUp(int child){
        int parent = (child-1)/2;
        while (child > 0){
            if (this.elem[parent] < this.elem[child]){
                this.swap(this.elem,parent,child);
                child = parent;
                parent = (child-1)/2;
            }else {
                break;
            }
        }
    }

    public void swap(int[] array, int x, int y){
        int tmp = array[y];
        array[y] = array[x];
        array[x] = tmp;
    }


    /**
     * 出队,每次删除的都是优先级高的元素
     * 仍然要保持是大根堆
     */
    public int poll(){
        if (this.isEmpty()) throw new IllegalArgumentException("优先级队列为空，无法删除！");
        int ret = this.elem[0];
        int parent = 0;
        int len = this.size;
        int leftChild = parent * 2 + 1;
        int rightChild = parent * 2 + 2;
        while (leftChild < len){
            if (leftChild < len){
                this.elem[parent] = this.elem[leftChild];
                parent = leftChild;
            }else if (rightChild < len && this.elem[leftChild] < this.elem[rightChild]){
                this.elem[parent] = this.elem[rightChild];
                parent = leftChild;
            }
            leftChild = parent * 2 + 1;
            rightChild = parent * 2 + 1;
        }
        this.size--;
        return ret;
    }



    public int peekHeap(){
        if (this.isEmpty()) throw new IllegalArgumentException("优先级队列为空，无法删除！");
        return this.elem[0];
    }


    public void heapSort(){
        int end = this.size-1;
        while (end > 0) {
            int tmp = this.elem[0];
            this.elem[0] = this.elem[end];
            this.elem[end] = tmp;
            this.shiftDown(0,end);
            end--;
        }
    }

    public void disPlay(){
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.elem[i] + " ");
        }
    }




}
