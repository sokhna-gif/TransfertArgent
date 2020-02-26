package joe.example.tranfertargent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EnvoiConfirmation extends AppCompatActivity {


    public float calculFrais(int som){
        return (7*som)/100;
    }
    public void showDialog(View view){
        AlertDialog alertDialog = new AlertDialog.Builder(this).
                setTitle("Confirmation")
                .setMessage("Etes Vous Sure")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i("EnvoiConfirmation","Yes");
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i("EnvoiConfirmation","No");
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envoi_confirmation);

        Intent intent = getIntent();

        if (intent!=null){
            EnvoiData dataReceive=intent.getParcelableExtra("data");
            if (dataReceive!=null){
                TextView prenomEmet = (TextView) findViewById(R.id.prenomEmetConf);
                TextView nomEmet = (TextView) findViewById(R.id.nomEmetConf);
                TextView telEmet = (TextView) findViewById(R.id.telEmettConf);
                TextView prenomRecep = (TextView) findViewById(R.id.prenomRecepConf);
                TextView nomRecep = (TextView) findViewById(R.id.nomRecepConf);
                TextView telRecep = (TextView) findViewById(R.id.telRecepConf);
                TextView tyPiece = (TextView) findViewById(R.id.typeDePieceConf);
                TextView pieceRecep = (TextView) findViewById(R.id.numPConf);
                TextView montant = (TextView) findViewById(R.id.montantConf);
                TextView fraisT = (TextView) findViewById(R.id.frais);
                TextView mnE = (TextView) findViewById(R.id.mnAEnvoyer);


                 String prEmet=dataReceive.getPrenomEmet();
                String nmEmet=dataReceive.getNomEmet();
                int tlEmet=dataReceive.getTelEmet();
                String prRecep=dataReceive.getPrenomRecep();
                String nmRecp=dataReceive.getNomRecp();
                int tleRecp=dataReceive.getTeleRecp();
                String typePiece=dataReceive.getTypePiece();
                int numPiece=dataReceive.getNumPiece();
                int mn=dataReceive.getMontant();

                float frais=calculFrais(mn);

                float mnAE=(mn-frais);

                String telE = Integer.toString(tlEmet);
                String telR = Integer.toString(tleRecp);
                String mon= Integer.toString(mn);
                String numP= Integer.toString(numPiece);
                String frs=Float.toString(frais);
                String mnaE=Float.toString(mnAE);

                prenomEmet.setText(prEmet);
                nomEmet.setText(nmEmet);
                telEmet.setText(telE);
                prenomRecep.setText(prRecep);
                nomRecep.setText(nmRecp);
                telRecep.setText(telR);
                tyPiece.setText(typePiece);
                pieceRecep.setText(numP);
                montant.setText(mon);
                fraisT.setText(frs);
                mnE.setText(mnaE);
            }

            Button btnDialog = (Button) findViewById(R.id.conf);

            btnDialog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog(v);
                }
            });
        }
    }
}
