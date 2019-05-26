# Express
Starting a Server

Express is a Node module.

## Express Basics
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

#### 4. File?!
