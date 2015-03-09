package Source;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;


/**
 * Created by Li on 15/2/25.
 */
public class SubCategory implements Searchable, Parcelable{
    private String searchableName;
    private int steps;
    private String[] text;
    private int[] picture;
    private Uri video;
    public static Creator<SubCategory> CREATOR = new Creator<SubCategory>(){

        @Override
        public SubCategory createFromParcel(Parcel source) {
            return new SubCategory(source);
        }

        @Override
        public SubCategory[] newArray(int size) {
            return new SubCategory[0];
        }
    };

    public SubCategory(){

    }

    public SubCategory(String name, int steps){
        searchableName = name;
        this.steps = steps;
        text = new String[steps];
        picture = new int[steps];
        video = null;
    }

    public SubCategory(SubCategory toBeCopied){
        this();
        searchableName = toBeCopied.getSearchableName();
        steps = toBeCopied.steps;
        text = new String[steps];
        for (int i = 0; i < steps; i++){
            text[i] = toBeCopied.text[i];
        }
        picture = new int[steps];
        for (int i = 0; i < steps; i++){
            picture[i] = toBeCopied.picture[i];
        }
        video = toBeCopied.video;
    }

    public SubCategory(Parcel p){
        this();
        searchableName = p.readString();
        steps = p.readInt();
        text = p.createStringArray();
        picture = p.createIntArray();
        video = p.readParcelable(Uri.class.getClassLoader());
    }

    public int getSteps() {
        return steps;
    }


    public void addText(int index, String item){
        text[index] = item;
    }

    public String getText(int index){
        return text[index];
    }

    public String removeText(int index){
        String temp = text[index];
        text[index] = null;
        return temp;
    }

    public void addPicture(int index, int item){
        if (index < steps) picture[index] = item;
    }

    public int getPicture(int index){
        if (index < steps) return picture[index];
        else return 0;
    }

    public int removePicture(int index){
        if (index < steps) {
            int temp = picture[index];
            picture[index] = 0;
            return temp;
        } else {
            return 0;
        }
    }

    public void setVideo(Uri video){
        this.video = video;
    }

    public Uri getVideo() {
        return video;
    }

    public Uri removeVideo(){
        Uri temp = video;
        video = null;
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
        dest.writeInt(steps);
        dest.writeStringArray(text);
        dest.writeIntArray(picture);
        dest.writeParcelable(video, flags);
    }
}
