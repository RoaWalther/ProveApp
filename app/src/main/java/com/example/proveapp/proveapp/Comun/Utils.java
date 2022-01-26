/*
 * Utils.java
 *
 * Created on 29 de Septiembre de 2018, 06:36 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.example.proveapp.proveapp.Comun;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.BatteryManager;
import android.os.Environment;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proveapp.proveapp.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.TimeZone;

/**
 *
 * @author Yeison Sanchez
 */
public class Utils {

    /** Creates a new instance of Utils */
    public Utils() {
    }

    /** Este metodo realiza un retardo en milisegundos                          
     * @
     */
    public static void delay(long milisecs){
        long t0 = System.currentTimeMillis() + milisecs;

        while(System.currentTimeMillis() < t0);

    }

    /** Este metodo convierte un array de Bytes a un objeto tipo String                          
     * @retorna la cadena tipo String
     */
    public static String uninterpret_ASCII(byte[] rawData, int offset, int length){
        char[] ret = new char[length];
        for (int i = 0; i < length; i++)
        {
            ret[i] = (char)rawData[offset + i];
        }
        return new String(ret);
    }

    /*******************************************************************************
     Function:   replaceChar
     Description: reemplazar un caracter por otro en un buffer
     Input:    *outputData = buffer a modificar
     antiguo = caracter que se reemplaza
     nuevo= caracter con el que se reemplaza
     len= longitud a recorrer en el buffer
     Return:   Nothing
     *******************************************************************************/
    public static void replaceChar(byte[] outputData, byte antiguo , byte nuevo, int len){
        int i;

        for(i=0; i<len; i++)
            if(outputData[i] == antiguo)
                outputData[i] = nuevo;
    }

    /** Este metodo separa un array de bytes en tokens dependiendo del caracter recibido  
     * @Retorna un array de cadenas con los tokens separados
     */
    public static String[] tokenizer(byte[] array, int offset, int length, byte separator, int numTokens){
        String[] tokens = new String[numTokens];
        int i, len_tok, j=0;

        while(j < numTokens){
            len_tok=0;
            for(i=offset; i<length; i++){
                if(array[i] == separator){

                    tokens[j]= uninterpret_ASCII(array, offset, len_tok);

                    offset += (len_tok + 1);
                    j++;
                    break;
                }
                len_tok++;
            }
        }

        return tokens;
    }

    /** Este metodo separa un array de bytes en tokens dependiendo del tama�o (LV)  
     * @Retorna un array de cadenas con los tokens separados
     */
    public static String[] tokenizer(byte[] array, int offset, int numTokens){
        String[] tokens = new String[numTokens];
        int i;

        for(i=0; i<numTokens; i++){
            tokens[i]= uninterpret_ASCII(array, offset + 1, array[offset]);
            offset += (array[offset] + 1);
        }

        return tokens;
    }

    /** Este metodo obtiene la fecha y hora actual
     *  en el formato YYYYMMDDhhmmss  
     * @Retorna una cadena con el formato de fecha y hora
     */
    public static String getDateTime(){
        String day, month, year, hour, minute, second;
        TimeZone tz = TimeZone.getTimeZone("GMT-5");
        Calendar actualDateTime = Calendar.getInstance(tz);

        year= String.valueOf(actualDateTime.get(actualDateTime.YEAR));
        month= String.valueOf(actualDateTime.get(actualDateTime.MONTH) + 1);
        day= String.valueOf(actualDateTime.get(actualDateTime.DAY_OF_MONTH));
        hour= String.valueOf(actualDateTime.get(actualDateTime.HOUR_OF_DAY));
        minute= String.valueOf(actualDateTime.get(actualDateTime.MINUTE));
        second= String.valueOf(actualDateTime.get(actualDateTime.SECOND));

        if((actualDateTime.get(actualDateTime.MONTH) + 1) < 10)
            month= "0" + month ;
        if(actualDateTime.get(actualDateTime.DAY_OF_MONTH) < 10)
            day= "0" + day ;
        if(actualDateTime.get(actualDateTime.HOUR_OF_DAY) < 10)
            hour= "0" + hour ;
        if(actualDateTime.get(actualDateTime.MINUTE) < 10)
            minute= "0" + minute ;
        if(actualDateTime.get(actualDateTime.SECOND) < 10)
            second= "0" + second ;

        //year = year.substring(2,4);

        String dateTime = year + month + day + hour + minute + second;
        return dateTime;
    }

