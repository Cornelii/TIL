#FILE IO in python

# open file
# 1. read
# 2. write
# 3. append
# close file

# DB open(connect) -> CRUD
# 1.make(create)
# 2.read (read/retrieve)
### 2.1 write???!
# 3.modify(update)
# 4.delete(delete/destroy)
# DB close(disconnect)

# key-value pair + keen methods => object
# ORM: It plays very important role in modern computer engineering.
# ORM is famous tech interview subject
# ORM is kind of program on DB. (object relational mapping)

s="File IO test"
with open("names.txt",'w',encoding="utf-8") as f:
    f.write("JiMyeong Son, Cornelii in Eng")
## with: open한 파일을 임시적으로 제어하고, 제어가 끝나면 자동으로 닫아준다.
with open("names.txt",'r',encoding="utf-8") as f:
    s1=f.read()
print(s1)

with open("names.txt",'a',encoding="utf-8") as f:
    f.write(s)
    f.write("\n"+s)

## .csv (import csv) => 2d-list
# 1.read
# 2.write
# 3.Append

## .json (import json) => dictionary
# 1.read
# 2.write
# 3.append

# with 키워드 활용 -> 코드를 간결하게