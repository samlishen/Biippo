package Source;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Li on 15/2/28.
 */
public class Text extends Element implements Parcelable{
    private String content;
    public static Creator<Text> CREATER = new Creator<Text>() {
        @Override
        public Text createFromParcel(Parcel source) {
            return new Text(source);
        }

        @Override
        public Text[] newArray(int size) {
            return new Text[0];
        }
    };

    public Text(){
        super();
        content = "";
    }

    public Text(String text){
        super();
        content = text;
    }

    public Text(Text toBeCopied){
        super();
        content = toBeCopied.content;
    }

    public Text(Parcel p){
        content = p.readString();
    }

    public String getContent(){
        return content;
    }

    public void setContent(String source){
        content = source;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(content);
    }
}
