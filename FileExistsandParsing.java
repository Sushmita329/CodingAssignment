/*
Question 1:
----------

There is a file containing a word and its possible meanings (like a Dictionary). The contents of the file look like this:

Apple – a fruit, a tech firm
Table – an object, contains rows and columns when used in context of computers
Orange – a fruit

Given a path to the file, do the following:

a)    Create a method called doesFileExist(String path) which takes the path of the file and tells the user if the file exists at that path or not. Assume all paths are relative to your project structure. If the file does not exist, catch the requisite exception.
b)    Read each word and its possible meanings and print them out. Your output should look like this:

Word1
Meaning 1
Meaning 2
Word2
Meaning1
Meaning2

Use appropriate data structures wherever necessary.
 */

import java.io.*;
public class FileExistsAndParsing {
static String WorkingDirectory;

/*since we are running it directly from eclipse to make it easy, we are expecting the file to be present in the 
current working directory and we check for it */
//creating the doesFileExist function as static so that we can run the function without instantiating the class
static public boolean doesFileExist() 
{
//Get the current working directory. user.dir gets the path to the folder where the process was launched
WorkingDirectory =  System.getProperty("user.dir");
System.out.println("Working Directory = " +WorkingDirectory);
//check if a .txt file is present in the folder or not
//looking for input file called programinput.txt
// double slashes is to avoid compiler interpret words
File f = new File(WorkingDirectory + "//programinput.txt");
        // Check if the specified file
        // Exists or not
        if (f.exists())
        {
        System.out.println("ProgramInput.txt exists");
        return true;
        }
        else
        {
        System.out.println("ProgramInput.txt does not exist - please create the file at the working directory mentioned");
        return false;
        }
       
}

public static void main(String[] args) {

try
{
boolean fileExists =  doesFileExist();
       if (fileExists == true)
       {
        File f = new File(WorkingDirectory + "//programinput.txt");
           //file exists read the contents of file and parse
           BufferedReader br = new BufferedReader(new FileReader(f));
           String line;
           while ((line = br.readLine()) != null) {
               // process the line.
           
            //Word1
            //Meaning 1
            //Meaning 2
            //Word2
            //Meaning1
            //Meaning2
            //Get the word by string split
            //trim removes the spaces from the beginning and end of the string
            System.out.println(line.split(" ")[0].trim());
           
            try
            {
            String meaningString;
            meaningString = line.split(",")[0].trim(); 
            //get the first meaning need to split on '-'
            System.out.println (meaningString.split("-")[1].trim()); 
           
            System.out.println(line.split(",")[1].trim()); 
            }
            catch (Exception e) 
            {
            //Only need to print Meaning 1
            //since we are splitting on , if the character is not found it will move to this exception clause
            System.out.println("No Meaning 2");
            }
           }
           br.close();
       
           }
     
}catch (Exception e)
{
e.printStackTrace();
}
}

}
