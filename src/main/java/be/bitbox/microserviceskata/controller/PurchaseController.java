package be.bitbox.microserviceskata.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.bitbox.microserviceskata.client.CurrencyCommand;

@RestController
public class PurchaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PurchaseController.class);

    @RequestMapping
    public String purchaseStock() {
        var currency = new CurrencyCommand().run();

        var result = String.format("Bought %f at %f so total %f", currency.getDollar(), 4.33, 3444);

        return result;
    }
}
