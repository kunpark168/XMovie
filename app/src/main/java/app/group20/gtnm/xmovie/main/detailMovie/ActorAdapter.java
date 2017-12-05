package app.group20.gtnm.xmovie.main.detailMovie;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import app.group20.gtnm.xmovie.R;

/**
 * Created by Kunka on 11/11/2017.
 */

public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.ActorViewHolder> {

    private ArrayList<Actor> arrActor;
    private Context mContext;

    public ActorAdapter(ArrayList<Actor> arrActor, Context mContext) {
        this.arrActor = arrActor;
        this.mContext = mContext;
    }

    @Override
    public ActorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.itemactor, parent, false);
        return new ActorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ActorViewHolder holder, int position) {
        Actor actor = arrActor.get(position);
        holder.imgActor.setImageResource(actor.getImgActor());
        holder.txtActor.setText(actor.getTxtActorName());
    }

    @Override
    public int getItemCount() {
        return arrActor.size();
    }

    public class ActorViewHolder extends RecyclerView.ViewHolder{

        public ImageView imgActor;
        public TextView txtActor;
        public ActorViewHolder(View itemView) {
            super(itemView);
            imgActor = (ImageView) itemView.findViewById(R.id.imgActor);
            txtActor = (TextView) itemView.findViewById(R.id.txtActor);
        }
    }
}
