/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

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
        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }
}
