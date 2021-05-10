package com.cg.jpastart.ui;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cg.jpastart.entities.Author;
import com.cg.jpastart.entities.Book;
import com.cg.jpastart.util.JPAUtil;

public class OperationsImpl {

	static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		OperationsMenu[] menus = OperationsMenu.values();
		OperationsMenu selectedMenu = null;

		while (selectedMenu != OperationsMenu.Quit) {
			System.out.println("University Staff Member Operation");
			for (OperationsMenu menu : menus) {
				System.out.println(menu.ordinal() + "\t" + menu);
			}
			System.out.print("Enter choice : ");
			int ch = scan.nextInt();

			if (ch >= 0 && ch <= menus.length) {
				selectedMenu = menus[ch];

				switch (selectedMenu) {
				case FindAll:
					doFindAllBooks();
					break;
				case FindAll_By_AuthorId:
					doFindByAuthorId();
					break;
				case FindAll_In_Range:
					doFindInRange();
					break;
				case Show_Author_By_BookId:
					doShowById();
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

	/**
	 * fetching author details for given course Id
	 */
	private static void doShowById() {
		EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
		EntityManager em = factory.createEntityManager();

		System.out.println("Enter Book Id");
		int bookId = scan.nextInt();
		Book book = em.find(Book.class, bookId);
		if (book == null) {
			System.out.println("No book present with this id");
		} else {
			Author author = book.getAuthor();
			System.out.println(author);
		}
	}

	/**
	 * listing all books in an inclusive price range
	 */
	private static void doFindInRange() {
		EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
		EntityManager em = factory.createEntityManager();

		System.out.println("Enter Min Price");
		int minPrice = scan.nextInt();
		System.out.println("Enter Max Price");
		int maxPrice = scan.nextInt();

		Query q = em.createQuery("select e from Book e where price between :a and :b");
		q.setParameter("a", minPrice);
		q.setParameter("b", maxPrice);

		List<Book> id = q.getResultList();
		if (id != null)
			id.forEach(System.out::println);
		else
			System.out.print("No books in this range");
	}

	/**
	 * all books written by a given author name
	 */
	private static void doFindByAuthorId() {
		EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
		EntityManager em = factory.createEntityManager();

		System.out.println("Enter Author Id");
		int authorId = scan.nextInt();
		Author author = em.find(Author.class, authorId);
		if (author == null) {
			System.out.println("No books written by the author");
		} else {
			List<Book> books = author.getBook();
			if (books.isEmpty()) {
				System.out.println("No books written by the author");
			} else {
				for (Book book : books) {
					System.out.println(book);
				}

			}
		}
	}

	/**
	 * listing all the books in database
	 */
	private static void doFindAllBooks() {
		EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
		EntityManager em = factory.createEntityManager();

		String jpql = "SELECT e FROM Book e";
		TypedQuery<Book> tqry = em.createQuery(jpql, Book.class);
		List<Book> ls = tqry.getResultList();
		ls.forEach(System.out::println);

	}

}
