package Branches;

import officeFurnitures.Furniture;

public class Branch {
    Storage chairs;
    Storage desks;
    Storage tables;
    Storage bookcases;
    Storage cabinets;

    private FurnitureInStorage findFurniture(Furniture furniture) {
        if (furniture.getType().startsWith("CHAIR")) {
            if(chairs.findFurniture(furniture) >= 0) {
               return new FurnitureInStorage(chairs,1);
            }
            return null;
        } else if (furniture.getType().startsWith("DESK")) {
            if(desks.findFurniture(furniture) >= 0) {
                return new FurnitureInStorage(chairs,1);
            }
            return null;
        } else if (furniture.getType().startsWith("TABLE")) {
            if(tables.findFurniture(furniture) >= 0) {
                return new FurnitureInStorage(chairs,1);
            }
            return null;
        } else if (furniture.getType().startsWith("BOOKCASE")) {
            if(bookcases.findFurniture(furniture) >= 0) {
                return new FurnitureInStorage(chairs,1);
            }
        } else if (furniture.getType().startsWith("CABINET")) {
            if (cabinets.findFurniture(furniture) >= 0) {
                return new FurnitureInStorage(chairs, 1);
            }
        }
        return null;
    }

    void sellFurniture(Furniture furniture) {

    }

    class FurnitureInStorage {
        FurnitureInStorage(Storage storage,int index) {
            this.storage = storage;
            this.index = index;
        }
        Storage storage;
        int index;
    }
}

class Storage {
    Furniture[] product;
    int size;
    final int capacity;

    public Storage(int capacity) {
        product = new Furniture[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public boolean importFurnitures(Furniture[] furnitures) {
        if (furnitures == null)
            return false;

        if (furnitures.length + size > capacity) {
            System.out.println("Not enough storage capacity");
            return false;
        }

        for (int i = 0; i < size; ++i) {
            product[i] = furnitures[i];
        }
        size += furnitures.length;
        return true;
    }

    public Furniture exportFurniture(int index) {
        assert index < size && index > -1;

        Furniture returnFurniture = product[index];
        Furniture[] temp = new Furniture[capacity];

        for(int i=0;i<size;i++) {
            if (i == index) {
                continue;
            }
            temp[i] = product[i+1];
        }
        product = temp;
        size--;
        return returnFurniture;
    }

    public int findFurniture(Furniture desiredFurniture) {
        for(int i=0; i<size; i++) {
            if (desiredFurniture.equals(product[i])) {
                return i;
            }
        }
        return -1;
    }

//    /**
//     * @param desiredFurniture
//     * @return
//     * If desiredFurniture doesnt found return null
//     */
//    public Furniture getFurniture(Furniture desiredFurniture) {
//        int index = findFurniture(desiredFurniture);
//        if (index >= 0) {
//            return product[index];
//        }
//        return null;
//    }
}
