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

#### Index access at String
`.charAt(0)`


##### Method

append(String s), insert(int offset, String s), reverse(), setChar(int index, char ch), setLength(int newLength)

```java
StringBuilder str=new StringBuilder("Yeah s");

```
#### Math
##### Methods
max, min, abs, sin, cos, tan, asin, acos, aton, cell, floor, round


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

```java
import java.util.ArrayList;
import java.util.Collection;

public class istTest2{
    public static void main(String[] args){
        Collection <String> list=new ArrayList<String>();
        list.add("Incheon");
        list.add("Seoul");
        
        for(String ob: list){
            SYstem.out.println(ob);
        }
    }
}
```
### Map

데이터 저장, 관리 시 검색을 쉽게 하기 위한 클래스

* 객체를 key와 value로 구분하여 관리함.
* key를 통한 검색과 삭제를 하게 함. (python의 dictionary?!)

```java
public class MapTest2{
    public static void main(String[] args){
        Map<String, String> list=new HashMap<String,String>();
        list.put("city","seoul");
        list.put("country","Republic of Korea");
        list.put("wow","ehe");
        
        System.out.println(list.get("city"));
        Iterator<String> i=list.keySet().iterator();
        
        while(i.hasNext()){
            String key=i.next();
            String value=list.get(key);
            System.out.println(key+":"+value)
        }
    }
}

```
### Calendar

```java
	Calendar rightNow=Calendar.getInsatnce();
	int hour=rightNow.get(Calendar.HOUR);
	int min=rightNow.get(Calendar.MINUTE);
	int sec=rightNow.get(Calendar.SECOND);
	int year=rightNow.get(Calendar.YEAR);
	int month=rightNow.get(Calendar.MONTH);
	int date=rightNow.get(Calendar.DATE);
```
