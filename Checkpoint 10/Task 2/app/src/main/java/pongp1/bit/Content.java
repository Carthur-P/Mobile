package pongp1.bit;

import android.content.res.Resources;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Content extends Fragment {

    public View contentFragment;
    public TextView titleTV;
    public ImageView imageIV;
    public TextView contentTextTV;

    public Content() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        contentFragment = inflater.inflate(R.layout.fragment_content, container, false);
        titleTV = contentFragment.findViewById(R.id.textView1);
        imageIV = contentFragment.findViewById(R.id.imageView1);
        contentTextTV = contentFragment.findViewById(R.id.textView2);

        Resources resourceResolver = getResources();
        titleTV.setText(getArguments().getString("Title"));
        imageIV.setImageDrawable(resourceResolver.getDrawable(getArguments().getInt("Image")));
        contentTextTV.setText(getArguments().getString("contentText"));

        // Inflate the layout for this fragment
        return contentFragment;
    }

    public void getContent(String title, int image, String contentText) {
        Resources resourceResolver = getResources();
        titleTV.setText(title);
        imageIV.setImageDrawable(resourceResolver.getDrawable(image));
        contentTextTV.setText(contentText);
    }
}
