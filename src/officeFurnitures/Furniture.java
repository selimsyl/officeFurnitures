package officeFurnitures;


/**
 * Abstract main product class, all products share
 */
public abstract class Furniture {
    /**
     * @return Get furniture model
     */
    public abstract Model getModel();
    public String getType() {
        return getModel().getValue();
    }
}

/**
 * A specific furniture type Chair
 */
class Chair extends Furniture {

    /**
     * @param model Chair Model Type
     * @param color Chair Color
     */
    Chair(Models.ChairModels model, String color) {
        super();
        this.color = color;
        this.model = model;
    }

    @Override
    public Models.ChairModels getModel() {
        return model;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Chair)) {
            return false;
        }

        Chair rhs = (Chair) obj;

        return model.equals(rhs.model)
                && color.equals(rhs.color);
    }

    /**
     * Every furniture has a specific model
     */
    final Models.ChairModels model;

    private String color;
}

/**
 * A specific furniture type Table
 */
class Table extends Furniture {
    /**
     * @param model Chair Model Type
     */
    public Table(Models.TableModels model, String color) {
        super();
        this.color = color;
        this.model = model;
    }

    @Override
    public Models.TableModels getModel() {
        return model;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Table)) {
            return false;
        }

        Table rhs = (Table) obj;

        return model.equals(rhs.model)
                && color.equals(rhs.color);
    }

    final Models.TableModels model;
    private String color;
}

/**
 * A specific furniture type Cabinet
 */
class Cabinet extends Furniture {

    /**
     * @param model Chair Model Type
     */
    public Cabinet(Models.CabinetModels model) {
        super();
        this.model = model;
    }

    public Models.CabinetModels getModel() {
        return model;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Cabinet)) {
            return false;
        }

        Cabinet rhs = (Cabinet) obj;

        return model.equals(rhs.model);
    }

    final Models.CabinetModels model;
}

/**
 * A specific furniture type Desk
 */
class Desk extends Furniture {

    /**
     * @param model Chair Model Type
     * @param color Chair Color
     */
    public Desk(Models.DeskModels model, String color) {
        super();
        this.model = model;
        this.color = color;
    }

    public Models.DeskModels getModel() {
        return (Models.DeskModels) model;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Desk)) {
            return false;
        }

        Desk rhs = (Desk) obj;

        return model.equals(rhs.model)
                && color.equals(rhs.color);
    }

    final Models.DeskModels model;
    private String color;
}

/**
 * A specific furniture type Desk
 */
class BookCase extends Furniture {
    /**
     * @param model Chair Model Type
     */
    public BookCase(Models.BookCaseModels model) {
        super();
        this.model = model;
    }

    public Models.BookCaseModels getModel() {
        return (Models.BookCaseModels) model;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof BookCase)) {
            return false;
        }

        BookCase rhs = (BookCase) obj;

        return model.equals(rhs.model);
    }

    final Models.BookCaseModels model;
}

