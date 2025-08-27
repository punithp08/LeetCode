class Solution {
    public boolean isValid(String word) {
    if (word.length() < 3) {
            return false;
        }

        boolean hasVowel = false;
        boolean hasConsonant = false;

        String vowels = "aeiouAEIOU";

        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                if (vowels.indexOf(c) != -1) {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            } else if (!Character.isDigit(c)) {
                return false;
            }
        }

        return hasVowel && hasConsonant;    
    }
}