package lesson_303_5.practiceAssignment_303_5_2;
/**
 * Suppose the tuition for a university is $10,000 for the current year and increases by 7 percent every year. 
In how many years will the tuition be doubled?
Year 	Tuition
0 		$10,000
1 		tuition = 1.07 * tuition
…		tuition = 1.07 * tuition
…		tuition = 1.07 * tuition
……
?		$20,000 or more
 */
public class PredictFutureTuition {
	public static void main(String[] args) {
		double  tuition  = 10000;
		int year = 0;
		while (tuition  <= 20000-1) {
			tuition = 1.07 * tuition;
			year++;
		}
		System.out.println(year);
	}
}
