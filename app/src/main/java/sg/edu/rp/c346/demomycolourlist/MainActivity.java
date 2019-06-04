package sg.edu.rp.c346.demomycolourlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etColour,etIndex;
    Button btnAddItem,btnRemoveItem,btnUpdateItem;
    ListView lvColour;

    ArrayList<String>alColours = new ArrayList<>();
    ArrayAdapter<String> aaColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etColour = findViewById(R.id.editTextColour);
        etIndex = findViewById(R.id.editTextIndex);
        btnAddItem = findViewById(R.id.buttonAddItem);
        btnRemoveItem = findViewById(R.id.buttonRemoveItem);
        btnUpdateItem = findViewById(R.id.buttonUpdateItem);
        lvColour = findViewById(R.id.listViewColour);

        //add colours to arraylist
        alColours.add("Red");
        alColours.add("Orange");
        alColours.add("Green");
        Log.d("add", String.valueOf(alColours));

        //add
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the colour user entered in the edit text
                String colour = etColour.getText().toString();
                //get the position user entered in the edit text
                int pos = Integer.parseInt(etIndex.getText().toString());
                //add to arraylist
                alColours.add(pos,colour);
                //notify the adapter
                aaColour.notifyDataSetChanged();
                //display
                Toast.makeText(MainActivity.this,colour,Toast.LENGTH_LONG).show();
            }
        });

        //display the colour value
        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //store value in colour
                String colour = alColours.get(position);
                Toast.makeText(MainActivity.this,"Colour: "+colour,Toast.LENGTH_LONG).show();
            }
        });

        //remove
        btnRemoveItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the colour user entered in the edit text
                String colour = etColour.getText().toString();
                //get the position user entered in the edit text
                int pos = Integer.parseInt(etIndex.getText().toString());
                //remove
                alColours.remove(colour);
                //notify the adapter
                aaColour.notifyDataSetChanged();
                //display
                Toast.makeText(MainActivity.this,"Removed",Toast.LENGTH_LONG).show();
            }
        });

        //update
        btnUpdateItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the colour user entered in the edit text
                String colour = etColour.getText().toString();
                //get the position user entered in the edit text
                int pos = Integer.parseInt(etIndex.getText().toString());
                //update
                alColours.set(pos,colour);
                //notify the adapter
                aaColour.notifyDataSetChanged();
                //display
                Toast.makeText(MainActivity.this,"Updated",Toast.LENGTH_LONG).show();
            }
        });


        //create an arrayAdapter - aaColour
        //set the adapter for listview - lvColour
        //alColour - arraylist
        aaColour = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alColours);
        lvColour.setAdapter(aaColour);
    }
}
