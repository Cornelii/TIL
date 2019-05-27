# Express
Starting a Server

Express is a Node module.

## I. Express Basics
```javascript
const express = require('express');
const app = express();
// this app is used to start a server and specify server behavior.
```

First, we have to tell the server where to listen by providing a port number.

```javascript
const PORT = process.env.PORT ||  4001;
app.listen(PORT, ()=>{
    console.log(`Server is listening on port ${PORT}`);
});
//The callback function on second argument will be called once the server is running and ready to receive responses.
```
#### 1. Writing basic route
`app.get()` register routes matched with GET HTTP method.

```javascript
const moods = [{mood:'excited about express!'},{
    mood: 'route-tastic!'
}];
app.get('/moods', (req, res, next) => {

});
```

method of response `.send()` for sending response
`.json()` can be used as well for jason response.

```javascript
const express = require('express');
const app = express();

const PORT = process.env.PORT || 4001;


const expressions = ['something','something','anything'];

// Get all expressions
app.get('/expressions', (req, res, next) => {
  // console.log(req);
  res.json(expressions);
});

app.listen(PORT, () => {
  console.log(`Listening on port ${PORT}`);
});
```


#### 2. Matching Route Paths
Express tries to match requests by route, meaning that if we send a request to

Express searches through routes in the order that they are registered in your code. The first one that is matched will be used, and its callback will be called.


#### 3. Getting A single Expression

##### i. Route Parameters
`/posts/:id`

Express parses any parameters, extracts their actual values, and attaches them as an object to the request object: req.params.

example
```javascript
// GET /people/josn
app.get('/people/:name', (req, res, next) => {
  console.log(req.params) // { name: 'hydra' };
  res.send(req.params.name);
});
```

##### ii. Status Code
`res` object has a `.status()` method to allow us to set the status code. `.send()` can be chained from it.

example
```javascript
app.get('/people/:name', (req, res, next) => {
  const person = person_list[req.params.name];
  if (person) {
    res.send(person);
  } else {
    res.status(404).send(`${req.params.name} not found on the list`);
```

##### iii. Other Http Methods
`app.get()`, `app.put()`, `app.post()`, `app.delete()`, etc


Query String is parsed into an object and saved in `req.query`

example of `put`

```javascript
app.put('/people/:id', (req, res, next) => {
  if (existence_check) {
    // data update
    people[req.params.id] = req.query;
    res.send(people[req.params.id]);
  } else {
    res.status(404).send();
  }
});
```

Express looks for call back function with HTTP methods and route at the same time.


example of `post`
```javascript
app.post('/people', (req, res, next)=>{
  const person = //created object (req.query);
  if (person){
      people.push(person);
      res.status(201).send(person);
  }else{
    res.status(400).send();
  }
})
```


example of `delete`
```javascript
app.delete('/people/:id', (req, res, next)=>{
  if(existence_check){
    // delete the row
    res.status(204).send();
  }else{
    res.status(404).send();
  }
})
```

#### 4. Express.Router

To use a router, we mount it at a certain path using `app.use()` and pass in the router as the second argument.

```javascript
const express = require('express');
const app = express();

app.use(express.static('public'));

const peopleRouter = express.Router();
app.use('/people', peopleRouter);

// `/people` is assumed to be prepended
peopleRouter.get('/:id',(req, res, next)=>{
  //...
})
```

##### i. Using multiple router files
To make code clean with separating each router in its own file.

people.js
```javascript
//people.js
const express = require('express');
const peopleRouter = express.Router();

peopleRouter.get('/:id', (req, res, next)=>{
  //...
})

module.exports = peopleRouter
```

main.js
```javascript
const express = require('express');
const app = express();

const peopleRouter = require('./people.js');

app.use('/people', peopleRouter);
```


## II. Middleware
To reduce replication and complexity.

DRY (Don't Repeat Yourself)

MiddleWare: Code that executes between a server receiving a request and sending a response.

`app.use()` takes a callback function that it will call for every received request.

[express-middleware](http://expressjs.com/en/guide/using-middleware.html)


#### i. `next()`

example
```javascript
app.use((req, res, next)=>{
  console.log('step1');
  next()
})

app.get('/people', (req, res, next)=>{
  console.log('get2');
  next()
})

app.get('/people', (req, res, next)=>{
  console.log('get3');
})

app.get('/people', (req, res, next)=>{
  console.log('get4');
})

// localhost:4001/people
// console
// step1
// get2
// get3
```
No output is comming regarding get4 because above callback fcn does not explicitly call `next()`.

All the Express routes are middleware!

#### ii. Route-level app.use() - Single Path
```javascript
app.use('/url', (req, res, next)=>{
  // executed regardless of HTTP method!!

  next()
})
```

#### iii. Route-level app.use() - Multiple Paths
`app.use()` also can take an array of paths or regular expression pattern to match patchs as well.


#### iv. Middleware Stacks - multiple callback fcn
for `app.use()`, `app.get()`, `app.post()`, etc.
exampel

```javascript
const auth = (res, req, next)=>{
  //...
}

const valid = (res, req, next)=>{
  //...
}

app.get('/people', auth, valid);
```

Callback functions will be executed in order.


#### v. Open-source Pacakage

ex)

[morgan](https://github.com/expressjs/morgan)

`morgan()` is a function that will return a middleware function.

example
```javascript
const express = require('express');
const app = express();
const morgan = require('morgan');
app.use(express.static('public'));

// Logging Middleware (console.log)
app.use(morgan('tiny'));
```

