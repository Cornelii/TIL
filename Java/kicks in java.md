# Kicks in JAVA
java.io, java.util, java.net, java.math, etc

## I. String type methods

|methods| return type|
|---|---|
|equals({String})|boolean|
|length()|int|
|charAt({int})|char|
|indexOf({char})|int|
|substring({int},{int})|String|


## II. Why static?
`static` facilitates calling variables or function by non-instance, but class itself.

- Why non-static member can not be accessed at static method?
  => Since this is not a class member, it is impossible to access before generating its instances


## III. Object & Wrapper Class
#### i. Object
Object is the Super Class of all classes in java.
It implies Object can allocates all the class in java.

Object class methods
|methods|return type|
|---|---|
|equals({Object})|boolean|
|hashCode()|int|
|toString()|String|
|getClass()|Class<?>|

#### ii. Wrapper Class
When make Primitive type data to object, Wrapper Class is used. (Integer, Double, Boolean, Character, etc)

 - It offers function of data type casting
ex) Integer.parseInt({String})

```java
Object [] array = new Object[100];
int a = 7;
array[3] = a; // Auto Boxing
array[3] = new Integer(a);

a.intValue(); // unBoxing
```

 - Auto-Boxing and -Unboxing
   - Compiler give unboxing and boxing code automatically when type casting is not given

```java
    Object [] array = new Object[50];
    // 
    int a = 6;
    // array[5] = new Integer(a);
    array[5] = a; // This is allowed by auto boxing
    array[3] = 5; // This is allowed by auto boxing

```


## IV. Abstract & Interface

#### i. Abstract
`abstract` keyword, User need to implement abstract methods in the abstract class to use it inheriting it by `extends`

```java
abstract class Node {
    public abstract void setVal(int Val);
}

class MyNode extends Node {
	
	public void setVal(int Val) {};
}
```

#### ii. Interface
`interface` keyword, Interface can be considered as an extremely abstracted class.

All methods in interface are abstract methods!

For the interface, `implements` keyword is used, not `extends`

```java
interface Node {
    public void setVal(int Val);
}

class MyNode implements Node {
    public void setVal(int Val){};
}
```

## V. Generic Programming

Way to focus on Reusability regardless of data type.

example
```java
public class Box <T>{
    private T a;
    public Box<T>();
    public void set(T c){this.a = c;}
    public T get(){return this.a;}
}

Box <Integer> integerBox = new Box<Integer>();
Box <Things> thingsBox = new Box<Things>();

```
**It can have more than two generic parameter.**

**Generic Programming can be implemented using Object class. However, in this case, Type casting is required**

## VI. IO

- Stream: Ordered Data flow
- type of Strea: by String, by Byte

#### i. String Stream

|1|2|3|
|---|---|---|
|Reader|BufferedReader|LineNumberReader|
||CharArrayReader||
||InputStreamReader|FileReader|
||FilterReader|PushbackReader|
||PipedReader||
||StringReader||
|Writer|BufferedWriter||
||CharArrayWriter||
||OutputStreamWriter|FileWriter|
||FilterWriter||
||PipedWriter||
||StringWriter||
||PrintWriter||

#### ii. Byte Stream

IS: InputStream in short.
OS: OutputStream in short.

|1|2|3|
|---|---|---|
|InputStream|FileIS||
||PipedIS||
||FilterIS|LineNumberIS|
|||DataIS|
|||BufferedIS|
|||PushbackIS|
||ByteArrayIS||
||SequenceIS||
||StringBufferIS||
||ObjectIS||
|OutputStream|FileOS||
||PipedOS||
||FilterOS|DataOS|
|||BufferedOS|
||ObjectOS||
||ByteArrayOS||
||PrintStream||

 - **BufferedReader**: Only recognize `Enter` as a delimeter.
 - (Scanner does `Space` and `Enter`)

Example
```java
    BufferedReader BRexample = new BufferedReader({Stream});
    BufferedReader BRfile = new BufferedReader(new File('intput.txt'));
    BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    String s = BR.readLine();
    int a = Integer.parseInt(BR.readLine().trim());

    // for the space-separated input
    StringTokenizer ST = new StringTokenizer(BR.readLine().trim());

    int b = Integer.parseInt(ST.nextToken());

    BR.close();
```

- **BufferedWriter**

```java
    BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));

    BW.write({String});

    BW.close();
```

methods of BufferedReader & BufferedWriter

|methods|return type|
|---|---|
|read()|int|
|read({char [] buf})|int|
|read({char [] buf}, {int offset}, {int length})|int|
|readLine()|String|
|mark()|void|
|reset()|void|
|skip(int n)|long|
|write({String s}, {int offset}, {int length})|void|
|newLine()|void|
|flush()|void|


