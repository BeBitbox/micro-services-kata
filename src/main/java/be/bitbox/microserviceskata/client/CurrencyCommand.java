package be.bitbox.microserviceskata.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class CurrencyCommand {
    private final RestTemplate restTemplate;

    public CurrencyCommand() {
        this.restTemplate = new RestTemplate();
    }

    public Currency run() {
        ResponseEntity<Currency> response = restTemplate.getForEntity("https://f6um2in4ce.execute-api.eu-west-3.amazonaws.com/default/concurrencyContext", Currency.class);
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
