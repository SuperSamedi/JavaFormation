import java.util.*;

public class DemoCollection {
    public static void main(String[] args) {
        int a = 5;
        int b = a;
        b = 2;

        // Tableau
        int[] myTab = new int[5];
        myTab[1] = 5;
        myTab[4] = 8;
        // Si je n'utilise pas clone, mon myTab va aussi être modifié
        int[] myTab2 = myTab.clone();
        myTab2[4] = 7;
        // System.out.println("Dernier element : " + myTab[myTab.length - 1]);
        for (int i = 0; i < myTab.length; i++) {
            // System.out.println(myTab[i]);
        }
        for (int elem : myTab) {
            // System.out.println(elem);
        }

        // List ordonné avec doublons
        ArrayList<Integer> myArrayList = new ArrayList<>();
        myArrayList.add(5);
        myArrayList.add(5);
        myArrayList.set(1, 8);
        System.out.println(myArrayList.get(1));
        System.out.println(myArrayList);
        for (int elem : myArrayList) {
            System.out.println(elem);
        }

        // Liste non ordonné sans doublons
        Set<String> mySet = new HashSet<>();
        mySet.add("Hola");
        mySet.add("Hola");
        System.out.println("Set : " + mySet);

        // Map (système de clé valeur)
        Map<Integer, String> myMap = new HashMap<>();
        myMap.put(3, "Bonjour");
        myMap.put(3, "Au revoir");
        myMap.put(5, "Au revoir");
        System.out.println(myMap);
        for (Map.Entry<Integer, String> entry : myMap.entrySet()) {
            System.out.println(entry);
        }

        // Stack
        Stack<Integer> myStack = new Stack<>();
        myStack.push(5);
        myStack.push(6);
        myStack.push(7);
        myStack.pop();
        System.out.println(myStack);

        // Queue
        // File d'attente
        Queue<Integer> myQueue = new LinkedList<>();
        myQueue.add(5);
        myQueue.add(6);
        myQueue.add(7);
        myQueue.poll();
        System.out.println(myQueue);

        // ArrayDeque
        ArrayDeque<String> myArrayDeque = new ArrayDeque<>();
        myArrayDeque.add("5");
        myArrayDeque.add("6");
        myArrayDeque.add("7");
        myArrayDeque.removeLast();
        myArrayDeque.removeFirst();
    }
}
