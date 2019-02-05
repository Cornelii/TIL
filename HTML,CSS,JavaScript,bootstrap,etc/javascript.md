#JAVASCRIPT
The javascript is one of cores of web development.

## I. Introduction

#### 1. console
`console.log()` is like `print()` in python

#### 2. Comments
`//` and `/* */` are for comment

#### 3.  Data Types
Seven fundamental data types in javascript

Primitive data types
    1. Number (Integer, float, any number)
    2. String (`" "` ,`' '` )
    3. Boolean (true, false)
    4. Null (null)
    5. Undefined (undefined)
    6. Symbol

Non-primitive data types
    7. Object

#### 4. Arithmetic operators
+, -, *, /, %

#### 5. String Concatenation & Interpolation
##### Concatenation
Strings are easily concatenated by `+` like python.

example
```javascript
console.log("Hello "+"World")
```
##### Interpolation
back tick ` and ${ }

example
```javascript
let hi = 'Hellow World!';
console.log(`Yes ${hi }`);
```


**String concatenation with variable is also available**

#### 6. Properties
Instances has properties. And, they can be refered by dot operator `.` (a period) with name of property.

example
```javascript
console.log('Hellow World'.length);
```

#### 7. Methods
Methods are also available. And, it is just the same as the OOP.
ex) string methods
`.toUpperCase()`
`.trim()` 

#### 8. Built-in Objects
There are several built-in objects in javascript
ex) Math, console, Number

A few methods of Math & Etc:
    1. Math.random()
    2. Math.floor()
    3. Math.round()
    4. Math.ceil()

Number.isInteger()

## II. Variables

#### 1. Create a Variable by var
keyword `var` to create variable
example
```javascript
var NewVar = "new one";
console.log(NewVar);
``` 

#### 2. let
keyword `let` means variable can be reassigned!!
example
```javascript
let A = 'abc';
A = 'wow';
console.log(A)
let B;  // Automaticall initialzied with undefined.
```

#### 3. const
keyword `const` create variable that can not be reassigned.

#### 4. Mathematical Assignment Operators & Increment and Decrement Operators
+= , -= ,*=, /=,   ++, --


#### 5. typeof operator
An operator to check datatype
`typeof`

```javascript
const var1 = 'world';
console.log(typeof var1);
```

## III. 