    /*******************************************************************************
     Function        : getDate
     Description     : Recibe la fecha en formato Dia/mes/año (20/01/18)
     Return          : Fecha
     ******************************************************************************/
    public static String getDate(boolean anio4Digitos){
        String day, month, year, hour, minute, second;
        TimeZone tz = TimeZone.getTimeZone("GMT-5");
        Calendar actualDateTime = Calendar.getInstance(tz);

        year= String.valueOf(actualDateTime.get(actualDateTime.YEAR));
        month= String.valueOf(actualDateTime.get(actualDateTime.MONTH) + 1);
        day= String.valueOf(actualDateTime.get(actualDateTime.DAY_OF_MONTH));
        hour= String.valueOf(actualDateTime.get(actualDateTime.HOUR_OF_DAY));
        minute= String.valueOf(actualDateTime.get(actualDateTime.MINUTE));
        second= String.valueOf(actualDateTime.get(actualDateTime.SECOND));

        if((actualDateTime.get(actualDateTime.MONTH) + 1) < 10)
            month= "0" + month ;
        if(actualDateTime.get(actualDateTime.DAY_OF_MONTH) < 10)
            day= "0" + day ;
        if(actualDateTime.get(actualDateTime.HOUR_OF_DAY) < 10)
            hour= "0" + hour ;
        if(actualDateTime.get(actualDateTime.MINUTE) < 10)
            minute= "0" + minute ;
        if(actualDateTime.get(actualDateTime.SECOND) < 10)
            second= "0" + second ;

        if (anio4Digitos == false)
            year = year.substring(2,4);


        //String dateTime = year + month + day + hour + minute + second;
        String dateTime = day + "/" + month + "/" + year;
        return dateTime;
    }

    /*******************************************************************************
     Function        : getTime
     Description     : Recibe la hora en formato HH:MM (Hora:Minuto)
     Return          : Hora
     ******************************************************************************/
    public static String getTime(boolean segundos){

        String time;
        String day, month, year, hour, minute, second, ampm;
        TimeZone tz = TimeZone.getTimeZone("GMT-5");
        Calendar actualDateTime = Calendar.getInstance(tz);

        hour= String.valueOf(actualDateTime.get(actualDateTime.HOUR_OF_DAY));
        minute= String.valueOf(actualDateTime.get(actualDateTime.MINUTE));
        second = String.valueOf(actualDateTime.get(actualDateTime.SECOND));


        if(actualDateTime.get(actualDateTime.HOUR_OF_DAY) < 10)
            hour= "0" + hour ;
        if(actualDateTime.get(actualDateTime.MINUTE) < 10)
            minute= "0" + minute ;
        if (actualDateTime.get(actualDateTime.SECOND) < 10)
            second = "0" + second;

        if (segundos == true)
            time = hour + ":" + minute + ":" + second;
        else
            time = hour + ":" + minute;

        return time;
    }

    /*******************************************************************************
     Function:	  obtenerFechaHora
     Description: regresa una cadena con la fecha y la hora
     Input:		  nothing
     Return:	  fecha

     *******************************************************************************/
    public static String obtenerFechaHora(){
        String month;
        String day;
        String year;
        String fecha = "";

        day = Utils.getDate(true).substring(0,2);
        month = Utils.getDate(true).substring(3,5);
        year = Utils.getDate(true).substring(6, Utils.getDate(true).length() );

        month = obtenerMesLetras( Integer.parseInt(month) );

        fecha = month + " " + day + "," + "  " + year + "  " + Utils.getTime(true);

        return fecha;
    }

