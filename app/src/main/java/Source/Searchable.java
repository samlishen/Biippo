package Source;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Li on 15/2/25.
 */
@SuppressWarnings("DefaultFileTemplate")
public interface Searchable{

    public String getSearchableName();

    public void setSearchableName(String name);

    public int getIcon();

    public void setIcon(int icon);

}
