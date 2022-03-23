package com.example.android;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.android.miwok.R;

import java.util.ArrayList;

public class wordAdapter extends ArrayAdapter<word> {
    private int mColorResourceId;
    public wordAdapter(Activity context, ArrayList<word> words,int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        final word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokWord = (TextView) listItemView.findViewById(R.id.miwok_word);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miwokWord.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultWord = (TextView) listItemView.findViewById(R.id.english_word);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        defaultWord.setText(currentWord.getDefaultTranslation());

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        textContainer.setBackgroundColor(color);

        ImageView image = (ImageView) listItemView.findViewById(R.id.image);

        if (currentWord.hasImage()){
            image.setImageResource(currentWord.getmImageResourceId());
            image.setVisibility(View.VISIBLE);
        }else {
            image.setVisibility(View.GONE);
        }

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
