/**********************************************************
 *File: TRIClass
 *Author: Amy Trevaskis (15129275) 
 *Purpose: a container class storing information 
 * regarding the Triceratops type Dinosaur 
 *********************************************************/

public class TRIClass extends Dinosaur 
 { 
   private int numHorns; 

/***********************
 * DEFAULT CONTRUCTOR
 * IMPORT: none
 * EXPORT: none
 * ALGORTHM:
 * ********************/ 

public TRIClass() 
 {
  super(); 
  numHorns = 3; 
 } 

/***************************
 * ALTERNATE CONSTRUCTOR 
 * IMPORT: inNumHorns, inName, inMass
 * EXPORT: none 
 * ALGORTHM:
 * ************************/ 

public TRIClass(String inName, double inMass,int inNumHorns, Genome inSequence)
 {
   super(inName, inMass, inSequence);   
  
 if (validateHorns(inNumHorns)) 
   {
    numHorns = inNumHorns; 
   } 
 else throw new IllegalArgumentException("invalid number of horns"); 

}

/***************************
 * COPY CONSTRUCTOR 
 * IMPORT: inTRI
 * EXPORT: none 
 * ALGORTHM:
 * ***************************/ 

public TRIClass (TRIClass inTRI) 
 { 
   super(inTRI); 
   numHorns = inTRI.getNumHorns(); 
 }

//MUTATORS

/***********************
 * SUBMODULE: setNumHorns
 * IMPORTl: inNumHorns 
 * EXPORT:none
 * ALGORTHM:
 * **********************/ 

public void setNumHorns(int inNumHorns) 
 {
  if (validateHorns(inNumHorns)) 
   {
     numHorns = inNumHorns; 
   } 
 else 
 {
  throw new IllegalArgumentException("invalid number of hrons"); 
 } 
} 

//ACCESORS 

public int getNumHorns() 
 {
  return numHorns; 
} 

/********************
 * EUQALS 
 * IMPORT: inObj 
 * EXPORT: same 
 * ALGORTHM:
 * *******************/ 

public boolean equals(Object inObject) 
 { 
  TRIClass inTRI;
  boolean  isEqual = false; 

 if (inObject instanceof  TRIClass) 
 {
  inTRI = (TRIClass)inObject; 
   if (super.equals(inTRI))
     if (numHorns == inTRI.getNumHorns() ) 
  isEqual = true;   
 }
 return isEqual; 
} 

/******************
 * SUBMODULE: clone
 * IMPORT: none
 * EXPORT: TRIClass
 * *******************/ 
@Override 

public TRIClass clone() 
 {
  return new TRIClass(this); 
 } 



  
/**********************
 * SUNMODULE:toString
 * IMPORT: none 
 * EXPORT: outString
 * ALGOETHM: 
 * *******************/ 

public String toString() 
 { 
  String outString; 
  outString = (super.toString() + " " + numHorns); 
  return outString; 
 } 

@Override 

public int calcEnclosureSize() 
 {
  double enclosure = super.getMass() * 5.5 * Math.pow(4, numHorns); 
  return (int)enclosure;   
 } 

//PRIVATE SUBMODULE

/*******************
 * SUBMODULE: validateHorns
 * IMPORT: inNumHorns
 * EXPORT: valid
 * **********************/ 

private boolean validateHorns(int inNumHorns) 
 { 
  return (inNumHorns >= 3 && (inNumHorns % 3) == 0); 
 } 

} 

