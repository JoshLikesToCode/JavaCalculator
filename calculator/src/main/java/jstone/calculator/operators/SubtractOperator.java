package jstone.calculator.operators;

import jstone.calculator.evaluator.Operand;
import jstone.calculator.operators.Operator;

public class SubtractOperator extends Operator {
    @Override
    public int priority()
    {
        return 1;
    }

    @Override
    public Operand execute(Operand operand1, Operand operand2)
    {
        return new Operand(operand1.getValue() - operand2.getValue());
    }
}
