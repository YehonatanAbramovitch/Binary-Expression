/**
 * Yehonatan Abramovitch yona132@gmail.com 318800182.
 */

import java.util.Map;

/**
 * Xor Class.
 */
public class Xor extends BinaryExpression {
    /**
     * Constructor for Xor.
     *
     * @param expression1 the first expression
     * @param expression2 the second expression
     */
    public Xor(Expression expression1, Expression expression2) {
        super(expression1, expression2);
    }

    /**
     * Evaluates the Xor operation with variable assignments.
     *
     * @param assignment a map containing variable assignments
     * @return the result of the Xor operation
     * @throws Exception if an error occurs during the evaluation
     */
    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        if (this.getExpression().evaluate(assignment) && !this.getExpression2().evaluate(assignment)) {
            return true;
        }
        if (!this.getExpression().evaluate(assignment) && this.getExpression2().evaluate(assignment)) {
            return true;
        }
        return false;
    }

    /**
     * Evaluates the Xor operation without variable assignments.
     *
     * @return the result of the Xor operation
     * @throws Exception if an error occurs during the evaluation
     */
    @Override
    public Boolean evaluate() throws Exception {
        if (this.getExpression().evaluate() && !this.getExpression2().evaluate()) {
            return true;
        }
        if (!this.getExpression().evaluate() && this.getExpression2().evaluate()) {
            return true;
        }
        return false;
    }

    /**
     * Converts the Xor operation to a string representation.
     *
     * @return a string representation of the Xor operation
     */
    @Override
    public String toString() {
        return "(" + this.getExpression().toString() + " ^ " + this.getExpression2().toString() + ")";
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
        return new Xor(this.getExpression().assign(var, expression), this.getExpression2().assign(var, expression));
    }

    /**
     * Performs NANDification on the Xor operation.
     *
     * @return the result of the expression uses only Nand operator
     */
    @Override
    public Expression nandify() {
        Expression e1 = this.getExpression().nandify();
        Expression e2 = this.getExpression2().nandify();
        Expression e = new Nand(new Nand(e1, new Nand(e1, e2)), new Nand(e2, new Nand(e1, e2)));
        return e;
    }

    /**
     * Performs NORification on the Xor operation.
     *
     * @return the result of the expression uses only Nor operator
     */
    @Override
    public Expression norify() {
        Expression e1 = this.getExpression().norify();
        Expression e2 = this.getExpression2().norify();
        Expression e = new Nor(new Nor(new Nor(e1, e1), new Nor(e2, e2)), new Nor(e1, e2));
        return e;
    }

    /**
     * Simplifies the Xor operation.
     *
     * @return a simplified expression
     */
    @Override
    public Expression simplify() {
        Xor ex = new Xor((this.getExpression()).simplify(), (this.getExpression2()).simplify());
        if ((ex.getExpression().toString()).equals(ex.getExpression2().toString())) {
            return new Val(false);
        }
        try {
            return new Val(ex.evaluate());
        } catch (Exception e) {
            try {
                boolean a = (ex.getExpression()).evaluate();
                if (a) {
                    return new Not(ex.getExpression2());
                }
                return ex.getExpression2();
            } catch (Exception e1) {
                try {
                    boolean b = (ex.getExpression2()).evaluate();
                    if (b) {
                        return new Not(ex.getExpression());
                    }
                    return ex.getExpression();
                } catch (Exception e2) {
                    return ex;
                }
            }
        }
    }
}