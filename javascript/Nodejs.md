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

[npm-website](https://www.npmjs.com/)
express, react, axios, others.

#### 4. Event-Driven Architecture

Node is designed to react event which is not known when it is triggered.

```javascript
let events = require('events');

let myEmitter = new events.EventEmitter();
// Each event emitter instance has an .on() and .emit() methods.
// .on()  1st arg => string: name of event, 2nd arg => callback fcn
```

example
```javascript
let events = require('events');

let listenerCallback = (data) => {
    console.log('Celebrate ' + data);
}

let myEmitter = new events.EventEmitter();

myEmitter.on('celebration',listenerCallback);

myEmitter.emit('celebration','firstEmit')
// .emit() also takes two arguments, for the first, event name set by .on(), and second one is the data needed for the callback fcn.
```

#### 5. Asynchronous Javascript with Node.js
Some tasks are time-consuming: reading files, querying a database, requests.

Node handles this by event loop that enables user to deal with blocking things in non-blocking way.

`Promise` and `async - await`


#### 6. User Input/Output
example to get input 
```javascript
process.stdout.write("blabla something something \n... ");

let play = (userInput) => {
  let input = userInput.toString().trim();
};

process.stdin.on('data', play)
```

[node buffer class](https://nodejs.org/api/buffer.html#buffer_buffer)



#### 7. Errors
The Node environment has all the standard javascript errors such as EvalError, SyntaxError, RangeError, ReferenceError, TypeError, and URIError, and Error class.
`throw`, and `try ... catch`

General Node APIs use error-first callback functions as follows
```javascript
const errorFirstCallBack = (err, data) => {
    if(err)}{
        console.log('error!');
    }else{
        console.log(`no error with data: ${data}`);
    }
}

AsyncAPI('problematic input', errorFirstCallback) // AsyncAPI is virtual thing.
// This syntax does not require try ... catch statement.
```

#### 8. FileSystem
All of the data on a computer is organized and accessed through a filesystem. 

Sandboxing: Method to isolate some applications from others.
`fs` is one of core modules in node w.r.t POSIX (Portable Operating System Interface)

`fs` module has synchronous and asynchronous versions.

one of core method is `.readFile()`

example
```javascript
const fs = require('fs');

let readDataCB = (err, data) => {
    if(err){
        console.log(`error occurs ${err}`);
    }else {
        console.log(`${data}`)
    }
};

fs.readFile('./file.txt', 'utf-8', readDataCB);
//first argument => file path, second => character encoding, third => error-first callback function
```

##### i. Readable Streams
For the line by line reading stream.
1. `readline` core module
2. `.createInterface()` method (This returns EventEmitter)
3. `fs.createReadStream()`
4. `'line'` event

example
```javascript
const fs = require('fs');
const readline = require('readline');

const myInterface = readline.createInterface({
    input: fs.createReadStream('text.txt')
});

myInterface.on('line', (fileLine)=>{
    console.log(`Line read: ${fileLine}`);
});
```
```javascript
const readline = require('readline');
const fs = require('fs');

const myInterface = readline.createInterface({
  input: fs.createReadStream('./shoppingList.txt')
});

const printData = data=>{
  console.log(`Item: ${data}`)
};

myInterface.on('line',printData);
```

##### ii. Writable Streams
1. fs.createWriteStream()

example
```javascript
const fs = require('fs');

const fileStream = fs.createWriteStream('output.txt');

fileStream.write('This is the first line');
fileStream.write('This line is the second.');
fileStream.end();
```

```javascript
const readline = require('readline');
const fs = require('fs');

const myInterface = readline.createInterface({
  input: fs.createReadStream('shoppingList.txt')
});

const fileStream = fs.createWriteStream('shoppingResults.txt');


const transformData = (data)=>{
  fileStream.write(`They were out of: ${data}\n`);
}

myInterface.on('line',transformData);
```


#### 9. Create an HTTP Server

`http` : node core module to listen and return responses.

* `http.createServer()`  This method returns an instance of http.server
(requestListener call back function is passed in)

http.server has
* `.listen()` 

**Remarks in requestListener**
1. two arguments: a request object, and a response object
2. Each time of a request, node will invoke the provided requestListener.
3. `response.end()` must to be called to express completion of the interaction.

example
```javascript
const http = require('http');

let requestListener = (request, reponse) => {
    response.writeHead(200, {'Content-Type':'text/plain'});
    response.write('Hello World!\n');
    response.end()
}

const server = http.createServer(requestListener);
server.listen(3000); // port number http://localhost:3000
```

[node-http in detail](https://nodejs.org/api/http.html)

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
