package com.postgres;

public class App 
{
    public static void main( String[] args )
    {
//    	ReadExcel r = new ReadExcel();
//    	r.readExcelFile();
    	
		DBConnect db = new DBConnect();
		db.readFromDB();
    }
}