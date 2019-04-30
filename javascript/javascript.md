#JAVASCRIPT
The javascript is one of cores of web development.

non-blocking properties: asynchronous language

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
console.log(`Yes ${hi }`);  // backtick!
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
**Remarks** for the equal, three `=` and `!== ` for nonequal

##### Logical Ops
`&&`, `||`, `!`

#### 4. Truthy and Falsy

list of falsy value
    1. 0
    2. `""` or `''`
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
3. This assumes that the one-line statement following `=>` has a `return` value.
Therefore, `return` keyword also can be put out.

example

```javascript
const my_func1 = ({param1}) => {
  return {param1} === 'desired' ? true : false;
};

const my_func1 = {param1} => {param1} === "desired" ? true : false;
```

##### min function, `arguments` and exception for arrow function
```javascript
var _ = require('lodash');

let min = function(){
    let min_val = Infinity;
    for(let i=0;i<arguments.length;i++){
        if(arguments[i]<min_val){
            min_val = arguments[i];0
        }
    }
    return min_val
}

console.log(min(5,7,1,6,7))// arbitrarily parameters can be handled with arguments
```
In this example, function should be declared with function() not arrow ()=>!! It affects arguments!

##### this keyword in arrow function

`this` in arrrow function indicate the object when decalared.

##### Anonymous function assigned to variable is the better because of hoisting!
undefined vs error  


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

And, The elements in list is also accessible and updated by index in the same way as python.

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
It can get more than one argument without array syntax `[]`

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
8. filter()
9. find()
10. reject()
11. every()
12. some()

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

#### 5. break
get out of adjacent loop


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
    'key2' :'value2',  
    color: 'yellow'
};
```


#### 2. Accessing Properties
Two ways to access properties of objects.
1. dot notation `.` 
2. Bracketk Notation `[]` 

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

#### 5. Object goes into function as pass-by-reference! direct memory access!

**Remarks** Variable in Object is not transfered. Only objects goes as pass-by-reference! It means that inside of function, **variable is accessible only by the transfered object**. If we make an attempt to reassign object! like this `obj = {property1:'prop1'}` does not work for object in outside of function! But, this works `obj.prop1 ="prop1"`.

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
function factoryfcn (name,age) => {
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
There are useful methods in `Object`
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

class class_name {
    constructor(params) {
        this.prop1 = prop1;
        this._prop2 = prop2;
    }

    get prop2 () {
        return this._prop2;
    }

    method1 (param1) {
        statement;
    }

}

```

#### 2. new keyword
When creating instance from class, `new` keyword is used.
`new` calls constructor defined in class.

example
```javascript

const inst1 = new Class1(params_to_constructor);

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

## XII. Browser compatibility and translation

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
const func1 = (resolve, reject) => {};

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

promise_obj.then(successhandler).then(null,failurehandler)

// is the same as the below

promise_obj.then(successhandler).catch(failurehandler)
```
#### 5. promise chain (promise composition)
example
```javascript

promise_obj.then(successhandler).then(null,failurehandler)

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

async forces function to return Promise!
await in front of function that returns Promise.

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

`await` keyword halts the following executions of an `async` function until a promise is no longer pending.

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

example to show role of await clearly
```javascript
let myPromise = () => {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve('Yay, I resolved!')
    }, 1000);
  });
}

async function noAwait() {
 let value = myPromise();
 console.log(value);
}

async function yesAwait() {
 let value = await myPromise();
 console.log(value);
}

noAwait(); // Prints: Promise { <pending> }
yesAwait(); // Prints: Yay, I resolved!
```

#### 3. Multiple await (chain operation)
At use of promise
```javascript
function myPromise() {
    Promise1()
    .then((firstValue) => {
        console.log(firstValue);
        return Promise2(firstValue);
    })
   .then((secondValue) => {
        console.log(secondValue);
    });
}

// Above code is equivalent to below one

async function myPromise() {
 let firstValue = await Promise1();
 console.log(firstValue);
 let secondValue = await Promise2(firstValue);
 console.log(secondValue);
}

