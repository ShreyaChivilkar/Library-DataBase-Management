package Lib;

public interface Admin {
	public void insertBook(String bookName, String author, int n);
	public void checkStock(String bookName, String author);
	public final int stock = 5;
}
