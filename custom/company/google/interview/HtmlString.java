package custom.company.google.interview;

import java.util.ArrayList;

/**
 * 比较两个 Html 树是否相同
 */
public class HtmlString {

    class Node {
        String content;
        ArrayList<Node> children;

        public Node(String content) {
            this.content = content;
            children = new ArrayList<>();
        }
    }

    public boolean isSame(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (!root1.content.equals(root2.content) || root1.children.size() != root2.children.size()) {
            return false;
        }

        for (int i = 0; i < root1.children.size(); i++) {
            if (!isSame(root1.children.get(i), root2.children.get(i))) {
                return false;
            }
        }

        return true;
    }
}
