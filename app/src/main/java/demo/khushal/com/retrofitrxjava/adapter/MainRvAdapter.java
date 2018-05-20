package demo.khushal.com.retrofitrxjava.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import demo.khushal.com.retrofitrxjava.R;
import demo.khushal.com.retrofitrxjava.beans.GitHubResponse;
import demo.khushal.com.retrofitrxjava.databinding.ListItemBinding;

public class MainRvAdapter extends RecyclerView.Adapter<MainRvAdapter.Viewholder> {

    private List<GitHubResponse> list;
    public MainRvAdapter(List<GitHubResponse> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        GitHubResponse gitHubResponse = list.get(position);
        holder.getListItemBinding().setResponse(gitHubResponse);
        holder.getListItemBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static final class Viewholder extends RecyclerView.ViewHolder{
        ListItemBinding listItemBinding;
        public Viewholder(View itemView) {
            super(itemView);
            listItemBinding = DataBindingUtil.bind(itemView);
        }

        public ListItemBinding getListItemBinding() {
            return listItemBinding;
        }
    }
}
