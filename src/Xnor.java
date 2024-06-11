
/**
 * Yehonatan Abramovitch yona132@gmail.com 318800182.
 */

import java.util.Map;

/**
 * Xnor Class.
 */
public class Xnor extends BinaryExpression {
    /**
     * Constructor for Xnor.
     *
     * @param expression1 the first expression
     * @param expression2 the second expression
     */
    public Xnor(Expression expression1, Expression expression2) {
        super(expression1, expression2);
    }

    /**
     * Evaluates the Xnor operation with variable assignments.
     *
     * @param assignment a map containing variable assignments
     * @return the result of the Xnor operation
     * @throws Exception if an error occurs during the evaluation
     */
    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        if (this.getExpression().evaluate(assignment) && !this.getExpression2().evaluate(assignment)) {
            return false;
        }
        if (!this.getExpression().evaluate(assignment) && this.getExpression2().evaluate(assignment)) {
            return false;
        }
        return true;
    }

    /**
     * Evaluates the Xnor operation without variable assignments.
     *
     * @return the result of the Xnor operation
     * @throws Exception if an error occurs during the evaluation
     */
    @Override
    public Boolean evaluate() throws Exception {
        if (this.getExpression().evaluate() && !this.getExpression2().evaluate()) {
            return false;
        }
        if (!this.getExpression().evaluate() && this.getExpression2().evaluate()) {
            return false;
        }
        return true;
    }

    /**
     * Converts the Xnor operation to a string representation.
     *
     * @return a string representation of the Xnor operation
     */
    @Override
    public String toString() {
        return "(" + this.getExpression().toString() + " # " + this.getExpression2().toString() + ")";
    }

    /**
     * Assigns a new expression to both operands.
     *
     * @param var        the variable to be assigned
     * @param expression the new expression to assign to the variable
     * @return a new expression with the variable assignment
     */
    @Override
    public Expression assign(String var, Expression expression) {
        return new Xnor(this.getExpression().assign(var, expression), this.getExpression2().assign(var, expression));
    }

    /**
     * Performs NANDification on the Xnor operation.
     *
     * @return the result of the expression uses only Nand operator
     */
    @Override
    public Expression nandify() {
        Expression e1 = this.getExpression().nandify();
        Expression e2 = this.getExpression2().nandify();
        Expression e = new Nand(new Nand(new Nand(e1, e1), new Nand(e2, e2)), new Nand(e1, e2));
        return e;
    }

    /**
     * Performs NORification on the Xnor operation.
     *
     * @return the result of the expression uses only Nor operator
     */

    @Override
    public Expression norify() {
        Expression e1 = this.getExpression().norify();
        Expression e2 = this.getExpression2().norify();
        Expression e = new Nor(new Nor(e1, new Nor(e1, e2)), new Nor(e2, new Nor(e1, e2)));
        return e;
    }

    /**
     * Simplifies the Xnor operation.
     *
     * @return a simplified expression
     */
    @Override
    public Expression simplify() {
        Xnor ex = new Xnor((this.getExpression()).simplify(), (this.getExpression2()).simplify());
        if ((ex.getExpression().toString()).equals(ex.getExpression2().toString())) {
            return new Val(true);
        }
        try {
            return new Val(ex.evaluate());
        } catch (Exception e) {
            return new Xnor(ex.getExpression(), ex.getExpression2());
        }
    }
}
