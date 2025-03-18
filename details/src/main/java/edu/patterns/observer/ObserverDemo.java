package edu.patterns.observer;

public class ObserverDemo {

    public static void main(String... args) {

        CarTemperature temperature = new CarTemperature();

        PanelTemperatureIndicator listener = new PanelTemperatureIndicator();
        PanelTemperatureIndicator listener2 = new PanelTemperatureIndicator();
        TemperatureAlarm alarm = new TemperatureAlarm();

        System.out.println("start");
        System.out.println("l1:" + listener);
        System.out.println("l2:" + listener2);


        temperature.addObserver(listener);
        temperature.addObserver(listener2);
        temperature.addObserver(alarm);

        temperature.increment();
        temperature.increment();
        System.out.println("incremented twice");

        System.out.println("l1:" + listener);
        System.out.println("l2:" + listener2);

        temperature.deleteObserver(listener2);
        System.out.println("listener removed ");

        temperature.increment();
        System.out.println("incremented");
        System.out.println("l1:" + listener);
        System.out.println("l2:" + listener2);

        for (int i=0; i<110; i++){
            temperature.increment();
        }
    }
}
