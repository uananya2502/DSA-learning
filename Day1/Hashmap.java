import java.util.*;

public class Hashmap<K, V> {

    private class Node {
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int n; // number of nodes
    private int N; // bucket size
    private LinkedList<Node>[] buckets;

    @SuppressWarnings("unchecked")
    public Hashmap() {
        this.N = 4;
        this.buckets = new LinkedList[N];

        for (int i = 0; i < N; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    // Hash Function
    private int hashFunction(K key) {
        int hc = key.hashCode();
        return Math.abs(hc) % N;
    }

    // Search in LinkedList
    private int searchLL(K key, int bi) {
        LinkedList<Node> ll = buckets[bi];

        for (int i = 0; i < ll.size(); i++) {
            Node node = ll.get(i);

            if (node.key.equals(key)) {
                return i;
            }
        }

        return -1;
    }

    @SuppressWarnings("unchecked")
    private void rehash() {
        LinkedList<Node>[] oldBuckets = buckets;

        N = N * 2;
        buckets = new LinkedList[N];

        for (int i = 0; i < N; i++) {
            buckets[i] = new LinkedList<>();
        }

        n = 0;

        for (int i = 0; i < oldBuckets.length; i++) {
            LinkedList<Node> ll = oldBuckets[i];

            while (!ll.isEmpty()) {
                Node node = ll.remove();
                put(node.key, node.value);
            }
        }
    }

    // Put
    public void put(K key, V value) {
        int bi = hashFunction(key);
        int di = searchLL(key, bi);

        if (di != -1) {
            Node node = buckets[bi].get(di);
            node.value = value;
        } else {
            buckets[bi].add(new Node(key, value));
            n++;
        }

        double lambda = (double) n / N;

        if (lambda > 2.0) {
            rehash();
        }
    }

    // Contains Key
    public boolean containsKey(K key) {
        int bi = hashFunction(key);
        int di = searchLL(key, bi);

        return di != -1;
    }

    // Remove
    public V remove(K key) {
        int bi = hashFunction(key);
        int di = searchLL(key, bi);

        if (di != -1) {
            Node node = buckets[bi].remove(di);
            n--;
            return node.value;
        }

        return null;
    }

    // Get
    public V get(K key) {
        int bi = hashFunction(key);
        int di = searchLL(key, bi);

        if (di != -1) {
            return buckets[bi].get(di).value;
        }

        return null;
    }

    // Key Set
    public ArrayList<K> keySet() {
        ArrayList<K> keys = new ArrayList<>();

        for (int i = 0; i < buckets.length; i++) {
            LinkedList<Node> ll = buckets[i];

            for (Node node : ll) {
                keys.add(node.key);
            }
        }

        return keys;
    }

    // Main
    public static void main(String[] args) {
        Hashmap<String, Integer> hm = new Hashmap<>();

        hm.put("India", 120);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("UK", 30);
        hm.put("Russia", 20);

        System.out.println(hm.get("India"));
        System.out.println(hm.containsKey("India"));
        System.out.println(hm.remove("India"));
        System.out.println(hm.containsKey("India"));

        ArrayList<String> keySet = hm.keySet();

        for (String key : keySet) {
            System.out.println(key);
        }
    }
}