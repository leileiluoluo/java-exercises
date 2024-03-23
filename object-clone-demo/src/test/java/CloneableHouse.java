public class CloneableHouse implements Cloneable {
    private String name;
    private Integer size;
    private Refrigerator refrigerator;

    public CloneableHouse(String name, Integer size, Refrigerator refrigerator) {
        this.name = name;
        this.size = size;
        this.refrigerator = refrigerator;
    }

    @Override
    public CloneableHouse clone() {
        try {
            CloneableHouse house = (CloneableHouse) super.clone();
            house.refrigerator = house.refrigerator.clone();
            return house;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public static class Refrigerator implements Cloneable {
        private String name;
        private Fruit fruit;

        public Refrigerator(String name, Fruit fruit) {
            this.name = name;
            this.fruit = fruit;
        }

        @Override
        public Refrigerator clone() {
            try {
                Refrigerator refrigerator = (Refrigerator) super.clone();
                refrigerator.fruit = refrigerator.fruit.clone();
                return refrigerator;
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static class Fruit implements Cloneable {
        private String name;

        public Fruit(String name) {
            this.name = name;
        }

        @Override
        public Fruit clone() {
            try {
                return (Fruit) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Refrigerator refrigerator = new Refrigerator("Larry's Refrigerator", new Fruit("Apple"));
        CloneableHouse house1 = new CloneableHouse("Larry's House", 100, refrigerator);

        CloneableHouse house2 = house1.clone();
        house2.name = "Jacky's House";
        house2.size = 99;
        house2.refrigerator.name = "Jacky's Refrigerator";
        house2.refrigerator.fruit.name = "Banana";

        System.out.println(house1); // CloneableHouse@6d311334
        System.out.println(house1.name); // Larry's House
        System.out.println(house1.size); // 100
        System.out.println(house1.refrigerator); // CloneableHouse$Refrigerator@682a0b20
        System.out.println(house1.refrigerator.name); // Larry's Refrigerator
        System.out.println(house1.refrigerator.fruit.name); // Apple

        System.out.println(house2); // CloneableHouse@3d075dc0
        System.out.println(house2.name); // Jacky's House
        System.out.println(house2.size); // 99
        System.out.println(house2.refrigerator); // CloneableHouse$Refrigerator@214c265e
        System.out.println(house2.refrigerator.name); // Jacky's Refrigerator
        System.out.println(house2.refrigerator.fruit.name); // Banana
    }
}
