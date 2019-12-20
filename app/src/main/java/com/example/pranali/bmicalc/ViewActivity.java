package com.example.pranali.bmicalc;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;

public class ViewActivity extends AppCompatActivity {
    ListView lvData;
   // ArrayList<record> r = new ArrayList<>();
    FirebaseDatabase database;
    DatabaseReference myref;
    String temp;
    ArrayList<String> k= new ArrayList<>();
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
    lvData=findViewById(R.id.lvData);
    database= FirebaseDatabase.getInstance();
    myref= database.getReference("record");

   myref.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            k.clear();
            for(DataSnapshot d:dataSnapshot.getChildren())
            { /*record data =d.getValue(record.class);
                r.add(data);
                Log.i("mera","Value is "+data);
                k.add(d.getKey());
                */
               /* String bmiresult= d.getValue().toString();
                int size=bmiresult.length();

                Calendar c=Calendar.getInstance();
                int day=c.get(Calendar.DAY_OF_MONTH);
                int month=c.get(Calendar.MONTH);
                int year=c.get(Calendar.YEAR);
                String date=String.valueOf(day)+"|"+String.valueOf(month+1)+"|"+String.valueOf(year);
*/
                String bmiresult = d.getValue().toString();
             //  float di = Float.valueOf(bmiresult);
               //Log.i("ye ata",String.valueOf(di));
               int size = bmiresult.length();
               temp=bmiresult.substring(6,size-1);
  //             String finall= temp + date;
               k.add(temp);
            }
            //ArrayAdapter ad = new ArrayAdapter<>(ViewActivity.this,android.R.layout.simple_list_item_1,k);
            adapter=new ArrayAdapter(ViewActivity.this,android.R.layout.simple_list_item_1,k);
            lvData.setAdapter(adapter);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });






    }
}
