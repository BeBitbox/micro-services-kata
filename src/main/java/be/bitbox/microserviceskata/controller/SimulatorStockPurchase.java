package be.bitbox.microserviceskata.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.bitbox.microserviceskata.client.CurrencyCommand;
import be.bitbox.microserviceskata.client.CurrencyCommand.Currency;
import be.bitbox.microserviceskata.client.ProfielCommand;
import be.bitbox.microserviceskata.client.StockCommand;
import be.bitbox.microserviceskata.client.StockCommand.StockPrice;

@RestController
public class SimulatorStockPurchase {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimulatorStockPurchase.class);
    public static final double TAXES = 1.05;

    @RequestMapping
    public String purchaseStock() {
        LOGGER.info("Start simulation for Adam and stock 'Apple'");
        var currency = new CurrencyCommand().run();
        var stockPrice = new StockCommand().run();

        var simulatedPrice = calculatePrice(currency, stockPrice);

        var result = String.format("Adam wants to by stock 'Apple' for %f", simulatedPrice);
        new ProfielCommand().run(result);
        LOGGER.info("Result: {}", result);
        return result;
    }

    private double calculatePrice(Currency currency, StockPrice stockPrice) {
        if ("dollar".equals(stockPrice.getCurrency())) {
            return stockPrice.getStock() * currency.getDollar() * TAXES;
        }
        throw new IllegalArgumentException("Not supported");
    }
}
