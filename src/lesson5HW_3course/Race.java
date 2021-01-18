package lesson5HW_3course;

import java.util.ArrayList;
import java.util.Arrays;

public class Race {
    Boolean winner = false;
    private ArrayList<Stage> stages;
    public ArrayList<Stage> getStages() { return stages; }
    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
}

