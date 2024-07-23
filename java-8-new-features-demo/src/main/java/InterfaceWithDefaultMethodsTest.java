public class InterfaceWithDefaultMethodsTest {

    public interface Animal {
        String greeting();

        default void firstMeet(String someone) {
            System.out.println(greeting() + "，" + someone);
        }

        static void sleep() {
            System.out.println("呼呼呼");
        }
    }

    public static class Cat implements Animal {
        @Override
        public String greeting() {
            return "喵喵喵";
        }
    }

    public static class Dog implements Animal {
        @Override
        public String greeting() {
            return "汪汪汪";
        }
    }

    public static void main(String[] args) {
        Animal cat = new Cat();
        System.out.println(cat.greeting()); // 喵喵喵
        cat.firstMeet("主人"); // 喵喵喵，主人

        Animal dog = new Dog();
        System.out.println(dog.greeting()); // 汪汪汪
        dog.firstMeet("主人"); // 汪汪汪，主人

        Animal.sleep(); // 呼呼呼
    }

}
