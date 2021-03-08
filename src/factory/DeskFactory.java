package factory;

import officeFurnitures.Chair;
import officeFurnitures.Color;
import officeFurnitures.Desk;

public class DeskFactory implements Factory {

    public DeskFactory() {}

    @Override
    public Desk[] createFurniture() {

        Desk[] order = new Desk[Desk.DeskModels.values().length];
        int index = 0;
        for (Desk.DeskModels model : Desk.DeskModels.values()) {
            for (Color color : Color.values()) {
                order[index++] = new Desk(model, color);
            }
        }
        return order;
    }
}
