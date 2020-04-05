import arrays.MaximumSubArray;
import arrays.Sort;

public class JavaPracticeApplication {
    public static void main(String[] args) {


        // MaxSubArray
        int[] maxTest1 = {-2,1,-3,4,-1,2,1,-5,4};
        int[] maxTest2 = {-2,-1};
        System.out.println(MaximumSubArray.maxSubArray(maxTest1));
        System.out.println(MaximumSubArray.maxSubArray(maxTest2));
        System.out.println("\n---------------------------------------\n");
    }
}

