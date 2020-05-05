package learn.queueandstack.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

/**
 * @File    :   CloneGraph.java
 * @Time    :   2020/05/05 17:33:52
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class CloneGraph {
    public Node cloneGraph(Node node) {
        HashMap<Integer, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    private Node dfs(Node node, HashMap<Integer, Node> map) {
        if (node == null) return null;
        if (map.containsKey(node.val)) return map.get(node.val);
        Node copyNode = new Node(node.val);
        map.put(copyNode.val, copyNode);
        for (Node neighbor: node.neighbors) {
            copyNode.neighbors.add(dfs(neighbor, map));
        }
        return copyNode;
    }
}