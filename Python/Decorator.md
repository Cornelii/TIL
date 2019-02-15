# Python Decorator

## I. Closure
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

## II. First class function
python handle function as first class function

Fuctions can be parameters of others!

They can be considered as one of objects.

## III. Decorator

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

