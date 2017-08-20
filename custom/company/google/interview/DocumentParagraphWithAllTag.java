package custom.company.google.interview;


import java.util.*;

/**
 * http://blog.csdn.net/lightty/article/details/12616677
 */
public class DocumentParagraphWithAllTag {

    class Point {
        int line;
        boolean isStart;
        String tag;

        public Point(int line, boolean isStart, String tag) {
            this.line = line;
            this.isStart = isStart;
            this.tag = tag;
        }
    }

    public List<int[]> solve(HashMap<String, List<int[]>> taggedParagraph) {
        final int tagsNum = taggedParagraph.size();
        ArrayList<Point> points = new ArrayList<>();
        for (String tag : taggedParagraph.keySet()) {
            for (int[] p : taggedParagraph.get(tag)) {
                points.add(new Point(p[0], true, tag));
                points.add(new Point(p[1], false, tag));
            }
        }

        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.line != o2.line) {
                    return o1.line - o2.line;
                }

                if (o1.isStart == o2.isStart) {
                    return 0;
                }

                return o1.isStart ? -1 : 1;
            }
        });

        int count = 0;
        List<int[]> result = new ArrayList<>();
        for (int i = 0, start = 0; i < points.size(); i++) {
            Point p = points.get(i);
            if (p.isStart) {
                if (++count == tagsNum) {
                    start = p.line;
                }
            } else {
                if (count-- == tagsNum) {
                    result.add(new int[] {start, p.line});
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] tags = {"tag1", "tag2"};
        int[][][] lines = {{{70, 80}, {90, 120}}, {{100, 160}}};

        HashMap<String, List<int[]>> tagged = new HashMap<>();
        for (int i = 0; i < tags.length; i++) {
            List<int[]> ps = new ArrayList<>();
            for (int[] p : lines[i]) {
                ps.add(p);
            }
            tagged.put(tags[i], ps);
        }

        List<int[]> result = new DocumentParagraphWithAllTag().solve(tagged);
        for (int[] p : result) {
            System.out.println(p[0] + " " + p[1]);
        }
    }
}
