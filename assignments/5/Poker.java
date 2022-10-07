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
        // String[] cards = { "pK", "c10", "h8", "hQ", "dJ", "c9", "c7", "c6", "c5" };
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

        /*
         * String[] cardsOnCommunity = { "cA", "pQ", "c2", "c5", "p6" };
         * String[] cardsAvailable = { "cA", "cK", "cQ", "cJ", "c10", "c9", "c8", "c7",
         * "c6", "c5", "c3", "c2", "pA", "pK",
         * "pQ", "pJ", "p10", "p9", "p8", "p6", "p5", "p4", "p3", "p2", "hA", "hK",
         * "hQ", "hJ", "h10", "h9", "h8",
         * "h7", "h6", "h5", "h4", "h3", "h2", "dA", "dK", "dQ", "dJ", "d10", "d9",
         * "d8", "d7", "d6", "d5", "d4",
         * "d3", "d2" };
         */

        String[] cardsOnCommunity = { "c2", "c3", "c4" };
        String[] cardsAvailable = { "c2", "c3", "c4", "c5", "c6", "c7" };

        p.possible_hands_opponent(cardsAvailable, cardsOnCommunity, new String[0]);
        // The following call must print the following combinations (order of
        // combinations and/or elements inside the combinations do not matter):
        // "c2", "c3", "c4", "c5", "c6"
        // "c2", "c3", "c4", "c5", "c7"
        // "c2", "c3", "c4", "c6", "c7"
        System.out.println("Opponent Combinations: " + Arrays.deepToString(Poker.opponent_combinations));
        System.out.println("Opponent Combinations length: " + Poker.opponent_combinations.length);
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
        // Everything done
        if (cardsAvailable.length == 0) {
            return;
        }
        if (cardsOnHands.length == 0) {
            for (int i = 0; i <= cardsAvailable.length - 5; i++) {
                String[] cardsToDiscard = new String[i + 1];
                for (int j = 0; j < i + 1; j++) {
                    cardsToDiscard[j] = cardsAvailable[j];
                }

                String[] handCard = { cardsAvailable[i] };
                possible_hands(discard_cards(cardsAvailable, cardsToDiscard), handCard);
            }
            return;
        } else {
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
            possible_hands(discard_cards(cardsAvailable, cardToDiscard), onHand);
            possible_hands(discard_cards(cardsAvailable, cardToDiscard), cardsOnHands);
        }

        // Write your code above
    }

    public String[][] Nchoose3(String[] arr) {
        int i = 0;
        int j = 1;
        int k = 2;

        int nFactorial = 1;
        int kFactorial = 1;
        for (int l = arr.length; l > 3; l--) {
            nFactorial *= l;
        }
        for (int l = arr.length - 3; l > 0; l--) {
            kFactorial *= l;
        }

        int nChooseK = nFactorial / kFactorial;

        String[][] result = new String[nChooseK][3];

        int counter = 0;
        while (i < arr.length - 2) {
            while (j < arr.length - 1) {
                while (k < arr.length) {
                    String[] temp = new String[3];
                    temp[0] = arr[i];
                    temp[1] = arr[j];
                    temp[2] = arr[k];
                    result[counter] = temp;
                    counter++;
                    k++;
                }
                j++;
                k = j + 1;
            }
            i++;
            j = i + 1;
            k = j + 1;
        }

        return result;
    }

    public String[][] Nchoose4(String[] arr) {
        int i = 0;
        int j = 1;
        int k = 2;
        int m = 3;

        int nFactorial = 1;
        int kFactorial = 1;
        for (int l = arr.length; l > 4; l--) {
            nFactorial *= l;
        }
        for (int l = arr.length - 4; l > 0; l--) {
            kFactorial *= l;
        }

        int nChooseK = nFactorial / kFactorial;

        String[][] result = new String[nChooseK][3];

        int counter = 0;
        while (i < arr.length - 3) {
            while (j < arr.length - 2) {
                while (k < arr.length - 1) {
                    while (m < arr.length) {
                        String[] temp = new String[4];
                        temp[0] = arr[i];
                        temp[1] = arr[j];
                        temp[2] = arr[k];
                        temp[3] = arr[m];
                        result[counter] = temp;
                        counter++;
                        m++;
                    }
                    k++;
                    m = k + 1;
                }
                j++;
                k = j + 1;
                m = k + 1;
            }
            i++;
            j = i + 1;
            k = j + 1;
            m = k + 1;
        }

        return result;
    }

    public void possible_hands_opponent(String[] cardsAvailable, String[] cardsOnCommunity, String[] cardsOnHands) {
        // Write your code below

        cardsAvailable = discard_cards(cardsAvailable, cardsOnCommunity);

        // Add to result
        if (cardsOnHands.length == 5) {
            String[][] newPlayerCombinations = new String[Poker.opponent_combinations.length + 1][5];
            for (int i = 0; i < Poker.opponent_combinations.length; i++) {
                newPlayerCombinations[i] = Poker.opponent_combinations[i];
            }
            newPlayerCombinations[newPlayerCombinations.length - 1] = cardsOnHands;

            Poker.opponent_combinations = newPlayerCombinations;
            return;
        }
        // Everything done
        if (cardsAvailable.length == 0) {
            return;
        }
        if (cardsOnHands.length == 0) {
            String[][] allCombinations3 = Nchoose3(cardsOnCommunity);
            String[][] allCombinations4 = Nchoose4(cardsOnCommunity);
            String[][] allCombinations5 = new String[0][3];
            if (cardsOnCommunity.length == 5) {
                allCombinations5 = new String[1][3];
                allCombinations5[0] = cardsOnCommunity;
            }

            for (int i = 0; i < allCombinations3.length; i++) {
                possible_hands_opponent(cardsAvailable, cardsOnCommunity, allCombinations3[i]);
            }
            if (cardsOnCommunity.length == 3)
                return;
            for (int i = 0; i < allCombinations4.length; i++) {
                possible_hands_opponent(cardsAvailable, cardsOnCommunity, allCombinations4[i]);
            }
            if (cardsOnCommunity.length == 4)
                return;

            for (int i = 0; i < allCombinations5.length; i++) {
                possible_hands_opponent(cardsAvailable, cardsOnCommunity, allCombinations5[i]);
            }

            return;
        } else {
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
            possible_hands_opponent(discard_cards(cardsAvailable, cardToDiscard), cardsOnCommunity, onHand);
            possible_hands_opponent(discard_cards(cardsAvailable, cardToDiscard), cardsOnCommunity, cardsOnHands);
        }
        // Write your code above
    }

}