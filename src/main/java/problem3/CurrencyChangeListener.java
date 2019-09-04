package problem3;

public class CurrencyChangeListener {

    public void listenToAlerts() throws InterruptedException {
        Thread engineThread = new CurrencyRatesAlertingEngine();
        engineThread.start();
        while (true) {
            Thread.sleep(61 * 1000);
            if (((CurrencyRatesAlertingEngine) engineThread).isChanged()) {
                System.out.println("Things to do with the currency " + ((CurrencyRatesAlertingEngine) engineThread).getCurrency());
                ((CurrencyRatesAlertingEngine) engineThread).setChanged(false);
            }
        }
    }
}
