package com.xample.androidautopart.ui.supplier;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.xample.androidautopart.R;

import org.json.JSONArray;
import org.json.JSONObject;

public class SupplierFragment extends Fragment {

    private SupplierViewModel supplierViewModel;
    public static RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    public static FragmentActivity activity;
    public View root;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        supplierViewModel = ViewModelProviders.of(this).get(SupplierViewModel.class);
        root = inflater.inflate(R.layout.fragment_suppliers, container, false);

        activity = getActivity();
        doRequest();

        recyclerView = root.findViewById(R.id.supplier_recyclerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(supplierViewModel.adapter);

        return root;
    }

    protected void doRequest() {
        RequestQueue queue = Volley.newRequestQueue(this.getContext());

        String url = "https://f6eb04bb.ngrok.io/suppliers";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        supplierViewModel.GetList(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //If the connection fail use the test DB
                        supplierViewModel.GetList(testDB());
                        error.printStackTrace();
                        Context context = root.getContext();
                        CharSequence text = error.toString();
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                });
        queue.add(jsonArrayRequest);
    }

    public JSONArray testDB(){
        String json = null;
        JSONArray jsonArray;

        try {
            json = "{\n" +
                    "  \"products\": [\n" +
                    "    {\n" +
                    "      \"id\": 1,\n" +
                    "      \"title\": \"Jante de pneus Mirolex\",\n" +
                    "      \"modelNo\": \"MIR-72300\",\n" +
                    "      \"code\": \"P0140\",\n" +
                    "      \"unitPrice\": \"269.99\",\n" +
                    "      \"inventory\": \"23\",\n" +
                    "      \"supplierId\": \"1\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"id\": 2,\n" +
                    "      \"title\": \"Vitre Telemax Qualité Supérieure\",\n" +
                    "      \"modelNo\": \"TM-7738\",\n" +
                    "      \"code\": \"V0234\",\n" +
                    "      \"unitPrice\": \"123.89\",\n" +
                    "      \"inventory\": \"2\",\n" +
                    "      \"supplierId\": \"1\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"id\": 3,\n" +
                    "      \"title\": \"Miroir Ajustable 4500\",\n" +
                    "      \"modelNo\": \"JKL-4500\",\n" +
                    "      \"code\": \"M0450\",\n" +
                    "      \"unitPrice\": \"89.45\",\n" +
                    "      \"inventory\": \"10\",\n" +
                    "      \"supplierId\": \"1\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"id\": 4,\n" +
                    "      \"title\": \"Sièges Confort Pacov\",\n" +
                    "      \"modelNo\": \"PAC-1000\",\n" +
                    "      \"code\": \"S0561\",\n" +
                    "      \"unitPrice\": \"412.53\",\n" +
                    "      \"inventory\": \"5\",\n" +
                    "      \"supplierId\": \"1\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"id\": 5,\n" +
                    "      \"title\": \"Essieu Tout Usage\",\n" +
                    "      \"modelNo\": \"XYZ-77233\",\n" +
                    "      \"code\": \"X0113\",\n" +
                    "      \"unitPrice\": \"600.00\",\n" +
                    "      \"inventory\": \"0\",\n" +
                    "      \"supplierId\": \"1\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"id\": 6,\n" +
                    "      \"title\": \"Carburateur Automoto\",\n" +
                    "      \"modelNo\": \"AUTO-A1\",\n" +
                    "      \"code\": \"X0129A\",\n" +
                    "      \"unitPrice\": \"229.99\",\n" +
                    "      \"inventory\": \"12\",\n" +
                    "      \"supplierId\": \"2\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"id\": 7,\n" +
                    "      \"title\": \"Pneus Econoto\",\n" +
                    "      \"modelNo\": \"ECO-5511\",\n" +
                    "      \"code\": \"P0230\",\n" +
                    "      \"unitPrice\": \"450.00\",\n" +
                    "      \"inventory\": \"16\",\n" +
                    "      \"supplierId\": \"2\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"id\": 8,\n" +
                    "      \"title\": \"Essuie-glace The Snowbuster 2000\",\n" +
                    "      \"modelNo\": \"SB-2000\",\n" +
                    "      \"code\": \"V0965\",\n" +
                    "      \"unitPrice\": \"54.99\",\n" +
                    "      \"inventory\": \"130\",\n" +
                    "      \"supplierId\": \"2\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"id\": 9,\n" +
                    "      \"title\": \"Huile à moteur Skylex\",\n" +
                    "      \"modelNo\": \"SKYLEX-A\",\n" +
                    "      \"code\": \"X0189\",\n" +
                    "      \"unitPrice\": \"70.00\",\n" +
                    "      \"inventory\": \"10\",\n" +
                    "      \"supplierId\": \"2\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"title\": \"Turbo reacteur de la fusee Ariane IV\",\n" +
                    "      \"modelNo\": \"12341234\",\n" +
                    "      \"code\": \"1234\",\n" +
                    "      \"unitPrice\": \"100000000.99\",\n" +
                    "      \"inventory\": \"3\",\n" +
                    "      \"id\": 14\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"suppliers\": [\n" +
                    "    {\n" +
                    "      \"id\": 1,\n" +
                    "      \"name\": \"Automotives Parts Inc\",\n" +
                    "      \"address_line_1\": \"3400, chemin de la Côte-Vertue\",\n" +
                    "      \"address_line_2\": \"Suite 2400\",\n" +
                    "      \"address_city\": \"Montréal\",\n" +
                    "      \"address_province\": \"QC\",\n" +
                    "      \"address_postal_code\": \"H1U 3N9\",\n" +
                    "      \"telephone\": \"(514) 243-8753\",\n" +
                    "      \"contact\": \"Henri-Paul Levasseur\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"id\": 2,\n" +
                    "      \"name\": \"Les pièces d'auto du Chez-Nous\",\n" +
                    "      \"address_line_1\": \"1500 Boul. Saint-Martin\",\n" +
                    "      \"address_line_2\": \"\",\n" +
                    "      \"address_city\": \"Laval\",\n" +
                    "      \"address_province\": \"QC\",\n" +
                    "      \"address_postal_code\": \"G1M 8V1\",\n" +
                    "      \"telephone\": \"(450) 651-2381\",\n" +
                    "      \"contact\": \"Maude Lessard\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"name\": \"qwer\",\n" +
                    "      \"contact\": \"qewr\",\n" +
                    "      \"telephone\": \"qwer\",\n" +
                    "      \"id\": 3\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"name\": \"asdf\",\n" +
                    "      \"contact\": \"asdf\",\n" +
                    "      \"telephone\": \"asdf\",\n" +
                    "      \"id\": 5\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"name\": \"fournisseur1123\",\n" +
                    "      \"contact\": \"yeah123\",\n" +
                    "      \"telephone\": \"letsgo123\",\n" +
                    "      \"id\": 6\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}";

            JSONObject jsonbject = new JSONObject(json);

            jsonArray = jsonbject.getJSONArray("suppliers");

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return jsonArray;
    }
}