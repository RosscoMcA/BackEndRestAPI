package Test;


import Model.DataParser;

public class TestJSONParser {
    public static void main(String args[]){
        DataParser parser = new DataParser();
        parser.loadFile("products.json");
    }
}
