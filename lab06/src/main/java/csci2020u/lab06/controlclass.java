package csci2020u.lab06;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class controlclass implements Initializable {
    private javafx.scene.control.Label Label;
    @FXML
    private NumberAxis price;
    @FXML
    private CategoryAxis year;
    @FXML
    private BarChart barchart;
    @FXML
    private PieChart piechart;

    //data for charts
    private static double[] avgHousingPricesByYear = {
            247381.0,264171.4,287715.3,294736.1,
            308431.4,322635.9,340253.0,363153.7
    };
    private static double[] avgCommercialPricesByYear = {
            1121585.3,1219479.5,1246354.2,1295364.8,
            1335932.6,1472362.0,1583521.9,1613246.3
    };
    private static String[] ageGroups = {
            "18-25", "26-35", "36-45", "46-55", "56-65", "65+"
    };
    private static int[] purchasesByAgeGroup = {
            648, 1021, 2453, 3173, 1868, 2247
    };
    private static Color[] pieColours = {
            Color.AQUA, Color.GOLD, Color.DARKORANGE,
            Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM
    };

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //bar chart settings
        XYChart.Series seriesHousing = new XYChart.Series();
        XYChart.Series seriesCommercial = new XYChart.Series();
        seriesHousing.setName("Price of Houses");
        seriesCommercial.setName("Price of Commercial");

        //adding data to bar chart
        for(int i = 0; i < avgHousingPricesByYear.length; i++) {
            seriesHousing.getData().add(new XYChart.Data<>("Year " + (i + 2015), avgHousingPricesByYear[i]));
            seriesCommercial.getData().add(new XYChart.Data<>("Year " + (i + 2015), avgCommercialPricesByYear[i]));
        }
        barchart.getData().addAll(seriesHousing, seriesCommercial);

        //adding data to piechart
        PieChart.Data section00 = new PieChart.Data(ageGroups[0],purchasesByAgeGroup[0]);
        PieChart.Data section01 = new PieChart.Data(ageGroups[1],purchasesByAgeGroup[1]);
        PieChart.Data section02 = new PieChart.Data(ageGroups[2],purchasesByAgeGroup[2]);
        PieChart.Data section03 = new PieChart.Data(ageGroups[3],purchasesByAgeGroup[3]);
        PieChart.Data section04 = new PieChart.Data(ageGroups[4],purchasesByAgeGroup[4]);
        PieChart.Data section05 = new PieChart.Data(ageGroups[5],purchasesByAgeGroup[5]);
        piechart.getData().addAll(section00, section01, section02, section03, section04, section05);

    }
}

