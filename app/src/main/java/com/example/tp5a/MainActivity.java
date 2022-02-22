package com.example.tp5a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
private int compteur=0;
private int production=1;
public static final String COMPTEUR = "TP5a.COMPTEUR";
public static final String PRODUCTION="TP5a.PRODUCTION";

private int computeNextProd(){
    return (production*production)*10;
}
   @Override
   protected void onSaveInstanceState(Bundle outState){
    outState.putInt(COMPTEUR,compteur);
    outState.putInt(PRODUCTION,production);
    super.onSaveInstanceState(outState);
   }
    protected void onResume()
    {
        super.onResume();

    }
    @Override
    protected void onPause()
    {
        super.onPause();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState!=null){
            compteur=savedInstanceState.getInt(COMPTEUR);
            production=savedInstanceState.getInt(PRODUCTION);
        }
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.imageView);
        TextView text = findViewById(R.id.textView2);
        Button prod = findViewById(R.id.button);
        TextView text2 = findViewById(R.id.textView);
        imageView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                compteur=compteur+production;
                text.setText("Nombre de croissants: "+compteur);

            }
        });
        prod.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(compteur>=computeNextProd()) {
                    compteur=compteur-computeNextProd();
                    production++;
                    text2.setText("Production: " + production);
                    prod.setText("Augmenter la production: " + computeNextProd());
                    text.setText("Nombre de croissants: "+compteur);
                }else{
                    Toast.makeText(getApplicationContext(),"Pas assez de croissants", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}