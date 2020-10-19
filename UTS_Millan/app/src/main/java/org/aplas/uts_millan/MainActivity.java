package org.aplas.uts_millan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText nNama, nKelas, nHadir, nTugas, nUTS, nUAS, nUsername, nPassword;
    TextView tNA, tSemester;
    Button nLogin, nBatal, nHitung, nKeluar;
    Integer NH, NT, UTS, UAS;
    Double NA;
    ImageView nlogo;
    RadioButton nGanjil, nGenap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nNama = (EditText) findViewById(R.id.eNama);
        nKelas = (EditText) findViewById(R.id.eKelas);
        nGanjil=(RadioButton) findViewById(R.id.ganjil);
        nGenap=(RadioButton) findViewById(R.id.genap);
        nHadir = (EditText) findViewById(R.id.eHadir);
        nTugas = (EditText) findViewById(R.id.eTugas);
        nUTS = (EditText) findViewById(R.id.eUTS);
        nUAS = (EditText) findViewById(R.id.eUAS);
        nUsername = (EditText)findViewById(R.id.eUsername);
        nPassword = (EditText) findViewById(R.id.ePassword);
        nlogo = (ImageView) findViewById(R.id.sd);
        nLogin = (Button) findViewById(R.id.bLogin);
        nBatal = (Button) findViewById(R.id.bBatal);
        nHitung = (Button) findViewById(R.id.bHitung);
        nKeluar = (Button) findViewById(R.id.bKeluar);


        tNA = (TextView) findViewById(R.id.txtNA);
        tSemester = (TextView) findViewById(R.id.Semester);

    }
    public void showDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        //set tittle dialognya
        alertDialogBuilder.setTitle("Apakah Anda Ingin Keluar dari Aplikasi?");

        //set pesan dari dialog
        alertDialogBuilder
                .setMessage("Klik Ya untuk keluar !")
                .setIcon(R.mipmap.ic_launcher)
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //jika tombol diklik,akan menutup dialog
                        //terjadi keluar
                        finish();
                    }
                })
                .setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                    }
                });
        //membuat alert dialog keluar dari builder
        AlertDialog alertDialog = alertDialogBuilder.create();

        //menampilkan alert dialog
        alertDialog.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    public void masuk(View klik){
        String keyword= "guru123";
        String pass = nPassword.getText().toString();
        if(keyword.equals(pass)){
            nUsername.setVisibility(View.INVISIBLE);
            nPassword.setVisibility(View.INVISIBLE);
            nlogo.setVisibility(View.INVISIBLE);
            nLogin.setVisibility(View.INVISIBLE);

            nNama.setVisibility(View.VISIBLE);
            nKelas.setVisibility(View.VISIBLE);
            tSemester.setVisibility(View.VISIBLE);
            nGanjil.setVisibility(View.VISIBLE);
            nGenap.setVisibility(View.VISIBLE);
            nHadir.setVisibility(View.VISIBLE);
            nTugas.setVisibility(View.VISIBLE);
            nUTS.setVisibility(View.VISIBLE);
            nUAS.setVisibility(View.VISIBLE);
            tNA.setVisibility(View.VISIBLE);

            nBatal.setVisibility(View.VISIBLE);
            nHitung.setVisibility(View.VISIBLE);
            nKeluar.setVisibility(View.VISIBLE);

            Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_LONG).show();
        }else{
            nUsername.setVisibility(View.VISIBLE);
            nPassword.setVisibility(View.VISIBLE);
            nlogo.setVisibility(View.VISIBLE);
            nLogin.setVisibility(View.VISIBLE);


            nNama.setVisibility(View.INVISIBLE);
            nKelas.setVisibility(View.INVISIBLE);
            tSemester.setVisibility(View.INVISIBLE);
            nGanjil.setVisibility(View.INVISIBLE);
            nGenap.setVisibility(View.INVISIBLE);
            nHadir.setVisibility(View.INVISIBLE);
            nTugas.setVisibility(View.INVISIBLE);
            nUTS.setVisibility(View.INVISIBLE);
            nUAS.setVisibility(View.INVISIBLE);
            tNA.setVisibility(View.INVISIBLE);

            nBatal.setVisibility(View.INVISIBLE);
            nHitung.setVisibility(View.INVISIBLE);
            nKeluar.setVisibility(View.INVISIBLE);

            Toast.makeText(getApplicationContext(), "Password is wrong", Toast.LENGTH_LONG).show();
        }
    }
    public void aksi (View klik){
        switch (klik.getId()){
            case R.id.bHitung:

                if (nHadir.getText().toString().equals("") ||
                        nTugas.getText().toString().equals("") ||
                        nUTS.getText().toString().equals("") ||
                        nUAS.getText().toString().equals("")) {

                }else{
                    NH = Integer.parseInt(nHadir.getText().toString());
                    NT = Integer.parseInt(nTugas.getText().toString());
                    UTS = Integer.parseInt(nUTS.getText().toString());
                    UAS = Integer.parseInt(nUAS.getText().toString());
                    NA = (0.1 * NH) + (0.2 * NT) + (0.3 * UTS) + (0.4 * UAS);
                    tNA.setText("Nilai Akhir : " +
                            String.valueOf(NA).toString());
                }
                break;
            case R.id.bBatal:
                nNama.setText("");
                nKelas.setText("");
                nHadir.setText("");
                nTugas.setText("");
                nUTS.setText("");
                nUAS.setText("");
                nGanjil.setChecked(false);
                nGenap.setChecked(false);
                tNA.setText("Nilai Akhir : ");
                break;
            case R.id.bKeluar:
                nKeluar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showDialog();

                    }
                });

                break;
        }
    }


}