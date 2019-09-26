package trees;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {


	public static void main(String[] args) throws FileNotFoundException {
		createTree("dataFiles/treeData.dat").inOrderTraversal();

	}

	private static IntBST createTree(String fileName) throws FileNotFoundException {
		Scanner in = new Scanner(new File(fileName));
		IntBST bst = new IntBST();
		while (in.hasNext()) {
			bst.addInt(in.nextInt());
		}
		in.close();
		return bst;
	}
}
