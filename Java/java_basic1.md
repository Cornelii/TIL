# Java_basic1

### 1. Java SE (Java Platform Standard Edition)
    It's like design sheet, called specification aka spec.
    This is no a software itself! This java spec is made in JCP_java community process
### 2. JDK (Java Development Kit)
    Software according to Java SE
    Java for Developer
  * Java SE (Standard Edition)
  * Java EE (Enterprise Edition)
  * Java Me (Micro Edition)
### 3. JVM (Java Virtual Machine)
    Actual Enviroment Java works.
    It makes java operate in no matter what operating system is
### 4. JRE (Java Runtime Enviroment)
    JVM, Sorts of library, files to make java work in real.
    Java for users

 - java and javac in cli
    javac is for compiling

    > role of compiler: code -> byte code 


### hello world
```java
class HelloWorld{
    public static void main(String[] args){
        System.out.println("Hello World");
    }
}
```

javac HelloWorld.java -> HelloWolrd.class (byte code)

java HelloWorld 

"Hello World"

## Java?!

* Class unit-based language
* main() must exists for execution
* Virtual Machine (VM) only covers main()
  * process to execute : <>.java  -> <>.class -> JVM on any OS



## Keywords in Java

|abstract|continue|goto|pachage|



##  I. Remarks in Character and String

`System.out.println('c');`

* A character should be wraped in ' '

`System.out.println("cstring");`

* Strings should be wraped in " "
* Concatenation between string is available in Java

`System.out.println("Hellio "+"World");`

## II. Remarks in Variables

```java
/*
comment1
comment2
comment3
*/
public class VariableDemo{
    public static void main(String[] args){
        int a;          // for integer
        long a2=21575213L;
        a=1;
        System.out.println(a+1); //2
        System.out.println(a2); //21575213
        
        double b=1.3;      // for realnumber
        float c=1.3F;
        Syste.out.println(b); //1.3
        Syste.out.println(c); //1.3
        
        String z;            // for string
        z="Variables Yeah"
    }
}
```

### III. Data type

|section| data type | memory size | expressive range |
| --------- | ----------- | ------------------------------- | --------- |
| integer      | byte      | 1 byte      |-128 ~ 127|
|              | short     | 2           |-32,768 ~ 32767|
|              | int       | 4           |-2,147,483,648 ~ 2,147,483,647|
|              | long      | 8           |-9,223,372,036,854,775,808 ~ []|
| real numbers | float | 4 |~-1.4e-45 ~ ~3.4e+38|
|  | double | 8 |~-4.9e-324 ~ ~1.7e308|
| character | char | 2 |All Unicode letter|

### IV. Type Conversion

**1. Implicit conversion **
byte -> (short, char) -> int -> long -> float -> double
**2. Explicit conversion **
```java
float a= 100.0;
int b=100.0F;  // These do not work

float a=(float)100.0;
int b=(int)100.0F;  // These do work!
```
**(data-type)data-value** : explicit conversion

### V. Operators
- **+,-,*,/,%(remains)**

- **unary operators are available, ++,--**
- **==,!=,>,>=,<,<=,**
- .equals (comparison operator for string)

```java
public class EqualString{
    public static void main(String[] args){
        String a="wow";
       	String b=new String("Hey");
        System.out.println(a==b);
        System.out.println(a.equals(b));
    }
}
```
- **logical operator &&,||,! **
- **Tip** use () for multiple logical operators
### VI. Conditional Statements

#### IF

```java
//1.
if(true){
    
}
//2.
if(true){
    
}else{
    
}
//3.
if(true1){
    
}else if(true2){
    
}else{
    
}
```

```java
public class Authen{
    public static void main(String[] args){
        String id=args[0];
        String pass=args[1];
            if(id.equals("yesman")){
                if(pass.equals("1234")){ 
                	System.out.println("right");
                }
            }else{
                System.out.println("wrong");
            }
    }
}
```
#### SWITCH

```java
public class SwitchDemo{
    public static void main(String[] args){
        a=3; 
        switch(a){
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
                break;
            default:
                System.out.println("default");
                break;
        }
    }
}
```

### VII. Iterative statements

```java
//1. while
while(condition){
    
}
//2. for
for(int jmi=0;jmi<10;jmi++){
    
}
//Regarding Control break, continue
break;,continue;
```

### VIII. Array

```java
public class ArrayDemo{
    public static void main(String[] args){
		String[] classGroup={"Charles","Chandler","Cornelii"};   
        System.out.println(classGroup[0]);
        
        String[] classMate=new String[4];
        classMate[0]="Kevin";
        System.out.println(classMate[0]);
        System.out.println(classMate[0].length);//.length len of array
        
    }
}

```

#### Array-related java statements: for-each

```java
String[] members={"Ethen","Edan","Eric"};
for (String e:members){   // since java 5.0
    System.out.println(e+"saw consultant");
}
```

### IX. Method

#### format of method

```java
public class methodPrac{
// define method
    public static void numbering(){
        int jmi=0;
        while(jmi<10){
            System.out.println(jmi);
            jmi++
        }
    }
// main method
	public static void main(Stringp[] args){ //main method
    	numbering();  // call of numbering method defined above
	}
}
```

* **The main method is a regulation!!!**

#### Parameter & return value

```java
public class MethodDemo{
    public static String numbering(int init,int limit){
        in jmi=init;
        String output="";
        
        while(jmi<limit){
            output+=jmi;
            jmi++;
        }
        return output;
    }
    
    public static void main(String[] args){
        String result=numbering(1,5);
        System.out.println(result);
    }
}
```

* so far, 

* ```java
  public static [return_type] [fcn_name]([parameters with data type,]){
  
      return [return_value];                                             }
  // if there is no return_value: void
  ```

* If you want multiple return values, put in an array.



#### meaning of String[] args

This is a parameter. String[] is array.

### X. Input

```java
import java.util.Scanner;  // java lib, packages~~~

public class ScannerDemo{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);//sc.hasNextInt() gives boolean True if int type, False else.
        int i=sc.nextInt();
        System.out.println(i*1000);
        sc.close();
    }
}
```

```java
import java.util.Scanner;

public class Scanner2Demo{
    public static void main(String[] args){
        try{ //exception
            File file=new File("out.txt"); // file object?!
            Scanner sc=new Scanner(file); // file IO
            while(sc.hasNextInt()){
                System.out.println(sc.nextInt()*1000);
            }
            sc.close();
        } catch (FileNotFoundException e){ //exception
            e.printStackTrace();
        }
    }
}
```

### XI. OOP (Object-Oriented Programming)

 현실의 사물을 프로그래밍에 그대로 적용하고자 하는 목적에 기반한 개념.

즉, "추상화"를 통한 구현에 좀 더 적합한 프로그램 방식!

## XII. Class

```java
// class example
class Calculator{
    int left,right;
    
    public void setOprands(int left, int right){
        this.left=left;
        this.right=right;
    }
    public void sum(){
        System.out.println(this.left+this.right);
    }
    public void avg(){
        System.out.println((this.left+this.right)/2);
    }
}

public class CalculatorDemo4{
    public static void main(String[] args){
        Calculator c1= new Calculator();
        c1.setOprands(10,20);
        c1.sum();
        c1.avg();
    }
}
```

### XIII. Class member and Instance member

```java
class Calculator{
    static double PI=3.14; // Class member by static.
    int left,right;
    
    public void setOprands(int left,int right){
        this.left=left;
        this.right=right;
    }
    public static void sum(int left, int right){  // Class method by static
            System.out.println(left+right);
    }
}
```

 **Remarks**

1. Instance method can go up to class member.
2. class method cannot go up to instance member.