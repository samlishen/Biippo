package Source;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Li on 15/3/3.
 */
public class Video extends Element implements Parcelable {

    private Uri content;
    public static Creator<Video> CREATER = new Creator<Video>(){

        @Override
        public Video createFromParcel(Parcel source) {
            return new Video(source);
        }

        @Override
        public Video[] newArray(int size) {
            return new Video[0];
        }
    };

    public Video(Uri source){
        super();
        content = source;
    }

    protected Video(Parcel p){
        content = p.readParcelable(Video.class.getClassLoader());
    }

    public Uri getContent(){
        return content;
    }

    public void setContent(Uri source){
        content = source;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(content, flags);
    }
}
