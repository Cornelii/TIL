# Bit Operations

## I. Basics in Bit Operations
#### 1. Bit Operations
1. AND: &
2. OR: |
3. XOR: ^
4. REVERSE: ~
5. left shift: <<
6. right shift: >>

#### 2. Some operations used frequently
`1 << n` : $2^n$
`i & (1<<j)`: to check `j`th bit of `i` is 1 or not

#### 3. Bitprint example
print bit of `i` on 8-bit binary field.
```python
def BitPrint(i):
    for j in range(7, -1, -1):
        print('1' if (i&(1<<j)) else '0', end='')     
```
#### 4. 4byte bit reader
```python
def BitPrint4(i):
    for j in range(24,-1,-8):
        BitPrint(i>>j)
        print(end=" ")
```


## II. Endianness

Endian is a way to arange sequential data into 1-D space. It varies with HW architectures.

**This is important, especially, in transforming byte and word unit**
#### 1. Big-endian
Generally, Larger units comes first
* Network

#### 2. Little-endian
Smaller units comes first
* Almost desktop computer

example
|kind|0x1234|0x12345678|
|---|---|---|
|Big endian|12 34|12 34 56 78|
|Little endian|34 12|78 56 34 12|

#### 3. Endian Check
code to check which endian a computer use.
```python
n = 0x00111111

if n & 0x11:
    print("little endian")   
    # for little endian n => 11 11 11 00
    # n & 0x11: 17
else: 
    print("big endian")
    # for big endian n => 00 11 11 11
    # n & 0x11 => 0
```
## III. Number in Computer

#### 1. Integer


#### 2. Real Number
* Floating-point (부동 소수점)


sign part /  exponent / mantissa

1. 32bit
sign part 1 / exponent 8 / mantissa 23

2. 64bit (python float)
sign part 1 / exponent 11 / mantissa 52

**make 32bit mantissa part**
example
1001.0011
=>  point shift to make interger part 1
0001.0010011
=> make 23bit under point 
0001.00100110000000000000000
=> only store 23bit part under point
00100110000000000000000 (mantissa)

save the number of shifting into the exponent part.

**make 32bit exponent part**
*Excess expressive method*
Divide exponent part to two half parts that are for 
negative exponent and positive exponent.
* Exponent part takes 8bits.
* => 127(10) = 0 (excess)

example
|excess|binary|decimal|
|128|11111111|255|
|127|11111110|254|
|2|10000001|129|
|1|10000000|128|
|0|01111111|127|
|-1|01111110|126|
|-126|00000001|1|
|-127|00000000|0|

effective number for real number in computer
1. 32bit: 6
2. 64bit: 15