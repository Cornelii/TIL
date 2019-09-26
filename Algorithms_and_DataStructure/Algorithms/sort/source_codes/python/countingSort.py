L=[6,7,1,2,8,4,42,97,50] # test list
print(L)
max_val=max(L)           # max_value should be known
C=[0]*(max_val+1)       
# including 0 it should be multiplied by max_val+1 to get maximum index of max_val

# making count_list
for num in L:
    C[num]+=1

position=[0]*(max_val+1)
# get accumulative_list
dummy=0
for idx,num in enumerate(C):
    if num!=0:
        position[idx]=num+dummy
        dummy+=num

result=[0]*len(L)
# get sorted result
for num in reversed(L):
    idx=position[num]-1
    position[num] -= 1
    result[idx]=num

print("After counting-sorted")
print(result)