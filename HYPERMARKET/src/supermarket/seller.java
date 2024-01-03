/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import com.sun.java.swing.plaf.windows.resources.windows;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author eltaweel
 */

class user{
    protected String id;
    protected String User_Name;
    protected String User_Pass;
    protected String Gender;
    
    protected File MyFile;
    
    
    public void setUserName(String User_Name){
        this.User_Name=User_Name;
    }
    
    public String GetUserName(){
        return this.User_Name;
    }
    
    public String GetPasswpord(){
        return this.User_Pass;
    }
    
}





class Mange_Seller extends user{
    
 
    public Mange_Seller(){
        
    }
    public void AddSeller(String Name,String pass,String Gender,String id)throws Exception {
        
        String NAME="";
        String PASS="";
        String GENDER="";
        String ID="";
        this.User_Name=Name;
        this.User_Pass=pass;
        this.Gender=Gender;
        this.User_Name=Name;
        this.id=id;
        int flag=0;
        try{
        MyFile=new File("seller.txt");
        BufferedWriter file=new BufferedWriter(new FileWriter(MyFile,true));
        Scanner x=new Scanner(MyFile);
        
         while(x.hasNext())
          {
              
             
             ID=x.next();
             PASS=x.next();
             GENDER=x.next();
             NAME=x.next();
             if(ID.equals(id))
             {
                 flag=1;
                JOptionPane.showMessageDialog(null,"ID  must not be duplicated");
                break;
             }else if(id.equals("0")){
                 flag=1;
                 JOptionPane.showMessageDialog(null,"ID  must not be 0");
                 break;
             }
             
          }
          if(flag==0){
        file.write(this.id+"\t\t"+this.User_Pass+"\t\t"+this.Gender+"\t\t"+this.User_Name);
        file.newLine();
        file.flush();
        file.close();
        }
          
       
        
        }catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        
    }
   
      public void Update2(String Name,String id,String Password){
        
        String NAME="";
        String PASS="";
        String GENDER="";
        String ID="";
      boolean flAG=false;
        
        File OldFile = new File("seller.txt");
        File NewFile = new File("temp.txt");
       
        try{
          
          BufferedWriter bw=new BufferedWriter(new FileWriter(NewFile,true));
          PrintWriter pw=new PrintWriter(bw);
          Scanner x=new Scanner(OldFile);
          
          
          
          while(x.hasNext())
          {
             
             ID=x.next();
             PASS=x.next();
             GENDER=x.next();
             NAME=x.next();
             
             if(ID.equals(id))
             {
                 flAG=true;
                 
                 pw.println(ID+"\t\t"+Password+"\t\t"+GENDER+"\t\t"+Name);
             }else{
              pw.println(ID+"\t\t"+PASS+"\t\t"+GENDER+"\t\t"+NAME);
             
              
              
          }
          }
          if(flAG==false){
              
              JOptionPane.showMessageDialog(null,"ID Isnot Found");
          }else{
              JOptionPane.showMessageDialog(null, "Your info is updated...");
          }
          
                x.close();
                pw.flush();
                pw.close();
                OldFile.delete();
                File dump=new File("seller.txt");
                NewFile.renameTo(dump);
          
        }catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        
    
      }
    public void check(String x){
           boolean flAG=false;
           File OldFile = new File("seller.txt");
           String NAME="";
        String PASS="";
        String GENDER="";
        String ID="";
        try{
        Scanner c = new Scanner(new File("seller.txt"));
        
        while(c.hasNext()){
             ID=c.next();
             PASS=c.next();
             GENDER=c.next();
             NAME=c.next();
            
                if(ID.equals(x))
                {
                 flAG=true;
                 
                }
            
            }
        if(flAG==false){
            JOptionPane.showMessageDialog(null, "id isnot found");
        }
        
        c.close();
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }
       
        
        
    }
     
       public void deleteSeller(String id){
            check(id);
           File OldFile = new File("seller.txt");
           File NewFile = new File("temp.txt");
        String NAME="";
        String PASS="";
        String GENDER="";
        String ID="";
        
            try {
                FileWriter fw=new FileWriter("temp.txt",true);
                BufferedWriter bw=new BufferedWriter(fw);
                PrintWriter pw=new PrintWriter(bw);
               Scanner x = new Scanner(new File("seller.txt"));
                
          
            
              
             
               
              while(x.hasNext()){
            
             ID=x.next();
             PASS=x.next();
             GENDER=x.next();
             NAME=x.next();
            
             
             if(!ID.equals(id)){
                 
                 pw.println(ID+"\t\t"+PASS+"\t\t"+GENDER+"\t\t"+NAME);
             }
             
              }
               x.close();
                pw.flush();
                pw.close();
                OldFile.delete();
                File dump=new File("seller.txt");
                NewFile.renameTo(dump);
                 
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error");
            }
            
        
        }
   public boolean login(String id,String Password,int k) throws FileNotFoundException{
        String PASS="";
        String ID="";
        File File = new File("seller.txt");
        Scanner o=new Scanner(File);
        File OldFile = new File("admin.txt");
        Scanner x=new Scanner(OldFile);
        boolean flag=false;
        if(k ==2){
        
        
        
             
         
      //    MAKE_ORDER s1=new MAKE_ORDER();
//          LOGIN l=new LOGIN();
            
          while(o.hasNext())
          {
             
             ID=o.next();
             PASS=o.next();
            String GENDER = o.next();
            String NAME = o.next();
             if(ID.equals(id) && PASS.equals(Password) ){
              flag=true;
              break;
             }
          }}
        else if(k==1){
        
        
            
         
      //    MAKE_ORDER s1=new MAKE_ORDER();
//          LOGIN l=new LOGIN();
            
          while(x.hasNext())
          {
             
             ID=x.next();
             PASS=x.next();
                 String GENDER = x.next();
                 String NAME = x.next();
                 if(ID.equals(id) && PASS.equals(Password) ){
              flag=true;
              break;
             }
          }
        }
             o.close();
             x.close();
               
                
             if(flag==false){
          return false;
             }else{
             return true;
             }
                 }
  
             
            
   }
        
                       
//                 flag1=1;
//                if(){
//                    flag2=1;
//                    break;
//                    
//                }
//                break;
//                 
//             }
//             
//          }
//          if(flag1==1&&flag2==0){
//              JOptionPane.showMessageDialog(null,"password is wrong");
//          }else if(flag1==0){
//              JOptionPane.showMessageDialog(null,"Id is wrong");
//          }else if(flag1==1&&flag2==1)
//          {
//              s1.setVisible(true);
//              
//          }
//          
//          
//          x.close();
//        }catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "Error");
//            }
   //     return false;
