# C language

Basic Form
```c
#include <stdio.h>

int main(){
    printf("Hello World!");
}
```

## I. Basics
#### 1. stdandard input and output (printf and scanf)
```c
printf("%d %c %f %ld \n", 1, 'a', '5,4', '52', );

int a;
scanf("%d", &a);

float b;
scanf("%f", &b);

char c;
scanf("%c", %c);

int x=0, y=1, z=2;
scanf("%d %d %d",&x, &y, &z);
```

#### 2. Data types
* Integer

|Data type|Size|Range|
|---|---|---|
|short|2 bytes|$-2^{15}(-32768) \text{  to  } 2^{15}-1(32767)$|
|unsigned short|2 bytes|$0 \text{  to  } 2^{31}-1 (65535)$|
|int|4 bytes|$-2^{31} \text{(2.1billion)   to  } 2^{31}-1 (65535)$|
|unsigned int|4 bytes|$0 \text{   to  } 2^{31}-1 (4.2billion)$|
|long|4 bytes|$-2^{31} \text{(2.1billion)   to  } 2^{31}-1 (65535)$|
|unsigned long|4 bytes|$0 \text{   to  } 2^{31}-1 (4.2billion)$|
?!
|Data type|Size|Range|
|---|---|---|
|float|4 bytes|$-3.4*10^{38} \text{  to  } 3.4*10^{38}$|
|double|8 bytes|$-1.79*10^{308} \text{  to  } 1.79*10^{308}$|

one character
|Data type|Size|Range|
|---|---|---|
|char|1 bytes|$-128 \text{to} 127$|
|unsigned char|1 bytes|$0 \text{  to  } 255$|


**ASCII Code**
|ASCII code|Decimal|hex|
|---|---|---|
|0 ~ 9|48 ~ 59|0x30 ~ 0x39|
|A ~ Z|65 ~ 90|0x41 ~ 0x5A|
|a ~ z|97 ~ 122|0x61 ~ 0x7A|

**Remarks** String in C is nothing but array with ends of `\0` (null character)
**Remarks** Explicit Type conversion ex) `(float)var_a`

#### 3. Operators
##### i. Arithmetic Operators
* =, +, -, *, /, %
* +=, -=, /=, %=, ++, -- (++a, a++, --a, a--)

**Remarks** Difference between ++a & a++
```c
int b
int a
a = 10
b = a++  //a first, then ++
// b = 10, a = 11
```

##### ii. Relational Operators
* ==, >, <, <=, >=, !=

##### iii. Logical Operators
* &&, ||, ! (not)

##### iv. Bit Operators
&, |, ^ (xor), ~ (bit not), <<, >>

#### 4. Conditional Statements
```c
#include <stdio.h>

void main(){
    int a = 99;
    
    if (a<100){
        printf("Yes");
    }// with braces
    
    if(a>=100)
        printf("No"); // If it has one line, brace can be ommited.

    if(){

    }else{

    }

    if(){
        if(){

        }
    }
    
    if(){

    }else if(){

    }else{

    }
}
```
**Switch Statement**
```c
switch(var_a){
    case 1:
        //statements1 when var_a == 1
        break;
    case 2:
        //statements1 when var_a == 2
        break;
    default:
        //statements1 when var_a != 1 && var_a != 2
        break;
}
```
#### 5. Loop
`for` and `while`

**for**
```c
#include <stdio.h>

void main(){
    for(int i=0; i < 5; i++){
        //Statement.
    }

    for(;;){ // infinite loop

    }
}
```
**while**
```c
while(/*conditional Statments*/){
    
    // base treatment.
}
// When you use while, you always have to care about infinite loop.

// Do while
do{

}while()


// etc 
break;
continue;
return;
goto a;
a:
    statements;
```

#### 6. Array
**array declaration**
```c
#include <stdio.h>

void main(){
    int a[100];
    int b[4] = {42, 645, 75,15};
    int c[6] = {42,13,1,5   };   // automatically others are filled with zero.
    int d[67] = {0};

    // To know size of array!

    int size;
    size = sizeof(a)/sizeof(int);


    //array and string
    char m[10] = {'C', '_', 'B','a','s','i','c','s','\0'}
    char s[10] = "C_Basics";
    char ss[] = "Oh yeah!"

    // string funtions
    #include <string.h>
    strlen(); // return length of string except  null character.
    strcpy(a,b); // copy b into a
    strcat(a,b);  // concatenate a + b into a 
    strcmp(a,b);  // 0 if a and b are the same, else some integers.

    gets();  // usefull for string, get input until get Enter.
    puts();  // This is also useful for string as well. print string with \n


    // 2d array
    int aa[4][5];
    int bb[3][3] = {
        {5, 6, 7},
        {1, 6, 7},
        {1, 56, 7}
    }

}
```

#### 7. Array & Pointer
```c
#include <stdio.h>

void main(){
    int a = 100;
    printf("address of a: %d", &a); // print address of a

    int aa[2][2] = {
        {1, 5},
        {6, 3}
    } ;
    
    printf("address of a: %d", aa); // print address of aa
    !! Remarks: out of &.


    int b[6] = {1,5,6,2,7,8};
    // &b[0] = b+0
    // &b[1] = b+1
    // &b[j] = b+j

    char ch;
    char *p;

    ch = 'a';
    p = &ch;  // point is a box to include address.
    printf("%c",*p);   // * before pointer means value it points.

    //Remarks
    char* p;  == char *p;
    //However, these are different.
    char* p, q;  // char* p; and char* q;
    char *p, q; // char* p; and char q
    // Pointer always take 4bytes regardless of data type it points.
}
```

#### 8. Function
structure of function
```c
{type of result} {function name}({parmter type parameter name1}, {p2}...){
    statement1;
    statement2;
    return result;
}
//ex)
int check(int a, float b){
    return a/b;
}

    // local and global variables in C
    // local variables: variables in {}
    // global variables: variables at out of {}

    // no return case: void
void check2(int a, float b){
    printf("%f", a/b);
}

```

#### 9. Standard Input & Output
standard input functions: scanf(), gets(), getchar()
standard output functions: printf(), puts(), putchar()



#### 10. Dynamic memory assign

#### 11. Struct and enum?!

#### 12. Etc