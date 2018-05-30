package com.dexlan.charactersheet.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dexlan.charactersheet.R;
import com.dexlan.charactersheet.logic.recyclers.RaceRecyclerViewAdapter;
import com.dexlan.charactersheet.models.Race;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CreationActivity extends AppCompatActivity {

    private List<Race> races;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation);

        setTitle(getString(R.string.character_creation));
        getSupportActionBar().setSubtitle(getString(R.string.select_race));

        loadData();

        RecyclerView race_recycler_rv = (RecyclerView) findViewById(R.id.race_recyclerview);
        RaceRecyclerViewAdapter rrva = new RaceRecyclerViewAdapter(this, races);
        race_recycler_rv.setLayoutManager(new GridLayoutManager(this, 1));
        race_recycler_rv.setAdapter(rrva);
    }



    private void loadData() {
        races = new ArrayList<>();

        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset("races.json"));
            JSONArray jsonArray = obj.getJSONArray("races");

            for (int i = 0; i <jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                races.add(new Race(jsonObject.getString("name"), jsonObject.getString("miniature"),
                        jsonObject.getString("ability"), jsonObject.getString("size"), jsonObject.getString("speed"),
                        jsonObject.getString("age"), jsonObject.getString("alignment"), jsonObject.getString("proficiency"),
                        jsonObject.getString("languages"), jsonObject.getString("description")));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String loadJSONFromAsset(String path) {
        String json = null;
        try {
            InputStream is = getAssets().open(path);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
