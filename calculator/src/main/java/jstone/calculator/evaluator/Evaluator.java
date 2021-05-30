package jstone.calculator.evaluator;



import jstone.calculator.evaluator.exceptions.InvalidTokenException;
import jstone.calculator.operators.Operator;

import java.util.Stack;
import java.util.StringTokenizer;

public class Evaluator {

    private Stack<Operand> operandStack;
    private Stack<Operator> operatorStack;
    private StringTokenizer expressionTokenizer;
    // we will need to add parenthesis to the list of delimiters
    private final String delimiters = " +/*-^()";

    public Evaluator() {
        operandStack = new Stack<>();
        operatorStack = new Stack<>();
    }

    public int evaluateExpression(String expression ) throws InvalidTokenException {
        String expressionToken;

        this.expressionTokenizer = new StringTokenizer( expression, this.delimiters, true );

        while ( this.expressionTokenizer.hasMoreTokens() ) {
            // filter out spaces
            if ( !( expressionToken = this.expressionTokenizer.nextToken() ).equals( " " )) {
                // check if token is an operand
                if ( Operand.check( expressionToken )) {
                    operandStack.push( new Operand( expressionToken ));
                } else {
                    if ( ! Operator.check( expressionToken )) {
                        System.out.println("Please enter valid token.");
                        throw new InvalidTokenException(expressionToken);
                    }

                    Operator newOperator = Operator.getOperator(expressionToken);

                    if(expressionToken.equals("("))
                    {
                        operatorStack.push(newOperator);
                        continue;
                    } else if (expressionToken.equals(")")) {
                        while(operatorStack.peek().priority() != 0)
                        {
                            Operator operator = operatorStack.pop();
                            Operand operand = operandStack.pop();
                            operandStack.push(operator.execute(operandStack.pop(), operand));
                        }
                        operatorStack.pop();
                        continue;
                    }


                    while (!(operatorStack.isEmpty()) && operatorStack.peek().priority() >= newOperator.priority()) {
                        Operator operator = operatorStack.pop();
                        Operand operand = operandStack.pop();
                        operandStack.push(operator.execute(operandStack.pop(), operand));
                    }

                    operatorStack.push( newOperator );
                }
            }
        }

        while(!(operatorStack.isEmpty()))
        {
            Operator operator = operatorStack.pop();
            Operand operand = operandStack.pop();
            operandStack.push(operator.execute(operandStack.pop(), operand));
        }

        return operandStack.pop().getValue();
    }
}
