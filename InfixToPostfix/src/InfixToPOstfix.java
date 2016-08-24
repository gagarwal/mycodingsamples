
import java.util.*;

public class InfixToPOstfix
{

	private boolean isOperator(char c)
	{
		return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '(' || c == ')';
	}

	private boolean isSpace(char c)
	{
		return (c == ' ');
	}

	private boolean lowerPrecedence(char op1, char op2)
	{
		// Tell whether op1 has lower precedence than op2, where op1 is an
		// operator on the left and op2 is an operator on the right.
		// op1 and op2 are assumed to be operator characters (+,-,*,/,^).
		switch (op1)
		{
		case '+':
		case '-':
			return !(op2 == '+' || op2 == '-');

		case '*':
		case '/':
			return op2 == '^' || op2 == '(';

		case '^':
			return op2 == '(';

		case '(':
			return true;

		default: // (shouldn't happen)
			return false;
		}
	} 

	public String convertToPostfix(String infix)
	{
		Stack<String> operatorStack = new Stack<String>();

		char c;

		StringTokenizer parser = new StringTokenizer(infix, "+-*/^() ", true);

		StringBuffer postfix = new StringBuffer(infix.length());

		while (parser.hasMoreTokens())
		{
			String token = parser.nextToken();

			c = token.charAt(0); // the first character of this token

			if ((token.length() == 1) && isOperator(c))
			{ // if token is an operator

				while (!operatorStack.empty() && !lowerPrecedence(((String) operatorStack.peek()).charAt(0), c))
					// (Operator on the stack does not have lower precedence, so
					// it goes before this one.)

					postfix.append(" ").append((String) operatorStack.pop());

				if (c == ')')
				{
					// Output the remaining operators in the parenthesized part.
					String operator = (String) operatorStack.pop();
					while (operator.charAt(0) != '(')
					{
						postfix.append(" ").append(operator);
						operator = (String) operatorStack.pop();
					}
				} else
					operatorStack.push(token);// Push this operator onto the
												// stack.

			} else if ((token.length() == 1) && isSpace(c))
			{
				// else if token was a space ignore it
			} else
			{ // (it is an operand)
				postfix.append(" ").append(token); // output the operand
			}
		}

		// Output the remaining operators on the stack.
		while (!operatorStack.empty())
			postfix.append(" ").append((String) operatorStack.pop());

		return postfix.toString();

	}// end convertToPostfix

	public static void main(String[] args)
	{
		String[] testString =
		{ "2 + 3 * 4 / 5", "2*3 - 4 + 5 / 6", " 35 - 42* 17 /2 + 10", " 33.2 - 17.5 * 2.0 ^ 3.2", "3 * (4 + 5)",
				"3 * ( 4 - (5+2))/(2+3)" };

		InfixToPOstfix converter = new InfixToPOstfix();

		for (int i = 0; i < testString.length; i++)
		{
			System.out.println("infix: " + testString[i]);
			System.out.println("postfix: " + converter.convertToPostfix(testString[i]));
			System.out.println();
		}
	}
}
