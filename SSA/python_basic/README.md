# Python 101 

## Jupyter notebook 환경설정
### 0) Jupyter notebook 설치

```powershell
$ pip install jupyter
```

### 1) 추가 확장 프로그램 설치

> 확장 프로그램은 [링크](https://jupyter-contrib-nbextensions.readthedocs.io/en/latest/index.html)를 통해 확인 가능하다. 
>
> 일부 확장 프로그램은 pip 추가 설치 해야하는 경우도 있다.

(1) pip를 통한 패키지 설치

```powershell
$ pip install jupyter_contrib_nbextensions
```

(2) JS, CSS 파일 설치

```powershell
$ jupyter contrib nbextension install --user
```

(3) 확장프로그램 목록 확인

http://localhost:8888/nbextensions

* 사용중인 확장 프로그램
  * Table of Contents (필수)

## 목차

1. [Intro to Python](./01_Python_intro.ipynb)

   1. 파이썬 기초

     * 식별자
     * 기초 문법
     * 
   2. 변수 및 자료형 

     * 수치형(numbers)
     * Bool
     * None
     * 문자형(string)
   3. 연산자

     * 산술 연산자
     * 비교 연산자
     * 논리 연산자
     * 복합 연산자
     * 기타 연산자
     * 연산자 우선순위
   4. 기초 형변환
   5. 시퀀스 자료형
     * 리스트
     * 튜플
     * 레인지
   6. set, dictionary
      * set
      * dictionary

2. Control of Flow

   1. 조건문 
   2. 반복문
   3. 함수

3. Data Structures 

   1. Lists
   2. Tuples/Sequences
   3. Sets
   4. Dictionaries

4. Control of Flow with Data Structures

5. Error and Exceptions

6. Classes

## License

[Python 라이선스 정책](https://docs.python.org/3/license.html)을 따라 GPL-3.0을 따릅니다. 

본 강의자료는 [Python Tutorial](https://docs.python.org/3.6/tutorial/index.html)를 참조하여 만들어졌습니다.