```

#### 4. Handling Error
To know where a fail occur! To handle error
`try catch`is used.

example
```javascript
async function myfunc() {
 try {
   let resolved = await asyncFunc();
   let secondValue = await asyncFunc2(resolved);
 } catch (error) {
   // Catches any errors in the try block
   console.log(error);
 }
}

myfunc();
```

Since `async` function returns promise. `.catch` also can be used to check error as well.

#### 5. Handling independent promises
If each promise is independent one another.

await keyword can be called latter to take advantage of  concurrency that javascript has.

example
```javascript
async function concurrecy() {
 const firstPromise = firstAsync();
 const secondPromise = secondAsync();
console.log(await firstPromise, await secondPromise);
}
```
#### 6. Await Promise.all()
`await Promise.all()` allows us to do things simultaneously. Of course, independent promises!!

example
```javascript
async function asyncPromAll() {
  const resultArray = await Promise.all([asyncTask1(), asyncTask2(), asyncTask3(), asyncTask4()]);
  for (let i = 0; i<resultArray.length; i++){
    console.log(resultArray[i]); 
  }
}
```

## XVI. Requests
(http request methods)[https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods]

#### 1. HTTP Requests
Since javascript is asynchronous language, for better user experience, a site is generally  written so that users do not have to wait for all those contents to be read

(regarding event loop)[https://developer.mozilla.org/en-US/docs/Web/JavaScript/EventLoop]

#### 2. XHR GET Requests

**Ajax**: Asynchronous javascript and XML

XMLHttpRequest(XHR)  API

make get request
example
```javascript
const xhr = new XMLHttpRequest();

const url = 'https://api-to-call.com/endpoint';

xhr.responseType = 'json';

xhr.onreadystatechange = ()=>{
	if (xhr.readyState === XMLHttpRequest.DONE){
    return xhr.response;
  } 
}
// the if statement check if the request has finished
xhr.open('GET',url);
//open create new request, argument: type, url
xhr.send();
```

#### 3. XHR GET Requests 2 (Datamuse API)

(datamuse api)[https://www.datamuse.com/api/]
example
```javascript
// Information to reach API
const url = "https://api.datamuse.com/words?";
const queryParams = 'rel_rhy=';

// Selecting page elements
const inputField = document.querySelector('#input');
const submit = document.querySelector('#submit');
const responseField = document.querySelector('#responseField');

// AJAX function
const getSuggestions = () => {
	const wordQuery = inputField.value;
  const endpoint = url + queryParams + wordQuery;
  const xhr = new XMLHttpRequest();
  xhr.responseType = 'json';
  
  xhr.onreadystatechange = ()=> {
    if (xhr.readyState === XMLHttpRequest.DONE ) {
      renderResponse(xhr.response);
      renderRawResponse(xhr.response);

    }
  }
	xhr.open('GET',endpoint);
  xhr.send();
}


// Clear previous results and display results to webpage
const displaySuggestions = (event) => {
  event.preventDefault();
  while(responseField.firstChild){
    responseField.removeChild(responseField.firstChild);
  };
  getSuggestions();
}

submit.addEventListener('click', displaySuggestions);
```

**Attributes and Methods of XMLHttpRequest**
    1. .readyState
    2. .DONE   !(Class variable)
    3. .response
    4. .open(`method`,`url`)
    5. .send()

#### 4. XHR GET Request 3
(wikipedia regarding query string)[https://en.wikipedia.org/wiki/Query_string]

Generally query parameters are setted in url as follows.
?`query_name1`=`query_param1`&`query_name2`=`query_param2`&..


#### 5. XHR POST Request

"POST" method needs additional information than "GET".

example
```javascript
const xhr = new XMLHttpRequest();

const url ='https://api-to-call.com/endpoint';

const data = JSON.stringify({id:'200'});
// Additional part!
xhr.responseType = 'json';

xhr.onreadystatechange = ()=> {
  if (xhr.readyState === XMLHttpRequest.DONE) {
   return xhr.response; 
  }
}

