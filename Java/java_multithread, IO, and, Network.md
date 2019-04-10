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

#### 4. Thread State and Control

`TreadObj.getState()`

|enum constant|Description|
|---|---|
|NEW|not yet start() after thread obj is generated|
|RUNNABLE|Executable by JVM selection|
|BLOCKED|wait until monitor lock is unlocked|
|WAITING|standby without specified time interval|
|TIMED_WAITING|standby with specified time interval|
|TERMINATE|end state after run() method quit|

##### Procedure of execution of thread

1. Right after generating thread object, it is `NEW` state. When calling `start()`, thread state becomes `RUNNABLE`. And, There are competition between thread objects to be selected by thread scheduler.
2. When JVM call `run()` of thread obj, it opertes. And, This obj is terminated `TERMINATE` when `run()` method quits.
**Terminated Thread Obj means that Stack of the thread itself is terminated.**
3. Threads on operaiont can be stopped by calling of `sleep()`, `wait()`, `join()`, and blocking by I/O being transfered to waiting pool. (`WAITING` or `TIMED_WAITING`).
4. Threads in stanby state can be `RUNNABLE` state as follows.
    * Time-up of `sleep()` and `join()`
    * Calling method `notify()` about `wait()`
    * Calling method `interrupt()`
    * End of I/O.
`RUNNALBE` thread can be operated again after competition procedure like the first step.
5. When `yield()` are called on operating threads, It stops and go back to the state `RUNNABLE`.(Executable again after the competition)


##### i. State Control by `sleep()`

##### ii. State Contorl by `join()`

##### iii. escape out of the waiting pool by `interrupt()`

##### iv. State Control by `yield()`

###### Finishing Thread

##### 5. Problems of Multi-thread and Solutions




 
## II. Console & File I/O



