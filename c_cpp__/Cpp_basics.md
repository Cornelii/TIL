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

    // To make fixed decimal part fixed & setprecision
    cout << fixed << setprecision(3);


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
funtion heading without its body, but with semicolon ;

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
2. The initialized variable in `for` loop is only accesible in the `for` block.

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

namespaceName::printResult();
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

// You can not ommit second dimension size in parameters because end of row must be specified for c++.
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

void ClassIdentifier::func1(){
    //...
}
void ClassIdentifier::func2(int a){
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

`&` get address, `*` dereferencing


##### ii. Classes, Structs, and Pointer Variables
```cpp

struct people{
    char name[20];
    int age;
    int ID;
    char occupation[50];
};

people person1;
people *person1Ptr; // pointer variable of people type.

person1Ptr = &person1;

(*person1Ptr).age = 30; 
```
**Remarks `.(dot) has higher precedence than *!!!`**
`*person1Ptr.age does not work in this case.`


**member access operator arrow**
`pointerVarName -> classMemberName`
```cpp
(*person1Ptr).age = 30;
person1Ptr -> age = 30;
```

##### iii. Initializing Pointer Variables
Pointer variables are initialized using the constant `0` or `nullptr`, null pointer.

##### iv. Dynamic Variables
```cpp
new dataType;
new dataType[intExp];

delete identifier;
delete [] array_identifier;
```

```cpp
int *p = new int;
int *q = new int[500];

// Deallocation is necessary for dynamic variables
delete p;
delete []q;
```

#### 10. Dynamic Arrays

**Remarks**
1. Range-based for loop `for(int x: array-identifier){}` is unavailable with dynamic array

##### i. functoins and pointers
```cpp
void example_function(int * &p, char *q){}
// for the p, example_function can change values of p and *p
//for the q, example_fuinction only can change the value of *q.
```

```cpp
int * example2 {};
// pointer can be returned.
```

##### ii. Dynamic Two-Dimensional Arrays
```cpp
int ** matrix;
int row = 100;
int col = 50;

matrix = new int*[row]; // row
for (int i=0; i < row; i++){
    matrix[i] = new int[col];
}
// For the `int ** matrix`, matrix is for access array, which comes first, *matrix is for second one.
```

##### iii. Shallow Copy versus Deep Copy
Shallow Copy actually pointing same array memory address.

##### iv. When using dynamic variable in class.
Use destructor to deallocate the memory of it.

**Remarks**
Assignment operator `=` copies member array in the shallow way.

##### v. copy constructor
```cpp

class ClassName{
    ClassName();
    ~ClassName();    
    ClassName(const ClassName& identifier);
};

ClassName::ClassName(const ClassName& identifier){

}

```

#### 11. Virtual Functions
C++ allows the user to pass an object of a derived class to a formal parameter of the base class type.


In this case, **at compile time,** the compiler associates the same-named method of the declarative class type.
```cpp
void example_fcn(BaseClass object1){}

BaseClass base_object;
DerivedClass derived_object;

example_fcn(base_object); // it is.
example_fcn(derived_object); // allowed
//However, when calling the overrided method in the function, it is binded with the BaseClass at compile time by method definition.
```

**To resolve this=> Virtual Functions**
run-time binding, late binding, or dynamic binding


```cpp
virtual void the_method();
```

`virtual` function enables that a base class object can use the derived class's method definition in running-time.

**Remarks**
We need to declare a `virtual` function only in the base class.


##### i. assignment, pointer assignment
```cpp
BaseClass base_object;
DerivedClass derived_object;

base_object = derived_object; //This is allowed.
//But, only members of BaseClase survive (Slicing Problems)

BaseClass * base_object = new BaseClass()
DerivedClass * derived_object = new DerivedClass()

base_object = derived_object // no slicing probs
```

**Remarks**
If a base class contains virtual functions, make the destructor of the basse class virtual.

##### ii. Abstract class and pure virtual functions
Abstract class: class contain at least one pure virtual function.

pure virtual function:
`virtual void draw() = 0;`, `=0` before semicolon.


##### iii. reference as alias
```cpp
int x;
int &y = x;

int & example_fcn(){
    return x;
}
// const before returnType of function definition prevent unwanted change in private number by returning reference!!
const int & example_fcn(){
    return y;
}

```


#### 12. Operator Overloading & Template
In order to overload an operator, you must write function using keyword `operator`

`returnType operator operatorSymbol(formal parameter list){}`

##### i. Restrictions in overloading an operator
- The associativity can not be changed (left to right)
- Default parameters are not allowed
- Can not change the number of parameters an operator takes
- Can not create new operator.
- `.`, `.*`, `::`, `?:`, `sizeof` can not be overloaded
- Can not redefine how operators work with built-in data types such as `int`, `double`.


##### ii. Pointer `this`
`this`: address of instance
`*this`: content of instance

##### iii. Friend Functions of Classes
A friend function of a class is a nonmember function of the class. But, it has access to all of the members even `private`.

`friend` (in the class definition)

- A friend function is not a member of any class. So, it can be defined out of `private`, `protected`, and `public`. (They are typically placed before any method definition)
  

**Function Definition after prototype at a class**
without `::`, and `friend`

**Remarks**
Insertion & extraction operators can be overloaded only as `friend` functions.


##### iv. Operator Function as member functions and nonmember functions

- `()`, `[]`, `->`, or `=` for a class must be declared as a member of the class
- Let some operator `op` is overloaded for `opClass`.
  - 1. If the far left operand of `op` is an object of a different type(not `opClass`), the function must be a nonmember that is a friend of the class `opClass`.
  - 2. If the operator function for `op` is a member of  `opClass`, then when applying `op` on objects of `opClass`, the far left operand of `op` must be of type `opClass`



##### v. Overloading Binary Operators
let `#` represent a binary operator.

###### 1. As member functions
`instance1 # instance2`, The compiler translates this into the `instance1.operator#(instance2)`

`instacne1` invokes `operator#` function. And, `instance2` passes as a parameter.



**[function prototype]**
`returnType operator#(const className$) const;` in class

**[function definition]**
```cpp
returnType className::operator#(const className& otherObject) const {

    return some_value;
}
```

###### 2. As nonmember functions
`instance1 # instance2`, => `operator#(instance1, instance2)`

**[function prototype]**
`friend returnType operator#(const className&, const className&)`

**[function definition]**
```cpp
returnType operator#(const className& firstObject, const className& secondObject){
    return some_value;
}
```


##### vi. Overloading the stream insertion operator(<<)

If an operator function is a member function of a class, then thye leftmost operand of that operation must be an object of that class. Therefore, the operator function `<<`, `>>` must be a nonmember function of that class.

example
`cout << instance1`
`cout`: opstream object, not the instance of the class (instance1)

**[function prototype]**
`friend ostream& operator<<(ostream&, const className&)`

**[function definition]**
```cpp
ostream& operator<<(ostream& osObject, const className& cObject){
    //...
    return osObject;
}
```

- Both are reference parameters.
- osObject is a reference to an ostream
- The function returnType is a reference to an ostream
`cout << instance1` <=> `operator<< (cout, instance1)`


##### vii. Overloading the stream extraction operator(>>)

**[function prototype]**
`friend istream & operator>>(istream&, className&)`

**[function definition]**
```cpp
istream& operator>>(istream& isObject, className& cObject){
    //...
    return isObject;
}

```

##### viii. Overloading the assignment operator (=)
In the pristine state, the assignment operator causes a member-wise copy of the member variables of the class.
*work well for nonpointer member variables*

**Remarks**
`operator=` must be a member of that class.

**[function prototype]**
`const className& operator=(const className&);`

**[function definition]**
```cpp
const className& className::operator=(const className& rightObject){
    //...
    if(this != &rightObject){ // To avoid self-assignment

    }
    return *this;
}
```
- There is only one formal parameter
- parameter, and returnType => `const`
- It must return reference type.


##### ix. Overloading Unary Operators
- 1. If the operator function is a member of the class, it has no parameters
- 2. If the operator function is a nonmember, which is a friend function of the class, it has one parameter.


##### x. Overloading the increment (++) and decrement (--) operators
It has two forms: pre- `++u`, post- `u++`
For the pre- `++u`, in the case that `u` is `int`, `u` is incremented by 1 before `u` is used. Contrarily


###### 1. overloading the pre-increment(decrement) operators
we will use pointer `this` to return the object's value.

**[function prototype]**
`className operator++();`

**[function definition]**
```cpp
className className::operator++()
{

    return *this;
}
```

**Remarks**
pre-incremet(decrement) operators can also be nonmembers of the class

**[function prototype]**
`friend className operator++(className&);`

**[function definition]**
```cpp
className operator++(className& incObj)
{

    return incObj;
}
```

###### 2. overloading the post-increment(decrement) operators

As a member of a class
**dummy parameter** is used to distinguish the post- and pre-increment(decrement) operators in only function prototype.


**[function prototype]**
`className operator++(int);`

**[function definition]**
```cpp
className className::operator++(int u)
{
    className temp = *this;
    // increment the object
    return temp;  // return old value!!
}
```

`instance1++` <=> `instacne1.operator++(0)`


As a nonmember of the class


**[function prototype]**
`friend className operator++(className&, int);`

**[function definition]**
```cpp
className operator++(className& incObj, int u)
{
    className temp = incObj;
        // increment incObj;
    return temp; // return old value
}

```


##### xi. Classes and Pointer Member Variables
Classes with pointer member variables must:
1. Explicitly overload the assignment operator
2. Include the copy constructor
3. Include the destructor


##### xii. Overloading the Array Index(Subscript)

`operator[]` must be a member of the class.

`Type& operator[](int index);`

for constant array
`const Type& operator[](int index) const;`
`Type` is the data type of the array elements in class


#### 13. Templates
Templates in C++ allow you to write a single code segment for a set of related functions, called a function template, and for a set of related classes, called a class template.

```cpp
template <class Type>
declaration;
//Type : the name of a data type
// declaration : function of class declaration.
// class in <> can be replaced with the keyword typename
// Type is refered to as a formal parameter to the template
```

#### i. Function Templates
```cpp
template <class Type>
Type larger(Type x, Type y){

    //...
}
```

#### ii. Class Templates
```cpp
template<class elemType>
class className{
    public:
        int a=4;
    protected:
        elemType class_array[100];
        int length;
};

className<int> instance;

```
*template instantiations*
A template instantiation can be done with either a built-in or user-defined type.

**Remarks**
Methods in class template are considered function template!!!!

For the method definition in class template
```cpp
template <class elemType>
void className<elemType>::method1(elemType newElement){

}
```

For the constructor or destructor
```cpp
template<class elemType>
class Constructor{
    Constructor();
};

template <class elemType>
Constructor<elemType>::Constructor(){

}
//<elemType> is needed! because it is also used when declaring its instances.
```

#### iii. Header file and implementation file of a class template

definition of the class(in the header file)
definitions of the member functions(in the implementation file). This separation does not work on class template!

solution
1. all in the client code
2. all in the same header file
3. seprated but include a directive to the implementation file at the end of the header file.



#### 13. Error Handling
```cpp
try{
    //statements that should not be executed if an exception occurs
}catch(dataType1 identifier1){
    //exception-handling code
}catch(dataType2 identifier2){
    //exception-handling code
}catch(...){
    // ellipses (three dots) is meant to catch any type of exception.
}
```
**Remarks**
In the following code block
```cpp
catch (int x){
    //...
}
```
- `x` is catch block parameter
- This `catch` block can catch an exception of type `int`
- A catch block can have at most one catch block parameter.

(placeholder)

##### i. Throwing an exception
`throw expression;`
expression is a value, variable, or object.

```cpp
int x = 5;
string str = "Somthing is wrong!";

throw str;
throw x;
throw string("Exception found!");

```

**Remarks**
When it comes to the order of `catch` blocks,
when exception occurs, it looks for proper `catch` block in order!!.
You have to be careful to arrange them.

ex) `catch` block with (ellipses)`...` must be positioned last.


