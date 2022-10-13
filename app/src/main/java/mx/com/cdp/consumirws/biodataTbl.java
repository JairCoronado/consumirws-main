package mx.com.cdp.consumirws;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class biodataTbl extends SQLiteOpenHelper {

    Context context;
    Cursor cursor;
    SQLiteDatabase database;

    public static String nama_database="data";
    public  static  String nama_table ="biodata";


    public biodataTbl(@Nullable Context context) {
        super(context, nama_database, null, 3);
        this.context=context;
        database=getReadableDatabase();
        database=getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE IF NOT EXISTS " +nama_table+" (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "CPY_CODE varchar(50), " +
                "NODE_TYPE varchar(50), " +
                "NODE_CODE varchar(50), " +
                "VAE_ID varchar(50), " +
                "SAM_ID varchar(50), " +
                "SAM_TYPE varchar(50), " +
                "SAM_UID varchar(50), " +
                "LINE varchar(50), " +
                "STATION varchar(50), " +
                "TRAY varchar(50), " +
                "ECO varchar(50))";
        db.execSQL(query);

    }



    void guardar_data(String ID,String CPY_CODE, String NODE_TYPE, String NODE_CODE, String VAE_ID, String SAM_ID, String SAM_TYPE, String SAM_UID, String LINE, String STATION, String TRAY, String ECO){
        database.execSQL("INSERT INTO " + nama_table+" values" + "('"+ID+"','"+CPY_CODE+"','"+NODE_TYPE+"','"+NODE_CODE+"','"+VAE_ID+"','"+SAM_ID+"','"+SAM_TYPE+"','"+SAM_UID+"','"+LINE+"','"+STATION+"','"+TRAY+"','"+ECO+"')"
        );

        Toast.makeText(context, "\n" +"Datos guardados exitosamente", Toast.LENGTH_SHORT).show();
    }

    void update_data(String id, String nama, String alamat){
        database.execSQL("UPDATE "+nama_table+" SET nama='"+nama+"', alamat='"+alamat+"'" + "WHERE id='"+id+"'" + "");
        Toast.makeText(context, "\n" + "Actualizar correctamente los datos", Toast.LENGTH_SHORT).show();
    }

    void delete(String id){
        database.execSQL("DELETE FROM "+nama_table+" WHERE id='"+id+"'");
        Toast.makeText(context, "Datos eliminados con éxito", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}