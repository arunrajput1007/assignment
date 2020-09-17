package com.assignment.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class And extends Expression {
    private Expression exp1;
    private Expression exp2;

    public Expression add(SKUnit other){
        return new And(this,other);
    }
}
