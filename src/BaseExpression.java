/**
 * Yehonatan Abramovitch yona132@gmail.com 318800182.
 */

import java.util.List;
import java.util.Map;

/**
 * BaseExpression Class.
 */
public abstract class BaseExpression implements Expression {
    private Expression expression;

    /**
     * Constructor for BaseExpression.
     *
     * @param expression the inner expression contained in this object
     */
    public BaseExpression(Expression expression) {
        this.expression = expression;
    }

    /**
     * Gets the inner expression.
     *
     * @return the inner expression
     */
    public Expression getExpression() {
        return this.expression;
    }

    /**
     * Sets a new expression for the operand.
     *
     * @param expression the new expression to be set as the operand
     */
    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    /**
     * Evaluates the expression with variable assignments.
     *
     * @param assignment a map containing variable assignments
     * @return the result of the evaluation
     * @throws Exception if an error occurs during the evaluation
     */
    @Override
    public abstract Boolean evaluate(Map<String, Boolean> assignment) throws Exception;

    /**
     * Evaluates the expression without variable assignments.
     *
     * @return the result of the evaluation
     * @throws Exception if an error occurs during the evaluation
     */
    @Override
    public abstract Boolean evaluate() throws Exception;

    /**
     * Gets a list of variables present in the expression.
     *
     * @return a list of variables
     */
    @Override
    public abstract List<String> getVariables();

    /**
     * Converts the expression to a string representation.
     *
     * @return a string representation of the expression
     */
    @Override
    public abstract String toString();

    /**
     * Assigns a new expression to a variable in the expression.
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
