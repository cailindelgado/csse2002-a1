package sheep.expression;

import sheep.expression.arithmetic.Arithmetic;
import sheep.expression.basic.Constant;
import sheep.expression.basic.Nothing;
import sheep.expression.basic.Reference;

import static sheep.expression.arithmetic.Arithmetic.*;

public class CoreFactory implements ExpressionFactory {

	/**
	 * An instance of Reference that stores the given identifier
	 * @param identifier A reference to either a cell or a built-in
	 * @return An instance of Reference that stores the given identifier
	 * @requires identifier != ""
	 */
	public Expression createReference(String identifier) {
		if (!identifier.isEmpty()) {
			return new Reference(identifier);
		}
		return null;
	}

	/**
	 * An instance of Constant that stores the given value
	 * @param value A constant long value of the expression
	 * @return An instance of {@link Constant} that stores the given value
	 */
	public Expression createConstant(long value) {
		return new Constant(value);
	}

	/**
	 * An instance of {@link Nothing}
	 * @return An instance of {@link Nothing}
	 */
	public Expression createEmpty() {
		return new Nothing();
	}

	/**
	 * An instance of {@link Arithmetic} based on the given operator name
	 * @param name An identifier for the operator, e.g. +, -, *
	 * @param args A list of {@link Expression} instances as arguments to the {@link Arithmetic}
	 * instance
	 * @return An appropriate operator expression
	 * @throws InvalidExpression If the operator name is unknown or if any of the given
	 * {@link Object} arguments are not subclasses of {@link Exception} or if there are no argument
	 * given
	 */
	public Expression createOperator(String name, Object[] args) throws InvalidExpression {
		//check if name is in the string in order to continue
		if (!("+-*/<=".contains(name))) {
			throw new InvalidExpression("Operator name unknown");
		}

		//checks if args is an array of Expressions[]
		if (args instanceof Expression[] expressions) {
			//difference operation performed based on the operator name passed in
			switch (name.trim()) {
				case "+" -> plus(expressions);
				case "-" -> minus(expressions);
				case "*" -> times(expressions);
				case "/" -> divide(expressions);
				case "<" -> less(expressions);
				case "=" -> equal(expressions);
			}
		}
		throw new InvalidExpression("args not of type Expression[]");
	}

}

