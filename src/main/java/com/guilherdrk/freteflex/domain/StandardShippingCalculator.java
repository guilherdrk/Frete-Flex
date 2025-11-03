package com.guilherdrk.freteflex.domain;

import org.springframework.stereotype.Component;

@Component
public class StandardShippingCalculator implements ShippingCalculator{

    @Override
    public Double calculate(double distance, double weight) {
        return (weight * 1.0)  + (distance * 0.5);

    }


}
