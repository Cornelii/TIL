# String and Pattern matching

# String Basic
## ASCII code
7bit encoding.

It is composed of 
**control latters of 33, and printable letters of 95**

## Unicode
Standard code 
for  network between nations.

1. CharacterSet
* UCS-2
* UCS-4
(Not standardized in bytes)

2. Unicoide encoding (external encoding )UTF: Unicode Transformation Format
* UTF-8
* UTF-16
* UTF-32

3. Python's basic encoding
   **UTF-8**
for the python2
`#-*-coding:utf-8-*-`
was needed.(basically ASCII)

## Classfication of String
1. Fixed length
2. Variable length
   * length controlled: Java
   * Delimited: C


## String Process in each language
1. C
* Array, always need "\0" at the end.
* Operaters are offered for string processing such as strlen(), strcpy(), strcmp(), ...
* ASCII
```C
char*name="홍길동";
int count=strlen(name);
printf("%d",count)
//6
```
* str to num
atoi() and itoa()


1. Java
* Class, no need null char
* Operaters are given in the form of methods such as +, length(), replace(), split(), substring().
* UTF16 ,2bytes
``` java
String name="홍길동";
System.out.println(name.length())
//3

```
* str to num
Integer.parseInt(String)
toString()


3. Python
* String as Sequence data type 
* No char type.
* many operators like +,*, replace(),split(),find(), etc...
* Immutable.
* UTF8, 1byte
```python
name="홍길동"
print(len(name))
#3
```
* str to num
int(),float(),str(),repr()



# Pattern matching

## 1. Brute force
One by one comparison
If it does not coincides, one step forward and again.

PseudoCode
```PseudoCode
FUNCTION bruteforce(String p, String t)
    i = 0 // index of t
    j = 0 // index of p
    M = len(p)
    N = len(t)

    WHILE j < M and i < N THEN
        IF t[i] != p[j] THEN
            i = i-j
            j = -1
        i = i + 1
        j = j + 1
        ENDIF
    ENDWHILE
    IF j == M THEN
        RETURN i-M // matching succeed
    ELSE
        RETURN -1 // matching fail
    ENDIF
```
time complexity: O(MN)

## 2. KMP algorithm (Knuth-Morris-Pratt algorithm)
Remeber where to go. not one step forward



time complexity  O(M+N)

## 3. Boyer-Moore Algorithm
1. Make skip table
2. compare last word.
3. If last word coincides, compare them one by one from right to left
4. If they does not coincides, look for the last word in skip table.
5. If the number exists in skip table. Skip amount of given
6. If not, Skip length of string

**PseudoCode**
```pseudoCode
FUNCTION boyer_moore(p:string, t:target-string):
    N = len(p)
    M = len(t)

    skip_table
    // key - value matching
    // from last 0,1,2,3,4 ...

    index = M-1

    WHILE index < N
        FOR i M-1 -> 0
            IF t[i] != p[index-i] THEN
                skip_idx = GET from skip_table
                IF skip_idx != None THEN
                    index += skip_idx
                ELSE 
                    index += M
                BREAK
                ENDIF
            ELSE
                IF i == M-1 THEN
                    RETURN index-M+1
                ENDIF
            ENDIF
        ENDFOR
    ENDWHILE
    RETURN -1

```

**Python Code**
```python
def boyer_moore(p,t):
    N = len(p)
    M = len(t)
    # skip_table
    skip_table = {}
    for i, char in enumerate(t[:-1]):
        skip_table.update({char: M-1-i})
    # for the repetitive key problem

    idx = M-1
    while idx < N:
        for i, char in enumerate(reversed(t)):
            if char != p[idx-i]:
                skip_idx = skip_table.get(p[idx-i])
                if skip_idx:
                    idx += skip_idx-i
                else:
                    idx += M
                break
            else:
                if i == M-1:
                    return idx-M+1
    return -1
```




## 4. Kalp-Rabin Algorithm
Using Hash?!    
