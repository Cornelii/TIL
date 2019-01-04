import json

D={'a':1,'b':2,'c':3,'d':4}
print(D)

# json Encoding python object -> json
## 1
A=json.JSONEncoder().encode(D)
print(A)

## 2
B=json.dumps(D,indent=4)
print(B)

# kspm Decoding json -> python object
## 1
Ad=json.JSONDecoder().decode(A)
print(Ad)
print(type(Ad))

## 2
Bd=json.loads(B)
print(Bd)
print(type(Bd))

# json file save and load
## save
with open("test.json",'w',encoding="utf-8") as f:
    f.write(B)
## load
with open("test.json",'r',encoding="utf-8") as f:
    F=f.read()

    print("F: {}, F's type: {}".format(F, type(F)))