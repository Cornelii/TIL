/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */

class Solver{
    public Solver(){}

    public int[] vectorize(int p1x, int p1y, int p2x, int p2y){
        int [] vec= new int[2];
        vec[0]=p2x-p1x;
        vec[1]=p2y-p1y;
        return vec;
    }

    public double rotate_angle(int [] vec){
        //abscissa based 
        return Math.atan((double)vec[1]/vec[0]);
    }

    public double rotate_point(int p1x, int p1y,double angle,char point){
        double cos_angle=Math.cos(angle);
        double sin_angle=Math.sin(angle);
        double p;
        if (point=='x'){
            p=cos_angle*p1x+sin_angle*p1y;
        }else{
            p=cos_angle*p1y-sin_angle*p1x;
        }
        return p;
    }
    
    public double Area(int p1x, int p1y, int p2x, int p2y, int p3x, int p3y){
        //p1 is alway base point //p3 is alway heigth point
        int []vec1=new int[2];
        double area;
        double p2_x;
        double p3_y;
        
        vec1=this.vectorize(p2x,p2y,p1x,p1y);
        double angle=this.rotate_angle(vec1);

        p2_x=this.rotate_point(p2x,p2y,angle,'x');
        p3_y=this.rotate_point(p3x,p3y,angle,'y');
        area=Math.abs((p2_x-p1x)*(p3_y-p1y))/2;
        // System.out.println(area);
        return area;
    }
    /*
    public int valueCount(){
        return 0;
    }*/
}
class Ordering{
    double A,B;
    Solver solver=new Solver();
    int count;
    public Ordering(long A, long B){
        this.A=(double)A/2;
        this.B=(double)B/2;
        this.count=0;
    }
    
    //public boolean isTriangle(){}

    public int[][] nCombi(int n){
        
        int N=this.Combination3(n);
        //System.out.println(N);
        int [][] samples=new int[N][3];
        int iter=0;
        for(int jmi=0;jmi<n;jmi++){
            for(int jmii=jmi+1;jmii<n-1;jmii++){
                for(int jmiii=jmii+1;jmiii<n;jmiii++){
                    samples[iter][0]=jmi;
                    samples[iter][1]=jmii;
                    samples[iter][2]=jmiii;
                    iter++;
                }
            }
        }
        return samples;
    }
    public int Combination3(int n){
        return n*(n-1)*(n-2)/6;
    }

    public void counting(int[] p1,int[] p2,int[] p3){
        double area=solver.Area(p1[0],p1[1],p2[0],p2[1],p3[0],p3[1]);
        // System.out.println("lower bound "+this.A);
        // System.out.println("upper bound "+this.B);
        if(this.A<area || Math.abs(this.A-area)<=1e-6){
            if(this.B>area || Math.abs(this.B-area)<=1e-6){
                this.count+=1;
                // System.out.println("Action");
            }
        }
    }
    public void represent(int num_order){
        System.out.println("#"+num_order+" "+this.count);
    }
}

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("./input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
        int T; //T:case number
        long A,B;
        int N;
        T=sc.nextInt();
        
        //System.out.println(T);
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
        */

		for(int test_case = 1; test_case <= T; test_case++)
		{
            N=sc.nextInt();
            A=sc.nextLong();
            B=sc.nextLong();
            int [][]points=new int[N][2]; // all the points
            points=ref_count(N,sc);
 
            Ordering order=new Ordering(A,B);
            int M=order.Combination3(N);

            int [][] sample=new int[M][3]; // all the order
            sample=order.nCombi(N);
            
            for(int jmi=0;jmi<M;jmi++){
                order.counting(points[sample[jmi][0]],points[sample[jmi][1]],points[sample[jmi][2]]);
                
            }
            order.represent(test_case);
            points=null;
            order=null;
            sample=null;
            // for(int jmi=0;jmi<N;jmi++){
            //     System.out.print(points[jmi][0]);
            //     System.out.println(points[jmi][1]);
            // }
                

			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////

		}
    }
    // N times,
    public static int[][] ref_count(int N,Scanner y){
        int [][]points=new int[N][2];
        for(int jmi=0;jmi<N;jmi++){
            points[jmi][0]=y.nextInt();
            points[jmi][1]=y.nextInt();
        }
        return points;
    }
}