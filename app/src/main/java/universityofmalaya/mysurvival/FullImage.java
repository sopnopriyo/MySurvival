package universityofmalaya.mysurvival;

import android.content.res.TypedArray;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class FullImage extends Activity {

    TypedArray basic_Info_picture;
    WebView wb;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);

         Intent i = getIntent();
        int position = i.getExtras().getInt("id");
        //Toast.makeText(FullImage.this, "You Clicked at " + position, Toast.LENGTH_SHORT).show();
        ImageView imageView = (ImageView) findViewById(R.id.singleView);
        basic_Info_picture = getResources().obtainTypedArray(R.array.basic_info_pic);

        imageView.setImageResource(basic_Info_picture.getResourceId(position,-1));






    }

}