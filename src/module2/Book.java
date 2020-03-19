package module2;

public class Book {
    private int id;
    private String name;
    private String author;
    private int price;
    private String origin;

    public Book(){

    }
    public Book(int id, String name, String author, int price, String origin){
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.origin = origin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public void show(){
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Book : [" +
                "Id:" + id + '\t' + "| Name:" + name + '\t' + "| Author:" + author + '\t' +
                "| Price:" + price + '\t' + "| Origin:" + origin + '\t' + ']';
    }
}
