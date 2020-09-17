package com.assignment;

import com.assignment.models.And;
import com.assignment.models.Expression;
import com.assignment.models.SKUnit;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
import java.util.Optional;

@Data
@AllArgsConstructor
public class SKUPriceCalculator {

    private Map<Character,Double> unitPrice;
    private Map<Expression,Double> scheme;

    public Double calculatePrice(Expression expression){
        if(expression instanceof SKUnit){
            //find in scheme
            //else find in unit price
            final SKUnit skExpr = (SKUnit)expression;
            Optional<Map.Entry<Expression,Double>> schemePrice = scheme.entrySet().stream()
                    .filter(entry -> entry.getKey() instanceof SKUnit)
                    .filter(entry -> ((SKUnit) entry.getKey()).getSku() == skExpr.getSku() &&
                            skExpr.getUnit() >= ((SKUnit) entry.getKey()).getUnit()).findFirst();
            return schemePrice.map(entry -> entry.getValue() +
                    calculatePrice(new SKUnit(skExpr.getUnit() - ((SKUnit) entry.getKey()).getUnit(),((SKUnit) entry.getKey()).getSku())))
                    .orElseGet(() -> unitPrice.get(skExpr.getSku()) * skExpr.getUnit());
        }else if(expression instanceof And){
            And andExpr = (And)expression;
            return calculatePrice(andExpr.getExp1()) + calculatePrice(andExpr.getExp2());
        }
        return 0.0;
    }
}
