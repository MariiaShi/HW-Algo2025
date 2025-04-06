package org.Tree;

public class AVLTree {

    Node root;
    private int length = 0;
    private boolean isBalanced;

    /**
     * Конструктор для создания нового бинарного дерева поиска.
     */
    public AVLTree() {
        this.root = null;
        this.isBalanced = true;
    }

    /**
     * Вставляет новый узел в дерево.
     *
     * @param key   Ключ нового узла.
     * @param value Значение нового узла.
     */
    public void insert(int key, String value) {
        Node newNode = new Node(key, value);
        if (root == null) {
            root = newNode;
            length++;
            this.updateBalanceFactor(root);
        } else {
            insertNode(root, newNode);
        }
    }

    /**
     * Рекурсивно вставляет новый узел в поддерево.
     *
     * @param node    Текущий узел.
     * @param newNode Новый узел.
     */
    private void insertNode(Node node, Node newNode) {
        if (newNode.key < node.key) {
            if (node.left == null) {
                node.left = newNode;
                length++;
                this.updateBalanceFactor(root);
            } else {
                insertNode(node.left, newNode);
            }
        } else if (newNode.key > node.key) {
            if (node.right == null) {
                node.right = newNode;
                length++;
                this.updateBalanceFactor(root);
            } else {
                insertNode(node.right, newNode);
            }
        } else {
            // Дубликат ключа — обновляем значение без увеличения длины
            node.value = newNode.value;
        }
    }

    /**
     * Ищет значение узла по заданному ключу.
     *
     * @param key Ключ искомого узла.
     * @return Значение найденного узла или null, если узел не найден.
     */
    public String search(int key) {
        Node node = searchNode(root, key);
        return node != null ? node.value : null;
    }

    /**
     * Рекурсивно ищет узел с заданным ключом в поддереве.
     *
     * @param node Текущий узел.
     * @param key  Ключ искомого узла.
     * @return Найденный узел или null, если узел не найден.
     */
    private Node searchNode(Node node, int key) {
        if (node == null) {
            return null;
        }

        if (key < node.key) {
            return this.searchNode(node.left, key);
        } else if (key > node.key) {
            return this.searchNode(node.right, key);
        } else {
            return node;
        }
    }

    /**
     * Находит минимальный узел в дереве.
     *
     * @return Минимальный узел или null, если дерево пустое.
     */
    public Node min() {
        if (root == null) {
            return null;
        }
        Node currentNode = root;
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode;
    }

    /**
     * Находит максимальный узел в дереве.
     *
     * @return Максимальный узел или null, если дерево пустое.
     */
    public Node max() {
        if (root == null) {
            return null;
        }
        Node currentNode = root;
        while (currentNode.right != null) {
            currentNode = currentNode.right;
        }
        return currentNode;
    }

    public int length() {
        return length;
    }

    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(this.getHeight(node.left), this.getHeight(node.right)) + 1;
    }

    private void updateBalanceFactor(Node node) {
        if (node == null) {
            return;
        }
        node.balanceFactor = this.getHeight(node.right) - this.getHeight(node.left);
        if (node.balanceFactor > 1 || node.balanceFactor < -1) {
            this.isBalanced = false;
        }
        this.updateBalanceFactor(node.left);
        this.updateBalanceFactor(node.right);
    }

    public boolean isBalanced() {
        return this.isBalanced;
    }

    /**
     * Отображает дерево в виде древовидной структуры в терминале.
     */
    public void displayTree() {
        if (root == null) {
            System.out.println("Дерево пустое.");
            return;
        }
        displayNode(root, "", true);
    }

    /**
     * Рекурсивно отображает узел и его поддеревья.
     *
     * @param node   Текущий узел.
     * @param prefix Префикс для отображения уровня дерева.
     * @param isLeft Флаг, указывающий, является ли узел левым дочерним.
     */
    private void displayNode(Node node, String prefix, boolean isLeft) {
        if (node != null) {
            String displayPrefix = prefix + (isLeft ? "├── " : "└── ");
            String directionIndicator = isLeft ? "L: " : "R: ";

            System.out.println(displayPrefix + directionIndicator + node.key + ":" + node.balanceFactor);

            String childPrefix = prefix + (isLeft ? "│   " : "    ");
            if (node.left != null || node.right != null) {
                displayNode(node.left, childPrefix, true);
                displayNode(node.right, childPrefix, false);
            }
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insert(3, "one");
        tree.insert(12, "two");
        tree.insert(2, "three");
        tree.insert(15, "four");
        tree.insert(16, "five");
        tree.insert(12, "updated two"); // дубликат, обновляет значение

        System.out.println("\n== Дерево ==");
        tree.displayTree();

        System.out.println("\n== Тесты ==");
        System.out.println("Поиск 12: " + tree.search(12)); // updated two
        System.out.println("Поиск 99: " + tree.search(99)); // null

        Node minNode = tree.min();
        System.out.println("Минимум: " + (minNode != null ? minNode.key : "null")); // 2

        Node maxNode = tree.max();
        System.out.println("Максимум: " + (maxNode != null ? maxNode.key : "null")); // 16

        System.out.println("Длина дерева: " + tree.length()); // 5
        System.out.println("Сбалансировано: " + tree.isBalanced()); // true/false
    }
}

