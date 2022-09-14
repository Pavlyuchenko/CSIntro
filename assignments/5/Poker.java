import java.util.Arrays;

class Poker extends ArrayManipulation {
    static String[] deck = { "cA", "cK", "cQ", "cJ", "c10", "c9", "c8", "c7", "c6", "c5", "c4", "c3", "c2", // Clovers
            "pA", "pK", "pQ", "pJ", "p10", "p9", "p8", "p7", "p6", "p5", "p4", "p3", "p2", // Pickes
            "hA", "hK", "hQ", "hJ", "h10", "h9", "h8", "h7", "h6", "h5", "h4", "h3", "h2", // Hearts
            "dA", "dK", "dQ", "dJ", "d10", "d9", "d8", "d7", "d6", "d5", "d4", "d3", "d2" }; // Diamonds

    static String[][] player_combinations = new String[0][5];
    static String[][] opponent_combinations = new String[0][5];

    public static void main(String[] args) {
        String[] cards = { "c2", "c3", "c4", "c5", "c6", "c7" };
        Poker p = new Poker();

        // Example to validate your implementation of method deleteCards
        String[] discard = { "c7" };
        String[] newCards = p.discard_cards(cards, discard);
        System.out.println(Arrays.toString(newCards));
        // The following call must print the following combination (order of the
        // elements inside the combination does not matter):
        // "c2", "c3", "c5", "c6", "c7"

        // Example to validate your implementation of method possible_hands
        p.possible_hands(cards, new String[0]);
        // The following call must print the following combinations (order of
        // combinations and/or elements inside the combinations do not matter):
        // "c2", "c3", "c4", "c5", "c6"
        // "c2", "c3", "c4", "c5", "c7"
        // "c2", "c3", "c4", "c6", "c7"
        // "c2", "c3", "c5", "c6", "c7"
        // "c2", "c4", "c5", "c6", "c7"
        // "c3", "c4", "c5", "c6", "c7"
        System.out.println(Arrays.deepToString(Poker.player_combinations));

        // Example to validate your implementation of method possible_hands_opponent
        String[] cardsOnCommunity = { "c2", "c3", "c4" };
        String[] cardsAvailable = { "c2", "c3", "c4", "c5", "c6", "c7" };
        p.possible_hands_opponent(cardsAvailable, cardsOnCommunity, new String[0]);
        // The following call must print the following combinations (order of
        // combinations and/or elements inside the combinations do not matter):
        // "c2", "c3", "c4", "c5", "c6"
        // "c2", "c3", "c4", "c5", "c7"
        // "c2", "c3", "c4", "c6", "c7"
        System.out.println(Arrays.deepToString(Poker.opponent_combinations));

    }

    public String[] discard_cards(String[] initialCards, String[] cardsToDiscard) {
        // Write your code below

        // Terminate condition
        if (cardsToDiscard.length == 0) {

            // Need to remove "nulls" from the initialCards array
            int nullCount = 0;
            for (int i = 0; i < initialCards.length; i++) {
                if (initialCards[i] == null) {
                    nullCount++;
                }
            }

            String[] result = new String[initialCards.length - nullCount];
            int nullFound = 0;
            for (int i = 0; i < initialCards.length; i++) {
                if (initialCards[i] != null) {
                    result[i - nullFound] = initialCards[i];
                } else {
                    nullFound++;
                }
            }
            return result;
        }

        // Delete cards that equal to the first discarded card
        String discardedCard = cardsToDiscard[0];
        String[] tempCards = new String[initialCards.length];
        for (int i = 0; i < initialCards.length; i++) {
            if (initialCards[i] != discardedCard) {
                tempCards[i] = initialCards[i];
            }
        }

        // Remove the discarded card from the array
        String[] tempDiscardedCards = new String[cardsToDiscard.length - 1];
        for (int i = 1; i < cardsToDiscard.length; i++) {
            tempDiscardedCards[i - 1] = cardsToDiscard[i];
        }

        return discard_cards(tempCards, tempDiscardedCards);

        // Write your code above
    }

    public void possible_hands(String[] cardsAvailable, String[] cardsOnHands) {
        // Write your code below

        // Write your code above
    }

    public void possible_hands_opponent(String[] cardsAvailable, String[] cardsOnCommunity, String[] cardsOnHands) {
        // Write your code below

        // Write your code above
    }

}