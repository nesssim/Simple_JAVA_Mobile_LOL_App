package Module;

import com.example.fragment_td2.R;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

public class Champion implements Parcelable {
    private String name;
    private String role;
    private int imageResId;

    public Champion(String name, String role, int imageResId) {
        this.name = name;
        this.role = role;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public int getImageResId() {
        return imageResId;
    }

    public static List<Champion> getChampList() {
        List<Champion> ChampList = new ArrayList<>();
        ChampList.add(new Champion("Lee Sin", "Jungler", R.drawable.lee_sin));
        ChampList.add(new Champion("Miss Fortune", "ADC", R.drawable.miss_fortune));
        ChampList.add(new Champion("Thresh", "Support", R.drawable.thresh));
        ChampList.add(new Champion("Nasus", "Top", R.drawable.nasus));
        ChampList.add(new Champion("Kayn", "Jungler", R.drawable.kayn));
        ChampList.add(new Champion("Kennen", "Top/Mid", R.drawable.kennen));
        ChampList.add(new Champion("Nidalee", "Supp/Jungle", R.drawable.nidalee));
        ChampList.add(new Champion("VoliBear", "Top/Jungle", R.drawable.volibear));
        ChampList.add(new Champion("Mordkaiser", "Top", R.drawable.mordkaiser));
        ChampList.add(new Champion("Yuumi", "support", R.drawable.yuumi));
        ChampList.add(new Champion("Viktor", "mid", R.drawable.viktor));
        ChampList.add(new Champion("Akali", "mid/top", R.drawable.akali));
        ChampList.add(new Champion("Talon", "mid", R.drawable.talon));

        return ChampList;
    }

    protected Champion(Parcel in) {
        name = in.readString();
        role = in.readString();
        imageResId = in.readInt();
    }

    public static final Creator<Champion> CREATOR = new Creator<Champion>() {
        @Override
        public Champion createFromParcel(Parcel in) {
            return new Champion(in);
        }

        @Override
        public Champion[] newArray(int size) {
            return new Champion[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(role);
        dest.writeInt(imageResId);
    }
}