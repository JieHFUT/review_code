package review_java_01;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-30
 * Time: 21:01
 */
public class Demo2 {
    public Object[] array = new Object[10];

    public Object getPostion(int pos){
        return this.array[pos];
    }

    public void setVal(int pos, int val){
        this.array[pos] = val;
    }

}


