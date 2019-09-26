package javas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
//import java.io.FileReader;


// Least Common Ancestor
public class LCA_leastCommonAncestor {
	
	//static FileReader FR;
	
	static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer ST;
	static StringBuilder ANSWER;
	static int N;
	static int[][] D;
	static int[] depth;
	static int RESULT;
	//static BufferedReader BR;
	
	public static void main(String[] args)throws Exception{
//		try{
//			FileReader FR = new FileReader("input.txt");
//			BR = new BufferedReader(FR);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		
		
		int T = Integer.parseInt(BR.readLine().trim());
		for(int tc = 1; tc <= T; tc++){
			input();
			process();
			print(tc);
		}
		BW.close();
		BR.close();
		
	}
	
	public static void input() throws Exception {
		N = Integer.parseInt(BR.readLine().trim());
		D = new int[16][N+1];
		depth = new int[N+1];
		
		ANSWER = new StringBuilder();
		int a, b;
		for(int i = 0; i < N-1; i++){
			ST = new StringTokenizer(BR.readLine().trim());
			a = Integer.parseInt(ST.nextToken());
			b = Integer.parseInt(ST.nextToken());
			
			D[0][b] = a;
		}
		
		//init D
		for(int i = 1; i < 15; i++){
			for(int j = 1; j < N+1; j++) D[i][j] = D[i-1][D[i-1][j]];
		}
	}
	
	public static void process() throws Exception{
		// get depth from D;
		for(int i = 1; i < N+1; i++){
			if (depth[i] == 0) getDepth(i);
		}
		
		// get query
		int a, b;
		ST = new StringTokenizer(BR.readLine().trim());
		a = Integer.parseInt(ST.nextToken());
		b = Integer.parseInt(ST.nextToken());
		
		// calculate depth difference
		int diff = Math.abs(depth[a] - depth[b]);
		int targetA, targetB;
		if(depth[a] < depth[b]){
			targetA = a;
			targetB = b;
		}else {
			targetA = b;
			targetB = a;
		}
		
		// matching depth first
		for(int i = 0; i < 16; i++)
			if(((1 << i) & diff) != 0){
				targetB = D[i][targetB];
			}
		
		if(targetA == targetB){
			RESULT = targetA;
			return;
		}
		
		// binary search
		RESULT = jumpLCA(targetA, targetB);
	}
	
	public static void print(int tc) throws Exception {
		ANSWER.append(RESULT).append('\n');
		BW.write(ANSWER.toString());
	}
	
	public static int jumpLCA(int a, int b){
		int d = depth[a];
		int pos = 15;
		for(int i = 15; i >= 0; i--){
			if(((1<<i)&d) != 0){
				pos = i;
				break;
			}
		}
		
		int tmpA, tmpB;
		while(pos >= 0){
			if(pos == 0){
				a = D[0][a];
				b = D[0][b];
				break;
			}
			
			tmpA = D[pos][a];
			tmpB = D[pos][b];
			if(tmpA != tmpB){
				a = tmpA;
				b = tmpB;
			}
			pos--;
		}
		if(a != b){
			a = D[0][a];
		}
		
		return a;
	}
	
	
	public static void getDepth(int s){
		int iter = 0;
		int tmp = s;
		while(D[0][tmp] != 0 && depth[tmp] == 0){
			iter++;
			tmp = D[0][tmp];
		}
		if(depth[tmp] != 0) iter += depth[tmp];
		
		tmp = s;
		while(D[0][tmp] != 0 && depth[tmp] == 0){
			depth[tmp] = iter;
			iter--;
			tmp = D[0][tmp];
		}
	}
}
