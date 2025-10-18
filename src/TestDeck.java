public class TestDeck {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Card[] hand = deck.dealHand();
        Deck.checkHand(hand);
    }
}
