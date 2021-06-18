import java.util.ArrayList;

public class Deger implements Observer {

    Pencere jTextArea;

    public Deger(Pencere jTextArea) {
        this.jTextArea = jTextArea;
    }

    @Override
    public void update(ArrayList<String> message) {
        jTextArea.values.setText(" ");
        jTextArea.values.setText(jTextArea.values.getText() + " : " +  message.get(3));
    }

}
