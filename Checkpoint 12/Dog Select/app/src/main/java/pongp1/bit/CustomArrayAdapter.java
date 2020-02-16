package pongp1.bit;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomArrayAdapter extends ArrayAdapter<Dog> {

    CustomArrayAdapter(Context context, int resources, Dog[] object){
        super(context, resources, object);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup container) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.listview_layout, container, false);
        Dog currentItem = getItem(position);
        ImageView image = customView.findViewById(R.id.imageView1);
        TextView text = customView.findViewById(R.id.textView1);
        image.setImageDrawable(currentItem.getImage());
        text.setText(currentItem.getName());
        return customView;
    }
}
