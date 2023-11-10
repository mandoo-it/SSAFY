package list;

class MyLinkedList
{
	Node header = new Node();
	
	public void addFirst(int data) {
//		Node n = new Node();
//		n.data = data;
//		n.link = header.link;
//		header.link = n;
		header.link = new Node(data,header.link);
	}
	public void append(int data) {
		if(header.link == null) {
			addFirst(data);
		} else {
			Node n = new Node();
			n.data = data;
			n.link = null;
			Node t = header.link;
			while(t.link != null) {
				t = t.link;
			}
			t.link = n;
		}
	
	}
	public void delete(int data) {
		if(header.link == null) return;
		Node t = header;
		while(t.link != null) {
			if(t.link.data == data) {
				t.link = t.link.link;
				return;
			} else {
				t = t.link;
			}
		}
	}
	public void print() {
		if(header.link == null) return;
		Node t = header.link;
		while(t.link != null) {
			System.out.print(t.data+"->");
			t = t.link;
		}
		System.out.println(t.data);
	}
	
}
public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedList ll = new MyLinkedList();
		ll.addFirst(3);
		ll.print();
		ll.addFirst(2);
		ll.addFirst(1);
		ll.print();
		ll.append(4);
		ll.append(5);
		ll.print();
		ll.delete(3);
		ll.print();
	}

}