    /*******************************************************************************
     Function        : obtenerMesLetras
     Description     : Recibe el mes en entero y lo convierte a cadena
     Input           : mes = mes en entero a convertir
     Return          : Cadena con fecha
     ******************************************************************************/
    public static String obtenerMesLetras(int mes){

        switch (mes){
            case 1:
                return "Ene";
            case 2:
                return "Feb";
            case 3:
                return "Mar";
            case 4:
                return "Abr";
            case 5:
                return "May";
            case 6:
                return "Jun";
            case 7:
                return "Jul";
            case 8:
                return "Ago";
            case 9:
                return "Sep";
            case 10:
                return "Oct";
            case 11:
                return "Nov";
            case 12:
                return "Dic";
            default:
                return "";
        }

    }

    /** Obtiene un numero (int) aleatorio en un inervalo determinado
     *  int: 32 bits [ -2.147.483.648  a  2.147.483.647 ]
     * @desde = Limite inferior  
     * @hasta = Limite superior
     * @Retorna el numero aleatorio
     */
    public static int getRandomInt(int desde , int hasta){
        Random azar;
        azar = new Random(System.currentTimeMillis());
        return desde + Math.abs(azar.nextInt()) % (hasta - desde + 1);
    }


    /** Obtiene un numero (long) aleatorio en un inervalo determinado
     *  long: 64 bits [ -9.223.372.036.854.775.808  a  9.223.372.036.854.775.807 ]
     * @desde = Limite inferior  
     * @hasta = Limite superior
     * @Retorna el numero aleatorio
     */
    public static long getRandomLong(long desde , long hasta){
        Random azar;
        azar = new Random(System.currentTimeMillis());
        return desde + Math.abs(azar.nextLong()) % (hasta - desde + 1);
    }


   /**
    * Asigna al Buffer el caracter especificado en cada una de sus posiciones hasta completar size
    * @param Buffer: buffer de tipo byte que se va a modificar
    * @param caracter: caracter a agregar al buffer
    * @param size: Tama�o que se va copiar
    */
    public static void memSet(byte[] Buffer, byte caracter, int size ) {
        int i;

        for(i=0; i<size; i++){
            Buffer[i] = caracter;
        }
    }


    /**
     * Muestra la memoria de un boffer en hexa y ascii
     * @param Buffer: buffer que se va a mostrar
     * @param tam: Tama�o que se va a mostrar     
     */
    public static void dumpMemory(byte[] Buffer, int tam)
    {
        int i;

        byte[] BufferDisplay = new byte[tam];

        for(i=0; i<tam; i++){
            if( Buffer[i] >= 32 && Buffer[i] <= 126 )
                BufferDisplay[i] = Buffer[i];
            else
                BufferDisplay[i] = '.';
        }

        System.out.println("\n\n\n");

        for(i=0; i<tam; i++){

            //System.out.print( ISOUtil.unPadLeft( (ISOUtil.padleft(Integer.toHexString(Buffer[i]), 2, '0').toUpperCase() ) , 'F' ) + " " );

            System.out.print(ISOUtil.hexString(Buffer[i]) + " ");

            if( (i+1) % 16 == 0){
               System.out.print( "   "  + uninterpret_ASCII(BufferDisplay, i - 15, 16) );
               System.out.println();
            }
            else if(i+1 == tam){

               System.out.print( ISOUtil.padleft( "   ", 3*(16-tam%16), ' ' ) );
               System.out.print( "   " + uninterpret_ASCII(BufferDisplay, i - (tam%16) + 1, tam%16) );

               System.out.println();
            }

        }

        System.out.println();

        //System.out.println(ISOUtil.hexString(Buffer, 0, tam));        

    }

    /*******************************************************************************
     Function        : strLen
     Description     : Recibe un array de bytes y muestra la cantidad
     Input           : Buffer = Tamaño del byte
     Return          : Cantidad
     ******************************************************************************/
    public static int strLen(byte[] Buffer) {
        int i;

        for(i=0; i<Buffer.length; i++){
            if(Buffer[i] == 0x00)
                break;
        }

        return i;
    }


