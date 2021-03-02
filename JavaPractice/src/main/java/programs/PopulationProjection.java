package programs;

/** (Population projection) The U.S. Census Bureau projects population based on the following assumptions:
 *      One birth every 7 seconds
 *      One death every 13 seconds
 *      One new immigrant every 45 seconds
 *
 * Write a program to display the population for each of the next five years. Assume the current population is
 * 312,032,486 and one year has 365 days.
 * Hint: In Java, if two integers perform division, the result is an integer. The fraction part is truncated.
 * For example, 5 / 4 is 1 (not 1.25) and 10 / 4 is 2 (not 2.5).
 */

public class PopulationProjection {

    // Adding the change in population each year = births + immigrants - deaths
    public static void getPopulationsMethod1() {
        int population = 312032486;
        int secondsInAYear = 60 * 60 * 24 * 365;
        int births = secondsInAYear / 7;
        int deaths = secondsInAYear / 13;
        int immigrants = secondsInAYear / 45;

        for (int i = 0; i < 5; i++) {
            population = population + births + immigrants - deaths;
            System.out.println("Population using the change in population is: " + population);
        }
    }

    // Uses the arithmetic sequence formula: nth term = first term + d(n - 1)
    public static void getPopulationsMethod2() {
        int population = 312032486;
        int secondsInAYear = 60 * 60 * 24 * 365;
        int births = secondsInAYear / 7;
        int deaths = secondsInAYear / 13;
        int immigrants = secondsInAYear / 45;
        int commonDifference = births + immigrants - deaths;

        for (int i = 2; i < 7; i++) {
            int newPopulation = population + commonDifference * (i-1);
            System.out.println("Population using the arithmetic sequence formula is: " + newPopulation);
        }
    }

    // When running the main method, we see that either of the solutions will produce the same output
    public static void main(String[] args) {
        getPopulationsMethod1();
        getPopulationsMethod2();
    }
}
//    // Output:
//    Population using the change in population is: 314812582
//    Population using the change in population is: 317592678
//    Population using the change in population is: 320372774
//    Population using the change in population is: 323152870
//    Population using the change in population is: 325932966
//    Population using the arithmetic sequence formula is: 314812582
//    Population using the arithmetic sequence formula is: 317592678
//    Population using the arithmetic sequence formula is: 320372774
//    Population using the arithmetic sequence formula is: 323152870
//    Population using the arithmetic sequence formula is: 325932966