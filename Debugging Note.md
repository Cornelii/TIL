# Debugging Note

## 1. github

### gray directory in github remote repository

It's called a sub-module

* solution

git rm --cached <directory name>

### .gitignore is not applied

git rm -r --cached .

git add .

git commit -m "Apply .gitignore"

**Tips for .gitignore**



## 2. Python
*.a all         the .a files

!lib.a          except lib.a

/TODO            ignore TODO file in the current directory

build/           ignore all files in the build diriectory

doc/*.txt        ignore all the *.txt at doc directory. not applied to subdirectory

doc/**/*.pdf     ignore all the .pdf files in the doc/ directory



## 3. Java

### unmappable character for encoding x-windows-949

when compiling,

* solution

adding -encoding UTF-8 option.

ex) javac Main.java -encoding UTF-8





