package priorityqueuecompare;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-05
 * Time: 9:39
 */
public class Card implements Comparable<Card>{

    public int rank;

    public String suit;

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Card)) return false;
        Card card = (Card)obj ;
        return rank == card.rank && suit.equals(card.suit);
    }

    @Override
    public int compareTo(Card o) {
        if (o == null) return 1;
        return rank - o.rank;
    }
}
