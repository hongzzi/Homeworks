package com.ssafy.work;

public class BookManager {

	Book[] books = new Book[10];

	private static BookManager bm = new BookManager();
	
	public static BookManager getBookManager() {
		return bm;
	}
	/**
	 * 전달받은 Book을 books에 저장. 단 배열의 요소가 null일 때,
	 * 
	 * @param book
	 * @return
	 */
	
	// 생성자
	private BookManager() {}	//싱글턴은 private이 기본임 

	public BookManager(Book[] books) {
		this.books = books;
	}
	
		
	public Book[] getBooks() {
		return books;
	}

	public void setBooks(Book[] books) {
		this.books = books;
	}

	
	public boolean addBook(Book book) {
		for (Book b : books) {
			if (b == null) {
				b = book;
				return true;
			} else {

			}

		}
		return false;
	}
	

	public boolean addBook2(Book book) {
		for(int i =0; i<books.length; i++) {
			Book stored = books[i];
			if (stored == null) {
				books[i] = book;
				return true;
			}
		}
		return false;
	}
	
	
	public Book[] readAllBooks() {
		return books;
	}
	
	
	public Book getBookByIsbn(String isbn) {
		Book searched = null;
		for(Book temp : books) {
			if (temp.getIsbn().equals(isbn)) {
				searched = temp;
			}
		}
		return searched;
	}
	
	
	public Book[] getBookByTitle(String title) {
		Book [] temp = new Book[10];
		int idx = 0;
		for(int i =0; i<books.length; i++) {
			if(books[i].title.contains(title)) {
				temp[idx++] = books[i];
			}
		}
		Book [] result = new Book[idx];
		System.arraycopy(temp, 0, result, 0, result.length);
		return result;
		
	}
	
	public Book[] getAllBookType() {
		Book [] temp = new Book[10];
		int idx = 0;
		for(Book book : books) {
			if(!(book instanceof Magazine)) {
				temp[idx++] = book;
			}
		}
		Book [] result = new Book[idx];
		System.arraycopy(temp, 0, result, 0, result.length);
		return result;
	}
}
