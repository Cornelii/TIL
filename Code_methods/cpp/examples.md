# CPP examples

## Boost up cin
```cpp
ios_base::sync_with_stdio(0); cin.tie(0);
```

## queue
```cpp
#include <queue>
// Queue
queue<int> q;
q.push(5);
q.pop();
q.front();
q.empty();
q.size();
```

## vector
```cpp
#include <vector>
// Vector
struct EDGE {
	int x, w;
	EDGE() {};
	EDGE(int x, int w) : x(x), w(w) {};
};
vector<EDGE> v[5];
v[2].clear();
v[3].push_back(EDGE(y, z));
v[2].begin();
v[2].end();
//// set initial size of vector with n
vector<int> v2(n);

//// set initial size of vector with n initializing with value val
vector<int> v3(n, val);
```

## stack
```cpp
#include <stack>

// Stack
stack<int> st;
st.push(4);
st.pop();
st.top();
st.empty();
st.size();
```

## deque
dynamic array. This guarantee O(1) in access, adding first and last elements.
```cpp
#include <deque>

deque<int> dq;
dq.push_front(5);
dq.push_back(5);
dq.pop_front();
dq.pop_back();

// other things are the same as the ones of vector
```

## set
```cpp
#include <set>

set<int> s;
s.insert(5);

// If 6 exists in s, it return address of it, otherwise, if return s.end();
s.find(6);
s.end(); // s.end()

s.size();
s.clear();
// erase second element, erasing by address
s.erase(++s.begin());
```

## pair
A data type to store two data.
When operate comparing, first is frist, second is second.
```cpp
#include <utility>

pair<int, int> p;
p = make_pair(4, 5);

//from c++ 11
p = {4, 5};
p.first;
p.second;
```

## map
dictionary. insert, remove, search in O(logN) => map by Tree
```cpp
#include <map>

map<int, int> m;
// key => int, data => int
m.insert(make_pair(4, 5));
m[4] = 5;

// address of pair?!
m.find(4) -> second
m.size();

// number of data related to the specific key.
m.count(4);
```


# bits/stdc++ header
```cpp

// C 
#ifndef _GLIBCXX_NO_ASSERT
#include <cassert>
#endif 
#include <cctype> 
#include <cerrno>
#include <cfloat>
#include <ciso646> 
#include <climits> 
#include <clocale> 
#include <cmath>
#include <csetjmp> 
#include <csignal> 
#include <cstdarg> 
#include <cstddef> 
#include <cstdio> 
#include <cstdlib> 
#include <cstring> 
#include <ctime> 

#if __cplusplus >= 201103L 
#include <ccomplex> 
#include <cfenv> 
#include <cinttypes> 
#include <cstdalign>
#include <cstdbool>  
#include <cstdint> 
#include <ctgmath> 
#include <cwchar> 
#include <cwctype> 
#endif


// c++
#include <algorithm> 
#include <bitset> 
#include <complex> 
#include <deque> 
#include <exception> 
#include <fstream> 
#include <functional> 
#include <iomanip> 
#include <ios> 
#include <iosfwd> 
#include <iostream> 
#include <istream> 
#include <iterator> 
#include <limits> 
#include <list> 
#include <locale> 
#include <map> 
#include <memory> 
#include <new> 
#include <numeric> 
#include <ostream> 
#include <queue> 
#include <set>
 #include <sstream> 
#include <stack>
 #include <stdexcept> 
#include <streambuf> 
#include <string> 
#include <typeinfo>
#include <utility> 
#include <valarray> 
#include <vector> 

#if __cplusplus >= 201103L 
#include <array> 
#include <atomic> 
#include <chrono> 
#include <condition_variable> 
#include <forward_list> 
#include <future> 
#include <initializer_list>
#include <mutex> 
#include <random> 
#include <ratio> 
#include <regex> 
#include <scoped_allocator> 
#include <system_error> 
#include <thread> 
#include <tuple> 
#include <typeindex>
 #include <type_traits>
 #include <unordered_map> 
 #include <unordered_set> 
#endif
```
