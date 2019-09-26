package trees;

public class IntBST {

	private IntBinaryTreeNode root;

	public IntBST(IntBinaryTreeNode root) {
		this.root = root;
	}

	public IntBST() {
		this.root = null;
	}

	public void addInt(Integer data) {
		if (root == null) {
			root = new IntBinaryTreeNode(data);
		}
		if (root.getData() > data) {
			if (root.hasLeft()) {
				addIntNode(root.getLeftChild(), data);
			} else {
				root.setLeftChild(new IntBinaryTreeNode(data));
			}
		} else if (root.getData() < data) {
			if (root.hasRight()) {
				addIntNode(root.getRightChild(), data);
			} else {
				root.setRightChild(new IntBinaryTreeNode(data));
			}
		}
	}

	private void addIntNode(IntBinaryTreeNode root, Integer data) {
		if (root.getData() > data) {
			if (root.hasLeft()) {
				addIntNode(root.getLeftChild(), data);
			} else {
				root.setLeftChild(new IntBinaryTreeNode(data));
			}
		} else if (root.getData() < data) {
			if (root.hasRight()) {
				addIntNode(root.getRightChild(), data);
			} else {
				root.setRightChild(new IntBinaryTreeNode(data));
			}
		}

	}
	
	public void inOrderTraversal() {
		inOrderTraversal(root);
	}

	private void inOrderTraversal(IntBinaryTreeNode node) {
		if (node.hasLeft()) {
			inOrderTraversal(node.getLeftChild());
			System.out.println(node.getData());
		}
		if (node.hasRight()) {
			inOrderTraversal(node.getRightChild());
			System.out.println(node.getData());
		}

	}
}
