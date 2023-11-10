import com.object.SingleTonObject;

public class SingletonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleTonObject s1 = SingleTonObject.getInstance();
		SingleTonObject s2 = SingleTonObject.getInstance();
		SingleTonObject s3 = SingleTonObject.getInstance();
		
		System.out.println(s1== s2);
		System.out.println(s3== s2);
		s1.test();
		s2.test();
		s3.test();
	}

}
