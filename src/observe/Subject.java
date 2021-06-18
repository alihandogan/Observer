import javax.swing.*;
import java.util.ArrayList;

public interface Subject
{
    void attach(Observer o);
    void detach(Observer o);
    void notifyUpdate(ArrayList<String> message);
}