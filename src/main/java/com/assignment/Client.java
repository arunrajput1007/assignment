package com.assignment;

import com.assignment.models.Expression;
import com.assignment.models.SKUnit;

import java.util.HashMap;
import java.util.Map;

public class Client {

    private final Map<Character,Double> unitPrice = new HashMap<>();
    private final Map<Expression,Double> scheme = new HashMap<>();


    public static void main(String[] args) {
        Client client = new Client();
        client.init();
    }

    public void init(){
        unitPrice.put('A',50.0);
        unitPrice.put('B',30.0);
        unitPrice.put('C',20.0);
        unitPrice.put('D',15.0);

        scheme.put(new SKUnit(3,'A'),130.0);
        scheme.put(new SKUnit(2,'B'),45.0);
        scheme.put(new SKUnit(1,'C').add(new SKUnit(1,'D')),30.0);
    }
}
