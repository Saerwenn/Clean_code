import src.MyLinkedList;

public class Main {
	public static void main (String[] args) {
		MyLinkedList myList = new MyLinkedList();

		myList.appendLast(33);
		myList.appendLast(34);
		myList.appendLast(35);
		myList.appendLast(36);
		myList.deleteElem(34);
		myList.appendFirst(32);
		myList.appendAtPosition(34, 3);
		myList.deleteElemAtPosition(5);
		System.out.print("number Elem: " + myList.getNumberElem());

		myList.print();
	}
}
