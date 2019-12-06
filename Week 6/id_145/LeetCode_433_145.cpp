class Solution {
public:
    int minMutation(string start, string end, vector<string>& bank) {
        if(start.length() != 8 || end.length() != 8 || bank.empty()) {
            return -1;
        }
        
        if (find(bank.begin(), bank.end(), end) == bank.end()) {
            return -1;
        }
        
        deque<string> que;
        que.push_back(start);
        int step = 0;
        vector<int> visited(bank.size(), 0);
        while(!que.empty()) {
            ++step;
            int size = que.size();
            for (int i=0; i<size; ++i) {
                string top = que.front();
                que.pop_front();
                for (int j=0; j<bank.size(); ++j) {
                    if (visited[j]) continue;
                    string current_bank = bank[j];
                    int diff = 0;
                    for (int k=0; k<current_bank.length(); ++k) {
                        if (top[k] != current_bank[k]) {
                            ++diff;
                        }
                    }
                    
                    if (diff == 1) {
                        visited[j] = 1;
                        if (current_bank == end) return step;
                        que.push_back(current_bank);
                    }
                }
                
            }
            
        }
        
        return -1;
        
        
    }
};




