/**
 * Yehonatan Abramovitch yona132@gmail.com 318800182.
 */

import java.util.Map;

/**
 * Not Class.
 */
public class Not extends UnaryExpression {
    /**
     * Constructor for Not.
     *
     * @param expression the expression to negate
     */
    public Not(Expression expression) {
        super(expression);
    }

    /**
     * Evaluates the NOT operation with variable assignments.
     *
     * @param assignment a map containing variable assignments
     * @return the result of the NOT operation
     * @throws Exception if an error occurs during the evaluation
     */
    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return !getExpression().evaluate(assignment);
    }

    /**
     * Evaluates the NOT operation without variable assignments.
     *
     * @return the result of the NOT operation
     * @throws Exception if an error occurs during the evaluation
     */
    @Override
    public Boolean evaluate() throws Exception {
        return !getExpression().evaluate();
    }

    /**
     * Converts the NOT operation to a string representation.
     *
     * @return a string representation of the NOT operation
     */
    @Override
    public String toString() {
        return "~(" + this.getExpression().toString() + ")";
    }

    /**
     * Assigns a new expression to the operand.
     *
     * @param var        the variable to be assigned
     * @param expression the new expression to assign to the variable
     * @return a new expression with the variable assignment
     */
    @Override
    public Expression assign(String var, Expression expression) {
        return new Not(this.getExpression().assign(var, expression));
    }

    /**
     * Performs NANDification on the Not operation.
     *
     * @return the result of the expression uses only Nand operator
     */
    @Override
    public Expression nandify() {
        Expression e1 = this.getExpression().nandify();
        Expression e = new Nand(e1, e1);
        return e;
    }

    /**
     * Performs NORification on the Not operation.
     *
     * @return the result of the expression uses only Nor operator
     */
    @Override
    public Expression norify() {
        Expression e1 = this.getExpression().norify();
        Expression e = new Nor(e1, e1);
        return e;
    }

    @Override
    public Expression simplify() {
        Not ex = new Not((this.getExpression()).simplify());
        try {
            return new Val(ex.evaluate());
        } catch (Exception e) {
            return ex;
        }
    }
}


