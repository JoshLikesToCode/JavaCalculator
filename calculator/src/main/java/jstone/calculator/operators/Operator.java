package jstone.calculator.operators;

import jstone.calculator.evaluator.Operand;

import java.util.HashMap;
//import java.util.Iterator;
import java.util.Map;

public abstract class Operator {
    // The Operator class should contain an instance of a HashMap
    // This map will use keys as the tokens we're interested in,
    // and values will be instances of the Operators.

    private static Map<String, Operator> operators;
    static {
        operators = new HashMap<>();
        operators.put("+", new AddOperator());
        operators.put("-", new SubtractOperator());
        operators.put("/", new DivideOperator());
        operators.put("*", new MultiplyOperator());
        operators.put("^", new PowerOperator());
        operators.put("(", new OpenOperator());
        operators.put(")", new CloseOperator());
    }

    /**
     * retrieve the priority of an Operator
     * @return priority of an Operator as an int
     */
    public abstract int priority();

    /**
     * Abstract method to execute an operator given two operands.
     * @param operandOne first operand of operator
     * @param operandTwo second operand of operator
     * @return an operand of the result of the operation.
     */
    public abstract Operand execute(Operand operandOne, Operand operandTwo);

    /**
     * used to retrieve an operator from our HashMap.
     * This will act as out publicly facing function,
     * granting access to the Operator HashMap.
     *
     * @param token key of the operator we want to retrieve
     * @return reference to a Operator instance.
     */
    public static Operator getOperator(String token) {
        return operators.get(token);
    }


     /**
     * determines if a given token is a valid operator.
     */
    public static boolean check(String token) { return operators.containsKey(token); }

}
