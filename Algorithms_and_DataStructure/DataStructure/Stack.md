# Stack
1. highly useful datastructure in program
2. Linear structure (1:1 relationship with data)
3. LIFO (Last-In-Fist-Out) 1,2,3 => 3,2,1

## For the implementation of Stack
1. Data storage is needed 
    * C: array
    * Python: List
2. Storage itself is called Stack
3. Last inserted element is called **top**
4. Stack Operation
    * Push (insert)
    * Pop (retrieving)
    * isEmpty (check emptiness)
    * peek (only refer)

Stack in python
```python
def push(s,item):
    s.append(item)

def pop(s):
    if len(s)==0:
        print("Stack is Empty!") #underflow
        return
    else:
        return s.pop(-1)
s=[]
push(s,1)
push(s,2)
print("pop item=>",pop(s))
print("pop item=>",pop(s))
```

Remarks
1. When using List for Stack,
    * It is easy but, revising the size of list costs so much inducing overhead.
    * Solution:
      * First fix size
      * or use dynamic linked list


## Applications of Stack

### 1. Parenthesis, brace, and bracket check!
condition
    1. left parenthesis are as many as right ones
    2. left one come first 
    3. Only belonging relationship is valid. ex) (a{b)[d}] => wrong

**Paranthesis check algorighm outline**
1. search paranthesis in string by order
   1. If meet left one=> push to stack
   2. If meet right one 
      1. pop at top of stack => camparison
         1. Stack empty -> Wrong
         2. No matching -> Wrong
         3. After all the search finished, still stack has paranthesis => Wrong


