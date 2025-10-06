package RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragment_td2.R;

import java.util.List;

import Module.Champion;

public class ChampionAdapter extends RecyclerView.Adapter<ChampionAdapter.ChampionViewHolder> {

    private List<Champion> championList;
    private Context context;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Champion champion);
    }

    public ChampionAdapter(Context context, List<Champion> championList, OnItemClickListener listener) {
        this.context = context;
        this.championList = championList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ChampionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_champion, parent, false);
        return new ChampionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChampionViewHolder holder, int position) {
        Champion champion = championList.get(position);

        holder.nameTextView.setText("Name : " + champion.getName());
        holder.roleTextView.setText("Role : " + champion.getRole());
        holder.imageView.setImageResource(champion.getImageResId());

        holder.itemView.setOnClickListener(v -> {

            listener.onItemClick(champion);


        });
    }

    @Override
    public int getItemCount() {
        return championList.size();
    }

    public static class ChampionViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameTextView;
        TextView roleTextView;

        public ChampionViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.champion_image);
            nameTextView = itemView.findViewById(R.id.champion_name);
            roleTextView = itemView.findViewById(R.id.champion_role);
        }
    }
}