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

    //...
    // setw() // to assign specific # of columns to output
    cout << setw(5) << x << endl;   // right-justified

    // setfill('*') //  fill the empty space with a specific character

    cout << setfill('*') << setw(7) << name << endl;

    // left and right // left-justified, right-justified
    // left
    cout << left;
    cout.unsetf(ios::left);

    // right
    cout << right;

}

```

##### ii. String Types

```cpp
int main(){

    string name;
    cin >> name;

    // To obtain string containing blanks
    // getline(istreamVar, strVar);

    string string2;
    getline(cin, string2);
}
```

##### iii. File IO

File I/O steps
1. Include the header file `fstream`
2. Declare file stream variables
3. Associate the file stream variables with the input/output sources
4. Use the file stream variable with `>>, <<`, or other functions
5. Close the files.

```cpp
// Step1
#include <fstream>

using namespace std;

int main()
{
    // Step2
    ifstream inData;
    ofstream outData;

    // Step3
    inData.open(addr);
    outData.open(addr);

    // adding mode
    // outData.open(addr, ios::app);

    // Step4
    inData >> variables;
    outData << outputs;

    // Step5
    inData.close();
    outData.close();

    return 0;
}

```

#### 4. Conditional Statements

##### i. if
```cpp
if (expression)
{
    statements;
}
```
##### ii. if - else
```cpp
if(expression)
{
    statement1;
}
else 
{
    statement2;
}
```

##### iii. Nested if and else if
```cpp
if(expresssion1)
{
    if(expression2)
    {
        statement1;
    }
}
else if (expression3)
{
    statement2;
}
else
{
    statement3;
}
```


##### iv. IO check
```cpp
ifstream infile;

infile.open(addr);

if (!infile)
{
    cout << "Can not open the input file";
    return 1;
}
```

##### v. ternary operator `? :`

```cpp
if (a>=b)
    max = a;
else
    max = b;
```
==
`max = (a>=b) ? a : b;`

##### vi. switch

```cpp
switch (target_expression)
{
    case value1:
        statement1;
        break;
    case value2:
        statement2;
        break;
        //...
    default:
        statement_last;

}
```

##### vi. terminating with assert function
`assert(expression)`

```cpp
#include <cassert>

assert(expression) // true => go on, false => error occurs

```

#### 5. Loop

##### i. while 
```cpp
while (expression)
{

}


// eof-controlled while loops

while(cin)
{

}

while(!istreaVar.eof())
{

}
```

##### ii. for
```cpp
for (initial statement; loop condition; update statement)
{
    statements;
}

for(int i = 0; i < 10; i++)
{
    statements;
}
```

##### iii. do - while

```cpp
do{

}while(expression);

```

##### iv. `break` & `continue`


#### 6. User-defined functions

##### i. sort of predefined function
|Header|Function|
|---|---|
|`<cmath>`|abs(x)|
|`<cmath>`|ceil(x)|
|`<cmath>`|cos(x)|
|`<cmath>`|exp(x)|
|`<cmath>`|fabs(x)|
|`<cmath>`|floor(x)|
|`<cmath>`|pow(x, y)|
|`<cmath>`|sqrt(x)|
|`<cctype>`|islower(x)|
|`<cctype>`|isupper(x)|
|`<cctype>`|tolower(x)|
|`<cctype>`|toupper(x)|

##### ii. User-defined functions
```cpp
functionType functionName(formal parameter list)
{
    statements;
    // return return_value; // for the non-void function // variable, constant value, or expression for return_value
}
// formal parameter list => dataType identifier
```

##### iii. Function prototype
funtion heading without its body, terminated with semicolon ;

##### iv. return
Return can only return one value.(last value.)

`return x, y;`. In this case, y is returned.

##### v. parameter types
1. Value parameter
copy of the content of actual parameter.

2. Reference parameter
location(memory address) of the actual parameter

```cpp
void func1(double a, double b, double& c, double& d);
// a,b => value paramter
// c,d => reference parameter
```

**Tips**
If a function needs to return more than one value, change it to a void function and use reference parameter.

**Remarks**
1. C++ does not allow nested functions in a function.
2. The initialized variable in `for` loop is onyl accesible in the `for` block.

##### vi. Static and Automatic Variables

Simple rules for variables
1. Memory for global variables remains allocated as long as the program executes.
2. Memory for a variable declared within a block is allocated at block entry and deallocated at block exit. 


`automatic variable` : variables in above rule 2.
`static variable`: of which memory remains allocated as long as the program executes.

* global variable => static variable
* variable decalred within block => automatically automatic variable

To make a variable be declared within block as static variable,
use keyword `static`, `static dataType identifier;`


**Remarks**
static variable need to be initialized. you'd better initialize it yourself.

After first initialization, it acts like the declation code are removed from source code.
(Most compiler initialize the static variable)
!! Other function can not access the variable.

**Remarks**
Use stub to test function to work properly by driver.


##### vii. Function Overloading
Several functions can have the same name.
Function, which is to be overloaded, must have different formal parameter lists.

`signature` of a function
- function name
- formal parameter list
(Signatrue does not include returne dataType)

##### viii. default parameters
```cpp
void func1(int a, int b, double c=2.5, char d='K');
```


##### ix. enum type
```cpp
enum typeName {val1, val2, val3, ...};

