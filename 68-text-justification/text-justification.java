class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
     List<String> result = new ArrayList<>();
        int n = words.length;
        int i = 0;

        while (i < n) {
            int lineStart = i;
            int lineLength = words[i].length();
            i++;

            while (i < n && lineLength + 1 + words[i].length() <= maxWidth) {
                lineLength += 1 + words[i].length();
                i++;
            }

            int wordsOnLine = i - lineStart;
            int totalSpaces = maxWidth - (lineLength - (wordsOnLine - 1));

            StringBuilder line = new StringBuilder();

            if (i == n || wordsOnLine == 1) {
                line.append(words[lineStart]);
                for (int j = lineStart + 1; j < i; j++) {
                    line.append(" ").append(words[j]);
                }
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {
                int baseSpaces = totalSpaces / (wordsOnLine - 1);
                int extraSpaces = totalSpaces % (wordsOnLine - 1);
                
                line.append(words[lineStart]);
                for (int j = 1; j < wordsOnLine; j++) {
                    for (int k = 0; k < baseSpaces; k++) {
                        line.append(" ");
                    }
                    if (extraSpaces > 0) {
                        line.append(" ");
                        extraSpaces--;
                    }
                    line.append(words[lineStart + j]);
                }
            }
            result.add(line.toString());
        }

        return result;   
    }
}