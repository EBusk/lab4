import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FindWord{

  public static void main(String[] args){
  
    Scanner sc= new Scanner(System.in);
    /*Change to while loop*/
    while (true){
      /*Scan for user input*/
      
      String input = sc.nextLine(); 
      if(!validInput(input)){
        System.out.print("Input should be in the format: search <pattern> <file>");
      }else{
        FindWord fw = new FindWord();
        String pattern = fw.findPattern(input);
        String file = fw.findFile(input);
        fw.printLines(pattern, file);
        break;
      }
    }
    

  }

  /*Returns the pattern in the input the string*/
  public String findPattern(String s){
    String a[] =  s.split(" ", 3);
    return a[1];
  }

  public String findFile(String s){
    String a[] =  s.split(" ", 3);
    return a[2];
  }

  public void printLines(String pattern, String file){
    
    File f;
    Scanner s;
    try {
       f = new File(file);
       s = new Scanner(f);
    } catch (FileNotFoundException e){
      System.out.println("The file was not found!");
      return;
    }
    while (s.hasNextLine()){
      String line = s.nextLine();
      if(line.contains(pattern)){
        System.out.println(line);
      }
    }
    s.close();
  }

  public static boolean validInput(String input){
    String a[] =  input.split(" ");

    if(a.length != 3){
      return false;
    }

    if(!a[0].equals("search")){
      return false;
    };

    return true;
  }


}