package com.exam.namelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.exam.namelist.model.PersonDetails;
import com.exam.namelist.view.RecyclerViewAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<PersonDetails> personDetails = new ArrayList<>();;

    ArrayList<String> personName = new ArrayList<>();

    List<String> person_list = new ArrayList<>();

    public RecyclerView mRecyclerView;
    public RecyclerViewAdapter recyclerViewAdapter;
    public ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.personList);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReferenceFromUrl("https://mydatabase-e8236.firebaseio.com/");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapShot : dataSnapshot.getChildren()) {
                    PersonDetails personDetail = postSnapShot.getValue(PersonDetails.class);
                    personDetails.add(personDetail);
                }
                for (int i = 0; i < personDetails.size(); i++) {
                    personName.add(personDetails.get(i).getFname());
                }

                person_list = new ArrayList<String>(personName);

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                        (MainActivity.this, android.R.layout.simple_list_item_1, person_list);

                listView.setAdapter(arrayAdapter);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setContentView(R.layout.recycler_view);
                mRecyclerView = (RecyclerView)findViewById(R.id.recyclerview);
                PersonDetails pDetails = personDetails.get(position);
                personDetails = new ArrayList<>();

                personDetails.add(new PersonDetails(pDetails.getFname(), pDetails.getLname(), pDetails.getBday(), pDetails.getAge(), pDetails.getEmail(), pDetails.getMobileNum(), pDetails.getAddress(), pDetails.getCntctPrsn(), pDetails.getCntctPrsnNum()));

                recyclerViewAdapter = new RecyclerViewAdapter(personDetails);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                mRecyclerView.setLayoutManager(linearLayoutManager);
                mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                mRecyclerView.setAdapter(recyclerViewAdapter);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            onBackPressed();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(MainActivity.this, MainActivity.class));
        finish();
        super.onBackPressed();
    }
}