package com.example.proveapp.proveapp.Comun;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Yeison Sanchez
 */
public class Global {

                                                                                                    // Identificadores de Nombre y version
    //--------------------------------------------------------------------------
    public static final String NOMBRE_APP               = "PROVEAPP";
    public static final String VERSION_APP              = "V1.0";
    public static final String CHECKSUM                 = "0929";
    //--------------------------------------------------------------------------

    /*                                                                                                // IPs y Puertos
    // produccion
    public static String    primaryIP               = "172.20.0.15";
    public static int       primaryPort             = 52200;
    public static String    primaryIPRecarga        = "172.20.0.15";
    */


    // Pruebas
    public static String primaryIP               = "10.121.171.31";
    public static int       primaryPort             = 10013;
    public static String primaryIPRecarga        = "10.121.171.31";


    public static final int       SOCKET_TIMEOUT          = 20000;     //20.000
    public static final int       MAX_LEN_INPUTDATA		  = 1024 * 16;
    public static final int       MAX_LEN_OUTPUTDATA	  = 1024 * 4;

    /*
    // Para tiquete de rollo pequeño de dos pulgadas SUNMI
    public static final int       MAX_LEN_LINE_SMALL      = 44;
    public static final int       MAX_LEN_LINE_NORMAL     = 33;
    public static final int       MAX_LEN_LINE_MEDIUM     = 26;
    public static final int       SIZE_NORMAL             = 24;
    public static final int       SIZE_SMALL              = 18;
    public static final int       SIZE_MEDIUM             = 30;
    */

    /*
    // Para tiquete de rollo grande de tres pulgadas SUNMI
    public static final int       MAX_LEN_LINE_SMALL      = 60;
    public static final int       MAX_LEN_LINE_NORMAL     = 40;
    public static final int       MAX_LEN_LINE_MEDIUM     = 32;
    public static final int       SIZE_SMALL              = 18;
    public static final int       SIZE_NORMAL             = 26;
    public static final int       SIZE_MEDIUM             = 34;
    */

    // Para newpos 9220
    public static final int       MAX_LEN_LINE_SMALL      = 42;
    public static final int       MAX_LEN_LINE_SMALL_18   = 36;
    public static final int       MAX_LEN_LINE_NORMAL     = 32;
    public static final int       MAX_LEN_LINE_MEDIUM     = 24;
    public static final int       MAX_LEN_LINE_BIG        = 16;
    public static final int       SIZE_SMALL              = 15;
    public static final int       SIZE_SMALL_18           = 17;
    public static final int       SIZE_NORMAL             = 20;
    public static final int       SIZE_MEDIUM             = 26;
    public static final int       SIZE_BIG                = 40;

    public static final int       JUGADAS                 = 6;
    public static final int       MAX_JUEGO               = 5;
    public static final int       MAX_LOTERIAS            = 200;
    public static final int       MAX_JUEGO_ASTRO         = 2;
    public static final int       MAX_JUGADAS_ASTRO       = 4;
    public static final int       MAX_JUEGO_SC            = 1;
    public static final int       MAX_JUGADAS_SC          = 5;
    public static final int       MAX_JUGADAS_PM          = 5;

    public static final int       TRANSACTION_OK          = 1;
    public static final int       ERR_OPEN_SOCKET         = -1;
    public static final int       ERR_WRITE_SOCKET        = -2;
    public static final int       ERR_TIMEOUT_SOCKET      = -3;
    public static final int       ERR_READ_SOCKET         = -4;

    public static final byte      PIPE                    = '|';
    public static final byte      ARROBA                  = '@';
    public static final byte      COMA                    = ',';
    public static final byte      GUION                   = '-';
    public static final byte      PUNTO_Y_COMA            = ';';
    public static final byte      SLASH                   = '/';
    public static final byte      AMPERSAND               = '&';
    public static final byte      VIRGULILLA              = '~';

    public static final int       TIME_INFORMATION        = 3000;
    public static final int       TIME_ERROR              = 5000;

    public static final String FIN_CADENA              = "z\n";
    public static final String SPACES_SMALL            = "                    ";
    public static final String SPACES_NORMAL           = "               ";
    //public static final String NULL_NUM                = " -- ";
    //public static final String NULL_VALOR              = "-----";
    public static final String NULL_NUM                = "****";
    public static final String NULL_VALOR              = "    0";
    public static final String NULL_VACIO              = "     ";
    public static final String CERO_CELDA              = "0";
    public static final int    CARGA_MINIMA_BATERIA    = 5;
    public static int   MAX_APUESTAS                   = 5;

    public static final String VCONFIG                 = "2";  // Pruebas:  revisar ese campo arancandolo en cero y luego guardando lo q llegue en la respuesta
                                                                                // Identificadores de transaccion

    public static final String MSG_ERR_CONEXION        = "Error de Conexión: No se estableció comunicación con el servidor, revise la configuración de Datos Móviles o WIFI";
    public static final String MSG_ERR_BATERIA         = "Nivel de bateria menor al permitido, Para operar, Por favor, cargue el dispositivo";
    public static final String MSG_ERR_PAPEL           = "Introduzca papel en la impresora";
    public static final String MSG_ERR_OCUPADA         = "La impresora se encuentra ocupada\nReintente Por Favor...";
    public static String TITULO_ERR_VALIDAR_IMPRESORA  = "";

    public static byte[]         inputData                = new byte[MAX_LEN_INPUTDATA];
    public static byte[]         outputData               = new byte[MAX_LEN_OUTPUTDATA];
    public static String strOutputData;
    public static String strInputData;
    public static int            inputLen;
    public static int            outputLen;
    public static boolean        levelBattery;
    public static boolean        statusPaper;

    // Variables CustomArrayAdapter
    public static CheckBox checkBox;
    public static int position;

    // Variables CustomToast
    public static LayoutInflater inflater;
    public static View layout;


    // Variable de estado de salida
    public static boolean        StatusExit               = true;
    public static boolean        validaAsesora;
    public static boolean        validarLoteriasActivas;
    public static boolean        validarInfo;

    // Variables de los Datos principales
    public static String INITIAL_IP;
    public static int       INITIAL_PORT;
    public static String INITIAL_IP_RECARGAS;
    public static int       INITIAL_PORT_RECARGAS;
    public static boolean   mostrarMensaje;

    // Variables de información de la App
    public static String serial;
    public static String IMEI;
    public static String IDSIMCARD;
    public static String operador;
    public static Socket tcpSocket = null;

    // Variables mainActivity
    public static String MsgError;
    public static String user;
    public static String pass;
    public static int indice;

    // Arrays
    public static String[] tokens = null;

    public static ArrayList<TableRow> filas;
    public static TableRow[] fila;
    public static EditText[] editTexts;
    public static TextView[] textViews;

}