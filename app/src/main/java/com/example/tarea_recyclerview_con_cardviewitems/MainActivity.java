package com.example.tarea_recyclerview_con_cardviewitems;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText codigo;
    Button buscar;
    private String Ruta = " https://revistas.uteq.edu.ec/ws/issues.php";
    RequestQueue requestQueue;
    private List<ListElement> lista;

    RecyclerView recyclerlist;
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        codigo= findViewById(R.id.txtCodigo);
        buscar=findViewById(R.id.btnBuscar);
        requestQueue = Volley.newRequestQueue(this);
        jsonArrayRequest("2",Ruta);
    }
    public void setBtnBuscar (View view){
        jsonArrayRequest(codigo.getText().toString(),Ruta);
    }
    private void inicializarelementos() {
        recyclerlist = findViewById(R.id.recycler);
        recyclerlist.setLayoutManager(new LinearLayoutManager(this));
        listAdapter = new ListAdapter(lista, this);
        recyclerlist.setAdapter(listAdapter);
    }
    private void jsonArrayRequest(String j_id, String Ruta) {
        Ruta += "?j_id=" + j_id;
        JsonArrayRequest json = new JsonArrayRequest(Request.Method.GET,
                Ruta, null,
                new com.android.volley.Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        lista = new ArrayList<>();
                        int size = response.length();
                        for (int i = 0; i < size; i++) {
                            try {
                                JSONObject objeto = new JSONObject(response.get(i).toString());
                                String issue_id = objeto.getString("issue_id");
                                String volume = objeto.getString("volume");
                                String number = objeto.getString("number");
                                String year = objeto.getString("year");
                                String date_published = objeto.getString("date_published");
                                String title = objeto.getString("title");
                                String doi = objeto.getString("doi");
                                String cover = objeto.getString("cover");
                                ListElement elemento = new ListElement(issue_id, volume, number, year, date_published, title, doi, cover);
                                lista.add(elemento);
                            } catch (JSONException e) {
                                e.printStackTrace();
                                System.out.println(e.getMessage());
                            }
                        }
                        inicializarelementos();
                    }
                }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue.add(json);
    }
}