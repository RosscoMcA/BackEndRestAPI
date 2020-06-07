package Model;

import Utils.ProductSort;

import java.util.ArrayList;

/**
 * @class handles the data for all parsed products from feed
 */
public class ProductList {


    private ArrayList<Product> products;
    private ArrayList<String>distinctGroup;

    /**
     *
     */
    public ProductList()
    {
        products = new ArrayList<Product>();
        distinctGroup = new ArrayList<String>();
    }

    /**
     * Adds product to the product list
     * @param obj item to add to list
     */
    public void addProduct(Product obj){
        products.add(obj);
        addTypeToGroupList(obj);
    }

    /**
     * Adds distinct group type to recognised group list
     * @param obj Type to add
     */
    private void addTypeToGroupList(Product obj) {
        if(distinctGroup.isEmpty())
        {
            distinctGroup.add(obj.getType());
        }
        else if(!(distinctGroup.contains(obj.getType())))
        {
            distinctGroup.add(obj.getType());
        }
    }

    /**
     * Default sort method, will sort all items
     * in descending order
     * @return product list in the order of highest price first
     */
    public ArrayList<Product> sortDescending()
    {
        ProductSort sorter = new ProductSort();
        ArrayList<Product> items= sorter.sortDescending(this.products);
        return items;
    }

    /**
     * Default sort method, will sort all items in
     * product list in ascending order
     * @return product list in the order of lowest price first
     */
    public ArrayList<Product> sortAscending()
    {
        ProductSort sorter = new ProductSort();
        ArrayList<Product> items = sorter.sortAscending(this.products);
        return items;
    }

    /**
     * Sorts all items provided in the descending order of price
     * @param items the items to sort
     * @return list of products in order of highest price first
     */
    public ArrayList<Product> sortCollectionByDescending(ArrayList<Product>items)
    {
        ProductSort sorter = new ProductSort();
        ArrayList<Product> result= sorter.sortDescending(items);
        return  result;
    }

    /**
     * Sorts all items provided in the ascending order of price
     * @param items the items to sort
     * @return list of products in order of lowest price first
     */
    public ArrayList<Product> sortCollectionByAscending(ArrayList<Product>items)
    {
        ProductSort sorter = new ProductSort();
        ArrayList<Product> result= sorter.sortAscending(items);
        return  result;
    }

    /**
     *  getter
     * @return
     */
    public ArrayList<Product> getProducts() {
        return products;
    }

    /**
     * setter
     * @param products
     */
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    /**
     * Default sorting, handles all products in the current session
     * @param order the order to sort
     * @return a sorted list of all products in the current session
     */
    public ArrayList<Product>sort(SortOrder order)
    {

        if(order == SortOrder.ASCENDING)
        {
            return sortAscending();
        }
        else {
            return sortDescending();
        }

    }

    /**
     *  Retrieves a list of all items of a single type
     * @param type the type to search for
     * @return A list of products of a single group type
     */
    public ArrayList<Product>getGroup(String type)
    {
        ArrayList<Product>items= new ArrayList<Product>();
        if(distinctGroup.contains(type)) {
            for (Product prod : products) {
                if (prod.getType().equals(type))
                    items.add(prod);
            }
        }
        return items;

    }

    /**
     * Retrives a specific group and sorts it in a specified order
     * @param order the order to sort
     * @param group the group to sort
     * @return A sorted set of products of a specific type
     */
    public ArrayList<Product>sort(SortOrder order, String group)
    {
        ArrayList<Product>items = getGroup(group);
        if(items.isEmpty()|| items.size()==1)
            return items;

        if(order== SortOrder.ASCENDING)
        {
            return sortCollectionByAscending(items);
        }
        else {
            return sortCollectionByDescending(items);
        }
    }

    /**
     * Groups items by type and sorts within their respective groups
     * @param order the order to sort
     * @return the sorted and grouped list
     */
    public ArrayList<Product>sortAllGroup(SortOrder order)
    {
        ArrayList<Product> groupedItems = new ArrayList<Product>();
        for (String type:distinctGroup) {
            groupedItems.addAll(sort(order, type));
        }

        return groupedItems;
    }

    public static enum SortOrder{ASCENDING, DESCENDING};
}

/**
 * @enum handles the order in which items
 * should be sorted in queries
 */


