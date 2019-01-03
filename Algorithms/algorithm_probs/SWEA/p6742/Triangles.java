import java.lang.Math;

class Solver{
    public double Area(int p1x, int p1y, int p2x, int p2y, int p3x, int p3y){
        a=this.vectorize(int p1x, int p1y, int p2x, int p2y);
        b=this.vectorize(int p1x, int p1y, int p3x, int p3y);
        norm_a=this.norm(a[0],a[1]);
        norm_b=this.norm(b[0],a[1]);
        Area=0.5*norm_a*norm_b*this.inner_sine(norm_a,norm_b,a[0]*b[0]+a[1]*b[1])

        return 0;
    }
    public double norm(int v1x, int v1y){
        return Math.sqrt((double)(v1x*v1x+v1y*v1y));
    }
    public int vectorize(int p1x, int p1y, int p2x, int p2y){
        int [2] vec={p2x-p1x,p2y-p1y};
        return vec
    }
    public double inner_sine(double a, double b, double dotprod){
        angle=Math.acos(dotprod/(a*b));
        return Math.sin(angle);
    }

    public boolean isTriangle(int p1x, int p1y, int p2x, int p2y, int p3x, int p3y){

    }
}

public class Triangles{
    public static void main(String[] args){
        Solver s=new Solver()
                
    }
}

// Java _SW expert Academy Problem
// non triangle


// Every Problem
// Interface to read input
// Interface to write output
// N of algorithm in sorting, searching, or matching
// Expected Constraints
// you don't have to get exact triangle area. object is not that!