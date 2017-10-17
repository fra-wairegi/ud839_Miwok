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
public class ColorsFragment extends Fragment {

    private MediaPlayer mMediaPlayer;


    public ColorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list,container,false);


        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("red", "one",R.drawable.color_red,R.raw.color_red));
        words.add(new Word("green", "chokokki", R.drawable.color_green,R.raw.color_green));
        words.add(new Word("brown", "three", R.drawable.color_brown,R.raw.color_brown));
//        words.add(new Word("gray", "four"));
//        words.add(new Word("black", "five"));
//        words.add(new Word("white", "six"));
//        words.add(new Word("dusty yellow", "ṭopiisә"));
//        words.add(new Word("mustard yellow", "eight"));

        // Initialize an ArrayAdapter
        WordAdapter itemsAdapter = new WordAdapter(getActivity(), words,R.color.category_colors);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        // Implementing the onItemClickListener

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Word word = words.get(position);

                // Toast.makeText(ColorsActivity.this,word.toString(),Toast.LENGTH_LONG).show();

                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(getActivity(), word.getAudioResourceId());

                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        //Toast.makeText(ColorsActivity.this, "end of this audio file", Toast.LENGTH_SHORT).show();
                        releaseMediaPlayer();
                    }
                });
            }
        });
       return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();

        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }

}
