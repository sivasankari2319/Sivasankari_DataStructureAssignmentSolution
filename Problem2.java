
public class Problem2 {
	static Node node;
	static Node prevNode = null;
	static Node headNode = null;

	static void flattenBstToRightSkewed(Node root) {

		if (root == null) {
			return;
		}

		flattenBstToRightSkewed(root.left);
		Node rightNode = root.right;

		if (headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		} else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

		flattenBstToRightSkewed(rightNode);
	}

	static void traverseRightSkewed(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		traverseRightSkewed(root.right);
	}

	public static void main(String[] args) {
		Problem2.node = new Node(50);
		Problem2.node.left = new Node(30);
		Problem2.node.right = new Node(60);
		Problem2.node.left.left = new Node(10);
		Problem2.node.left.right = new Node(40);

		flattenBstToRightSkewed(node);
		traverseRightSkewed(headNode);
	}
}

class Node {
	int val;
	Node left;
	Node right;

	Node(int item) {
		val = item;
		left = right = null;
	}
}
