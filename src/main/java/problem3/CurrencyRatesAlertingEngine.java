package problem3;

public class CurrencyRatesAlertingEngine extends Thread {

    private String currency = "";
    private boolean isChanged = false;
    Thread thread;

    public CurrencyRatesAlertingEngine() {
        thread = new CurrencyChangeService();
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            String currentCurrency = ((CurrencyChangeService) thread).getCurrentCurrency();
            try {
                Thread.sleep(60 * 1000);
                if (!currency.equalsIgnoreCase(currentCurrency)) {
                    currency = currentCurrency;
                    System.out.println("The currency changed. New currency: " + currentCurrency);
                    isChanged = true;
                } else {
                    System.out.println("the currency didn't change");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isChanged() {
        return isChanged;
    }

    public void setChanged(boolean changed) {
        isChanged = changed;
    }

    public String getCurrency() {
        return currency;
    }
}
