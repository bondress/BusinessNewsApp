package com.example.android.businessnewsapp;

/**
 * News represents a single News instance
 * Each object has four properties: headline, trailText, time and url.
 */
public class News {

    // Headline Tag of the News
    private String headline;

    // A small part of the News body (to pique the reader's interest. Lol)
    private String trailText;

    // Author of the News
    private String author;

    // Section ID of the News
    private String sectionId;

    // Date and Time of the News
    private String time;

    // Website url of the News
    private String url;

    /**
     * Create a new News object
     * @param h is the News Headline or Web
     * @param a is the author of the News
     * @param text is some text from the body of the News
     * @param t is the time the News was published
     * @param u is the website url to find more details about the news
     */
    public News(String h, String a, String text, String s, String t, String u){
        headline = h;
        author = a;
        trailText = text;
        sectionId = s;
        time = t;
        url = u;
    }

    /**
     * Get the News Headline
     */
    public String getHeadline(){
        return headline;
    }

    /**
     * Get the News Trail Text
     */
    public String getTrailText(){
        return trailText;
    }

    /**
     * Get the time the News was published
     */
    public String getTime(){
        return time;
    }

    /**
     * Get the website url to find more information about the News
     */
    public String getUrl(){
        return url;
    }

    /**
     * Get the News Author
     */
    public String getAuthor(){
        return author;
    }

    /**
     * Get the Section ID
     */
    public String getSectionId(){
        return sectionId;
    }
}
