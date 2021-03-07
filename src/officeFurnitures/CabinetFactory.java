package officeFurnitures;

public class CabinetFactory implements Factory {

    Models.CabinetModels model;
    int count;
    public CabinetFactory(Models.CabinetModels model, int count) {
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
