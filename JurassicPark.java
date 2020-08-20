 /************************************************************
 * File: JurassicPark 
 * author: Amy Trevaskis (15129275) 
 * Purpose: a class containing information about
 *            a "Jurassic park" including an array of dinosaur objects 
 ***************************************************************/ 

public class JurassicPark 
{
  private Dinosaur[][] dinosaurs; 
  private boolean constructed; 
  private int count; 

/*******************
 *DEFAULT CONSTRUCTOR
 *IMPORT: none 
 *EXPORT: none
 *ALGOTHM:
 ***********************/

public JurassicPark()
 {    
   dinosaurs = new Dinosaur[100][1]; 
   constructed = true; 
   count = 0; 
     
 } 

 /****************************************
 * ALTERNATE CONSTRUTOR
 * IMPORT: Dinosaurs, inConstructed, inCount 
 * EXPORT: none 
 * ALGORTHM:
 * **************************************/ 
public JurassicPark(boolean inConstructed, int inCount, Dinosaur[][] inDino )
 {
    dinosaurs = inDino; 
    constructed = inConstructed; 
    count = inCount; 
     
 }  

/*******************
 *COPY CONSTRUCTOR
 *IMPORT: none 
 *EXPORT: none 
 *ALGORHTM:
 ****************/  

public JurassicPark(JurassicPark inPark)
 {
    dinosaurs = inPark.getDino();   
    constructed = inPark.getConstruct();
    count = inPark.getCount(); 
 
     
 } 


//MUTATORS


 /*****************************
 * SUBMODULE: setDinosarus 
 * IMPORT: inDinosuars 
 * EXPORT: none 
 * ALGORTHM:
 *************************/ 

public void setDinosaurs(Dinosaur inDino)
{
  if (validateDino(inDino))
   {
       dinosaurs[getCount()][0] = inDino; 
       count += 1; 
       
   }
   else 
   {
       throw new IllegalArgumentException("invalid dinosuars");
   }    
}  

/**********************
 *SUBMODULE: getDino
 *IMPORT: none
 *EXPORT: none
 *ALGORTHM
 *************************/ 

public Dinosaur[][] getDino()
{

 return dinosaurs;  
} 

/****************************
 * SUBMODULE: setConstructed 
 * IMPORT: inConstructed 
 * EXPORT: none 
 * ALGOTHM:
 *************************/ 

public void setConstructed(boolean inConstruct)
{ 
   if(validateConstruct(inConstruct))
   {
       constructed = inConstruct; 
   }
   else 
   {
       throw new IllegalArgumentException("invalid value"); 
   }
    } 

/*************************
 *SUBMODULE: getConstruct
 *IMPORT:none
 *EXPORT:none
 *ALGORTHM:
 ************************/ 

public boolean getConstruct()
 {
    return constructed; 
    
 } 

 /**********************
 * SUBMODULE: setCount
 * IMPORT: inCount
 * EXPORT: nonea
 * ALGORTHM:
 ***********************/

public void setCount(int inCount)
{
   if (validateCount(inCount))
   {
       count = inCount;
   }
  
   else 
   {
       throw new IllegalArgumentException("invalid count value"); 
   }
 } 

/*************************
 *SUBMODULE: getCount
 *IMPORT: none
 *EXPORT: none
 *ALGORTHM:
 ****************/

public int getCount()
{
  return count; 
    
}
     
/**************************
 *SUBMODULE EQUALS:
 *IMPORT: inObject 
 *EXPORT: none 
 *ALGORTHM:
 ********************/
public boolean equals(Object inObject)
{  
    JurassicPark inPark; 
    boolean isEqual = false; 
    
    if (inObject instanceof JurassicPark)
    {
        inPark = (JurassicPark)inObject; 
        if (constructed == inPark.getConstruct())
            if (count == inPark.getCount()) 
               isEqual = true;  
    }  
    return isEqual;  
} 

 /************************
 * SUBMODULE: clone
 * IMPORT: none
 * EXPORT: JurassicPark
 * ALGORTHM:
 *******************/ 
public JurassicPark clone() 
{
    return new JurassicPark(this); 
 }      

/**********************
 *SUBMODULE: toString
 *IMPORT:none
 *EXPORT: outString
 *******************/ 

public String toString()
{
   String outString; 
   
   outString = count + " " + constructed; 
   return outString; 
 }      

//PRIVATE VALIDATION SUBMODULES


private boolean  validateDino(Dinosaur inDinosaurs)
{
    boolean valid; 
    valid = (inDinosaurs != null);
    return valid; 
            
} 


private boolean  validateCount(int inCount)
{
    boolean valid; 
    valid = (inCount > 0);
    return valid;     
    
}  


private boolean validateConstruct(boolean inConstruct)
{
    boolean valid; 
    valid = (inConstruct = true) || (inConstruct = false);
    return valid; 
}


  } 
