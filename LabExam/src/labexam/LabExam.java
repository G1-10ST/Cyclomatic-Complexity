/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labexam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author placements2019
 */
public class LabExam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        File file=new File("input.c");
        File file1=new File("input.c");
        File file2=new File("input.c");
        FileReader fr,fr1,fr2;
        int if_count=0;
        int occurence=0;
        String[] c={};
        String allconditions="";
        try{
            fr=new FileReader(file);
            
            BufferedReader bf=new BufferedReader(fr);
            try {
                String str=bf.readLine();
                while(str!=null)
                {
                    //Your Code Here
                    
                    System.out.println(str);
                    if(str.contains("if"))
                    {
                        if_count++;
                    }
                    str=bf.readLine();
                    
                }
                //bf.reset();
                //bf.close();
                
                System.out.println("Cyclomatic Complexity = "+((if_count)+1));
            } catch (IOException ex) {
                Logger.getLogger(LabExam.class.getName()).log(Level.SEVERE, null, ex);
            }
            //System.out.println("/t /t /t Reduced Cyclomatic Code ");
            fr1=new FileReader(file1);
            BufferedReader of=new BufferedReader(fr1);
            try {
                String str1=of.readLine();
                while(str1!=null)
                {
                    if(!str1.contains("if"))
                    {
                        //System.out.println(str1);
                    }
                    else
                    {
                        int start=str1.indexOf("(");
                        int stop=str1.indexOf(")");
                        String condition=(String) str1.subSequence(start+1, stop);
                        allconditions=allconditions.concat(condition+":");
                        //System.out.println("if ("+condition+" && ");
                        
                    }
//                    if(occurence==1)
//                    {
//                        
//                       
//                        
//                    }
                    str1=of.readLine();
                }
                c=allconditions.split(":");
               // System.out.println("Length : "+c.length);
                //System.out.println("Condition 1 :"+c[0]+"Condition 2 : "+c[1]);
//                if(c.length>2)
//                {
//                    for(int i=1;i<(c.length)-2;i++)
//                    {
//                     System.out.println("if ("+c[0]+"&&"+c[i]+" && "+c[c.length-1]+")");
//                    }
//                    
//                }
//                else if(c.length==2)
//                {
//                     System.out.println("if ("+c[0]+" && "+c[c.length-1]+")");
//                    
//                }
                
            } catch (IOException ex) {
                Logger.getLogger(LabExam.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("");
            System.out.println("");
            System.out.println(" \t \t \t  Reduced Cyclomatic Code");
            System.out.println("");
            System.out.println("");
            fr2=new FileReader(file2);
            BufferedReader of2=new BufferedReader(fr2);
            try {
                String str2=of2.readLine();
                while(str2!=null)
                {
                    if(!str2.contains("if"))
                    {
                        System.out.println(str2);
                    }
                    else if(occurence==0)
                    {
                        if(c.length>2)
                        {
                            System.out.print("if ("+c[0]+"&& ");
                            for(int i=1;i<(c.length)-1;i++)
                            {
                                
                                System.out.print(c[i]+" && ");
                            }
                            System.out.print(" && "+c[c.length-1]+")");

                        }
                        else if(c.length==2)
                        {
                             System.out.println("if ("+c[0]+" && "+c[c.length-1]+")");

                        }
                        occurence++;
                    }
                    else{}
                    str2=of2.readLine();
                }
            } catch (IOException ex) {
                Logger.getLogger(LabExam.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }
        
    }
    
}
