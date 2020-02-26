package joe.example.tranfertargent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class EnvoiActivity extends AppCompatActivity {

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public void SendData(View view){
        EditText prenomEmet = (EditText) findViewById(R.id.prenomEmet);
        EditText nomEmet = (EditText) findViewById(R.id.nomEmett);
        EditText telEmet = (EditText) findViewById(R.id.telEmett);
        EditText prenomRecep = (EditText) findViewById(R.id.prenomRecep);
        EditText nomRecep = (EditText) findViewById(R.id.nomRecep);
        EditText telRecep = (EditText) findViewById(R.id.telRecep);
        EditText tyPiece = (EditText) findViewById(R.id.typeDePiece);
        EditText pieceRecep = (EditText) findViewById(R.id.pieceRecep);
        EditText montant = (EditText) findViewById(R.id.montantEvoye);

        String prenomEm = prenomEmet.getText().toString();
        String nomEm = nomEmet.getText().toString();
        String telEm = telEmet.getText().toString();
        String prenomRec = prenomRecep.getText().toString();
        String nomRec = nomRecep.getText().toString();
        String telRec = telRecep.getText().toString();
        String TypeP = tyPiece.getText().toString();
        String pieceRec= pieceRecep.getText().toString();
        String mon = montant.getText().toString();

        int telE = Integer.parseInt(telEm);
        int telR = Integer.parseInt(telRec);
        int mn= Integer.parseInt(mon);
        int numP= Integer.parseInt(pieceRec);


        EnvoiData dataEvn = new EnvoiData(getRandomNumberInRange(1,10000000),prenomEm,nomEm,telE,prenomRec,nomRec,telR,TypeP,numP,mn);

        System.console();

        Intent intent = new Intent(this,EnvoiConfirmation.class);
        intent.putExtra("data",dataEvn);

        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envoi);

        Button envoiBtn= (Button) findViewById(R.id.btnE);
        envoiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendData(v);
            }
        });

    }
}
