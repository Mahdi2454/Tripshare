package com.share.trip.tripshare;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URI;

public class main extends AppCompatActivity {
private static final int RE_LO_IM =1;
    ImageView im;
    TextView t4,t5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent=getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
 public void upload_image(View view){
        im=findViewById(R.id.im1);
        Intent opGal =new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(opGal,RE_LO_IM);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==RE_LO_IM && resultCode==RESULT_OK && data!=null) {
            Uri user_img = data.getData();
            im.setImageURI(user_img);
        }

    }


    public void check_pass(View view)
    {
        t4 =findViewById(R.id.t4);
        t5 =findViewById(R.id.t5);
        if (!t4.getText().toString().equals(t5.getText().toString())) {
           t4.setText("");
           t5.setText("");

          startActivity(new Intent(main.this,Error_pass.class));

        }

    }


}
