package joe.example.tranfertargent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    private void formDeConnexion(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    private void formEnvoi(){
        Intent intent = new Intent(this,EnvoiActivity.class);
        startActivity(intent);
        //finish();
    }

    private void formRetrait(){
        Intent intent = new Intent(this,RetraitActivity.class);
        startActivity(intent);
        //finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btnMeDeconnecter= findViewById(R.id.btnSeDeconnecter);
        btnMeDeconnecter.setOnClickListener(this);

        Button btnEnvoyer= findViewById(R.id.btnEnvoi);
        btnEnvoyer.setOnClickListener(this);

        Button btnRetirer= findViewById(R.id.btnRetait);
        btnRetirer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSeDeconnecter:
                formDeConnexion();
                break;
            case R.id.btnEnvoi:
                formEnvoi();
                break;
            case R.id.btnRetait:
                formRetrait();
                break;
        }
    }
}
