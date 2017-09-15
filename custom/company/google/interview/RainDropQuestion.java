package custom.company.google.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 * https://instant.1point3acres.com/thread/153699
 */
public class RainDropQuestion {

    private Random random = new Random();
    private final double WIDTH = 0.1;

    class RainDrop {
        double start, end;

        public RainDrop(double s, double e) {
            this.start = s;
            this.end = e;
        }

        @Override
        public String toString() {
            return start + "," + end;
        }
    }

    public static final double DELTA = 1e-6;

    public static boolean equal(double a, double b) {
        return Math.abs(a - b) < DELTA;
    }

    public RainDrop nextRainDrop() {
        double r = random.nextDouble() * 3;
        return new RainDrop(r - 1, r + WIDTH - 1);
    }

    class Interval {
        double start, end;

        public Interval(double s, double e) {
            this.start = s;
            this.end = e;
        }
    }

    private ArrayList<Interval> intervals = new ArrayList<>();

    private boolean overlap(Interval a, Interval b) {
        return b.start < a.end || equal(b.start, a.end);
    }

    public boolean isWet(double start, double end) {
        while (true) {
            RainDrop rainDrop = nextRainDrop();
            System.out.println(rainDrop);
            if (rainDrop.end < start || end < rainDrop.start) {
                continue;
            }

            Interval itv = new Interval(rainDrop.start, rainDrop.end);
            int ix = Collections.binarySearch(intervals, itv, new Comparator<Interval>() {
                @Override
                public int compare(Interval o1, Interval o2) {
                    if (o1.start < o2.start) {
                        return -1;
                    } else if (equal(o1.start, o2.start)) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            });

            if (ix < 0) {
                ix = - (ix + 1);
                Interval prev = ix > 0 ? intervals.get(ix - 1) : null;
                Interval next = ix < intervals.size() ? intervals.get(ix) : null;
                if (prev != null && next != null && overlap(prev, itv) && overlap(itv, next)) {
                    prev.end = next.end;
                } else if (prev != null && overlap(prev, itv)) {
                    prev.end = Math.max(prev.end, itv.end);
                } else if (next != null && overlap(itv, next)) {
                    next.start = itv.start;
                } else {
                    intervals.add(ix, itv);
                }
            }

            Interval first = intervals.get(0);
            if ((first.start < start || equal(first.start, start)) && (end < first.end || equal(end, first.end))) {
                System.out.println(intervals);
                return true;
            }
        }
    }

    class Bucket {
        double start, end;
        public Bucket(double s, double e) {
            start = s;
            end = e;
        }

        public boolean isCovered() {
            return end < start;
        }
    }

    private int getIndex(double d) {
        if (d < 0) {
            return (int) (d / WIDTH) - 1;
        } else {
            return (int) (d / WIDTH);
        }
    }

    public boolean isRangeWet() {
        Bucket[] buckets = new Bucket[(int)(1.0 / WIDTH)];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket(i * WIDTH, i * WIDTH + WIDTH);
        }


        int count = buckets.length;

        int ix = 0;
        while (ix++ < 1000) {
            RainDrop rainDrop = nextRainDrop();
            if (rainDrop.end < 0 || rainDrop.start > 1) {
                continue;
            }

            for (int i = 0; i < buckets.length; i++) {
                if (!buckets[i].isCovered()) {
                    System.out.print(i + ", ");
                }
            }
            System.out.println();

//            System.out.println(rainDrop + " , " + count + ","+ buckets.length);
            int six = getIndex(rainDrop.start);
            if (six >= 0 && six < buckets.length && !buckets[six].isCovered()) {
                buckets[six].end = Math.min(buckets[six].end, rainDrop.start);
                if (buckets[six].isCovered()) {
                    count--;
                }
            }

            int eix = getIndex(rainDrop.end);
            if (eix >= 0 && eix < buckets.length && !buckets[eix].isCovered()) {
                buckets[eix].end = Math.min(buckets[eix].end, rainDrop.start);
                if (buckets[eix].isCovered()) {
                    count--;
                }
            }

            if (count == 0) {
                return true;
            }
        }
        System.out.println(buckets[0].start + "," + buckets[0].end);
        return false;
    }

    public static void main(String[] args) {
        RainDropQuestion question = new RainDropQuestion();
        System.out.println(question.isWet(0.1, 0.2));
        System.out.println(question.isRangeWet());
    }
}
