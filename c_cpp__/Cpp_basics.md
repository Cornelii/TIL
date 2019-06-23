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
    members
}


```



#### 6. Array


#### 7. `new`


#### 8. Class and Instance



#### 9. Inheritence



#### 10. Polymorphism (Overload and Override)


#### 11. Virtual Functions


#### 12. Etc

