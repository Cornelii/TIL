import os

a= os.listdir()
up_to_date=a[-3]

day_count=int((up_to_date[0:4])[3:])+1

try:
    os.mkdir("day{}".format(day_count))
    print("day{} directory has been successfully made".format(day_count))
except:
    print("Failed to make the directory")

basic_structure='''
# day{}

## I.
### 1. Concepts
### 2. Practice


**Tip**
**Tip**
## II.
### 1. Concepts
### 2. Practice

**Tip**
**Tip**

## III.
### 1.Concepts
### 2.Practice

**Tip**
**Tip**
## IV.
'''.format(day_count)

try:
    with open("day{}.md".format(day_count),'w') as f:
        f.write(basic_structure)
    print("day{}.md has been successfully made".format(day_count))
except:
    print("Failed to make the markdown document")
