import arrays.Sort;

public class JavaPracticeApplication {
    public static void main(String[] args) {

        // SortSoln1
        int[] a = {1,1,2,2,3,4,4,5};
        int[] ansSoln1 = Sort.sortSoln1(a);
        System.out.print("sortSoln1 = ");
        for (int i = 0; i < ansSoln1.length; i++) {
            // should output 1,2,3,4,5
            System.out.print(ansSoln1[i] + " ");
        }
        System.out.println("\n---------------------------------------\n");

        // SortSoln2
        int[] b = {1,1,2,2,3};
        int[] ansSoln2 = Sort.sortSoln2(b);
        System.out.print("sortSoln2 = ");
        for (int i = 0; i < ansSoln2.length; i++) {
            // should output 1,2,3
            System.out.print(ansSoln2[i] + " ");
        }
        System.out.println("\n---------------------------------------\n");
    }
}

