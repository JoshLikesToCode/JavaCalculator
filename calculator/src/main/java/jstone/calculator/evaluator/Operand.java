package jstone.calculator.evaluator;

/**
 * Operand class used to represent an operand
 * in a valid mathematical expression.
 */
public class Operand {
    /**
     * construct operand from string token.
     */

    int val;

    public Operand(String token) {
        this.val = Integer.parseInt(token);
    }

    /**
     * construct operand from integer
     */
    public Operand(int value) {
        this.val = value;
    }

    /**
     * return value of operand
     */
    public int getValue() {
        return val;
    }

    /**
     * Check to see if given token is a valid
     * operand.
     */
    public static boolean check(String token) {
        try{
            Integer.parseInt(token);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

}
