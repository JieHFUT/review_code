package arraylist;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-31
 * Time: 12:57
 */
public class MyArrayList<E> {
    private Object[] array;
    private int size;

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    //构造方法
    public MyArrayList(){
        this.array = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public MyArrayList(int initCapacity){
        if (initCapacity > 0){
            array = new Object[initCapacity];
        } else if (initCapacity == 0) {
            array = new Object[0];
        }else {
            throw new IllegalArgumentException("初始容量为负数！");
        }
    }

    //返回数组的已经使用的大小空间
    public int size(){
        return this.size;
    }

    //判断数组是否为空
    public boolean isEmpty(){
        return this.size == 0;
    }

    //尾插法
    public boolean add(E e){
        //先提前判断加入一个元素是否会让数组越界，从而需要扩容-----注意第一次size为0的时候
        ensureCapacityInternal(this.size + 1);
        this.array[size++] = e;
        return true;
    }


    /**
     * 存放元素之前先确定内部的容量
     * @param minCapacity 即是现在的容量如果要再插入一个元素的使用值
     */
    private void ensureCapacityInternal(int minCapacity){
        /**
         * 1、先计算，如果调用的是不带参数的构造方法就返回默认值和预使用的较大值
         *    如果调用的是带参数构造方法就直接返回指定的大小
         *    可以理解如果是再次add，则返回预需要的大小也就是size+1
         */
        int capacity = calculateCapacity(this.array, minCapacity);

        //2、确保该容量是否可以被分配
        ensureExplicitCapacity(capacity);

    }



    //默认容量
    private static final int DEFAULT_CAPACITY = 10;

    private static int calculateCapacity(Object[] elementData, int minCapacity){     //elementData其实就是array的数组
        //1、说明调用了不带参数的构造方法
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA){
            //此时默认的分配容量是10
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        //2、给了参数，返回你指定的参数
        return minCapacity;
    }

    private void ensureExplicitCapacity(int minCapacity){
        //计算出来的容量如果大就需要扩容，否则什么都不做
        if (minCapacity - this.array.length > 0){
            grow(minCapacity);
        }
    }

    //扩容
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8; //2^31-1-8

    private void grow(int initCapacity){  //传过来的就是预需要的空间大小
        int oldCapacity = this.array.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);

        //当第一次newCapacity==0的时候，大小为给定的容量
        if (newCapacity < initCapacity){
            newCapacity = initCapacity;
        }
        if (newCapacity > MAX_ARRAY_SIZE){
            newCapacity = MAX_ARRAY_SIZE;
        }
        array = Arrays.copyOf(this.array, newCapacity);
    }

    //为指定的位置插入元素e
    public void add(int index, E e){
        this.rangeCheckForAdd(index);
        this.ensureCapacityInternal(this.size + 1);
        for (int i = size-1; i >= index; i--) {
            this.array[i+1] = this.array[i];
        }
        this.array[index] = e;
        this.size++;
    }


    //检查插入的下标是否合法
    private void rangeCheckForAdd(int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("add下标越界!");
        }
    }


    //删除index位置上的元素
    private E remove(int index){
        this.rangeCheck(index);
        E ret = (E)this.array[index];
        for (int i = index; i < this.size; i++) {
            this.array[i] = this.array[i+1];
        }
        this.size--;
        return ret;
    }

    //检查remove时下标是否合法
    private void rangeCheck(int index){
        if (index < 0 || index >= this.size){
            throw new IllegalArgumentException("remove时输入的下标越界！");
        }
    }

    // ******获取o第一次出现的位置
    public int indexOf(Object o){
        if (null == o){
            for (int i = 0; i < this.size; i++) {
                if (array[i] == null){
                    return i;
                }
            }
        }else {
            for (int i = 0; i < this.size; i++) {
                if (this.array[i].equals(o)){
                    return i;
                }
            }
        }
        return -1;
    }


    //如果o存在，则删除
    public boolean remove(Object o) {
        int index = this.indexOf(o);
        if (index == -1)
            return false;
        this.remove(index);
        return false;
    }


    //获取index位置上的元素
    public E get(int index){
        this.rangeCheck(index);
        return (E)this.array[index];
    }

    //将index位置上的元素设置为e
    public E set(int index, Object e){
        this.rangeCheck(index);
        this.array[index] = e;
        return (E) e;
    }


    //清空
    public void clear(){
        for (int i = 0; i < this.size; i++) {
            this.array[i]  = null;
        }
        this.size = 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < this.size-1; i++) {
            stringBuilder.append(this.array[i] + ",");
        }
        stringBuilder.append(this.array[this.size-1]);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }









}
