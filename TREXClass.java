/**********************************************************
 * File: TREXClass 
 * Author: Amy Trevaskis (15129275) 
 * Purpose: a container class storing information 
 *  regarding the Tyrannosaurus Rex type Dinosaur 
 *********************************************************/

public class TREXClass extends Dinosaur
 {
   //CLASS CONSTANTS: none 

   private double biteForce; 

/**************************
 * DEFAULT CONSTRUCTOR
 * IMPORT: none 
 * EXPORT: none
 * ALGORTHM:
 * ************************/

public TREXClass()
 {
   super(); 
   biteForce = 501.0;   
 } 

/*************************************
 * ALTERNATE CONSTRUCTOR
 * IMPORT: inBiteForce, inName, inMass
 * EXPORT: none
 * ALGORTHM:
 ***********************************/

public TREXClass(String inName, double inMass, double inBite, Genome inSequence)
 { 
  
  
    super(inName, inMass, inSequence); 

   if (validateBite(inBite)) 
     { 
      biteForce = inBite; 
     }
   else throw new IllegalArgumentException("invalid bite force value"); 
}

/*****************************
 * COPY CONSTRUCTOR
 * IMPORT: inTREX 
 * EXPORT: none
 * ALGORTHM: 
 * **************************/ 

public TREXClass(TREXClass inTREX)
{
  super(inTREX); 
  biteForce = inTREX.getBite(); 

}

//MUTATORS

/*****************************
 * SUBMODULE: setBite
 * IMPORT: inBiteForce 
 * EXPORT: none
 * ALGORTHM:
 * **************************/ 
public void setBite(double inBite)
 {
  if(validateBite(inBite))
  {
    biteForce = inBite; 
  }
 else 
 {
   throw new IllegalArgumentException("invalid bite force"); 
 }

} 

//ACCESSORS 

 public double getBite()
{
  return biteForce; 
}

/******************************
 * EQUALS
 * IMPORT: inObj
 * EXPORT: same
 * ALGORTHM:
 * *****************************/ 


public boolean equals (Object inObject)
{
  TREXClass inTREX; 
  boolean isEqual = false; 
  
  if (inObject instanceof TREXClass) 
   {
     inTREX = (TREXClass)inObject; 
      if (super.equals(inTREX) )
         if (biteForce == inTREX.getBite() )
       isEqual = true; 
  }
 return isEqual; 

}


/**********************
 * SUBMODULE: clone
 * IMPORT: none
 * EXPORT: TRIClass
 * ALGORTHM:
 * *****************/ 

@Override 
public TREXClass clone() 
 { 
   return new TREXClass(this); 
 }




 
/*********************
 * SUBMODULE: toString
 * IMPORT: none 
 * EXPORT: outString
 * ALGORTHM:
 * *********************/

public String toString() 
{
 String outString; 
 outString = (super.toString() + " " +  biteForce);   
  return outString; 
}

/********************
 * SUBMODULE: setBiteForce
 * IMPORT: inBiteForce
 * EXPORT: none 
 * ALGORTHM:
 * **********************/

public void setBiteForce( double inBiteForce)
{
 if (validateBite(inBiteForce)) 
 {
   biteForce = inBiteForce; 
 }

else 
 {
  throw new IllegalArgumentException("invalid biteForce"); 
 }

 }


 @Override 

public int calcEnclosureSize() 
 {
  double enclosure = (Math.log(super.getMass())/Math.log(2)) * biteForce * 10.0;   
  return (int)enclosure; 

} 



//PRIVATE SUBMODULE

/************************
 * SUBMODULE: validateBite
 * IMPORT: inBiteForce
 * EXPORT: valid 
 * *********************/ 

private boolean validateBite(double inBiteForce)
 {
  return (inBiteForce > 500.5); 
  }

}     
