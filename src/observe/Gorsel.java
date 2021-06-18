import java.util.ArrayList;

public class Gorsel implements Observer {

    Pencere jTextArea;

    int a;

    public Gorsel(Pencere jTextArea) {
        this.jTextArea = jTextArea;
    }

    @Override
    public void update(ArrayList<String> message) {

        String value = message.get(3).substring(35,41);
        FrameView.drawGraphic(jTextArea.graphic,Double.parseDouble(value));
        System.out.println(value);
    }
}
