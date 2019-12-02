package section1;

public class BinarySearch {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;


        while(left < right){
            int mid = left + (right - left) /2;
            if(nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                left = mid+1;
            } else {
                right = mid;
            }
        }

        if(nums[left] == target){
            return left;
        }

        return -1;


    }

    public static void main(String[] args){
        int[] array = {-1, 0, 3, 5, 9, 12};

        BinarySearch solution = new BinarySearch();
        System.out.println(solution.search(array, 2));

    }
}
