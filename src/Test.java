import java.util.Random;


public class Test {

	public static void main(String[] args) {
		DList<Integer> list1 = new DList<Integer>();
		DList<Integer> list2 = new DList<Integer>();
		
		System.out.println("Random Numbers and Inserts");
		Random rand = new Random();
		int item3 = 0;
		for (int i = 0; i < 5; i++) {
			int j = rand.nextInt(100);
			list1.addLast(j);
			list2.addFirst(j);
			if (i == 3) item3 = j;
		}
		
		System.out.println("List1: " + list1.toString());
		System.out.println("List2: " + list2.toString());
		System.out.println("4th item in list 1: " + item3);
		
		Node<Integer> node = list1.search(item3);
		System.out.println("Node: " + node.toString());
		
		Integer item3r = list1.remove(node);
		System.out.println("List1 without item: " + list1.toString());
		System.out.println("Removed item as expected: " + (item3r == item3));
		
		System.out.println("\nTesting AddBefore and AddAfter");
		list1 = new DList<Integer>();
		Node<Integer> n1 = list1.addFirst(1);
		list1.addAfter(n1, rand.nextInt(100));
		list1.addAfter(n1, rand.nextInt(10));
		list1.addBefore(n1, rand.nextInt(100));
		System.out.println("List: " + list1.toString());
		
		list1 = new DList<Integer>();
		list2 = new DList<Integer>();
		list1.addLast(6);
		list1.addLast(9);
		list2.addLast(2);
		list2.addLast(8);
	
		DList<Integer> list3 = list1.merge(list2);
		DList<Integer> sortedList = list3.quicksort();
		
		System.out.println("\nMerge and Sorted sort test:");
		System.out.println("List1: " + list1.toString());
		System.out.println("List2: " + list2.toString());
		System.out.println("List3 (merged): " + list3.toString());
		System.out.println("SortedList: " + sortedList.toString());
		
		System.out.println("\nSorting Random List");
		list1 = new DList<Integer>();
		for (int i = 0; i < 9; i++) {
			list1.addLast(rand.nextInt(100));
		}
		System.out.println("Unsorted List: " + list1.toString());
		System.out.println("Sorted List: " + list1.quicksort());
		
	}

}
