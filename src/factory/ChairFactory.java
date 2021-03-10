package factory;

import officeFurnitures.Chair;
import officeFurnitures.Color;

public class ChairFactory implements Factory {

    public ChairFactory() {}

    @Override
    public Chair[] createFurniture() {

        Chair[] order = new Chair[Chair.ChairModels.values().length*Color.values().length];
        int index = 0;
        for (Chair.ChairModels model : Chair.ChairModels.values()) {
            for (Color color : Color.values()) {
                order[index++] = new Chair(model, color,10);
            }
        }
        return order;
    }
}
