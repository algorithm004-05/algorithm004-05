class Solution {
public:
    vector<int> plusOne1(vector<int>& digits) {
        int n = 1;
        for (int p = digits.size()-1;p>=0;p--) {
            if (n==0) {
                break;
            }
            n = digits[p] + n;
            digits[p] = n%10;
            n /= 10;
        }
        if (n!=0) {
           digits.insert(digits.begin(), n);
        }
        return digits;
    }
        vector<int> plusOne(vector<int>& digits) {
        for (int i = (int)digits.size() - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            }
            else {
                digits[i]++;
                break;
            }
        }
        if (digits[0] == 0) {
            digits.push_back(0);
            digits[0] = 1;
        }
        return digits;
    }
};
