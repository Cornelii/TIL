# Python_Class

## 1. Making Private Member



_ _ [name] => automatically changed to _[class name]__[name]

```python
class A:
    def __init__(self):
        self.__a=30

class_A=A()        
print(class_A._A__a)
# 30
print(class_A.__a)# error
```

## 2. user-defined module

for using "import,  from import, etc"

The directory, which contains user-defined modules, define path as a name of "PYTHONPATH"

