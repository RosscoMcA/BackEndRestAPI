package Utils;


import Model.Price;
import Model.Product;
import Model.ProductList;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;


public class DataParser {

    private ProductList productList = new ProductList();

    /**
     *
     * @param path
     */
    public void loadFile(String path)
    {
        try {
            JSONParser parser = new JSONParser();

            JSONArray products =(JSONArray) parser.parse(new FileReader(path));

            for (int i = 0; i < products.size(); i++) {
                Map item = (Map) products.get(i);
                Product prod = parseProductData(item.entrySet().iterator());
                Map price = (Map) ((Map) products.get(i)).get("price");
                Price newPrice = parsePriceData(price.entrySet().iterator());
                prod.setPrice(newPrice);
                productList.addProduct(prod);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    /**
     *
     * @param items
     * @return
     * @throws Exception
     */
    private Product parseProductData(Iterator<Map.Entry>items) throws Exception
    {
        Product newProduct= new Product();
        while(items.hasNext())
        {
            Map.Entry item= (Map.Entry)items.next();
            String key = item.getKey().toString();
            String value = item.getValue().toString();
            if ("id".equals(key)) {
                newProduct.setId(value);
            } else if ("name".equals(key)) {
                newProduct.setName(value);
            } else if ("description".equals(key)) {
                newProduct.setDescription(value);
            } else if ("type".equals(key)) {
                newProduct.setType(value);
            } else if ("department".equals(key)) {
                newProduct.setDepartment(value);
            } else if ("weight".equals(key)) {
                newProduct.setWeight(value);
            } else if ("price".equals(key)) {
            } else {//Unexpected content found, send empty Product
                return new Product();
            }

        }

        return newProduct;
    }

    /**
     *
     * @param items
     * @return
     * @throws Exception
     */
    private Price parsePriceData(Iterator<Map.Entry>items) throws Exception
    {
        Price newPrice = new Price();
        while(items.hasNext())
        {
            Map.Entry item = (Map.Entry) items.next();
            String key = item.getKey().toString();
            String value = item.getValue().toString();

            if ("value".equals(key)) {
                newPrice.setValue(Double.parseDouble(value));
            } else if ("currency".equals(key)) {
                newPrice.setCurrency(value);
            } else {
                return new Price();
            }
        }

        return newPrice;
    }

    public ProductList retrieveProductList()
    {
        return productList;
    }
}
