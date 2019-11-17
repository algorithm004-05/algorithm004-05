class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        p=[]
        for q in matrix:
            p+=q
        i,j=0,len(p)-1
        while i<=j:
                k=(i+j)//2
                if p[k]<target:
                    i=k+1
                elif p[k]>target:
                    j=k-1
                else:
                    return True
        return False


