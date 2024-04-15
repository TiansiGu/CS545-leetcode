import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * LC 347. Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 * Hash Table + Heap
 */

public class LC347 {
    /**
     * Get the k most frequent elements from an unsorted array
     * Heap + Hashmap
     * @param nums input integer array
     * @param k the top k frequent elements
     * @return the k most frequent elements
     * Time: O(n * logk), since the minHeap at most has k+1 elements, each insertion/deletion with heap
     * takes O(lgk). And there are at most n k-value pairs in the map. In total takes O(n * logk) time
     * Space: O(n), O(n + k) -> O(n)
     */
    public int[] getKopKFrequent(int[] nums, int k) {
        // get each number's frequency
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        // keep a size k minHeap, comparator implemented by frequency
        // the final k paris in the heap is the top k frequent elements
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int n = entry.getKey();
            int freq = entry.getValue();
            minHeap.add(new int[] {n, freq});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        // put the most k frequent elements in result array
        int[] result = new int[k];
        int idx = 0;
        while (!minHeap.isEmpty()) {
            result[idx++] = minHeap.poll()[0];
        }
        return result;
    }
}
