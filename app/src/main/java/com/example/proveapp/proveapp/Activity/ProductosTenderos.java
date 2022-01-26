package com.example.proveapp.proveapp.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proveapp.proveapp.R;

public class ProductosTenderos extends AppCompatActivity {
    private TextView totalNeto;
    private Spinner spi,spi1,spi2,spi3,spi4;
    private EditText cant,cant1,cant2,cant3,cant4,pre,pre1,pre2,pre3,pre4;

    private  String productos []= {"Seleccione..","Leche","Huevos","Pan","Café"
            ,"Arroz"};
    int precios  [] = {2600,350,500,2000,1350};

    String can, can1, can2,can3,can4,pr,pr1,pr2,pr3,pr4;
    int canti=0, canti1=0, canti2=0,canti3=0,canti4=0, prei=0,prei1=0,prei2=0,prei3=0,prei4=0 ;
    int total=0,total1=0,total2=0,total3=0,total4=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos_tenderos);

        cant=(EditText)findViewById(R.id.cantidad);
        cant1 = (EditText)findViewById(R.id.cantidad1);
        cant2 = (EditText)findViewById(R.id.cantidad2);
        cant3 = (EditText)findViewById(R.id.cantidad3);
        cant4 = (EditText)findViewById(R.id.cantidad4);
        totalNeto = (TextView)findViewById(R.id.etTotal);

        pre = findViewById(R.id.precios);
        pre1 = findViewById(R.id.precios1);
        pre2 = findViewById(R.id.precios2);
        pre3 = findViewById(R.id.precios3);
        pre4 = findViewById(R.id.precios4);

        spi = (Spinner)findViewById(R.id.productos);
        spi1 = (Spinner)findViewById(R.id.productos1);
        spi2 = (Spinner)findViewById(R.id.productos2);
        spi3 = (Spinner)findViewById(R.id.productos3);
        spi4 = (Spinner)findViewById(R.id.productos4);

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, R.layout.cambio_letra_spinner,productos);
        spi.setAdapter(adapter);
        spi.setSelection(0);

        ArrayAdapter<String> adapter1= new ArrayAdapter<String>(this, R.layout.cambio_letra_spinner,productos);
        spi1.setAdapter(adapter1);
        spi1.setSelection(0);

        ArrayAdapter<String> adapter2= new ArrayAdapter<String>(this, R.layout.cambio_letra_spinner,productos);
        spi2.setAdapter(adapter2);
        spi2.setSelection(0);

        ArrayAdapter<String> adapter3= new ArrayAdapter<String>(this, R.layout.cambio_letra_spinner,productos);
        spi3.setAdapter(adapter3);
        spi3.setSelection(0);

        ArrayAdapter<String> adapter4= new ArrayAdapter<String>(this, R.layout.cambio_letra_spinner,productos);
        spi4.setAdapter(adapter4);
        spi4.setSelection(0);


    }

    public void calcular(View view){

        try {
                if (!cant.getText().toString().isEmpty() ){
                    if(!pre.getText().toString().isEmpty()) {
                        can = (cant.getText().toString());
                        canti = Integer.parseInt(can);
                        pr = (pre.getText().toString());
                        prei = Integer.parseInt(pr);
                        total = canti * prei;
                    }else{
                        total= 0;
                        Toast.makeText(this,"Precio vacio", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    total =0;
                    Toast.makeText(this,"Cantidad vacia", Toast.LENGTH_SHORT).show();
                }
                if (!cant1.getText().toString().isEmpty()) {
                    if(!pre1.getText().toString().isEmpty()) {
                        can1 = (cant1.getText().toString());
                        canti1 = Integer.parseInt( can1);
                        pr1 = (pre1.getText().toString());
                        prei1 = Integer.parseInt(pr1);
                        total1 = prei1 * canti1;
                    }else {
                        total1 =0;
                        Toast.makeText(this,"Precio vacio", Toast.LENGTH_SHORT).show();}
                }else{
                    total1 =0;
                    Toast.makeText(this,"Cantidad vacia", Toast.LENGTH_SHORT).show();
                }
                if (!cant2.getText().toString().isEmpty()){
                    if(!pre2.getText().toString().isEmpty()) {
                        can2 = (cant2.getText().toString());
                        canti2 = Integer.parseInt( can2);
                        pr2 =(pre2.getText().toString());
                        prei2 = Integer.parseInt(pr2);
                        total2 = prei2 * canti2;
                    }else{
                        total2 =0;
                        Toast.makeText(this,"Precio vacio", Toast.LENGTH_SHORT).show();}
                }else{
                    total2 =0;
                    Toast.makeText(this,"Cantidad vacia", Toast.LENGTH_SHORT).show();
                }
                if (!cant3.getText().toString().isEmpty()){
                    if(!pre3.getText().toString().isEmpty()){
                        can3 = (cant3.getText().toString());
                        canti3 = Integer.parseInt( can3);
                        pr3 = (pre3.getText().toString());
                        prei3= Integer.parseInt(pr3);
                        total3 = prei3 * canti3;
                    }else{
                        total3 =0;
                        Toast.makeText(this,"Precio vacio", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    total3 =0;
                    Toast.makeText(this,"Cantidad vacia", Toast.LENGTH_SHORT).show();
                }
                if (!cant4.getText().toString().isEmpty()){
                    if(!pre4.getText().toString().isEmpty()){
                        can4 = (cant4.getText().toString());
                        canti4 = Integer.parseInt( can4);
                        pr4 = (pre4.getText().toString());
                        prei4 = Integer.parseInt(pr4);
                        total4 = prei4 * canti4;
                    }else{
                        total4 =0;
                        Toast.makeText(this,"Precio vacio", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    total4 =0;
                    Toast.makeText(this,"Cantidad Vacia", Toast.LENGTH_SHORT).show();
                }

            int sumaTotal = 0;
            sumaTotal = total + total1 + total2 + total3 +total4;
            System.out.println("total= "+ total + " total1= "+total1 +" total2: "+total2);
            System.out.println("total3= "+ total3 + " total4= "+total4 +" totalTodo: "+sumaTotal);
            totalNeto.setText(String.valueOf(sumaTotal));

        }catch (Exception e){
            e.getMessage();
        }


    }

    public void verPrecio(View view) {
        try {
            String seleccion  = spi.getSelectedItem().toString();
               if (seleccion.equals("Leche") ) {
                   pre.setText(String.valueOf(precios[0]));
               }else if (seleccion.equals("Huevos")){
                    pre.setText(String.valueOf(precios[1]));
                }
                else if (seleccion.equals("Pan")){
                    pre.setText(String.valueOf(precios[2]));
                }
                else if (seleccion.equals("Café")){
                    pre.setText(String.valueOf(precios[3]));
                }
                else if (seleccion.equals("Arroz")){
                    pre.setText(String.valueOf(precios[4]));
                }
                else if(seleccion.equals("Seleccione..")){
                   pre.setText("");
               }


            String seleccion1 = spi1.getSelectedItem().toString();
                if (seleccion1.equals("Leche")){
                    pre1.setText(String.valueOf(precios[0]));
                }
                else if (seleccion1.equals("Huevos")){
                    pre1.setText(String.valueOf(precios[1]));
                }
                else if (seleccion1.equals("Pan")){
                    pre1.setText(String.valueOf(precios[2]));
                }
                else if (seleccion1.equals("Café")){
                    pre1.setText(String.valueOf(precios[3]));
                }
                else if (seleccion1.equals("Arroz")){
                    pre1.setText(String.valueOf(precios[4]));
                }else if(seleccion1.equals("Seleccione..")){
                    pre1.setText("");
                }

            String seleccion2 = spi2.getSelectedItem().toString();
                if (seleccion2.equals("Leche")){
                    pre2.setText(String.valueOf(precios[0]));
                }
                else if (seleccion2.equals("Huevos")){
                    pre2.setText(String.valueOf(precios[1]));
                }
                else if (seleccion2.equals("Pan")){
                    pre2.setText(String.valueOf(precios[2]));
                }
                else if (seleccion2.equals("Café")){
                    pre2.setText(String.valueOf(precios[3]));
                }
                else if (seleccion2.equals("Arroz")){
                    pre2.setText(String.valueOf(precios[4]));
                }else if(seleccion2.equals("Seleccione..")){
                    pre2.setText("");
                }

            String seleccion3 = spi3.getSelectedItem().toString();
                if (seleccion3.equals("Leche")){
                    pre3.setText(String.valueOf(precios[0]));
                }
                else if (seleccion3.equals("Huevos")){
                    pre3.setText(String.valueOf(precios[1]));
                }
                else if (seleccion3.equals("Pan")){
                    pre3.setText(String.valueOf(precios[2]));
                }
                else if (seleccion3.equals("Café")){
                    pre3.setText(String.valueOf(precios[3]));
                }
                else if (seleccion3.equals("Arroz")){
                    pre3.setText(String.valueOf(precios[4]));
                }else if(seleccion3.equals("Seleccione..")){
                    pre3.setText("");
                }

            String seleccion4 = spi4.getSelectedItem().toString();
                if (seleccion4.equals("Leche")){
                    pre4.setText(String.valueOf(precios[0]));
                }
                else if (seleccion4.equals("Huevos")){
                    pre4.setText(String.valueOf(precios[1]));
                }
                else if (seleccion4.equals("Pan")){
                    pre4.setText(String.valueOf(precios[2]));
                }
                else if (seleccion4.equals("Café")){
                    pre4.setText(String.valueOf(precios[3]));
                }
                else if (seleccion4.equals("Arroz")){
                    pre4.setText(String.valueOf(precios[4]));
                }else if(seleccion4.equals("Seleccione..")){
                    pre4.setText("");
                }
        }catch (Exception e){
            e.getMessage();
        }
    }

}
