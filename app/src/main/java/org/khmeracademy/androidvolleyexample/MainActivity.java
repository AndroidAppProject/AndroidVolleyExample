package org.khmeracademy.androidvolleyexample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.kosalgeek.android.json.JsonConverter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final String TAC ="MainActivity";

    ListView listProducts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listProducts= (ListView)findViewById(R.id.listProduct);

        String url ="http://192.168.43.39:8080/PHP/android/product.php";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("TAC",response);
                        ArrayList<Product> productsList = new JsonConverter<Product>().toArrayList(response,Product.class);
                        final ArrayList<String> textList = new ArrayList<>();
                        for (Product p:productsList){
                            textList.add(""+p.getId());
                            textList.add(""+p.getName());
                            textList.add(""+p.getQty());
                            textList.add(""+p.getPrice());
                            textList.add(""+p.getImage());
                        }
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                                getApplicationContext(),
                                android.R.layout.simple_list_item_1,
                                textList
                        ){
                            @Override
                            public View getView(int position, View convertView, ViewGroup parent) {
                                TextView textView = (TextView) super.getView(position, convertView, parent);
                                textView.setTextColor(Color.BLACK);
                                return textView;
                            }
                        };
                        listProducts.setAdapter(adapter);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("TAC", "ERORR");
                    }

        });
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }
}
