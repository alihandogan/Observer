import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends TimerTask {

    static Stock stock = new Stock();

    public static void main(String[] args) {


        FrameView frameView = new FrameView();
        ArrayList<Pencere> jTextArea = frameView.createView();

        Deger values = new Deger(jTextArea.get(0));
        Choose change = new Choose(jTextArea.get(0));
        Gorsel graphic = new Gorsel(jTextArea.get(0));


        stock.attach(values);
        stock.attach(change);
        stock.attach(graphic);


        Timer timer = new Timer();
        Main task = new Main();

        timer.schedule(task, 1000, 300000);

    }

    @Override
    public void run() {

        String uri="http://realtime.paragaranti.com/asp/xml/icpiyasaX.xml";
        try {
            ArrayList<String> def = new ArrayList<>();

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                boolean control;
                String doc = "";

                public void startDocument() {
                }

                public void startElement(String uri
                        , String localName, String qname, Attributes attributes) {

                        if (qname.equalsIgnoreCase("SYMBOL")) {
                            control = true;
                            doc += qname;
                        }
                        if (qname.equalsIgnoreCase("DESC")) {
                            control = true;
                            doc += qname;
                        }
                        if (qname.equalsIgnoreCase("LAST")) {
                            control = true;
                            doc += qname;
                        }
                    if (qname.equalsIgnoreCase("PERNC")) {
                        control = true;
                        doc += qname;
                    }
                }



                public void characters(char[] ch, int start, int finish){
                 //   String string = new String(ch,start,finish);

                    if(control) {
                            doc += ": " + new String(ch,
                                    start,
                                    finish)+"\n";
                            control = false;
                            def.add(doc);

                        }

                    }

                public void endDocument(){
                    stock.notifyUpdate(def);
                }
            };
            parser.parse(uri,handler);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
