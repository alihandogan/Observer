import javax.swing.*;
import java.util.ArrayList;

public class Choose implements Observer {

    Pencere jTextArea;
    String prevValue;
    double prevDouble;

    public Choose(Pencere jTextArea) {
        this.jTextArea = jTextArea;
    }


    @Override
    public void update(ArrayList<String> message) {

        jTextArea.change.setText(" ");
      if(prevDouble != 0.0) {
          if (prevDouble < Double.parseDouble(message.get(3).substring(35, 41))) {
              parse(message.get(3));
              jTextArea.change.setText(jTextArea.change.getText() + " : " + message.get(3) + " Değerlerde artış var.");
          } else if (prevDouble > Double.parseDouble(message.get(3).substring(35, 41))) {
              parse(message.get(3));
              jTextArea.change.setText(jTextArea.change.getText() + " : " + message.get(3) + " Değerlerde düşüş var.");
          } else {
              parse(message.get(3));
              jTextArea.change.setText(jTextArea.change.getText() + " : " + message.get(3) + " Değerlerde değişim yok.");
          }
       }else{
          parse(message.get(3));
          jTextArea.change.setText(jTextArea.change.getText() + " : " + message.get(3));
      }
    }

    public void parse(String ms){
        prevValue = ms.substring(35,41);
        prevDouble = Double.parseDouble(prevValue);
    }
}



