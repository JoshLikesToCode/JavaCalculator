package jstone.calculator.operators;

import jstone.calculator.evaluator.Operand;
import jstone.calculator.operators.Operator;

public class PowerOperator extends Operator {
    @Override
    public int priority()
    {
        return 3;
    }

    @Override
    public Operand execute(Operand operand1, Operand operand2)
    {
        return new Operand((int) Math.pow(operand1.getValue(), operand2.getValue()));
    }
}
