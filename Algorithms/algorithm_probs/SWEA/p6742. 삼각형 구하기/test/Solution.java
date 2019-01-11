import java.util.Scanner;
import java.io.FileInputStream;

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
        //int[]vec1=new int[2];
        int[]vec2=new int[2];
        long[]vec11=new long[2];

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
                        // vec1=vectorize(points[jmi][0],points[jmi][1],points[jmii][0],points[jmii][1]);
                        // vec11[0]=(long)vec1[0];
                        // vec11[1]=(long)vec1[1];

                        vec11[0]=points[jmii][0]-points[jmi][0];
                        vec11[1]=points[jmii][1]-points[jmi][1];

                    for(int jmiii=jmii+1;jmiii<N;jmiii++){
 
                        vec2=vectorize(points[jmii][0],points[jmii][1],points[jmiii][0],points[jmiii][1]);
                        area=Math.abs(vec11[0]*vec2[1]-vec11[1]*vec2[0]);
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
    public static long[] vectorize_long(int p1x, int p1y, int p2x, int p2y){
        long [] vec= new long[2];
        vec[0]=p2x-p1x;
        vec[1]=p2y-p1y;
        return vec;
    }
}