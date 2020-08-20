 /************************************************************   
 * File: Genome  
 * author: Amy Trevaskis (15129275) 
 * Purpose: a class containing information about
 *           a Dinosaurs Genome. Aggregates with abstract class
 *             Dinosaur. 
 * ********************************************************/

public class Genome 
 {
  //CLASS CONSTANTS: none 
   private String sequence; 
   
/********************
 * DEFAULT CONSTRUCTOR
 * IMPORT: none
 * EXPORT: none
 * ALGORTHM:
 * ******************/                     
  
public Genome()
 {
   sequence = "AAA"; 
 }    

 /*****************
 * ALTERNATE CONSTRUCTOR
 * IMPORT: inSequence
 * EXPORT: none
 * ALGORTHM:
 *******************/   

public Genome(String inSequence)
 {
  if (validateGene(inSequence))
      {
        sequence = inSequence; 
      }
      else throw new IllegalArgumentException("invalid sequence value");
} 

/*******************
 * COPY CONSTRUCTOR
 *IMPORT: inGenome
 *EXPORT: none
 *ALGORTHM:
 *******************/ 
   
public Genome(Genome inGenome)
  {
      sequence = inGenome.getGene(); 
      
  } 

/***********************
 *SUBMODULE: setSequence
 *IMPORT: inSequence
 *EXPORT: none
 *ALGORTHM: 
 **********************/
  
public void setSequence(String inSequence)
  {
    if(validateGene(inSequence))
    {
       sequence = inSequence; 
    }
   else 
   {
     throw new IllegalArgumentException("invalid sequence value");
     }
      
 } 


//ACCESSORS 

public String getGene()
 {
   return sequence; 
 }      


  
 /*********************
 * EQUALS
 * IMPORT: inObj 
 * EXPORT: same
 * ALGORTHM:
 * *****************/ 

public boolean equals (Object inObject)
{
  Genome inGene; 
  boolean isEqual = false; 

if (inObject instanceof Genome)
 {
   inGene = (Genome)inObject;
    if (sequence == inGene.getGene())
        isEqual = true; 
    }
  return isEqual;   
    
}  


/*****************
 *SUBMODULE: clone
 *IMPORT: none
 *EXPORT: Genome
 *ALGORTHM
 ******************/
 
public Genome clone()
{
   Genome geneClone = new Genome(this);  
   return geneClone;  
    
} 

/*******************
 * SUBMODULE:toString
 * IMPORT:none
 * EXPORT: outString
 * ALGORTHM:
 ******************/ 
public String toString()
{
  String outString; 
  outString = (sequence + " ");
  return outString; 
    
} 

//PRIVATE SUBMODULES

/************************
 * SUBMODULE: validateGene
 * IMPORT: inSequence
 * EXPORT: valida
 ***********************/


private boolean  validateGene(String inSequence)
{
  boolean valid = true; 
  for (int i = 0; i < inSequence.length(); i ++)
    {
     if (inSequence.charAt(i) != 'A')
        if (inSequence.charAt(i) != 'G')
           if (inSequence.charAt(i) != 'T')  
             if (inSequence.charAt(i) != 'C')
             {
            
             valid = false; 
            }
    }
return valid; 

   }
}
