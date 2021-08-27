package be.bitbox.microserviceskata.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static be.bitbox.microserviceskata.config.Config.PROFIEL_CONTEXT_URL;


public class ProfielCommand {
    private final RestTemplate restTemplate;

    public ProfielCommand() {
        this.restTemplate = new RestTemplate();
    }

    public Feedback run(String message) {
        var addProfielHistory = new AddProfielHistory(message);

        ResponseEntity<Feedback> response = restTemplate.postForEntity(PROFIEL_CONTEXT_URL, addProfielHistory, Feedback.class);
        return response.getBody();
    }

    public static class AddProfielHistory {
        private final String newLog;

        public AddProfielHistory(String newLog) {
            this.newLog = newLog;
        }

        public String getNewLog() {
            return newLog;
        }
    }

    public static class Feedback {
        private String feedback;

        public String getFeedback() {
            return feedback;
        }

        public void setFeedback(String feedback) {
            this.feedback = feedback;
        }
    }
}
