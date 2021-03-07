package furnitureFactory;

import officeFurnitures.Cabinet;

public class CabinetFactory implements Factory {

    Cabinet.CabinetModels model;
    int count;
    public CabinetFactory(Cabinet.CabinetModels model, int count) {
        this.model = model;
        this.count = count;
    }
    @Override
    public Cabinet[] createFurniture() {
        Cabinet[] order = new Cabinet[count];
        for (int i=0; i < count; ++i) {
            order[i] = new Cabinet(model);
        }
        return order;
    }
}
