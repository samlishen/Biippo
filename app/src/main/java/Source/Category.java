package Source;

import java.util.ArrayList;

/**
 * Created by Li on 15/2/25.
 */
public class Category extends Searchable{
    private ArrayList<SubCategory> list;
    private int count;

    public Category(String name){
        super(name);
        list = new ArrayList<SubCategory>();
        count = 0;
    }

    public Category(Category toBeCopied){
        super(toBeCopied);
        list = new ArrayList<SubCategory>();
        for(int i = 0; i < toBeCopied.getCount(); i++){
            addItem(toBeCopied.getItem(i));
            count++;
        }
    }

    public int getCount(){
        return count;
    }

    public void addItem(SubCategory addToList){
        list.add(addToList);
        count++;
    }

    public void addItem(int index, SubCategory addToList){
        list.add(index, addToList);
        count++;
    }

    public SubCategory getItem(int index){
        return list.get(index);
    }

    public SubCategory deleteItem(int index){
        SubCategory temp = getItem(index);
        list.remove(index);
        count--;
        return temp;
    }

    public Category clone(){
        Category temp = new Category(this);
        return temp;
    }
}
