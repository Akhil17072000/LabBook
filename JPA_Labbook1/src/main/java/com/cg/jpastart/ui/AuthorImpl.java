package com.cg.jpastart.ui;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.cg.jpastart.entities.Author;
import com.cg.jpastart.util.JPAUtil;

public class AuthorImpl {

	static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		AuthorMenu[] menus = AuthorMenu.values();
		AuthorMenu selectedMenu = null;

		while (selectedMenu != AuthorMenu.Quit) {
			System.out.println("University Staff Member Operation");
			for (AuthorMenu menu : menus) {
				System.out.println(menu.ordinal() + "\t" + menu);
			}
			System.out.print("Enter choice : ");
			int ch = scan.nextInt();

			if (ch >= 0 && ch <= menus.length) {
				selectedMenu = menus[ch];

				switch (selectedMenu) {
				case Add_Author:
					doAdd();
					break;
				case Update_Author:
					doUpdate();
					break;
				case Show_Author_By_AuthorId:
					doFind();
					break;
				case Remove_Author:
					doRemove();
					break;
				default:
					break;
				}
			} else {
				selectedMenu = null;
			}

		}
		scan.close();
		System.out.println("Application Terminated");

	}

	private static void doAdd() {
		EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
		EntityManager em = factory.createEntityManager();

			System.out.print("Enter First Name :");
			String firstName = scan.next();
			System.out.print("Enter Middle Name :");
			String middleName = scan.next();
			System.out.print("Enter Last Name :");
			String lastName = scan.next();
			System.out.print("Enter Phone Number :");
			String number = scan.next();
			
			Author author = new Author(firstName,middleName,lastName,number);
			
			EntityTransaction txn = em.getTransaction();

			txn.begin();
			em.persist(author);
			txn.commit();
			
			System.out.println("Author Added");

	}

	private static void doUpdate() {
		System.out.print("Enter Author Id whose details are to be updated :");
		int authorId = scan.nextInt();
		
		EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		try {
			Author author = em.find(Author.class, authorId);
			if (author == null) {
				throw new Exception("No author details updation with #" + authorId + " is possible as it doesn't exist.");
			} else {
				System.out.print("Enter Updated First Name :");
				String firstName = scan.next();
				author.setFirstName(firstName);
				System.out.print("Enter Updated Middle Name :");
				String middleName = scan.next();
				author.setMiddleName(middleName);
				System.out.print("Enter Updated Last Name :");
				String lastName = scan.next();
				author.setLastName(lastName);
				System.out.print("Enter Updated Phone Number :");
				String number = scan.next();
				author.setPhoneNo(number);
				
				txn.begin();
				em.persist(author);
				txn.commit();
				
				System.out.println("Author details updated");
			}
		} catch (Exception excep) {
			System.out.println("Unable to update author");
		}
	}

	private static void doFind() {
		System.out.println("Enter Author Id :");
		int authorId = scan.nextInt();
		
		EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
		EntityManager em = factory.createEntityManager();
		
		try {
		Author author = em.find(Author.class, authorId);
		if (author == null) {
			throw new Exception("No author details with #" + authorId);
		} else {
				System.out.println(author);
			}
		} catch (Exception excep) {
			System.out.println("No author with provided id");
		}
	}

	private static void doRemove() {
		try {
			EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
			EntityManager em = factory.createEntityManager();
			EntityTransaction txn = em.getTransaction();
			
			System.out.println("Enter Author Id :");
			int authorId = scan.nextInt();
			Author author = em.find(Author.class, authorId);
			if (author == null) {
				throw new Exception("No author with id #" + authorId);
			} else {
				txn.begin();
				em.remove(author);
				txn.commit();
				
				System.out.println("Author details removed");
			}
		} catch (Exception excep) {
			System.out.println("Author not removed");
		}
	}
}
