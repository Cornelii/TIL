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

## IV. Inheritance

* **Important concept in OOP**
  * Super <=> Sub class
  * Base <=> Derived class

```java
class Calculator{             
    int left, right;
    
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
    public sub(){
        System.out.println(this.left-this.right)
    }
}

public class CalDemo2{
    public static void main(String[] args){
        Calculator c1=new Calculator(10,20);
        
        SubCal s1=new SubCal();    
        
    }
}
```



