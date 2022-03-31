package csci2020u.lab07;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class datacontrol {
    @FXML
    public PieChart pieChart;

    public void initialize(){
        File stormData = new File(Objects.requireNonNull(datacontrol.class.getResource("weatherwarnings-2015.csv")).getPath());
        try{
            BufferedReader reader = new BufferedReader(new FileReader(stormData));

            String fileData;
            int flood = 0;
            int thunder = 0;
            int specialWet = 0;
            int tornado = 0;

            while ((fileData = reader.readLine()) != null){
                String[] warning = fileData.split(",");
                String type = warning[5];
                if (type == "FLASH FLOOD"){
                    flood++;
                }
                if (type == "SEVERE THUNDERSTORM"){
                    thunder++;
                }
                if (type == "SPECIAL MARINE"){
                    specialWet++;
                }
                if (type == "TORNADO"){
                    tornado++;
                }
            }

            ObservableList<PieChart.Data> chartInfo = FXCollections.observableArrayList(new PieChart.Data("FLASH FLOOD - " + flood, flood), new PieChart.Data("SEVERE THUNDERSTORM - " + thunder, thunder), new PieChart.Data("SPECIAL MARINE - " + specialWet, specialWet), new PieChart.Data("TORNADO - " + tornado, tornado));
            pieChart.setData(chartInfo);

        }catch (IOException Q){
            Q.printStackTrace();
        }
    }
}
