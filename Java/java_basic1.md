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

##### i. JVM memory structure
Java does not allow user to access memory management.
It gets rid of unused object by garbage collection(GC).

 - ClassLoader: Retrieve translated class file in disk.
 - Class area: Place to memorize info of class
 - Heap: generate and memorize object of class
 - Java Stack: Method operation, tmporarily memorization of variables, etc.



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
* **main() must exists for execution**
* **Virtual Machine (VM) only covers main()**
  * process to execute : <>.java  -> <>.class -> JVM on any OS



##  I. Remarks in Character and String

`System.out.println('c');`

* A character should be wraped in ' '

`System.out.println("cstring");`

* Strings should be wraped in " "
* Concatenation between string is available in Java

`System.out.println("Hello "+"World");`

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

#### 1. Primitive Type

 - Boolearn Type **(boolean)**
 - Numeric Type
    - Integral Type
       - Integer **(short,int,long)**
       - Floating Point Type **(float,double)**
   - Character Type **(char)**

#### 2. Reference Type

- Class Type
- Interface Type
- Array Type
- Enum Type
- etc.


|section| data type | memory size | expressive range |
| --------- | ----------- | ------------------------------- | --------- |
| integer      | byte      | 1 byte      |-128 ~ 127|
|              | short     | 2           |-32,768 ~ 32767|
|              | int       | 4           |-2,147,483,648 ~ 2,147,483,647|
|              | long      | 8           |-9,223,372,036,854,775,808 ~ []|
| real numbers | float | 4 |~-1.4e-45 ~ ~3.4e+38|
|  | double | 8 |~-4.9e-324 ~ ~1.7e308|
| character | char | 2 |All Unicode letter|

**BigInteger**

`method: .multiply(), .add(), .subtract(), .divide()`

**Tip:** If class inherit **java.lang.Object**, it basically become **Reference Type**



#### String Class

string is immutable. (If value is changed, new object is generated)

 .equals() method for string comparison rather than ==



#### Wrapper Class

We cannot assign `null` in basic type. but, for wrapper class, that's possible.

| basic type | corresponding wrapper class |
| ---------- | --------------------------- |
| byte       | Byte                        |
| short      | Short                       |
| int        | Integer                     |
| long       | Long                        |
| float      | Float                       |
| double     | Double                      |
| char       | Char                        |
| boolean    | Boolean                     |
| void       | Void                        |

Wrapper class has members which are declared by final inside it.

```java
//Primitive ==> Object
int a = 5;
Integer i = new Integer(a);
Integer j = a;

// Object ==> Primitive
int b;
b = i.intValue();
b = j;
// Object ==> String
String st = i.toString();

```

#### Array

```java
int [] array1=new int[10];
int len=array1.length //the length of array
    
// declaration of array
int [] array1;
int array1[];
Member [] array2;
Member array2[];

// generation of the array
array1=new int[50];
array2=new Member[50];

//value assignments
array1[0]=5;
array2[1]=Member();// ?! new Member()?!

// declaration and generation concurrently
int[] array1=new int[50];
Member [] array2=new Member[50];

// declaration, generation, and assigning values concurrently
int[] array1={10,50,30,20};
int[] array1=new int[]{10,50,30,20};
Member[] array2={new Member(), new Member()}

```



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
- new (generating object)
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
- **logical operator &&,||,!**
- **Tip** use () for multiple logical operators
- **bit operator &, |, ^**
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

// do while
do{

}while(condition)

//2. for
for(int jmi=0;jmi<10;jmi++){
    
}
//Regarding Control break, continue
break;,continue;


//3. for~each
for(int s:su){ //su => array variable
    System.out.println(s);
}
```

###### Array-related java statements: for-each

```java
String[] members={"Ethen","Edan","Eric"};
for (String e:members){   // since java 5.0
    System.out.println(e+"saw consultant");
}
```

### VIII. Array

```java
public class ArrayDemo{
    public static void main(String[] args){
        int [] a;
        a = new int[50];
        int [] b = new int[100];

		String[] classGroup={"Charles","Chandler","Cornelii"};   
        System.out.println(classGroup[0]);
        
        String[] classMate=new String[4];
        classMate[0]="Kevin";
        System.out.println(classMate[0]);
        System.out.println(classMate[0].length);//.length len of array


        // array copy
        int[] c = new int[100];
        System.arraycopy(a, 0, c, 0, a.length);
        // System.arraycopy({wanted to be copied}, {starting index}, {target array}, {starting index}, {length of array to get from the one to be copied})
    }
}

```

#### Multi-dimensional Array

```java
int[][] test1;
int test1[][];
int[] test1[]; // all available.

int [][] array1=new int[5][7];
int [][] array1=new int[6][];
Member [][] array2=new Member[5][3];
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

* **The format of main method is a convention!!!**

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
    
    public Calculator(){}

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

### XIV. Access Modifier

|Access Modifier|Same class|Same Package|Subclass|Universe|
|---|---|---|---|---|
|private|yes||||
|(defualt)|yes|yes|||
|protected|yes|yes|yes||   
|public|yes|yes|yes|yes|
**protected**: this is about inheritence

### XV. Usage Modifier
* static: If user want to use it without Object generation
* final: unchangeable
* abstract: Not implemented yet



|Usage Modifier|Used at|
|---|---|
|static|member variable, member method, member nested class|
|final|class, variable, method|
|abstract|class, method|

##### static
Variable defined with static can be used without generation of object
Even for methods.

* **!**:  Static method is used without object generation, only static variables can be used within static method since other variables are defined with object!
* Spontaneously, `this`, `super` keywords are not allowed.
* Overriding is not allowed.

**Static Block**
Static Block is automatically called after classes are loaded on memory.
```java
static{
    //statements
}

```

##### final
final class: can not be inherited.
final method: can not be overrided
final variable: constant.

**Remarks** At interface, variable is not used but as final variable.


##### abstract
abstract is used to defined a class that includes methods undefined yet.

abstract class itself can not be used.

class, which inherit the abstract class, must override all the methods in the abstract one.

### XVI. Encapsulation
* Use pirvate for important information.
* methods for access are declared with public.
* setXxx(), getXxx()


### XVII. Annotation (javadoc)
To generate javadoc `javadoc -d doc -private *.java`
```java
/**
 * Annotate
 * 
 * /
```


@see {class_name} :"See also" with a link to the class
@see {class_name}#{method_name} : "See also" with a link to the method
etc.

 **Remarks**

1. Instance method can go up to class member.
2. class method cannot go up to instance member.