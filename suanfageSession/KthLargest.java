package suanfageSession;

public class KthLargest {
    public int findKthLargest(int[] nums, int k) {

        //quick selection
        //cc


        //do it in place use quick select
        quickSelect(nums, 0, nums.length -1, k-1);
        return nums[k];

    }

    private void quickSelect(int[] nums, int left, int right, int target){

        int mid = partition(nums, left, right);
        if(mid == target){
            return;
        }else if(mid < target){
            quickSelect(nums, mid+1, right, target);
        }else if(mid > target){
            quickSelect(nums, left, mid-1, target);
        }
    }


    private int partition(int[] nums, int left, int right){
        // int mid = left + (right - left) /2;
        // swap(nums, mid, right);
        int pivot = nums[right];
        int start = left;
        int end = right -1;
        while(start <= end){
            if(nums[start] > pivot){
                start++;
            } else if(nums[end] <= pivot){
                end--;
            }else{
                swap(nums, start++, end--);
            }
        }

        swap(nums, start, right);
        return start;
    }

    private void swap(int[] nums, int left, int right){
        int swap = nums[left];
        nums[left] = nums[right];
        nums[right] = swap;
    }

    public static void main(String[] args){
        KthLargest solution = new KthLargest();
        int[] array = {3, 2, 1, 5, 6, 4};
        int result = solution.findKthLargest(array, 2);
        System.out.println(result);
    }
}
