/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pbo07;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author evfi2
 */
public class PBO0702 {
    Connection connection = null;
    Statement statement = null;
    ResultSet rs = null;
    Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
    
        
        PBO0702 gas = new PBO0702();
        gas.runthis();
        //498
        
    }
    public void runthis(){
        openConnection();
        menu();
        //percobaan();
    }
    public void percobaan(){
        //System.out.println(scanningexistorder("10426"));
        //viewdatacustomers("499");
        //viewdata();
        //viewdatatransaksi("499");
        
        if(taketheordernumberbyON("20000")>0){
            viewdetiltransaksi("20000");
        }
        else{
            System.out.println("Belum ada pesanan");
        }
                
        
        
       
    }
    public void menu(){
        int stop =0;
        do{
        System.out.println("\t\nSelamat datang");
        System.out.println("\tMenu : ");
        System.out.println("\t1. Input Customer Baru");
        System.out.println("\t2. Input New Transaksi");
        System.out.println("\t3. Info Data");
        System.out.println("\t4. Keluar");
        System.out.print("Input number : ");
        int inputan = input.nextInt();
        if(inputan==1){
            insertcustomer();
        }
        else if(inputan==2){
            newtransaksi();
        }
        else if(inputan==3){
            viewdata();
        }
        else if(inputan==4){
            stop=1;
        }
        else{
            System.out.println("Inputan Salah");
        }
        }while(stop!=1);
        
    }
    public void viewdata(){
        System.out.println("\tView Data: ");
        System.out.println("\t1. Customer by input ID");
        System.out.println("\t2. Data Transaksi by OrderNumber");
        System.out.println("\t3. Detil Transaksi by OrderNumber");
        System.out.println("\t   Input any number for back to Menu");
        System.out.print("\tInput number : ");
        int inputan = input.nextInt();
        if(inputan==1){
            System.out.print("\tInput ID Customer : ");
            input.nextLine();
            String idcustomer = input.nextLine();
            viewdatacustomers(idcustomer);
            int orderr;
            if(scanningexistorder(idcustomer)){
                orderr=taketheordernumber(idcustomer);
                System.out.print(orderr);
            }
            else{
                System.out.print("Belum ada pesanan");
            }
        }
        else if(inputan==2){
            System.out.print("\tInput Order Number : ");
            input.nextLine();
            String orderNumber = input.nextLine();
            
                if(taketheordernumberbyON(orderNumber)>0){
                    viewdatatransaksi(orderNumber);
                }
                else{
                    System.out.println("Belum ada pesanan");
                }
        }
        else if(inputan==3){
            System.out.print("\tInput Order Number : ");
            input.nextLine();
            String orderNumber = input.nextLine();
                if(taketheordernumberbyON(orderNumber)>0){
                    viewdetiltransaksi(orderNumber);
                }
                else{
                    System.out.println("Belum ada pesanan");
                }
        }
        else{
        }
    }
    public void viewdetiltransaksi(String orderNumber){
        String query = "select orderNumber as kode,productCode as kodeproduk,quantityOrdered as qty,priceEach as harga,orderLineNumber as kali from orderdetails where orderNumber="+orderNumber+" order by kali asc;";
        
        try{
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            System.out.println("\tOrder Number\t: "+orderNumber);
            System.out.println("\tKode Produk\tQty\tHarga\tTotal\tHistori" );
            
            while(rs.next()){
                String b = rs.getString("Kodeproduk");
                int c = rs.getInt("Qty");
                int d = rs.getInt("Harga");
                int hargafull = c+d;
                String e = rs.getString("kali");
                
                //System.out.println("\t"+a +"\t"+harga+"\t" + c+"\t\t"+b);
                System.out.print("\t"+b+"\t"+c+"\t"+d+"\t"+hargafull+"\t"+e+"\n");
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void viewdatatransaksi(String orderNumber){
        String query = "select orderNumber as kodeorder,orderDate as tglorder,requiredDate as tglminta,shippedDate as tglkirim,status as status,comments as deskripsi,customerNumber as idcustomer from orders where orderNumber="+10427+";";
        
        try{
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            System.out.println("\tID\tKode Order\tStatus\t\tOrder Date\t\tRequired Date\t\tShipped Date\tDeskripsi\tHistori Pesanan " );
            while(rs.next()){
                String a = rs.getString("idcustomer");
                String b = rs.getString("kodeorder");
                String c = rs.getString("status");
                String d = rs.getString("tglorder");
                String e = rs.getString("tglminta");
                String f = rs.getString("tglkirim");
                String g = rs.getString("deskripsi");
                
                //System.out.println("\t"+a +"\t"+harga+"\t" + c+"\t\t"+b);
                System.out.print("\t"+a+"\t"+b+"\t\t"+c+"\t\t"+d+"\t\t"+e+"\t\t"+f+"\t"+g+"\t\t");
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void viewdatacustomers(String kodecustomer){
        String query = "select customerNumber as kode,customerName as nama,phone as hp,addressLine1 as alamat,country as negara from customers where customerNumber="+kodecustomer+";";
        
        try{
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            System.out.println("\tKode\tNama\t\tPhone\t\tAlamat\t\tNegara\t\tOrder Number " );
            while(rs.next()){
                String a = rs.getString("kode");
                String b = rs.getString("nama");
                String c = rs.getString("hp");
                String d = rs.getString("alamat");
                String e = rs.getString("negara");
                
                //System.out.println("\t"+a +"\t"+harga+"\t" + c+"\t\t"+b);
                System.out.print("\t"+a+"\t"+b+"\t"+c+"\t"+d+"\t\t"+e+"\t\t");
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void forinput(String type){
        int orderlinenumberr;
        int qty;
        int hargaa;
        String harga;
        int total;
        int orderr;
        String order;
        String orderlinenumber;
                
        showallproductbytype(type);
        System.out.print("\tInput Kode Produk\t\t: ");
        input.nextLine();
        String kodeproduk = input.nextLine();
        System.out.print("\tInput Id Customer\t\t: ");
        String kodecustomer = input.nextLine();
        if(scanningexistkode(kodecustomer)){
            System.out.print("\tQTY\t\t: ");
            qty = input.nextInt();
            hargaa = finalprice(kodeproduk);
            harga=Integer.toString(hargaa);
            total=qty*hargaa;
            
            if(scanningexistorder(kodecustomer)){
                orderr=taketheordernumber(kodecustomer);
            }
            else{
                orderr=takelastordernumber()+1;
            }
           order=Integer.toString(orderr);
            if(getorderlinenumber(order)>0){
                orderlinenumberr = getorderlinenumber(order)+1;
            }
            else{
                orderlinenumberr = 1;
            }
            orderlinenumber=Integer.toString(orderlinenumberr);
        
        if(scanningexistorder(kodecustomer)){
            //langsung insert orderdetail
            String query1="INSERT INTO orderdetails(orderNumber,productCode,quantityOrdered,priceEach,orderLineNumber)" ;
            String query2=" Value ("+order+",'"+kodeproduk+"',"+qty+","+harga+","+orderlinenumber+");";
            String finalquery = query1+query2;
            executestatement(finalquery);
            
        }
        else{
        //insert order number
            String query1="insert into orders(orderNumber,orderDate,requiredDate,shippedDate,status,customerNumber)";
            String query2=" values ("+order+",'2023-7-9','2023-7-9','2023-7-9','Proses',"+kodecustomer+");";
            String finalquery = query1 + "\n" + query2;
            executestatement(finalquery);
            
        //order detail
            String query3="INSERT INTO orderdetails(orderNumber,productCode,quantityOrdered,priceEach,orderLineNumber)" ;
            String query4=" Value ("+order+",'"+kodeproduk+"',"+qty+","+harga+","+orderlinenumber+");";
            String finalquery2 = query3+query4;
            executestatement(finalquery2);
                
        }
         
        
        
        }
        
    }
    
    public int getorderlinenumber(String orderNumber) {
       int cusnumber = 0;
        try{
            String text = "select max(orderLineNumber)as execute from orderdetails where orderNumber="+orderNumber+";";
//            executestatement(text);
            ResultSet rs = getdata(text);
            if(rs.next()){
                cusnumber = rs.getInt("execute");
            }
            
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return cusnumber;
    }
    
    public Boolean scanningexistkode(String kode){
        Boolean back=false;
        //498 yg gada
        String query="select customerNumber as Kode from customers where customerNumber="+kode+";";
        try{
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            if(rs.next()){
                String a = rs.getString("kode");
                back=true;
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return (back);
    }
    
    public void newtransaksi(){
        System.out.println("\tProduk apa yang ingin dibeli: ");
        System.out.println("\t1. Classic Cars");
        System.out.println("\t2. MotorCycles");
        System.out.println("\t3. Planes");
        System.out.println("\t4. Ships");
        System.out.println("\t5. Trains");
        System.out.println("\t6. Trucks and Buses");
        System.out.println("\t7. Vintage Cars"); 
        System.out.println("     Input any number for bact to Menu");
        System.out.print("\tInput Number\t\t: ");
        int inputan = input.nextInt();
        
        if(inputan==1){
            forinput("Classic Cars");
        }
        else if(inputan==2){
            forinput("Motorcycles");
        }
        else if(inputan==3){
            forinput("Planes");
        }
        else if(inputan==4){
            forinput("Ships");
        }
        else if(inputan==5){
            forinput("Trains");
        }
        else if(inputan==6){
            forinput("Trucks and Buses");
        }
        else if(inputan==7){
            forinput("Vintage Cars");
        }
        else{
            
        }
        
        
        
    }
    
    public void showallproductbytype(String type){
        String query = "select productCode as kode,productName as nama,quantityInStock as stok from products where productLine='"+type+"';";
        
        try{
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            System.out.println("\tKode Produk\tStok\tNama " );
            while(rs.next()){
                String a = rs.getString("kode");
                String b = rs.getString("nama");
                String c = rs.getString("stok");
                
                //System.out.println("\t"+a +"\t"+harga+"\t" + c+"\t\t"+b);
                System.out.println("\t"+a +"\t" + c+"\t"+b);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public int finalprice(String idproduct){
        //harga asli 
        String query1="select buyprice as hargaAsli from products where productCode='"+idproduct+"';";
        //harga rata"jual
        String query2 = "select avg(priceEach) as avgHargaJual from orderdetails WHERE productCode='"+idproduct+"';";
        int hargaAsli=0;
        int hargaJualrata=0;
        int HargaJual;
        try{
            statement = connection.createStatement();
            rs = statement.executeQuery(query1);
            while(rs.next()){
                hargaAsli = rs.getInt("hargaAsli");
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        
        try{
            rs = statement.executeQuery(query2);
            while(rs.next()){
                hargaJualrata = rs.getInt("avgHargaJual");
            }   
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        HargaJual=hargaAsli+(hargaJualrata-hargaAsli);
        
        return(HargaJual);
    }
    public void cobaPrintall(){
        //CUMA PERCOBAAN
        String query = "SELECT * FROM `orderdetails`";
        try{
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            System.out.println("Order Numbers: " );
            while(rs.next()){
                String a = rs.getString("orderNumber");
                String b = rs.getString("productCode");
                
                System.out.println("\t"+a + "\t" + b);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void insertcustomer(){
        int cusNumber = takelastnumber("customerNumber");
        cusNumber++;
        String cusNumber2 = Integer.toString(cusNumber);
        input.nextLine();
        System.out.print("Nama Depan\t: ");
        String firstname = input.nextLine();
        System.out.print("Nama Belakang\t: ");
        String Lastname = input.nextLine();
        System.out.print("No. HP\t\t: ");
        String phone = input.nextLine();
        System.out.print("Alamat\t\t: ");
        String addressLine1 = input.nextLine();
        System.out.print("Kota\t\t: ");
        String city = input.nextLine();
        System.out.print("Provinsi\t: ");
        String state = input.nextLine();
        System.out.print("Kode Pos\t: ");
        String kodepos = input.nextLine();
        System.out.print("Negara\t\t: ");
        String country = input.nextLine();
        String fullname = firstname + " " + Lastname;
        // salesRepEmployeeNumber = SREN
        int SREN = 0;

        String queryawal = "insert into customers(customerNumber,customerName,contactLastName,contactFirstName,phone,addressLine1,city,state,postalCode,country)";
        String queryakhir = " values(" + cusNumber2 + ",'" + fullname + "','" + Lastname + "','" + firstname
                + "','" + phone + "','" + addressLine1 + "','" + city + "','" + state + "','" + kodepos + "','"
                + country + "');";
        String finalquery = queryawal + "\n" + queryakhir;
        executestatement(finalquery);
        
        System.out.println("\t data anda berhasil diinput dengan keterangan sebagai berikut :");
        System.out.println("\t Id Customer\t: "+cusNumber2);
        System.out.println("\t Nama Lengkap\t: "+fullname);
        System.out.println("\t Phone\t: "+phone);
        System.out.println("\t Alamat\t: "+addressLine1+","+city+","+state+","+kodepos+","+country);
        
    }
    
    public int takelastnumber(String tabel) {
        // dipakai untuk ambil last number aja
        int back = 0;
        try {
            String text = "select max(" + tabel + ") as execute from customers;";
            // executestatement(text);
            ResultSet rs = getdata(text);
            if (rs.next()) {
                back = rs.getInt("execute");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return back;
    }
    
    public int taketheordernumber(String kodecustomer){
        int back = 0;
        try {
            String query = "select orderNumber as execute from orders where customerNumber="+kodecustomer+";";
            ResultSet rs=getdata(query);
            if(rs.next()){
                back = rs.getInt("execute");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return back;
    }
    
    public int taketheordernumberbyON(String kodeordernumber){
        int back = 0;
        try {
            String query = "select orderNumber as execute from orders where orderNumber="+kodeordernumber+";";
            ResultSet rs=getdata(query);
            if(rs.next()){
                back = rs.getInt("execute");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return back;
    }
    
    public int takelastordernumber(){
        int back=0;
        try {
            String query = "select max(orderNumber) as execute from orderdetails;";
            // executestatement(text);
            ResultSet rs = getdata(query);
            if(rs.next()){
            back=rs.getInt("execute");
            }
        }
        catch (SQLException ex) {
        ex.printStackTrace();
        }
        return back;
    }
    public Boolean scanningexistorder(String kode){
        Boolean back=false;
        //498 yg gada
        String query="select orderNumber as Kode from orders where customerNumber="+kode+";";
        try{
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            if(rs.next()){
                String a = rs.getString("kode");
                back=true;
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return (back);
    }
    
    public void openConnection(){
        //Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/classicmodels",
                    "root",
                    "");
            System.out.println("berhasil koneksi");
        }
        catch(Exception e){
            System.out.println(e);
            System.out.println("gagal koneksi");
        }
    }
    
    public void closeconnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Koneksi ditutup");
            } catch (SQLException ex) {
                System.out.println("Gagal menutup koneksi: " + ex.getMessage());
            }
        }
    }
    
    public int executestatement(String query){
        int resultCount = 0;
        try{
            statement = connection.createStatement();
            resultCount =statement.executeUpdate(query);
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return resultCount;
    }
    
    public ResultSet getdata(String query){
        try{
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return rs;
    }
    public int lastordernumber(){
        int cusnumber = 0;
        try{
            String text = "select max(orderNumber) as orderNumber from Orders;";
//            executestatement(text);
            ResultSet rs = getdata(text);
            if(rs.next()){
                cusnumber = rs.getInt("orderNumber");
            }
            
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return cusnumber;
    }
    public void viewdataa(){
    try{
        PBO0702 db = new PBO0702();
        db.openConnection();
        rs = db.getdata("select * from testTable");
        int id;
        String name;
        int jumlah;
        String tanggal;
        while(rs.next()){
            id      = rs.getInt("id");
            name    = rs.getString("name");
            jumlah  = rs.getInt("jumlah");
            tanggal = rs.getString("tanggalTransaksi");
            System.out.println(
            id+" "+name+" "+jumlah+" "+tanggal);
        }
        rs.close();
        //query lainnya
        ResultSet rs2 = db.getdata("select * from customers");
        db.closeconnection();
    }
    catch (SQLException ex) {
        System.out.println(ex.toString());
    }
    }
    
    public void inserdata(){
        try{
            PBO0702 db = new PBO0702();
            db.openConnection();
            System.out.println("Insert record baru");
            String query = "insert into testtable "
                    + "values(null,'bejo',10,'2023-06-20')";
            db.executestatement(query);
            System.out.println("Data berhasil dimasukkan");
            db.closeconnection();
        }
        catch(Exception e){
            Logger.getLogger(DriverManager.class.getName())
                    .log(Level.SEVERE,null,e);
            
        }
    }
}
