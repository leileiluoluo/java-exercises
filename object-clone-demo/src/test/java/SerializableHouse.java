import org.apache.commons.lang3.SerializationUtils;

import java.io.Serial;
import java.io.Serializable;

public class SerializableHouse implements Serializable {
    @Serial
    private static final long serialVersionUID = -3606554850313928707L;

    private String name;
    private Integer size;
    private Refrigerator refrigerator;

    public SerializableHouse(String name, Integer size, Refrigerator refrigerator) {
        this.name = name;
        this.size = size;
        this.refrigerator = refrigerator;
    }

    public static class Refrigerator implements Serializable {
        @Serial
        private static final long serialVersionUID = 7744295794434285806L;

        private String name;

        public Refrigerator(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Refrigerator refrigerator = new Refrigerator("Larry's Refrigerator");
        SerializableHouse house1 = new SerializableHouse("Larry's House", 100, refrigerator);

        SerializableHouse house2 = SerializationUtils.clone(house1);
        house2.name = "Jacky's House";
        house2.size = 99;
        house2.refrigerator.name = "Jacky's Refrigerator";

        System.out.println(house1); // SerializableHouse@5e9f23b4
        System.out.println(house1.name); // Larry's House
        System.out.println(house1.size); // 100
        System.out.println(house1.refrigerator); // SerializableHouse$Refrigerator@7e6cbb7a
        System.out.println(house1.refrigerator.name); // Larry's Refrigerator

        System.out.println(house2); // SerializableHouse@5b37e0d2
        System.out.println(house2.name); // Jacky's House
        System.out.println(house2.size); // 99
        System.out.println(house2.refrigerator); // SerializableHouse$Refrigerator@4459eb14
        System.out.println(house2.refrigerator.name); // Jacky's Refrigerator
    }
}
