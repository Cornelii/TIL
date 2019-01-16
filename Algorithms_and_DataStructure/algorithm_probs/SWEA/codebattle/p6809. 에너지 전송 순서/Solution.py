import random

T=1
N=10


with open("test2.txt","w",encoding="utf-8") as f:
    f.write("{}\n".format(T))
    for case in range(T):
        f.write("{}\n".format(N))
        for number in range(N):
            f.write("{} ".format(random.randint(0,4)))
        f.write("\n")