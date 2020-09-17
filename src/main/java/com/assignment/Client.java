package com.assignment;

import com.assignment.models.Expression;

import java.util.HashMap;
import java.util.Map;

public class Client {

    private Map<Character,Double> unitPrice = new HashMap<>();
    private Map<Expression,Double> scheme = new HashMap<>();


    public static void main(String[] args) {
        Client client = new Client();
        client.init();
    }

    public void init(){
        unitPrice.put('A',50.0);
        unitPrice.put('B',30.0);
        unitPrice.put('C',20.0);
        unitPrice.put('D',15.0);
    }
}
