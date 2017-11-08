public class Book {
    private String name;
    private Author author;
    private double price;
    private int qty;

    public Book()
    {
        name = "book example name";
        author = new Author();
    }
    public Book(String ... arData) throws NumberFormatException
    {
        name = arData[0];
        author = new Author(arData[1]);
        price = Double.parseDouble(arData[2]);
        qty = Integer.parseInt(arData[3]);
        if (qty <= 0 || price <= 0.0) throw new NumberFormatException();
    }
    public Book(double price, Author author, String name) {
        this.price = price;
        this.author = author;
        this.name = name;
    }

    public Book(String name, int qty, double price, Author author) {
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public int getQty() {
        return qty;
    }

    public double getPrice() {
        return price;
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!name.equals(book.name)) return false;
        return author.equals(book.author);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + author.hashCode();
        return result;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author=" + author +
                ", price=" + price +
                ", qty=" + qty +
                '}';
    }
}