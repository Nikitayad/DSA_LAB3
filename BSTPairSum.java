
public class BSTPairSum {
		    static class Node {
	        int data;
	        Node left, right;
	        Node(int data) {
	            this.data = data;
	            left = right = null;
	        }
	    }

	    public static Node insert(Node root, int data) {
	        if(root == null) {
	            return new Node(data);
	        }
	        if(data < root.data) {
	            root.left = insert(root.left, data);
	        }
	        else if(data > root.data) {
	            root.right = insert(root.right, data);
	        }
	        return root;
	    }

	    public static boolean findPair(Node root, int sum) {
	        if(root == null) {
	            return false;
	        }
	        Node left = root, right = root;
	        while(left.left != null) {
	            left = left.left;
	        }
	        while(right.right != null) {
	            right = right.right;
	        }
	        while(left != right && right != null) {
	            int currentSum = left.data + right.data;
	            if(currentSum == sum) {
	                System.out.println("Pair is (" + left.data + ", " + right.data + ")");
	                return true;
	            }
	            else if(currentSum < sum) {
	                left = left.right;
	            }
	            else {
	                right = right.left;
	            }
	        }
	        return false;
	    }

	    public static void main(String[] args) {
	        Node root = null;
	        int sum = 130;
	        int[] arr = {50, 60, 70, 80, 90, 100};
	        for(int i : arr) {
	            root = insert(root, i);
	        }
	        if(!findPair(root, sum)) {
	            System.out.println("Nodes are not found");
	        }
	    }
	}

