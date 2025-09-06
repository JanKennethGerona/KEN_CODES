public class Test {

    public static void main(String args[]){
    	CollegeStudent cs = new CollegeStudent("Cruz","Tom", new MyDate(2014, 6, 1));
    	
    	System.out.println("----------------------------------------------------------------------");
    	System.out.println("Student's Name		: " + cs.getLastname() + ", " + cs.getFirstname());
    	System.out.println("Enrollment Date		: " + cs.getEnrollmentDate().dateToString() );
    	System.out.println("Expected Graduation : " + cs.getGraduationDate().dateToString() + "\n" );
    	
    	cs.setLastname("Sta Cruz");
    	cs.setFirstname("Tom Jones");
    	cs.setEnrollmentDate(new MyDate(2015, 6, 1));
    	cs.setGraduationDate(new MyDate(2019, 3, 28));
    	
    	System.out.println("----------------------------------------------------------------------");
    	System.out.println("Student's Name		: " + cs.getLastname() + ", " + cs.getFirstname());
    	System.out.println("Enrollment Date		: " + cs.getEnrollmentDate().dateToString() );
    	System.out.println("Expected Graduation : " + cs.getGraduationDate().dateToString() + "\n" );


    	cs.setLastname("Reyes");
    	cs.setFirstname("Jimmy");
    	cs.getEnrollmentDate().setYear(2018);
    	cs.getEnrollmentDate().setMonth(11);
    	cs.getEnrollmentDate().setDay(31);
    	
    	cs.getGraduationDate().setYear(2023);
    	cs.getGraduationDate().setMonth(3);
    	cs.getGraduationDate().setDay(32);
    	
    	
    	System.out.println("----------------------------------------------------------------------");
    	System.out.println("Student's Name		: " + cs.getLastname() + ", " + cs.getFirstname());
    	System.out.println("Enrollment Date		: " + cs.getEnrollmentDate().dateToString() );
    	System.out.println("Expected Graduation : " + cs.getGraduationDate().dateToString() + "\n" );
    	
    }
    
}