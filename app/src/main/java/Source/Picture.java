package Source;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Li on 15/3/3.
 */
public class Picture extends Element implements Parcelable {

    private Drawable content;
    public static Creator<Picture> CREATER = new Creator<Picture>(){

        @Override
        public Picture createFromParcel(Parcel source) {
            return null;
        }

        @Override
        public Picture[] newArray(int size) {
            return new Picture[0];
        }
    };

    public Picture(Drawable source){
        content = source;
    }

    public Picture(Parcel p){
        content = p.readParcelable(Picture.class.getClassLoader());
    }
}
