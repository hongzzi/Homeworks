package com.ssafy.work;

public class Magazine extends Book {

	int year;
	int month;
	
	public Magazine() {}
	
	public Magazine(String isbn, String title, String author, String publisher, int year, int month, int price,
			String desc) {

		super(isbn, title, author, publisher, price, desc);
		this.year = year;
		this.month = month;
	}
	
	public Magazine(String isbn, String title, String author, String publisher, int year, int month, int price) {

		this(isbn, title, author, publisher, year, month, price, "");
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}


	public String toString() {
		return super.toString()+"|"+year+"."+month;
	}
	
}
