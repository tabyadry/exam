package problem3;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class CurrencyChangeService extends Thread {
    private String currentCurrency = "";

    @Override
    public void run() {
        while (true) {
            RestTemplate restTemplate = new RestTemplate();
            String fooResourceUrl
                    = "https://api.exchangeratesapi.io/latest?symbols=RON";
            ResponseEntity<String> response
                    = restTemplate.getForEntity(fooResourceUrl, String.class);
            currentCurrency = response.getBody().split(":")[2].split("}")[0];

            try {
                Thread.sleep(60 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getCurrentCurrency() {
        return currentCurrency;
    }
}
