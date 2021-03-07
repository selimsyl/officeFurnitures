package FurnitureFactory;

import officeFurnitures.Chair;

public class ChairFactory implements Factory {
    Chair.ChairModels model;
    String Color;
    int count;
    public ChairFactory(Chair.ChairModels model,String Color, int count) {
        this.model = model;
        this.Color = Color;
        this.count = count;
    }
    @Override
    public Chair[] createFurniture() {
        Chair[] order = new Chair[count];
        for (int i=0; i < count; ++i) {
            order[i] = new Chair(model,Color);
        }
        return order;
    }
}
