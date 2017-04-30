package main.java.scratchpad.app.Misc;

import java.util.Scanner;

import com.mongodb.DBCollection;

import main.java.scratchpad.Database.IConnect;
import main.java.scratchpad.MongoDB.Entities.Collection.BasicCollectionOperations;
import main.java.scratchpad.MongoDB.Entities.Document.BasicDocumentOperations;
import main.java.scratchpad.MongoDB.connection.Connect;

public class Main {

	public void hello() {
		try {
			// Display welcome greeting
			System.out.println("==== Welcome to ScratchPad ====");
			System.out.println("What would you like to do today?");
			System.out.println("1. Add a document");
			System.out.println("2. Display all the document\n");
			
			// Take input from the user
			System.out.println("Input: ");
			Scanner in = new Scanner(System.in);
			String option = in.nextLine().trim();
	 
			// To connect to mongodb server
	        IConnect conn = new Connect();
	        DBCollection coll = conn.connect();
	        
	        // Do operations as per user.
	        if (option.equals("1")) {
				// Add document
	        	BasicDocumentOperations op = new BasicDocumentOperations(coll); 
	        	System.out.println("\n\nEnter Title: ");
				String title = in.nextLine();
				System.out.println("\nEnter description: ");
				String description = in.nextLine();
				op.Add(title, description);
			} else {
				// Display all the documents.
				BasicCollectionOperations op = new BasicCollectionOperations(coll);
				op.ShowAllDisplay();
			}
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
