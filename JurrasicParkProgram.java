import java.util.*; 

/*******************************************************
 * File: JurassicParkProgram
 * Author: Amy Trevaskis (15129275) 
 * Purpose: the main class for managing JurrassicPark
 *********************************************************/


public class JurrasicParkProgram
{
 public static void main (String [] args) 
 { 
  //calls the main selection menu
  mainMenu();

 }

/****************************
 * SUBMODULE: mainMenu
 * IMPORT: none
 * EXPORT: none
 * ALGORTHM: 
 * **************************/ 

public static void mainMenu()
 { 
   System.out.println("welcome to the Jurrasic Park, please select an option");
   JurassicPark thePark = new JurassicPark();  
   int option; 

 do 
 { 

   System.out.println("Add dinosuar (1)");
   System.out.println("display dinosuars (2)");
   System.out.println("calculate park size (3)"); 
   System.out.println("Read in a jurrassic park file (4)"); 
   System.out.println("Write out to jurrasic park file (5)"); 
   System.out.println("Exit(6)"); 
   option = validateInt(); 

   switch (option) 
   { 
     case 1: 
           createDino(thePark);
           System.out.println(thePark.getCount() + " Dinosaurs added");  
         break; 
       case 2: 
           outDinos(thePark); 
        break; 
       case 3: 
           calcPark(thePark); 
        break; 
       case 4: 
           thePark = readIn(); 
        break; 
       case 5: 
           System.out.println("write out");
        break; 
       case 6: 
           System.out.println("exit");
         break;   
     }

  } while (option != 6);  
}

/*******************
 * SUBMODULE: createDino 
 * IMPORT: bob
 * EXPORT: bob
 * ALGORTHM:
 * **********************/ 

public static void createDino(JurassicPark thePark)
 {
  System.out.println("what is the name of your dinosaur?");
  String dinoName = inputString(); 
  System.out.println("what is " + dinoName + "'s mass?"); 
  double mass = inputReal(); 
  System.out.println("what is " + dinoName + "'s Gene sequence?"); 
  String seq = inputString();
  Genome geneSeq = new Genome(seq); 
  System.out.println("what kind of Dinosaur is " + dinoName +"?"); 
  System.out.println("(1) Tyrannosaurus rex");
  System.out.println("(2) Plesiosaurus");
  System.out.println("(3) Triceratops");
  int type = validateType(); 

  switch (type) 
  { 
     case 1: 
        System.out.println("what is "+ dinoName +"'s bite force?"); 
        double inBite = inputReal();
        thePark.setDinosaurs(new TREXClass(dinoName, mass, inBite, geneSeq)); 
     break; 
     case 2:
        System.out.println("does "+ dinoName +" have a Tail Finn? (1) yes, (2) no");
        boolean tail = yesNo(); 
        thePark.setDinosaurs(new PLESIOClass(dinoName, mass, tail, geneSeq)); 
     break; 
     case 3: 
         System.out.println("how many horns does "+ dinoName + "have?"); 
         int horns = inputInt();
         thePark.setDinosaurs(new TRIClass(dinoName, mass, horns, geneSeq)); 
       break;   
}
 
}


/*********************
 *SUBMODULE outDino
 *IMPORT:none
 *EXPORT: none
 *ALGORTHM:
 ********************/
public static void outDinos(JurassicPark thePark)
{
  Dinosaur[][] output = thePark.getDino(); 
    for (int i = 0; i < thePark.getCount(); i++)
    {
       if(output[i][0] != null)
       System.out.println(i +"\n" + output[i][0].toString() + "\n" );
                
     }
    
}

 /***************
 * SUBMODULE: readIn
 * IMPORT:none
 * EXPORT:none
 *  ALGORTHM:
 * ****************/

public static JurassicPark readIn()
{  
   boolean constructed = true;
   int count = 1000; 
   Dinosaur[][] dinos; 
   String fileName;
   ReadFile filRdr; 

   System.out.println("please enter name of file"); 
   fileName = inputString(); 
   filRdr = new ReadFile(fileName, 1000); 
   dinos = filRdr.ReadinDino(); 
   
   JurassicPark filePark = new JurassicPark(constructed, count, dinos);
   return filePark; 
   
 } 






 /**********************
 * SUBMODULE: calcPark
 * IMPORT:none
 * EXPORT:none
 * ALGORTHM:
 ******************/

public static void calcPark(JurassicPark thePark)
{
    int totalSize = 0; 
    Dinosaur[][] enclosure = thePark.getDino(); 
    
    for (int i = 0; i < thePark.getCount(); i++)
    {
        if(enclosure[i][0] != null)
        totalSize = enclosure[i][0].calcEnclosureSize(); 
        totalSize = totalSize + totalSize;  
    }
   System.out.println("Total size of the park is " + totalSize);   
    
}  


/*****************
 * SUBMODULE: inputInt
 * IMPORT: none
 * EXPORT: 
 ***************/

public static int inputInt()
{
    Scanner sc = new Scanner(System.in); 
    int value = 0; 
    
  try 
    {
        value = sc.nextInt(); 
    } 
  catch (InputMismatchException e)
  {
      System.out.println("invalid input"); 
  }
return value;     
} 

/*****************
 *SUBMODULE: yesNo
 *IMPORT: none
 *EXPORT: tail
 *ALGORTHM:
 *******************/ 
public static boolean yesNo()
{
    Scanner sc = new Scanner(System.in); 
    int select = sc.nextInt(); 
    boolean tail = true; 
    
  if (select == 1)
  {
      tail = true; 
  }
  else if (select == 2)
  {
      tail = false; 
  }
 return tail;    
} 





 /**************************
 * SUBMODULE: validateInt
 * IMPORT: none
 * EXPORT: input
 * ALGORTHM: 
 * *************************/ 

public static int validateInt()
{ 
  int input = 0; 
  try 
  {

    Scanner sc = new Scanner(System.in); 
    input = sc.nextInt();
    
    while (input < 1 || input > 6)
    {
        System.out.println("invalid input, try again"); 
        input = sc.nextInt(); 
    }
   }
   catch (InputMismatchException e)
   {
     System.out.println("invalid input,"); 
    }  
   
  return input;  

  }

 /***************************
 * SUBMODULE: inputString
 * IMPORT: none
 * EXPORT: value
 ******************/

public static String inputString()
{
    String value = " "; 
    
 try 
 {   
   Scanner sc = new Scanner(System.in); 
   value = sc.next(); 
 }
catch (InputMismatchException e) 
{
    System.out.println("invalid input");
 }
    
 return value; 
} 

/********************
 *SUBMODULE: inputReal
 *IMPORT: none
 *EXPORT: value
 *****************/
public static double inputReal()
{
    Scanner sc = new Scanner(System.in); 
    double value = 0; 
 
try 
{
    value = sc.nextDouble(); 
    
} 

catch (InputMismatchException a)
{
    System.out.println("invalid input");
}
 return value;     
} 

 /*************************
 * SUBMODULE: validateType
 * IMPORT: none
 * EXPORT: none
 * ALGOTHM:
 ***********************/

public static int validateType()
{
    Scanner sc = new Scanner(System.in); 
    int input = 0; 
 try 
 { 
   input = sc.nextInt(); 
    
  while (input < 1 || input > 3)
   {
       System.out.println("invalid input, try again"); 
       input = sc.nextInt(); 
    }
  } 
 catch (InputMismatchException e)
   {
     System.out.println("invalid input,"); 
    }  
 return input; 
    
}  



}
