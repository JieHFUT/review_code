package priorityqueuecompare;

import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-05
 * Time: 10:00
 */
public class TestPriorityQueue {

    public static void main(String[] args) {

        PriorityQueue<Card> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Card(2,"♣"));
        priorityQueue.offer(new Card(3,"♠"));

    }
}
