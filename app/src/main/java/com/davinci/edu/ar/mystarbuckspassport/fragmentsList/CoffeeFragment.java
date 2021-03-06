package com.davinci.edu.ar.mystarbuckspassport.fragmentsList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.davinci.edu.ar.mystarbuckspassport.R;

/**
 * Created by user on 11/07/2017.
 */

public class CoffeeFragment extends Fragment {

    String[] coffee = {"Espresso Roast", "Italian Roast"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView= inflater.inflate(R.layout.coffee_fragment, container, false);
        ListView list = (ListView) rootView.findViewById(R.id.coffeeListView);
        ArrayAdapter adapter = new ArrayAdapter(this.getActivity(), android.R.layout.simple_expandable_list_item_1,coffee);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),coffee[position],Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }
}
