package com.wipro.portal.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/Finder.htm")
public class FinderController extends BaseController {
	
	String keyword="";
//String Uquery="";
private static final long serialVersionUID = 1L;
static final String LUCENE_INDEX_DIRECTORY = "/Users/mandeepsingh/Desktop/index/";

	public String doGet(AppService appService) {
		_log.info("Login controller : doGet Called");
		doPost(appService);
		return "Finder";
	}

	public String doPost(AppService appService) {

	    _log.info("PLogin  Controller : doPost Called");
	    IndexReader reader = null;
	 	StandardAnalyzer analyzer = null;
	 	IndexSearcher searcher = null;
	 	TopScoreDocCollector collector = null;
	 	QueryParser parser = null;
	 	Query query = null;
	 	ScoreDoc[] hits = null;
	     keyword = (String) appService.getRequest().getParameter("keyword");
		 System.out.println("   keyword     --- > "+keyword);
		if(keyword != null){
			try{
				System.out.println("Analyzing");
				analyzer = new StandardAnalyzer(Version.LUCENE_CURRENT);
				//create File object of our index directory
				File file = new File(LUCENE_INDEX_DIRECTORY);
				//create index reader object
				reader = IndexReader.open(FSDirectory.open(file),true);
				//create index searcher object
				searcher = new IndexSearcher(reader);
				//create topscore document collector
				collector = TopScoreDocCollector.create(1000, false);
				//create query parser object
				parser = new QueryParser(Version.LUCENE_CURRENT,"assetid", analyzer);   //new QueryParser(null, "fulltext", analyzer);
				//parse the query and get reference to Query object
				query = parser.parse(keyword);
				//search the query
				
				searcher.search(query, collector);
				hits = collector.topDocs().scoreDocs;
				//check whether the search returns any result
				if(hits.length>0){
					for(int i=0; i<hits.length; i++){
						int scoreId = hits[i].doc;
						//now get reference to document
						Document document = searcher.doc(scoreId);
						//System.out.println("UN  : "+document.getField("id").stringValue()+" PASS : "+document.getField("Password").stringValue());
						
						System.out.println("Asset Id:   "+document.getField("assetid").stringValue()+"   Asset Name:   "+document.getField("assetName").stringValue()+"Brand:  "+document.getField("brand").stringValue()+"IP:  "+document.getField("ip").stringValue());
					}
					
				}
				else{
					System.out.println("No Records");
				}
	 
	 
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				if(reader!=null)
					try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
			

		return "Finder";
	}
	
}
