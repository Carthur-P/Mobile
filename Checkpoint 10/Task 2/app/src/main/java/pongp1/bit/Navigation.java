package pongp1.bit;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Navigation extends Fragment {


    public Navigation() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View navFragment = inflater.inflate(R.layout.fragment_navigation, container, false);
        ListView nav = navFragment.findViewById(R.id.listView1);
        String[] navItems = {"Services", "Fun Things To Do", "Dinning", "Shopping"};
        ArrayAdapter<String> navItemsAdapter = new ArrayAdapter<String>(getActivity(), R.layout.listview_layout, R.id.listViewText, navItems);
        nav.setAdapter(navItemsAdapter);
        nav.setOnItemClickListener(new ListViewOnClickHandler());

        // Inflate the layout for this fragment
        return navFragment;
    }

    public class ListViewOnClickHandler implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            MainActivity activity = (MainActivity) getActivity();
            String clickedItem = parent.getItemAtPosition(position).toString();

            switch (clickedItem) {
                case "Services":
                    activity.getData(clickedItem);
                    break;

                case "Fun Things To Do":
                    activity.getData(clickedItem);
                    break;

                case "Dinning":
                    activity.getData(clickedItem);
                    break;

                case "Shopping":
                    activity.getData(clickedItem);
                    break;
            }
        }
    }


}
