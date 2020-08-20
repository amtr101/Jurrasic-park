/**********************************************************
 * File: PLESIOClass
 *Author: Amy Trevaskis (15129275) 
 *Purpose: a container class storing information 
 *  regarding the Plesiosaurus  type Dinosaur 
 *********************************************************/

public class PLESIOClass extends Dinosaur 
 {
   //CLASS CONSTANTS: none
   private boolean hasTailFinn; 

/**********************
 *DEFAULT CONSTRUCTOR
 *IMPORT: none 
 *EXPORT: none 
 **********************/

public PLESIOClass()
 {
  super(); 
  hasTailFinn = true; 

 }

/**************************************************
 * ALTERNATE CONSTRUCTOR
 * IMPORT: inHasTailFinn, inName, inMass, inSequence
 * EXPORT: none
 * ************************************************/  

public PLESIOClass(String inName, double inMass, boolean inHasTailFinn,Genome inSequence)
 {
  super(inName, inMass, inSequence);  

  if (validateTail(inHasTailFinn)) 
    { 
      hasTailFinn = inHasTailFinn; 
    }
  else throw new IllegalArgumentException("invalid Tail finn value"); 

}

/*****************************
 * COPY CONSTRUCTOR
 * IMPORT: inPLES
 * EXPORT: none
 * ************************/  

public PLESIOClass(PLESIOClass inPLES) 
 {
   super(inPLES); 
   hasTailFinn = inPLES.getTailFinn(); 

 } 

/***********
 * MUTATORS*
 * ********/

public boolean getTailFinn()
 {
  return hasTailFinn; 
 }

/*********************
 * SUBMODULE: equals 
 * IMPORT: inObject
 * EXPORT: isEqual
 * ********************/

public boolean equals (Object inObject)
 {
   PLESIOClass inPLES; 
   boolean  isEqual = false; 

 if (inObject instanceof PLESIOClass)
  {
    inPLES = (PLESIOClass)inObject; 
    if (super.equals(inPLES) )
       if (hasTailFinn == inPLES.getTailFinn())
    isEqual = true; 
  }
 return isEqual; 

  }  

/******************
 * SUBMODULE: clone
 * IMPORT: none
 * EXPORT: PLESIOclass
 * ******************/ 

@Override 
public PLESIOClass clone()
{
  return new PLESIOClass(this); 
}

 /**********************
 * SUBMODULE: toString
 * IMPORT: none
 * EXPORT: outString
 * *********************/ 
  
public String toString()
{
 String outString; 
 outString  = (super.toString() + " " + hasTailFinn);  
 return outString; 
 
}

/************************
 * SUBMODULE: setHasTailFinn
 * IMPORT: inHasTailFinn
 * EXPORT: none
 *********************** */
 
 
public void setHasTailFinn(boolean inHasTailFinn)
 { 
   if (validateTail(inHasTailFinn)) 
   {
    hasTailFinn = inHasTailFinn;
   }
 }

/*************************** 
 * PRIVATE SUBMODULE: validateTail
 * IMPORT: inHasTailFinn
 * EXPORT: valid
 * *********************/ 

private boolean validateTail(boolean inHasTailFinn)
 {
   return (inHasTailFinn = true) ||( inHasTailFinn = false);
 }

/*********************
 * SUBMODULE: calcEclosureSize 
 * IMPORT: mass 
 * EXPORT: enclosure
 * **********************/ 

@Override

public  int calcEnclosureSize()
 {
  double enclosure = super.getMass() * Math.PI * Math.pow(10, 3); 
  return (int)enclosure;  
 }

} 

 
