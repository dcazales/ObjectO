import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.beans.XMLDecoder;

//Reads member data from the tab delimited text file
//Shows the menu of options and repeats as long as the user does not want to quit
	
public class MemberReader {
	//Reads from a texfile
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
                //Splits the line into parts 
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
                
               
               //calls in constructor
                members.add(new Member(firstName,lastName, age, height, weight, 
                		 bpSyst, bpDias, cancer, diabetes,  alzheimers));
            }
            fsc.close();
            return members;
        } catch (Exception ex) {
            return null;  // indicates a problem  with file; gracefully saving yourself
        }
    }

	//BINARY
public static ArrayList<Member> readMembersFromBinary(String filename) {
    try {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
        ArrayList<Member> result = (ArrayList<Member>)ois.readObject();
        ois.close();
        return result;
    } catch (Exception ex) {
        return null;
    }
}
//XML TEXT TO READ
public static ArrayList<Member> readMembersFromXML(String filename) {
    try {
        XMLDecoder dec = new XMLDecoder(new BufferedInputStream(new
                FileInputStream(filename)));
        ArrayList<Member> result = (ArrayList<Member>)dec.readObject();
        dec.close();
        return result;
    } catch (Exception ex) {
        return null;
    }
}

}