package be.bitbox.microserviceskata.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static be.bitbox.microserviceskata.config.Config.CURRENCY_CONTEXT_URL;

public class CurrencyCommand {
    private final RestTemplate restTemplate;

    public CurrencyCommand() {
        this.restTemplate = new RestTemplate();
    }

    public Currency run() {
        ResponseEntity<Currency> response = restTemplate.getForEntity(CURRENCY_CONTEXT_URL, Currency.class);
        return response.getBody();
    }

    public static class Currency {
        private double dollar;
        private double bitcoin;
        private double euro;

        public double getDollar() {
            return dollar;
        }

        public void setDollar(double dollar) {
            this.dollar = dollar;
        }

        public double getBitcoin() {
            return bitcoin;
        }

        public void setBitcoin(double bitcoin) {
            this.bitcoin = bitcoin;
        }

        public double getEuro() {
            return euro;
        }

        public void setEuro(double euro) {
            this.euro = euro;
        }
    }
}
