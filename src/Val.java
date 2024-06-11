/**
 * Yehonatan Abramovitch yona132@gmail.com 318800182.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Val Class.
 */
public class Val implements Expression {
    private boolean value;

    /**
     * Constructor for Val.
     *
     * @param x the boolean value (True or False)
     */
    public Val(boolean x) {
        this.value = x;
    }

    /**
     * Evaluates the value with variable assignments.
     *
     * @param assignment a map containing variable assignments (not used in Val)
     * @return the boolean value of the expression
     */
    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) {
        return this.value;
    }

    /**
     * Evaluates the value without variable assignments.
     *
     * @return the boolean value of the expression
     */
    @Override
    public Boolean evaluate() {
        return this.value;
    }

    /**
     * Gets the list of variables in the expression.
     *
     * @return an empty list since Val is a constant
     */
    @Override
    public List<String> getVariables() {
        return new ArrayList<String>();
    }

    /**
     * Converts the boolean value to a string representation.
     *
     * @return "T" for True and "F" for False
     */
    @Override
    public String toString() {
        if (this.value) {
            return "T";
        } else {
            return "F";
        }
    }

    /**
     * Assigns a new expression to a variable (not applicable in Val).
     *
     * @param var        the variable to be assigned (not used in Val)
     * @param expression the new expression to assign to the variable (not used in Val)
     * @return the same Val instance since it is a constant
     */
    @Override
    public Expression assign(String var, Expression expression) {
        return this;
    }

    /**
     * Applies NANDification to the expression (not applicable in Val).
     *
     * @return the same Val instance since it is a constant
     */
    @Override
    public Expression nandify() {
        return this;
    }

    /**
     * Applies NORification to the expression (not applicable in Val).
     *
     * @return the same Val instance since it is a constant
     */
    @Override
    public Expression norify() {
        return this;
    }

    /**
     * Simplifies the expression (not applicable in Val).
     *
     * @return the same Val instance since it is a constant
     */
    @Override
    public Expression simplify() {
        return this;
    }
}
