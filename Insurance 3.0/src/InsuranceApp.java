import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

//Presents a welcome message

public class InsuranceApp {
       	 public static void printStars(int howMany) {
       	        String stars = "";
       	        for (int i = 0; i < howMany; i++) {
       	            stars = stars + "*";
       	        }
       	        System.out.println(stars);
       	    }

       
       	 


       public static void showMenu() {
       	System.out.println("\n");
           System.out.println("Here are your choices: \n");
           System.out.println("\t1.  List Members:");
           System.out.println("\t2.  Add a new member");
           System.out.println("\t3.  Save members");
           System.out.println("\t4.  Load members");
           System.out.println("\t5.  Assess members:");
           System.out.println("\t6.  Save assessments as JSON, ");
           System.out.println("\t7.  Exit");
           System.out.print("Enter the number of your choice:");

       }

       public static void main(String[] args) throws IOException {
    	   printStars(58);
           System.out.print("\t\tINSURANCE SCORE CARD \n This app scores a potential customer on various health \n"
           		+ "attributes: blood pressure, age, height, weight, and\n" + 
           		"family history of disease. It writes each member's \n"
           		+ "insurance grade to a JSON file so that they can be easily\n "
           		+ "shared on a web based data exchange! \n");
           printStars(58);
       
           
    	   Scanner sc = new Scanner(System.in);
    	   Scanner option = new Scanner(System.in);
           System.out.print("Enter name of data file: ");
           String filename = sc.nextLine();
           ArrayList<Member>members = MemberReader.readMembersFromTextFile(filename);
           int choice, count=0; //for the menu
          
           
           
       	if (members == null) {
           	System.out.println("Something bad happened, try again.");
           }else {
        	   
        	   for(Member m: members ) {
        		   count = count + 1;
       		}
        	System.out.printf("%s members read.", count);
        	   
        	   
          
           	do {
                   showMenu();
                   
                   choice = sc.nextInt();
                   System.out.println("");
                  //Choices begin *_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*
                   
                   if (choice == 1) {
                   System.out.print("Here are the Memebers: \n");
                   MemberWriter.writeMembersToScreen(members);
                   
                   }else if (choice == 2) {
                	String firstName, lastName, c, d, a;
                	int age, height, weight, bpSyst, bpDias;    
                    System.out.println("Enter first name:");
                    firstName = sc.next().trim();
                    System.out.println("Enter last name:");
                    lastName = sc.next().trim();
                    System.out.println("Enter age:");
                    age = sc.nextInt();
                    System.out.println("Enter height in inches:");
                    height = sc.nextInt();
                    System.out.println("Enter weight in pounds:");
                    weight = sc.nextInt();
                    System.out.println("Enter blood pressure sys:");
                    bpSyst = sc.nextInt();
                    System.out.println("Enter blood pressure dia:");
                    bpDias = sc.nextInt();
                    System.out.println("Has a family member had...");
                    System.out.println("Cancer? (y/n):");
                    c = sc.next().trim();
                    System.out.println("Diabetes? (y/n):");
                    d = sc.next().trim();
                    System.out.println("Alzheimers? (y/n):");
                    a = sc.next().trim();
                    
                	FileWriter fileWriter = new FileWriter(filename, true); //Set true for append mode
               	    PrintWriter printWriter = new PrintWriter(fileWriter);
               	    printWriter.println(firstName+"	"+lastName+"	"+age+"	"+height+"	"+weight+"	"+bpSyst+"	"+bpDias+"	"+c+"	"+d+"	"+a);  //New line
               	    printWriter.close();
               	    members.add(new Member(firstName, lastName, age, height, weight, bpSyst, bpDias, c, d, a));
                   }
                   else if (choice == 3) {
                   	System.out.print("(T)ext, (B)inary, or (X)ML?");
                   	String textOption = option.nextLine();

                	System.out.println("Enter then name of the output file: ");
                   	filename = option.nextLine();
                   	if (textOption == "B") {
                   		MemberWriter.writeMembersToBinary(filename, members);
                   	} else if (textOption == "T") {
                   		MemberWriter.writeMembersToTextFile("output.txt", members);
                   	}else if (textOption == "X") {
                   		MemberWriter.writeMembersToXML(filename, members);
                   	}
                   	
                   } 
                   else if (choice == 4) {
                   // Assessor.getAgeScore(members);
                    Assessor.getBMIScore(members);
                    Assessor.getBloodPressure(members);
                    Assessor.getDisease(members);
                    
                   }
                   else if (choice == 5) {
                   	
                   }	
           	}
           	while (choice != 6);
           	System.out.println("Have a good day.");
           }
      }
}













