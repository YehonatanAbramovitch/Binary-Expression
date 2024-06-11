/**
 * Yehonatan Abramovitch yona132@gmail.com 318800182.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Var Class.
 */
public class Var implements Expression {
    private String str;

    /**
     * Constructor for Var.
     *
     * @param str the String value
     */
    public Var(String str) {
        this.str = str;
    }

    /**
     * Evaluates the variable with variable assignments.
     *
     * @param assignment a map containing variable assignments
     * @return the boolean value of the variable based on the assignment
     * @throws Exception if the variable is not present in the assignment
     */
    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        if (assignment.containsKey(this.str)) {
            return assignment.get(this.str);
        }
        throw new Exception("the map assignment is not contain this var");
    }

    /**
     * Evaluates the variable without variable assignments.
     *
     * @return an exception since variable evaluation requires an assignment
     * @throws Exception always thrown since variable evaluation without assignment is not supported
     */
    @Override
    public Boolean evaluate() throws Exception {
        throw new Exception("the map assignment is not contain this var");
    }

    /**
     * Gets the list of variables in the expression.
     *
     * @return a list containing the variable name
     */
    @Override
    public List<String> getVariables() {
        List<String> lst = new ArrayList<>();
        if (this.str != null) {
            lst.add(this.str);
        }
        return lst;
    }

    /**
     * Converts the variable to a string representation.
     *
     * @return the variable name
     */
    @Override
    public String toString() {
        if (this.str != null) {
            return this.str;
        }
        return "";
    }

    /**
     * Assigns a new expression to the variable.
     *
     * @param var        the variable name to be assigned
     * @param expression the new expression to assign to the variable
     * @return the same Var instance if the variable names do not match, otherwise the assigned expression
     */
    @Override
    public Expression assign(String var, Expression expression) {
        if (this.toString().equals(var)) {
            return expression;
        }
        return this;
    }

    /**
     * Applies NANDification to the expression (not applicable in Var).
     *
     * @return the same Var instance since it is a variable
     */
    @Override
    public Expression nandify() {
        return this;
    }

    /**
     * Applies NORification to the expression (not applicable in Var).
     *
     * @return the same Var instance since it is a variable
     */
    @Override
    public Expression norify() {
        return this;
    }

    /**
     * Simplifies the expression (not applicable in Var).
     *
     * @return the same Var instance since it is a variable
     */
    @Override
    public Expression simplify() {
        return this;
    }
}
