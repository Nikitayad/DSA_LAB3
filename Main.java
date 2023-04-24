
public class Main {
		    Node node;
	    Main() {
	        node = null;
	    }

	    // Function to convert BST to skewed tree
	    Node convertToSkewed(Node root) {
	        if (root == null) {
	            return null;
	        }

	        Node right = convertToSkewed(root.right);
	        root.right = right;
	        Node left = convertToSkewed(root.left);
	        if (left == null) {
	            return root;
	        }

	        Node leftMost = left;
	        while (leftMost.right != null) {
	            leftMost = leftMost.right;
	        }

	        leftMost.right = root;
	        root.left = null;
	        return left;
	    }

	    // Function to print nodes of the skewed tree in ascending order
	    void printInorder(Node root) {
	        if (root == null) {
	            return;
	        }
	        System.out.print(root.data + " ");
	        printInorder(root.right);
	    }

	    public static void main(String[] args) {
	        Main tree = new Main();
	        tree.node = new Node(50);
	        tree.node.left = new Node(30);
	        tree.node.right = new Node(60);
	        tree.node.left.left = new Node(10);
	        tree.node.right.left = new Node(55);

	        Node skewed = tree.convertToSkewed(tree.node);
	        tree.printInorder(skewed);
	    }
}
	