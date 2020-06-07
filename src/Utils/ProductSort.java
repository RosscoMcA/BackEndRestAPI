package Utils;
/** @author Ross McArthur
 *
 */

import Model.Price;
import Model.Product;

import java.util.ArrayList;

/**
 * @class handles the sorting of products
 */
public class ProductSort {

    /**
     * Core Sort method for ascending prices of products
     * @param items the list of products to sort
     * @return the final sorted items from lowest to highest
     */
    public ArrayList<Product> sortAscending(ArrayList<Product>items)
    {
        boolean sorted = false;
        while(!sorted)
        {
            boolean sortedRun = true;
            for(int i=0; i < items.size()-1; i++)
            {

                COMPARISON_RESULT result = comparePrice(items.get(i).getPrice(), items.get((i+1)).getPrice());
                switch(result)
                {
                    case EQUAL:
                            //Do nothing here
                        break;
                    case GREATER:
                        items= swap(items,i+1, i);
                        sortedRun= false;
                        break;
                }
                sorted= sortedRun;
            }
        }

        return items;
    }

    /**
     * Core Sort method for descending prices of products
     * @param items the list of products to sort
     * @return the final sorted items from lowest to highest
     */
    public ArrayList<Product> sortDescending(ArrayList<Product>items)
    {
        boolean sorted = false;
        while(!sorted)
        {
            boolean sortedRun = true;
            for(int i=0; i < items.size()-1; i++)
            {

                COMPARISON_RESULT result = comparePrice(items.get(i).getPrice(), items.get((i+1)).getPrice());
                switch(result)
                {
                    case EQUAL:
                        //Do nothing here
                        break;
                    case LESS:
                        items= swap(items,i+1, i);
                        sortedRun= false;
                        break;

                }
                sorted= sortedRun;
            }
        }

        return items;
    }

    /**
     * Compares two products prices to identify its differences
     * @param first the item currently being traversed
     * @param second the next item in list to compare to
     * @return either Equal if the same, greater if the first item is more expensive,
     * @return less if it is less expensive
     *
     */
    public COMPARISON_RESULT comparePrice(Price first, Price second)
    {
        if(first.getValue()==second.getValue())
            return COMPARISON_RESULT.EQUAL;
        else if(first.getValue()>second.getValue())
            return COMPARISON_RESULT.GREATER;
        else if(first.getValue()<second.getValue())
            return COMPARISON_RESULT.LESS;

        return COMPARISON_RESULT.UNKNOWN;
    }

    /**
     * Swaps the position of two selected indexes
     * @param product the array list of products
     * @param firstIndex the position of the product to swap
     * @param secondIndex the position of the product to be swapped by
     * @return the updated list with the two items swapped
     */
    private ArrayList<Product>swap(ArrayList<Product> product, int firstIndex, int secondIndex)
    {
        Product firstItem =  product.get(firstIndex);
        Product secondItem = product.get(secondIndex);
        product.set(firstIndex, secondItem);
        product.set(secondIndex, firstItem);

        return product;
    }

    /**
     * @enum used to indicate the state of comparisons
     *
     */
    enum COMPARISON_RESULT {UNKNOWN, EQUAL, GREATER, LESS}
}

