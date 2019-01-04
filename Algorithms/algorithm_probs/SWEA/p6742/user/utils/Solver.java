package user.utils;

import java.lang.Math;

public class Solver{
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

        double p2_x;
        double p3_y;
        
        vec1=this.vectorize(p2x,p2y,p1x,p1y);
        double angle=this.rotate_angle(vec1);

        p2_x=this.rotate_point(p2x,p2y,angle,'x');
        p3_y=this.rotate_point(p3x,p3y,angle,'y');

        return Math.abs((p2_x-p1x)*(p3_y-p1y))/2;
    }
    /*
    public int valueCount(){
        return 0;
    }*/
}
