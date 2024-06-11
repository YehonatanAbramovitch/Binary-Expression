/**
 * Yehonatan Abramovitch yona132@gmail.com 318800182.
 */

import java.util.List;
import java.util.Map;

/**
 * UnaryExpression Class.
 */
public abstract class UnaryExpression extends BaseExpression {
    /**
     * Constructor for UnaryExpression.
     *
     * @param expression the inner expression
     */
    public UnaryExpression(Expression expression) {
        super(expression);
    }

    /**
     * Evaluates the unary expression with variable assignments.
     *
     * @param assignment a map containing variable assignments
     * @return the result of the evaluation
     * @throws Exception if an error occurs during the evaluation
     */
    @Override
    public abstract Boolean evaluate(Map<String, Boolean> assignment) throws Exception;

    /**
     * Evaluates the unary expression without variable assignments.
     *
     * @return the result of the evaluation
     * @throws Exception if an error occurs during the evaluation
     */
    @Override
    public abstract Boolean evaluate() throws Exception;

    /**
     * Gets a list of variables present in the inner expression.
     *
     * @return a list of variables
     */
    @Override
    public List<String> getVariables() {
        return this.getExpression().getVariables();
    }

    /**
     * Converts the unary expression to a string representation.
     *
     * @return a string representation of the expression
     */
    @Override
    public abstract String toString();

    /**
     * Assigns a new expression to a variable in the inner expression.
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
