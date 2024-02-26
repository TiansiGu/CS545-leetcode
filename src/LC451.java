/**
 * LC 451. Sort Characters By Frequency
 * https://leetcode.com/problems/sort-characters-by-frequency/description/
 */
public class LC451 {
    /**
     * Sorting
     * counting sort + quick sort
     * Time: O(n). Form a frequency array is one pass. quickSort takes constant time because there are
     * in total 75 elements in the frequency array. Last step (filling-in) is one pass.
     * Space: O(n). sArr takes O(n) extra space, but frequency array only takes O(1) extra space.
     */
    class Pair {
        private char c; //char
        private int n; //number of c in total
        public Pair(char c, int n) {this.c = c; this.n = n;}
        public char getC() {return this.c;}
        public int getN() {return this.n;}
    }

    public String frequencySort(String s) {
        char[] sArr = s.toCharArray();
        // create freqPairArray to store every character and its corresponding number of occurrence
        int[] freqArray = new int[75];
        for (char c : sArr) {
            freqArray[c - '0']++;
        }
        Pair[] freqPairArray = new Pair[75];
        for (int i = 0; i < 75; i++) {
            char c = (char) (i + (int) '0');
            freqPairArray[i] = new Pair(c, freqArray[i]);
        }
        // quickSort the frequency array based on frequencies
        quickSort(freqPairArray, 0, 74);
        // using the sorted frequency array to fill the initial array
        int index = 0;
        for (int i = 0; i < 75; i++) {
            Pair pair = freqPairArray[i];
            int count = pair.getN();
            while (count > 0) {
                sArr[index++] = pair.getC();
                count--;
            }
        }
        return new String(sArr);
    }

    private void quickSort(Pair[] arr, int low, int high) {
        if (low < high) {
            int mid = partition(arr, low, high);
            quickSort(arr, low, mid - 1);
            quickSort(arr, mid + 1, high);
        }
    }

    private int partition(Pair[] arr, int low, int high) {
        int mid = (low + high) / 2;
        int max = high;
        Pair pivot = arr[mid];
        arr[mid] = arr[high];
        arr[high] = pivot;
        while (low <= high) {
            while (low <= high && arr[low].getN() > pivot.getN()) {
                low++;
            }
            while (low <= high && arr[high].getN() <= pivot.getN()) {
                high--;
            }
            if (low < high) {
                Pair tmp = arr[low];
                arr[low] = arr[high];
                arr[high] = tmp;
            }
        }
        arr[max] = arr[low];
        arr[low] = pivot;
        return low;
    }
}
