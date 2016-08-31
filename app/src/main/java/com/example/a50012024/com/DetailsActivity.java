package com.example.a50012024.com;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);


//        Toast.makeText(DetailsActivity.this,"Hello",Toast.LENGTH_LONG).show();

//        TextView textview = new TextView(this);
//        textview.setText("Hello Androi,msdnfkjasdnfnsakjdfkskjnsd,sbdsndns.lkdslfcdcnndnclamslkcdmalsmxkl;asmlxmaslkmxsamlxkaslkmxd");
//        textview.setTextSize(30);
//        textview.setTextColor(Color.CYAN);
//        textview.setMaxLines(2);
//       setContentView(textview);


//        String masterData = getIntent().getExtras().getString("MasterOrderDetails");
//        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
//        priceTextView.setText(masterData);
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                NavUtils.navigateUpFromSameTask(this);
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
}
