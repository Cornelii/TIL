/*
p.6809. 에너지 전송 순서

N개의 축전기가 일렬로 나열되어 있다. 각 축전기는 1에서 N까지 번호가 붙어 있으며, i번 축전기에는 Ei만큼의 에너지가 저장되어 있다.

1만큼의 에너지를 소모하면 연속한 세 축전기에 있는 에너지가 한쪽으로 몰린다.

정확히 말하면 세 축전기 i, i+1, i+2 ( 1 ≤ i ≤ N-2 ) 의 에너지가 현재 Ei, Ei+1, i+2라고 할 때,

에너지를 전송하면 각각 에너지가 0, i+1 – 1, Ei + i+2가 된다.

즉, i+1의 에너지를 1 소모하면 i의 에너지가 모두 i+2로 전송되는 것이다. 물론 i+1의 에너지가 1이상이어야 한다.

에너지를 어떤 순서로 전송해야 N번 축전기에 있는 에너지가 최대한 크게 될 것인지 구하는 프로그램을 작성하라.


[입력]

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 하나의 정수 N ( 1 ≤ N ≤ 80 )이 주어진다.

두 번째 줄에는 N개의 정수 E1, …, EN ( 0 ≤ Ei ≤ 4)가 공백 하나로 구분되어 주어진다.


[출력]

각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고 한 칸을 띄운 후,

N번 축전기에 모을 수 있는 에너지 크기의 최댓값을 출력한다.

입력
7
1
2
2
1 2
3
4 1 4
3
4 0 4
5
4 1 4 0 4
5
4 1 4 1 4
5
4 2 4 0 4	//테스트 케이스 개수
//첫 번째 테스트 케이스, N = 1
//E1 = 2
//두 번째 테스트 케이스

출력
#1 2
#2 2
#3 8
#4 4
#5 7
#6 12
#7 11
*/
import java.util.Scanner;
import java.io.FileInputStream;


class Solution{

    static int zero_idx=0;
    static boolean flag=false; // true at odd_idx
    public static void main(String args[]) throws Exception{

        long start=System.nanoTime();
        System.setIn(new FileInputStream("./test2.txt"));

        Scanner sc=new Scanner(System.in);
        int T;
        T=sc.nextInt();
        int y;
        int N;

        for(int test_case = 1;test_case <= T; test_case++){

            N=sc.nextInt();
            int []C=new int[N];
            for(int i = 0; i < N; i++){
                C[i]=sc.nextInt();
            }

            if (N == 1){//edge cases
                System.out.println("#"+test_case+" "+C[0]);
            }else if(N == 2){
                System.out.println("#"+test_case+" "+C[1]);
            }else{

                C=detect_fill_zero(C,N);
                //set_flag();

                // for(int i=0; i < N; i++){
                //     System.out.print(C[i]+" ");
                // }
                //System.out.println("zero_idx "+Solution.zero_idx);
                //System.out.println("flag "+Solution.flag);

                y=summation(C,N);
                System.out.println("#"+test_case+" "+y);

                Solution.zero_idx=0;// Initialization
                Solution.flag=false;
            }
        }
        long end_time=System.nanoTime();
        System.out.println((end_time-start)/1e+6);
        sc.close();
    }

    //already checked for the two steps > 1, 
    public static int[] zero_excution(int[]seq,int idx,int N){
        // idx => index, where zero is
        int sum=0;
        if(N%2==0){
            if(Solution.flag){
                for(int i = Solution.zero_idx; i < idx; i=i+2){// i=1 // => zero_idx
                    sum+=seq[i];
                }
                if(seq[idx-1]>0){
                    seq[idx]+=sum;
                    Solution.zero_idx=idx-1;
                    set_flag();
                }
            }else{
                for(int i = Solution.zero_idx+1; i < idx; i=i+2){// i=1 // => zero_idx
                    sum+=seq[i];
                    //System.out.println("Hey1");
                }
                if(idx<N-1 & seq[idx-1]>0){
                    seq[idx]+=seq[idx-2];
                    seq[idx-1]-=1;
                    Solution.zero_idx=idx-2;
                    set_flag();
                }
            }
        }else{
            if(Solution.flag){
                for(int i=Solution.zero_idx+1; i < idx; i=i+2){ // => zero_idx
                    sum+=seq[i];
                    
                }
                if(seq[idx-1]>0){
                    seq[idx]+=sum;
                    Solution.zero_idx=idx-1;
                    set_flag();
                }
            }else{
                for(int i=Solution.zero_idx; i < idx; i=i+2){ // => zero_idx
                    sum+=seq[i];

                }
                if(idx<N-1 & seq[idx-1]>0){
                    seq[idx-1]=sum-1;
                    seq[idx]=seq[idx-2]-1;
                    Solution.zero_idx=idx-2;
                    set_flag();
                }

            }
    }
        
        return seq;
    }

    public static int[] detect_fill_zero(int[]seq,int N){
        // Maximization is needed!!! before zero_filling
        // forwarding detection is needed!
        //
        if(seq[1]==0){
            Solution.zero_idx=1;
            set_flag();
        }

        for(int i = 2; i < N; i++){
            if(seq[i]==0){
                if(seq[i-2]>1){
                    seq=zero_excution(seq,i,N);

                }else{
                    seq[i]+=seq[i-2];
                    seq[i-1]-=1;
                    Solution.zero_idx=i-1;// i-1?
                    set_flag();
                }
            }
        }
        return seq;
    }
    public static int summation(int[]seq,int N){
        int sum=0;
        if(N%2 == 0){//even when N even, idx of N's is located at odd.
            if(Solution.flag){
                for(int i = Solution.zero_idx; i < N;i = i+2){
                    sum+=seq[i];
                }
            }else{
                for(int i = Solution.zero_idx+1;i < N;i = i+2){
                    sum+=seq[i];
                }
            } 
        }else{// Target is positioned at even index
            if(Solution.flag){
                for(int i = Solution.zero_idx+1;i < N;i = i+2){
                    sum+=seq[i];
                }
            }else{
                for(int i = Solution.zero_idx;i < N;i = i+2){
                    sum+=seq[i];
                }
            }
        }        
        return sum;
    }
    
    public static void set_flag(){
        if(Solution.zero_idx%2==0){
            Solution.flag=false;
        }else{
            Solution.flag=true;
        }
    }
}