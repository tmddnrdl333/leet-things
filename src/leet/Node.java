package leet;

import java.util.ArrayList;
import java.util.List;

/**
 * Unified node used by LeetCode N-ary tree and graph problems.
 * `children` is populated by N-ary deserializers; `neighbors` by graph deserializers.
 */
public class Node {
    public int val;
    public List<Node> children;
    public List<Node> neighbors;

    public Node() {
        this.children = new ArrayList<>();
        this.neighbors = new ArrayList<>();
    }

    public Node(int val) {
        this.val = val;
        this.children = new ArrayList<>();
        this.neighbors = new ArrayList<>();
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
        this.neighbors = new ArrayList<>();
    }
}
