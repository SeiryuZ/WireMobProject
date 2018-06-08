package com.example.mrtbkwjn.a2018asiangamesapp;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    ArrayList<String> eventList;

    public static class EventViewHolder extends RecyclerView.ViewHolder {

        TextView eventIdText;
        TextView eventDetailText;
        TextView eventDate;


        public EventViewHolder(View itemView) {
            super(itemView);

            eventIdText = itemView.findViewById(R.id.sportId);
            eventDetailText = itemView.findViewById(R.id.sportDetail);
            eventDate = itemView.findViewById(R.id.sportTime);
        }
    }

    public EventAdapter(ArrayList<String> eventList) {
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View row = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.choose_event_row, parent, false);
        EventViewHolder viewHolder = new EventViewHolder(row);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        holder.eventIdText.setText(eventList.get(position));
        holder.eventDetailText.setText(eventList.get(position));
        holder.eventDate.setText(eventList.get(position));
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }
}
