/**
 * Yehonatan Abramovitch yona132@gmail.com 318800182.
 */

import java.util.List;
import java.util.Map;

/**
 * BinaryExpression Class.
 */
public abstract class BinaryExpression extends BaseExpression {
    private Expression ex2;

    /**
     * Constructor for BinaryExpression.
     *
     * @param expression1 the first expression
     * @param expression2 the second expression
     */
    public BinaryExpression(Expression expression1, Expression expression2) {
        super(expression1);
        this.ex2 = expression2;
    }

    /**
     * Gets the second expression.
     *
     * @return the second expression
     */
    public Expression getExpression2() {
        return this.ex2;
    }

    /**
     * Sets a new expression for the second operand.
     *
     * @param expression the new expression to be set as the second operand
     */
    public void setExpression2(Expression expression) {
        this.ex2 = expression;
    }

    /**
     * Evaluates the binary expression with variable assignments.
     *
     * @param assignment a map containing variable assignments
     * @return the result of the evaluation
     * @throws Exception if an error occurs during the evaluation
     */
    @Override
    public abstract Boolean evaluate(Map<String, Boolean> assignment) throws Exception;

    /**
     * Evaluates the binary expression without variable assignments.
     *
     * @return the result of the evaluation
     * @throws Exception if an error occurs during the evaluation
     */
    @Override
    public abstract Boolean evaluate() throws Exception;

    /**
     * Gets a list of variables present in both expressions.
     *
     * @return a list of variables
     */
    @Override
    public List<String> getVariables() {
        List<String> lst1 = this.getExpression().getVariables();
        List<String> lst2 = this.getExpression2().getVariables();
        boolean flag = true;
        for (String s1 : lst1) {
            for (String s2 : lst2) {
                if (s2.equals(s1)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                lst2.add(s1);
            }
        }
        return lst2;
    }

    /**
     * Converts the binary expression to a string representation.
     *
     * @return a string representation of the expression
     */
    @Override
    public abstract String toString();

    /**
     * Assigns a new expression to a variable in both expressions.
     *
     * @param var        the variable to be assigned
     * @param expression the new expression to assign to the variable
     * @return a new expression with the variable assignment
     */
    @Override
    public abstract Expression assign(String var, Expression expression);

    /**
     * Applies NANDification to the expression .
     *
     * @return the expression tree resulting from converting all the operations to the logical Nand operation
     */
    @Override
    public abstract Expression nandify();

    /**
     * Applies NORification to the expression.
     *
     * @return the expression tree resulting from converting all the operations to the logical Nor operation
     */
    @Override
    public abstract Expression norify();

    /**
     * Simplifies the expression.
     *
     * @return a simplified version of the current expression
     */
    @Override
    public abstract Expression simplify();
}
