package Model;
//POJO for handling all product data
public class Product {

    private String id;
    private String name;
    private String weight;
    private Price price;
    private String type;
    private String department;

    public Product(String id, String name, String weight, Price price, String type, String department) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.type = type;
        this.department = department;
    }
}

