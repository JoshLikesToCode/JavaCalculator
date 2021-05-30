package jstone.calculator.operators;

import jstone.calculator.evaluator.Operand;

public class DivideOperator extends Operator {
    @Override
    public int priority()
    {
        return 2;
    }

    @Override
    public Operand execute(Operand operand1, Operand operand2)
    {
        return new Operand(operand1.getValue() / operand2.getValue());
    }
}