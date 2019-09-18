package nqueens;

public class NQueensDriver {

	public static void main(String[] args) {
		
		int n = 10;
		
		Board board = new Board(n);
		board.solve();
		
	}

}
