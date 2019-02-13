# Difference between Python and Javascript


## . Class  

#### . self & this


#### . Static method
For the python static method in class is also available in the instances. However, not for the javascript.
```python
class Myclass:
    def __init__(self):
        pass

    @staticmethod
    def mycunf1(val):  ## Remarks: self is not used as the first argument!
        pass
```

```javascript
class Myclass {
    consturctor (val1,val2) {}
    static myfunc1 (val) {}
}
```