package com.guilherdrk.freteflex.service;

import com.guilherdrk.freteflex.domain.ExpressShippingCalculator;
import com.guilherdrk.freteflex.domain.ShippingCalculator;
import com.guilherdrk.freteflex.domain.StandardShippingCalculator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    private final ShippingCalculator standardCalculator;
    private final ShippingCalculator expressCalculator;

    public ShippingService(@Qualifier("standardShippingCalculator") ShippingCalculator standardCalculator,
                           @Qualifier("expressShippingCalculator") ShippingCalculator expressCalculator) {
        this.standardCalculator = standardCalculator;
        this.expressCalculator = expressCalculator;
    }


    public Double calculate(String shippingType, Double distance, Double weight){

        if(shippingType.equalsIgnoreCase("standard")){
            return standardCalculator.calculate(distance, weight);
        }

        if (shippingType.equalsIgnoreCase("express")){
            return expressCalculator.calculate(distance, weight);
        }
        return null;
    }

}