```cpp
    int dividend, divisor;
    double quotient;
    try{
        cin >> dividend >> divisor;

        if(divisor == 0)
            throw 0;
    }catch(int x){
        cout << "Division by 0." << endl;
    }

    return  0;
```


##### ii. Using C++ Exception Classes

All derived class of the `class exception` override the method `what` to issue their own error message.

in the header file `stdexcept`
1. `logic_error`
    - invalid_argument
    - out_of_range
    - length_error
    - bad_alloc
    - etc

2. `runtime_error`
    - overflow_error
    - underflow_error
    - etc

example
```cpp
try{

}catch(out_of_range re){
    re.what();
}catch(length_error le){
    le.what();
}
```

##### iii. Creating Your own Exception Classes
A simple class
```cpp
class MyOwnException{};

throw MyOwnException();
```

Own Exception with members
```cpp
class MyOwnException{
    public:
        MyOwnException(){
            message = "Division by zero";
        }
        MyOwnException(string str){
            message = str;
        }
        string what(){
            return message;
        }
    private:
        string message;
};


try{

    throw MyOwnException()
}catch(MyOwnException moe){
    moe.what();
}
```


##### iv. Rethrowing and Throwing Exception
To put together regarding exception-handling exception codes, (in function)

`throw`
or
`throw expression`

