import java.util.*;

public class Test {

	public static void main(String[] args) {

		int thread_num = 0;

		System.out.println("������� ���-�� �����");

		Scanner sc = new Scanner(System.in);
		if (sc.hasNextInt()) {
			thread_num = sc.nextInt();
		} else {
			System.out.println("�� ����� �� ����� �����");
		}

		int node_num = 0;
		int node_count = 0;
		
		System.out.println("������� ���-�� �����");
		if (sc.hasNextInt()) { 								
			node_count = sc.nextInt(); 								
		} else {
			System.out.println("�� ����� �� ����� �����");
		}

		Tree<Integer> my_tree = new Tree<Integer>();

		int step = 0;
		if (node_count < thread_num) {
			step = node_count / thread_num;
		} else {
			step = 1;
			thread_num = node_count;
		}
		
		Thread[] thread = new Thread[thread_num];

		Search[] counter = new Search[thread_num];

		
		for (int i = 0; i < (thread_num - 1); i++) {
			counter[i] = new Search(my_tree, step);
			thread[i] = new Thread(counter[i]);
			thread[i].start();
		}
		
		counter[thread_num - 1] = new Search(my_tree, (step + (node_count % thread_num)) );
		thread[thread_num - 1] = new Thread(counter[thread_num - 1]);
		thread[thread_num - 1].start();
		

		
		for (int i = 0; i < thread_num; i++) {
			try {
				thread[i].join();
			} catch (InterruptedException e) {
				System.out.println("Intrrupted!");
			}
		}

		
		int search_key = 0;
		System.out.println("������� ������� ����");
		if (sc.hasNextInt()) { 								
			search_key = sc.nextInt(); 								
		} else {
			System.out.println("�� ����� �� ����� �����");
		}

		int deep = my_tree.SearchKey(search_key); 
		if (deep == 0){
			System.out.println("������ ���� �� ���������� ��� ��������� � �����");
		} else {
		System.out.println("���� � ������ ������ ��������� �� ������ " + deep + " �� �����");
		}
		
		
	}
}


