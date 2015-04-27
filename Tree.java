public class Tree<Key extends Comparable<Key>> {
	public Tree() {
	}

	private class Node {
		private Key key;
		private Node left, right;

		private Node(Key key) {

			this.key = key;
		}
	}

	private Node root = null;
	private int counter = 0;
	

	public Key getRootKey() {
		return root.key;
	}

	public Key getLeftChildKey(Key k) {

		Node x = treeSearchKey(k);
		if (x.left != null) {
			return x.left.key;
		} else
			return null;
	}

	public Key getRightChildKey(Key k) {

		Node x = treeSearchKey(k);
		if (x.right != null) {
			return x.right.key;
		} else
			return null;
	}

	public void addNode(Key k) {
		treeAddNode(k);
	}

	private void treeAddNode(Key k) {
		Node x = root, y = null;

		while (x != null) {
			int tmp = k.compareTo(x.key);
			if (tmp == 0) {
				x.key = k;
				return;
			} else {
				y = x;
				if (tmp < 0) {
					x = x.left;
				} else {
					x = x.right;
				}
			}
		}

		Node add_node = new Node(k);

		if (y == null) {
			root = add_node;
		} else {
			if (k.compareTo(y.key) < 0) {
				y.left = add_node;
			} else {
				y.right = add_node;
			}
		}
	}



	private Node treeSearchKey(Key k) {

		Node x = root;

		while (x != null) {
			int tmp = k.compareTo(x.key);
			if (tmp == 0) {
				return x;
			} else if (tmp < 0) {
				counter ++;
				x = x.left;
			} else {
				counter++;
				x = x.right;
				
			}
		}
		return null;
	}
	
	public int SearchKey(Key k) {
		int deep = 0;
		Node x = root;

		while (x != null) {
			int tmp = k.compareTo(x.key);
			if (tmp == 0) {
				return deep;
			} else if (tmp < 0) {
				deep ++;
				x = x.left;
			} else {
				deep ++;
				x = x.right;
				
			}
		}
		return 0;
	}



}