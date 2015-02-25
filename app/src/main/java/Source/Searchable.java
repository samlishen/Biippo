package Source;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Li on 15/2/25.
 */
public class Searchable implements Parcelable{
    private String searchableName;

    public Searchable() {
        searchableName = "";
    }

    public Searchable(String name) {
        if (name != null) {
            searchableName = name;
        } else {
            searchableName = "";
        }
    }

    public Searchable(Searchable copy) {
        searchableName = copy.searchableName;
    }

    public Searchable(Parcel p) {
        searchableName = p.readString();
    }

    public String getSearchableName() {
        return searchableName;
    }

    public void setSearchableName(String name) {
        searchableName = name;
    }

    @Override
    public String toString() {
        return searchableName;
    }

    public Searchable clone() {
        Searchable temp = new Searchable(this);
        return temp;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(searchableName);
    }

    public static Parcelable.Creator<Searchable> CREATOR = new Parcelable.Creator<Searchable>() {

        @Override
        public Searchable createFromParcel(Parcel source) {
            return new Searchable(source);
        }

        @Override
        public Searchable[] newArray(int size) {
            return new Searchable[0];
        }
    };
}
