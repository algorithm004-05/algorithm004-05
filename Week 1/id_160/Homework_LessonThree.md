# NO.1
[删除排序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)

解法
```
    class Solution {
    public:
        int removeDuplicates(vector<int> &nums) {
            if (nums.empty()) {
                return 0;
            }
            int i = 0;
            for (int j = 1; j < nums.size(); j++)
            {
                if (nums[j] != nums[i])
                {
                    i++;
                    nums[i] = nums[j];
                }
            }
            return i + 1;
        }
    };
```
# NO.2
[旋转数组](https://leetcode-cn.com/problems/rotate-array/)

解法1:暴力解决,一步一步移动
```
    class Solution {
    public:
        void rotate(vector<int>& nums, int k) {
            if(k>=nums.size())
                k%=nums.size();
            if(k!=0)
            {
                while(k)
                {
                    int temp=nums[nums.size()-1];
                    for(int i=nums.size()-2;i>=0;i--)
                    {
                        nums[i+1]=nums[i];
                    }
                    nums[0]=temp;
                    k--;
                }
            }
        }
    };

```
解法2:
 
- insert() 函数有以下三种用法,这边使用第三种方法:
 1. 在指定位置loc前插入值为val的元素,返回指向这个元素的迭代器,
 2. 在指定位置loc前插入num个值为val的元素,
 3. 在指定位置loc前插入区间[start, end)的所有元素.
 
```
    class Solution {
    public:
        void rotate(vector<int>& nums, int k) {
            int len = nums.size();
            if(len == 0) return;
            
            k %= len;
            
            nums.insert(nums.begin(), nums.end() - k, nums.end()); // 把[nums.end() - k, nums.end())区间的元素插入到首位置
            nums.resize(len);
        }
    };
```
解法3:
- 用一个大小相同得数组存放移动后得正确位置，再写入原数组中
```
    class Solution {
    public:
        void rotate(vector<int>& nums, int k) {
            int length = nums.size();
            int A[length];
            for(int i=0; i<length; i++)
            {
                A[(i+k)%length]=nums[i];   
            }
            for(int j=0; j<length; j++)
            {
                nums[j]=A[j];
            }
            
        }
    };
```
# NO.3
[合并两个有序链表](https://leetcode-cn.com/problems/merge-sorted-array/)

解法1 
```
    class Solution {
    public:
        ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
            ListNode* resultListHead = NULL;
            ListNode* resultListEnd = NULL;
            
            if (l1==NULL)
                return l2;
            if (l2==NULL)
                return l1;       
            if (l1->val < l2->val)
            {
                resultListHead = resultListEnd = l1;
                l1 = l1->next;
            }else
            {
                resultListHead = resultListEnd = l2;
                l2 = l2->next;
            }        
            while(l1 != NULL && l2 != NULL){
                if (l1->val < l2->val)
                {
                    // 将l1这段拼接到结果串中
                    resultListEnd->next = l1;
                    // 如果l1中有一段比l2->val小那就找到l1这段中的最后一个节点，并让结果串指向这个节点
                    while (l1->next!=NULL && l1->next->val < l2->val)
                    {
                        l1 = l1->next;
                    }
                    resultListEnd = l1;     
                    l1 = l1->next;
                }           
                if(l1!=NULL && l2->val <= l1->val)
                {
                    resultListEnd->next = l2;
                    while (l2->next!=NULL && l2->next->val <= l1->val)
                    {
                        l2 = l2->next;
                    }
                    resultListEnd = l2;   
                    l2 = l2->next;
                }           
            }       
            // 拼接较长的那个链剩下的串
            resultListEnd->next = (l1==NULL)? l2 : l1;
            return resultListHead;        
        }
    
    };

```

解法2

- 迭代
```
    class Solution {
    public:
        ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
            ListNode* prehead = new ListNode(-1);
            ListNode* prev = prehead;
            while(l1 != NULL && l2 != NULL) {
                if(l1->val <= l2->val) {
                    prev->next = l1;
                    l1 = l1->next;
                } else {
                    prev->next = l2;
                    l2 = l2->next;
                }
                prev = prev->next;
            }
            prev->next = l1 != NULL ? l1 : l2;
            // return prehead->next;
            ListNode* rstNode = prehead->next;
            delete prehead;
            return rstNode;
        }
    };
```
# NO.4
[两数之和](https://leetcode-cn.com/problems/two-sum/)

解法

```
    class Solution {
    public:
        vector<int> twoSum(vector<int> &nums, int target) {
            int i = 0;
            int j = 0;
            for (int i = 0; i < nums.size(); i++)
            {
                for (int j = i + 1; j < nums.size(); j++)
                {
                    if (nums[j] == target - nums[i])
                    {
                        return {i, j};
                    }
                }
            }
            return {i, j};
        }
    };
```

# NO.5
[移动零](https://leetcode-cn.com/problems/move-zeroes/)

解法

```
    class Solution {
    public:
        void moveZeroes(vector<int>& nums) {
            int j = 0;
            for (int i = 0;i<nums.size();++i) {
                if (nums[i] != 0) {
                    nums[j] = nums[i];
                    if (i != j) {
                        nums[i] = 0;
                    }
                    j++;
                }
            }
        }
    };
```
# NO.6
[加1](https://leetcode-cn.com/problems/plus-one/)
