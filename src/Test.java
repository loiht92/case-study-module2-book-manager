import module2.Book;
import module2.BookManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        List<Book> bookList = new ArrayList<>();
        int choose;
        int bookId;
        String bookAuthor;
        BookManager bookManager = new BookManager(bookList);

        showMenu();

        while (true) {
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    bookManager.addBook(bookList);
                    break;
                case 2:
                    bookId = bookManager.inputID();
                    bookManager.deleteBook(bookList, bookId);
                    break;
                case 3:
                    bookId = bookManager.inputID();
                    bookManager.editBook(bookList, bookId);
                    break;
                case 4:
                    bookAuthor = bookManager.inputAuthor();
                    bookManager.search(bookList, bookAuthor);
                    break;
                case 5:
                    System.out.println(BookManager.selectionSortByPrice(bookList) );
                    break;
                case 6:
                    bookManager.shortBookByName(bookList);
                    break;
                case 7:
                    bookManager.show(bookList);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Bạn vui lòng chọn lại !!");
                    break;
            }
            showMenu();
        }

    }
    public static void showMenu(){
        System.out.println("-----------------Menu---------------");
        System.out.println("1: Thêm thông tin các quyển sách. ");
        System.out.println("2: Xoá thông tin cuốn sách. ");
        System.out.println("3: Chỉnh sửa thông tin sách. ");
        System.out.println("4: Tìm kiếm sách theo tác giả. ");
        System.out.println("5: Sắp xếp giá bán theo thuật toán sắp xếp chèn. ");
        System.out.println("6: Sắp xếp sách theo tên. ");
        System.out.println("7: Hiển thị thông tin các quyển sách.");
        System.out.println("0: Thoát. ");
        System.out.println("-----------------------------------");
    }
}
