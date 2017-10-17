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
public class FamilyFragment extends Fragment {


    public FamilyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("father", "one",R.drawable.family_father));
        words.add(new Word("mother", "two",R.drawable.family_mother));
        words.add(new Word("son", "three",R.drawable.family_son));
        words.add(new Word("dfdf", "four",R.drawable.family_daughter));
        words.add(new Word("dfdf", "five",R.drawable.number_one));
        words.add(new Word("vcv", "six",R.drawable.number_one));
        words.add(new Word("cvv", "seven",R.drawable.number_one));
        words.add(new Word("vfg", "eight",R.drawable.number_one));

        // Initialize an ArrayAdapter
        WordAdapter itemsAdapter = new WordAdapter(getActivity(), words, R.color.category_family);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        return rootView;
    }

}
