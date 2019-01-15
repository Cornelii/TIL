## Heap Algorithm
def generate(n,a):
    if n == 1:
        return print(a)
    else:
        for i in range(n-1):
            generate(n-1,a)

            if n%2:
                a[0],a[n-1]=a[n-1],a[0]
            else:
                a[i],a[n-1]=a[n-1],a[i]
        generate(n-1,a)

generate(4,[1,2,3,4])