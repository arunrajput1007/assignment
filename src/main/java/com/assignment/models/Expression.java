package com.assignment.models;

public abstract class Expression {
    public Expression add(SKUnit other){
        return new And(this,other);
    }
}