xhr.open("POST",url); // POST way
xhr.send(data)\
```
#### 6. XHR POST Requset 2 Rebrandly API
Carefully take look at the way to add header.

example
```javascript
// Information to reach API
const apiKey = 'api_key';
const url = 'https://api.rebrandly.com/v1/links';

// Some page elements
const inputField = document.querySelector('#input');
const shortenButton = document.querySelector('#shorten');
const responseField = document.querySelector('#responseField');

// AJAX functions
const shortenUrl = () => {
  const urlToShorten = inputField.value;
  const data = JSON.stringify({destination: urlToShorten});
  const xhr = new XMLHttpRequest();
  xhr.responseType ='json';
  
  xhr.onreadystatechange = ()=>{
    if (xhr.readyState === XMLHttpRequest.DONE) {
      renderResponse(xhr.response);
    }
  }
  
  xhr.open("POST",url);
  // Header is needed to access Rebrandly API
  xhr.setRequestHeader('Content-type','application/json');
  xhr.setRequestHeader('apikey',apiKey);
  
  xhr.send(data);
  
}


// Clear page and call AJAX functions
const displayShortUrl = (event) => {
  event.preventDefault();
  while(responseField.firstChild){
    responseField.removeChild(responseField.firstChild);
  }
  shortenUrl();
}

shortenButton.addEventListener('click', displayShortUrl);
```

## XVII.  Requests with ES6

#### 1. fetch() GET Request
[fetch API MDN](https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API)

example with datamuse api
```javascript
// Information to reach API
const url = 'https://api.datamuse.com/words';
const queryParams = '?sl=';

// Selects page elements
const inputField = document.querySelector('#input');
const submit = document.querySelector('#submit');
const responseField = document.querySelector('#responseField');

// AJAX function
const getSuggestions = () => {
  const wordQuery = inputField.value;
  const endpoint = `${url}${queryParams}${wordQuery}`;
  
  fetch(endpoint).then(response => {
    if (response.ok) {
      return response.json();
    }
    throw new Error('Request failed!');
  }, networkError => {
    console.log(networkError.message)
  }).then((jsonResponse)=>{
    renderResponse(jsonResponse);
  })
}

// Clears previous results and display results to webpage
const displaySuggestions = (event) => {
  event.preventDefault();
  while(responseField.firstChild){
    responseField.removeChild(responseField.firstChild);
  }
  getSuggestions();
};

submit.addEventListener('click', displaySuggestions);
```
**Remarks** fetch(`url`) returns objects in terms of **Promise**, which is `response` in this case.

#### 2. fetch() POST Requests
When we do POST, we pass second parameter into `fetch()`

example
```javascript
// Information to reach API
const apiKey = 'api_key';
const url = 'https://api.rebrandly.com/v1/links';

// Some page elements
const inputField = document.querySelector('#input');
const shortenButton = document.querySelector('#shorten');
const responseField = document.querySelector('#responseField');

// AJAX functions
const shortenUrl = () => {
  const urlToShorten = inputField.value;
  const data = JSON.stringify({destination: urlToShorten});
  
  fetch(url,{method:"POST",headers:{'Content-type':'application/json','apikey':apiKey}, body:data}).then(
  response => {
    if (response.ok){
      return response.json();
    }throw new Error("Request failed!")
  }, networkError => {
    console.log(networkError.message);
  }
  ).then(jsonResponse=>{renderResponse(jsonResponse);})
  
}


// Clear page and call AJAX functions
const displayShortUrl = (event) => {
  event.preventDefault();
  while(responseField.firstChild){
    responseField.removeChild(responseField.firstChild)
  }
  shortenUrl();
}

shortenButton.addEventListener('click', displayShortUrl);

```

#### 3. async GET Requests 
example

```javascript
const getData = async () =>{
  try {
    const response = await fetch('https://api-to-call.com/endpoint');
    if (response.ok) {
      const jsonResponse = await response.json();
      return jsonResponse;
    } throw new Error("Request failed!")
  } catch(error) {
    console.log(error);
  }
};
```

**async GET with datamuse API**
example

```javascript
// Information to reach API
const url = 'https://api.datamuse.com/words?';
const queryParams = 'rel_jja=';

