package com.example.android.businessnewsapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter<News>{

    private static final String DATE_SEPARATOR = "T";
    private static final String TIME_SEPARATOR = "Z";
    /**
     * A static inner class to hold our views in order to optimise our ListView
     */
    static class ViewHolder {
        TextView headline;
        TextView author;
        TextView section;
        TextView trailText;
        TextView date;
        TextView time;
    }

    /**
     * A custom constructor (does not mirror a superclass constructor)
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param activity The current context. Used to inflate the layout file
     * @param newsObjects A list of News objects to display in a list
     */
    public NewsAdapter(Activity activity, ArrayList<News> newsObjects){
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for three TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(activity, 0, newsObjects);
    }

    /**
     * Provides a view for an AdapterView (in this case, a ListView)
     *
     * @param position The position in the list of data that should be displayed
     *                 in the list item view
     * @param convertView The recycled view to populate
     * @param parent The parent ViewGroup that is used for inflation
     * @return The View for the positon in the AdapterView
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Declare a new ViewHolder object
        ViewHolder holder;

        // Create new String variables (dateOnly and timeOnly)
        // to store separated date and time
        String dateOnly, timeOnly;

        // Check if the existing view is being reused, otherwise inflate the view
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate
                    (R.layout.list_item, parent, false);

            // Initialise the ViewHolder object
            holder = new ViewHolder();

            // Populate the ViewHolder and store it inside the layout
            holder.headline = convertView.findViewById(R.id.headline_text_view);
            holder.author = convertView.findViewById(R.id.author_text_view);
            holder.trailText = convertView.findViewById(R.id.trail_text_view);
            holder.section = convertView.findViewById(R.id.section_text_view);
            holder.date = convertView.findViewById(R.id.date_text_view);
            holder.time = convertView.findViewById(R.id.time_text_view);
            convertView.setTag(holder);

            News newsObject = getItem(position);

            // Get the original time String from the News object and
            // store it in a variable
            String originalTime = newsObject.getTime();

            // Split the originalTime String into dateOnly and TimeOnly
            // Check for the DATE SEPARATOR "T"
            if(originalTime.contains(DATE_SEPARATOR)){
                // Split the String
                String[] parts = originalTime.split(DATE_SEPARATOR);
                dateOnly = parts[0];
                timeOnly = parts[1];
                holder.date.setText(dateOnly);
                // Remove the TIME SEPARATOR "Z" from the second part of the String
                if(parts[1].contains(TIME_SEPARATOR)){
                    String secondPart[] = parts[1].split(TIME_SEPARATOR);
                    timeOnly = secondPart[0];
                    holder.time.setText(timeOnly);
                }
            }

            // Display the remaining contents of the ViewHolder in their corresponding TextViews
            holder.headline.setText(newsObject.getHeadline());
            holder.author.setText(newsObject.getAuthor());
            holder.trailText.setText(newsObject.getTrailText());
            holder.section.setText(newsObject.getSectionId());
        }
        return convertView;
    }
}
