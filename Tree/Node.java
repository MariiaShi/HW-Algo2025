package org.Tree;

class Node {
    int key;
    String value;
    Node left;
    Node right;
    int balanceFactor;

    /**
     * Конструктор для создания нового узла.
     *
     * @param key   Ключ узла.
     * @param value Значение узла.
     */
    public Node(int key, String value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
        this.balanceFactor = 0;
    }
}

