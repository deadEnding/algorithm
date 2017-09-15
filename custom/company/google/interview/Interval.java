package custom.company.google.interview;

/**
 */



public class Interval {
    int start, end;

    public static final String EMPTY = "[)";

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public boolean isEmpty() {
        return end <= start;
    }

    public boolean isOverlap(Interval interval) {
        if (isEmpty() || interval.isEmpty()) {
            return false;
        }

        return (start <= interval.start && interval.start < end) ||
                (interval.start <= start && start < interval.end);
    }

    public boolean contains(Interval interval) {
        return start <= interval.start && interval.end <= end;
    }

    public Interval intersection(Interval interval) {
        return new Interval(Math.max(start, interval.start), Math.min(end, interval.end));
    }

    public String difference(Interval interval) {
        if (!isOverlap(interval)) {
            return this.toString();
        }

        if (interval.contains(this)) {
            return EMPTY;
        }

        if (contains(interval)) {
            if (interval.start == start) {
                return (new Interval(interval.end, end)).toString();
            }
            return (new Interval(start, interval.start)).toString() + (new Interval(interval.end, end)).toString();
        }

        if (start <= interval.start) {
            return new Interval(start, interval.start).toString();
        }

        return new Interval(interval.end, end).toString();
    }

    @Override
    public String toString() {
        return String.format("[%d,%d)", start, end);
    }

    public static void main(String[] args) {
        Interval i1 = new Interval(1, 5);
        Interval i2 = new Interval(3, 8);
        System.out.println(i1.isOverlap(i2));
        System.out.println(i1.difference(i2));
    }
}
