package stack2;
import java.util.Arrays;
import java.util.Scanner;
//중복순열 nPIr = n^r 5*5*5=125
//순열 nPr = 5*4*3 =60
//중복조합 nHr = 35
//조합 nCr = 5*4*3/3*2*1 = 10
//비트연산 없이 이거만 기억해서 네개 다 할 수 있게
public class PermComb {
    public static int n, r, cnt;
    public static int[] d = { 1, 2, 3, 4, 5 };
    public static int[] a, v;
    public static void permcomb(int start, int count) {
        if (count == r) {
            cnt++;
            System.out.println(Arrays.toString(a));
            return;
        } else {
            for (int i = start; i < n; i++) {
                // v 방문처리 안하면 중복순열, 중복 조합
                // v 방문 처리 하면 순열, 조합
                // i==0부터 하면 순열, i==start 부터 하면 조합
                if (v[i] == 0) {
                    v[i] = 1;
                    a[count] = d[i];
                    permcomb(i, count + 1);
                    v[i] = 0;
                }
            }
//    		순열
//    		for(int i=0;i<n;i++) {
//    			if(v[i] == 0) {
//    				v[i] = 1;
//    				a[count] = d[i];
//    				permcomb(i,count+1);
//    				v[i] = 0;
//    			}
//    		}
    		//증복 조합
    		for(int i=start;i<n;i++) {
    				a[count] = d[i];
    				permcomb(i,count+1);
    		}
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = 5; // sc.nextInt();
        r = 3; // sc.nextInt();
        a = new int[r];
        v = new int[n];
        permcomb(0, 0);
        System.out.println(cnt);
        sc.close();
    }
}