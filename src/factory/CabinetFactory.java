package factory;

import officeFurnitures.Cabinet;

public class CabinetFactory implements Factory {

    public CabinetFactory() {}

    @Override
    public Cabinet[] createFurniture() {
        Cabinet[] order = new Cabinet[Cabinet.CabinetModels.values().length];
        int index = 0;
        for (Cabinet.CabinetModels model : Cabinet.CabinetModels.values()) {
                order[index++] = new Cabinet(model,10);
        }

        return order;
    }
}
