package t02;

import java.util.Iterator;
import java.util.List;

public interface IRange {
    boolean isBefore(IRange otherRange);
    boolean isAfter(IRange otherRange);
    boolean isConcurrent(IRange otherRange);
    long getLowerBound();
    long getUpperBound();
    boolean contains(long value);
    List<Long> asList();
    Iterator<Long> asIterator();
}
