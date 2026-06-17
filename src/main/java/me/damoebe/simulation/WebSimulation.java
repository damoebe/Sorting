package me.damoebe.simulation;

import com.google.gson.Gson;
import me.damoebe.Main;
import me.damoebe.SortData;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.function.Function;

public class WebSimulation {

    private static final String dataPath = "C:\\Users\\Schueler\\IdeaProjects\\Sorting\\src\\main\\java\\me\\damoebe\\simulation\\site\\data.js";

    public static void start(Function<Double[], SortData> function, int dataSize){
        clearData();
        try {
            new File(dataPath).createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Gson gson = new Gson();
        try {
            FileWriter writer = new FileWriter(dataPath);
            writer.write("json = ");
            writer.write(gson.toJson(function.apply(Main.getRandomArray(dataSize))));
            writer.close();
            Desktop.getDesktop().browse(new File(dataPath.replace("data.js", "index.html")).toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    static void clearData(){
        File file = new File(dataPath);
        file.delete();
    }
}
