import java.util.Scanner;

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

       public static void printWelcome() {
           printStars(58);
           System.out.print("\t\tINSURANCE SCORE CARD \n This app scores a potential customer on various health \n"
           		+ "attributes: blood pressure, age, height, weight, and\n" + 
           		"family history of disease. It writes each member's \n"
           		+ "insurance grade to a JSON file so that they can be easily\n "
           		+ "shared on a web based data exchange! \n");
           printStars(58);
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

       public static void main(String[] args) {
    	   Scanner sc = new Scanner(System.in);
           System.out.print("Enter name of data file: ");
           String filename = sc.nextLine();
           ArrayList<Member>members = MemberReader.readMembersFromTextFile(filename);
           int choice; //for the menu
           
       	if (members == null) {
           	System.out.println("Something bad happened, try again.");
           }else {
       	
        	   printWelcome();
          
           	do {
                   showMenu();
                   choice = sc.nextInt();
                   System.out.println("");
                  //Choices begin *_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*
                   
                   if (choice == 1) {
                   	System.out.print("Here are all of the Memebers: \n\n");
                  
                   MemberWriter.writeMembersToScreen(members);
                   
                   } else if (choice == 2) {
                	   
            
                   }
                   else if (choice == 3) {
                   	
                   	
                   } 
                   else if (choice == 4) {
                   	
                   }
                   else if (choice == 5) {
                   	
                   }	
           	}
           	while (choice != 6);
           	System.out.println("Have a good day.");
           }
      }
}













