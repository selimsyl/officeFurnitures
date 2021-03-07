package officeFurnitures;

/**
 * Furniture Models shares
 */
interface Model {
    public String getValue();
}

public class Models {
    private Models() {}

    public enum ChairModels implements Model {
        CHAIR1("CHAIR1"),CHAIR2("CHAIR2"),CHAIR3("CHAIR3"),
        CHAIR4("CHAIR4"),CHAIR5("CHAIR5"),CHAIR6("CHAIR6"),CHAIR7("CHAIR7");

        private final String value;
        ChairModels(String value) {
            this.value = value;
        }

        @Override
        public String getValue() {
            return value;
        }
    }

    public enum TableModels implements Model {
        TABLE1("TABLE1"),TABLE2("TABLE2"),TABLE3("TABLE3"),TABLE4("TABLE4"),TABLE5("TABLE5"),
        TABLE6("TABLE6"),TABLE7("TABLE7"),TABLE8("TABLE8"),TABLE9("TABLE9"),TABLE10("TABLE10");

        private final String value;
        TableModels(String value) {
            this.value = value;
        }

        @Override
        public String getValue() {
            return value;
        }
    }

    public enum CabinetModels implements Model {
        CABINET1("CABINET1"),CABINET2("CABINET2"),CABINET3("CABINET3"),CABINET4("CABINET4"),
        CABINET5("CABINET5"),CABINET6("CABINET6"),CABINET7("CABINET7"),CABINET8("CABINET8"),
        CABINET12("CABINET9"),CABINET9("CABINET10"),CABINET10("CABINET11"),CABINET11("CABINET12");

        private final String value;
        CabinetModels(String value) {
            this.value = value;
        }

        @Override
        public String getValue() {
            return value;
        }
    }

    public enum DeskModels implements Model {
        DESK1("DESK1"),DESK2("DESK2"),DESK3("DESK3"),DESK4("DESK4"),DESK5("DESK5");

        private final String value;
        DeskModels(String value) {
            this.value = value;
        }

        @Override
        public String getValue() {
            return value;
        }
    }

    public enum BookCaseModels implements Model {
        BOOKCASE1("BOOKCASE1"),BOOKCASE2("BOOKCASE2"),BOOKCASE3("BOOKCASE3"),BOOKCASE4("BOOKCASE4"),
        BOOKCASE5("BOOKCASE5"),BOOKCASE6("BOOKCASE6"),BOOKCASE7("BOOKCASE7"),BOOKCASE8("BOOKCASE8"),
        BOOKCASE12("BOOKCASE9"),BOOKCASE9("BOOKCASE10"),BOOKCASE10("BOOKCASE11"),BOOKCASE11("BOOKCASE12");

        private final String value;
        BookCaseModels(String value) {
            this.value = value;
        }

        @Override
        public String getValue() {
            return value;
        }
    }
}
