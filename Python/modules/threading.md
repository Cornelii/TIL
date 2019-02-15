# Thread


## thread

## threading

#### 1. function and method way
example
```python
import threading

def func1(p1, p2):
    pass

def func2(p1, p2):
    pass

t = threading.Thread(target = func1, args=(1, 100000))
t2 = threading.Thread(target = func2, args=(2, 54000))

t.start()
t2.start()

print("Done")
```
If function need argument. it is handed over in terms of args or kwargs

#### 2. by class
example
```python
import threading

def func1():
        pass

def func2():
    pass

class Myclass(threading.Thread):
    def __init__(self):
        pass
    
    def run(self):
        func1()
        func2()
        print("Done")

t = Myclass()
t.start() # .start() execute run in class
```
Just declare class,which inherit threading.Thread, and make `run` method in it.
After generating instance, .start() execute the `run` method in class!

**remarks**: Thread instance has `daemon` property representing daemon thread*
**default: False (not daemon thread)**

* daemon thread : thread that quit as soon as main thread finishes. 

## multiprocessing
You have to use multiprocessing module for parallel execution on multiple CPU core.
