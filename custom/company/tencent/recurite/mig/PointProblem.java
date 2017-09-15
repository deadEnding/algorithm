package custom.company.tencent.recurite.mig;

import java.util.*;

class Point {
    int x, y;
}

public class PointProblem {

    private int distance(Point p, Point q) {
        int dx = p.x - q.x;
        int dy = p.y - q.y;
        return dx * dx + dy * dy;
    }

    public ArrayList<Point> remove(Point current, ArrayList<Point> points, int n) {
        PriorityQueue<Point> heap = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return distance(current, o1) - distance(current, o2);
            }
        });

        int remian = points.size() - n;
        for (Point p : points) {
            if (heap.size() < remian) {
                heap.offer(p);
            } else {
                if (distance(current, heap.peek()) < distance(current, p)) {
                    heap.poll();
                    heap.offer(p);
                }
            }
        }

        ArrayList<Point> list = new ArrayList<>();
        list.addAll(heap);
        return list;
    }

    private int partition(Point current, ArrayList<Point> points, int s, int e) {
        Point pivot = points.get(s);
        int dist = distance(current, pivot);
        while (s < e) {
            while (s < e && distance(current, points.get(e)) >= dist) {
                e--;
            }
            points.set(s, points.get(e));

            while (s < e && distance(current, points.get(s)) < dist) {
                s++;
            }
            points.set(e, points.get(s));
        }
        points.set(s, pivot);

        return s;
    }

    public int findKth(Point current, ArrayList<Point> points, int s, int e, int kindex) {
        int ix = partition(current, points, s, e);
        if (ix == kindex) {
            return distance(current, points.get(ix));
        } else if (ix < kindex) {
            return findKth(current, points, ix + 1, e, kindex);
        } else {
            return findKth(current, points, s, ix - 1, kindex);
        }
    }

    public void removeFast(Point current, ArrayList<Point> points, int n) {
        n = Math.min(n, points.size());
        int dist = findKth(current, points, 0, points.size() - 1, n - 1);
        Iterator<Point> it = points.iterator();
        while (it.hasNext()) {
            if (distance(current, it.next()) < dist) {
                it.remove();
            }
        }
    }

    public ArrayList<int[]> find(ArrayList<Point> points, int d) {
        ArrayList<int[]> pairs = new ArrayList<>();
        if (points.isEmpty()) {
            return pairs;
        }

        int minx = Integer.MAX_VALUE, miny = Integer.MAX_VALUE;
        int maxx = Integer.MIN_VALUE, maxy = Integer.MIN_VALUE;
        for (Point p : points) {
            minx = Math.min(minx, p.x);
            maxx = Math.max(maxx, p.x);
            miny = Math.min(miny, p.y);
            maxy = Math.max(maxy, p.y);
        }

        int xbuckets = (maxx - minx) / d + 1;
        int ybuckets = (maxy - miny) / d + 1;
        ArrayList<Point>[][] bucketxy = new ArrayList[xbuckets][ybuckets];
        for (int i = 0; i < xbuckets; i++) {
            for (int j = 0; j < ybuckets; j++) {
                bucketxy[i][j] = new ArrayList<>();
            }
        }

        HashMap<Point, Integer> map = new HashMap<>();
        for (int i = 0; i < points.size(); i++) {
            Point p = points.get(i);
            int xb = (p.x - minx) / d;
            int yb = (p.y - miny) / d;
            bucketxy[xb][yb].add(p);
            map.put(p, i);
        }

        for (int i = 0; i < xbuckets; i++) {
            for (int j = 0; j < ybuckets; j++) {
                findInSingleBucket(map, bucketxy[i][j], pairs, d);
                if (i - 1 >= 0 && j - 1 >= 0) {
                    findInPairBuckets(map, bucketxy[i][j], bucketxy[i - 1][j - 1], pairs, d);
                }

                if (i - 1 >= 0) {
                    findInPairBuckets(map, bucketxy[i][j], bucketxy[i - 1][j], pairs, d);
                }

                if (j - 1 >= 0) {
                    findInPairBuckets(map, bucketxy[i][j], bucketxy[i][j - 1], pairs, d);
                }
            }
        }

        return pairs;
    }

    private void findInSingleBucket(HashMap<Point, Integer> map, ArrayList<Point> bucket, ArrayList<int[]> pairs, int d) {
        final int n = bucket.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (distance(bucket.get(i), bucket.get(j)) < d) {
                    pairs.add(new int[] {map.get(bucket.get(i)), map.get(bucket.get(j))});
                }
            }
        }
    }

    private void findInPairBuckets(HashMap<Point, Integer> map, ArrayList<Point> bucket1, ArrayList<Point> bucket2,
                                   ArrayList<int[]> pairs, int d) {
        final int n1 = bucket1.size(), n2 = bucket2.size();
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (distance(bucket1.get(i), bucket2.get(j)) < d) {
                    pairs.add(new int[] {map.get(bucket1.get(i)), map.get(bucket2.get(j))});
                }
            }
        }
    }
}
