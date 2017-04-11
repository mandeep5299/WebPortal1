package com.wipro.portal.util;
 
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
 
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
 
 
public class IndexBuilder {
 
	static final String LUCENE_INDEX_DIRECTORY = "/Users/mandeepsingh/Desktop/index/";
	static final String DB_HOST_NAME = "localhost";
	static final String DB_USER_NAME = "root";
	static final String DB_PASSWORD = "";
	public Connection con = null;
	public Statement stmt = null;
	public ResultSet rs = null;
	public IndexWriter writer=null;
	public StandardAnalyzer analyzer = null;		
	public File file = null;
	//method for indexing
	public IndexBuilder() {
		
	}
	
	
	
	public Connection getConnec() {

		try{
			//create statement object
			file = new File(LUCENE_INDEX_DIRECTORY);
			analyzer = new StandardAnalyzer(Version.LUCENE_CURRENT);
			writer = new IndexWriter(FSDirectory.open(file),analyzer,true,IndexWriter.MaxFieldLength.LIMITED);
			//initialize the driver class
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			//get connection object
			con = DriverManager.getConnection("jdbc:mysql://"+DB_HOST_NAME+"/test",DB_USER_NAME, DB_PASSWORD);
		}
		catch(Exception e){
			e.printStackTrace();
		}

		return con;

	} 
	
