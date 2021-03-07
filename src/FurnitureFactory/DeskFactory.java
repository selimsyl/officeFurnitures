package FurnitureFactory;

import officeFurnitures.Chair;
import officeFurnitures.Desk;
import officeFurnitures.Furniture;

public class DeskFactory implements Factory {

    Desk.DeskModels model;
    String Color;
    int count;

    public DeskFactory(Desk.DeskModels model,String Color, int count) {
        this.model = model;
        this.Color = Color;
        this.count = count;
    }
    @Override
    public Desk[] createFurniture() {
        Desk[] order = new  Desk[count];
        for (int i=0; i < count; ++i) {
            order[i] = new Desk(model,Color);
        }
        return order;
    }
}
