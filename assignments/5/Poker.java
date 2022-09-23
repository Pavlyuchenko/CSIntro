import java.util.Arrays;

class Poker extends ArrayManipulation {
    static String[] deck = { "cA", "cK", "cQ", "cJ", "c10", "c9", "c8", "c7", "c6", "c5", "c4", "c3", "c2", // Clovers
            "pA", "pK", "pQ", "pJ", "p10", "p9", "p8", "p7", "p6", "p5", "p4", "p3", "p2", // Pickes
            "hA", "hK", "hQ", "hJ", "h10", "h9", "h8", "h7", "h6", "h5", "h4", "h3", "h2", // Hearts
            "dA", "dK", "dQ", "dJ", "d10", "d9", "d8", "d7", "d6", "d5", "d4", "d3", "d2" }; // Diamonds

    static String[][] player_combinations = new String[0][5];
    static String[][] opponent_combinations = new String[0][5];

    public static void main(String[] args) {
        // String[] cards = { "d2", "c3", "c4", "c5", "c6", "c7" };
        String[] cards = { "c10", "d8", "c9", "dJ", "cQ", "cK", };
        Poker p = new Poker();

        // Example to validate your implementation of method deleteCards
        String[] discard = { "c7" };
        String[] newCards = p.discard_cards(cards, discard);
        System.out.println("Discard Cards: " + Arrays.toString(newCards));
        // The following call must print the following combination (order of the
        // elements inside the combination does not matter):
        // "c2", "c3", "c5", "c6", "c7"

        System.out.println("--------");
        // Example to validate your implementation of method possible_hands
        p.possible_hands(cards, new String[0]);
        System.out.println(Arrays.deepToString(p.player_combinations));
        System.out.println("--------");

        // The following call must print the following combinations (order of
        // combinations and/or elements inside the combinations do not matter):
        // "c2", "c3", "c4", "c5", "c6"
        // "c2", "c3", "c4", "c5", "c7"
        // "c2", "c3", "c4", "c6", "c7"
        // "c2", "c3", "c5", "c6", "c7"
        // "c2", "c4", "c5", "c6", "c7"
        // "c3", "c4", "c5", "c6", "c7"
        System.out.println("Player Combinations: " + Arrays.deepToString(Poker.player_combinations));

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

        // Terminating conditions
        // Add to result
        if (cardsOnHands.length == 5) {
            String[][] newPlayerCombinations = new String[Poker.player_combinations.length + 1][5];
            for (int i = 0; i < Poker.player_combinations.length; i++) {
                newPlayerCombinations[i] = Poker.player_combinations[i];
            }
            newPlayerCombinations[newPlayerCombinations.length - 1] = cardsOnHands;
            Poker.player_combinations = newPlayerCombinations;
            return;
        }
        // Not a solution
        if (cardsAvailable.length == 0) {
            return;
        }
        if (cardsOnHands.length == 0) {
            for (int i = 0; i <= cardsAvailable.length - 5; i++) {
                String[] cardsToDiscard = new String[i + 1];// { cardsAvailable[i] };
                for (int j = 0; j < i + 1; j++) {
                    cardsToDiscard[j] = cardsAvailable[j];
                }

                String[] handCard = { cardsAvailable[i] };
                possible_hands(discard_cards(cardsAvailable, cardsToDiscard), handCard);
            }
            return;
        } else {
            // The last added card to cardsOnHands
            String lastCard = cardsOnHands[cardsOnHands.length - 1];
            // The card we are checking now
            String checkedCard = cardsAvailable[0];

            // Cards we want to remove from cardsAvailable
            String[] cardToDiscard = { cardsAvailable[0] };

            // Array of new cardsOnHand
            String[] onHand = new String[cardsOnHands.length + 1];
            for (int i = 0; i < cardsOnHands.length; i++) {
                onHand[i] = cardsOnHands[i];
            }
            // Append the card we are checking now to our hand
            onHand[cardsOnHands.length] = cardsAvailable[0];

            // Always call this
            possible_hands(discard_cards(cardsAvailable, cardToDiscard), cardsOnHands);

            boolean allCardsSameColor = true;
            for (int i = 0; i < cardsOnHands.length; i++) {
                if (cardsOnHands[i].charAt(0) != checkedCard.charAt(0)) {
                    allCardsSameColor = false;
                    break;
                }
            }
            // Check for possible flush
            if (allCardsSameColor) {
                possible_hands(discard_cards(cardsAvailable, cardToDiscard), onHand);
                return;
            }

            // Check for row
            String lastCardValue = lastCard.substring(1);
            lastCardValue = lastCardValue.replace("J", "11")
                    .replace("Q", "12")
                    .replace("K", "13")
                    .replace("A", "14");
            int lastCardValueInt = Integer.parseInt(lastCardValue);
            String checkedCardValue = checkedCard.substring(1);
            checkedCardValue = checkedCardValue.replace("J", "11")
                    .replace("Q", "12")
                    .replace("K", "13")
                    .replace("A", "14");
            int checkedCardValueInt = Integer.parseInt(checkedCardValue);

            if (lastCardValueInt == checkedCardValueInt - 1
                    || lastCardValueInt == checkedCardValueInt + 1) {
                possible_hands(discard_cards(cardsAvailable, cardToDiscard), onHand);
                return;
            }
        }

        // Write your code above
    }

    public void possible_hands_opponent(String[] cardsAvailable, String[] cardsOnCommunity, String[] cardsOnHands) {
        // Write your code below

        // Write your code above
    }

}