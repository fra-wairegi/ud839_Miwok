package com.example.android.miwok;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhrasesFragment extends Fragment {

    private MediaPlayer mMediaPlayer;

    public PhrasesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("Where are you going?", "minto wuksus",R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?", "two",R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is...", "three",R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?", "four",R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I'm feeling good", "five",R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?", "six",R.raw.phrase_are_you_coming));
        words.add(new Word("Yes I'm coming.", "hәә’ әәnәm",R.raw.phrase_yes_im_coming));
        words.add(new Word("I'm coming", "әәnәm",R.raw.phrase_im_coming));
        words.add(new Word("Let's go.", "yoowutis",R.raw.phrase_lets_go));
        words.add(new Word("Come here.", "әnni'nem",R.raw.phrase_come_here));



        // Initialize an ArrayAdapter
        WordAdapter itemsAdapter = new WordAdapter(getActivity(), words,R.color.category_phrases);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Word word = words.get(position);
                mMediaPlayer = MediaPlayer.create(getActivity(), word.getAudioResourceId());
                mMediaPlayer.start();
            }
        });

        return rootView;
    }

}
