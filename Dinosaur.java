/**********************************************************
 * File: Dinosaur 
 * Author: Amy Trevaskis (15129275) 
 * Purpose: an abstract class which all Dinosaur types inhereit from 
 ********************************************************/


public abstract class Dinosaur
{
   private String name; 
   private double mass;
   private Genome sequence; //Genome is agregated 

/********************
 * DEFAULT CONSTRUCTOR
 * IMPORT: none 
 * EXPORT: none 
 * ALGORTHM
 * ******************/ 

public Dinosaur()
 {
   name = "jerry"; 
   mass = 550.5;
   sequence = new Genome();     
 } 

/***********************************
 *  ALTERNATE CONSTRUCTOR 
 *  IMPORT: inName, inMass, inSequence   
 *  EXPORT:NONE 
 *  ALGORTHM:
 * *********************************/ 

public Dinosaur(String inName, double inMass, Genome inSequence )  
 {
    if (validateName(inName) && validateMass(inMass))
    {
      name = inName; 
      mass = inMass; 
      sequence = new Genome(inSequence); 
    } 
  else 
    {
        throw new IllegalArgumentException("invalid imports");
    } 
}

/**********************
 * COPY CONSTRUCTOR
 * IMPORT: inDino
 * EXPORT: none
 * ALGORTHM
 * ********************/ 

public Dinosaur(Dinosaur inDino) 
{
  name = inDino.getName(); 
  mass = inDino.getMass(); 
    
} 

/*********************
 * SUBMODULE: setName
 * IMPORT: inName
 * EXPORT: none 
 * ALGORTHM
 * *****************/ 

public void setName(String inName)
{
  name = inName; 
    
} 

/****************
 * SUBMODULE: setMass
 * IMPORT: inMass
 * EXPORT: none 
 * ALGORTHM
 * *******************/ 

      
public void setMass(double inMass) 
 {
  mass = inMass; 
    
} 

/***************
 * SUBMODULE: getName
 * IMPORT: none
 * EXPORT: name 
 * ALGORTHM: 
 * ***************/ 

public String getName()
{
  return name; 
}  

/***************
 * SUBMODULE: getMass
 * IMPORT: none
 * EXPORT: name 
 * ALGORTHM: 
 * ***************/
public double getMass()
{
    return mass; 
} 

/***************
 * SUBMODULE: EQUALS
 * IMPORT: inObject
 * EXPORT: same
 * ALGORTHM:
 * *******************/ 
public boolean equals (Object inObject)
{
   boolean same = false; 
   if (inObject instanceof Dinosaur)
   {
     Dinosaur inDino = (Dinosaur)inObject;
     same = name.equals(inDino.getName());
     mass =(inDino.getMass());         
   }
   return same; 
   
 }

 public String toString() 
 {
   String outString = (name + " " + mass); 
   return outString; 

     
 } 


//PRIVATE SUBMODULES:

/*********************
 * SUBMODULE: validateName 
 * IMPORT: inName
 * EXPORT: valid
 * ALGORTHMM
 * **********************/ 




private boolean  validateName (String inName)
{
 boolean valid = (inName != null); 
 return valid; 
    
} 

private boolean validateMass(double inMass)
 {
  boolean valid = (inMass > 0);
  return valid; 
    
    
 }

//ABSTRACT METHODS

public abstract int calcEnclosureSize();

public abstract Dinosaur clone(); 

}
