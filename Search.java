public class Search implements Runnable {
	private	int step;
	private Tree<Integer> tree = new Tree<Integer>();

	public Search(Tree<Integer> tree, int step) {
		this.step = step;
		this.tree = tree;
	}

	private void insert(int step) {

		for (int i = 0; i < step; i++) {

			int key = (int) (Math.random() * 1000);
			tree.addNode(key);
			System.out.println(key);
		}
	}

	@Override
	public void run() {
		insert(step);
		return;
	}


}