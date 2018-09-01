package com.example.ay.teacher.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.HapticFeedbackConstants;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ay.teacher.R;

import java.util.ArrayList;

public class noticeAdapter extends RecyclerView.Adapter<noticeAdapter.holder> {


    private ArrayList<Integer> colorlist;
    private int count = 0;
    private int counter=0;
    private Context context;
    private Integer[] namearray;
    private Drawable[] iconarray;
    private LayoutInflater inflater;
    private View view;
    private MessageAdapterListener listener;


    public noticeAdapter(Drawable[] iconarray, Integer[] namearray, ArrayList<Integer> colorlist, int count, Context context) {
        this.colorlist = colorlist;
        this.count = count;
        this.context=context;
        this.namearray=namearray;
        this.iconarray=iconarray;
        inflater= LayoutInflater.from(context);
    }

    class holder extends RecyclerView.ViewHolder implements View.OnLongClickListener{
        ImageView d;
        TextView t;
        TextView f;
        public LinearLayout messageContainer;

        public holder(View itemView) {
            super(itemView);
            f = itemView.findViewById(R.id.tv_rollno_noti);
            d = itemView.findViewById(R.id.icon_noti_holder);
            t = itemView.findViewById(R.id.tv_name_noti_holder);
            messageContainer = (LinearLayout) view.findViewById(R.id.messageContainer);
            view.setOnLongClickListener(this);

        }
        @Override
        public boolean onLongClick(View view) {
            listener.onRowLongClicked(getAdapterPosition());
            view.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
            return true;
        }

    }


    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        view = inflater.inflate(R.layout.notification_holder, parent, false);
        counter++;
        return new holder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull holder holder, final int position) {
        holder.d.setImageDrawable(iconarray[position%iconarray.length]);
        holder.t.setText(namearray[position % namearray.length]);
        holder.f.setText(String.valueOf(position));
        holder.messageContainer.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                listener.onRowLongClicked(position);

                view.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
                return true;
            }
        });
    }



    @Override
    public int getItemCount() {
        return count;
    }

    public interface MessageAdapterListener {
        void onIconClicked(int position);

        void onIconImportantClicked(int position);

        void onMessageRowClicked(int position);

        void onRowLongClicked(int position);
    }

}


