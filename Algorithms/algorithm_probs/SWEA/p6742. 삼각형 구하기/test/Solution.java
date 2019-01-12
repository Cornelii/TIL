import java.util.Scanner;
import java.io.FileInputStream;

/*
6742. 넓이를 만족하는 삼각형들
N개의 점 P1 , … , PN이 주어진다.

이 중에서 세 점 Pi, Pj, Pk (i < j < k) 를 선택하여 만들어지는 삼각형 중에서

 넓이가 A/2이상, B/2이하인 것의 개수를 구하여라.


[입력]

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 세 정수 N, A, B ( 3 ≤ N ≤ 2,000, 1 ≤ A ≤ B ≤ 4×1012 ) 가 주어진다.

다음 N개의 줄의 i번째 줄에는 두 정수 xi, yi ( -106 ≤ xi, yi ≤ 106 ) 가 공백으로 구분되어 주어진다.

이는 Pi의 좌표가 (xi, yi)임을 나타낸다.


[출력]

각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고 한 칸을 띄운 후,

주어진 점 중 세 개의 점으로 이루어진 삼각형 중에서 넓이가 A/2이상, B/2이하인 것의 개수를 출력한다.



첫 번째 테스트 케이스 : 총 4개의 삼각형이 만들어지며, 각각의 넓이는 이다.
                                 이 중에서 이상 이하인 것은 두 개이다.

두 번째 테스트 케이스 : 총 4개의 삼각형이 만들어지며, 모두 넓이가 이다. 그러므로 4를 출력하면 된다.



입력

2
4 2 3 //첫 번째 테스트 케이스, N=4, A=2, B=3
0 0
0 1
1 2
2 0
4 1 1
0 0
0 1
1 1
1 0

출력

#1 2
#2 4 


*/


public class Solution
{
	public static void main(String args[]) throws Exception
	{
        long start=System.nanoTime();
		System.setIn(new FileInputStream("./test_5.txt"));
        ////////////////////////////////////////////////////
		Scanner sc = new Scanner(System.in);
        int T; //T:case number
        long A,B;
        int N;
        T=sc.nextInt();
        
        long area;
        long count;
        long[]vec12=new long[2];

        int idx;
        int idx2;
        int idx_;
        int idx1;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            N=sc.nextInt();
            A=sc.nextLong();
            B=sc.nextLong();
            int []pointx=new int[N]; // all the points
            int []pointy=new int[N];

            long []vec23x=new long[(N-1)*(int)(N-2)/2];
            long []vec23y=new long[(N-1)*(int)(N-2)/2];

            for(int jmi=0;jmi<N;jmi++){
                pointx[jmi]=sc.nextInt();
                pointy[jmi]=sc.nextInt();
            }

            count=0;

            for(int jmi=0;jmi<1;jmi++){
                for(int jmii=jmi+1;jmii<N-1;jmii++){
                        idx=(N-1)*(jmii-1)-jmii-1-(int)(jmii-1)*(jmii)/2;
                        
                        vec12[0]=pointx[jmii]-pointx[jmi];
                        vec12[1]=pointy[jmii]-pointy[jmi];

                    for(int jmiii=jmii+1;jmiii<N;jmiii++){
                        vec23x[idx+jmiii]=pointx[jmiii]-pointx[jmii];
                        vec23y[idx+jmiii]=pointy[jmiii]-pointy[jmii];

                        idx2=idx+jmiii;
                        area=Math.abs(vec12[0]*vec23y[idx2]-vec12[1]*vec23x[idx2]);
                        if(area>=A){
                            if(area<=B){
                                count+=1;
                            }
                        }
                    }
                }
            }

            for(int jmi=1;jmi<N-2;jmi++){
                idx_=(N-1)*(jmi-1)-jmi-1-(int)(jmi-1)*(jmi)/2;
                for(int jmii=jmi+1;jmii<N-1;jmii++){

                        idx=(N-1)*(jmii-1)-jmii-1-(int)(jmii-1)*(jmii)/2;
                        idx1=idx_+jmii;

                    for(int jmiii=jmii+1;jmiii<N;jmiii++){
                        idx2=idx+jmiii;
                        area=Math.abs(vec23x[idx1]*vec23y[idx2]-vec23y[idx1]*vec23x[idx2]);
                        if(area>=A){
                            if(area<=B){
                                count+=1;
                            }
                        }
                    }
                }
            }

            System.out.println("#"+test_case+" "+count);
        }    
        long finish=System.nanoTime();
        long timeElapsed=finish-start;
        System.out.println(timeElapsed/1e+6);
        }

}