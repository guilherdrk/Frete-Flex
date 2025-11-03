package com.guilherdrk.freteflex.domain;

import org.springframework.stereotype.Component;

@Component
public class ExpressShippingCalculator implements ShippingCalculator{
    @Override
    public Double calculate(double distance, double weight) {
        return (weight * 1.5)  + (distance * 0.75);
    }
}
