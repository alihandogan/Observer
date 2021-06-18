import java.util.ArrayList;
import java.util.List;

public class Stock implements Subject {

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {

    }

    @Override
    public void notifyUpdate(ArrayList<String>message) {

        for(Observer o: observers) {
            o.update(message);
        }
    }
}
