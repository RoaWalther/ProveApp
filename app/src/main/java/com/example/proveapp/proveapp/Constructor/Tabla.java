package com.example.proveapp.proveapp.Constructor;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.InputFilter;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.proveapp.proveapp.R;
import com.example.proveapp.proveapp.Comun.Global;

import java.util.ArrayList;

import static android.text.InputType.TYPE_CLASS_NUMBER;
import static android.text.InputType.TYPE_CLASS_TEXT;
import static android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD;
import static android.text.InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD;

/**
 * Created by CD002 on 18/12/2017.
 */

public class Tabla {

    // Variables
    private TableLayout tabla; // Layout donde se pintará la tabla
    //private ArrayList<TableRow> filas; // Array de las filas de la tabla
    private Activity actividad;
    private Resources rs;
    private int FILAS, COLUMNAS; // Filas y columnas de nuestra tabla

    /**
     * Constructor de la tabla
     * @param actividad Actividad donde va a estar la tabla
     * @param tabla TableLayout donde se pintará la tabla
     */
    public Tabla(Activity actividad, TableLayout tabla){

        this.actividad = actividad;
        this.tabla = tabla;
        rs = this.actividad.getResources();
        FILAS = 6;
        COLUMNAS = 5;
        Global.filas = new ArrayList<TableRow>();
    }

    /**
     * Agrega una fila a la tabla
     * @param elementos;
     */
    public void agregarFilaTabla(ArrayList<String> elementos, int cantidad, String texto, boolean isTexto, boolean isContraseña,int indice) {

        TableRow.LayoutParams layoutCelda;
        TableRow.LayoutParams layoutFila = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);

        // Filas de la tabla
        Context context;
        //TableRow fila = new TableRow(actividad);

        Global.fila[indice] = new TableRow(actividad);
        Global.fila[indice].setLayoutParams(layoutFila);
        // Columnas de la tabla
        Global.editTexts = new EditText[cantidad + 1];
        Global.textViews = new TextView[cantidad + 1];

        // Diseño de cada una de las celdas de la tabla
        for (int i = 0; i < 1; i++) {

            if (indice == cantidad){
                Global.textViews[indice] = new TextView(actividad);
                Global.textViews[indice].setGravity(Gravity.CENTER);       // Gravedad centrada
                Global.textViews[indice].setText("");
                Global.textViews[indice].setTextSize(25);
                Global.textViews[indice].setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.FILL_PARENT, 5));   // Ancho, alto, y peso de las celdas
                Global.textViews[indice].setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);   // Alineación del texto al final
                Global.textViews[indice].setTextAppearance(actividad, R.style.boldRegister);
                actividad.setTheme(R.style.CampoAcentoColor);

                Global.fila[indice].addView(Global.textViews[indice]);
                break;
            }

            if ( (indice % 2) == 0) {                                                               // TextViews
                Global.textViews[i] = new TextView(actividad);
                Global.textViews[i].setGravity(Gravity.CENTER);       // Gravedad centrada
                Global.textViews[i].setText(texto);
                Global.textViews[i].setTextSize(25);
                Global.textViews[i].setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.FILL_PARENT, 5));   // Ancho, alto, y peso de las celdas
                Global.textViews[i].setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);   // Alineación del texto al final
                Global.textViews[i].setTextAppearance(actividad, R.style.boldRegister);
                actividad.setTheme(R.style.CampoAcentoColor);

                Global.fila[indice].addView(Global.textViews[i]);
            } else {                                                                                // EditTexts

                Global.editTexts[i] = new EditText(actividad);
                Global.editTexts[i].setGravity(Gravity.CENTER);       // Gravedad centrada
                Global.editTexts[i].setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.FILL_PARENT, 1));   // Ancho, alto, y peso de las celdas
                Global.editTexts[i].setPaddingRelative(12, 0, 12, 0);
                Global.editTexts[i].setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
                Global.editTexts[i].setTextAppearance(actividad, R.style.Widget_AppCompat_EditText);
                Global.editTexts[i].setBackgroundResource(R.drawable.custom_input);
                actividad.setTheme(R.style.CampoAcentoColor);
                Global.editTexts[i].setImeOptions(EditorInfo.IME_ACTION_NEXT);
                Global.editTexts[i].setTextAppearance(actividad, R.style.boldText);

                if (isContraseña == true)
                    Global.editTexts[i].setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_PASSWORD);

                else if (isTexto == true)
                    Global.editTexts[i].setInputType(TYPE_CLASS_TEXT);

                else if (isTexto == false)
                    Global.editTexts[i].setInputType(TYPE_CLASS_NUMBER);

                Global.fila[indice].addView(Global.editTexts[i]); // Añade los cambios de las columnas a las filas
            }
        }

        tabla.addView(Global.fila[indice]);
        Global.filas.add(Global.fila[indice]);

        FILAS++;
    }

    public int getFilas()
    {
        return FILAS;
    }

    /**
     * Devuelve las columnas de la tabla
     * @return Columnas totales de la tabla
     */
    public int getColumnas()
    {
        return COLUMNAS;
    }

    /**
     * Devuelve el número de celdas de la tabla, la cabecera se cuenta como fila
     * @return Número de celdas totales de la tabla
     */
    public int getCeldasTotales()
    {
        return FILAS * COLUMNAS;
    }

}
