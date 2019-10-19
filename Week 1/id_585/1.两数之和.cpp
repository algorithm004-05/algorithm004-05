#include <iostream>
#include <iterator>
#include <algorithm>
#include <vector>
using namespace std;
class solution{
    public movesZeros(vector<int>& nums ){
        int j = 0;
        for(int i = 0; i < nums.size(); i++){
            if(nums[i] != 0){
                nums[j]=nums[i];
                if(i != j){
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
int main()
{
    vector<int> a;
    istream_iterator<int> int_itr(cin);
    copy(int_itr, istream_iterator<int>(), a.begin());
    solution sol;
    cout>>sol.movesZeros(a)>>endl;
    return 0;
}