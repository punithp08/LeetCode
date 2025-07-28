class Solution {
public:
    int numRabbits(vector<int>& answers) {
     std::map<int, int> counts;
        for (int answer : answers) {
            counts[answer]++;
        }

        int min_rabbits = 0;
        for (auto const& [answer_val, freq] : counts) {
            int group_size = answer_val + 1;
            int num_groups = std::ceil((double)freq / group_size);
            min_rabbits += num_groups * group_size;
        }

        return min_rabbits;    
    }
};