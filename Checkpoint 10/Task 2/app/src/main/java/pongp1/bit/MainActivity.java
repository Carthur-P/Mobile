package pongp1.bit;

import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    protected Navigation navFragment = new Navigation();
    protected Content contentFragment = new Content();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //displaying fragment
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.navFragment, navFragment);
        ft.replace(R.id.contentFragment, contentFragment);
        ft.commit();
        Bundle bundle = new Bundle();
        bundle.putString("Title", "Services");
        bundle.putInt("Image", R.drawable.services);
        bundle.putString("contentText", "Nulla gravida est non placerat consectetur. Aliquam maximus nibh dapibus est scelerisque suscipit. Donec finibus libero sed urna pellentesque finibus. In auctor luctus iaculis. Aenean id lectus posuere, viverra lorem nec, placerat augue.");
        contentFragment.setArguments(bundle);
    }

    public void getData(String contentName) {
        switch (contentName) {
            case "Services":
                contentFragment.getContent(
                        contentName,
                        R.drawable.services,
                        "Nulla gravida est non placerat consectetur. Aliquam maximus nibh dapibus est scelerisque suscipit. Donec finibus libero sed urna pellentesque finibus. In auctor luctus iaculis. Aenean id lectus posuere, viverra lorem nec, placerat augue.");
                break;

            case "Fun Things To Do":
                contentFragment.getContent(
                        contentName,
                        R.drawable.activities,
                        "Nulla gravida est non placerat consectetur. Aliquam maximus nibh dapibus est scelerisque suscipit. Donec finibus libero sed urna pellentesque finibus. In auctor luctus iaculis. Aenean id lectus posuere, viverra lorem nec, placerat augue.");
                break;

            case "Dinning":
                contentFragment.getContent(
                        contentName,
                        R.drawable.dinning,
                        "Nulla gravida est non placerat consectetur. Aliquam maximus nibh dapibus est scelerisque suscipit. Donec finibus libero sed urna pellentesque finibus. In auctor luctus iaculis. Aenean id lectus posuere, viverra lorem nec, placerat augue.");
                break;

            case "Shopping":
                contentFragment.getContent(
                        contentName,
                        R.drawable.shopping,
                        "Nulla gravida est non placerat consectetur. Aliquam maximus nibh dapibus est scelerisque suscipit. Donec finibus libero sed urna pellentesque finibus. In auctor luctus iaculis. Aenean id lectus posuere, viverra lorem nec, placerat augue.");
                break;
        }
    }
}
