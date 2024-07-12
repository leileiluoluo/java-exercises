import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class InstrumentHashSet<E> extends HashSet<E> {

    private int addCount = 0;

    public InstrumentHashSet() {
        super();
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        InstrumentHashSet<String> set = new InstrumentHashSet<>();
        set.addAll(List.of("a", "b", "c"));

        System.out.println(set.getAddCount()); // 6
    }

}
