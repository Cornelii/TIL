public class Test{

    static int b=0;
    int a;

    public static void main(String[] args){
        System.out.println(b);
        set_b();
        System.out.println(b);
    }

    public static void set_b(){
        Test.b+=10;
    }
}