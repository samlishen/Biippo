package Source;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Li on 15/2/25.
 */
public class SubCategory implements Searchable, Parcelable{
    private ArrayList<Element> list;
    private int count;
    private String searchableName;
    public static Creator<SubCategory> CREATER = new Creator<SubCategory>(){

        @Override
        public SubCategory createFromParcel(Parcel source) {
            return new SubCategory(source);
        }

        @Override
        public SubCategory[] newArray(int size) {
            return new SubCategory[0];
        }
    };

    public SubCategory(String name){
        searchableName = name;
        list = new ArrayList<Element>();
        count = 0;
    }

    public SubCategory(SubCategory toBeCopied){
        searchableName = toBeCopied.getSearchableName();
        list = new ArrayList<Element>();
        for(int i = 0; i < toBeCopied.getCount(); i++){
            list.add(toBeCopied.getItem(0));
            count++;
        }
    }

    public SubCategory(Parcel p){
        searchableName = p.readString();
        p.readTypedList(list, View.CREATER);
        count = p.readInt();
    }

    public int getCount() {
        return count;
    }

    public void addItem(Element item){
        list.add(item);
        count++;
    }

    public void addItem(int index, Element item){
        list.add(index, item);
        count++;
    }

    public Element getItem(int index){
        return list.get(index);
    }

    public Element removeItem(int index){
        Element temp = getItem(index);
        list.remove(index);
        count--;
        return temp;
    }

    public SubCategory clone(){
        SubCategory temp = new SubCategory(this);
        return temp;
    }

    @Override
    public String getSearchableName() {
        return searchableName;
    }

    @Override
    public void setSearchableName(String name) {
        if (name != null){
            searchableName = name;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(searchableName);
        dest.writeTypedList(list);
        dest.writeInt(count);
    }
}
