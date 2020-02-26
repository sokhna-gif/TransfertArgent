package joe.example.tranfertargent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RetraitActivity extends AppCompatActivity {

    public void sendDataR(View view){
        EditText prenom = (EditText) findViewById(R.id.prenom);
        EditText nom = (EditText) findViewById(R.id.nom);
        EditText tel = (EditText) findViewById(R.id.tel);
        EditText tyPiece = (EditText) findViewById(R.id.typeP);
        EditText nump = (EditText) findViewById(R.id.numP);
        EditText code = (EditText) findViewById(R.id.code);

        String pr = prenom.getText().toString();
        String nm = nom.getText().toString();
        String tl = tel.getText().toString();
        String tPiece = tyPiece.getText().toString();
        String numP = nump.getText().toString();
        String cdE = code.getText().toString();

        int telE = Integer.parseInt(tl);
        int mnP = Integer.parseInt(numP);
        int cd = Integer.parseInt(cdE);

        RetraitData dataRtr = new RetraitData(pr,nm,telE,tPiece,mnP,cd);

        System.console();

        Intent intent = new Intent(this,retraitConfirmation.class);
        intent.putExtra("data",dataRtr);

        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrait);

        Button btnR=(Button) findViewById(R.id.btnR);

        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDataR(v);
            }
        });
    }
}
