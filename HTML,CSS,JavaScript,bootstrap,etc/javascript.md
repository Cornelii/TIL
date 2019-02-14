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

## III. Conditional Statements

#### 1. Basic if statement
```javascript
if (boolean) {
    statements;
}
```

#### 2. if else
```javascript
if (boolean) {
    statement1;
} else {
    statement2;
}
// They are similar to the one of JAVA
```

#### 3. Comparison and Logical Operators
##### Coomparison Ops
<, >, <=, >=, ===, !==   
**Remarks** for the equal, three `=` and Not equal `!== `

##### Logical Ops
`&&`, `||`, `!`

#### 4. Truthy and Falsy

list of falsy value
    1. 0
    2. `" "` or `' '`
    3. null
    4. undefined
    5. NaN

##### Truthy and Falsy Assignment
using `||`
example
```javascript
let var1 = "";
let var2 = var1 || "hello world";
```
In the second line, `||` check `var1` first, and if `var1` is Falsy. assign right one("hello world") to `var2`

#### 5. Ternary Operator
`condition ? statement1: statement2;`

```javascript
if (condition) {
    statement1;
} else {
    statemetn2;
}
// above code can be contracted to the following

condition ? statement1 : statement2;
```

#### 6. else if
```javascript
if (condition1) {
    statement1;
} else if (condition2){
    statement2;
} else if (condition3){
    statement3;
} else {
    statement4;
}
```

#### 7. The switch keyword
switch.
**Remakrs** `break` is necessary for each case.
```javascript
let var1 = "c9";

switch (var1) {
    case "c1":
        statement1;
        break;
    case "c2":
        statement2;
        break;
    case "c9":
        statement3;
        break;
    default:
        statement4;
        break;
}
```

## IV. Functions
There are many ways to declare function in javascript

Basic form
```javascript

function {func_name}({parma1},{parma2},..) {
    statement1;
    statement2;
    return result;
}

```

#### 1.Default Parameter
Default parameter is also available in javascript ES6.
For example.
```javascript
function {func_name} (parma1 = 'yes. default'){

}
```

#### 2.Helper function
This is nothing but function used in the other function.

#### 3.Function expression
function without name is called anonymous function.

When using function expression, people usually declare `const` identifier. and assign anonymous function to this.

example

```javascript

const my_func1 = function({param1},{parma2}..){
    statement1;
    return something;
}
```

#### 4. Arrow Function
The shorter way to declare function using fat arrow `()=>`

You do not need to type in `function` keyword.

example

```javascript
const my_func1 = ({param1},{parma2}) => {
    statement1;
    return something;
}

```

##### Concise Body of arrow function
1. When arrow function get single parameter, parenthesis can be omitted.
2. If body of function is singleline, brace also can be ommited. Furthermore,
3. This assume the one-line statement following `=>` is `return` value.
Therefore, `return` keyword also can be put out.

example

```javascript
const my_func1 = ({param1}) => {
  return {param1} === 'desired' ? true : false;
};

const my_func1 = {param1} => {param1} === "desired" ? true : false;
```

#### 5. First-class function.

In Javascript, functions are handled as an object!
function name itself without parenthesis can be assigned to other variables. And, the variables has property or methods like other data type!
ex) 
```javascript
const qwerasdf = function (){}
var a = qwerasdf;
console.log(a.name)
```
##### Function also can be parameter


## V. Scope

#### 1. Blocks and Global Scope
Blocks : { }

Global Scope: Outside of all the blocks. Global variables, which is declared in the global scope, are accessible from anywhere.

#### 2. Block Scope
When variables are declared in { }, these are accessible in the { }.

## VI. Arrays
The way to make `List` is very similar to the one in python.

And, The elements in list is also accessible and updated by index in the same way python.

```javascript
let myarray =['yeah', 'hoo', 'ha'];
```
#### 1. Arrays with let and const

**const array**
The array itself can not be reassigned. However, element in the array is still mutable!

**let array**
Can be reassigned

#### 2. .length property
To check the number of elements in some Array.

#### 3. .push() method
.push() is like append() and extends() in python.
It can get more than one argument with out array syntax `[]`

example
```javascript
myarray = ['a', 'b', 'c'];
myarray.push('d','e','f');
```

#### 4. .pop() method
It return last element of the array altering pristine array.

#### 5. other array methods

