def boyer_moore(p,t):
    N = len(p)
    M = len(t)
    # skip_table
    skip_table = {}
    for i, char in enumerate(reversed(t)):
        skip_table.update({char: i})

    idx = M-1
    while idx < N:
        for i, char in enumerate(reversed(t)):
            if char != p[idx-i]:
                skip_idx = skip_table.get(p[idx-i])
                if skip_idx:
                    idx += skip_idx
                else:
                    idx += M
                break
            else:
                if i == M-1:
                    return idx-M+1
    return -1

def string_count(p, t):
    count = 0
    tmp = 0
    M = len(t)

    while tmp > -1:
        tmp = boyer_moore(p, t)
        if tmp != -1:
            count += 1
            p = p[tmp+M-1:]

    return count