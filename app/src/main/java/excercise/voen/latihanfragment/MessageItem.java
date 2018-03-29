package excercise.voen.latihanfragment;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by voen on 28/03/18.
 */

public class MessageItem implements Parcelable {
    String title;
    String content;
    int image;


    public MessageItem(String title, String content, int image) {
        this.title = title;
        this.content = content;
        this.image = image;
    }

    protected MessageItem(Parcel in) {
        title = in.readString();
        content = in.readString();
        image = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(content);
        dest.writeInt(image);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MessageItem> CREATOR = new Creator<MessageItem>() {
        @Override
        public MessageItem createFromParcel(Parcel in) {
            return new MessageItem(in);
        }

        @Override
        public MessageItem[] newArray(int size) {
            return new MessageItem[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
