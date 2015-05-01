package universityofmalaya.mysurvival;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class BasicInfo extends ActionBarActivity {
    GridView gridView;
    ArrayList<Item> gridArray = new ArrayList<Item>();
    ImageAdapter customGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_info);

        //set grid view item
        Bitmap roadIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.basic_logo_road);
        Bitmap fireIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.basic_logo_fire);
        Bitmap industryIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.basic_logo_industry);
        Bitmap domesticIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.basic_logo_domestic);
        Bitmap publicPlacesIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.basic_logo_public_places);
        Bitmap disastarIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.basic_logo_disaster);
        Bitmap sportsIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.basic_logo_sports);
        Bitmap schoolIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.basic_logo_school);


        gridArray.add(new Item(roadIcon,"Road Safety"));
        gridArray.add(new Item(fireIcon,"Fire Safety"));
        gridArray.add(new Item(industryIcon,"Industry Safety"));
        gridArray.add(new Item(domesticIcon,"Domestic Safety"));
        gridArray.add(new Item(publicPlacesIcon,"Outdoor Safety"));
        gridArray.add(new Item(disastarIcon,"Disaster Safety"));
        gridArray.add(new Item(sportsIcon,"Sports Safety"));
        gridArray.add(new Item(schoolIcon,"Kids Safety"));



        gridView = (GridView) findViewById(R.id.gridView1);
        customGridAdapter = new ImageAdapter(this, R.layout.row_grid, gridArray);
        gridView.setAdapter(customGridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


                Intent i =new Intent(getApplicationContext(), FullImage.class);
                // Pass image index
                i.putExtra("id", position);
                startActivity(i);

            }
        });



    }


}
