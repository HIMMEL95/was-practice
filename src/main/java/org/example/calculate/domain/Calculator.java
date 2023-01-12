package org.example.calculate.domain;

import org.example.calculate.tobe.AdditionOperator;
import org.example.calculate.tobe.ArithmeticOperator;
import org.example.calculate.tobe.DivisionOperator;
import org.example.calculate.tobe.SubtractionOperator;

import java.util.List;

public class Calculator {
    private static final List<ArithmeticOperator> arithmeticOperators = List.of(new AdditionOperator(), new DivisionOperator(), new SubtractionOperator());
    public static int calculate(PositiveNumber positiveOperand1, String operator, PositiveNumber positiveOperand2) {

        try {
            Thread.sleep(5_000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return arithmeticOperators.stream()
                .filter(arithmeticOperator -> arithmeticOperator.supports(operator))
                .map(arithmeticOperator -> arithmeticOperator.calculate(positiveOperand1, positiveOperand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
}
