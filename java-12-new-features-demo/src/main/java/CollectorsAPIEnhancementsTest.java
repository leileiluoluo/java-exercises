import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsAPIEnhancementsTest {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // Java 12 之前，分别计算 List<Integer> 中元素的最大值和平均值
        Integer minNumber = numbers.stream()
                .max(Integer::compareTo).get();
        Double averageNumber = numbers.stream()
                .collect(Collectors.averagingInt(Integer::intValue));
        System.out.println("min: " + minNumber + ", avg: " + averageNumber); // min: 6, avg: 3.5

        // Java 12，使用 Collectors.teeing() 同时计算 List<Integer> 中元素的最大值和平均值
        Map<String, Object> result = numbers.stream().collect(
                Collectors.teeing(
                        Collectors.maxBy(Integer::compareTo),
                        Collectors.averagingInt(Integer::intValue),
                        (r1, r2) -> Map.of("min", r1.get(), "avg", r2))
        );
        System.out.println("min: " + result.get("min") + ", avg: " + result.get("avg")); // min: 6, avg: 3.5
    }

}
