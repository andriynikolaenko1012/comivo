package com.example.developer.comivo.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.developer.comivo.R;
import com.example.developer.comivo.models.MessagesModel;

import java.util.List;


public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    public static class MessageViewHolder extends RecyclerView.ViewHolder {

        TextView userName;
        TextView companyName;
        TextView time;
        TextView messageText;
        ImageView status;
        ImageView coverImage;

        MessageViewHolder(View itemView) {
            super(itemView);
            userName = (TextView) itemView.findViewById(R.id.tv_user_name);
            companyName = (TextView) itemView.findViewById(R.id.tv_company_name);
            time = (TextView) itemView.findViewById(R.id.tv_time);
            messageText = (TextView) itemView.findViewById(R.id.tv_message_text);
            status = (ImageView) itemView.findViewById(R.id.iv_online_status);
            coverImage = (ImageView) itemView.findViewById(R.id.iv_cover_image);
        }
    }

    List<MessagesModel> messages;

    public MessageAdapter(List<MessagesModel> messages) {
        this.messages = messages;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.message_list_row, viewGroup, false);
        MessageViewHolder mvh = new MessageViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MessageViewHolder messageViewHolder, int i) {
        messageViewHolder.userName.setText(messages.get(i).getUserName());
        messageViewHolder.companyName.setText(messages.get(i).getCompanyName());
        messageViewHolder.time.setText(messages.get(i).getTime());
        messageViewHolder.messageText.setText(messages.get(i).getMessageText());
        messageViewHolder.status.setImageResource(messages.get(i).getStatusImg());
        messageViewHolder.coverImage.setImageResource(messages.get(i).getProfileCoverImage());
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }
}