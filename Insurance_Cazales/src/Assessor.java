import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.runtime.Name;
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
            return "uninsurable";
        }
    }
	

	
	public InsuranceScore insuranceScore(Member member){
		ArrayList<InsuranceScore> insuranceScores = new ArrayList<InsuranceScore>();
		//for(Member member: members) {
			InsuranceScore insuranceScore = new InsuranceScore();
			//Initialize the counter.
			int result = 0;
			
			/*Age Calculations
			 *
			*/
			int age = member.getAge();
			if  (age <= 30 ) {
    			result += 0;
    		
    		} else if((age >= 29)&&(age <45 )){
    			result = 10;
    		
    		} else if ((age > 46 )&&(age < 60)) {
    			result +=20;
    		
    		} else {
    			result += 30;
    		}
			//Jay 20
	        
	        
			//Weight and height calculations
			//body-mass Index which is equal to a persons weight in kg divided by the height in meter
			//You have to convert lb to kg, therefore (w / 2.2)
			//Also inches to meters
			
			double newWeight, newHeight, scoreWeight;
	            newWeight = member.getWeight() / 2.2;
	            //Getting the Square
	            newHeight = (member.getHeight() * 0.0254 * member.getHeight()*0.0254);
	        	
	        	scoreWeight = (newWeight / newHeight);
	        	/*Normal 18.5-24.9
	        	 * Overweight 25.0-29.9
	        	 * 30-34.9
	        	 */
	        	
	        	if ((scoreWeight > 18.5)&&(scoreWeight < 24.9)) {
	        		result += 0;
	        		
	        	} else if ((scoreWeight > 25.0)&&(scoreWeight < 29.9)) {
	        		result += 30;
	        		
	        	}else  {
	        		result += 75;
	        		
	        }
	        //Jay =  47.40 ( + 75)
	        		        	
	        	

	        //BlodPresure calculations
	         double bpSyst, bpDias;
	    			 bpSyst = member.getBpSyst();
	    			 bpDias = member.getBpDias();
	    			 if ((bpSyst <=120) && (bpDias < 80)) {
	    				 //Normal
	    				 result += 0;
	    			 
	    			 }else if ((bpSyst > 120 && bpSyst < 129) && (bpDias < 80)) {
	    				 //Elevated
	    				 result += 15;
	    			 
	    			 } else if ((bpSyst >=130 && bpSyst <39) || (bpDias >=80  && bpDias < 89)) {
	    				 //HighBlood Pressure  Systolic Stage 1
	    				 result += 30;
	    				 
	    			 }else if ((bpSyst >=140 && bpSyst < 180)||(bpDias >=90 && bpDias < 120)) {
	    				 //Stage 2
	    				 result += 75;
	    			 
	    			 }else if ((bpSyst >180)||(bpDias >120)){
	    				 //Hypertensive crisis
	    				 result += 100;
	    			 }


	    			 //Jay= 15
	    		        
	    		        
	    		        
	    	//Diseases calculation		 
	    			 int disease;
	    				String al, c, d;
	    					al = member.getAlzheimers();
	    					//Alzheimers 
	    					if (al.equals("y"))  {
	    						result += 10;	
	    					}
	    					//Cancer
	    					c = member.getCancer();
	    					if (c.equals("y")) {
	    						result +=10;

	    					}
	    					//Diabetes
	    					d = member.getDiabetes();
	    					if (d.equals("y")) {
	    						result +=10;
	    				}

	    					String verdict = getScore(result);
	    					return new InsuranceScore(member.getLastName(),member.getFirstName(),result, verdict);
	            }
	    	//Creates an object 		 
			public ArrayList<InsuranceScore>  insuranceScore(ArrayList<Member>member){
				ArrayList<InsuranceScore> insuranceScore = new ArrayList<InsuranceScore>();
					for (Member members : member) {
						insuranceScore.add(insuranceScore(members));
					}
					return insuranceScore;
				}
			}
			
	
	
	
	
	
 	
    			
	



	

