/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inccolor;
import java.awt.Color;
/**
 *
 * @author Julien
 */
public class Entreprise 
{
        private String nom;
	private Color[] tabColor = new Color[5];
        
        public Entreprise(String nom)
        {
            this.nom = nom;
        }
        public Entreprise(String nom, Color[] tabColor)
        {
            this.nom = nom;
            for(int i = 0; i < tabColor.length; i++)
            {               
                    this.tabColor[i] = new Color(tabColor[i].getRGB());
            }
        }
        
        public void setNom(String nom)
        {
            this.nom = nom;
        }
        public void setColor()
        {
            for(int i = 0; i < 5; i++)
            {  
                if(tabColor[i] != null)
                    this.tabColor[i] = new Color(tabColor[i].getRGB());
            }
        }
        
        public String getNom()
        {
            return this.nom;
        }
        public Color[] getColor()
        {
            Color[] tab = new Color[5];
            for(int i = 0; i < 5; i++)
            {
               if(this.tabColor[i] != null)
                    tab[i] = new Color(this.tabColor[i].getRGB());
            }
            return tab;
        }
}
