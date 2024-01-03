/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author mostafa
 */
public class Products {
    
   protected String NAME ;
   protected String ID ;
   protected double Price ;
   protected int Quantity ;
   protected String Expire_date ;
   protected String Period_validity ;
    protected File MyFile;
    //constructor empty
    public Products() {
    }

    public String getName() {
        
        return NAME;
    }

    public String getId() {
        return ID;
    }

    public double getPrice() {
        return Price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public String getExpire_date() {
        return Expire_date;
    }
    public void AddProductToFile( String ID ,String NAME ,int Quantity,double Price ,String Expire_date ,String Period_validity  ){
        this .ID = ID ;
        this .NAME = NAME ;
        this .Quantity = Quantity ;
        this . Price = Price ;
        this .Expire_date =Expire_date ;
        this .Period_validity = Period_validity ; 
        
        try {
           MyFile=new File("PRODUCTS.txt");
        BufferedWriter file=new BufferedWriter(new FileWriter(MyFile,true));
        file.write(this.ID +"\t\t"+this.NAME+"\t\t"+this.Price+"\t\t"+this.Quantity+"\t\t"+this.Expire_date+"\t\t"+this.Period_validity);
        file.newLine();
   
        file.flush();
        file.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }
   

   
    public void RemoveProductFromFile(String id){
           
           boolean flAG=false;
           File OldFile = new File("PRODUCT.txt");
           File NewFile = new File("temp.txt");
        String ID="";   
        String NAME="";
        String Quantity="";
        String Price="";
        String Expire_date ="";
        String Period_validity ="";
        
            try {
                FileWriter fw=new FileWriter("temp.txt",true);
                BufferedWriter bw=new BufferedWriter(fw);
                PrintWriter pw=new PrintWriter(bw);
               Scanner x = new Scanner(new File("PRODUCT.txt"));
          
           if(flAG==false&&!x.hasNext()){
                
                  JOptionPane.showMessageDialog(null, "the file is emty");
                
                
              }
              
             
              
           else{ 
              while(x.hasNext()){
             
             ID=x.next();
             NAME=x.next();
             Quantity = x.next();
             Price = x.next() ;
             Expire_date = x.next() ;
             Period_validity = x.next() ;
             
             
             if(!ID.equals(id)){
                 
                    pw.println(ID+"\t\t"+ NAME+"\t\t"+Quantity+"\t\t"+ Price+"\t\t"+Expire_date+"\t\t"+Period_validity);

             }
             if(ID.equals(id)){
                 flAG=true;
             }
               }
              if(flAG==false){
              
              JOptionPane.showMessageDialog(null,"Id is not found");
          }
           }
          
          
             
               x.close();
                pw.flush();
                pw.close();
                OldFile.delete();
                File dump=new File("PRODUCT.txt");
                NewFile.renameTo(dump);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        
        }
    
    
    
    
            
}