1. .join()
2. .slice()  :slicing
3. .splice()
4. .shift()   : It's like .pop(0) in python
5. .unshift()  : adding new element in the beginning of array returning new length.
6. .concat()
7. .indexOf()   : finding index by value.

#### 6. Arrays and Functions
Pass-by-reference!
When arrays is changed in some functions, that change will be conserved after function finish.

#### 7. Nested Array
Nothing but array in array.


## VII. Loops
Basic format: this is like one of JAVA or C

```javascript
for (let i = 0; i < 10; i++) {
    statement;
}
```
#### 1. Looping in reverse order
example
```javascript
for (let i=10; i>=0;i--) {
    statement;
}
```
#### 2. Looping through Arrays
Using length property

example
```javascript
for (let i=0; i<arr.length; i++) {
    statement;
}
```

#### 3. While
example
```javascript
let i = 0;
while (i < 10) {
    statement;
    i++;
}
```
#### 4. Do While
example
```javascript
do {

}while (condition) {
    statement;
    making step toward break_out;
}
```

#### 5. Break
get out of close looping


## VIII. Iterators
Iterators are methods called on arrays to manipulate elements and return values.
(Make for loop easier!)

#### 1. .forEach() 
execute same code for each element

example
```javascript
const arr = ['a', 'b', 'c', 'd'];
arr.forEach(func_1st_class);

arr.forEach(element => console.log(element));
```

#### 2. .map()
Basically, it works in the same way as .forEach()
But, this return new arr! Hence, it take func with return syntax.

```javascript
const arr2 = arr.map( element => element[0] );
```

#### 3. .filter()
Filter filtered element in arrray as its name.
**Callback function should return true or false (boolean)**
true:pass, false: block.

example
```javascript
const arr2 = arr.filter( element => element.length > 10 );

```

#### 4. findIndex()
This is like filter. but it return only index of first element that return true through callback function.

example
```javascript
const elem_index = arr.findIndex( element => element === 'why' );
```

#### 5. .reduce()
Accumulative manipulation

example
```javascript
const accu_var = arr.reduce( (accumul, current) => accumul + current);
```
accumul starts with first element of arr.
current starts with second element of arr.
`.reduce()` also can receive second parameter as an initial value of accumul.
`arr.reduce(funr(acc,curr), init_val)`

