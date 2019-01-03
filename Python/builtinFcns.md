# Python built-in functions

| function1                      | description2                                                 |
| ------------------------------ | ------------------------------------------------------------ |
| abs()                          | absolute value                                               |
| all()                          | Return True, if all (Iterable) True                          |
| any()                          | Return True, if any (iterable) True                          |
| ascii()                        | It's like repr()                                             |
| bin()                          | integer number to binary string with "0b"                    |
| bool()                         | Return boolean value                                         |
| callable()                     | Return True if object argument appears callable, for Class, __call__() method |
| chr()                          | Return String                                                |
| @classmethod                   | Transform a method into a class method. (decorator)          |
| compile(source,filename)       |                                                              |
| complex()                      | Return a complex number with real+imag*1j                    |
| dir(object)                    | Without arguments, return the list of names in the current local scope.   with an argument, return a list of a valid attributes for that object |
| divmod(a,b)                    | return a//b,a%b                                              |
| enumerate(iterable)            | iterator. check list(enumerate([5,4,7,5]))                   |
| eval(expression)               | string=> evaluated as a Python expression                    |
| exec()                         |                                                              |
| filter(function,iterable)      | When function return True it conserves the entry             |
| float()                        | data-type conversion                                         |
| format()                       |                                                              |
| bytes()                        |                                                              |
| bytearray()                    |                                                              |
| frozenset()                    | return a new frozenset object                                |
| getattr()                      | ex) getattr(x,"foobar")==x.foobar                            |
| globals()                      | return a dictionary representing the current global symbol table |
| hasattr(object,name)           | return true if the string is the name of one of the object's attributes |
| hash(object)                   | return the hash value                                        |
| help(object)                   |                                                              |
| hex()                          | interger number to hexadecimal string                        |
| id(object)                     | Return the "identity"                                        |
| input([prompt])                | get value in the form of string                              |
| int()                          |                                                              |
| isinstance(object,class)       | Return true if the object argument is an instance of the class |
| issubclass(class,classinfo)    | Return true if class is a subclass of classinfo              |
| iter(object)                   | return iterator object                                       |
| len(s)                         | Return the length                                            |
| list()                         |                                                              |
| locals()                       | Return a dictionary representing the current local symbol table |
| map(func,iterable)             | func(entry in iterable)                                      |
| max(iterable,)                 |                                                              |
| memoryview(obj)                | Return a "memory view" object                                |
| min()                          |                                                              |
| nexet(iterator)                | __next__()                                                   |
| object                         | Return a new featureless object (basically class?!)          |
| oct(x)                         | Integer => octal string                                      |
| open()                         | kind of file pointer                                         |
| ord(c)                         | return an integer representing the Unicode code point of that character inverse of chr() |
| pow(x,y)                       | x**y                                                         |
| print()                        |                                                              |
| property                       | Return a property attribute                                  |
| range()                        |                                                              |
| repr()                         | __repr__()                                                   |
| reversed(seq)                  | Return a reverse iterator. seq must be an object which has a __reversed__() |
| round()                        | Return number rounded                                        |
| set()R                         | Return a new set                                             |
| setattr(object,name,value)     | == object.name=value, counterpart of getattr()               |
| slice(start,stop[,step])       | Return a slice object                                        |
| sorted(iterable,reverse=False) | Return a now sorted list from the items in iterable          |
| @staticmethod                  | Transform a method into a static method. (static method does not receive an implicit first argument "self"), decorator |
| str()                          | return a str version of object                               |
| sum(iterable)                  |                                                              |
| super().                       | kind of "self" of super class                                |
| tuple()                        |                                                              |
| zip(*iterables)                |                                                              |
| vars(object)                   | return the __dict__ attribute                                |
| dir()                          |                                                              |
| delattr(object,name)           |                                                              |
| dict()                         |                                                              |
|                                |                                                              |