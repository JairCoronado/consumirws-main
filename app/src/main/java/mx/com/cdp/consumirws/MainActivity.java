package mx.com.cdp.consumirws;

import static android.content.ContentValues.TAG;
import static android.os.Build.ID;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText txtUser;
    Button btnDescargar;
    biodataTbl biodataTbl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUser = findViewById(R.id.txtUser);
        btnDescargar = findViewById(R.id.btnDescargar);

        btnDescargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                biodataTbl=new biodataTbl(getApplicationContext());
                LeerWs();
                //startActivity(new Intent(getApplicationContext(), Agregar_data.class));
                //enviarWs(txtTitle.getText().toString(), txtBody.getText().toString(), txtUser.getText().toString());
               // actualizarWs(txtTitle.getText().toString(), txtBody.getText().toString(), txtUser.getText().toString());
               // eliminarWs();
               // finish();
            }
        });

    }


    private void LeerWs() {

        String url = "https://dtstcm.net/API_REST/init_values?ID=2";

        StringRequest postResquest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONObject jsonObject = new JSONObject(response);

                    JSONArray namekey=jsonObject.names();
                    JSONArray obj=jsonObject.toJSONArray(namekey);
                    String ID=jsonObject.getString("ID");
                    String CPY_CODE=jsonObject.getString("CPY_CODE");
                    String NODE_TYPE=jsonObject.getString("NODE_TYPE");
                    String NODE_CODE=jsonObject.getString("NODE_CODE");
                    String VAE_ID=jsonObject.getString("VAE_ID");
                    String SAM_ID=jsonObject.getString("SAM_ID");
                    String SAM_TYPE=jsonObject.getString("SAM_TYPE");
                    String SAM_UID=jsonObject.getString("SAM_UID");
                    String LINE=jsonObject.getString("LINE");
                    String STATION=jsonObject.getString("STATION");
                    String TRAY=jsonObject.getString("TRAY");
                    String ECO=jsonObject.getString("ECO");
                    InitValues ValoresIniciales= new InitValues(ID,CPY_CODE,NODE_TYPE,NODE_CODE,VAE_ID,SAM_ID,SAM_TYPE,SAM_UID,LINE,STATION,TRAY,ECO);//baja los balores a la ram
                    Log.i(TAG, "onResponse: "+ obj);
                   // biodataTbl.update_data(ID,CPY_CODE,NODE_TYPE,NODE_CODE,VAE_ID,SAM_ID,SAM_TYPE,SAM_UID,LINE,STATION,TRAY,ECO);
                    biodataTbl.guardar_data(ID,CPY_CODE,NODE_TYPE,NODE_CODE,VAE_ID,SAM_ID,SAM_TYPE,SAM_UID,LINE,STATION,TRAY,ECO);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Error",error.toString());
            }
        });
        Volley.newRequestQueue(this).add(postResquest);
    }

    private void enviarWs(final String title, final String body, final String userId) {

        String url = "https://jsonplaceholder.typicode.com/posts";

        StringRequest postResquest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(MainActivity.this, "RESULTADO POST = " + response, Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", error.getMessage());
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("title", title);
                params.put("body", body);
                params.put("userId", userId);

                return params;
            }
        };
        Volley.newRequestQueue(this).add(postResquest);
    }
//actualizar la api
    private void actualizarWs(final String title, final String body, final String userId) {

        String url = "https://jsonplaceholder.typicode.com/posts/1";

        StringRequest postResquest = new StringRequest(Request.Method.PUT, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(MainActivity.this, "RESULTADO = " + response, Toast.LENGTH_LONG).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", error.getMessage());
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("id", "1");
                params.put("title", title);
                params.put("body", body);
                params.put("userId", userId);

                return params;
            }
        };
        Volley.newRequestQueue(this).add(postResquest);
    }

    private void eliminarWs() {

        String url = "https://jsonplaceholder.typicode.com/posts/1";

        StringRequest postResquest = new StringRequest(Request.Method.DELETE, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(MainActivity.this, "RESULTADO = " + response, Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", error.getMessage());
            }
        });
        Volley.newRequestQueue(this).add(postResquest);
    }
}