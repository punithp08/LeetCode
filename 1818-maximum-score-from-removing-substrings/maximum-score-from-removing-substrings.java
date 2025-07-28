class Solution {
    public int maximumGain(String s, int x, int y) {
         int totalScore = 0;
        String highPriorityPair;
        String lowPriorityPair;
        int highPriorityScore;
        int lowPriorityScore;

        // Determine which pair has higher priority based on points
        if (x > y) {
            highPriorityPair = "ab";
            lowPriorityPair = "ba";
            highPriorityScore = x;
            lowPriorityScore = y;
        } else {
            highPriorityPair = "ba";
            lowPriorityPair = "ab";
            highPriorityScore = y;
            lowPriorityScore = x;
        }

        // First pass: Remove high-priority pairs
        // We use a stack to efficiently build the new string while removing pairs.
        StringBuilder sb1 = new StringBuilder();
        for (char c : s.toCharArray()) {
            // If the current character forms a high-priority pair with the top of the stack
            if (c == highPriorityPair.charAt(1) && sb1.length() > 0 && sb1.charAt(sb1.length() - 1) == highPriorityPair.charAt(0)) {
                sb1.deleteCharAt(sb1.length() - 1); // Remove the matching character from the stack
                totalScore += highPriorityScore;    // Add points
            } else {
                sb1.append(c); // Otherwise, push the character onto the stack
            }
        }

        // Second pass: Remove low-priority pairs from the remaining string
        StringBuilder sb2 = new StringBuilder();
        for (char c : sb1.toString().toCharArray()) {
            // If the current character forms a low-priority pair with the top of the stack
            if (c == lowPriorityPair.charAt(1) && sb2.length() > 0 && sb2.charAt(sb2.length() - 1) == lowPriorityPair.charAt(0)) {
                sb2.deleteCharAt(sb2.length() - 1); // Remove the matching character from the stack
                totalScore += lowPriorityScore;     // Add points
            } else {
                sb2.append(c); // Otherwise, push the character onto the stack
            }
        }

        return totalScore;

    }
}