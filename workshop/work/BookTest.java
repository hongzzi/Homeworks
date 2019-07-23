package com.ssafy.work;

public class BookTest {

	// BookTest - > stateless, 한개만 필요
	public static void main(String[] args) {
		Book book1 = new Book("21424", "Java Basic", "김하니", "Jean.kr", 15000, "Java 기본 문법");
		Book book2 = new Book("33455", "JDBC Pro", "김철수", "Jean.kr", 23000);
		Book book3 = new Book("5355", "Servlet/JSP", "박자바", "Jean.kr", 41000,"Model2 기반");
		Book book4 = new Book("3332", "Android App", "홍길동", "Jean.kr", 25000, "Lightweight Framework");
		Book book5 = new Book("35355", "OOAD분석, 설계", "소나무", "Jean.kr", 30000);
		
		Magazine magazine1 = new Magazine("35535", "Java World", "편집부", "Jean.kr", 2013, 2, 7000);
		Magazine magazine2 = new Magazine("33434", "Mobile World", "편집부", "Jean.kr", 2013, 8, 8000);
		Magazine magazine3 = new Magazine("75342", "Next Web", "편집부", "Jean.kr", 2012, 10, 10000,"AJAX 소개");
		Magazine magazine4 = new Magazine("76543", "Architecture", "편집부", "Jean.kr", 2010, 3, 5000,"java 시스템");
		Magazine magazine5 = new Magazine("76534", "Data Modeling", "편집부", "Jean.kr", 2012, 12, 14000);
		
		Book [] books = {book1, book2, book3, book4, book5, magazine1, magazine2, magazine3, magazine4, magazine5};
	
		BookManager bm = BookManager.getBookManager();
		
		// 데이터 입력 기능
		for(Book book : books) {
			bm.addBook2(book);
		}
	
		
		// 데이터 전체 검색 기능
		Book [] stored = bm.readAllBooks();
		for(Book book : stored) {
			System.out.println(book);
		}
		
		// ISBN 으로 정보를 검색하는 기능
		System.out.println("============Isbn 검색============");
		System.out.println(bm.getBookByIsbn("75342"));
		
		// Title로 정보를 검색하는 기능 ( 파라미터로 주어진 제목을 포함하는 모든 정보 )
		System.out.println("============title 검색============");
		Book [] getTitle = bm.getBookByTitle("J");
		for (Book book : getTitle) {
			System.out.println(book.toString());
		}
		
		// Book만 검색하는 기능
		System.out.println("============BookType 검색============");
		Book [] getBookType = bm.getAllBookType();
		for (Book book : getBookType) {
			System.out.println(book.toString());
		}
		
		
		// Magazine만 검색하는 기능
		
		// Magazine중 올해 잡지만 검색하는 기능
		
		// 출판사로 검색하는 기능
		
		// 가격으로 검색하는 기능
		
		// 저장된 모든 도서의 금액 합계를 구하는 기능
		
		// 저장된 모든도서의 금액 평균을 구하는 기능 
	}
}
