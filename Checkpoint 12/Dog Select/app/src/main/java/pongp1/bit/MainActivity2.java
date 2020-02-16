package pongp1.bit;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity2 extends AppCompatActivity {

    Resources resourceResolver;
    Dog[] dogArray = new Dog[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        resourceResolver = getResources();
        initialiseData();
        ListView dogBreed = findViewById(R.id.listView1);
        CustomArrayAdapter adapter = new CustomArrayAdapter(this, R.layout.listview_layout, dogArray);
        dogBreed.setAdapter(adapter);
        dogBreed.setOnItemClickListener(new OnItemClickHandler());
    }

    public void initialiseData() {
        dogArray[0] = new Dog("Bull", resourceResolver.getDrawable(R.drawable.bull));
        dogArray[1] = new Dog("Cairn", resourceResolver.getDrawable(R.drawable.cairn));
        dogArray[2] = new Dog("Irish", resourceResolver.getDrawable(R.drawable.irish));
        dogArray[3] = new Dog("Lakeland", resourceResolver.getDrawable(R.drawable.lakeland));
        dogArray[4] = new Dog("Norfolk", resourceResolver.getDrawable(R.drawable.norfolk));
    }

    public class OnItemClickHandler implements AdapterView.OnItemClickListener {
        FragmentManager fm = getSupportFragmentManager();
        Bundle bundle = new Bundle();
        ImageFragment imageFragment = new ImageFragment();

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            switch (position) {
                case 0:
                    bundle.putInt("dogImage", R.drawable.bull);
                    imageFragment.setArguments(bundle);
                    imageFragment.show(fm, "Image");
                    break;

                case 1:
                    bundle.putInt("dogImage", R.drawable.cairn);
                    imageFragment.setArguments(bundle);
                    imageFragment.show(fm, "Image");
                    break;

                case 2:
                    bundle.putInt("dogImage", R.drawable.irish);
                    imageFragment.setArguments(bundle);
                    imageFragment.show(fm, "Image");
                    break;

                case 3:
                    bundle.putInt("dogImage", R.drawable.lakeland);
                    imageFragment.setArguments(bundle);
                    imageFragment.show(fm, "Image");
                    break;

                case 4:
                    bundle.putInt("dogImage", R.drawable.norfolk);
                    imageFragment.setArguments(bundle);
                    imageFragment.show(fm, "Image");
                    break;
            }
        }
    }
}
