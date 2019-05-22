# Nodejs
Javascript Framework built on Chrome V8 javascript Engine.
Javascript starts to take web and local.

You can make local app using javascript by node with appripriate packages.

[Node documentation](https://nodejs.org/api/)
[Javascript](https://developer.mozilla.org/en-US/docs/Web/JavaScript)
**Remarks** npm:
Package manager that Node offers.

```
node init


npm install lodash

<!-- git할 때는, node_modules는 .gitignore -->
<!-- 모듈 설치시 -->
npm install
```
lodash: node library => use javascript in kind of pythonic way?!


## I. Back-end and Front-end
Front-end development is a client-side development. The client, which sends requests to the web site, can be human, browser, smart applications, etc

Back-end takes charge in other part of front-end:
(behind-scenes processes).
send resources to clients, and make a website function, and so on.

**Front-end consists of the information and data sent to a client so that a user can see and interact with a website.**

**protocol**: Specific format of requests.

**Web Server**: Process running on a computer somewhere that listens for incoming requests over the internet and sends back responses.

**Main classification of Databases**
1. relational database (row-column table)
2. non-relational database (NoSQL) (key-value pair, etc)
Popular relational databases: MySQL, SQLite, PostgreSQL
Popular NoSQL databases: MongoDB, Redis

**API**: Application Program Interface

**Authentication & Authorization**
1. Authentication: process of validating the identity of a user.
2. Authorization: controls which users have access to which resources and actions.


**Differnet Back-end stacks**
FrameWork: collections of tools to help us make our web server and services.

|Back-end Framework|Language|
|---|---|
|Laravel|PHP|
|Express.js|JavaScript (in Node)|
|Ruby on Rails|Ruby|
|Spring|Java|
|Django|Python|
|JSF|Java|
|Flask|Python|
...

**Stack**: The collection of technologies used to create the front-end and back-end of a web application is referred to as a `stack`

ex) 
1.MEAN stack: MongoDB, Express.js, AngularJS, and Node.js (For web application)
2. LAMP stack: Linux, Apache, MySQL, and PHP
(archetypal stack)


## II. Node REPL

REPL is an abbreviation for read-eval-print-loop.

`.editor` => for multiple lines, executed by `ctrl+D`
`global` is an useful object in node.

#### 1. process object
a process is the instance of a computer program that is being executed.
`process`
`process.env`
`process.env.NODE_ENV`  // `'development' || 'production'`
`process.memoryUsage()`.

`process.argv` holds arguments from command line. (0=> address of Node, 1=> address of source code file, etc=> arguments)
...


[node-process object](https://nodejs.org/api/process.html)


#### 2. Modules (Core and Local)
The core modules are defined within Node.js's source and are located in the lib/ directory. `require()` passing a string with the name of a module.

example
`let events = require('events);`

[How require() works](https://nodejs.org/api/modules.html#modules_modules)

To make custom local module, make use of `module.exports` in node

```javascript
//example1.js
module.exports = anything
```
```javascript
let myModule = require('./exmample1.js');
let myModule2 = require('./exmample1');
```

#### 3. npm (node package manager)



## I. Node with lodash

```javascript
var _ = require('lodash');
```





## V. File IO in node

```javascript
// FILE IO by callback function
const fs = require('fs')

fs.readFile(__dirname + '/text.md', 'utf8', (err, data)=>{
    if(err === null){
        console.log(data);
    }else{
        console.log(err);
    }
})
```


## X etc

#### 1. Get inputs
example
get one-line
```javascript
const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

rl.on("line", function(line) {
  console.log("hello !", line);
  rl.close();
}).on("close", function() {
  process.exit();
});
```

```javascript
var input = [];
require('readline')
    .createInterface(process.stdin, process.stdout)
    .on('line', 
        function(line) {
            input.push(line.trim());
        })
    .on('close',
        function() {
            // 입력값 처리 및 출력  
        });

```
[관련 웹사이트](https://wooooooak.github.io/node.js/2018/09/26/Node.js-%EC%9E%85%EB%A0%A5-%EB%B0%9B%EA%B8%B0/)
