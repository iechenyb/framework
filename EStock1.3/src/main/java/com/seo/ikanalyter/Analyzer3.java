package com.seo.ikanalyter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.queryparser.xml.ParserException;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

/**
 *  <dependency>
            <groupId>org.apache.lucene</groupId>
            <artifactId>lucene-core</artifactId>
            <version>5.3.1</version>
        </dependency>
        <dependency>
            <groupId>org.apache.lucene</groupId>
            <artifactId>lucene-queryparser</artifactId>
            <version>5.3.1</version>
        </dependency>
 * @author DHUser
 *
 */
public class Analyzer3 {
	 public static void indexFile() throws IOException {
	        Directory dir = FSDirectory.open(Paths.get("d:/MyIndex"));
	        Analyzer analyzer = new IKAnalyzer();
	        IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
	        IndexWriter writer = new IndexWriter(dir, iwc);
	        File path=new File("d:\\MyIndex\\doc");
	        File [] file= path.listFiles();
	        for(File f:file){
	            String tile=f.getName();
	            String content="";
	            BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(f),"utf-8"));
	            String line="";
	            while (null!=(line=br.readLine())) {
	                content+=line;
	            }
	            Document doc = new Document();
	            doc.add(new TextField("name", tile, Field.Store.YES));
	            doc.add(new TextField("content", content,Field.Store.YES));
	            writer.addDocument(doc);
	            System.out.println("add " + tile);  
	        }
	        writer.close();
	    }
	public static void main(String[] args) throws IOException { 
		try {
			indexFile();
			search();
		} catch (ParserException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
    }  
	public static void search() throws IOException, ParserException, ParseException {
        Analyzer analyzer = new IKAnalyzer();
        IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get("d:/MyIndex")));
        IndexSearcher searcher = new IndexSearcher(reader);
        QueryParser parser = new QueryParser("name", analyzer);
        String queries = "奥巴马";
        Query query = parser.parse(queries);
        System.out.println("Searching for: " + query.toString(queries));
        TopDocs results = searcher.search(query, 10);
        System.out.println("Total match：" + results.totalHits);
        ScoreDoc[] hits = results.scoreDocs;
        int count = 1;
        for (ScoreDoc hit : hits) {
            Document doc1 = searcher.doc(hit.doc);
            String res = doc1.get("name");
            System.err.println(count + "  " + res + ", " + hit.score);
            count++;
        }

    }
}
