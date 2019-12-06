
def countingSot(arr):
    _max =  max(arr) +1
    tmp = [0]*_max
    for v in arr:
        tmp[v]+=1
    index = 0
    #print(arr)
   #print(tmp)
    for j, v in enumerate(tmp):
        if v != 0:
            for i in range(v):
                #print(index)
                arr[index] = j
                index+=1
    return arr


a = [2,3,1,4,1,2,3,4,5,6,7,6,6,5,4,8,4,1,4,2,3,3,9]
print(countingSot(a))

