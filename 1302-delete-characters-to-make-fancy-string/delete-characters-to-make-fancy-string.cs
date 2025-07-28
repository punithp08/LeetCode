public class Solution {
    public string MakeFancyString(string s) {
        if (s.Length < 3) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        sb.Append(s[0]);
        sb.Append(s[1]);

        for (int i = 2; i < s.Length; i++) {
            if (s[i] == sb[sb.Length - 1] && s[i] == sb[sb.Length - 2]) {
                continue;
            } else {
                sb.Append(s[i]);
            }
        }

        return sb.ToString();  
    }
}