example
```cpp
#include <iostream>
#include "divisionByZero.h"

using namespace std;

void throwExcep() throw (int, string, divisionByZero);

int main(){
    try{
        throwExcep();
    }catch (divisionByZero divByZeroObj){
        cout << divByZeroObj.what() << endl;
    }

    return 0;
}


void throwExcep() throw (int, string, divisionByZero){

    try{
        //statements

        if(divisor == 0)
            throw divisionByZero("0-division");
    }catch(divisionByZero){
        throw;
    }
}

```


#### 14. Vector Type

`#include<vector>`

##### i. basic declaration & methods
```cpp
#include <vector>

vector<elemType> vecList;
//vector<elemType> vecList(othervecList);
//vector<elemType> vecList(size);
//vector<elemType> vecList(n , initialValue);


//vecList.at(index);
//vecList[index];
//vecList.front()
//vecList.back()
//vecList.clear()
//vecList.push_back(input_value)   : like append
//vecList.pop_back()
//vecList.empty()
//vecList.size()
//vecList.max_size()
```

##### ii. use with `for`
```cpp
vecter<int> intList(5);

for (int j = 0; j < 5; j++)
    intList[j] = j;
```

```cpp
vector<int> intList;
unsigned int i;
intList.push_back(15);
intList.push_back(7);

for (i = 0; i < intList.size(); i++)
    cout << intList[i] << endl;


for (auto j : intList)
    cout << j << endl;
    
``` 

##### iii. Into the function

```cpp
void doubleList(vector<int> &list){
    for (auto &p : list)
        p = p*2;
}

// vector is a class! without & => copy constructor
```
