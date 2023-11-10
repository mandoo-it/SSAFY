package array1;
import java.util.*;
public class hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("Hello");
		//nextline은 단독으로 사용해라
		System.out.println(1<<0);
		System.out.println(1<<1);
		System.out.println(1<<2);
		System.out.println(1<<3);
		System.out.println(1<<4);
		System.out.println(1<<5);
		System.out.println(1<<6);
		//32번 비트연산하면 자기자신으로 컴백
		
		System.out.println(1<<32);
		System.out.println(1<<33);
		System.out.println(1<<34);
		System.out.println(1<<35);
		System.out.println(1<<36);
		System.out.println(1<<37);
		
		System.out.println(32>>0);
		System.out.println(32>>1);
		System.out.println(32>>2);
		
		System.out.println(-32>>0);
		System.out.println(-32>>1);
		System.out.println(-32>>2);
		
		System.out.println(-32>>>0);
		System.out.println(-32>>>1);
		System.out.println(-32>>>2);
		
		System.out.println(((123&1) == 0)?"짝":"홀");
		//0을로 채우기위해 0b1111
		System.out.println(0b1111 & (1<<0));
		System.out.println(0b1110 & (1<<0));
		System.out.println();
		System.out.println(0b1111 & (1<<1));
		System.out.println(0b1111 & (1<<1));
		
		int i=10;
		//2진수로 바꾸기
		System.out.println(i + " "+Integer.toBinaryString(i));


	
	}
}

