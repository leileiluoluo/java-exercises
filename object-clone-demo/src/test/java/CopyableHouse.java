import org.springframework.beans.BeanUtils;

public class CopyableHouse {
    private String name;
    private Integer size;
    private Refrigerator refrigerator;

    public CopyableHouse() {
    }

    public CopyableHouse(String name, Integer size, Refrigerator refrigerator) {
        this.name = name;
        this.size = size;
        this.refrigerator = refrigerator;
    }

    public static class Refrigerator {
        private String name;

        public Refrigerator() {
        }

        public Refrigerator(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Refrigerator refrigerator = new Refrigerator("Larry's Refrigerator");
        CopyableHouse house1 = new CopyableHouse("Larry's House", 100, refrigerator);

        CopyableHouse house2 = new CopyableHouse();
        house2.refrigerator = new Refrigerator();
        BeanUtils.copyProperties(house1, house2);

        house2.name = "Jacky's House";
        house2.size = 99;
        house2.refrigerator.name = "Jacky's Refrigerator";

        System.out.println(house1); // CopyableHouse@75828a0f
        System.out.println(house1.name); // Larry's House
        System.out.println(house1.size); // 100
        System.out.println(house1.refrigerator); // CopyableHouse$Refrigerator@3abfe836
        System.out.println(house1.refrigerator.name); // Larry's Refrigerator

        System.out.println(house2); // CopyableHouse@2ff5659e
        System.out.println(house2.name); // Jacky's House
        System.out.println(house2.size); // 99
        System.out.println(house2.refrigerator); // CopyableHouse$Refrigerator@77afea7d
        System.out.println(house2.refrigerator.name); // Jacky's Refrigerator
    }
}
