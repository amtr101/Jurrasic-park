 
 /******************************************************8
 *   author: Amy Trevaskis (15129275) 
 *   Purpose: a class containing for reading in and creating a
 *   Jurassicpark object from a file. 
 ************************************************************/

import java.io.*; 

public class ReadFile 
 {
   //CLASS CONSTANT MAXSIZE
 
   private  int maxSize = 1000; 
   private   String fileName;

  
/******************
 *  DEFAULT CONSTRUCTOR
 *  IMPORT: nonE
 *  EXPORT: none
 *  ALGORTHM:
 *  *******************/ 

 public ReadFile()
  {
      maxSize = 1000; 
      fileName = "fileName.txt";  
      
      
  } 

/**********************
 *   ALTERNATE CONSTRUCTOR
 *   IMPORT: none
 *   EXPORT:none
 *   ALGORTHM:
 *  ********************/  
public ReadFile(String inFileName, int inMaxSize)
 {
     fileName = inFileName; 
     maxSize = inMaxSize; 
     
     
 }

/****************
 *  COPY CONSTRUCTOR
 *  IMPORT: none
 *  EXPORT: none
 *  ALGORTHM:
 * *******************/ 

public ReadFile(ReadFile inRead)
 {
     fileName = inRead.getName(); 
     maxSize = inRead.getSize(); 
     
 } 
 

/*****************
 *SUBMODULE: getName
 *IMPORT: none
 *EXPORT: none
 ******************/

public String getName()
 {
     return fileName; 
     
 } 


/*******************
 *SUBMODULE: getSize
 *IMPORT: none
 *EXPORT: none
 *******************/
public  int getSize()
{
    return maxSize; 
    
    
} 

 /******************8**
 *  SUBMODULE: ReadFile
 * IMPORT: none
 *EXPORT: none
 *****************/
  
public Dinosaur[][] ReadinDino()
{
    Dinosaur[][] dinoFile = null; 
    FileInputStream fileStrm = null;
    InputStreamReader rdr;
    BufferedReader bufRdr;
    int lineNum = 0; 
    String line; 
try 
{ 
  dinoFile = new Dinosaur[maxSize][1]; 
    rdr = new InputStreamReader(fileStrm); 
    bufRdr = new BufferedReader(rdr); 
    
    lineNum = 0; 
    line = bufRdr.readLine(); 

 for(int i = 0; i < dinoFile.length; i++)
   {
      String[] stringLine = processLine(line); 
      Dinosaur dinoSplit = processDinos(stringLine);
      dinoFile[i][0] = dinoSplit; 
      
      line = bufRdr.readLine(); 
   }

  }
catch(IOException e)
{
    if (fileStrm != null)
    System.out.println("error in file porcessing: " + e.getMessage());
}
 
return dinoFile; 
} 

 /***********************
 * SUBMODULE: processLine
 * IMPORT: line
 * EXPORT:DinoLine
 ********************/ 
public String[] processLine(String line)
{
   String[] DinoLine = line.split("(<) | (/>)");
   return DinoLine; 
    
} 

private Dinosaur processDinos(String[] stringLine)
{
   
 Dinosaur dino = null; 
 Genome genSeq = new Genome(); 
 boolean tailFin = true; 
 String type = stringLine[0]; 
 String name = stringLine[1];
 double mass = Double.parseDouble(stringLine[2]); 
 String seq = stringLine[3];
 Genome gen = new Genome(seq);


 if (stringLine[0]== "TRI")
   {
     int numHorns = Integer.parseInt(stringLine[4]);
     dino = new TRIClass(name, mass, numHorns, gen );
   } else if (stringLine[0]== "TREX")
     {    
       double biteForce = Double.parseDouble(stringLine[4]);
       dino = new TREXClass(name, mass, biteForce, gen);
      }
   else if (stringLine[0]== "PLESIO")
      {
        if (stringLine[4] =="TRUE")
           {
             tailFin = true;
            }
            else tailFin = false;
            dino = new PLESIOClass(name, mass, tailFin, gen);
              
        }
       
   return dino; 
   
   }
  
    
} 
  

     
       
    
   
   
  
    

 
