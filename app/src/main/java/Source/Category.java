package Source;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Li on 15/2/25.
 */
public class Category implements Parcelable, Searchable {
    protected ArrayList<SubCategory> list;
    protected String searchableName;
    protected int count;

    public Category(){
        list = new ArrayList<SubCategory>();
        searchableName = "";
        count = 0;
    }

    public Category(String name){
        searchableName = name;
        list = new ArrayList<SubCategory>();
        count = 0;
    }

    public Category(Category toBeCopied){
        searchableName = toBeCopied.getSearchableName();
        list = new ArrayList<SubCategory>();
        for(int i = 0; i < toBeCopied.getCount(); i++){
            addItem(toBeCopied.getItem(i));
            count++;
        }
    }

    public Category(Parcel p){
        this();
        searchableName = p.readString();
        p.readTypedList(list, SubCategory.CREATOR);
        count = p.readInt();
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

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(searchableName);
        dest.writeTypedList(list);
        dest.writeInt(count);
    }

    public static Parcelable.Creator<Category> CREATOR = new Creator<Category>(){

        @Override
        public Category createFromParcel(Parcel source) {
            return new Category(source);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[0];
        };
    };

    @Override
    public String getSearchableName() {
        return searchableName;
    }

    @Override
    public void setSearchableName(String name) {
        if (name != null) {
            searchableName = name;
        }
    }
}
