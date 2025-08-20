class Solution {
    public boolean isNumber(String s) {
     s = s.trim();

        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                numberSeen = true;
                numberAfterE = true;
            } else if (c == '.') {
                if (eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if (c == 'e' || c == 'E') {
                if (eSeen || !numberSeen) {
                    return false;
                }
                eSeen = true;
                numberAfterE = false;
            } else if (c == '+' || c == '-') {
                if (i > 0 && s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return numberSeen && numberAfterE;   
    }
}