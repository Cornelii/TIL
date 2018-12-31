# Java_basic2

## I. Effective range (Scope)

Variables in method are can not be referred from outside the method.

```java
public class ScopeDemo2{
    static int i; // a global variable
    
    static void a(){
        i=0;
        //int i=0;  // a local variable. it resolves the infinite loop below.
    }
    
    public static void main(String[] args){
        for (i=0/*int i=0 this is a also local one*/;i<5;i++){  
                                     // Infinite Loop.
            a();
         	System.out.println(i)          
        }
    }
    
}
```

## II. Scope of instances

To refer a global variable!. => use **this.**

## III. Initialization and Constructor

```java
// A constructor example
class Calculator{
	int left, right;
    
    //// Constructor: no return value, same function name as the class name
    public Calculator(int left, int right){
        this.left=left;
        this.right=right;
    }              
    ////
    
    public void sum(){
        System.out.println(this.left+this.right);
    }
    public void avg(){
        System.out.println((this.left+this.right)/2);
    }
}

public class CalculatorDemo1{
    public static void main(String[] args){
        Calculator c1=new Calculator(10,20);
        c1.sum();
        c1.avg();
        
        Calculator c2=new Calculator(20,40);
        c2.sum();
        c2.avg();
    }
}

```

## IV. Inheritance (extends)

* **Important concept in OOP**
  * Super <=> Sub class
  * Base <=> Derived class

class SubClass extends SuperClass{}

```java
class Calculator{             
    int left, right;
    //public Calculator(){}
    public Calculator(int left, int right){
        this.left=left;
        this.right=right;
    }
    
    public void sum(){
        System.out.println(this.left+this.right)
    }
    
    public void avg(){
        System.out.println((this.left+this.right)/2)
    } 
}

class SubCal extends Calculaotr{  // This is how to make inheritance relationship
    public SubCal(int left,int right){
        super(left,right); // Super class constructor!
        // To invoke subclass's member have to follow super()
    }
    
    public sub(){
        System.out.println(this.left-this.right)
    }
}

public class CalDemo2{
    public static void main(String[] args){
        Calculator c1=new Calculator(10,20);
        
        SubCal s1=new SubCal(20,50);    
        
    }
}
```

**Important thing**: When sub class is being invoked, so the basic constructor of the superclass does automatically.!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

**Solution**

1. Add basic constructor in the super class.
2. using super() in constructor of sub class.

## V. Overriding

When subclass inherit from super one, methods can be redefined using same name, but different functions.

**For overriding. return data type, and parameters must coincide one another!**

`ex) public void avg(int i, int j)`

`in subclass, public void avg(int k, int l) //only void, and two int parameters!`

`It is told super and sub class have same signature. so overriding is available.`

* name of method
* return type of method
* number, data type and order of parameter in method

**'this' implies this class, 'super', super class**

## VI. Overloading

In a Class, even if using same name, but different methods, 

Different data-type and number of parameter is recognized as overloaded methods! 

**Remarks!. **However,different return-type is not counted. Cause, return-type itself is not information transferred at the time when the function is called.

## VII. Class path

This about how to load classes.



When compile a *.java source code file by javac, the *.class files as many as defined class in the source file are generated. 



ex)`java -classpath ".;lib" ClasspathDemo2` : ClasspathDemo2의 실행을 위해 필요한 class파일들을

"."현재 디렉토리에서 찾다가 없으면, "lib"에서 찾아봐라!



**Java use environmental variable "CLASSPATH" as class path.**

## VIII. Package

[project_directory]/src/name1/name2/name3/name4

"src": source codes directory

**"bin": complied class files directory**

name1/name2/name3/name4 => package name

```java
package name1.name2.name3.name4;

class ~~~
```

source codes in one package can be handled like one source file!! (like C++ linker)

However, if they exists in different packges, "import package.~~ " is needed



"-d [directory name]": 

at CLI

java [source code] -d [directory name]

It saves class file in designated directory



## IX. API and API Documents

import java.lang.* // this is kind of default. (It facilitates use of System.out.println())

**API: Application Programming Interface**

**UI: User Interface**

[JAVA API](https://docs.oracle.com/javase/7/docs/api/)



## X. Access Modifier

## XI.

## XII. 

## XIII.

## XIV.

## XV. 

