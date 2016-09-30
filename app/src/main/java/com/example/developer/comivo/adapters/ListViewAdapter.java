package com.example.developer.comivo.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.developer.comivo.R;
import com.example.developer.comivo.activities.activities_for_community.TimelineCommentsActivity;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Kevin Khanda on 30.09.2016.
 * Adapter for ListView
 */

public class ListViewAdapter extends BaseAdapter {

    private TimelineCommentsActivity timelineCommentsActivity;

    public ListViewAdapter(TimelineCommentsActivity timelineCommentsActivity) {
        this.timelineCommentsActivity = timelineCommentsActivity;
    }

    @Override
    public int getCount() {
        return timelineCommentsActivity.comments.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolderItem {
        TextView title;
        CircleImageView profileImage;
        TextView fullName;
        TextView companyName;
        TextView countryCreated;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderItem holderItem = new ViewHolderItem();
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) timelineCommentsActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.community_cell, null);

            holderItem.title = (TextView) convertView.findViewById(R.id.title);
            holderItem.profileImage = (CircleImageView) convertView.findViewById(R.id.profile_image);
            holderItem.fullName = (TextView) convertView.findViewById(R.id.full_name);
            holderItem.companyName = (TextView) convertView.findViewById(R.id.company_name);
            holderItem.countryCreated = (TextView) convertView.findViewById(R.id.country_created);

            convertView.setTag(holderItem);
        } else {
            holderItem = (ViewHolderItem) convertView.getTag();
        }


        holderItem.title.setText(this.timelineCommentsActivity.comments.get(position).getTitle());
        holderItem.profileImage.setImageURI(Uri.parse(this.timelineCommentsActivity.comments.get(position).getCommunityUser().getProfileImage()));
        holderItem.fullName.setText(this.timelineCommentsActivity.comments.get(position).getCommunityUser().getFirstName() + " " +
                this.timelineCommentsActivity.comments.get(position).getCommunityUser().getLastName());
        holderItem.companyName.setText(this.timelineCommentsActivity.comments.get(position).getCommunityUser().getCompanyName());
        holderItem.countryCreated.setText(this.timelineCommentsActivity.comments.get(position).getCommunityUser().getCountry() + " " +
                this.timelineCommentsActivity.comments.get(position).getCreated());

        return convertView;
    }
}
