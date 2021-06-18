import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FrameView {

    JFrame jFrame;
    JTabbedPane tabbedPane;
    JPanel degerler;
    JPanel degisim;
    JPanel grafik;
    JTextArea jTextArea;
    JTextArea changeTextArea;
    JScrollPane scrolll;
    JScrollPane scrollChangeTextArea;
    ArrayList<Pencere> screen = new ArrayList<>();

    ArrayList<Pencere> createView(){

        jFrame = new JFrame("Piyasa");
        tabbedPane = new JTabbedPane();
        degerler = new JPanel();
        degisim = new JPanel();
        grafik = new JPanel();

        jTextArea = new JTextArea(39,60);
        jTextArea.setEditable(false);

        changeTextArea = new JTextArea(39,30);
        changeTextArea.setEditable(false);

        scrolll = new JScrollPane(jTextArea);
        scrollChangeTextArea = new JScrollPane(changeTextArea);
        degerler.add(scrolll);
        degisim.add(scrollChangeTextArea);
        tabbedPane.add(degerler,"Değerler");
        tabbedPane.add(degisim,"Değişim");
        tabbedPane.add(grafik,"Grafik");

        jFrame.setContentPane(tabbedPane);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setBounds(10, 10, 700, 700);
        jFrame.setResizable(false);


        drawGraphic(grafik,100);
        screen.add(new Pencere(jTextArea,changeTextArea,grafik));
        return screen;
    }

    public static void drawGraphic(JPanel grafik,double value){
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.setValue(value,"5 dakika içindeki değer: ","BIST 100");
        JFreeChart jFreeChart = ChartFactory.createAreaChart("Grafik","5 dakikada güncellenen veri.","Değerler",defaultCategoryDataset,
                PlotOrientation.VERTICAL,false,true,false);
        CategoryPlot categoryPlot  = jFreeChart.getCategoryPlot();
        categoryPlot.setRangeGridlinePaint(Color.ORANGE);
        ChartPanel barPanel  = new ChartPanel(jFreeChart);
        grafik.removeAll();
        grafik.add(barPanel,BorderLayout.CENTER);
        grafik.validate();
    }
}
