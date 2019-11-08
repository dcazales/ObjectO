import java.util.ArrayList;
 
public class Member {
    private String firstName,lastName, cancer, diabetes, alzheimers ;
    private int age, height, weight, bpSyst, bpDias;
    
    //private ArrayList<Integer> grades;
    
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
    public String getCancer() {
        return cancer;
    }
    public void setCancer(String cancer) {
        this.cancer = cancer;
    }
    public String getDiabetes() {
        return diabetes;
    }
    public void setDiabetes(String diabetes) {
        this.diabetes = diabetes;
    }
    public String getAlzheimers() {
        return alzheimers;
    }
    public void setAlzheimers(String alzheimers) {
        this.alzheimers = alzheimers;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getBpDias() {
        return bpDias;
    }
    public void setBpDias(int bpDias) {
        this.bpDias = bpDias;
    }
    public int getBpSyst() {
        return bpSyst;
    }
    public void setBpSyst(int bpSyst) {
        this.bpSyst = bpSyst;
    }
    /*public ArrayList<Integer> getGrades() {
        return grades;
    }
    public void setGrades(ArrayList<Integer> grades) {
        this.grades = grades;
    }*/
   
    /*
    public void setGrade(String gradeString) {
        gradeString = gradeString.trim();
        String[] parts = gradeString.split(" ");
        grades = new ArrayList<Integer>();
        for (String part : parts) {
            grades.add(Integer.parseInt(part));
        }
    }*/
    public Member() {
    	 firstName ="";
    	 lastName="";
         age= 0;
         height=0;
         weight=0;
         bpSyst=0;
         bpDias=0;
         cancer= "";
         diabetes="";
        alzheimers="";
    }
    
    
    public Member(String firstName, String lastName, int age, int height, int weight, 
    	int bpSyst, int bpDias, String cancer, String diabetes, String alzheimers) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setHeight(height);
        setWeight(weight);
        setBpSyst(bpSyst);
        setBpDias(bpDias);
        setCancer(cancer);
        setDiabetes(diabetes);
        setAlzheimers(alzheimers);
        
        
   
    }
   /*
    public String getGradesAsString() {
        String result = "";
        for (int grade : grades) {
            result = result + grade + " ";
        }
        result = result.trim();  // get rid of extra space
        return result;
    }
    */
    @Override
    public String toString() {
        return String.format(
        		
        		"%s, %s \n\n "
        		
        		+ "Age:		%d\n"
        		+ "Height:		%d\n"
        		+ "BP Syst:	%d\n"
        		+ "BP Dias:	%d\n"
        		+ "Cancer:		%s\n"
        		+ "Dianetes:	%s\n"
        		+ "Alzheimers:	%s\n"
        		+ "-----------------------------"
        		,lastName, firstName, height,weight,bpSyst, bpDias, cancer, diabetes, alzheimers);
        		}
        	
    
}