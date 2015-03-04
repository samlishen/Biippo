package Source;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Li on 15/2/28.
 */
public class Element implements Parcelable{

    public static Creator<Element> CREATER = new Creator<Element>(){

        @Override
        public Element createFromParcel(Parcel source) {
            return new Element(source);
        }

        @Override
        public Element[] newArray(int size) {
            return new Element[0];
        }
    };

    protected Element(){

    }

    protected Element(Parcel p){

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
