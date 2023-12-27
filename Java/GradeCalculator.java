import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of subjects:");
        int numberOfSubjects = scanner.nextInt();

        int sum = 0;
        String grade;
        int[] marksObtained = new int[numberOfSubjects];
        System.out.println("Enter marks obtained out of (100).");
        for(int i = 0; i < numberOfSubjects; i++ ){
            marksObtained[i]  = scanner.nextInt();
            // calculating the total marks obtained
            sum  = sum + marksObtained[i];
        }
        // getting average
        int averagePercentage = sum / numberOfSubjects;
        // Grade calculation
        if (averagePercentage >= 85){
            grade = "A";
            System.out.println("Distinction, you have => " + grade);
        }
        else if(averagePercentage >=70){
            grade = "B";
            System.out.println("Excellent, you have => " + grade);
        }
        else if(averagePercentage >= 50){
            grade ="C";
            System.out.println("Passed, you have => " + grade);
        }
        else if(averagePercentage >= 40){
            grade = "D";
            System.out.println("Can do better, you have => " + grade);
        }else {
            System.out.println("You have failed");
        }
        System.out.println("Total marks obtained = "+ sum + " marks");
        System.out.println("Average percentage = " + averagePercentage + "%" );
    }
}
