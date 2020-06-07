package Test;


import Model.Product;
import Model.ProductList;
import Utils.DataParser;


import java.util.ArrayList;

public class TestJSONParser {
    public static void main(String args[]){
        DataParser parser = new DataParser();
        parser.loadFile("products.json");

        ProductList list = parser.retrieveProductList();
        testSortAllOrder(list);
        testGroupSortingIndivdual(list);
        testAllGroupsSorted(list);
    }

    static void testSortAllOrder(ProductList list)
    {
        //Passes if both return all items in their respective order
        list.setProducts(list.sort(ProductList.SortOrder.ASCENDING));
        list.setProducts(list.sort(ProductList.SortOrder.DESCENDING));

    }

    static void testGroupSortingIndivdual(ProductList list)
    {
        //Passes if both of these return two items in respective order
       ArrayList<Product> runningList = list.sort(ProductList.SortOrder.ASCENDING, "Running");
       ArrayList<Product> bookList = list.sort(ProductList.SortOrder.DESCENDING, "Book");

    }

    static void testAllGroupsSorted(ProductList list)
    {
        //All 15 entries should appear here first grouped and then sorted by respective order
        ArrayList<Product> ascendedGroups = list.sortAllGroup(ProductList.SortOrder.ASCENDING);
        ArrayList<Product> descendedGroups =list.sortAllGroup(ProductList.SortOrder.DESCENDING);

        if(true);
    }
}