typeName identifier;
```

##### x. `typedef` statement
To create alias of existing data type
```cpp
typedef existingTypeName newTypeName;
```

##### xi. namespaces

```cpp
namespace namespaceName
{
    //members
    int count = 0;
    const double RATE = 7.50;

    void printResult();
}

namespaceName:printResult();
// :: is called the scope resolution operator.
```

simplification of namespace
```cpp

// To simplify the accessing of all namespace members 
using namespace namespace_name;

// To simplify the accessing of a specific namespace member.
using namespace_name::identifier;
```
###### xi. string operators

|Expression|Description|
|---|---|
|strVar.at(index) or strVar[index]|Return the element |
|append(n, ch)|appends n copies of ch|
|append(str)|*|
|clear(str)|*|
|compare(str)|*|
|empty()|*|
|erase()|*|
|erase(pos, n)|*|
|find(str)|*|
|find(str, pos)|*|
|insert(pos, n, ch)|*|
|insert(pos, str)|*|
|length()|*|
|replace(pos, n, str)|*|
|size()|*|
|swap(str1)|*|

#### 6. Array and Strings

##### i. Array
`dataType arrayName[intExp];`


##### ii. Array Initializing during declaration.
```cpp
double axis[5] = {0.2, 0.4, 0.6, 0.8, 1.0};

double axis[12] = {0.2, 0.4, 0.6, 0.8, 1.0}; 
// others are initialized as zeros.
```


##### iii. Array and Function

**In C++, arrays are passed by reference only.**

No need of `&` for array.
```cpp
void initialize(int list[], int listSize){
    for(int count =0; count < listSize; count++)
        list[count] = 0;
}
```

##### iv. Constant Arrays
`const dataType identifier[]` => changing is not allowed.
```cpp
void example(int x[], const int y[], int sizeX, int sizeY){
    //changing y is not allowed.
}
```

##### v. array and enum types

```cpp
enum colorType {RED, GREEN, BLUE};
int channel[3];
channel[RED] = 255;
channel[GREEN] = 17;
channel[BLUE] = 231;
```

##### vi. Auto declaration and range-based `for` loops
`for (dataType identifier : arrayName)`

```cpp
double arr[20];

for (double number : arr){

}

for (auto number : arr){

}
```

##### vii. c-string functions
```cpp
#include <cstring>
```

- strcpy(s1,s2)
- strcmp(s1, s2)
- strlen(s)
- etc


**Remarks**
When it comes to `cin & cout` of string, aggregate operation is allowed exceptionally.

```cpp
cin >> name;
```

##### viii. multi-dimensional array

```cpp
//2D array
double example_array[6][8];

int example2[2][3] = {{4,  7,  1},
                                    {1, 7, 2},
                                    }

// when 2d array is saved in memory, c++ use row-order form 1st row -> 2nd row -> 3rd row -> and so on.

// You can not ommit second dimension size in parameterizaing because end of row must be specified for c++.
void print2D(int array[][num_of_col]){

}

