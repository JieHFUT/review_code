package review_java_01;


import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-02
 * Time: 8:42
 */
public class MyDoubleLinkedLIst<E> {

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }


    transient int size;

    transient Node<E> first;

    transient Node<E> last;

    public MyDoubleLinkedLIst(){

    }

    public MyDoubleLinkedLIst(Collection<? extends E> e){
        this();
        this.addAll(e);
    }


    @Override
    public String toString() {
       Node<E> eNode = this.first;
       if (eNode == null) return null;
       StringBuilder stringBuilder = new StringBuilder("[");
       while (eNode.next != null){
           stringBuilder.append(eNode.item + ",");
           eNode = eNode.next;
       }
       stringBuilder.append(eNode.item + "]");
       return stringBuilder.toString();
    }

    public int size(){
        return this.size;
    }


    public void addFirst(E e){
        Node<E> eNode = new Node<>(null,e,null);
        if (this.first == null){
            this.first = eNode;
            this.last = eNode;
            this.size++;
            return;
        }
        eNode.next = this.first;
        this.first.prev = eNode;
        this.first = eNode;
        this.size++;
        return;
    }


    public void addLast(E e){
        Node<E> eNode = new Node<>(null,e,null);
        if (this.first == null){
            this.first = eNode;
            this.last = eNode;
            this.size++;
            return;
        }
        this.last.next = eNode;
        eNode.prev = this.last;
        this.size++;
        return;
    }


    public boolean addIndex(int index, E e){

        if (index < 0 || index > this.size()){
            throw new IllegalArgumentException("输入的范围越界！");
        }
        Node<E> eNode = new Node<>(null,e,null);
        if (this.first == null){
            this.first = eNode;
            this.last = eNode;
            this.size++;
            return true;
        }
        Node<E> currentFirst = this.first;
        if (index == this.size()){
            this.last.next = eNode;
            eNode.prev = this.last;
            this.last = eNode;
            this.size++;
            return true;
        }
        while (index > 0){
            currentFirst = currentFirst.next;
            index--;
        }
        eNode.next = currentFirst;
        eNode.prev = currentFirst.prev;
        currentFirst.prev.next = eNode;
        currentFirst.prev = eNode;
        this.size++;
        return true;
    }


    public void addAll(Collection<? extends E> e){

    }

    public boolean contains(E e){
        Node<E> eNode = this.first;
        while (eNode != null){
            if (eNode.item.equals(e)){
                return true;
            }
            eNode = eNode.next;
        }
        return false;
    }




    public boolean remove(E e){
        if (this.first == null){
            throw new IllegalArgumentException("链表为空！无法删除！");
        }

        if (this.first.equals(this.last) && this.first.item.equals(e)){
            this.first = null;
            this.last = null;
            this.size--;
            return true;
        }

        if (this.first.item.equals(e)){
            this.first = this.first.next;
            if (this.first != null){
                this.first.prev = null;
            }
            this.size--;
            return true;
        }
        if (this.last.item.equals(e)){
            this.last.prev.next = null;
            this.last.prev = null;
            this.size--;
            return true;
        }

        Node<E> eNode = this.first;
        while (eNode != null){
            if (eNode.item.equals(e)){
                eNode.prev.next = eNode.next;
                eNode.next.prev = eNode.prev;
                this.size--;
                return true;
            }
            eNode = eNode.next;
        }
        throw new IllegalArgumentException("链表中没有你要删除的元素！");
    }



    public void removeAllKey(E e){
        if (this.first == null) {
            throw new IllegalArgumentException("该链表为空，无法进行删除！");
        }
        while (this.first != null && this.first.item.equals(e)){
            this.first = this.first.next;
            if (this.first != null){
                this.first.prev = null;
            }
            this.size--;
        }
        if (this.first == null) return ;
        Node<E> current = this.first;
        Node<E> preCur = this.first;
        Node<E> nextCur = this.first.next;
        while (nextCur != null){
            if (nextCur.item.equals(e)){
                current = nextCur;
                nextCur = nextCur.next;
                if (nextCur != null){
                    nextCur.prev = preCur;
                }
                preCur.next = nextCur;
                current.prev = null;
                current.next = null;
                current = preCur;
                this.size--;
            }else {
                current = nextCur;
                nextCur = nextCur.next;
                preCur = current;
            }
        }
        return ;
    }








}
