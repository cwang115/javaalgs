package section1;

public class HindexII {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int left = 0, right = citations.length - 1, mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (citations[mid] == citations.length - mid) return citations.length - mid;
            else if (citations[mid] < citations.length - mid) left = mid + 1;
            else right = mid - 1;
        }
        return citations.length - left;
    }


    public static void main(String[] args){
        HindexII solution = new HindexII();
        int[] citations = {0, 1, 3, 5, 6};
        int result = solution.hIndex(citations);
        System.out.println(result);
    }
}
