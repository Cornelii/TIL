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


### 2. managing function call



### DFS algorithm



### 3. calculator

#### making postfix by stack
1. Read token
2. If  Operand, printout
3. If Operator (includeing paranthesis)
        * High priority: stack push, lower
        * Lower priority: Pop from stack until lower-priority operator come out, after that push
        * If no operator on top: Push
4. If token is right paranthesis ")"
    * stack pop until, "(" be on top
    * Print out popped operators
    * When meet "(" jsut pop without print out

5. If nothing to read more, stop, otherwise loop from 1.
6. After that, all pop operators on stack
**Remarks** There are priority table called ISP ICP.
They are different inside and outside of stack, 
!! left paranthesis ( lowset inside stack, highest outside stack)

|token|ISP|ICP|
|---|---|---|
|)|-|-|
|*,/|2|2|
|+,-|1|1|
|(|0|3|

example (6+5*(2-8)/2)

> : [Stack]
> (
* 6
> (+                  // + has higher priority)
* 65
> (+*
> (+*(
* 652
> (+*(-
* 6528
> (+*(-               when meet )
* 6528-
> (+*(               get rid of "(" with ")"
> (+*
> (+*         * == / in priority, therefore pop
* 6528-*
> (+/
* 6528-*2
> (+/                   when meet )
* 6528-*2/+            and get rid of "(" with ")"
> nothing
formula has done. => stack is empty => close

#### Calculating postfix by stack

1. When meet operands, push to stack
2. When meet operators, required number of operands are popped from stack and push the result.
3. When done, last pop the stack.

example) 6528-*2/+   
> 6
> 65
> 652
> 6528
* 2-8 = -6 push   (carful the order. first out come latter)
> 65 -6
* 5 * -6 = -30 push
> 6 -30 2
* -30 / 2 =-15 push
> 6 -15
* 6 + -15 =-9 push
> -9  and pop
* -9
> empty

-9

python's built-in function `eval()` work in the same way

### 4. Back Tracking
1. When being blocked during finding solution.
2. Return and find again.
3. This is for Optimization and Decision problems.
**Decision problems:** Yes or no according to whther solution exists or not
like, n-Queen, Subset sum, Map coloring, Maze

It is like DFS. but difference as follows in table.
|backtracking|DFS|
|---|---|
|if it cannot turn out to be solution no more following -> prunning|Track all the path|
|early stop|for the N! almost impossible|
|for the N! maybe possible but difficult in time|screening every candidate|

* Backtracking come back to parent node ahead child node if some node is not promising.
**promising**: can a node be on the path to solution!
**Pruning**: no more search on non-promising node.

#### General procedure using backtracking algorithm
1. Make up state space tree
2. Check each node is promising or not
3. If a node is not promising, go back to parent and keep searching to another way