package Source;

import android.view.View;

import java.util.ArrayList;

/**
 * Created by Li on 15/2/25.
 */
public class SubCategory extends Searchable{
    private ArrayList<View> list;
    private int count;

    public SubCategory(String name){
        super(name);
        list = new ArrayList<View>();
        count = 0;
    }

    public SubCategory(SubCategory toBeCopied){
        super(toBeCopied);
        list = new ArrayList<View>();
        for(int i = 0; i < toBeCopied.getCount(); i++){

        }
    }

    public int getCount() {
        return count;
    }

    public void addItem(View item){
        list.add(item);
        count++;
    }

    public void addItem(int index, View item){
        list.add(index, item);
        count++;
    }

    public View getItem(int index){
        return list.get(index);
    }

    public View removeItem(int index){
        View temp = getItem(index);
        list.remove(index);
        count--;
        return temp;
    }

    public SubCategory clone(){
        SubCategory temp = new SubCategory(this);
        return temp;
    }
}