- InputStreamReader & OutputStreamWriter
These transform Byte data in the form of Char

Example
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.FileReader;
import ajva.io.FileWriter;
import java.io.IOException;

public class Practice {
    
    static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));

    static BufferedReader BRf;
    static BufferedWriter BWf;

    public static void main(String[] args){
        
        try {
            BRf = new BufferedReader(new FileReader("input.txt"));
            BRw = new BufferedWriter(new FileWriter("output.txt"));

            String a = BRf.readLine();
            String b = BRf.readLine();

            BRw.write(a);
            BRw.write(b);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                BRf.close();
                BRw.close();
            }catch (IOException ioe){
                ioe.printStackTrace();
            }
        }


        InputStreamReader ISR = new InputStreamReader(System.in);
		OutputStreamWriter OSW = new OutputStreamWriter(System.out);
		
		char [] a = new char[10];
		try {
			ISR.read(a, 3, 4);
		} catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println(a);
	}


    }
}

```

## VII. HashMap & TreeMap

HashMap : Using Hash (O(1) for Searching)
TreeMap : Using Tree (O(log(n)) for Searching)
However, TreeMap has better efficiency in memory usage becuase Hash has 50 - 75% memory efficiency in usual.

**ConcurrentHashMap** : This is similar to HashMap. However, it is recommended to use this in multi-threading.

example
```java
import java.util.HashMap;
import java.util.Map;

//...
    HashMap<String, Integer> myMap = new HashMap<String, Integer>();
    // TreeMap<String, Integer> myMap = new TreeMap<String, Integer>();

    myMap.put("hi") = 5;

    System.out.println(myMap.get("hi"));

    Map<String, String> myMap2 = new HashMap<String, String>();

    myMap2.put("Hello", "hihi");
    
    System.out.println(myMap2.get("Hello"));
    System.out.println(myMap2.containsKey("Hello"));

    System.out.println(myMap.containsValue(5));

    System.out.println(myMap.isEmpty());
    myMap.clear();
    System.out.println(myMap.isEmpty());

    System.out.println(myMap2.size());
    System.out.println(myMap2.remove("hey"));
    System.out.println(myMap2.isEmpty());
    System.out.println(myMap2.remove("hey"));
//...
```

|methods|return type|
|---|---|
|get({Key})|Object|
|put({Key},{Value})|void|
|containsKey({Key})|boolean|
|containsKey({Value})|boolean|
|isEmpty()|boolean|
|size()|int|
|remove({Key})|Object|
|KeySet()|Set|
|putAll({Map m})|void|
|values()|Collection|
|getOrDefault({Key},{default Object})|Object|
|entrySet()|Set|

## VIII. ArrayList
LinkedList

```java
import java.util.ArrayList;
//...

    ArrayList<Integer> myArr = new ArrayList<Integer>();
    myArr.add(6);
    myArr.add(4);
    myArr.add(3);

    System.out.println(myArr.get(2));
    
    System.out.println(myArr.size());

    System.out.println(myArr.remove(1));
//...
```

|methods|return type|
|---|---|
|add({Object o})|void|
|get({int idx})|Object|
|size()|int|
|remove({int idx})|Object|

## IX. Iterator with Map, HashMap, Set


example1
```java
import java.util.Iterator;
import java.util.Map;
//...

    HashMap<String, String> myMap = new HashMap<String, String>();
    myMap.put("hey", "1");
    myMap.put("ho", "4");

    Iterator itr = myMap.entrySet().iterator();

    while(itr.hasNext()){
        Map.Entry<String, String> e = (Map.Entry<String, String>) itr.next();
        System.out.println(e.getKey() + ": " + e.getValue());
    }
//...
```

example2
```java
//...
for (Map.Entry<String, String> elem: myMap.entrySet()){
    System.out.println(elem.getKey() + ": " + elem.getValue());
}
//...
```

example3
```java
//...
    for(String key: myMap.keySet()){
        System.out.println(key + ": " + myMap.get(key));
    }
//...
```

## X. HashSet
Set using Hash
This only concerns whether entries are in this or not.

```java
import java.util.HashSet;
import java.util.Set;
//...
		HashSet<Integer> mySet = new HashSet<Integer>();
		// Set<Integer> mySet = new HashSet<Integer>();
		mySet.add(6);
		System.out.println(mySet.isEmpty());
		mySet.remove(6);
		System.out.println(mySet.isEmpty());
		
		mySet.add(7);
		System.out.println(mySet.size());
		mySet.clear();
		System.out.println(mySet.size());
		
		mySet.add(16);
		System.out.println(mySet.contains(16));
		System.out.println(mySet.contains(17));
