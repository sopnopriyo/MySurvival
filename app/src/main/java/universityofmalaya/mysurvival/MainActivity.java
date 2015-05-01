package universityofmalaya.mysurvival;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnItemClickListener,LocationProvider.LocationCallback {

    private LocationProvider mLocationProvider;
    String[] title;
    TypedArray profile_pics;
    String[] description;
    double currentLatitude =0,currentLongitude=0;

    List<RowItem> rowItems;
    ListView mylistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rowItems = new ArrayList<RowItem>();

        title = getResources().getStringArray(R.array.title);

        profile_pics = getResources().obtainTypedArray(R.array.profile_pics);

        description = getResources().getStringArray(R.array.description);

        //   contactType = getResources().getStringArray(R.array.contactType);

        for (int i = 0; i < title.length; i++) {
            RowItem item = new RowItem(title[i],
                    profile_pics.getResourceId(i, -1), description[i]);
            rowItems.add(item);
        }

        mylistview = (ListView) findViewById(R.id.list);
        CustomAdapter adapter = new CustomAdapter(this, rowItems);
        mylistview.setAdapter(adapter);
        profile_pics.recycle();
        mylistview.setOnItemClickListener(this);

        mLocationProvider = new LocationProvider(this, this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {

        //String member_name = rowItems.get(position).getTitle();

        switch (position) {
            case 0:
                Intent intent0 = new Intent(this, BasicInfo.class);
                startActivity(intent0);
                break;
            case 1:
                Intent intent1 = new Intent(this,FirstAid.class);
                startActivity(intent1);
                break;


            case 2:
                Intent intent2 = new Intent(this, HospitalInfo.class);
                 intent2.putExtra("currentLongitude", currentLongitude);
                startActivity(intent2);
                break;
            case 3:
                Intent intent3 = new Intent(this, DangerInfo.class);
                startActivity(intent3);
                break;
            case 4:
                Intent intent4 = new Intent(this, EmergencyContact.class);
                startActivity(intent4);
                break;
            default:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;



        }
    }
    public void handleNewLocation(Location location) {

         currentLatitude = location.getLatitude();
         currentLongitude = location.getLongitude();



    }
    @Override
    protected void onResume() {
        super.onResume();

        mLocationProvider.connect();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mLocationProvider.disconnect();
    }

}