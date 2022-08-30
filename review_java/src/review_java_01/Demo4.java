package review_java_01;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-30
 * Time: 21:39
 */
public class Demo4<T> {
    private T message;

    public T getMessage(){
        return this.message;
    }

    public void setMessage(T message){
        this.message = message;
    }

}
