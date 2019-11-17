import java.util.ArrayList;

//write the insurance risk information in a nicely formatted 
//way to the screen
// write the insurance risk information to a JSON file.
public class InsuranceScoreWriter {
	
	public static void writeAssesmentToScreen(ArrayList<InsuranceScore>insuranceScore) {
		for(InsuranceScore i: insuranceScore ) {
			System.out.println(i);
		}
	}
}	
