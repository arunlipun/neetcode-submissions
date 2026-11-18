class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
          if (hand.length % groupSize != 0) {
            return false;
        }

        // 2. Count the frequency of each card
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int card : hand) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }

        // 3. Sort the array to always start with the smallest available card
        Arrays.sort(hand);

        // 4. Form groups greedily
        for (int card : hand) {
            // Skip cards that have already been used in previous groups
            if (countMap.get(card) == 0) {
                continue;
            }

            // Try to build a consecutive sequence of length groupSize
            for (int i = 0; i < groupSize; i++) {
                int currentCard = card + i;
                int currentCount = countMap.getOrDefault(currentCard, 0);

                // If the required consecutive card is missing, return false
                if (currentCount == 0) {
                    return false;
                }

                // Use one instance of currentCard
                countMap.put(currentCard, currentCount - 1);
            }
        }

        return true;
        
    }
}
