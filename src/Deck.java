import java.util.Random;
public class Deck
{
    private Card[] deck;
    public Deck()
    {
        deck = new Card[52];
        int cardCount = 0;
        String[] faces = {"A","2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] suits = {"♠️", "♦️", "♣️", "♥️"};
        for (String suit : suits)
        {
            for (String face : faces)
            {
                deck[cardCount] = new Card(face, suit);
                cardCount++;
            }
        }
    }
    private static int getCardValue(Card card)
    {
        switch (card.getFace())
        {
            case "A": return 14;
            case "K": return 13;
            case "Q": return 12;
            case "J": return 11;
            default: return Integer.parseInt(card.getFace());
        }
    }

    public void printDeck(boolean shuffle)
    {
        if (shuffle)
        {
            shuffleDeck();
        }
        for (int i = 0; i < 13; i++)
        {
            System.out.printf("%-5s %-5s %-5s %-5s\n", deck[i], deck[i + 13], deck[i + 26], deck[i + 39]);
        }
    }
    private void shuffleDeck()
    {
        Random rand = new Random();
        for (int i = this.deck.length - 1; i > 0; i--)
        {
            int index = rand.nextInt(i + 1);
            Card temp = this.deck[index];
            this.deck[index] = this.deck[i];
            this.deck[i] = temp;
        }
    }
    private Card dealCard(int i)
    {
        return deck[i];
    }
    public Card[] dealHand()
    {
        shuffleDeck();
        Card[] hand = new Card[5];
        for (int i = 0; i < 5; i++)
        {
            hand[i] = dealCard(i);
        }
        return hand;
    }
    public static void printHand(Card[] hand)
    {
        for (int i = 0; i < 5; i++)
        {
            System.out.printf("%-5s", hand[i]);
        }
        System.out.println();
    }
    private static void sortHandByValue(Card[] hand)
    {
        for (int i = 0; i < hand.length - 1; i++)
        {
            for (int j = i + 1; j < hand.length; j++)
            {
                if (getCardValue(hand[i]) > getCardValue(hand[j]))
                {
                    Card temp = hand[i];
                    hand[i] = hand[j];
                    hand[j] = temp;
                }
            }
        }
    }
    public static void checkHand(Card[] hand)
    {
        sortHandByValue(hand);
        printHand(hand);
        boolean isFlush = hand[0].getSuit().equals(hand[1].getSuit()) &&
                hand[1].getSuit().equals(hand[2].getSuit()) &&
                hand[2].getSuit().equals(hand[3].getSuit()) &&
                hand[3].getSuit().equals(hand[4].getSuit());
        boolean isStraight = getCardValue(hand[1]) == getCardValue(hand[0]) + 1 &&
                getCardValue(hand[2]) == getCardValue(hand[1]) + 1 &&
                getCardValue(hand[3]) == getCardValue(hand[2]) + 1 &&
                getCardValue(hand[4]) == getCardValue(hand[3]) + 1;
        int[] valueCounts = new int[15];
        for (Card card : hand)
        {
            valueCounts[getCardValue(card)]++;
        }
        boolean fourOfAKind = false;
        boolean threeOfAKind = false;
        int pairCount = 0;
        for (int count : valueCounts)
        {
            if (count == 4) fourOfAKind = true;
            if (count == 3) threeOfAKind = true;
            if (count == 2) pairCount++;
        }
        boolean fullHouse = threeOfAKind && pairCount == 1;
        if (isStraight && isFlush) System.out.println("You have a Straight Flush");
        else if (fourOfAKind) System.out.println("You have Four of a Kind");
        else if (fullHouse) System.out.println("You have a Full House");
        else if (isFlush) System.out.println("You have a Flush");
        else if (isStraight) System.out.println("You have a Straight");
        else if (threeOfAKind) System.out.println("You have Three of a Kind");
        else if (pairCount == 2) System.out.println("You have Two Pair");
        else if (pairCount == 1) System.out.println("You have a Pair");
        else System.out.println("High Card");
    }
}