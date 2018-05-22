package t02;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Range implements IRange {
    long lowerBound;
    long upperBound;

    @Override
    public boolean isBefore(IRange otherRange) {
        return upperBound < otherRange.getLowerBound();
    }

    @Override
    public boolean isAfter(IRange otherRange) {
        return lowerBound > otherRange.getUpperBound();
    }
    // 1     4
    //     3     6
    @Override
    public boolean isConcurrent(IRange otherRange) {
        return upperBound >= otherRange.getLowerBound() && lowerBound <= otherRange.getUpperBound() ||
                otherRange.getUpperBound() >= lowerBound && otherRange.getLowerBound() <= upperBound;
    }

    @Override
    public long getLowerBound() {
        return lowerBound;
    }

    @Override
    public long getUpperBound() {
        return upperBound;
    }

    @Override
    public boolean contains(long value) {
        return value <= upperBound && value >= lowerBound;
    }

    @Override
    public List<Long> asList() {
        val list = new ArrayList<Long>();
        for (long i = lowerBound; i <= upperBound; i++) {
            list.add(i);
        }
        return list;
    }

    @Override
    public Iterator<Long> asIterator() throws NoSuchElementException {
        return new Iterator<>() {
            long up = upperBound;

            long cur = lowerBound;

            @Override
            public boolean hasNext() {
                return cur <= up;
            }

            @Override
            public Long next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                return cur++;
            }
        };
    }
}
