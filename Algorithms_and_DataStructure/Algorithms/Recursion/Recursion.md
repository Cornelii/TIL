# Recursion

Remember the example. How many people is waiting in a line?!

In programming, recursion means a function definition that include an invocation of the function within its own body.

* This requires the function invoking itself with different arguments!

#### Fundamental aspects of recursion

1. Base case
    Without base case => infinite loop.

2. Recursive step
    a step toward base case


**Remarks**: The best way to understand recursion is with a lot of practice.

#### Stack overflow
As recursion depth goes deepder, memory cannot be taken any more. => stack overflow

Recursion has costs that iteration does not.

* Recursion is less efficient than iterative solution because of call stack.

#### Beauty of recursion is how it can reduce complex problems to elegant soltion of only a few lines of code.

#### flatten example

```python
def flatten(arr):
    result = []
    for val in arr:
        if isinstance(val,list):
            result += flatten(val)
        else:
			result.append(val)
    return result

```
#### Binary Search Tree
Data Structure also can be recursive itself.

```python
def build_bst(my_list):
  if len(my_list) == 0:
    return "No Child"

  middle_index = len(my_list) // 2
  middle_value = my_list[middle_index]
  
  print("Middle index: {0}".format(middle_index))
  print("Middle value: {0}".format(middle_value))
  
  tree_node = {"data": middle_value}
  tree_node["left_child"] = build_bst(my_list[ : middle_index])
  tree_node["right_child"] = build_bst(my_list[middle_index + 1 : ])

  return tree_node

sorted_list = [12, 13, 14, 15, 16]
binary_search_tree = build_bst(sorted_list)
print(binary_search_tree)
```

