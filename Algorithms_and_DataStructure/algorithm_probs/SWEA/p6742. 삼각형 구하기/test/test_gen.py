import numpy as np
import os
print(os.getcwd())
try:
    num_case=int(input("number of case: "))
except:
    num_case=3

N_lower_bound=3
N_upper_bound=2000

try:
    num_each=[int(jmi) for jmi in input("number of each case in the form of tuple: ").split(" ")]
except:
    num_each=np.random.randint(N_lower_bound,N_upper_bound,3)

try:
    len(num_each)
except:
    num_each=[num_each]

print(num_case,type(num_case))
print(num_each,type(num_each))


A_lower_bound=1
A_upper_bound=4e+12
point_lower_bound=-1e+6
point_upper_bound=1e+6
with open("test_.txt","w",encoding="utf-8") as f:
    f.write(str(num_case)+"\n")
    for idx,case in enumerate(num_each):
        A_candidate=np.random.randint(A_lower_bound,A_upper_bound-1,1,dtype=np.int64)[0]
        B_candidate=np.random.randint(A_candidate,A_upper_bound,1,dtype=np.int64)[0]
        points=np.random.randint(point_lower_bound,point_upper_bound,size=(case,2))
        f.write("{} {} {}\n".format(case,A_candidate,B_candidate))
        for ps in points:
            f.write("{} {}\n".format(ps[0],ps[1]))
        
