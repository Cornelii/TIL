/*
6808. 규영이와 인영이의 카드게임

규영이와 인영이는 1에서 18까지의 수가 적힌 18장의 카드로 게임을 하고 있다.

한 번의 게임에 둘은 카드를 잘 섞어 9장씩 카드를 나눈다. 그리고 아홉 라운드에 걸쳐 게임을 진행한다.

한 라운드에는 한 장씩 카드를 낸 다음 두 사람이 낸 카드에 적힌 수를 비교해서 점수를 계산한다.

높은 수가 적힌 카드를 낸 사람은 두 카드에 적힌 수의 합만큼 점수를 얻고,

낮은 수가 적힌 카드를 낸 사람은 아무런 점수도 얻을 수 없다.

이렇게 아홉 라운드를 끝내고 총점을 따졌을 때, 총점이 더 높은 사람이 이 게임의 승자가 된다.

두 사람의 총점이 같으면 무승부이다.

이번 게임에 규영이가 받은 9장의 카드에 적힌 수가 주어진다.

규영이가 내는 카드의 순서를 고정하면, 인영이가 어떻게 카드를 내는지에 따른 9!가지 순서에 따라

규영이의 승패가 정해질 것이다.

이 때, 규영이가 이기는 경우와 지는 경우가 총 몇 가지 인지 구하는 프로그램을 작성하라.


[입력]

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 아홉 개의 정수가 공백으로 구분되어 주어진다.

각 정수는 1이상 18이하이며, 같은 정수는 없다.

규영이는 정수가 주어지는 순서대로 카드를 낸다고 생각하면 된다.


[출력]

각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고 한 칸을 띄운 후,

인영이가 카드를 내는 9! 가지의 경우에 대해 규영이가 게임을 이기는 경우의 수와 게임을 지는 경우의 수를

공백 하나로 구분하여 출력한다.

입력
4
1 3 5 7 9 11 13 15 17
18 16 14 12 10 8 6 4 2
13 17 9 5 18 7 11 1 15
1 6 7 9 12 13 15 17 18	//테스트 케이스 개수
//1st TC, 9장의 카드에 대한 정보        
//2nd TC


출력
#1 112097 250783
#2 250783 112097
#3 336560 26320
#4 346656 16224

*/

import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
public class Solution
{

    static int countW=0;
    static int countE=0;

    static int dum;
    static int tmp;
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
        int T;
        int perNum=362880;
        T=sc.nextInt();
        int resultL;
        int []g=new int[9];
        int []a=new int[9];
        
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
        */

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////
            for(int i=0 ; i<9 ; i++){
                g[i]=sc.nextInt();
            }


            a=a_card(g); //a card

            //Heap permutation
            generate_permu(9,g,a);
            resultL=perNum-Solution.countW-Solution.countE;
            System.out.println("#"+test_case+" "+Solution.countW+" "+resultL);
            set_zero();
        }
        sc.close();
    }




    /// a의 카드를 구하는 메소드
    public static int[] a_card(int[] g_card){
        int []a=new int[9];
        int chk=0;
        for(int i=1 ; i<19 ; i++){
            if(Notmembership_test(i,g_card)){
                a[chk]=i;
                chk+=1;
            }
        }
        return a;
    }

    public static boolean Notmembership_test(int a,int[] g_card){// fixed size for g_card => 9
        for(int i=0 ; i<9 ; i++){
            if(a == g_card[i]){
                return false;
            }
        }
        return true;
    }

    public static int fight(int[] g,int[] a){
        int G=0;
        int A=0;
        for(int i=0 ; i<9 ; i++){
            if(g[i] > a[i]){
                G+=g[i]+a[i];
            }else{
                A+=a[i]+g[i];
            }
        }
        //System.out.println(G-A);
        return G-A;
    }

    public static void discriminator(int a){
        if(a > 0){
            Solution.countW+=1;
        }else if(a == 0){
            Solution.countE+=1;
        }
        //System.out.println("YoYO");
    }

    // Heap Permutation
    public static void generate_permu(int n,int[] g,int[] a){
        if(n == 1){
            Solution.dum=fight(g,a);
            discriminator(Solution.dum);

        }else{
            for(int i=0 ; i<n-1; i++){
                generate_permu(n-1,g,a);

                if((n%2)==0){
                    Solution.tmp=a[i];
                    a[i]=a[n-1];
                    a[n-1]=Solution.tmp;
                    
                }else{
                    Solution.tmp=a[0];
                    a[0]=a[n-1];
                    a[n-1]=Solution.tmp;
                }
            }
            generate_permu(n-1,g,a);
        }
    }

    public static void set_zero(){
        Solution.countW=0;
        Solution.countE=0;
    }

}