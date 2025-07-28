class Solution {
public:
    string countAndSay(int n) {
      if (n == 1) {
            return "1";
        }

        std::string prev_str = countAndSay(n - 1);
        std::string result = "";
        int count = 1;

        for (int i = 0; i < prev_str.length(); ++i) {
            if (i + 1 < prev_str.length() && prev_str[i] == prev_str[i+1]) {
                count++;
            } else {
                result += std::to_string(count);
                result += prev_str[i];
                count = 1;
            }
        }
        return result;   
    }
};