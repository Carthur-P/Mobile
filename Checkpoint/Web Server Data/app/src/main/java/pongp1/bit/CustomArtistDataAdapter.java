package pongp1.bit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import pongp1.bit.ArtistData;
import pongp1.bit.R;

public class CustomArtistDataAdapter extends ArrayAdapter<ArtistData> {

    CustomArtistDataAdapter(Context context, int resources, ArrayList<ArtistData> object){
        super(context, resources, object);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup container) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.listview_layout, container, false);
        ArtistData currentItem = getItem(position);
        TextView name = customView.findViewById(R.id.tv1);
        TextView listener = customView.findViewById(R.id.tv2);
        name.setText(currentItem.getName());
        listener.setText(Integer.toString(currentItem.getListener()));
        return customView;
    }
}
