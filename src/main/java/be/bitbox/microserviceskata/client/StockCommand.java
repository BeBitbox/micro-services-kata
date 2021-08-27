package be.bitbox.microserviceskata.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static be.bitbox.microserviceskata.config.Config.STOCK_CONTEXT_URL;


public class StockCommand {
    private final RestTemplate restTemplate;

    public StockCommand() {
        this.restTemplate = new RestTemplate();
    }

    public StockPrice run() {
        ResponseEntity<StockPrice> response = restTemplate.getForEntity(STOCK_CONTEXT_URL, StockPrice.class);
        return response.getBody();
    }

    public static class StockPrice {
        private double stock;
        private String currency;

        public double getStock() {
            return stock;
        }

        public void setStock(double stock) {
            this.stock = stock;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }
    }
}
