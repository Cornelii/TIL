def generate(n,A):
    if n==1:
        return print(A)
    else:
        for idx in range(0,n-1):
            generate(n-1,A)
            if n%2:
                A[0],A[n-1]=A[n-1],A[0]
            else:
                A[idx],A[n-1]=A[n-1],A[idx]
        generate(n-1,A)


A=[4,1,2,3]

generate(len(A),A)