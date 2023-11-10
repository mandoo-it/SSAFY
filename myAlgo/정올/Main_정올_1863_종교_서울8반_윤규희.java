package 파이팅;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main_정올_1863_종교_서울8반_윤규희 {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] p = new int[N+1];
        for(int i=1; i<p.length; i++) {
            p[i] = i;
        }
     
        int[][] ia = new int[M][2];
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
            ia[i][0] = Integer.parseInt(st.nextToken());
            ia[i][1] = Integer.parseInt(st.nextToken());
            union(p, ia[i][0], ia[i][1]);
        }
        int result = 0;
        
        for(int i=1;  i<p.length; i++) {
            if(p[i]==i) result++;
        }
        
        System.out.println(result);
    }
    
    public static void union(int[] p, int a, int b) {
        int i= findset(p, a);
        int j = findset(p, b);
        if(i < j) p[j] = i;
        else p[i] = j;
        
    }
    public static int findset(int[] p, int a) {
        if(p[a]==a) return a;
        return p[a] = findset(p, p[a]);
    }
}