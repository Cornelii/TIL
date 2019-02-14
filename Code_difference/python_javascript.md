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

## . Import 
Import statment is different between them.
Even export statements exists in javascript.

python example
```python
import os, sys

import numpy as np
from flask import Flask as Fk

from A import *

```

javascript example
```javascript
import A

import {a,b,c,d,e}

import * as Alias from "./filename" 
// "import filename as Alias"   in python
```
