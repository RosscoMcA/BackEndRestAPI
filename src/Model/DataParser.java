package Model;


import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;


public class JSONDataParser {

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
             switch(key)
             {
                 case "id":
                     newProduct.setId(value);
                     break;
                 case "name":
                     newProduct.setName(value);
                     break;

                 case "description":
                     newProduct.setDescription(value);
                     break;

                 case "type":
                     newProduct.setType(value);
                     break;
                 case "department":
                     newProduct.setDepartment(value);
                     break;
                 case "weight":
                     newProduct.setWeight(value);
                     break;
                 case "price":

                     break;
                 default :
                     //Unexpected content found, send empty Product
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

            switch(key)
            {
                case "value":
                    newPrice.setValue(Double.parseDouble(value));
                    break;

                case "currency":
                    newPrice.setCurrency(value);
                    break;
                default:
                    return new Price();

            }
        }

        return newPrice;
    }
}
