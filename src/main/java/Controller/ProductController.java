package Controller;

import Model.Product;
import Model.ProductList;
import Utils.DataParser;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @RequestMapping("/all")
    public List<Product> main_page()
    {
        DataParser parser = new DataParser();
        parser.loadFile("products.json");
        ProductList list =  parser.retrieveProductList();
        return list.getProducts().subList(0, list.getProducts().size());

    }
    @GetMapping(value = "/sort")
    public List<Product>sortedList(@RequestParam(value = "sortOrder", defaultValue = "ASCENDING")String sortorder,
                                   @RequestParam(value = "grouped", defaultValue = "UNGROUPED") String grouped)
    {
        DataParser parser = new DataParser();
        parser.loadFile("products.json");
        ProductList list =  parser.retrieveProductList();
        if(grouped.equals("UNGROUPED")|| grouped.isEmpty())
        {
            if (sortorder.equals("ASCENDING"))
            {
                return list.sort(ProductList.SortOrder.ASCENDING).subList(0,list.getProducts().size());
            }
            else
            {
                return list.sort(ProductList.SortOrder.DESCENDING).subList(0,list.getProducts().size());
            }

        }
        else
            {
                if (sortorder.equals("ASCENDING"))
                {
                    return list.sortAllGroup(ProductList.SortOrder.ASCENDING).subList(0,list.getProducts().size());
                }
                else
                {
                    return list.sortAllGroup(ProductList.SortOrder.DESCENDING).subList(0,list.getProducts().size());
                }
        }
    }
}
