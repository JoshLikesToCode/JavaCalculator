package jstone.calculator.operators;

import jstone.calculator.evaluator.Operand;

public class CloseOperator extends Operator {
    @Override
    public int priority()
    {
        return 0;
    }

    @Override
    public Operand execute(Operand operand1, Operand operand2)
    {
        return null;
    }
}
