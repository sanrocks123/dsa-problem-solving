/* (C) 2017 */
package dsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * Source SamplePractice.java created on Jan 22, 2018
 *
 * @author : Sanjeev Saxena
 * @version : 1.0
 * @email : sanrocks123@gmail.com
 */
public class BinaryTreeTest {

    private class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#equals(java.lang.Object)
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Node other = (Node) obj;
            if (!getOuterType().equals(other.getOuterType())) {
                return false;
            }
            if (data != other.data) {
                return false;
            }
            return true;
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#hashCode()
         */
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + data;
            return result;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }

        private BinaryTreeTest getOuterType() {
            return BinaryTreeTest.this;
        }
    }

    @Disabled
    @Test
    public void testLeftView() {

        final Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(6);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        final List<Node> currentLevel = new ArrayList<>();
        currentLevel.add(root);
        Node currentNode = root;

        final List<Node> nextLevel = new ArrayList<>();

        boolean isFirst = true;

        while (!currentLevel.isEmpty()) {

            if (isFirst) {
                System.out.printf("%s ", currentNode.data);
            }

            isFirst = false;

            nextLevel.add(currentNode.left);
            nextLevel.add(currentNode.right);

            currentLevel.remove(currentNode);

            currentNode = currentLevel.isEmpty() ? null : currentLevel.get(0);

            if (currentLevel.isEmpty()) {
                currentLevel.addAll(nextLevel);
                nextLevel.clear();
                currentNode = currentLevel.get(0);
                isFirst = true;
            }
        }
    }

    @Test
    public void testPrintBottomView() {
        // bottomview
        final Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        final Map<Integer, List<Integer>> map = new TreeMap<>();

        printBottomView(root, 0, 0, map);
        System.out.printf("bottom view : %s\n", map);
    }

    @Test
    public void testPrintVerticalOrder() {

        final Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);

        final Map<Integer, List<Integer>> map = new TreeMap<>();

        printVerticalOrder(root, 0, map);
        System.out.printf("vertical order : %s\n", map);
    }

    @Test
    public void testPrintZigZag() {
        final Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(6);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        final List<Node> nodeList = new ArrayList<>();
        final List<Node> nextLevelNodes = new ArrayList<>();
        nodeList.add(root);

        boolean left2right = true;

        Node currentNode = root;

        while (!nodeList.isEmpty()) {

            System.out.print(currentNode.data + " ");

            if (left2right) {
                if (currentNode.left != null) {
                    nextLevelNodes.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    nextLevelNodes.add(currentNode.right);
                }
            } else {
                if (currentNode.right != null) {
                    nextLevelNodes.add(currentNode.right);
                }
                if (currentNode.left != null) {
                    nextLevelNodes.add(currentNode.left);
                }
            }

            nodeList.remove(currentNode);
            currentNode = !nodeList.isEmpty() ? nodeList.get(0) : null;

            if (nodeList.isEmpty()) {
                for (int i = nextLevelNodes.size() - 1; i >= 0; i--) {
                    nodeList.add(nextLevelNodes.get(i));
                }
                currentNode = !nodeList.isEmpty() ? nodeList.get(0) : null;
                nextLevelNodes.clear();
                left2right = false;
            }
        }
    }

    private void printBottomView(Node node, int hd, int h, Map<Integer, List<Integer>> map) {
        if (null == node) {
            return;
        }

        map.computeIfPresent(
                hd,
                (k, v) -> {
                    if (v.get(1) <= h) {
                        v.clear();
                        v.add(0, node.data);
                        v.add(1, h);
                    }
                    return v;
                });

        map.computeIfAbsent(
                hd,
                v -> {
                    final List<Integer> list = new ArrayList<>();
                    list.add(0, node.data);
                    list.add(1, h);
                    return list;
                });

        printBottomView(node.left, hd - 1, h + 1, map);
        printBottomView(node.right, hd + 1, h + 1, map);
    }

    private void printVerticalOrder(Node node, int hd, Map<Integer, List<Integer>> map) {

        if (null == node) {
            return;
        }

        map.computeIfPresent(
                hd,
                (k, v) -> {
                    v.add(node.data);
                    return v;
                });

        map.computeIfAbsent(
                hd,
                v -> {
                    final List<Integer> list = new ArrayList<>();
                    list.add(node.data);
                    return list;
                });

        printVerticalOrder(node.left, hd - 1, map);
        printVerticalOrder(node.right, hd + 1, map);
    }
}
