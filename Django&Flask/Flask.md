# Flask

## Baseline of flask!

```python
from flask import Flask, render_template, request, redirect

app = Flask(__name__)

@app.route('/')
def index():
    return render_template("index.html")

@app.route('/example')
def example():
    return redirect("/")

```
1. Flask object tapp must be generated first.
2. @{Flask object}.route("/{url}") is a decorator
3. Root url => "/", with following function where name of index conventionally.
4. Coincide url and decorated function name.
5. return must be stated according to Flask grammer

## 1. Variable URL
flask can get a variable in the form of string by url.

example
```python
@app.route("/example/<int:var_name>")
def example(var_name):
    return var_name
```
1. get variable that is located at<int:var_name>. 
2. int: means type conversion from string to integer
3. function should recieve argument the defined var_name

## 2. render_template
render_template have a role to link a function to a html document!

**Remarks**: According to flask's convention, html documents should be in the directory named `templates`. This can be modified in the step of Flask object declaration.

* Using Jinja, render_template facilitates variable transfer to html document!!

example
```python
@app.route("/example")
def example():
    var = 5
    return render_template("example.html", var = var)
# call example.html offering value of var.
```

## 3. GET & POST
Fundamentally, there are two ways to send and receive data in web.
GET & POST.
**remarks** data through GET is shown in url. but not for the case of POST!

POST is safter. (RESTful WEB Service!)

In flask, all the information regarding received data are contained **request**

It works with `FORM tag` in html.

1. to get data through GET
   * request.args.get({name defined at form tag})

2. to get data through POST
   * request.form.get({name defined at form tag})

example
* at python
```python
# GET
@app.route("/example_get") # default get
def example_get():
    data = request.args.get("data")
    return data

@app.route("/example_post", methods=["POST"]) #or ["POST","GET"]
def example_post():
    data = request.form.get("data")
    return data

```
* at html
```html

<!-- GET -->
<form action="example_get" method="GET"> 
    <!-- input tags blablabla -->
<form>

<!-- POSt -->
<form action="example_post" method="POST"> 
    <!-- input tags blablabla -->
<form>

```

## 4. redirect
Redirect itself hand over the link to other with function operation.

example

```python
@app.route("/example")
def example():
    data = request.form.get("data")
    print(data) # printed at console

    return redirect("/") # to the root
```

This has difference with render_template("index.html"):

`render_template("index.html")` cannot use generated data in index().
Restatement is needed if want.
It just means call index.html

but `redirect("/")` can use `render_template("index.html",data=data)` in index().


