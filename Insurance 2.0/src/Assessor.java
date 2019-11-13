import java.util.ArrayList;
//determine the risk for each member and create an InsuranceScore object
//for each member and create an InsuranceScore object for eahc member 
//that expresses the risk
public class Assessor {
	
	public String getScore(double result) {
        if (result <= 20) {
            return "low risk";
        } else if ((result <= 50 )&& (result >=21)) {
            return "moderate risk";
        } else if ((result <= 75)&&(result>51)) {
            return "high risk";
        } else {
            return "unisurable";
        }
    }
	
	//Attempting to do functions that do the calculations.
	
	 public static void getAgeScore(ArrayList<Member>members) {
		 double ageScore = 0, age;	
		 
		 for (Member member : members) {
			 	age = member.getAge();
	    		
			 	if  (age <= 30 ) {
	    			ageScore = 0;
	    		
	    		} else if((age >= 29)&&(age <45 )){
	    			ageScore = 10;
	    		
	    		} else if ((age > 46 )&&(age < 60)) {
	    			ageScore =20;
	    		
	    		} else {
	    			ageScore = 30;
	    		}
	    		System.out.print("Age"+ageScore+"\n");
	    	}
			
	    }
	 
	//This one is attempting to calculate the weight points. 
		
		public static void getBMIScore(ArrayList<Member>members) {
	        for (Member member : members) {
	            double newWeight = member.getWeight()% 2.205;	
	        	double newHeight = member.getHeight()% 39.37;
	        	double scoreWeight = newWeight % newHeight;
	        	System.out.print("Weight"+ scoreWeight +"\n");
	        }

		}
			
	  
	 public static void getBloodPressure(ArrayList<Member>members) {
		 double bloodPressure =0, bpSyst, bpDias;
		 for (Member member : members) {
			 bpSyst = member.getBpSyst();
			 bpDias = member.getBpDias();
			 if ((bpSyst <=120) && (bpDias < 80)) {
				 //Normal
				 bloodPressure = 0;
			 
			 }else if ((bpSyst > 120 && bpSyst < 129) && (bpDias < 80)) {
				 //Elevated
				 bloodPressure = 15;
			 
			 } else if ((bpSyst >=130 && bpSyst <39) || (bpDias >=80  && bpDias < 89)) {
				 //HighBlood Pressure  Systolic Stage 1
				 bloodPressure = 30;
				 
			 }else if ((bpSyst >=140 && bpSyst < 180)||(bpDias >=90 && bpDias < 120)) {
				 //Stage 2
				 bloodPressure = 75;
			 
			 }else if ((bpSyst >180)||(bpDias >120)){
				 //Hypertensive crisis
				 bloodPressure = 100;
			 }
			 System.out.print("Blood Presure "+ bloodPressure +"\n");
	 }
		 
}/*
	public static void getDisease(ArrayList<Member>members) {
		int disease=0;
		String al, c, d;
		for (Member member : members) {
			al = member.getAlzheimers();
			c = member.getCancer();
			d = member.getDiabetes();
		//Alzheimers 
			if (al.equals("y")) {
				disease = disease +10;	
			}
			else if (al.equals("n")) {
				disease = disease + 0;
		//Cancer	
			
			} else if (c.equals("y")) {
				disease= disease +10;
			}else if (c.equals("n")) {
				disease= disease;
				
		//Diabetes		
			}else if (d.equals("n")) {
				disease = disease;
			} else if (d.equals("y")) {
				disease= disease +10;
			} 
			System.out.println(disease);
			} 
		} */
		
		//
	}
