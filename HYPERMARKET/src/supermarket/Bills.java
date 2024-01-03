package supermarket;
import java.util.*;
import java.io.*;
import java.text.*;

public class Bills
{
    private File BillFile;
    private double TotalPrice=0;

    public Bills()
    {
    }
    
   
    
    public void Cash (String id,int quant) throws Exception 
    {
        String quantity="",identi="" ,name="",price="",date="",wara="";
        //String myLine="";
        
        File ProductFile = new File("PRODUCTS.txt");
        try (Scanner input = new Scanner(ProductFile)) 
        {
            while(input.hasNext())
            {
                identi=input.next();
                name=input.next();
                price=input.next();
                quantity=input.next();
                date=input.next();
                wara=input.next();
                if(identi.equals(id))
                    break;
            } 
            
            input.close();
            double i = Double.parseDouble(price);
            this.TotalPrice= this.TotalPrice +(i*quant);
            if(this.TotalPrice>=10000) this.Offers();
            
        }
        
        
        
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        
        fw = new FileWriter("Bills.txt", true);
        bw = new BufferedWriter(fw);
        pw = new PrintWriter(bw);
        
        pw.println(identi + "   "+ name+ "   "+price+ "   "+quant);
        
        pw.close();
        bw.close();
        fw.close();
        
        File newFile = new File("templete.txt");
        
        FileWriter fw0 = null;
        BufferedWriter bw0 = null;
        PrintWriter pw0 = null;

        fw0 = new FileWriter("templete.txt", true);
        bw0 = new BufferedWriter(fw0);
        pw0 = new PrintWriter(bw0);
        
        File oldFile= new File("PRODUCTS.txt");
        
        try(Scanner input1 = new Scanner(oldFile))
        {
            while(input1.hasNext())
            {
                identi=input1.next();
                name=input1.next();
                price=input1.next();
                quantity=input1.next();
                date=input1.next();
                wara=input1.next();
                int x= Integer.parseInt(quantity);
                if(!identi.equals(id))
                    pw0.println(identi + "   " + name + "    " + price + "   " + quantity + "   " + date + "    " + wara);
                else
                    pw0.println(identi + "   " + name + "    " + price + "   " + (int)(x-quant) + "   " + date + "    " + wara);
            }
            
            input1.close();
            pw0.flush();
            pw0.close();
            oldFile.delete();
            File dump = new File("PRODUCTS.txt");
            newFile.renameTo(dump);
        }
    }
    
    public void Offers()
    {
            System.out.println("congrats ...you got  10% descount ");
            this.TotalPrice-=(this.TotalPrice/10);
    }
    
   
    public void DeleteItem(String id) throws Exception
    {
        double tempPrice=0;
        String price="",quant="",identi="",name="",date="",wara="";
        
        //new file creation and open it "append"
        File newFile = new File("temp.txt");
        
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        
        fw = new FileWriter("temp.txt", true);
        bw = new BufferedWriter(fw);
        pw = new PrintWriter(bw);
        
        //open old file to read from it
        File oldFile= new File("Bills.txt");
        try(Scanner input = new Scanner(oldFile))
        {
            while(input.hasNext())
            {
                identi=input.next();
                name=input.next();
                price=input.next();
                quant=input.next();
                
                if(!identi.equals(id))
                {
                    pw.println(identi + "   " + name + "    " + price + "   " + quant);
                    double i = Double.parseDouble(price);
                    tempPrice=tempPrice + i;
                }
                
                this.TotalPrice= tempPrice;       
            }
            input.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File("Bills.txt");
            newFile.renameTo(dump);
        }
            
        File newFilex = new File("templetex.txt");
        
        FileWriter fw0 = null;
        BufferedWriter bw0 = null;
        PrintWriter pw0 = null;

        fw0 = new FileWriter("templetex.txt", true);
        bw0 = new BufferedWriter(fw0);
        pw0 = new PrintWriter(bw0);
        
        File oldFilex= new File("PRODUCTS.txt");
        double i = Double.parseDouble(quant);
        try(Scanner input1 = new Scanner(oldFilex))
        {
            while(input1.hasNext())
            {
                identi=input1.next();
                name=input1.next();
                price=input1.next();
                int quantity=input1.nextInt();
                date=input1.next();
                wara=input1.next();
                
                if(!identi.equals(id))
                    pw0.println(identi + "   " + name + "    " + price + "   " + quantity + "   " + date + "    " + wara);
                else
                    pw0.println(identi + "   " + name + "    " + price + "   " + (int)(quantity+i) + "   " + date + "    " + wara);
            }
            
            input1.close();
            pw0.flush();
            pw0.close();
            oldFilex.delete();
            File dumpx = new File("PRODUCTS.txt");
            newFilex.renameTo(dumpx);
        }
    }    
         
    //named clear in gui
//    public void DeleteBill()
//    {
//        File oldFile= new File("Bills.txt");
//        oldFile.delete();
//    }
    
    //to use it in deff fuctions
    public double getTotalPrice() {
        return TotalPrice;
    }
    
    public void finish() throws IOException
    {
        File DBFile = new File("DataBase.txt");
        File billFile = new File("Bills.txt");
        
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        
        fw = new FileWriter("DataBase.txt", true);
        bw = new BufferedWriter(fw);
        pw = new PrintWriter(bw);

        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        pw.println(df.format(dateobj));
        
        FileInputStream in = new FileInputStream(billFile); 
        FileOutputStream out = new FileOutputStream(DBFile); 
        int n; 
        while ((n = in.read()) != -1) 
            out.write(n);
        
        in.close();
        out.close();
        pw.close();
        
        
        
        
        billFile.delete();
        File Bills = new File("Bills.txt");
        
        FileWriter fw0 = null;
        BufferedWriter bw0 = null;
        PrintWriter pw0 = null;

        fw0 = new FileWriter("Bills.txt");
        bw0 = new BufferedWriter(fw0);
        pw0 = new PrintWriter(bw0);
        
        this.TotalPrice=0;
    }

}