/*	
	//Calculations 
	public void getScores(ArrayList<Member>members) {
		ArrayList<InsuranceScore> insuranceScores = new ArrayList<InsuranceScore>();
		for(Member member: members) {
			InsuranceScore insuranceScore = new InsuranceScore();
			//Initialize the counter.
			int result = 0;
			
			//Age Calculations
			int age = member.getAge();
			if  (age <= 30 ) {
    			result += 0;
    		
    		} else if((age >= 29)&&(age <45 )){
    			result = 10;
    		
    		} else if ((age > 46 )&&(age < 60)) {
    			result +=20;
    		
    		} else {
    			result += 30;
    		}
			
			//Weight and height calculations
			double newWeight, newHeight, scoreWeight;
	            newWeight = member.getWeight()/ 2.205;	
	        	newHeight = member.getHeight()/ 39.37;
	        	scoreWeight = newWeight / newHeight;
	        	
	        	System.out.print("Weight"+ scoreWeight +"\n");
	        	
	        	if ((scoreWeight > 18.5)&&(scoreWeight < 24.9)) {
	        		result += 0;
	        		
	        	} else if ((scoreWeight > 25.0)&&(scoreWeight < 29.9)) {
	        		result += 30;
	        		
	        	}else  {
	        		result += 75;
	        		
	        }
	        
	        //BlodPresure calculations
	         double bpSyst, bpDias;
	    			 bpSyst = member.getBpSyst();
	    			 bpDias = member.getBpDias();
	    			 if ((bpSyst <=120) && (bpDias < 80)) {
	    				 //Normal
	    				 result += 0;
	    			 
	    			 }else if ((bpSyst > 120 && bpSyst < 129) && (bpDias < 80)) {
	    				 //Elevated
	    				 result += 15;
	    			 
	    			 } else if ((bpSyst >=130 && bpSyst <39) || (bpDias >=80  && bpDias < 89)) {
	    				 //HighBlood Pressure  Systolic Stage 1
	    				 result += 30;
	    				 
	    			 }else if ((bpSyst >=140 && bpSyst < 180)||(bpDias >=90 && bpDias < 120)) {
	    				 //Stage 2
	    				 result += 75;
	    			 
	    			 }else if ((bpSyst >180)||(bpDias >120)){
	    				 //Hypertensive crisis
	    				 result += 100;
	    			 }
	    	//Diseases calculation		 
	    			 int disease;
	    				String al, c, d;
	    					al = member.getAlzheimers();
	    					//Alzheimers 
	    					if (al.equals("y"))  {
	    						result += 10;	
	    					}
	    					//Cancer
	    					c = member.getCancer();
	    					if (c.equals("y")) {
	    						result +=10;

	    					}
	    					//Diabetes
	    					d = member.getDiabetes();
	    					if (d.equals("y")) {
	    						result +=10;
	    				}
	    			 
	    		//Setting the veredict based on the result	 
	    		insuranceScore.setResult(result);
	    		if (result <= 20) {
	                insuranceScore.setVerdict("low risk");
	            } else if ((result <= 50 )&& (result >=21)) {
	                insuranceScore.setVerdict("moderate risk");
	            } else if ((result <= 75)&&(result>51)) {
	                insuranceScore.setVerdict("high risk");
	            } else {
	                insuranceScore.setVerdict("unisurable");
	               
	             
	            }
	    			 
	    	 }
			
	        	
    	}
	
	
	
	
	public ArrayList<InsuranceScore> scoreInsurance(ArrayList<Member> members){
		ArrayList<InsuranceScore> insurance = new ArrayList<InsuranceScore>();
		for (Member mem : members) {
			insurance.add(scoreInsurance(mem));
		}
		return insurance;
	}
	
}
	
	
	
/*	
	
	
	
	
	
	
	
	
	
	//Attempting to do functions that do the calculations.
	
	
	public static double getAgeScore(ArrayList<Member>members) {
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
			return ageScore;
	    }
	 
	//This one is attempting to calculate the weight points.  83.90
		 
		public static void getBMIScore(ArrayList<Member>members) {
			double newWeight, newHeight, scoreWeight, bmiScore;
			for (Member member : members) {
	            newWeight = member.getWeight()/ 2.205;	
	        	newHeight = member.getHeight()/ 39.37;
	        	scoreWeight = newWeight / newHeight;
	        	System.out.print("Weight"+ scoreWeight +"\n");
	        	
	        	if ((scoreWeight > 18.5)&&(scoreWeight < 24.9)) {
	        		bmiScore = 0;
		        	System.out.print("Weight Score"+ bmiScore +"\n");
	
	        		
	        	} else if ((scoreWeight > 25.0)&&(scoreWeight < 29.9)) {
	        		bmiScore = 30;
		        	System.out.print("Weight Score"+ bmiScore +"\n");
	
	        		
	        	}else {
	        		bmiScore = 75;
		        	System.out.print("Over weight Weight Score"+ bmiScore +"\n");
	
	        		
	        	}
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
		 
}
public static void Result (int ageScore, int scoreWeight, int bloodPresureScore) {
	int result = ageScore + scoreWeight + bloodPresureScore;
}
	 
	 
public static void getDisease(ArrayList<Member>members) {
		int disease;
		String name;
		String al, c, d;

		for (Member member : members) {
			disease=0;

			name=member.getFirstName();
			al = member.getAlzheimers();
			//Alzheimers 
			if (al.equals("y"))  {
				disease += 10;	
			}
			//Cancer
			c = member.getCancer();
			if (c.equals("y")) {
				disease +=10;

			}
			//Diabetes
			d = member.getDiabetes();
			if (d.equals("y")) {
				disease +=10;

			}
			
		System.out.println(name+ " Scores"+disease);
		}
		
	}
}	

*/
		
		
	

