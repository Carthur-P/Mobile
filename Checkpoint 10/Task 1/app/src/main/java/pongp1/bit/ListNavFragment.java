package pongp1.bit;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListNavFragment extends DialogFragment {


    public ListNavFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View navFragment =  inflater.inflate(R.layout.list_nav_fragment, container, false);

        //setting up list view
        String[] animals = {"Panda", "Cat", "Dog", "Bear"};
        ListView navigation = navFragment.findViewById(R.id.listView1);
        ArrayAdapter<String> stringAdapter = new ArrayAdapter<String>(getActivity(), R.layout.listview_layout, R.id.listTextView, animals);
        navigation.setAdapter(stringAdapter);
        navigation.setOnItemClickListener(new OnItemClickHander());

        // Inflate the layout for this fragment
        return navFragment;
    }


    public class OnItemClickHander implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            MainActivity activity = (MainActivity) getActivity();
            String clickedItem = parent.getItemAtPosition(position).toString();

            switch(clickedItem){
                case "Panda":
                    activity.getImage(R.drawable.panda);
                    break;

                case "Cat":
                    activity.getImage(R.drawable.cat);
                    break;

                case "Dog":
                    activity.getImage(R.drawable.dog);
                    break;

                case "Bear":
                    activity.getImage(R.drawable.bear);
                    break;
            }
        }
    }
}
