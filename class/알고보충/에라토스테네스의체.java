
public class 에라토스테네스의체 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] visited = new boolean[121];
		
		for(int i=2;i<visited.length;i++) {
			if(!visited[i]) {
				System.out.print(i + " ");
//				for(int j=i+1;j<visited.length;j++) {
//					if(j % i == 0)
//						visited[j] = true;
//				}
				for(int j=i*2;j<visited.length;j+=i) {
						visited[j] = true;
				}
			}
		}
	}

}