double example_array3[][15][4];
```

#### 7. structs (records)


##### i. struct basic
```cpp
struct structName
{
    int identifier1;
    double identifier2;
    //...
};
//Semicolon is essential for struct.

structName myStruct;
myStruct.identifier1 = 5;
// .: member access operator.

structName myStruct2;
myStruct2 = myStruct; // this assignment is available..

```

##### ii. struct & function

- A struct variable can be passed by value or by reference.
- A struct variable can be returned in a function.

**Remarks**
struct in struct, array in struct are also possible.


#### 8. Classes and Data abstraction

##### i. basic form of class
```cpp
class ClassIdentifier
{
    public:
        classMemberList1;
        void func1();
        void func2(int) const;
    private:
        classMemberList2;
};
// semicolon after right brace is a part of syntax!

void ClassIdentifier:func1(){
    //...
}
void ClassIdentifier:func2(int a){
    //...
}


ClassIdentifier myClass1;
ClassIdentifier myClass2;
```

##### ii. member access specifiers
|member access specifiers|range|
|---|---|
|public|outside of class|
|protected|also accessible in the inheritance class|
|private|accessible within the class|

*By default, all members of a class are private*


**Remarks**
- Assignment operator works between the same class in member-wise way.

- class object can be passed by value and reference.

- passed by const referecne of class object also works in the same way.

##### iii. Constructors
Properties of constructor of c++ class

- 1. The name of a constructor is the same as the name of the class
- 2. A constructor is a function and it has no type. That is, it is neither a value-returning function nor a `void` function.
- 3. A class cna have more than one constructor(different formal parameter lists)
- 4. Constructors execute automatically when a class instance is declaresd.

##### iv. constructor & default parameter

```cpp
class ClassName{
    ClassName(int = 0, int = 0, int = 0);
};

ClassName my_class_array[100];
// class array
```

##### iv. Destructors
```cpp
class ClassName{

    ClassName(){}; // Constructor
    ~Classname(){}; // Destructor
};
```

##### v. static members of a class

A `public static` member, function, or variable of a class can be accessed using the class name and the scope resution operator (`::`)

For each static member variable of a class, C++ allocates only one memory space. `static` member variables of a `class` exist even when no instances of that `class` type exist.


#### 9. Inheritance and Composition

- Inheritance ("is-a" relationship)
- Composition (aggregation) ("has-a" relationship)


##### i. Inheritance
base classes => derived classes
(superclass) => (subclass)

```cpp
class className: memberAccessSpecifier baseClassName{

};
//memberAccessSpecifier: public, private, protected.
//if memberAccessSpecifier is not assigned, private assumed
```


##### ii. Constructors of Derived and Base Classes
Then, to trigger the exec ution of the base class
constructor with parameters, we add a colon ( :) to the headjng fo llowed by the name
of the constructor of the base class with its parameters in the heading of the definition
of the constructor of the derived class.

```cpp
class Sub: public Base{
    Sub(double, double, double);
};

Sub::Sub(double l, double w, double h) : Base(w, h);

```

##### iii. Destructors in a Derived Class
Destructors of all class in inheritance tree are invoked automatically in the reverse order.
sub -> base


##### iv. Header file of a derived class
```cpp

#include "baseClass.h"

class subClass: public baseClass{
    //...
};
```

##### v. Multiple inclusions of a header file
at header file (example.h)
```cpp
#ifndef H_EXAMPLE
#define H_EXAMPLE
const int ONE = 1;
const int TWO = 2;
#endif
```


##### vi. Composition

Instance from a class in the other class

##### vii. Features of OOD (object-oriented design)

1. Encapsulation: The ability to combine data and operations on that data in a single unit
2. Inheritance: The ability to create new objects (classes) from existing objects (classes)
3. Polymorphism: The ability to use the same expresssion to denote different operations


##### viii. Identifying Classes, Objects, and Operations

Choose classes from the list of nouns, and operations from the list of verbs.





#### 9. Pointer, Classes, Virtual methods, Abstrcat classes

##### i. Pointer variable
A variable whose content is an address(memory address)

`dataType *identifier;`







#### 11. Virtual Functions


#### 12. Etc

