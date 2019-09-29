# fast IO for cpp

## At cpp17
example Floyd-Warshall

```cpp
#pragma GCC optimize("Ofast")
#pragma GCC target("arch=skylake")
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <algorithm>
using namespace std;

int z[101][101];

namespace fio {
    const int BSIZE = 524288;
    char buffer[BSIZE + 1];
    int p = BSIZE;
    inline char readChar() {
        if(p == BSIZE) {
            buffer[syscall(0x00, 0, buffer, BSIZE)] = '\n';
            p = 0;
        }
        return buffer[p++];
    }
    int readInt() {
        char c = readChar();
        while (c < '0') {
            c = readChar();
        }
        unsigned ret = 0;
        do {
            ret = ret * 10 + c - '0';
            c = readChar();
        } while (c >= '0');
        return ret;
    }
}

char buf[1000000];

int main()
{
	int n, m;
    n = fio::readInt(); m = fio::readInt();
	for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) z[i][j] = 1e9;
	for (int i = 0; i < n; i++) z[i][i] = 0;
	for (int i = 0; i < m; i++)
	{
		int a, b, c;
        a = fio::readInt();
        b = fio::readInt();
        c = fio::readInt();
		if (z[a - 1][b - 1] > c)
			z[a - 1][b - 1] = c;
	}
    
	for (int k = 0; k < n; k++)
    {
		for (int i = 0; i < n; i++)
        {
            int res[101];
            int R = z[i][k];
			for (int j = 0; j < n; j++) res[j] = z[k][j] + R;
            for (int j = 0; j < n; j++) z[i][j] = min(z[i][j], res[j]);
        }
    }

    char *Z = buf + 999999;
    *Z-- = '\n';
    
    for (int b = n - 1; b >= 0; b--)
    {
        for (int a = n - 1; a >= 0; a--)
        {
            int K = z[b][a];
            if (K >= (int)1e9) K = 0;
            do
            {
                *Z-- = K % 10 + '0';
                K /= 10;
            } while (K);
            *Z-- = a ? ' ' : '\n';
        }
    }
    ++Z;
    syscall(0x01, 1, Z + 1, buf + 999999 - Z);
    _Exit(0);
}
```

