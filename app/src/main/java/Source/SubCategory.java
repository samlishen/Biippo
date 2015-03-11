package Source;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * Created by Li on 15/2/25.
 */
@SuppressWarnings("DefaultFileTemplate")
public class SubCategory implements Searchable, Parcelable{
    private String searchableName;
    private int steps;
    private String[] text;
    private int[] picture;
    private String video;
    private int icon;
    public static final Creator<SubCategory> CREATOR = new Creator<SubCategory>(){

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
        System.arraycopy(toBeCopied.text, 0, text, 0, steps);
        picture = new int[steps];
        System.arraycopy(toBeCopied.picture, 0, picture, 0, steps);
        video = toBeCopied.video;
    }

    public SubCategory(Parcel p){
        this();
        searchableName = p.readString();
        steps = p.readInt();
        text = new String[steps];
        picture = new int[steps];
        text = p.createStringArray();
        picture = p.createIntArray();
        video = p.readString();
        icon = p.readInt();
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

    public void setVideo(String video){
        this.video = video;
    }

    public String getVideo() {
        return video;
    }

    public String removeVideo(){
        String temp = video;
        video = null;
        return temp;
    }

    public SubCategory clone(){
        return new SubCategory(this);
    }

    public int getIcon(){
        return icon;
    }

    public void setIcon(int icon){
        this.icon = icon;
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
        dest.writeString(video);
        dest.writeInt(icon);
    }
}
