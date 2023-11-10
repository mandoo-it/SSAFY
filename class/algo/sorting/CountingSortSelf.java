import java.util.Arrays;

public class CountingSortSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {9,8,6,5,4,3,6,3};
		int M = Arrays.stream(arr).max().getAsInt();
		int[] count = new int[M+1];//인덱스는 0부터 시작하니 맥스가 10이라면 11짜리 배열을 만들어줘야
		int[] temp = new int[arr.length];
		
		for(int i=0;i<arr.length;i++)
			count[arr[i]]++;
		for(int i=2;i<count.length;i++)
			count[i] += count[i-1];
		
		for(int i=arr.length-1;i>0;i--) {
			temp[count[arr[i]]] = arr[i];
			count[arr[i]]--;
		}
		System.out.println(Arrays.toString(temp));
		
	}

}
