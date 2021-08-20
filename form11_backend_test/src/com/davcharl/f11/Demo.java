package com.davcharl.f11;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.davcharl.f11.model.TaxPayer;

public class Demo {

	public static void main(String[] args) {
		
		/*
		// Create taxpayer object and print out - no hibernate
		TaxPayer testTaxPayer = new TaxPayer(
				"1234567AB", "Jeremy", "Noriega", LocalDate.of(1990,8,20), "david@mail.com",  "");
		System.out.println(testTaxPayer.toString() );
		*/
		
		TaxPayer myTaxPayer;
		TaxPayer retrievedTaxPayer;
		List<TaxPayer> listOfAllTaxPayers;
		
		// Create Factory session
		SessionFactory factory = createFactorySession();
		// Create Session
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			/*
			// Create object to persist
			myTaxPayer = new TaxPayer(
					"8123456BZ", "Jasper", "Hodgsen", LocalDate.of(1977,12,30), "ghostwriter@mail.com",  "\\\\folder-structure\\1111-vnsk-sd89sher-df98ehe-dfoudkjfvnkjdnkj\\uwiuviurs.xml");
			// Persist Taxpayer object
			saveTaxpayer(myTaxPayer, session);
			*/
			
			/*
			// Retrieve one record
			String recordToRetrieve = "8123456BZ";
			retrievedTaxPayer = session.get(TaxPayer.class, recordToRetrieve);
			System.out.println("\n" + recordToRetrieve + "\nLast Name: " + retrievedTaxPayer.getLastName() + "\nemail: " + retrievedTaxPayer.getEmail());			
			*/
			
			/*
			// Retrieve all records
			listOfAllTaxPayers = retrieveAllRecords(session);	
			displayAllRecords(listOfAllTaxPayers);
			*/
			
			/*
			// Delete a record based on PK
			System.out.println("Delete a record");
			deleteNamedTaxPayer(session, "Erika");
			*/

			

			session.close();
			
		} catch(Exception exc) {
			exc.printStackTrace();
		} finally {
			System.out.println("Exit application");
		}
		
	}

	private static void deleteNamedTaxPayer(Session session, String name) {
		TaxPayer retrievedTaxPayer;
		List<TaxPayer> listOfAllTaxPayers;
		StringBuilder query = new StringBuilder();
		query.append("from TaxPayer t where t.firstName = '");
		query.append(name);
		query.append("'");
		listOfAllTaxPayers = session.createQuery(query.toString()).getResultList();
		retrievedTaxPayer = listOfAllTaxPayers.get(0);
		session.delete(retrievedTaxPayer);
		session.getTransaction().commit();
	}

	private static void displayAllRecords(List<TaxPayer> listOfAllTaxPayers) {
		listOfAllTaxPayers.stream().forEach( t -> System.out.println(t.toString()) );
	}

	private static List<TaxPayer> retrieveAllRecords(Session session) {
		List<TaxPayer> listOfAllTaxPayers;
		System.out.println("\nAll Records:\n");
		listOfAllTaxPayers = session.createQuery("from TaxPayer").getResultList();
		return listOfAllTaxPayers;
	}

	private static void saveTaxpayer(TaxPayer myTaxPayer, Session session) {
		// Open session
		System.out.println("\nStarting transaction.");

		// Persist object to database
		session.save(myTaxPayer);
		session.getTransaction().commit();
		System.out.println("\nTransaction completed successfully.");
	}

	private static SessionFactory createFactorySession() {
		// Create SessionFactory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(TaxPayer.class)
				.buildSessionFactory();
		return factory;
	}

}