	public void buildIndexTableLogin(){
				
		try{
			
			System.out.println("Start indexing --- Login");
			
			stmt = getConnec().createStatement();
			//execute query
			rs = stmt.executeQuery("SELECT * FROM Login");
			//iterate through result set
			while(rs.next()){
				String id = rs.getString("username");
				String Password = rs.getString("password");
				System.out.println(id+"    "+Password);
				//create document object
				Document document = new Document();
				//create field objects and add to document				
				Field idField = new Field("id",id, Field.Store.YES,Field.Index.ANALYZED);
				//System.out.println("idField - -- - -> "+ idField.toString());
				document.add(idField);
				Field nameField = new Field("Password",Password, Field.Store.YES,Field.Index.ANALYZED);
				//System.out.println("nameField - -- - -> "+ nameField.toString());
				document.add(nameField);
				//add the document to writer
				writer.addDocument(document);
				
		}
			//optimize the index
			System.out.println("Optimizing index --- Login");
			writer.optimize();
 
		}catch(Exception e){
			e.printStackTrace();
		}
 	}
	
public void buildIndexTableAllocateAsset(){
try{
			
			System.out.println("Start indexing --- AllocateAsset");
			//create statement object
			stmt = getConnec().createStatement();
			//execute query
			rs = stmt.executeQuery("SELECT * FROM AllocateAsset");
			//iterate through result set
			while(rs.next()) {
				System.out.println("coming here .....");
				String assetid = rs.getString("assetid");
				String assetName = rs.getString("assetname");
				String employeeId = rs.getString("EmployeeID");
				String Name = rs.getString("Name");
				
				System.out.println(assetid+"    "+assetName+"     "+employeeId+"   "+Name);
				//create document object
				Document document = new Document();
				//create field objects and add to document				
				Field assetidField = new Field("assetid",assetid, Field.Store.YES,Field.Index.ANALYZED);
				//System.out.println("idField - -- - -> "+ idField.toString());
				document.add(assetidField);
				Field assetnameField = new Field("assetName",assetName, Field.Store.YES,Field.Index.ANALYZED);
				//System.out.println("nameField - -- - -> "+ nameField.toString());
				document.add(assetnameField);
				Field brandField = new Field("employeeId",employeeId, Field.Store.YES,Field.Index.ANALYZED);
				//System.out.println("nameField - -- - -> "+ nameField.toString());
				document.add(brandField);
				Field ipField = new Field("Name",Name, Field.Store.YES,Field.Index.ANALYZED);
				//System.out.println("nameField - -- - -> "+ nameField.toString());
				document.add(ipField);
				//add the document to writer
				writer.addDocument(document);
		}
			//optimize the index
			System.out.println("Optimizing index --- AllocateAsset");
			writer.optimize();
 
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	public void closeStream(){
		try{
			if(writer!=null)
				writer.close();
			if(rs!=null)
				rs.close();
			if(stmt!=null)
				stmt.close();
			if(con!=null)
				con.close();
			System.out.println("Finished indexing");

		}catch(Exception ex){
			ex.printStackTrace();
		}
	 }
	
	public void buildindexTableAsset()	{
		
		try{
			
			System.out.println("Start indexing --- Asset");
			//create statement object
			stmt = getConnec().createStatement();
			//execute query
			rs = stmt.executeQuery("SELECT * FROM Asset");
			//iterate through result set
			
			while(rs.next()) {
				
				System.out.println("coming here .....");
				String assetid = rs.getString("assetid");
				String assetName = rs.getString("assetname");
				String brand = rs.getString("brand");
				String ip = rs.getString("ip");
				
				System.out.println(assetid+"    "+assetName+"     "+brand+"   "+ip);
				//System.out.println(id+"    "+Password);
				//create document object
				Document document = new Document();
				//create field objects and add to document				
				Field assetidField = new Field("assetid",assetid, Field.Store.YES,Field.Index.ANALYZED);
				//System.out.println("idField - -- - -> "+ idField.toString());
				document.add(assetidField);
				Field assetnameField = new Field("assetName",assetName, Field.Store.YES,Field.Index.ANALYZED);
				//System.out.println("nameField - -- - -> "+ nameField.toString());
				document.add(assetnameField);
				Field brandField = new Field("brand",brand, Field.Store.YES,Field.Index.ANALYZED);
				//System.out.println("nameField - -- - -> "+ nameField.toString());
				document.add(brandField);
				Field ipField = new Field("ip",ip, Field.Store.YES,Field.Index.ANALYZED);
				//System.out.println("nameField - -- - -> "+ nameField.toString());
				document.add(ipField);
				//add the document to writer
				writer.addDocument(document);
		}
			//optimize the index
			System.out.println("Optimizing index --- Asset");
			writer.optimize();
 
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	public void buildIndexTableEmployee(){

		
		try{
			
			System.out.println("Start indexing --- Employee");
			//create statement object
			stmt = getConnec().createStatement();
			//execute query
			rs = stmt.executeQuery("SELECT * FROM Employee");
			//iterate through result set
			
			while(rs.next()) {
				
				System.out.println("coming here .....");
				String employeeid = rs.getString("employeeid");
				String aimChatId = rs.getString("aimChatId");
				String aimMailId = rs.getString("aimMailId");
				String appleMailId = rs.getString("appleMailId");
				String businessUnit = rs.getString("businessUnit");
				String contactNo = rs.getString("contactNo");
				String name = rs.getString("name");
				String status = rs.getString("status");
				String wiproMailId = rs.getString("wiproMailId");
				
				System.out.println(employeeid+"    "+aimChatId+"     "+aimMailId+"   "+appleMailId+"    "+businessUnit+"   "+contactNo+"   "+name+"   "+status+"  "+wiproMailId);
				
				//System.out.println(id+"    "+Password);
				//create document object
				Document document = new Document();
				//create field objects and add to document				
				Field employeeidField = new Field("employeeid",employeeid, Field.Store.YES,Field.Index.ANALYZED);
				//System.out.println("idField - -- - -> "+ idField.toString());
				document.add(employeeidField);
				
				Field aimChatIdField = new Field("aimChatId",aimChatId, Field.Store.YES,Field.Index.ANALYZED);
				//System.out.println("nameField - -- - -> "+ nameField.toString());
				document.add(aimChatIdField);
				Field aimMailIdField = new Field("aimMailId",aimMailId, Field.Store.YES,Field.Index.ANALYZED);
				//System.out.println("nameField - -- - -> "+ nameField.toString());
				document.add(aimMailIdField);
				Field appleMailIdField = new Field("appleMailId",appleMailId, Field.Store.YES,Field.Index.ANALYZED);
				//System.out.println("nameField - -- - -> "+ nameField.toString());
				document.add(appleMailIdField);
				
				Field businessunitField = new Field("businessUnit",businessUnit, Field.Store.YES,Field.Index.ANALYZED);
				//System.out.println("nameField - -- - -> "+ nameField.toString());
				document.add(businessunitField);
				
				Field contactNoField = new Field("contactNo",contactNo, Field.Store.YES,Field.Index.ANALYZED);
				//System.out.println("nameField - -- - -> "+ nameField.toString());
				document.add(contactNoField);
				
				Field nameField = new Field("name",name, Field.Store.YES,Field.Index.ANALYZED);
				//System.out.println("nameField - -- - -> "+ nameField.toString());
				document.add(nameField);
				Field statusField = new Field("status",status, Field.Store.YES,Field.Index.ANALYZED);
				//System.out.println("nameField - -- - -> "+ nameField.toString());
				document.add(statusField);
				Field wipromailidField = new Field("wiproMailId",wiproMailId, Field.Store.YES,Field.Index.ANALYZED);
				//System.out.println("nameField - -- - -> "+ nameField.toString());
				document.add(wipromailidField);
				//add the document to writer
				writer.addDocument(document);
		}
			//optimize the index
			System.out.println("Optimizing index --- Employee");
			writer.optimize();
 
		}catch(Exception e){
			e.printStackTrace();
		}	
	
	}
	public void buildIndexTableEmployeeVisa(){
try{
			System.out.println("Start indexing --- EmployeeVisa");
			stmt = getConnec().createStatement();
			//execute query
			rs = stmt.executeQuery("SELECT * FROM EmployeeVisa");
			//iterate through result set
			while(rs.next()){
				String assid = rs.getString("assid");
				String eID = rs.getString("eID");
				String VID = rs.getString("VID");
				System.out.println(assid+"    "+eID+"    "+VID);
				//create document object
				Document document = new Document();
				//create field objects and add to document				
				Field assidField = new Field("assid",assid, Field.Store.YES,Field.Index.ANALYZED);
				//System.out.println("idField - -- - -> "+ idField.toString());
				document.add(assidField);
				Field eIDField = new Field("eID",eID, Field.Store.YES,Field.Index.ANALYZED);
				//System.out.println("nameField - -- - -> "+ nameField.toString());
				document.add(eIDField);
				Field VIDField = new Field("VID",VID, Field.Store.YES,Field.Index.ANALYZED);
				//System.out.println("nameField - -- - -> "+ nameField.toString());
				document.add(VIDField);
				//add the document to writer
				writer.addDocument(document);
				
		}
			//optimize the index
			System.out.println("Optimizing index --- EmployeeVisa");
			writer.optimize();
 
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void buildIndexTableTraining(){


		
		try{
			
			System.out.println("Start indexing --- Training");
			//create statement object
			stmt = getConnec().createStatement();
			//execute query
			rs = stmt.executeQuery("SELECT * FROM Training");
			//iterate through result set
			
			while(rs.next()) {
				
				System.out.println("coming here .....");
				String trainingid = rs.getString("trainingid");
				String contactperson = rs.getString("contactperson");
				String date = rs.getString("date");
				String prerequistics = rs.getString("prerequistics");
				String time = rs.getString("time");
				String trainingdescription = rs.getString("trainingdescription");
				String trainingname = rs.getString("trainingname");
				String venue = rs.getString("venue");
				
				
				System.out.println(trainingid+"    "+contactperson+"     "+date+"   "+prerequistics+"    "+time+"   "+trainingdescription+"   "+trainingname+"   "+venue);
				
				//System.out.println(id+"    "+Password);
				//create document object
				Document document = new Document();
				//create field objects and add to document				
				Field trainingidField = new Field("trainingid",trainingid, Field.Store.YES,Field.Index.ANALYZED);
				//System.out.println("idField - -- - -> "+ idField.toString());
				document.add(trainingidField);
				
				Field contactpersonField = new Field("contactperson",contactperson, Field.Store.YES,Field.Index.ANALYZED);
				//System.out.println("nameField - -- - -> "+ nameField.toString());
				document.add(contactpersonField);
				Field dateField = new Field("date",date, Field.Store.YES,Field.Index.ANALYZED);
				//System.out.println("nameField - -- - -> "+ nameField.toString());
				document.add(dateField);
				Field prerequisticsField = new Field("prerequistics",prerequistics, Field.Store.YES,Field.Index.ANALYZED);
				//System.out.println("nameField - -- - -> "+ nameField.toString());
				document.add(prerequisticsField);
				
				Field timeField = new Field("time",time, Field.Store.YES,Field.Index.ANALYZED);
				//System.out.println("nameField - -- - -> "+ nameField.toString());
				document.add(timeField);
				
				Field trainingdescriptionField = new Field("trainingdescription",trainingdescription, Field.Store.YES,Field.Index.ANALYZED);
				//System.out.println("nameField - -- - -> "+ nameField.toString());
				document.add(trainingdescriptionField);
				
				Field trainingnameField = new Field("trainingname",trainingname, Field.Store.YES,Field.Index.ANALYZED);
				//System.out.println("nameField - -- - -> "+ nameField.toString());
				document.add(trainingnameField);
				Field venueField = new Field("venue",venue, Field.Store.YES,Field.Index.ANALYZED);
				//System.out.println("nameField - -- - -> "+ nameField.toString());
				document.add(venueField);
				
				//add the document to writer
				writer.addDocument(document);
		}
			//optimize the index
			System.out.println("Optimizing index --- Training");
			writer.optimize();
 
		}catch(Exception e){
			e.printStackTrace();
		}	
	
	
	}
	
	public void buildIndexTableVisa(){

		
		try{
			
			System.out.println("Start indexing --- Visa");
			//create statement object
			stmt = getConnec().createStatement();
			//execute query
			rs = stmt.executeQuery("SELECT * FROM Visa");
			//iterate through result set
			
			while(rs.next()) {
				
				System.out.println("coming here .....");
				String visaId = rs.getString("visaId");
				String country = rs.getString("country");
				String validFrom = rs.getString("validFrom");
				String validto = rs.getString("validTo");
				String visaType = rs.getString("visaType");
				
				System.out.println(visaId+"    "+country+"     "+validFrom+"   "+validto+"  "+visaType);
				//System.out.println(id+"    "+Password);
				//create document object
				Document document = new Document();
				//create field objects and add to document				
				Field visaIdField = new Field("visaId",visaId, Field.Store.YES,Field.Index.ANALYZED);
				//System.out.println("idField - -- - -> "+ idField.toString());
				document.add(visaIdField);
				Field countryField = new Field("country",country, Field.Store.YES,Field.Index.ANALYZED);
				//System.out.println("nameField - -- - -> "+ nameField.toString());
				document.add(countryField);
				Field validFromField = new Field("validFrom",validFrom, Field.Store.YES,Field.Index.ANALYZED);
				//System.out.println("nameField - -- - -> "+ nameField.toString());
				document.add(validFromField);
				Field validtoField = new Field("validto",validto, Field.Store.YES,Field.Index.ANALYZED);
				//System.out.println("nameField - -- - -> "+ nameField.toString());
				document.add(validtoField);
				
				Field visaTypeField = new Field("visaType",visaType, Field.Store.YES,Field.Index.ANALYZED);
				//System.out.println("nameField - -- - -> "+ nameField.toString());
				document.add(visaTypeField);
				//add the document to writer
				writer.addDocument(document);
		}
			//optimize the index
			System.out.println("Optimizing index --- Visa");
			writer.optimize();
 
		}catch(Exception e){
			e.printStackTrace();
		}	
	
	}
	public static void main(String[] args) throws Exception {
 
		try{
			IndexBuilder builder = new IndexBuilder();
			//builder.buildIndexTableLogin();
			//builder.closeStream();
			
			builder.buildindexTableAsset();
			builder.closeStream();
			
			//builder.buildIndexTableAllocateAsset();
			//builder.closeStream();
			
			//builder.buildIndexTableEmployee();
			//builder.closeStream();
			
			//builder.buildIndexTableEmployeeVisa();
			//builder.closeStream();
			
			//builder.buildIndexTableTraining();
			//builder.closeStream();
			
			//builder.buildIndexTableVisa();
			//builder.closeStream();
			
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
}