// Selecting page elements
const inputField = document.querySelector('#input');
const submit = document.querySelector('#submit');
const responseField = document.querySelector('#responseField');

// AJAX function
// Code goes here
const getSuggestions = async () =>{
  const wordQuery = inputField.value;
  const endpoint = `${url}${queryParams}${wordQuery}`;
  
  try{
    const response = await fetch(endpoint);
    if (response.ok){
      const jsonResponse = await response.json();
      renderResponse(jsonResponse);
    }throw new Error("")
  }catch(error){console.log(error)};
}


// Clear previous results and display results to webpage
const displaySuggestions = (event) => {
  event.preventDefault();
  while(responseField.firstChild){
    responseField.removeChild(responseField.firstChild)
  }
  getSuggestions();
}

submit.addEventListener('click', displaySuggestions);
```

#### 4. async POST Requests 
example
```javascript
const getData = async ()=>{
  try{
    const response = await fetch('https://api-to-call.com/endpoint',{
      method:'POST',
      body:JSON.stringify({id:200})
    });
    if (response.ok) {
      const jsonResponse = await response.json();
      return jsonResponse;
    } throw new Error("Request failed!");
    
  }catch(error){console.log(error);}
}
```

**async POST Request with Rebrandly API**
example
```javascript
// information to reach API
const apiKey = 'api_key';
const url = 'https://api.rebrandly.com/v1/links';

// Some page elements
const inputField = document.querySelector('#input');
const shortenButton = document.querySelector('#shorten');
const responseField = document.querySelector('#responseField');

// AJAX functions
// Code goes here
const shortenUrl = async ()=>{
  const urlToShorten = inputField.value;
  const data = JSON.stringify({destination:urlToShorten});
  try{
    const response = await fetch(url,{
      method:'POST',
      body:data,
      headers:{
        'Content-type':'application/json',
        'apikey':apiKey
      }
    });
    if (response.ok){
      const jsonResponse = await response.json();
      renderResponse(jsonResponse);
    } throw new Error();
  }catch(error){console.log(error);}
  
}

// Clear page and call AJAX functions
const displayShortUrl = (event) => {
  event.preventDefault();
  while(responseField.firstChild){
    responseField.removeChild(responseField.firstChild);
  }
  shortenUrl();
}

shortenButton.addEventListener('click', displayShortUrl);



```





#### .5 functions used above

helperFunctions.js
```javascript
// Formats response to look presentable on webpage
const renderResponse = (res) => {
  // Handles if res is falsey
  if(!res){
    console.log(res.status);
  }
  // In case res comes back as a blank array
  if(!res.length){
    responseField.innerHTML = "<p>Try again!</p><p>There were no suggestions found!</p>";
    return;
  }

  // Creates an empty array to contain the HTML strings
  let wordList = [];
  // Loops through the response and caps off at 10
  for(let i = 0; i < Math.min(res.length, 10); i++){
    // creating a list of words
    wordList.push(`<li>${res[i].word}</li>`);
  }
  // Joins the array of HTML strings into one string
  wordList = wordList.join("");

  // Manipulates responseField to render the modified response
  responseField.innerHTML = `<p>You might be interested in:</p><ol>${wordList}</ol>`;
  return
}

// Renders response before it is modified
const renderRawResponse = (res) => {
  // Takes the first 10 words from res
  let trimmedResponse = res.slice(0, 10);
  // Manipulates responseField to render the unformatted response
  responseField.innerHTML = `<text>${JSON.stringify(trimmedResponse)}</text>`;
}

// Renders the JSON that was returned when the Promise from fetch resolves.
const renderJsonResponse = (res) => {
  // Creates an empty object to store the JSON in key-value pairs
  let rawJson = {};
  for(let key in res){
    rawJson[key] = res[key];
  }
  // Converts JSON into a string and adding line breaks to make it easier to read
  rawJson = JSON.stringify(rawJson).replace(/,/g, ", \n");
  // Manipulates responseField to show the returned JSON.
  responseField.innerHTML = `<pre>${rawJson}</pre>`;
}
```


## XVIII. POST, GET, etc in javascript
```javascript
// axios (javascript version of python requests module)

