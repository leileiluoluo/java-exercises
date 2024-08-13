public class SwitchExpressionsTest {

    private static String getDayTypeUsingJava7SwitchStatement(String day) {
        String type;
        switch (day) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
                type = "Weekday";
                break;
            case "Saturday":
            case "Sunday":
                type = "Weekend";
                break;
            default:
                type = "Unknown";
        }
        return type;
    }

    private static String getDayTypeUsingJava12SwitchExpression(String day) {
        return switch (day) {
            case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> "Weekday";
            case "Saturday", "Sunday" -> "Weekend";
            default -> "Unknown";
        };
    }

    private static String getDayTypeUsingJava12SwitchExpressionWithBlockBodies(String day) {
        return switch (day) {
            case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> {
                System.out.println("This day is Weekday");
                yield "Weekday";
            }
            case "Saturday", "Sunday" -> {
                System.out.println("This day is Weekend");
                yield "Weekend";
            }
            default -> "Unknown";
        };
    }

    public static void main(String[] args) {
        // Java 7 switch 语句使用
        System.out.println(getDayTypeUsingJava7SwitchStatement("Sunday"));

        // Java 12 switch 表达式使用
        System.out.println(getDayTypeUsingJava12SwitchExpression("Sunday"));

        // Java 12 switch 表达式使用（含有块体）
        System.out.println(getDayTypeUsingJava12SwitchExpressionWithBlockBodies("Sunday"));
    }

}
