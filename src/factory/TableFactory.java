package factory;

import officeFurnitures.Table;

public class TableFactory implements Factory {

    public TableFactory() {}

    @Override
    public Table[] createFurniture() {
        Table[] order = new Table[Table.TableModels.values().length * 4];
        int index = 0;
        for (Table.TableModels model : Table.TableModels.values()) {
            for (Table.Color color : Table.Color.values()) {
                order[index++] = new Table(model, color,10);
            }
        }

        return order;
    }
}
