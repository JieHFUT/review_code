package singlelinkedlist;




/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-01
 * Time: 12:44
 */
public class MySingleLinkedList<E> {


    static class ListNode<E> {
        public E value;

        public ListNode<E> next;

        public ListNode(E value){
            this.value = value;
        }

        public ListNode(){

        }

    }

    public ListNode<E> head;



    public int size(){
        int size = 0;
        ListNode<E> currentHead = this.head;
        while (currentHead != null){
            size++;
            currentHead = currentHead.next;
        }
        return size;
    }
    public void addFirst(E e){
        while (this.head == null){
            this.head = new ListNode<>(e);
            return;
        }
        ListNode<E> listNode = new ListNode<>(e);
        listNode.next = this.head;
        this.head = listNode;
    }

    public void display(){
        ListNode<E> currentHead = this.head;
        while (currentHead != null){
            System.out.print(currentHead.value + " ");
            currentHead = currentHead.next;
        }
        System.out.println();
    }


    public void addLast(E e){
        while (this.head == null){
            this.head = new ListNode<>(e);
            return;
        }
        ListNode<E> currentHead = this.head;
        ListNode<E> listNode = new ListNode<>(e);

        while (currentHead.next != null){
            currentHead = currentHead.next;
        }
        currentHead.next = listNode;
    }

    public void addIndex(int index, E e){
        this.checkIndexForAddIndex(index);
        ListNode<E> currentHead = this.head;
        ListNode<E> listNode = new ListNode<>(e);
        if (index == 0){
            this.addFirst(e);
        } else if (index == this.size()) {
            this.addLast(e);
        }else {
            while (index > 1){
                currentHead = currentHead.next;
                index--;
            }
            listNode.next = currentHead.next;
            currentHead.next = listNode;
        }
    }
    private void checkIndexForAddIndex(int index){
        while (index < 0 || index > this.size()){
            throw new IllegalArgumentException("输入的范围不合法！");
        }
    }




    public boolean contains(E e){
        ListNode<E> currentHead = this.head;
        while (currentHead != null){
            if (currentHead.value == e){
                return true;
            }
            currentHead = currentHead.next;
        }
        return false;
    }



    public void remove(E e){
        if (this.head == null){
            throw new IllegalArgumentException("链表为空！无法删除！");
        }
        if (this.head.value == e){
            this.head = this.head.next;
            return;
        }
        ListNode<E> currentHead = this.head;
        while (currentHead != null){
            if (currentHead.next.value == e){
                currentHead.next = currentHead.next.next;
                return;
            }
            currentHead = currentHead.next;
        }
        throw new IllegalArgumentException("链表中没有要删除的元素！");
    }



    public void removeAllKey(E e) {
        if (this.head == null) {
            throw new IllegalArgumentException("链表为空！无法删除！");
        }
        while (this.head.value == e) {
            this.head = this.head.next;
        }
        ListNode<E> currentHead = this.head.next;
        ListNode<E> prevCurrentHead = this.head;
        while (currentHead != null ) {
            if (currentHead.value == e) {
                currentHead = currentHead.next;
                prevCurrentHead.next = currentHead;
            } else {
                prevCurrentHead = currentHead;
                currentHead = currentHead.next;
            }
        }

    }


    public void clear(){
        ListNode<E> currentHead = this.head.next;
        ListNode<E> preCurrentHead = this.head;
        while (currentHead != null){
            currentHead.value = null;
            preCurrentHead = currentHead;
            currentHead = currentHead.next;
            preCurrentHead.next = null;
        }
        this.head.value = null;
        this.head = null;
    }



    public void reverse(){
        if (this.head == null){
            throw new IllegalArgumentException("单链表为空，无法反转！");
        }
        ListNode<E> currentHead = this.head;
        ListNode<E> preCurrentHead = currentHead;
        ListNode<E> nextCurrentHead = currentHead.next;

        while (nextCurrentHead != null){
            currentHead = nextCurrentHead;
            nextCurrentHead = nextCurrentHead.next;
            currentHead.next = preCurrentHead;
            preCurrentHead = currentHead;
        }
        this.head.next = null;
        this.head = currentHead;
        return;
    }


    public ListNode<E> returnMiddle(){
        ListNode<E> slow = this.head;
        ListNode<E> fast = this.head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode<E> returnLastK(int k){
        ListNode<E> prevNote = this.head;
        ListNode<E> node = this.head;
        while (k > 0 && prevNote != null){
            prevNote = prevNote.next;
            k--;
        }
        if (k != 0){
            throw new IllegalArgumentException("输出该链表倒数第K个节点时，输入不合法！");
        }
        while (prevNote != null){
            prevNote = prevNote.next;
            node = node.next;
        }
        return node;
    }



    public ListNode<Integer> returnNew(ListNode<Integer> head1, ListNode<Integer> head2){
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        ListNode<Integer> listNode = new ListNode<>();
        ListNode<Integer> ret = listNode;
        while (head1 != null && head2 != null){
            if (head1.value < head2.value){
                listNode.next = head1;
                head1 = head1.next;
            }else {
                listNode.next = head2;
                head2 = head2.next;
            }
        }
        if (head1 == null){
            while (head2 != null){
                listNode.next = head2;
                head2 = head2.next;
            }
        }
        if (head2 == null){
            while (head1 != null){
                listNode.next = head1;
                head1 = head1.next;
            }
        }
        return ret.next;
    }


    public ListNode<Integer> sortPointK(ListNode<Integer> head, int x){
        ListNode<Integer> bs = null;
        ListNode<Integer> be = null;
        ListNode<Integer> as = null;
        ListNode<Integer> ae = null;
        ListNode<Integer> currentHead = head;
        while (head != null){
            if (head.value < x){
                if (bs == null){
                    bs = currentHead;
                    be = currentHead;
                }else {
                    be.next = currentHead;
                    be = be.next;
                }
            }else {
                if (as == null){
                    as = currentHead;
                    ae = currentHead;
                }else {
                    ae.next = currentHead;
                    ae = ae.next;
                }
            }
        }
        if (bs == null) return as;
        if (as == null) return bs;
        be.next = as;
        return bs;
    }


    public boolean chkPalindrome(ListNode A) {
        while (A == null) {
            throw new IllegalArgumentException("该链表为空！");
        }
        ListNode<E> fast = A;
        ListNode<E> slow = A;
        ListNode<E> start = A;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode<E> slowPrev = slow;
        ListNode<E> slowNext = slow.next;
        ListNode<E> slowCure = slow;
        while (slowNext != null){
            slowCure = slowNext;
            slowNext = slowNext.next;
            slowCure.next = slowPrev;
            slowPrev = slowCure;
        }
        slow.next = null;
        while (slowCure != start && start.next != slowCure){
            if (start.value != slowCure.value){
                return false;
            }
            slowCure = slowCure.next;
            start = start.next;
        }
        return true;
    }

}
