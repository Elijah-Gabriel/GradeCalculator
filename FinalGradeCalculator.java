import java.util.Scanner;
import java.io.*;

public class FinalGradeCalculator {

 public static void main(String[] args) {
  // TODO Auto-generated method stub

  System.out.println("Welcome to the Final Grade Calculator");
  Scanner kb = new Scanner(System.in);
  System.out.println("Enter the file name to read grades from");
  String fileName = kb.nextLine();
  
  //count number of each instance of lab,homework,exam and extra credit
  int labCount = 0;
  int homeworkCount = -1; //drops lowest grade by making it out of one less assignment
  
  //sum the values of each lab, homework, exam and extra credit
  double labSum = 0;
  double homeworkSum = 0;
  double examOneSum = 0;
  double examTwoSum = 0;
  double labExamOneSum = 0;
  double labExamTwoSum = 0;
  double finalExamSum = 0;
  double extraCreditSum = 0;
  
  int nextLine = 0;
  
  //read from file 
  try
  {
   Scanner fileScanner = new Scanner(new File(fileName));
   while (fileScanner.hasNextLine())
   {
    String inputLine=fileScanner.nextLine().toUpperCase();
    if (inputLine.equals("LABS"))
    {
     nextLine = 1;
    }
    else if(inputLine.equals("HOMEWORK"))
    {
     nextLine = 2;
    }
    else if(inputLine.equals("EXAM 1"))
    {
     nextLine = 3;
    }
    else if(inputLine.equals("EXAM 2"))
    {
     nextLine = 4;
    }
    else if(inputLine.equals("LAB EXAM 1"))
    {
     nextLine = 5;
    }
    else if(inputLine.equals("LAB EXAM 2"))
    {
     nextLine = 6;
    }
    else if(inputLine.equals("FINAL"))
    {
     nextLine = 7;
    }
    else if(inputLine.equals("EXTRA CREDIT"))
    {
     nextLine = 8;
    }
    else 
    {
     double score = Double.parseDouble(inputLine); //take in the next grade value 
     switch (nextLine) //switch based on what type of grade it is lab, hw, exam, or extra
     {
      case 1: //labs
       labSum += score;
       labCount++;
       break;
      case 2: //homework
       homeworkSum+= score;
       homeworkCount++;
       break;
      case 3: //exam one
       examOneSum += score;
       break;
      case 4: //exam two
       examTwoSum += score;
       break;
      case 5: //lab exam one
       labExamOneSum +=score;
       break;
      case 6: //lab exam two
       labExamTwoSum += score;
       break;
      case 7: //final exam 
       finalExamSum += score;
       break;
      case 8: //extra credit
       extraCreditSum += score;
       break;
      default:
       System.out.println("error line 118");
       break;
     }
    }
   }
   
  }
  catch(Exception e)
  {
   System.out.println(e.getMessage());
  }
  
  //perform mathematical operations to calculate 
  double labGrade = (labSum/labCount);
  double homeworkGrade = (homeworkSum/homeworkCount);
  double examGrade =((examOneSum)+(examTwoSum)+(labExamOneSum)
    +(labExamTwoSum)+(finalExamSum));
  double extraCreditGrade = (extraCreditSum);
  //add percentages of each grade here
  double theGrade = ((labGrade*.2)+(homeworkGrade*.3)+(examGrade*.1)+(extraCreditGrade*.02));
  int finalGrade = (int) Math.round(theGrade);
  
  //print info to console 
  System.out.println("Your lab average is: "+labGrade+
    "\nYour homework average is: "+homeworkGrade+
    "\nYour first exam is: "+ examOneSum+
    "\nYour second exam is: "+ examTwoSum+
    "\nYour first lab exam is: "+ labExamOneSum+
    "\nYour second lab exam is: "+ labExamTwoSum+
    "\nYour final exam is: "+ finalExamSum+
    "\nYour extra credit is: "+extraCreditGrade*.02+
    "\nYour raw total is: "+finalGrade);
  
  //print letter grade from final grade 
  if(finalGrade>=90)
  {
   System.out.println("Your final grade is an A"); //a range 90-100
  }
  else if (finalGrade<=89 && finalGrade>=80)
  {
   System.out.println("Your final grade is a B"); //b range 80-89
  }
  else if(finalGrade<=79 && finalGrade>=70)
  {
   System.out.println("Your final grade is a C"); //c range 70-79
  }
  else if(finalGrade<=69 && finalGrade>=60)
  {
   System.out.println("Your final grade is a D");//d range 69-70
  }
  else 
  {
   System.out.println("Your final grade is an F"); //f range lower than 69
  }
 }

}