import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

//write the insurance risk information in a nicely formatted 
//way to the screen
public class InsuranceScoreWriter {
	
	public static void writeMembers(ArrayList<InsuranceScore> insuranceScores) {	       
		            for (InsuranceScore is : insuranceScores) {
		            	System.out.println(is+"\n");   
		    } 
	
	
	}
//Jason
	public static boolean writeMembersToJSON(String filename,
		    ArrayList<Member> members) {
		        try {
		            PrintWriter pw = new PrintWriter(new BufferedWriter(new
		                FileWriter(filename)));
		            
		            // create a JSON object for each student
		            JSONObject memObj;
		            JSONArray array = new JSONArray();
		            
		            for (Member mem : members) {
		                memObj = new JSONObject();
		                //Need to fix this
		                memObj.put("na me", mem.getFirstName());
		                memObj.put("last name", mem.getLastName());
		                memObj.put("age", mem.getAge());
		                memObj.put("height", mem.getHeight());
		                memObj.put("weight", mem.getWeight());
		                memObj.put("BP Syst", mem.getBpSyst());
		                memObj.put("BP Dias", mem.getBpDias());
		                memObj.put("Cancer", mem.getCancer());
		                memObj.put("Diabetes", mem.getDiabetes());
		                memObj.put("alzheimers", mem.getAlzheimers());
		                array.add(memObj);
		            }
		            JSONObject outer = new JSONObject();
		            outer.put("members", array);
		            pw.println(outer.toJSONString());
		            pw.close();
		            return true;
		        } catch (Exception ex) {
		            return false;
		        }
		    }
}




























