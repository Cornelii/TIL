# Python_function

## I. keyword Arguments

**Keyword argument must be behind positional arguments**



## II. Variable Arguments

Variable arguments are to get unspecified number of argument.

It is handled in terms of tuple.

*Asterisk means variable Arguments ex) *argument

```python
def my_max(*args):
    arg=list(args)
    result=arg[0]
    while True:
        try:
            barg=arg.pop()
            if barg>=result:
                result=barg
        except:
            return result
```



## III. how to handle Undefined Arguments

They are handled in terms of dict

** two Asterisk means Undefined Arguments ex) **kwargs

```python
def hello_in_world(**kwargs):
    print(kwargs)
    
hello_in_world(한국어='안녕', 영어='hi', 독일어='Guten Tag') ## NO "" in key part
#{'한국어': '안녕', '영어': 'hi', '독일어': 'Guten Tag'}
```

```python
class Auth:
    def __init__(self):
        print("Auth system opens")
        self.D={}
        self.s='http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?itemPerPage=10key=abc&tagetDt='
    def signUp(self,key,username):
        self.D[key]=username
        
    def url_call(self,**kwags):
        if kwags["key"] in self.D:
            return self.s+"{}&".format(kwags["tagetDt"])

auth=Auth()
auth.signUp("abc","Cornelli")

api = {
    'key': 'abc',
    'tagetDt': '20190104'
}

auth.url_call(**api) ## Remarks! ** needed also when calling function by dictionary
```

## IV. Name Space and Scope

* Local
* Enclosed
* Global
* Built-in
* L->E->G->B

**When you want to change a global variable in local scope**

```python
b=4
def a(c):
    global b#global
    b=3
    return c

a(2),b
```



