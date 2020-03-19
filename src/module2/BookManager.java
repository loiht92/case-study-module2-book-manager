package module2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BookManager {
    public static Scanner scanner = new Scanner(System.in);
    private static XuLyFile xuLyFile;

    public BookManager(List<Book> bookList) throws Exception {
        xuLyFile = new XuLyFile();
        addBook(bookList);

        xuLyFile.write("/Users/holoi/IdeaProjects/Case Study Module2/file.txt",bookList);
        xuLyFile.read(bookList);
    }

    public void addBook(List<Book> bookList) throws Exception {
        int id = (bookList.size() > 0) ? (bookList.size() + 1) : 1;
        System.out.println("ID:" +id);
        String name = inputName();
        String author = inputAuthor();
        int price = inputPrice();
        String origin = inputOrigin();

        Book book = new Book(id,name,author,price,origin);
        bookList.add(book);
       xuLyFile.write("/Users/holoi/IdeaProjects/Case Study Module2/file.txt",bookList);
    }

    public void deleteBook(List<Book> bookList, int id) throws Exception {
        Book book = null;
        for (Book value : bookList) {
            if (value.getId() == id) {
                book = value;
                break;
            }
        }
        if (book != null){
            bookList.remove(book);
            xuLyFile.write("/Users/holoi/IdeaProjects/Case Study Module2/file.txt",bookList);
        }else {
            System.out.println("ID không tồn tại !");
        }
    }

    public void editBook(List<Book> bookList, int id) throws IOException {
        boolean isExisted = false; //lúc đầu mặc định là chưa thấy.
        for (Book book : bookList) {
            if (book.getId() == id) {
                isExisted = true;
                try {
                    book.setName(inputName());
                    book.setAuthor(inputAuthor());
                    book.setPrice(inputPrice());
                    book.setOrigin(inputOrigin());
                    break;
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        if (!isExisted) {
            System.out.println("Id không hợp lệ !");
        }
        xuLyFile.write("/Users/holoi/IdeaProjects/Case Study Module2/file.txt",bookList);
    }
    public void search(List<Book> bookList, String author){
        System.out.println("Nhập tên cần tìm kiếm.");
         author = scanner.nextLine();
        for (Book book : bookList) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                book.show();
            }
        }
    }

    public static String  selectionSortByPrice(List<Book> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            Book currentMin = list.get(i);
            int currentIndex = list.indexOf(list.get(i));

            for (int j = i + 1; j < list.size(); j++) {
                if (currentMin.getPrice() > list.get(j).getPrice()) {
                    currentMin = list.get(j);
                    currentIndex = list.indexOf(list.get(j));
                }
            }

            if (currentIndex != i) {
                list.set(currentIndex, list.get(i));
                list.set(i, currentMin);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (Book book : list) {
            String bookInfo = book.toString();
            builder.append(bookInfo).append("\n");
        }
        return builder.toString();
    }


//        return list.stream().map(i -> i.toString().concat("\n")).collect(Collectors.joining());



    public void shortBookByName(List<Book> bookList){
        ShortBookByName shortBookByName = new ShortBookByName();
        bookList.sort(shortBookByName);
    }

    public int inputID() {
        System.out.println("Nhập ID:");
        while (true) {
            try {
                int id = Integer.parseInt(scanner.nextLine());
                return id;
            } catch (NumberFormatException e) {
                System.out.println("Không hợp lệ ! Mời bạn nhập lại.");
            }
        }
    }
    private String inputName(){
        System.out.println("Nhập tên sách:");
        while (true) {
            try {
                return scanner.nextLine();
            }catch (NumberFormatException e){
                System.out.println("Tên nhập vào không hợp lê, bạn vui lòng nhập lại !");
            }
        }
    }
    public String inputAuthor(){
        System.out.println("Nhập tên tác giả:");
        while (true){
            try {
                String author = scanner.nextLine();
                if (author.isEmpty() || author.length() > 20){
                    System.out.println("Tên không tồn tại hoặc vượt quá giới hạn cho phép.");
                }
                return author;
            }catch (NumberFormatException e){
                System.out.println("Tên nhập vào không hợp lê, bạn vui lòng nhập lại !");
            }
        }
    }
    private int inputPrice(){
        System.out.println("Nhập giá bán:");
        while (true){
            try {
                int price = Integer.parseInt(scanner.nextLine());
                if (price < 0 || price > 500000){
                    throw new NumberFormatException();
                }
                return price;
            }catch (NumberFormatException e){
                System.out.println("Không hợp lệ ! Mời bạn nhập lại.");
            }
        }
    }
    private String inputOrigin(){
        System.out.println("Nhập xuất xứ hàng bán:");
        while (true){
            try {
                String origin = scanner.nextLine();
                if (origin.isEmpty() || origin.length() > 20){
                    System.out.println("Tên không tồn tại hoặc vượt quá giới hạn cho phép.");
                }
                return origin;
            }catch (NumberFormatException e){
                System.out.println("Không hợp lệ ! Mời bạn nhập lại.");
            }
        }
    }
    public void show(List<Book> bookList){
        for (Book book : bookList){
            System.out.format("ID:%2d | ", book.getId());
            System.out.format("Tên sản phẩm:%4s | ", book.getName());
            System.out.format("Tác giả:%6s | ", book.getAuthor());
            System.out.format("Giá bán:%2d | ", book.getPrice());
            System.out.format("Xuất xứ:%4s | ", book.getOrigin());
            System.out.println();
        }
    }
}
