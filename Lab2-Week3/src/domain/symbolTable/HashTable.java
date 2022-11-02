package domain.symbolTable;

import java.util.Arrays;

public class HashTable {
    private Integer size, nb_of_elements;
    private Node[] elements;

    public HashTable(Integer size) {
        this.size = size;
        elements = new Node[size];
    }

    private int hashFunction(String value) {
        Integer sum = 0;
        for (char character: value.toCharArray()) {
            sum += (int) character;
            System.out.println((int) character);

        }
        System.out.println(sum % this.size);
        return sum % this.size;
    }

    public Position addElement(String value) {
        Integer hashValue = this.hashFunction(value);
        if (this.elements[hashValue] == null) {
            this.elements[hashValue] = new Node(value, 0);
            return new Position(hashValue, 0);
        }
        /// else
        Node lastNode = this.elements[hashValue];
        while (lastNode.nextNode != null) {
            lastNode = lastNode.nextNode;
        }
        Node newNode = new Node(value, lastNode.index + 1);
        lastNode.nextNode = newNode;
        return new Position(hashValue, newNode.index);
    }

    public Position searchElement(String value) {
        Integer hashValue = this.hashFunction(value);
        Node currentNode = this.elements[hashValue];
        if (currentNode != null) {
            while (currentNode != null) {
                if (currentNode.value.equals(value)) {
                    return new Position(hashValue, currentNode.index);
                }
                currentNode = currentNode.nextNode;
            }
        }
        return new Position(-1, -1);
    }

    @Override
    public String toString() {
        return "HashTable{" +
                "size=" + size +
                ", nb_of_elements=" + nb_of_elements +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }
}
