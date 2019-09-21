package postfix;

public class Driver {
	
	private static String expression;
	
	public static void main(String[] args) {
		expression = "2 3 9 + *";
		PostfixEvaluator pE = new PostfixEvaluator(expression);
		pE.evaluate();

	}

}
