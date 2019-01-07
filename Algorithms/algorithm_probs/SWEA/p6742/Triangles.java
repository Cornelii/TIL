import user.utils.Solver;
// N combination 3//2 arrays

class Ordering{
    double A,B;
    Solver solver=new Solver();
    int count;
    public Ordering(int A, int B){
        this.A=A/2;
        this.B=B/2;
        this.count=0;
    }
    
    //public boolean isTriangle(){}

    public int[][] nCombi(int n){
        
        int N=this.Combination3(n);
        System.out.println(N);
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
        if(A<=area & area<=B){
            this.count+=1;
        }
    }
}

public class Triangles{
    public static void main(String[] args){
        int A; //lower boundary
        int B; //upper boundary
        // A=,B= Bound 
        // Input

        Ordering order=new Ordering(A,B);
        int n=6;
        int N=order.Combination3(n);
        int [][] sample=new int[N][3];
        sample=order.nCombi(n);
        // for(int jmi=0;jmi<N;jmi++){
        //     for(int jmii=0;jmii<3;jmii++){
        //         System.out.print(sample[jmi][jmii]);
        //     }
        //     System.out.println("\n");
        // }
        



    }


}
// Guess, i have data in the form of array.
// 1st. naive try
// is Triangle