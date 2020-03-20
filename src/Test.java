import module2.Book;
import module2.BookManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        showMenu();
        List<Book> bookList = new ArrayList<>();
        int choose;
        int bookId;
        String bookAuthor;
        String bookName;
        int bookPrice;
        String bookOrigin;

        BookManager bookManager = new BookManager(bookList);
        //showMenu();
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
                    bookManager.searchAuthor(bookList, bookAuthor);
                    break;
                case 5:
                    bookName = bookManager.inputName();
                    bookManager.searchName(bookList, bookName);
                    break;
                case 6:
                    bookPrice = bookManager.inputPrice();
                    bookManager.searchPrice(bookList, bookPrice);
                    break;
                case 7:
                    bookOrigin = bookManager.inputOrigin();
                    bookManager.searchOrigin(bookList, bookOrigin);
                    break;
                case 8:
                    System.out.println(BookManager.selectionSortByPrice(bookList) );
                    break;
                case 9:
                    System.out.println(BookManager.insertionSortByPrice(bookList));
                    break;
                case 10:
                    bookManager.shortBookByName(bookList);
                    break;
                case 11:
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
        System.out.println("5: Tìm kiếm sách theo tên sách. ");
        System.out.println("6: Tìm kiếm sách theo giá sách. ");
        System.out.println("7: Tìm kiếm sách theo xuất xứ sách. ");
        System.out.println("8: Sắp xếp giá bán theo thuật toán sắp xếp chèn. ");
        System.out.println("9: Sắp xếp giá bán theo thuật toán sắp xếp chọn. ");
        System.out.println("10: Sắp xếp sách theo tên. ");
        System.out.println("11: Hiển thị thông tin các quyển sách.");
        System.out.println("0: Thoát. ");
        System.out.println("-----------------------------------");
    }
}