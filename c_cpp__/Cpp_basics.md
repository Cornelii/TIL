# C++


## I. Basics

#### 1. Standard input and output

```cpp
#include <iostream>

using namespace std;

int main(){
    int a;
    float b = 547.5f; // float
    float d = 547.5; // double
    cout << "Hello World" << endl;
    cin >> a;
    
    return 0;   
}
```

#### 2. Data Types

##### i. Simple Data Types
| Type   | Capacity | Range |
| ------ | -------- | ---- |
| char   | 1 byte   |-128 ~ 127|
| bool   | 1 byte   |true / false|
| short  | 2 byte   |-32768 ~ 32767|
| int    | 4 byte   |약 -22억 ~ 21억|
| float  | 4 byte   ||
| double | 8 byte   ||


##### ii. Structured Data Type

##### iii. Pointer

#### 3. Operators

##### i. Arithmetic Operators

`+,-, *, /, % `

##### ii. Relational Operators

`>, >=, <, <=, ==, !=  `

##### iii. Logical Operators

`&&, ||, !`

##### iv. Bit Operators

`&, |, <<, >>, ^, ~`


`const` keyword to fix data throughout program execution

#### 4. I/O

```cpp
# include <iostream>

using namespace std;

int main(){

    char a, b;
    int c;
    double d;
    
    // cout & cin
    cout << "Hey, you. write in numbers" << endl;
    cin >> a >> b >> c >> d;
    
    // cin.get() for only one character.
    cin.get(a);

    // cin.ignore() to skip characters in a line before meeting the specific character.
    cin.ignore(100,  '.');

    // cin.putback(ch) istreamVar.putback(ch) : istreamVar: input stream variable like cin


    // cin.peek() istreamVar.peek() : istreamVar: input stream variable like cin

    // istreamVar.clear();
    cin.clear(); 
    cin.ignore(200, '\n'); // To remove garbage from the input stream.

    return 0;
}

```

##### i. formatting output
`setprecision, fixed, showpoint, setw`

```cpp
#include <iomanip> // for setprecision

int main(){
    //...
    // setprecision => to control the output of floating-point numbers.

    cout << setprecision(2);

    // fixed & scientific => fixed: fixed decimal format of  standard output device, scientific: 

    cout << fixed;   // for some compiler, cout.setf(ios::fixed)
    cout << float_var1 << float_var2;

    cout.unsetf(ios::fixed);

    cout << scientific; // cout.setf(ios::scientific)
    cout << float_var3 << float_var4;


    //...
    // showpoint // trailing zeros in decimal part

    cout << showpoint;
    cout << fixed << showpoint;




}

```




#### 4. Conditional Statements


#### 5. Loop


#### 6. Pointer & Reference



#### 6. Array


#### 7. `new`


#### 8. Class and Instance



#### 9. Inheritence



#### 10. Polymorphism (Overload and Override)


#### 11. Virtual Functions


#### 12. Etc

