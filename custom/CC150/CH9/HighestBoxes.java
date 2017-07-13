package custom.CC150.CH9;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 1:55 PM 12/30/16
 * @version: 1.0
 * @description:
 */

class Box {
    int height, width, depth;

    public Box(int h, int w, int d) {
        height = h;
        width = w;
        depth = d;
    }

    public boolean canBeAbove(Box box) {
        return box == null ||
                (box.height < height && box.width < width && box.depth < depth);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object instanceof Box) {
            Box box = (Box) object;
            return box.height == height && box.width == width && box.depth == depth;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash = hash * 31 + height;
        hash = hash * 31 + width;
        hash = hash * 31 + depth;
        return hash;
    }

    @Override
    public String toString() {
        return String.format("%s[height=%d,width=%d,depth=%d]",
                getClass().getName(), height, width, depth);
    }
}


public class HighestBoxes {

    private int getHeight(LinkedList<Box> tower) {
        int height = 0;
        for (Box box : tower) {
            height += box.height;
        }
        return height;
    }

    public LinkedList<Box> getHighest(Box[] boxes, Box bottom, HashMap<Box,
            LinkedList<Box>> cache) {
        if (bottom != null && cache.containsKey(bottom)) {
            return cache.get(bottom);
        }

        int maxHeigth = 0;
        LinkedList<Box> highestTower = null;
        for (Box box : boxes) {
            if (box.canBeAbove(bottom)) {
                LinkedList<Box> tower = getHighest(boxes, box, cache);
                int height;
                if ((height = getHeight(tower)) > maxHeigth) {
                    maxHeigth = height;
                    highestTower = tower;
                }
            }
        }

        // 没有可以放到bottom箱子上面的箱子
        if (highestTower == null) {
            highestTower = new LinkedList<>();
        }

        // 对应解空间的根节点
        if (bottom != null) {
            highestTower.add(0, bottom);
        }

        cache.put(bottom, highestTower);
        return highestTower;
    }
}