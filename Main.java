public class Main {
    public static void main(String[] args) {
        // Create an instance of TwoWayLinkedList
        TwoWayLinkedList<String> list = new TwoWayLinkedList<>();

        // Test the methods
        list.add("A");
        list.add("B");
        list.add("C");

        System.out.println("List: " + list);

        System.out.println("Size: " + list.size());
        System.out.println("Contains 'B': " + list.contains("B"));
        System.out.println("Element at index 1: " + list.get(1));

        list.remove("B");
        System.out.println("List after removing 'B': " + list);
    }
}

