/**
 * Yehonatan Abramovitch yona132@gmail.com 318800182.
 */

import java.util.Map;
import java.util.List;

/**
 * Expression interface.
 */
public interface Expression {
    /**
     * Evaluates the expression with variable assignments.
     *
     * @param assignment a map containing variable assignments
     * @return the result of the evaluation
     * @throws Exception if an error occurs during the evaluation
     */
    Boolean evaluate(Map<String, Boolean> assignment) throws Exception;

    /**
     * Evaluates the expression without variable assignments.
     *
     * @return the result of the evaluation
     * @throws Exception if an error occurs during the evaluation
     */
    Boolean evaluate() throws Exception;

    /**
     * Gets a list of variables present in the expression.
     *
     * @return a list of variables
     */
    List<String> getVariables();

    /**
     * Converts the expression to a string representation.
     *
     * @return a string representation of the expression
     */
    String toString();

    /**
     * Assigns a new expression to a variable in the expression.
     *
     * @param var        the variable to be assigned
     * @param expression the new expression to assign to the variable
     * @return a new expression with the variable assignment
     */
    Expression assign(String var, Expression expression);

    /**
     * Applies NANDification to the expression .
     *
     * @return the expression tree resulting from converting all the operations to the logical Nand operation
     */
    Expression nandify();

    /**
     * Applies NORification to the expression.
     *
     * @return the expression tree resulting from converting all the operations to the logical Nor operation
     */
    Expression norify();

    /**
     * Simplifies the expression.
     *
     * @return a simplified version of the current expression
     */
    Expression simplify();
}
