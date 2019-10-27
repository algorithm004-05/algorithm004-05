#!/anaconda3/bin/python

class Solution:

    """
    不是自己写的呦
    """
    def equationsPossible(self, equations: 'List[str]') -> 'bool':
        self.data = {i:i for i in [chr(ord('a')+j) for j in range(26)]}
        neq = []
        for a,op,_,b in equations:
            if op == '=':
                self.union(a,b)
            else:
                neq.append((a,b))
        return all(self.find(a) != self.find(b) for a,b in neq)

    def find(self,i):
        if self.data[i] != i:
            self.data[i] = self.find(self.data[i])
        return self.data[i]

    def union(self,a,b):
        n = self.find(a)
        self.data[n] = self.find(b)

if __name__ == '__main__':
    print(Solution().equationsPossible(["b==a","a==b"]))
