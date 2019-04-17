# Nodejs


## Get inputs
example
get one-line
```node
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


```node
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


