# Java_basic2

## I. Effective range (Scope)

Variables in method can not be referred from outside of the method.

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

Standard API
\jre\lib\rt.jar.

java.awt: Basic graphic screen classes
java.io: Input, Output classes and Interfaces
**java.lang**: Java Basic classes
**java.net**: Network-related classes
java.sql: java-DB related classes and interfaces
java.text: string format-related classes
**java.util**: data management and etc.
javax.sql: java-db extended classes
javax.swing: java graphic extended classes

java.lang package is automatically loaded even though it is not imported.

**UI: User Interface**

[JAVA API](https://docs.oracle.com/javase/7/docs/api/)



## X. Access Modifier

**public, private, protected, default**

* For the private, That is only callable within the class where the method belongs to
* protected: allow inheritance-related one to access, even other packages.
* default: allow inheritance-related one to access within the same package.

```java
class A{
    private int left, right;   // A.left assignment is not allowed! but by method!
    public String y(){
        return "Public void y()";
    }
    private String z(){  //            Access Modifier=> public, private.
        return "public void z()"; 
    }
    public String x(){
        return z();
    }
}

public class AccessDemo1{
    public static void main(String[] args){
        System.out.println(a.y());
        
        //System.out.print(a.z()); This induce error
        System.out.println(a.x());
    }
}
```

**If nothing ahead of data type implies "default" access modifier!**

## XI. abstract

kind of regulation associated with inheritance.



**abstract class is only available under inheritance!!!!**

```java
abstract class A{                    // It can be used only through inheritance!
    public abstract int b(); // abstract method can not possess contents body!!!
    //                              // only abstract invoke. it means overriding needed!!!!
    public void d(){
        System.out.println("world")
    }
}

class B extends A{
    public int b(){
        // super keyword to refer super class
        super.d()
        return 1;
    }
}

public class AbstractDemo{
    public static void main(String[] args){
        //A obj =new A();  error code
        B obj=new B();
    }
}
```

- When and Why is abstract class required?!

This type of code is rare in small-size projects.

**This abstract class force other to inherit them necessarily. => driving to overriding**

Let Common parts belong to Super Class(abstract class)

And, let dynamically changed method be located in Subclass in terms of abstract method!

**It make repeat and maintenance easy.**



## XII. final

kind of opposite to abstract.

It prohibit inheritance and revision.

```java
//1.
class Calculator{
    static final double PI=3.14; // unchangeable.
    int left,right;
    
    public void setOprands(int left, int right){
        this.left=left;
        this.right=right;            
        //this.PI=6; /error because PI-> final!
    }
    public void sum(){
        System.out.println(this.left+this.right)
    }
}

public class CalculatorDemo{
    public static void main(String[] args){
        Calculator c= new Calculator();
        c.setOprands(10,20);
		
    }
}
//2.
class A{
    final void b(){}
}
class B extends A{
    //void b(){}  cannot be overrided!!!
}

//3.
final class A{}
//class B extends A
// B cannot inherit A because A is defined as final
```

## XIII. Interface

**interface force class include methods of interface!!!** (forced override!!)

```java
interface I{
    public void z();
}

class A implements I{ // use of implements for interface I
    public void z(){}
}
```

from 2nd lecture clip in life-coding.

#### Utility of Interface 

It helps communication one another between developers.

Interface makes sure what methods and members are included in a specific class.

```java
interface I1{
    public void x();
}

interface I2{
    public void z();
}
// non-public methods and members are not available in interface!
class A implements I1,I2{
    public void x(){}
    public void z(){}
}

interface I3{
    public void x();
}
interface I4 extends I3{
    public void z();
}
// interface also can be inherited

class B implements I4{
    public void x(){} //must be
    public void z(){} //must be
}
```

## XIV. Polymorphism

Polymorphism is about letting a method or a class work in different ways!

```java 
class O{
    public void a(int param){
        System.out.println("number printout");
        System.out.println(param);
    }
    public void a(String param){
        System.out.println("letter printout");
        System.out.println(param);
    }
}
public class PolymorphismOverloadingDemo{
    public static void main(String[] args){
        O obj= O();
        O.a(1);
        O.a("yeah");
    }
}

```

Overloading is one of the polymorphism

```java
class A{
    public String x(){return "x";}
}
class B extends A{
    public String y(){return "y";}
}
public class PolymerphismDemo1{
    public static void main(String[] args){
        A obj=new B(); // instance of B, but it acts in A!!!
        obj.x();
        //obj.y(); error. Cause, What acts in A means no access to method y in B"
    }
}
```

```java
class A{
    public String x(){return "A.x";}
}
class B extends A{
    public String x(){return "B.x";}
    public String y(){return "y";}
}
public class PolymerphismDemo1{
    public static void main(String[] args){
        A obj=new B(); // instance of B, but it acts in A!!!
        System.out.println(obj.x());
        // B.x  (kind of virtual function in C++)
    }
}
```

```java
class A{
    public String x(){return "A.x";}
}
class B extends A{
    public String x(){return "B.x";}
    public String y(){return "y";}
}
class B2 extends A{
    public String x(){return "B2.x";}
}
public class PolymerphismDemo1{
    public static void main(String[] args){
        A obj=new B(); // instance of B, but it acts in A!!!
        A obj2=new B2();
        System.out.println(obj.x()); //B.x
        System.out.println(obj2.x()); //B2.x why?! because method x() in A is virtual fcn
    }
}
```


#### Use of instanceof

When changing type reference from superclass to subclass, it could be possible that the calss is objects of super one.

```java
if (m instanceof SubOne){
    SubOne mm = (SUbOne) m;
}
```


#### Interface Type
Interface is composed of constant, unimplemeneted methods.
Eventhough variables is not declared with final, it is changed by compliler.

Interface can not generate an object.

For classes, which inherit interface, all the methods must be overrided.

Inferface is a kind of spec of classes.

* default modifier
* 1. for variable, `public static final`
* 2. for methods, `public abstract`


```java
interface Media{
    abstract void start();  // Remarks! not {}, but ;
    abstract void stop();

}

class A implements Media{ // Remarks implements, not extends
    public void start(){}
    public void stop(){}
}

**!Remarks!**: Subclass can implement multiple of interfaces.

interface MyInterface<T>{
    void add(T value);
}
// T is generic type!!!!
```
#### Generic
Generic enabels determination of data type when instances are created!
It reduces burden of type conversion and makes program more robust from type error.

```java
ArrayList<A> MyList = new ArrayList<A>();

// A객체만 저장할 수 있는 ArrayList를 생성
MyList.add(new A());

MyList.add(new B());// 컴파일 에러
```

* Objects, which inherit some class, can be assigend to the class-generic object as well.

* wild card: `?`
```java
class A{}
class B extends A{}
class C<A,B>{}

public void method1(X<? extends A>){} // A or B 
```
Wild card`?` enables us to define multiple types of generic.


**For array, use of Object?!**
```java
class MyList<T>{
	private Object [] element;
	private int index = 0;
	
	public MyList(int a) {
		this.element = new Object[a]; 
	}
	
	public void add(T e) {
		this.element[this.index++] = e;
	}
	
	public T get(int idx) {
		return (T) this.element[idx];
	}
	
}

public class Prac{
	public static void main(String []args) {
		MyList<Integer> mylist = new MyList<Integer>(5);
		
		mylist.add(5);
		mylist.add(3);
		
		System.out.println(mylist.get(0));
		System.out.println(mylist.get(1));
		
	}		
}
```


#### Enum Type

```java

```

## XV. Exception

try{

`code expected to have error`

}catch(<exception class instance>){

`code when error occurs`

}

```java 
class Calculator{
    int left, right;
    public void setOprands(int left,int right){
        this.left=left;
        this.right=right;
    }
    public void divide(){
        try{
        System.out.print(this.left/this.right);
        } catch(Exception e){ // Exception has method of getMessage()
            System.out.println("Error occurs"+e.getMessage());
            //  / by zero
            System.out.println("e.toString()"+e.toString());
            //  detailed description
            System.out.println("e.printStackTrace()");
            e.printStackTrace();
            //  more detailed description
        } 
        System.out.println("Divide End");
    }
}
```

#### Various Exceptions

```java
class A{
    private int[] arr=new int[3];
    A(){
        arr[0]=0;
        arr[1]=10;
        arr[2]=20;
    }
    public void z(int first,int second){
        System.out.println(arr[first]/arr[second]);
    }
}

public class ExceptionDemo1{
    public static void main(String[] args){
        A a= new A();
        a.z(10,1); // ArrayIndexOutOfBoundsException
        //a.z(1,0); // ArithmeticException
```

#### How to resolve?!

```java
class A{
    private int[] arr=new int[3];
    A(){
        arr[0]=0;
        arr[1]=10;
        arr[2]=20;
    }
    public void z(int first,int second){
        try{
        System.out.println(arr[first]/arr[second]);
        }catch(ArithmeticException e){
            e.printStackTrace();
            System.out.println("ArithmeticException")
        }catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println("ArrayIndexOutOfBoundsException")
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            // this line must be excuted regardless of occurance exception
        }
        
    }
}

public class ExceptionDemo1{
    public static void main(String[] args){
        A a= new A();
        a.z(10,1); // ArrayIndexOutOfBoundsException
        //a.z(1,0); // ArithmeticException
    }
}
```

#### Java Exception

Exception, error are Objects

* Exception: Unexpected things during programming operation
* Error: Fatal Error

* Throwable
  * Error
  * Exception
    * RunTimeException
      * ArithmeticException
      * NullPointerException
      * IndexOutOfBoundsException
    * DataFormException
    * SQLException
    * IOException
      * EOFException
      * FileNotFoundException

#### Exception Handling

```java
import java.io.*;

public class InputFile{
    FileInputStream fis; //FileInputStrem~~!!!
    InputFile(String filename){
        fis=new FileInputStream(filename);
    }
    void readLine(){
        String s;             // InputStreamReader~~!!
        BufferedReader buf=new BufferedReader(new InputStreamReader(fis));
        while((s=buf.readLine())!=null)
            System.out.println(s)
    }
    public static void main(String[] args){
        InputFile inputFile=new InputFile("data.txt");
        InputFile.readLine();
        System.out.println("Program End...");
    }
}
```

```java
//Basic Form
try{
    
}catch(XXXException e){
    
}

try{
    
}catch(){
    
}xn  finally{
    
}
```

```java
void readLine(){
    String s;             // InputStreamReader~~!!
    BufferedReader buf=new BufferedReader(new InputStreamReader(fis));
    
    try{
        while((s=buf.readLine())!=null)
            System.out.println(s)
    }catch(IOException e){
        System.out.println(e+" :: reading failed");
    }finally{
        try{
            if(buf!=null) buf.close();
        }catch(IOExceptoin e){
            e.printStackTrace();
        }
    }
}
```

#### throws

When exception occurs, hand over the processing to the part that call it.

Functions calling the functions, whitch throws exception, are forced to be implemented that the functions be placed in try-catch except statement!


* Customized Exception
```java
public class ValueException extends Exception{
    public ValueException(){
        super("Value Error!");
    }
    public void myMethod(){
        System.out.println("No way!");
    }
}


```

