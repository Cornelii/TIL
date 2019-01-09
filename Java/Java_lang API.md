# Java_lang API

## I. Java APIs

There so many APIs

* java.awt: basic graphic screen class
* java.io: input/output interface class
* **java.lang**: most basic class
* java.net: network-related class
* java.text: string foramt and related class
* java.util: regarding managing data


## II. java.lang

### 1. java.lang.Object

All class must inherit this. Thus, even if is not stated, It is automatically inherited by compiler.

```java
// Frequently overrided methods
toSting()
hashCode()
equals(Object a)
```

### 2. String

Only class which can be declarable without `new` 

##### Method

| methods1                     | methods2                     |
| ---------------------------- | ---------------------------- |
| concat(String s)             | replace(char old, char new)  |
| length()                     | toLowerCase(), toUpperCase() |
| indexOf(String s)            | equals(String a)             |
| compareTo(String s)          | equalsIgnoreCase(String s)   |
| substring(int start,int num) | trim()                       |
| endsWith()                   | startsWith()                 |

##### StringBuilder

##### Method

append(String s), insert(int offset, String s), reverse(), setChar(int index, char ch), setLength(int newLength)

```java
StringBuilder str=new StringBuilder("Yeah s");

```

## III. java.util.Collection

* Collection
  * Set
    * Set
      * HashSet
      * SortedSet
        * TreeSet
  * List
    * ArrayList
    * LinkedList

### Set

같은 내용의 객체를 equals()와 hashCode()가 같을 경우 같다고 인정하여 추가되는 데이터는 무시한다.

* HashSet (Set을 구현한 클래스)
* TreeSet (SortedSet을 구현한 클래스)

### ex)

```java
Collection hashset=new HashSet();
hashset.add("incheon");
hashset.add("busan");
hashset.add("seoul");
hashset.add("kwangju");
```

### ex2)

```java
class SetTest2{
    public static void main(String[] args){
        Collection<String> list=new HashSet<String>(); // <> : generic
        list.add("incheon");
        
        Iterator<String>i=list.iterator();
        while(i.hasNext()){
			// for-each statement            
        }
        
        // for (String s: list){
        //		System.out.println(s)
    	// }
    }
}
```

### List
















