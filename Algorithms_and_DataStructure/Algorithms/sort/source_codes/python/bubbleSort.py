L=[6,7,1,2,8,4,42,97,50] #test list
print(L)
for i in range(len(L)-1):                
    for j in range(len(L)-1-i):       # two for-loops => O(n^2)
        if L[j]>L[j+1]:
            L[j],L[j+1]=L[j+1],L[j] # Swap
print("after bubble-sorted")
print(L)
