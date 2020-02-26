package joe.example.tranfertargent;

import android.os.Parcel;
import android.os.Parcelable;

public class RetraitData implements Parcelable {

    private String prenom;
    private String nom;
    private  int tel;
    private  String typePiece;
    private  int numP;
    private int code;

    protected RetraitData(Parcel in) {
        prenom = in.readString();
        nom = in.readString();
        tel = in.readInt();
        typePiece = in.readString();
        numP = in.readInt();
        code = in.readInt();
    }

    public static final Creator<RetraitData> CREATOR = new Creator<RetraitData>() {
        @Override
        public RetraitData createFromParcel(Parcel in) {
            return new RetraitData(in);
        }

        @Override
        public RetraitData[] newArray(int size) {
            return new RetraitData[size];
        }
    };

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public int getTel() {
        return tel;
    }

    public String getTypePiece() {
        return typePiece;
    }

    public int getNumP() {
        return numP;
    }

    public int getCode() {
        return code;
    }

    public RetraitData(String prenom, String nom, int tel, String typePiece, int numP, int code) {
        this.prenom = prenom;
        this.nom = nom;
        this.tel = tel;
        this.typePiece = typePiece;
        this.numP = numP;
        this.code = code;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(prenom);
        dest.writeString(nom);
        dest.writeInt(tel);
        dest.writeString(typePiece);
        dest.writeInt(numP);
        dest.writeInt(code);
    }
}
