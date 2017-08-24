package com.edwinacubillos.sesion1interfaces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText eNombre, eApellido,eCelular, eCorreo;
    private TextView tInfo;
    private Button bRegistrar;
    private String nombre, apellido, sexo="Masculino",hobbies="",celular, correo,ciudad;
    private CheckBox cCine, cComer, cDeporte, cDormir;
    private Spinner sCiudad;
 //   private RadioButton rMasculino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eNombre = (EditText) findViewById (R.id.eNombre);
        eApellido = (EditText) findViewById(R.id.eApellido);
        eCelular = (EditText) findViewById (R.id.eCelular);
        eCorreo = (EditText) findViewById(R.id.eMail);
        bRegistrar = (Button) findViewById(R.id.bRegistrar);
        tInfo = (TextView) findViewById(R.id.tInfo);
        cCine =(CheckBox) findViewById(R.id.cCine);
        cComer =(CheckBox) findViewById(R.id.cComer);
        cDeporte =(CheckBox) findViewById(R.id.cDeporte);
        cDormir =(CheckBox) findViewById(R.id.cDormir);
        sCiudad = (Spinner) findViewById(R.id.sCiudad);
 //       rMasculino = (RadioButton) findViewById(R.id.rMasculino);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ciudad_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        sCiudad.setAdapter(adapter);

       // sCiudad.setOnItemClickListener();



        sCiudad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ciudad=adapterView.getItemAtPosition(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void Registrar(View view) {
        hobbies = "";
        if (cCine.isChecked()) {hobbies = hobbies + " " + "Cine";}
        if (cComer.isChecked()) {hobbies = hobbies + " " + "Comer";}
        if (cDeporte.isChecked()) {hobbies = hobbies + " " + "Deporte";}
        if (cDormir.isChecked()) {hobbies = hobbies + " " + "Dormir";}

        nombre = eNombre.getText().toString();
        apellido = eApellido.getText().toString();
        celular = eCelular.getText().toString();
        correo = eCorreo.getText().toString();

        tInfo.setText("Nombre: "+nombre+
                " \nApellido: "+apellido+
                " \nVelular: "+celular+
                " \ncorreo: "+correo+
                " \nciudad: "+ciudad+
                " \nSexo: "+sexo+
                " \nHobbies: "+hobbies);
    }

    public void onRadioButtonClicked(View view) {
       int id = view.getId();
        if (id == R.id.rMasculino) {
            sexo = "Masculino";
        }
        if (id == R.id.rFemenino){
            sexo = "Femenino";
        }
    }

    public void onCheckboxClicked(View view) {
      /*  int id = view.getId();
        switch (id){
            case R.id.cCine: if (((CheckBox) view).isChecked()){
                hobbies = hobbies + "Cine";
            }
                break;
            case R.id.cComer: hobbies = hobbies + "Comer";
                break;
            case R.id.cDeporte: hobbies = hobbies + "Deporte";
                break;
            case R.id.cCDormir: hobbies = hobbies + "Dormir";
                break;
        }*/
    }
}











