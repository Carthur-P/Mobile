package pongp1.bit;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    String imageFileName;
    File  imageFile;
    ImageView image1, image2, image3, image4;
    Intent cameraIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image1 = findViewById(R.id.imageView1);
        image2 = findViewById(R.id.imageView2);
        image3 = findViewById(R.id.imageView3);
        image4 = findViewById(R.id.imageView4);

        File imageDirectory = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "CameraImage");
        if(!imageDirectory.exists()){
            imageDirectory.mkdirs();//make the directory if it does not exist
        }

        //making image file name
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date currentTime = new Date();
        String timeStamp = formatter.format(currentTime);
        imageFileName = "IMG_" + timeStamp + ".jpg";

        //making the image file
        imageFile = new File(imageDirectory.getPath() + File.separator + imageFileName);
        Uri imageFileURI = Uri.fromFile( imageFile);

        //intent that will bring up the camera
        cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileURI);
        startActivityForResult(cameraIntent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        Log.i("Image File Path", Integer.toString(resultCode));
        if(requestCode == 1 && resultCode == RESULT_OK){
            Log.i("Image File Path", imageFile.getPath());
            Bitmap image = BitmapFactory.decodeFile(imageFile.getPath());
            Log.i("Image File Path", Integer.toString(resultCode));
            image1.setImageBitmap(Bitmap.createScaledBitmap(image,500,500, false));
            image2.setImageBitmap(Bitmap.createScaledBitmap(image,500,500, false));
            image3.setImageBitmap(Bitmap.createScaledBitmap(image,500,500, false));
            image4.setImageBitmap(Bitmap.createScaledBitmap(image,500,500, false));
        } else{
            Toast.makeText(MainActivity.this, "No Photo Found", Toast.LENGTH_LONG).show();
            startActivityForResult(cameraIntent, 1);
        }
    }
}
