# Nodejs
Javascript Framework built on Chrome V8 javascript Engine.
Javascript starts to take web and local.

You can make local app using javascript by node with appripriate packages.


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

## Get inputs
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