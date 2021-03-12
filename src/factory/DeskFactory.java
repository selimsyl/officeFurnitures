package factory;

import officeFurnitures.Chair;
import officeFurnitures.Color;
import officeFurnitures.Desk;

public class DeskFactory implements Factory {

    public DeskFactory() {}

    @Override
    public Desk[] createFurniture() {

        Desk[] order = new Desk[Desk.DeskModels.values().length * 4];
        int index = 0;
        for (Desk.DeskModels model : Desk.DeskModels.values()) {
            for (Desk.Color color : Desk.Color.values()) {
                order[index++] = new Desk(model, color,10);
            }
        }

        return order;
    }
}
