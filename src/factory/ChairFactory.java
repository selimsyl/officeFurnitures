package factory;

import officeFurnitures.Chair;

public class ChairFactory implements Factory {

    public ChairFactory() {}

    @Override
    public Chair[] createFurniture() {

        Chair[] order = new Chair[Chair.ChairModels.values().length*Chair.Color.values().length];
        int index = 0;
        for (Chair.ChairModels model : Chair.ChairModels.values()) {
            for (Chair.Color color : Chair.Color.values()) {
                order[index++] = new Chair(model, color,10);
            }
        }

        return order;
    }
}
