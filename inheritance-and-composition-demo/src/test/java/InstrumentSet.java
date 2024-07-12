import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InstrumentSet<E> extends ForwardingSet<E> {

    private int addCount = 0;

    public InstrumentSet(Set<E> set) {
        super(set);
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
        InstrumentSet<String> set = new InstrumentSet<>(new HashSet<>());
        set.addAll(List.of("a", "b", "c"));

        System.out.println(set.getAddCount()); // 3
    }

}
