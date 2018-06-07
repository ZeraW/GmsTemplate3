package gmsproduction.com.gmstemplate3.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import gmsproduction.com.gmstemplate3.Activity.Details.DetailsProjects;
import gmsproduction.com.gmstemplate3.Models.MainModel;
import gmsproduction.com.gmstemplate3.R;

/**
 * Created by Hima on 4/15/2018.
 */

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<MainModel> mArrayList;
    private ArrayList<String> mArrayList2;
    private int lang ;

    public ProjectsAdapter(Context mContext, ArrayList<MainModel> mArrayList, ArrayList<String> mArrayList2 , int lang) {
        this.mContext = mContext;
        this.mArrayList = mArrayList;
        this.mArrayList2 = mArrayList2;
        this.lang = lang;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(mContext).inflate(R.layout.row_projects, parent, false);
        return new ProjectsAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final MainModel currentItem = mArrayList.get(position);
        final String ar_name = currentItem.getTitle();
        final String logo = currentItem.getLogo();
        final String desc = currentItem.getText();
        final String images = mArrayList2.get(position);

        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // to send data to new class using putExtra
                Intent intent=new Intent(mContext,DetailsProjects.class);
                intent.putExtra("title",ar_name);
                intent.putExtra("images",images);
                intent.putExtra("text",desc);
                if (lang == 1){
                    intent.putExtra("ToolbarTitle","المشروعات");
                }else{
                    intent.putExtra("ToolbarTitle","Projects");
                }


                mContext.startActivity(intent);

            }
        });

        holder.data_name.setText(ar_name);
        Picasso.with(mContext).load(logo).fit().centerInside().into(holder.imgs);


    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {
        ImageView imgs;
        TextView data_name;
        LinearLayout linear;

        public ViewHolder(View itemView) {
            super(itemView);
            imgs = itemView.findViewById(R.id.Img_Frag_Card);
            data_name = itemView.findViewById(R.id.TextName_Frag_Card);
            linear = itemView.findViewById(R.id.linearCardz);
        }
    }
}