const url = 'https://jsonplaceholder.typicode.com/';


const XHR = new XMLHttpRequest();

// GET ----------------------------------------------
// XHR.open(httpmethod, url)
XHR.open('GET', url+'posts');
// 요청을 보내는 문서양식을 작성하겠다는 open

XHR.send();
// XHR은 응답이 오기까지 기다림.

XHR.addEventListener('load',(e)=>{
  const result = e.target.response
   const jsObject = JSON.parse(result);
  console.log(jsObject);
  const jsonString = JSON.stringify(jsObject);
  console.log(jsonString);

  console.log(jsObject[0].title);
})
// 'load', 'progress', 'abort', etc.

//JSON.parse => json => javascript object
//JSON.stringify => javascript obj => string


//POST --------------------------------------------------

XHR.open('POST', url+'posts/1');

XHR.setRequestHeader(
  'Content-Type',
  'applications/json;charset=UTF-8'
)

const data = {
    title:'요거요거 타이틀',
    body: '이것은 내용',
    userId: 1,
}

XHR.send(JSON.stringify(data))

XHR.addEventListener('load', (e)=>{
    const result = e.target.response;
    console.log(result);
})
```

##### Using fetch since ES6
```javascript
const url = 'https://jsonplaceholder.typicode.com/';

// fetch return Promise
fetch(url+'posts').then((response)=>{
    return response.json()
}).then((resolved)=>{
    console.log(resolved)
});

```

## XIX. 





## XIX. javascript GIPHY-SEARCH ENGINE Example
```javascript
// 1. tag input 안의 값 잡기.
const input = document.querySelector('#js-userinput'); // input => reference type.
const button = document.querySelector('#js-go');
const resultArea = document.querySelector('#result-area');

const api_key = '#';
const tv = document.querySelector('#js-tv')

const base_url = 'http://api.giphy.com/v1/gifs/'

input.addEventListener('keypress', (e)=>{
    if(e.keyCode === 13){
        resultArea.innerHTML = ""
        const value = input.value;
        const url = `search?q=${value}&api_key=${api_key}&limit=${10}`
        searchAndPush(url);
    }
})

button.addEventListener('click',(e)=>{
    resultArea.innerHTML = ""
    const value = input.value;    
    const url = `search?q=${value}&api_key=${api_key}&limit=${10}`
    searchAndPush(url);
})


// 2. giphy api 사용하여 data를 받아서 가공한다.
const searchAndPush = (url) =>{
    const xhr = new XMLHttpRequest();
    xhr.open('GET', base_url+url);
    xhr.send()
    xhr.addEventListener('load', (e)=>{
        const rawData = e.target.response;
        parsedData = JSON.parse(rawData)
        console.log(parsedData);
        for (let target of parsedData.data){
            console.log(target);
            pushToDom(target.images.fixed_height.url)
        }
        showTv(parsedData.data)
    })
}


// 3. GIF 파일들을 HTML(DOM)에 밀어 넣는다.
const pushToDom = (data) => {
    const gif = document.createElement('img');  // <img />
    gif.src = data; // <img src="${data}"></img />
    // resultArea.appendChild(gifs);
    resultArea.insertBefore(gif, resultArea.firstChild);

    // resultArea.innerHTML += `<img src="${data}" />`;
}   

const showTv = (data_list)=>{
    let s = 0;
    let data_len = data_list.length;
    let flag = true;
    let data = data_list[s];
    
    tv.innerHTML = `<img src="${data.images.fixed_height.url}" />`;
    setInterval(()=>{
        s = (s+1)%data_len;
        data = data_list[s]
        tv.innerHTML = `<img src="${data.images.fixed_height.url}" />`;
    },5000)
}

```


## XXIX. Single Thread
Back-end is not single thread.
jsut the code we write works as a single thread.

#### i. non-blocking function cause asynchrounous
Even if function contains non-blocking functions and returns something.
It returns first rather than non-blocking functions.


