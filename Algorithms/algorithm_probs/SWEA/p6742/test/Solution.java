import java.util.Scanner;
import java.io.FileInputStream;

public class Solution
{
	public static void main(String args[]) throws Exception
	{

		System.setIn(new FileInputStream("./test_4.txt"));
        ////////////////////////////////////////////////////
		Scanner sc = new Scanner(System.in);
        int T; //T:case number
        long A,B;
        int N;
        T=sc.nextInt();
        
        double area;
        long count;
        int[]vec1=new int[2];
        int[]vec2=new int[2];
        double p2_x;//p1 is alway base point //p3 is alway heigth point
        double p3_y;
        double angle;
        double sA; // sin angle
        double cA; // cos angle

		for(int test_case = 1; test_case <= T; test_case++)
		{
            N=sc.nextInt();
            A=sc.nextLong();
            B=sc.nextLong();
            int [][]points=new int[N][2]; // all the points
            points=ref_count(N,sc);
            count=0;

            for(int jmi=0;jmi<N-2;jmi++){
                for(int jmii=jmi+1;jmii<N-1;jmii++){
                        vec1=vectorize(points[jmi][0],points[jmi][1],points[jmii][0],points[jmii][1]);

                        angle=Math.atan((double)vec1[1]/vec1[0]);
                        sA=Math.sin(angle);
                        cA=Math.cos(angle);
                        p2_x=cA*vec1[0]+sA*vec1[1];

                    for(int jmiii=jmii+1;jmiii<N;jmiii++){
                        vec2=vectorize(points[jmi][0],points[jmi][1],points[jmiii][0],points[jmiii][1]);
                        p3_y=cA*vec2[1]-sA*vec2[0];

                        area=Math.abs(p2_x*p3_y); // rectangular
                        if(area>A || Math.abs(A-area)<=1e-10){
                            if(B>area || Math.abs(B-area)<=1e-10){
                                count+=1;
                            }
                        }
                    }
                }
            }
            System.out.println("#"+test_case+" "+count);
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
    public static int[] vectorize(int p1x, int p1y, int p2x, int p2y){

        int [] vec= new int[2];
        vec[0]=p2x-p1x;
        vec[1]=p2y-p1y;
        return vec;
    }
}