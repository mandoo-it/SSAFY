package com.ssafy.algo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class dfs {
	public static int[] data;
    public static int N, hap, cnt;
    public static void solve(int sum, int pos) {
        if(sum > hap)    return;
        if(sum==hap) {
            cnt++;
            return;
        }
        if(pos > N-1 )   return;
        solve(sum,          pos+1);
        solve(sum+data[pos],pos+1);
        
    }
    
    
    public static void main(String[] args) throws FileNotFoundException {
//        System.setIn(new FileInputStream("res/input_D3_2817.txt"));
        Scanner sc = new Scanner(System.in);
        
        
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N  = sc.nextInt();
            hap  = sc.nextInt();
            data =new int[N];
            
            
            for (int i = 0; i < data.length; i++) {
                data[i] = sc.nextInt();
            }
            solve(0,0);
            System.out.println("#" + (tc)+" " + cnt);
            
            
        }
    
    }
}
