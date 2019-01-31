# Python_function

## I. Variable Arguments

Variable arguments are to get unspecified number of argument.

It is handled in terms of tuple.

*Asterisk means variable Arguments ex) *argument

```python
def my_max(*args):
    arg=list(args)
    result=arg[0]
    while True:
        try:
            barg=arg.pop()
            if barg>=result:
                result=barg
        except:
            return result
```

## II. keyword Arguments

**Keyword argument must be behind positional arguments**

def func(a,b,c,*args,**kwargs)
def func(1,6,2,7,3,8,5,d=1,f=6,g=81)


## III. how to handle Undefined Arguments

They are handled in terms of dict

** two Asterisk means Undefined Arguments ex) **kwargs

```python
def hello_in_world(**kwargs):
    print(kwargs)
    
hello_in_world(한국어='안녕', 영어='hi', 독일어='Guten Tag') ## NO "" in key part
#{'한국어': '안녕', '영어': 'hi', '독일어': 'Guten Tag'}
```

```python
class Auth:
    def __init__(self):
        print("Auth system opens")
        self.D={}
        self.s='http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?itemPerPage=10key=abc&tagetDt='
    def signUp(self,key,username):
        self.D[key]=username
        
    def url_call(self,**kwags):
        if kwags["key"] in self.D:
            return self.s+"{}&".format(kwags["tagetDt"])

auth=Auth()
auth.signUp("abc","Cornelli")

api = {
    'key': 'abc',
    'tagetDt': '20190104'
}

auth.url_call(**api) ## Remarks! "**" needed also when calling function by dictionary
```

## IV. Name Space and Scope

* Local
* Enclosed
* Global
* Built-in
* L->E->G->B

**When you want to change a global variable in local scope**

```python
b=4
def a(c):
    global b#global
    b=3
    return c

a(2),b
```

## V. Closure
Closure save **free variables** with some function.
**free variable** is variable that is not defined in function, but used.
ex)
```python
def func1():
    name="Cornelii"

    def func2():
        print(name)
    
    return func2

func3 = func1()

func3()
# Cornelii.


# name is defined in func1 local name space.
# but func3 refer the name.
# how?! That is the role of closure!!
# And, the name is a free variable.
```
Closure play the role in saving func2 with the name!

**Remarks!!** Using closure property, Wrapped function can be easily implemented.



## VI. Decorator


example
```python
def deco_fcn(func):
    def wrapper():
        print("added work!")
        return func()
    return wrapper

def func1():
    print("This is func1")

def func2():
    print("This is func2")


func_1 = deco_fcn(func1)
func_2 = deco_fcn(func2)

func_1()
# added work!
# This is func1

func_2()
# added work!
# This is func2
```
Above code is basic principle of decorator!
**Decorator** gives another operation to other functions!!

Following is a case of decorator for functions with parameters

example
```python
def deco_fcn(func):
    def wrapper(*args,**kwargs): ## This is points!!
        print("added work!")
        return func(args[0],args[1])
    return wrapper

def func1(a,b):
    print("This is func1")
    return a,b

def func2(a,b):
    print("This is func2")
    return b,a

func_1 = deco_fcn(func1)
func_2 = deco_fcn(func2)

d1 = func_1(1,7)
print(d1)
# added work!
# This is func1
# (1,7)

d2 = func_2(1,7)
print(d2)
# added work!
# This is func2
# (7,1)
```

#### In python, decorator is expressed with 'at (@)' mark before decoration function that should be located on the definition of the other functions like as follows

```python
def deco_fcn(func):
    def wrapper(*args,**kwargs): ## This is points!!
        print("added work!")
        return func(args[0],args[1])
    return wrapper

@deco_fcn
def func1(a,b):
    print("This is func1")
    return a,b

@deco_fcn
def func2(a,b):
    print("This is func2")
    return b,a

d1 = func1(1,7)
print(d1)
# added work!
# This is func1
# (1,7)

d2 = func2(1,7)
print(d2)
# added work!
# This is func2
# (7,1)

```
This is so useful to give another function to other functions!!
