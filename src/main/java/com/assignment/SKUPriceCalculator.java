package com.assignment;

import com.assignment.models.And;
import com.assignment.models.Expression;
import com.assignment.models.SKUnit;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class SKUPriceCalculator {

    private Map<Character,Double> unitPrice;
    private Map<Expression,Double> scheme;

    public Double calculatePrice(Expression expression){
        if(expression instanceof SKUnit){

        }else if(expression instanceof And){
            And andExpr = (And)expression;
            return calculatePrice(andExpr.getExp1()) + calculatePrice(andExpr.getExp2());
        }
        return 0.0;
    }
}
