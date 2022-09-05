package stack;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-02
 * Time: 9:00
 */
public class MyStack<E> {

    private E[] elem;

    private int size;

    public MyStack(){
        this.elem = (E[])new Object[2];
    }

    public boolean isEmpty(){
        return this.size == 0;
    }
    public boolean isFull(){
        return this.elem.length == this.size;
    }
    private void grow(){
        this.elem = Arrays.copyOf(this.elem, 2*this.elem.length);
    }
    public void push(E e){
        if (this.isFull()){
            this.grow();
        }
        this.elem[this.size++] = e;
    }

    public E pop(){
        if (this.isEmpty()) throw new IllegalArgumentException("栈为空");
        E ret = this.elem[this.size-1];
        this.elem[this.size-1] = null;
        this.size--;
        return ret;
    }


    public E peek(){
        if (this.isEmpty()) throw new IllegalArgumentException("栈为空");
        return this.elem[this.size-1];
    }

    public int size(){
        return this.size;
    }


}
