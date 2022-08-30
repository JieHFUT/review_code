package review_java_01;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-30
 * Time: 21:10
 */
public class Demo3<T> {
    public T[] array = (T[])new Object[10];

    public T getPos(int pos){
        return this.array[pos];
    }

    public void setVal(int pos, T val){
        this.array[pos] = val;
    }
}
