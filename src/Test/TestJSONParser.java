package Test;


import Model.Product;
import Model.ProductList;
import Utils.DataParser;

import javax.swing.*;
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
        list.setProducts(list.sort(SortOrder.ASCENDING));
        list.setProducts(list.sort(SortOrder.DESCENDING));

    }

    static void testGroupSortingIndivdual(ProductList list)
    {
        //Passes if both of these return two items in respective order
       ArrayList<Product> runningList = list.sort(SortOrder.ASCENDING, "Running");
       ArrayList<Product> bookList = list.sort(SortOrder.DESCENDING, "Book");

    }

    static void testAllGroupsSorted(ProductList list)
    {
        //All 15 entries should appear here first grouped and then sorted by respective order
        ArrayList<Product> ascendedGroups = list.sortAllGroup(SortOrder.ASCENDING);
        ArrayList<Product> descendedGroups =list.sortAllGroup(SortOrder.DESCENDING);

        if(true);
    }
}
