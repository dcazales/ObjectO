
	import java.util.ArrayList;
	import java.util.Scanner;


import java.io.File;

	
public class MemberReader {
	
	
	public static ArrayList<Member> readMembersFromTextFile(String filename) {
        try {
            Scanner fsc = new Scanner(new File(filename)); 
            String line;
            String firstName, lastName, cancer, diabetes, alzheimers;
            int age, height, weight,bpSyst, bpDias;
            //Storage
            String [] parts;
            ArrayList<Member> members = new ArrayList<Member>();

            while (fsc.hasNextLine()) {
                line = fsc.nextLine().trim();
                //Splits the line
                parts = line.split("\t");
                firstName = parts[0];
                lastName = parts[1];
                age =Integer.parseInt(parts[2]);
                height =Integer.parseInt(parts[3]);
                weight =Integer.parseInt(parts[4]);
                bpSyst =Integer.parseInt(parts[5]);
                bpDias =Integer.parseInt(parts[6]);
                cancer = parts[7];
                diabetes = parts[8];
                alzheimers = parts[9];
                
               
               
                members.add(new Member(firstName,lastName, age, height, weight, 
                		 bpSyst, bpDias, cancer, diabetes,  alzheimers));
            }
            fsc.close();
            return members;
        } catch (Exception ex) {
            return null;  // indicates a problem  with file; gracefully saving yourself
        }
    }
    
}
