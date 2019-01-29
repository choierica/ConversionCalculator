package observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<ConversionObserver> observers = new ArrayList<>();

    public void addObserver(ConversionObserver conversionObserver){
        if(!observers.contains(conversionObserver)){
            observers.add(conversionObserver);
        }
    }


    public void notifyObservers(){
        for (ConversionObserver observer : observers){
            observer.update(observer);
        }
    }
}


