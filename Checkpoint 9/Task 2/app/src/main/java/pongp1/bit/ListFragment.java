package pongp1.bit;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {


    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_list, container, false);

        //setting up list view
        ListView list = (ListView) fragmentView.findViewById(R.id.listView1);
        String[] animals = {"Cat", "Dog", "Elephant", "Tiger", "Lion", "Zebra", "Bear"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.list_view_layout, R.id.listViewText, animals);
        list.setAdapter(adapter);

        // Inflate the layout for this fragment
        return fragmentView;
    }

}
