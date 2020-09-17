package com.assignment;

import com.assignment.models.Expression;
import com.assignment.models.SKUnit;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class SKUPriceCalculatorTest {

    private SKUPriceCalculator calculator;

    @Before
    public void init(){
        Map<Character,Double> unitPrice = new HashMap<>();
        unitPrice.put('A',50.0);
        unitPrice.put('B',30.0);
        unitPrice.put('C',20.0);
        unitPrice.put('D',15.0);

        Map<Expression,Double> scheme = new HashMap<>();
        scheme.put(new SKUnit(3,'A'),130.0);
        scheme.put(new SKUnit(2,'B'),45.0);
        scheme.put(new SKUnit(1,'C').add(new SKUnit(1,'D')),30.0);
        calculator = new SKUPriceCalculator(unitPrice,scheme);
    }

    @Test
    public void simpleHappyScenarioUnitPrice(){
        Expression exp1 = new SKUnit(1,'A')
                .add(new SKUnit(1,'B'))
                .add(new SKUnit(1,'C'));
        assertThat(calculator.calculatePrice(exp1)).isEqualTo(100.0);
    }
}
