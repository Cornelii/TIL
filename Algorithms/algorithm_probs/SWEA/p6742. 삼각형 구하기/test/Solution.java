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
            int [][]points=new int[N][2]; // all the points
            long []vec23x=new long[(N-1)*(int)(N-2)/2];
            long []vec23y=new long[(N-1)*(int)(N-2)/2];
            points=ref_count(N,sc);
            count=0;

            for(int jmi=0;jmi<1;jmi++){
                for(int jmii=jmi+1;jmii<N-1;jmii++){
                        idx=(N-1)*(jmii-1)-jmii-1-(int)(jmii-1)*(jmii)/2;
                        
                        vec12[0]=points[jmii][0]-points[jmi][0];
                        vec12[1]=points[jmii][1]-points[jmi][1];

                    for(int jmiii=jmii+1;jmiii<N;jmiii++){
                        vec23x[idx+jmiii]=points[jmiii][0]-points[jmii][0];
                        vec23y[idx+jmiii]=points[jmiii][1]-points[jmii][1];

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
                        // vec12[0]=points[jmii][0]-points[jmi][0];
                        // vec12[1]=points[jmii][1]-points[jmi][1];
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