//...
```
|methods|return type|
|---|---|
|add({Object o})|void|
|isEmpty()|boolean|
|contains({Object o})|boolean|
|clear()|void|
|remove({Object o)|boolean|
|size()|int|

## XI. Comparable & Comparator
* Comparable: To implement origin sorting standard.
 
* Comparator: To implement another sorting standard.

Comparable example
```java
import java.util.Arrays;
import java.util.Collections;
//...
class Node implements Comparable<Node>{
    int val;

    @Override
    public int compareTo(Node node){
        return this.val - node.val;
    }
}

//...
    Node [] nodes = new Node[100];
    //...

    Arrays.sort(nodes);
    Collections.sort(nodes);
//...
```

Comparator example
```java
import java.util.Comparator;
import  java.util.Arrays;
import java.util.Collections;
//...
class MyComparator implements Comparator<Node>{
    @Override
    public int compare(Node n1, Node n2){
        if(n1.val > n2.val) return 1;
        else if(n1.val == n2.val) return 1;
        else return -1;
    }
}
//...

//...
    MyComparator myComparator = new MyComparator();
    Collections.sort(nodes, myComparator);
```

Comparator example2 (Anonymous class)
```java
//...
Comparator<Node> myComparator = new Comparator<Node>(){
    @Override
    public int compare(Node n1, Node n2){//...
    }
}

Collections.sort(nodes, myComparator)
```

## XII. PriorityQueue
PriorityQueue using Comparator!

Simple example
```java
import java.util.PriorityQueue;

//...
    PriorityQueue myPQ = new PriorityQueue(100);
    myPQ.offer(8);
    myPQ.offer(67);

    System.out.println(myPQ.isEmpty());
    System.out.println(myPQ.peek());
    System.out.println(myPQ.poll());
//...
```

example with Comparator
```java
import java.util.Comparator;
import java.util.PriorityQueue;

class TestNode {
    int val;

    public TestNode(int val){
        this.val = val;
    }
}

//...
    PriorityQueue<TestNode> pq = new PriorityQueue<TestNode>(100, new Compoarator<TestNode>(){
        @Override
        public int compare(TestNode tn1, TestNode tn2){
            if(tn1.val > tn2.val) return 1;
            else return -1;
        }
    });

    pq.offer(new TestNode(16));
    pq.offer(new TestNode(4));
    pq.offer(new TestNode(12));
    
    System.out.println(pq.peek().val);
    //4
    System.out.println(pq.isEmpty());
    //false
    System.out.println(pq.poll().val);
    //4
    System.out.println(pq.poll().val);
    //12
//...

```

|methods|return type|
|---|---|
|offer({Object o})|void|
|poll()|Object|
|isEmpty()|boolean|
|peek()|Object|
|size()|int|
etc.

## XIII. java.util.Arrays & Collections
- Arrays
|methods|return type|
|---|---|
|asList(T [] arr)|List<T>?!|
|binarySearch(Object[] a, Object key)|int|
|copyOf(T[] original, int newLength)|T[]|
|copyOfRange(T[] original, int from, int to)|T[]|
|fill(Object[] a, Object val)|void|
|sort(Object[]a)|void|

- Collections are similar to Arrays above.

## XIV. Common mistakes in Java

#### i. Attempts to transform general array to ArrayList

- mistake
```java
List<String> list = Arrays.asList(arr);
```

Arrays.asList() returns private static class ArrayList. (java.util.Arrays.ArrayList; This does not contain add method)
This is different from java.util.ArrayList

- correction
```java
ArrayList<String> arrList = new ArrayList<String>(Arrays.asList(arr));
```

#### ii. Attempts to check if specific value in usural arrays

- mistake
```java
Set<String> set = new HashSet<String>(Arrays.asList(arr));
return set.contains(targetValue);
```

This code works. However, it takes time to make list to set, actucally, unnecessary.

- correction
```java
Arrays.asList(arr).contains(targetValue);

//or

for(String s: arr){
    if(s.equals(targetValue)) return true;
}
return false;
```

Are both O(n), aren't they?!
For the membership check, make up HashSet from the first.

#### iii. Attempts to remove entries in list within Loop

- mistake
```java
ArrayList<String> list = new ArrayList<String>(Arrays.asList("a","b","c","d"));
for(int i = 0; i < list.size(); i++){
    if (list[i] == "a") list.remove(i);
}
System.out.println(list);
```
Indices are changing during Loop execution. It can cause problems.

- correction
```java
ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));

Iterator<String> itr = list.iterator();
while(itr.hasNext()){
    String s = itr.next();
    if (s.equals("a")){
        iter.remove();
    }
}
```

#### iv. Use of Raw Type in Collection
Raw type vs unbounded wildcard
ex) Set vs Set<?>
Type Checking?!