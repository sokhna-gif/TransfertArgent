package joe.example.tranfertargent;

import android.os.Parcel;
import android.os.Parcelable;

public class EnvoiData implements Parcelable {

    private int code;
    private String prenomEmet;
    private String nomEmet;
    private int telEmet;
    private String nomRecp;
    private  String prenomRecep;
    private int teleRecp;
    private  String typePiece;
    private  int numPiece;
    private int montant;

    protected EnvoiData(Parcel in) {
        code = in.readInt();
        prenomEmet = in.readString();
        nomEmet = in.readString();
        telEmet = in.readInt();
        nomRecp = in.readString();
        prenomRecep = in.readString();
        teleRecp = in.readInt();
        typePiece = in.readString();
        numPiece = in.readInt();
        montant = in.readInt();
    }

    public static final Creator<EnvoiData> CREATOR = new Creator<EnvoiData>() {
        @Override
        public EnvoiData createFromParcel(Parcel in) {
            return new EnvoiData(in);
        }

        @Override
        public EnvoiData[] newArray(int size) {
            return new EnvoiData[size];
        }
    };

    public int getCode() {
        return code;
    }

    public String getPrenomEmet() {
        return prenomEmet;
    }

    public String getNomEmet() {
        return nomEmet;
    }

    public int getTelEmet() {
        return telEmet;
    }

    public String getNomRecp() {
        return nomRecp;
    }

    public String getPrenomRecep() {
        return prenomRecep;
    }

    public int getTeleRecp() {
        return teleRecp;
    }

    public String getTypePiece() {
        return typePiece;
    }

    public int getNumPiece() {
        return numPiece;
    }

    public int getMontant() {
        return montant;
    }

    public EnvoiData(int code, String prenomEmet, String nomEmet, int telEmet, String nomRecp, String prenomRecep, int teleRecp, String typePiece, int numPiece, int montant) {
        this.code = code;
        this.prenomEmet = prenomEmet;
        this.nomEmet = nomEmet;
        this.telEmet = telEmet;
        this.nomRecp = nomRecp;
        this.prenomRecep = prenomRecep;
        this.teleRecp = teleRecp;
        this.typePiece = typePiece;
        this.numPiece = numPiece;
        this.montant = montant;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(code);
        dest.writeString(prenomEmet);
        dest.writeString(nomEmet);
        dest.writeInt(telEmet);
        dest.writeString(nomRecp);
        dest.writeString(prenomRecep);
        dest.writeInt(teleRecp);
        dest.writeString(typePiece);
        dest.writeInt(numPiece);
        dest.writeInt(montant);
    }
}
