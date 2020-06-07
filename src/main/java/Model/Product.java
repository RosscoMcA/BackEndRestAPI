package Model;
//POJO for handling all product data

public class Product {

    private String id;
    private String name;
    private String weight;
    private Price price;
    private String type;
    private String department;
    private String description;

    Product(String id, String name, String weight, Price price, String type, String department) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.type = type;
        this.department = department;
    }

    public Product()
    {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

