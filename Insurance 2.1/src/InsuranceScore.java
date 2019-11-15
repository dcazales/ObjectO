//Models the risk associated with each member 
//stores the name, score, and risk level for a member
import java.util.ArrayList;

public class InsuranceScore {
   //Body-Mass Index which is equal to a persons weight in kg divided by height in meters
	//Since the original data is in lb and in we have to convert the values to meters and kg
	private String firstName,lastName, verdict;
    private int score;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLasttName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public int getScore() {
        return score;
    }
    public void setScore(int sc) {
        score = sc;
    }
    public String getVerdict() {
        return verdict;
    }
    public void setVeredict(String veridect) {
        this.verdict = verdict;
    }
    public InsuranceScore(String lastName, String firstName, int sc) {
    	setLastName(lastName);
    	setFirstName(firstName);
    	//setScore = (sc);
    }
    
    @Override
    public String toString() {
    	return String.format("Name:		%s, %s \n"
    			+ "Score:		%d \n"
    			+ "Verdict:		String", lastName,firstName, score);
    	
    }

}