# Java Exception

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

## Exception Handling

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

Kinds of Function Overriding Forcing the functions be placed in try-catch except statement!

```java

```

