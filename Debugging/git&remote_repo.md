# github


## I. git

#### 1. gray directory in github remote repository

It's called a sub-module

* solution

git rm --cached <directory name>

#### 2. .gitignore is not applied

git rm -r --cached .

git add .

git commit -m "Apply .gitignore"

**Tips for .gitignore**
```
*.a all         the .a files

!lib.a          except lib.a

/TODO            ignore TODO file in the current directory

build/           ignore all files in the build diriectory

doc/*.txt        ignore all the *.txt at doc directory. not applied to subdirectory

doc/**/*.pdf     ignore all the .pdf files in the doc/ directory
```

#### 3. Page build failure
`The page build failed for the 'master' branch with the following error`

Add empty file named `.nojekyll` into the repository.

#### 4. When git push, Git keep asking for username & password

1. in the specific repository
2. `git config credential.helper store`

then push once more with username & passwordss