#### 6. Iterator Documentation
[javascrip Iterator](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array#Iteration_methods)

## IX. Objects
Javascript loves Object!

#### 1. Create Object literals
This looks like dictionary in python

```javascript
let obj_literal = {};
let obj_literal2 = {
    'key1' : 'value1',
    'key2' :'value2'  
    color: 'yellow'
};
```
#### 2. Accessing Properties
Two ways to access properties of objects.
1. dot notation `.`  for variable-like property without quotation marks.
2. Bracketk Notation `[]` for string-like property with quotation marks. 
3. 
#### 3. Properties are mutable even for ones of const Objects.

Changing and Adding properties can be easily done by `=` assignment.

**deleting properties by keyword `delete`**
example
```javascript

delete obj1.prop1;
delete obj2['prop2'];
```

#### 3. Methods in objects
Functions in object literal are called methods

Two syntax to define method in object
```javascript
let obj1 = {
    method1 : function () {
        statement;
    }
}
```
Second way
```javascript
let obj2 = {
    method2 () {
        statement;
    }
}
```

#### 4. Nested Objects
Objects in an Object.

#### 5. Object go into function as pass-by-reference! direct memory access!

**Remarks** Variable in Object is not transfered. Only objects go as pass-by-reference! It means that inside of function, **variable is accessible only by the transfered object**. If we make an attempt to reassign object! like this `obj = {property1:'prop1'}`. It did not work for object in outside! But, this works `obj.prop1 ="prop1"`.

(Changing address of obj in functions is not allowed?!)


#### 6. Looping through Objects
`for .. in ..  ` syntax!!

```javascript
for (let member in obj) {
    member-statement;
}
```
**assign name of properties to member one by one.**
Name!


## X. Advanced Object

#### 1. `this` keyword
**access to object's property in the object!!!**
Definition of object and its properties does not mean existence of the object and properties yet!.

<span style="color:red">For the arrow function, this does not work like description above!</span>

* Arrow function does not have its own `this`
* `this` is in enclosing lexical scope.

example
```javascript
const obj1 {
    prop1:6,
    method1 : function () {
        console.log(this.prop1);
    }
}

```

#### 2. Privacy
There is no built-in accessing control syntax in javascript. But, only done by convention such as `_` underscore before variable name.

#### 3. Getters
Getters are methods to **get** and **return** the internal properties of an object and do some more.

keyword `get`

example
```javascript
const obj = {
    prop1 : "prop1",
    _prop2 : "private prop2",
    
    get prop2 () {
        console.log(_prop2+"Yeah");
        return _prop2;
    }
}

let a = obj.prop2;

```
#### 4. Setters
Setters is to reassign existing properties and do more.

#### 5. Factory Functions
When we want to create many instances of an object quickly, use factory functions.(syntax)

a factory function = just a function returning object!

example
```javascript
const factoryfcn = (name,age) => {
    return {
        name: name,
        age: age,
        method1 () {
            console.log("Wow");
        }
    }
}
```
#### 6. Property Value Shorthand
Destructuring Technique (property value shorthand)

When constructing factory function.
we usually repeat variable name like example above!
At the situation, we can reduce these expression as follows.

```javascript
function factoryfcn (name,age) {
    name,
    age,
    func1 () {
        statement;
    }
}
```

#### 7. Destructured Assignment
When we want to extract property from obj with the same name of variable.

```javascript
const prop1 = obj.prop1;
```
can be reduced to
```javascript
const {prop1} = obj;
```

#### 8. Built-in Object Methods
There are useful method in `Object`
like 
    1. Object.keys(obj_name)
    2. Object.entries(obj_name)
    3. Object.assign(added_obj,obj)
    4. etc
[Object methods](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object#Methods)

example
```javascript
obj = {
    prop1:"prop1",
    prop2:"prop2",
    prop3:"prop3",
    prop4:"prop4"
}

const keys = Object.keys(obj);
const entries = Object.entries(obj);
const new_instance = Object.assign({newprop1:'newprop1',newprop2:'newprop2'},obj);

```

 
## XI. Classes

## XI. Classes
Javascript is an object-oriented programming (OOP) language.

#### 1. Basic Structure of Class
example
```javascript

class <class_name> {


}

```

#### 2. `constructor() {}`

#### 1. Basic Form
Classes have very similar form with that of Object literals except comma is not used between methods!!!!.


example
```javascript

class <class_name> {
    constructor(<params>) {
        this.prop1 = prop1;
        this._prop2 = prop2;
    }

    get prop2 () {
        return this._prop2;
    }

    method1 (<param1>) {
        statement;
    }

}

```

#### 2. new keyword
When creating instance from class, `new` keyword is used.
`new` calls constructor defined in class.

example
```javascript

const inst1 = new Class1(<params for constructor>);

let inst2 = new Class1();

```
#### 3. Inheritence
`extends` and `super()`


`extends` make defined class inherit super class.
`super()` calls 

**Remarks**: `super()` must be before `other assignment.`

example
```javascript
class Myclass {
    constructor(param1) {
        this.param1 = param1;
    }

}

class Mysubclass extends Myclass {
    constructor(param1,param2) {
        super(param1);
        this.param2 = param2;
    }
}
```

#### 4. Static Methods
`static` keyword.
When you want to call method directly from class, not by individual instances.
!! But they not accessible in instances!!

example
```javascript

class Myclass {
    constructor(val1, val2){}

    static myfunc() {}
}

```

## XII. Browser compatibility and transplation

[caniuse](https://www.caniuse.com/) for browser compatibility with HTML, CSS, javascript features.

Programmer developed `babel` to do transpilation from javasciprt on ES6 to that on ES5.

## XIII. Modules
Modules are particularly useful for a number of reasons. By separating code with similar logic into files called modules.

#### 1. module.exports & require()

example
```javascript
// in the prac.js

let A = {};
A.prop1 = "prop1";

module.exports = A;
```
`module.exports` exposes assigned object.

To get the exposed object
`require()`

example
```javascript
const a = require('./prac.js')

```

#### 2. export default
`export default` is similar to `module.exports` allowing us to export one module per file.

example
```javascript
let A = {}
export default A // object, functions, primitive data types are also available here.
```

#### 3. import
`import` is also available to bring module in other javascript files

example
```javascript
import A from './prac';

```
**Remarks**: extension `.js` is ommited!


#### 4. Named exports
`export` keyword
to export multiple things.

example
```javascript
export {myfunc1, obj1, var1}

```


#### 5. Named imports
to import multiple things

example
```javascript
import {myfunc1, obj1, var1} from './prac';

```

#### 6. Export Named Exports
`export` keyword before declaration expose it as soon as defined.

example
```javascript
export let var1 = "";

export function myfunc(){};

export let obj1 = {};
```

#### 7. Export as

`as` keyword with export

example

```javascript

export { obj1 as my_obj1, obj2 as my_obj2, obj3 as my_obj3};

```

#### 8. Import as
We have to use aliased variable name!

Below statement is also possible.
```javascript
import * as MyModule from './filename';

MyModule.obj1;
MyModule.fcn1;
MyModule.var1;

```

## XIV. Asynchronous control by `Promise`
Promises are objects that represents eventual outcome.

They can be in one of three states.

1. Pending: initial state, operation not completed yet
2. Fulfilled: operation completed successfully
3. Rejected: failed operation


#### 1. Constructing a Promise Object
example to create Promise object
```javascript
const func1 = (resolve, reject) => () {};

const myPromise = new Promise(func1);
```
The func1, which go into Promise(), have to get two parameters `resolve` and `reject`


example
```javascript
var a = 7;

const myExec = (resolve, reject) => {
	if (a > 0) {
    resolve("Resolved.");
  }  else {
    reject("Rejected.");
  }
}

const constructPromise = () => {
  const A = new Promise(myExec);
  return A
}

var orderPromise = constructPromise();

console.log(orderPromise)
```

#### 2. setTimeout() function
The point is it, How to consume or use promise that return to you as the result of an asynchronous operation.

example
```javascript

var myfunc1 = ()=>{statement1};

setTimeout(myfunc1,2500) // ms
```

**Remarks** time parameter in unit ms means **at least** operation. It could be more according to operations in code.


#### 3. Consuming Promises
`.then()`

`.then()` is a higher-order function usually taking two callbackfunctions.
Each callbackfunction is used as a handler at success and failure each.

`.then()` returns promise

##### onFulfilled & onRejected
example
```javascript
const handleSuccess = (resolvedValue) => {statement1};
const handleFailure = (rejectedValue) => {statement2};

promise_obj.then(handleSuccess,handleFailure)
```

#### 4. Using catch() with promises
`catch()`
when applying `.then()` successively, `catch()` is used for the reject part.

example
```javascript

promise_obj.then(successhandler.then(null,failurehandler)

// is the same as the below

promise_obj.then(successhandler.catch(failurehandler)
```
#### 5. promise chain (promise composition)
example
```javascript

promise_obj.then(successhandler.then(null,failurehandler)

// is the same as the below

promise_obj.then(successhandler).then(successhandler2).catch(failurehandler)

// successhandler have to return promise obj!!
```

#### 6. Promise.all()
To maximize efficiency, we shoud use concurrency.
multiple asynchronous operations happening together.
That is what `Promise.all()` does.

`Promise.all()` accepts an array of promise! and returns a single promise.



#### 7. Why we use promise!!

Promise and Promise composition is a good way to handle situations where asynchrounous operations depend on each other or execution order matters.

1. When every promise in the array resolves, it returns array containing corresponding resolved valued.
2. When any promise is rejected, it immediately returns the single reason of the promise.
(failing fast)

example
```javascript

Promise.all([promis_return_func1, promis_return_func2, promis_return_func3])
```


## XV. async ... await
Since ES8 javascript, it provides `async...await` syntax


#### 1. `async` keyword
declare function, in which has asynchronous logic, by `async`

example
```javascript
asnyc function myFunc(){};

// or
const myFunc2= async () => {};

myFunc();
myFunc2();
```
**Remarks**: async function always returns Promise

async function returns Promise in three ways.

1. If nothing to return, undefined as resolved value
2. If non-promise value retunred in function, promised with the value as resolved one
3. If promise is returned, it just returns the promise.

example
```javascript
async function withAsync(number){
  if (number === 0){
    return "zero";  //return promise with resolved value "zero"
   } else {
     return "not zero"; // return promise with resolved value "not zero"
   }
}
```

#### 2.  `await` operator
await only can be used in `async` function.

example
```javascript
async function func1(){
    let a = awiat promise1();

    statement_with_a;
}
// the statement_with_a is surely executed after get 'a'.
```

example
```javascript
promise1.then((resolved)=>{statement_with_a;})
```

#### 3. 


## XVI. 


## XVII. 


## XVIII.


## XIX.



## XX.