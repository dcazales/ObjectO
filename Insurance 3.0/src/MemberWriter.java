import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.*;
import java.beans.XMLEncoder;
//import org.json.simple.*;

//Saves the members to a tab-delimited text file 
//text file, binary file, xml file
//Where loads the member from binary file and xml file****
public class MemberWriter {
	
	
	
	public static void writeMembersToScreen(ArrayList<Member>members) {
		for(Member m: members ) {
			System.out.println(m);
		}
	}
	
	//Textfile
	public static boolean writeMembersToTextFile(String filename, 
		    ArrayList<Member> members) {
		        try {
		            PrintWriter pw = new PrintWriter(new BufferedWriter(
		                new FileWriter(filename)));
		            for (Member member: members) {
		                pw.println(member);
		            }
		            pw.close();
		            return true;
		        } catch (Exception ex) {
		            return false;
		        }
		    }
	
//Binary function	
	public static boolean writeMembersToBinary(String filename, 
		ArrayList<Member> members) {
		   try {
		        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
		          oos.writeObject(members);
		          oos.close();
		           return true; 
		        } catch (Exception ex) {
		            return false;
		        }
		    }
//XML function
	public static boolean writeMembersToXML(String filename,
		ArrayList<Member> members) {
		   try {
		       XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(new
		           FileOutputStream(filename)));
		           enc.writeObject(members);
		            enc.close();
		            return true;
		        } catch (Exception ex) {
		            return false;
		        }
		    }
/*/toJSON File
	
	public static boolean writeMembersToJSON(String filename,
		    ArrayList<Member> members) {
		        try {
		            PrintWriter pw = new PrintWriter(new BufferedWriter(new
		                FileWriter(filename)));
		            
		            // create a JSON object for each student
		            JSONObject stuObj;
		            JSONArray array = new JSONArray();
		            for (Member mem : members) {
		                stuObj = new JSONObject();
		                //Need to fix this
		                stuObj.put("name", stu.getName());
		                stuObj.put("grades", stu.getGrades());
		                array.add(stuObj);
		            }
		            JSONObject outer = new JSONObject();
		            outer.put("members", array);
		            pw.println(outer.toJSONString());
		            pw.close();
		            return true;
		        } catch (Exception ex) {
		            return false;
		        }
		    }*/
		}