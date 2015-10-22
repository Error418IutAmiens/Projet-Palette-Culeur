/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inccolor;
import java.io.*;
import java.util.ArrayList;
import java.awt.Color;
/**
 *
 * @author Julien
 */
public class Fichier 
{
   
    static void enregistrement(ArrayList<Entreprise> listeEts,String fichier)
    {
        
        
        try
        {
            File f = new File(fichier);
            PrintWriter pw = new PrintWriter (new BufferedWriter (new FileWriter (f)));
            for(Entreprise ets : listeEts)
            {
                pw.println(ets.getNom());             
                for(int i = 0; i < 5; i++)
                {
                    pw.print(";");
                    pw.print(ets.getColor()[i].getRGB());
                    
                }
            
            }
            
            pw.close();
        }
        catch(IOException exception)
                {
                    System.out.println("Erreur lors de l'écriture : " + exception.getMessage());
                    javax.swing.JOptionPane.showMessageDialog(null,"Erreur lors de la sauvegarde !");
                }
       
        
    }
    
    static ArrayList<Entreprise> importation(String fichier)
    {
              
               Color[] tabColor = new Color[5];     
               ArrayList<Entreprise> ets = new ArrayList();
               String[] splitArray = null;
               try
               {
                   File f = new File(fichier);
                   FileReader fr = new FileReader (f);
                   BufferedReader br = new BufferedReader (fr);
                   
                   String line = br.readLine();
                   
                   while(line != null)
                   {
                       splitArray = line.split(";");
                       for(int i = 0;i < splitArray.length -1;i++)
                       {
                           tabColor[i] = new Color(Integer.parseInt(splitArray[i+1]));                          
                       }
                       ets.add(new Entreprise(splitArray[0],tabColor));
                   }
                   
                  br.close();
                  fr.close();
               }
               catch(IOException exception)
                {
                    System.out.println("Erreur lors de la lecture : " + exception.getMessage());
                    javax.swing.JOptionPane.showMessageDialog(null,"Erreur lors de la lecture !");
                }
               return ets;
    }
    
}
