package postfix;

public class PostfixEvaluator {

	private Stack stack;
	private String[] segmentedExpression;

	public PostfixEvaluator(String expression) {
		stack = new Stack();
		segmentedExpression = new String[expression.split(" ").length];
		assignExpression(expression);
	}

	public void evaluate() {
		for (int i = 0; i < segmentedExpression.length; i++) {
			try {
				stack.push(Integer.parseInt(segmentedExpression[i]));
			} catch (Exception ex) {
				try {
					if (segmentedExpression[i].equals("+")) {
						stack.push(stack.pop() + stack.pop());
					} else if (segmentedExpression[i].equals("-")) {
						stack.push(stack.pop() - stack.pop());
					} else if (segmentedExpression[i].equals("*")) {
						stack.push(stack.pop() * stack.pop());
					} else if (segmentedExpression[i].equals("/")) {
						stack.push(stack.pop() / stack.pop());
					} else {
						operationFailed();
						return;
					}
				} catch (Exception ex1) {
					operationFailed();
					return;
				}
			}
		}
		if(stack.numberElements == 1)
			operationSuccess();
		else
			operationFailed();

	}
	
	private void assignExpression(String expression) {
		for(int i = 0; i < segmentedExpression.length; i++) {
			segmentedExpression[i] = expression.split(" ")[i];
		}
		
	}
	
	private void operationSuccess() {
		System.out.println("The result is: " + stack.pop());
	}

	private void operationFailed() {
		System.out.println("The expression entered could not be evaluated.");
	}

}
