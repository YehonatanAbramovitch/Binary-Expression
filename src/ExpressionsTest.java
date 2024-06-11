/**
 * Yehonatan Abramovitch yona132@gmail.com 318800182.
 */

import java.util.Map;
import java.util.TreeMap;

/**
 * ExpressionsTest Class.
 */
public class ExpressionsTest {
    /**
     * Main method to run the expressions test.
     *
     * @param args command line arguments (not used)
     * @throws Exception if an exception occurs during expression evaluation
     */
    public static void main(String[] args) throws Exception {
        Expression e = new Not(
                new Xor(
                        new Or(
                                new Var("x"),
                                new Var("y")
                        ),
                        new Nor(
                                new Var("z"),
                                new Val(false))
                )
        );
        System.out.println(e);

        Map<String, Boolean> assignment = new TreeMap<>();
        assignment.put("x", true);
        assignment.put("y", false);
        assignment.put("z", false);

        Boolean value = e.evaluate(assignment);
        System.out.println(value);

        System.out.println(e.nandify());
        System.out.println(e.norify());

        System.out.println(e.simplify());
    }
}
