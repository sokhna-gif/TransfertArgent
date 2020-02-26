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

public class retraitConfirmation extends AppCompatActivity {

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
        setContentView(R.layout.activity_retrait_confirmation);

        Intent intent = getIntent();
        if (intent!=null){
            RetraitData dataReceveid = intent.getParcelableExtra("data");

            if (dataReceveid!=null){

                TextView prenom = (TextView) findViewById(R.id.prRtrConf);
                TextView nom = (TextView) findViewById(R.id.nomRtrConf);
                TextView tel = (TextView) findViewById(R.id.telRtrConf);
                TextView tyPiece = (TextView) findViewById(R.id.tyPieceRtrConf);
                TextView numP = (TextView) findViewById(R.id.numPRtrConf);
                TextView code = (TextView) findViewById(R.id.codeConf);



                String pr=dataReceveid.getPrenom();
                String nm=dataReceveid.getNom();
                int tlp=dataReceveid.getTel();
                String tyP=dataReceveid.getTypePiece();
                int nmP=dataReceveid.getNumP();
                int cdEnv=dataReceveid.getCode();

                String tl = Integer.toString(tlp);
                String nmPiece = Integer.toString(nmP);
                String cd = Integer.toString(cdEnv);

                prenom.setText(pr);
                nom.setText(nm);
                tel.setText(tl);
                tyPiece.setText(tyP);
                numP.setText(nmPiece);
                code.setText(cd);


                Button btnRtrconf = (Button) findViewById(R.id.btnRtrconf);
                btnRtrconf.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(v);
                    }
                });
            }
        }


    }
}
