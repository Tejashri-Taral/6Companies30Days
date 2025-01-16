class Solution {
    public int numFriendRequests(int[] ages) {
        // Initialize a frequency array for ages between 1 and 120
        int[] ageCount = new int[121];
        
        // Populate the frequency array with the number of people of each age
        for (int age : ages) {
            ageCount[age]++;
        }

        int totalRequests = 0;

        // Iterate through each age x from 1 to 120
        for (int x = 1; x <= 120; x++) {
            if (ageCount[x] == 0) continue; // No people with this age

            // For each person with age x, calculate valid requests to people with age y
            for (int y = 1; y <= 120; y++) {
                if (ageCount[y] == 0) continue; // No people with this age

                // Check the three conditions under which x won't send a friend request to y
                if (y <= 0.5 * x + 7) continue; // Condition 1
                if (y > x) continue; // Condition 2
                if (y > 100 && x < 100) continue; // Condition 3

                // Calculate how many requests are made from age x to age y
                if (x == y) {
                    // If x == y, we don't send a request to oneself, so count the self-pairs properly
                    totalRequests += ageCount[x] * (ageCount[x] - 1); // x cannot send a request to themselves
                } else {
                    // Otherwise, valid requests are the product of the counts of people with age x and y
                    totalRequests += ageCount[x] * ageCount[y];
                }
            }
        }

        return totalRequests;
    }
}
