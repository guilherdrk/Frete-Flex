package com.guilherdrk.freteflex.controller;


import com.guilherdrk.freteflex.dto.ShippingResponse;
import com.guilherdrk.freteflex.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShippingController {


    private final ShippingService shippingService;

    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @GetMapping(path = "/shipping/calculate")
    public ResponseEntity<ShippingResponse> calculate(@RequestParam("type") String shippingType,
                                                      @RequestParam("distance") Double distance,
                                                      @RequestParam("weight") Double weight) {

        double custo = shippingService.calculate(shippingType, distance, weight);

        return ResponseEntity.ok(new ShippingResponse(custo));
    }
}
