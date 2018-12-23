# Python: Iterator & Generator

## I. Concept

### 1. Iterator

List, Set ,Dictionary, Sequence 등을 for문을 써서 하나씩 그 안의 데이터를 처리할 수 있게 하는 

것이 **Iterable Object(Iterator)**이다.



예전에는 클래스의 __getitem__을 통해 for문에서 호출해 왔다.

```python
#Example getitem-> indexing 지원
class Seq:
    def __init__(self):
        self.lst=[1,2,3,4,6,7,8]
    def __getitem__(self,k):
        line=self.lst[k]
        if not line: raise IndexError
        return line

a=Seq()
for entry in a:
    print(entry)
```



**iter()** : generate Iterator object

It has **__next__()** method.

```python
# example
L=[1,2,3,4,5]
iterL=iter(L) 
iterL.__next__() ## Built-in function next() is available
iterL.__next__()
iterL.__next__()

for jmi in L:  # L automatically assigned in the form of Iterator iter()
    print(jmi)
```

#### i) To make a Class as an iterator

When some instances from a Class stand in "for  in "sentence,

Automatically, `__iter__()` was called and so `__next__() ` again and again

until it reaches `StopIteration` or other kinds of Errors

```python
class Seq:
    def __init__(self):
        self.lst=[1,2,3,4,6,7,8]
        
        
	def __iter__(self):   ### iter(instances)
        self.index=0
        return self  ### Remarks it return self
    
    def __next__(self):   ### when Seq instances go into "for in "statement
        if self.index>=len(self.lst):   #iter() -> __next__() again and again
            raise StopIteration  ### Remarks raise StopIteration
        result=self.lst[self.index]
        self.index +=1
        return result
        

a=Seq()
for entry in a:
    print(entry)
```



#### ii)** Dictionary** itself is an **Iterator** with respect to its **Key**

items(),keys(),values()

if you want to make use them as list. list() is needed.



#### iii) File object itself is given as an Iterator

```python

```

### 2. Generator



```python

```







## Practice

