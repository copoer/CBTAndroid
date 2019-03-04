package com.theworld.help.cbtandroid;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class EntryActivity extends AppCompatActivity {
    private Button save;
    private TextInputEditText
            title,
            situation,
            feeling,
            thought,
            support,
            against,
            alt,
            outcome;
    private int entry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);

        //Set vars
        title = findViewById(R.id.title);
        situation = findViewById(R.id.situation);
        feeling = findViewById(R.id.feeling);
        thought = findViewById(R.id.thought);
        support = findViewById(R.id.support);
        against = findViewById(R.id.against);
        alt = findViewById(R.id.alt);
        outcome = findViewById(R.id.outcome);

        Intent intent = getIntent();
        entry = intent.getIntExtra(CustomAdapter.ENTRY, -1);
        if (entry >= 0) {
            loadEntry(entry);
        }


        //Save entry on click
        save = (Button) findViewById(R.id.savebutton);
        save.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 saveEntry();
             }
        });

    }

    private void loadEntry(int pos) {
        //Set all text fields
        Files file = new Files(this);
        ArrayList<Entry> collection = file.read();
        Entry entry = collection.get(pos);
        title.setText(entry.getTitle());
        situation.setText(entry.getSituation());
        feeling.setText(entry.getFeelings());
        thought.setText(entry.getThoughts());
        support.setText(entry.getSupport());
        against.setText(entry.getAgainst());
        alt.setText(entry.getAlt());
        outcome.setText(entry.getOutcome());
    }

    private void saveEntry() {
        Files file = new Files(this);
        ArrayList<Entry> collection = file.read();
        Entry fresh = new Entry(title.getText().toString(), situation.getText().toString(), feeling.getText().toString(), thought.getText().toString(), support.getText().toString(), against.getText().toString(), alt.getText().toString(), outcome.getText().toString());
        if (entry >= 0) {
            collection.set(entry, fresh);
        } else {
            collection.add(fresh);
        }
        file.write(collection);
        setResult(RESULT_OK, null);
        finish();
    }
}
