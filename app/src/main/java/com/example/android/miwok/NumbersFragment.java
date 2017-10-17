package com.example.android.miwok;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumbersFragment extends Fragment {


    public NumbersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);


        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("lutti","one",R.drawable.number_one));
        words.add(new Word("fdfd","two",R.drawable.number_two));
        words.add(new Word("fdd","three",R.drawable.number_three));
        words.add(new Word("dfdf","four",R.drawable.number_four));
        words.add(new Word("dfdf","five",R.drawable.number_five));
        words.add(new Word("vcv","six",R.drawable.number_one));
        words.add(new Word("cvv","seven",R.drawable.number_one));
        words.add(new Word("vfg","eight",R.drawable.number_one));

        // Initialize an ArrayAdapter
        WordAdapter itemsAdapter = new WordAdapter(getActivity(), words, R.color.category_numbers);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        return rootView;
    }

}