    /*******************************************************************************
     Function        : formatMiles
     Description     : Recibe una cadena y la convierte en formato miles
     Input           : cadena = Cadena a convertir
     Return          : cadena formateada
     ******************************************************************************/
    public static String formatMiles(String cadena){
        int i, k = 0;
        int j = 0;
        int tam;

        tam = cadena.length();

        byte[] cadena_orig = cadena.getBytes();
        byte[] cad_destino = new byte[50];

        i=tam/3;															// Calc�lo la cantidad de puntos de mil que se van a agregar
        if(i*3==tam) i--;
	k=0;

	for(j=tam-1; j>=0; j--){
            cad_destino[j+i]=cadena_orig[j];
            k++;
            if( (k/3)*3==k ){
                i--;

                if( (j+i) > 0 )
                    cad_destino[j+i]='.';
            }
	}

        return uninterpret_ASCII(cad_destino, 0, strLen(cad_destino) ) ;
    }

    /**
     * 弹出撤销框
     */
    private static int toByte(char c) {
        byte b = (byte)"0123456789ABCDEF".indexOf(c);
        return b;
    }
    public static byte[] hexStringToByteArray(String hex) {
        int len = hex.length() / 2;
        byte[] result = new byte[len];
        char[] achar = hex.toCharArray();

        for(int i = 0; i < len; ++i) {
            int pos = i * 2;
            result[i] = (byte)(toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
        }

        return result;
    }

    /*******************************************************************************
     Function        : extraerString
     Description     : Extrae digitos de una cadena
     Input           : s = Cadena a extraer
     Return          : cadena final
     ******************************************************************************/
    public static String extraerString(String s){
        String strfinal="";

        for(int i =0; i< s.length();i++) {
            strfinal +="3";
            strfinal += s.substring(i,i+1);

        }
        return strfinal;
    }

    /*******************************************************************************
     Function        : writeLOG
     Description     :
     Input           : data =
                       tipo =
     Return          : 0
     ******************************************************************************/
    public  static int writeLOG(String data, String tipo) {

        File extStore = Environment.getExternalStorageDirectory();
        String fileName = tipo+".txt";
        String path = extStore.getAbsolutePath() + "/" + fileName;
        try {
            File myFile = new File(path);
            myFile.createNewFile();
            FileOutputStream fOut = new FileOutputStream(myFile);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
            myOutWriter.append(data);
            myOutWriter.close();
            fOut.close();

            //Toast.makeText(getApplicationContext(), fileName + " saved", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Log.e("Ficheros Reverso w", "Error al escribir fichero a memoria interna");
        }
        return 0;
    }

    /*******************************************************************************
     Function        : getImei
     Description     : Obtiene el IMEI de un dispositivo en Android
     Input           : c = Contexto
     Return          : IMEI
     ******************************************************************************/
    @SuppressLint("MissingPermission")
    public static String getImei(Context c) {
        TelephonyManager telephonyManager = (TelephonyManager) c
                .getSystemService(Context.TELEPHONY_SERVICE);

        //return "865067037731257";
        return "863835028259393";  // IMEI PARA ASTRO PRUEBAS
        //return "359682000228942";
        //return "863835023836377";   // IMEI pruebas
        //return telephonyManager.getDeviceId();
    }

    /*******************************************************************************
     Function        : getIDSim
     Description     : Obtiene el ID de una SIMCARD en Android
     Input           : c = Contexto
     Return          : ID de la SIMCARD
     ********************************************** ********************************/
    @SuppressLint("MissingPermission")
    public static String getIDSim(Context c) {
        TelephonyManager telephonyManager = (TelephonyManager) c
                .getSystemService(Context.TELEPHONY_SERVICE);

        //return "863835023836377";   // IMEI pruebas
        return telephonyManager.getSimSerialNumber();
    }

    /*******************************************************************************
     Function        : getOperator
     Description     : Obtiene el Operador de un dispositivo en Android
     Input           : c = Contexto
     Return          : Operador
     ******************************************************************************/
    @SuppressLint("MissingPermission")
    public static String getOperator(Context c) {
        TelephonyManager telephonyManager = (TelephonyManager) c
                .getSystemService(Context.TELEPHONY_SERVICE);

        //return "863835023836377";   // IMEI pruebas
        return telephonyManager.getSimOperatorName();
    }

    /*******************************************************************************
     Function        : getSerialLaperla
     Description     : Obtiene el serial del dispositivo
     Input           : c = Contexto
     Return          : IMEI
     ******************************************************************************/
    /*public static String getSerialLaperla(Context c){

        //String Imei = getImei(c);
        String Imei = Global.IMEI;
        String serial = Global.PREFIJO + Imei.substring(Imei.length()-8, Imei.length() );

        return "72131008606"; // SERIAL PARA PRUEBAS EN OTROS DISPOSITIVOS
        //return serial;
    }
    */

    /*******************************************************************************
     Function        : contarCaracter
     Description     : Cuenta caracteres
     Input           : array = Array a dividir
                       offset = inicio
                       length = longitud
                       separator = separador
     Return          : numero de caracteres
     ******************************************************************************/
    public static int contarCaracter (byte[] array, int offset, int length, byte separator) {

        int i;
        int numCaracteres = 0;

        for (i = offset; i < length; i++) {
            if (array[i] == separator) {

                numCaracteres++;
            }
        }
        return numCaracteres;
    }

    /*******************************************************************************
     Function        : timeStrToInt_12h
     Description     : Convierte una hora en formato 12 a entero
     Input           : horaLlegada = Hora a convertir
     Return          : hora convertida
     ******************************************************************************/
    public static int timeStrToInt_12h (String horaLlegada){
        String meridiano;
        String horas24 = "";

        meridiano = horaLlegada.substring(6,8);

        horaLlegada = horaLlegada.substring(0,5);
        horaLlegada = horaLlegada.replace(":","");

        if (meridiano.equals("PM") ){
            horas24 = String.valueOf( Integer.parseInt( horaLlegada.substring(0,2) ) + 12 );
            horaLlegada = horaLlegada.substring( 2, horaLlegada.length() );
        }

        horaLlegada = horas24 + horaLlegada;

        return Integer.parseInt(horaLlegada);
    }

    /*******************************************************************************
     Function        : timeStrToInt_24h
     Description     : Convierte una hora en formato 24 a entero
     Input           : horaLlegada = Hora a convertir
     Return          : hora convertida
     ******************************************************************************/
    public static int timeStrToInt_24h (String horaActual){

        horaActual = horaActual.substring(0,5);
        horaActual = horaActual.replace(":","");

        return Integer.parseInt(horaActual);
    }

    /*******************************************************************************
     Function        : DialogError
     Description     : Crea un dialogo de error
     Input           : c = Contexto
     Return          : Ninguno
     ******************************************************************************/
    public static void DialogError(Context c) {

        Global.MsgError = "Código: " + Global.tokens[1] + "\n" + "Descripción: " + Global.tokens[2];

        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(c,
                R.style.DialogColor));

        builder.setTitle("Error");
        builder.setMessage(Global.MsgError);
        builder.setCancelable(true);


        final Dialog dialog = builder.create();
        dialog.show();

        int titleDividerId = c.getResources().getIdentifier("titleDivider", "id", "android");
        View titleDivider = dialog.findViewById(titleDividerId);
        if (titleDivider != null)
            titleDivider.setBackgroundColor(c.getResources().getColor(R.color.colorPrimary));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                dialog.dismiss();
            }
        },5000);

    }

    /*******************************************************************************
     Function        : CustomAlertDialog
     Description     : Crea un dialogo customizado
     Input           : c = Contexto
                       titulo = Titulo del dialogo
                       msg = Mensaje del dialogo
                       tiempo = Tiempo del dialogo
     Return          : Ninguno
     ******************************************************************************/
    public static void CustomAlertDialog (Context c, String titulo, String msg, int tiempo){

        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(c,
                R.style.DialogColor));

        builder.setTitle(titulo);
        builder.setMessage(msg);
        builder.setCancelable(true);


        final Dialog dialog = builder.create();
        dialog.show();

        int titleDividerId = c.getResources().getIdentifier("titleDivider", "id", "android");
        View titleDivider = dialog.findViewById(titleDividerId);
        if (titleDivider != null)
            titleDivider.setBackgroundColor(c.getResources().getColor(R.color.colorPrimary));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                dialog.dismiss();
            }
        }, tiempo);
    }

    /*******************************************************************************
     Function        : CustomAlertDialogImpresion
     Description     : Crea un dialogo customizado
     Input           : c = Contexto
                       titulo = Titulo del dialogo
                       msg = Mensaje del dialogo
                       tiempo = Tiempo del dialogo
     Return          : Ninguno
     ******************************************************************************/
    public static void CustomAlertDialogImpresion (Context c, String titulo, String msg, int tiempo){

        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(c,
                R.style.DialogColor));

        builder.setTitle(titulo);
        builder.setMessage(msg);
        builder.setCancelable(false);


        final Dialog dialog = builder.create();
        dialog.show();

        int titleDividerId = c.getResources().getIdentifier("titleDivider", "id", "android");
        View titleDivider = dialog.findViewById(titleDividerId);
        if (titleDivider != null)
            titleDivider.setBackgroundColor(c.getResources().getColor(R.color.colorPrimary));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
            }
        }, tiempo);
    }

    /*******************************************************************************
     Function        : CustomToast
     Description     : Crea un toast customizado
     Input           : c = Contexto
                       titulo = Titulo del dialogo
                       msg = Mensaje del dialogo
                       duracion = Duración del dialogo
     Return          : Ninguno
     ******************************************************************************/
    public static void CustomToast(Context c, String titulo, String msg, int duracion){

            TextView textTitulo = (TextView) Global.layout.findViewById(R.id.textTitulo);
            textTitulo.setText(titulo);

            TextView textMensaje = (TextView) Global.layout.findViewById(R.id.textMensaje);
            textMensaje.setText(msg);

            Toast toast = new Toast(c);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.setDuration(duracion);
            toast.setView(Global.layout);
            toast.show();
    }

    /*******************************************************************************
     Function        : getDecimals
     Description     : Recibe un numero decimal y retorna una cadena con los digitos decimales deseados
     Input           : numero = numero a convertir
                       cantDecimales = Cantidad de decimales
     Return          : cadena con los decimales seleccionados
     ******************************************************************************/
    public static String getDecimals(String numero, int cantDecimales){
        String parteDecimal = "", parteDecimalRet = "";
        int numPuntos = 0, numTokens;

        numero = numero + ".";

        numPuntos = contarCaracter(numero.getBytes(),0,numero.getBytes().length,(byte) '.');

        numTokens = numPuntos;

        Global.tokens = tokenizer(numero.getBytes(), 0, numero.getBytes().length, (byte) '.', numTokens);

        if (numTokens > 1)
            parteDecimal = Global.tokens[1];

        //parteDecimal = ISOUtil.padleft(parteDecimal, cantDecimales, '0');
        if (parteDecimal.length() < cantDecimales)
            parteDecimal = ISOUtil.padRight(parteDecimal, cantDecimales, '0');

        parteDecimalRet = parteDecimal.substring(0,cantDecimales);

        return parteDecimalRet;
    }

    /*******************************************************************************
     Function        : pintarLineaDialogo
     Description     : Pinta la linea de un AlertDialog de color verde
     Input           : c = Contexto
                       dialog = Dialogo a pintar
     Return          : cadena con los decimales seleccionados
     ******************************************************************************/
    public static void pintarLineaDialogo(Context c, Dialog dialog) {

        int titleDividerId = c.getResources().getIdentifier("titleDivider", "id", "android");
        View titleDivider = dialog.findViewById(titleDividerId);
        if (titleDivider != null)
            titleDivider.setBackgroundColor(c.getResources().getColor(R.color.colorPrimary));
    }


    public static int getDayOfTheWeek(Date d) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(d);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    /***********************************************************************************************
     Function        : colorizeDatePicker
     Description     : Pinta la linea de un DatePicker del color del colorPrimary
     Input           : datePicker = DatePicker a pintar
     Return          : Nothing
     **********************************************************************************************/
    public static void colorizeDatePicker(DatePicker datePicker) {
        Resources system = Resources.getSystem();
        int dayId = system.getIdentifier("day", "id", "android");
        int monthId = system.getIdentifier("month", "id", "android");
        int yearId = system.getIdentifier("year", "id", "android");

        NumberPicker dayPicker = (NumberPicker) datePicker.findViewById(dayId);
        NumberPicker monthPicker = (NumberPicker) datePicker.findViewById(monthId);
        NumberPicker yearPicker = (NumberPicker) datePicker.findViewById(yearId);

        setDividerColor(dayPicker);
        setDividerColor(monthPicker);
        setDividerColor(yearPicker);
    }

    /***********************************************************************************************
     Function        : setDividerColor
     Description     : pintador de la función colorizeDatePicker
     Input           : picker = NumberPicker a pintar
     Return          : Nothing
     **********************************************************************************************/
    private static void setDividerColor(NumberPicker picker) {
        if (picker == null)
            return;

        final int count = picker.getChildCount();
        for (int i = 0; i < count; i++) {
            try {
                Field dividerField = picker.getClass().getDeclaredField("mSelectionDivider");
                dividerField.setAccessible(true);
                ColorDrawable colorDrawable = new ColorDrawable(picker.getResources().getColor(R.color.colorPrimary));
                dividerField.set(picker, colorDrawable);
                picker.invalidate();
            } catch (Exception e) {
                Log.w("setDividerColor", e);
            }
        }
    }


    /***********************************************************************************************
     Function        : validate_battery
     Description     : Valida el estado de la bateria
     Input           : context = Contexto
     Return          : TRUE = Si la carga es mayor a la debida
                       FALSE = Si la carga es menor a la debida
     **********************************************************************************************/
    public static boolean validate_battery(Context context) {
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = context.registerReceiver(null, ifilter);

        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);

        if (level <= Global.CARGA_MINIMA_BATERIA) {
            Global.levelBattery = false;
            return false;
        }

        Global.levelBattery = true;
        return true;
    }

    /*******************************************************************************
     Function:	  retrieve_str
     Description: regresa una cadena q se encuentra entre dos delimitadores
     Input:		  S1 = cadena base
                  S2 = cadena a retornar
                  LIMIT_LEFT = delimitador izquierdo
                  LIMIT_RIGHT =	delimitador derecho
     Return:	  retorna el indice de la posicion siguiente a LIMIT_RIGHT
                  retorna 0 sino encontró la cadena

     *******************************************************************************/
    public static String retrieve_str(String S1, String S2, String LIMIT_LEFT, String LIMIT_RIGHT){
        int i, j = 0;

        if( S1.length() != 0 ){

            i = S1.indexOf(LIMIT_LEFT) + LIMIT_LEFT.length();

            if(i != -1){

                j = S1.indexOf(LIMIT_RIGHT, i);

                if(j != -1){

                    S2 = S1.substring(i,j);
                    Global.indice += (i + S2.length() + LIMIT_RIGHT.length() );
                    return S2;
                }


            }
        }

        return "";
    }

    /*******************************************************************************
     Método       : formatoMilesEditText
     Description  : Muestra el editText en formato miles
     Input        : valor = EditText que se le implementara el formato
     Return       : Ninguno
     *******************************************************************************/
    public static void formatoMilesEditText(EditText valor) {

        final EditText sumando = (EditText) valor;

        sumando.addTextChangedListener(new TextWatcher() {

            private DecimalFormat formatoMiles;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                formatoMiles = new DecimalFormat("#,###");

                sumando.removeTextChangedListener(this);

                try {
                    int inilen, endlen, sel, cp;

                    inilen = sumando.getText().length();

                    String v = s.toString().replace(String.valueOf(formatoMiles.getDecimalFormatSymbols().getGroupingSeparator()), "");
                    Number n = formatoMiles.parse(v);

                    cp = sumando.getSelectionStart();

                    sumando.setText(formatoMiles.format(n));

                    endlen = sumando.getText().length();

                    sel = (cp + (endlen - inilen));

                    if (sel > 0 && sel <= sumando.getText().length()) {
                        sumando.setSelection(sel);
                    } else {
                        sumando.setSelection(sumando.getText().length() - 1);
                    }

                } catch (NumberFormatException nfe) {
                    // do nothing?
                } catch (ParseException e) {
                    // do nothing?
                }

                sumando.addTextChangedListener(this);
            }
        });
    }

}
