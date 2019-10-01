package com.example.ppb2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView main_map;
    private TextView main_telepon;
    private TextView main_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_map=findViewById(R.id.xAlamat);
    }

    public void Map(View view) {
        String loc = main_map.getText().toString();
        Uri mapmap = Uri.parse("geo:0,0?q=" +loc);
        Intent bukamap = new Intent(Intent.ACTION_VIEW,mapmap);
        if(bukamap.resolveActivity(getPackageManager())!=null){
            startActivity(bukamap);
        }
        else{
            Log.d("ImplicitIntents","Salah alamat :D");
        }
    }

    public void Tlp(View view) {
        String nomor = "082117384255" ;
        Intent panggil = new Intent(Intent. ACTION_DIAL);
        panggil.setData(Uri. fromParts("tel",nomor,null));
        startActivity(panggil);
    }

    public void email(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(    "mailto", "frisklamia@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Isi Email");
        startActivity(Intent.createChooser(emailIntent, "Feedback"));
    }
}
