# Multi Thread, IO, and Network

## I. Multi Thread
#### 1. Thread and Process
* Proces: Independent Program that operate separately.
* Thread: Small unit that consists of a process.
* MultiProcess: To execute multiple process.
* MultiThread: To operate multiple thread in one Process.


#### 2. Positive / Negative in multi thread.

**Positive**
* Increase use rate of CPU
* Improve response time by separation of tasks
* Increase Efficiency by sharing resources.
    Threads in one process share resources of the process.

**Negative**
* Cost of context switching (task transition)
* Difficulty in control


#### 3. Thread Generation and Operation

###### i. generate thread
* inherit Thread class
or
* implement Runnable Interface



**inherit thread**

**Basic Format**

```java
public class Test extends Thread{
    public void run(){
        System.out.println("thread run.");
    }
    public static void main(String[] args){
        Test test = new Test();
        test.start();  // when execute .start, run method executes.
    }
}
```


To see features of thread.
```java
public class Test extends Thread{
    int a;
    public Test(int a){
        this.a = a;
    }
    public void run(){
        System.out.println(this.a+" thread starts.");
        try{
            Thread.sleep(1000);
        }catch(Exception e){
        }
        System.out.println(this.a+" thread ends.");

    }

    public static void main(String[] args){
        for(int i=0;i<10;i++){
            Thread t = new Test(i);  // Tread type.
            t.start();
        }
        System.out.println("main ends.");
    }
}
```


**Join! in thread**
```java
import java.util.ArrayList;

public static void main(String[] args){
    ArrayList<Thread> threads = new ArrayList<Thread>();
    for(int i=0; i<10;i++){
        Thread t = new Test(i);
        t.start();
        threads.add(t);
    }

    for(int i=0; i<threads.size(); i++){
        Thread t = threqds.get(i);
        try{
            t.join();
        }catch(Exception e){
        }
    }
    System.out.println("main ends.");
}
```


**How to implement Runnable Interface**
Runnable interface has `run()` abstract method.
This method must be overrided
```java
public class Test implements Runnable{
    int a=0;
    public Test(int a){
        this.a = a;
    }

    public void run(){
        System.out.println(this.a + "thread starts.");
        try {
            Thread.sleep(1000);
        }catch(Exeption e){
        }
        System.out.println(this.a + "thread ends.");
    }

    public static void main(String[] args){
        ArrayList<Thread> threads = new ArrayList<Thread>();
        for(int i=0; i<10; i++){
            Thread t = new Thread(new Test(i));
            t.start();
            threads.add(t);
        }

        for(int i=0; i<threads.size(); i++){
            Thread t = threads.get(i);
            try{
                t.join();
            }catch(Exception e){

            }
        }
        System.out.println("main end")
    }
}
```
## II. Console & File I/O



