package a2019.hackaz.connect;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.api.services.calendar.model.Event;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {
    private List<Event> mDataset;

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        protected TextView description;
        protected TextView summary;
        public EventViewHolder(View v) {
            super(v);
            this.description = v.findViewById(R.id.descriptionTextView);
            this.summary = v.findViewById(R.id.summaryTextView);
        }
    }

    public EventAdapter(List<Event> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public EventAdapter.EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_view_item, parent, false);

        EventViewHolder vh = new EventViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        holder.summary.setText(mDataset.get(position).getSummary());
        holder.description.setText(mDataset.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
