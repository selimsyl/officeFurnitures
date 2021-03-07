package furnitureFactory;

import officeFurnitures.Table;

public class TableFactory implements Factory {
    Table.TableModels model;
    String Color;
    int count;
    public TableFactory(Table.TableModels model,String Color, int count) {
        this.model = model;
        this.Color = Color;
        this.count = count;
    }
    @Override
    public Table[] createFurniture() {
        Table[] order = new Table[count];
        for (int i=0; i < count; ++i) {
            order[i] = new Table(model,Color);
        }
        return order;
    }
}
