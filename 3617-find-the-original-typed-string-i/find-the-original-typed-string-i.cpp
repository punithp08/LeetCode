class Solution {
public:
    int possibleStringCount(string word) {
     int n = word.length();
        if (n == 0) {
            return 0;
        }

        int count = 1;

        int i = 0;
        while (i < n) {
            char current_char = word[i];
            int j = i;
            while (j < n && word[j] == current_char) {
                j++;
            }
            
            int block_length = j - i;
            
            if (block_length > 1) {
                count += (block_length - 1);
            }
            
            i = j;
        }
        
        return count;   
    }
};