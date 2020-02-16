package pongp1.bit;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImageFragment extends DialogFragment {


    public ImageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View dialogFragment = inflater.inflate(R.layout.fragment_image, container, false);
        Resources resourceResolver = getResources();
        ImageView dogImage = dialogFragment.findViewById(R.id.imageView1);
        dogImage.setImageDrawable(resourceResolver.getDrawable(getArguments().getInt("dogImage")));
        return dialogFragment;
    }

}
