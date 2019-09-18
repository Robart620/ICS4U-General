package nqueens;

public class Board {

	private int numberSetQueens;
	private Queen[] stack;
	private int n;

	Board(int n) {
		this.n = n;
		numberSetQueens = 0;
		stack = new Queen[n];
	}

	void arrange() {
		while (numberSetQueens < n && numberSetQueens > -1) {
			if (!placeQueen()) {
				if (!pop())
					break;
			}
		}
		if (numberSetQueens <= 0)
			displayFailure();
		else
			displaySuccess();
	}

	private void displaySuccess() {
		int countRow = 0;
		int countCol = 0;

		while (countRow < n) {
			countCol = 0;
			while (countCol < n) {
				if (checkPosition(countRow, countCol))
					System.out.print(" Q ");
				else
					System.out.print(" x ");
				countCol++;
			}
			System.out.println();
			countRow++;
		}

	}

	private boolean checkPosition(int countRow, int countCol) {
		for (int i = 0; i < n; i++) {
			if (stack[i].getCol() == countCol && stack[i].getRow() == countRow)
				return true;
		}
		return false;
	}

	private void displayFailure() {
		System.out.println("There is no nQueens solution for n = " + n);

	}

	private boolean placeQueen() {
		Queen current;
		try {
			current = new Queen(peek().getRow() + 1, numberSetQueens);
		} catch (Exception ex) {
			current = new Queen(0, numberSetQueens);
		}

		boolean isPlaced = false;
		while (!isPlaced && current.getRow() < n) {
			if (!isConflicting(current)) {
				push(current);
				return true;
			}
			current = new Queen(current.getRow() + 1, numberSetQueens);
		}
		return false;
	}

	private boolean isConflicting(Queen current) {
		if (numberSetQueens == 0)
			return false;
		for (int i = 0; i < numberSetQueens; i++) {
			if (stack[i].getRow() == current.getRow())
				return true;
			else if (isDiagonal(current, stack[i]))
				return true;

		}
		return false;
	}

	private boolean isDiagonal(Queen current, Queen setQueen) {
		for (int i = 0; i > -1 && i < n; i++) {
			if ((setQueen.getCol() + i == current.getCol() && setQueen.getRow() + i == current.getRow())
					|| (setQueen.getCol() + i == current.getCol() && setQueen.getRow() - i == current.getRow()))
				return true;
		}
		return false;
	}

	public Queen peek() {
		if (stack[0] == null)
			throw new IllegalStateException("You really goofed this one up");
		else if (numberSetQueens == 0)
			return stack[0];
		return stack[numberSetQueens];
	}

	public boolean pop() {
		stack[numberSetQueens] = null;
		numberSetQueens--;
		if (numberSetQueens < 0)
			return false;
		return true;
	}

	public boolean isEmpty() {
		return numberSetQueens == 0;
	}

	public void push(Queen x) {
		stack[numberSetQueens++] = x;

	}
}
