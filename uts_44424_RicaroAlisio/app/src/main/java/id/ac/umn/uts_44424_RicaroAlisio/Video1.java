package id.ac.umn.uts_44424_RicaroAlisio;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class Video1 extends RecyclerView.Adapter<Video1.VideoViewHolder> {
    private Context context;
    private ArrayList<Video> listVideo;
    private OnItemClickListener listener;

    @Override
    public int getItemCount() {
        int x = listVideo.size();
        return x;
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView deleteButton;
        ConstraintLayout videoContainer;

        public VideoViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            videoContainer = itemView.findViewById(R.id.eachVideoContainer);
            videoContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, VideoPropertiesActivit.class);
                    intent.putExtra("video", listVideo.get(getAdapterPosition()));
                    context.startActivity(intent);
                }
            });
            deleteButton = itemView.findViewById(R.id.deleteBtn);
            deleteButton.setOnClickListener(new View.OnClickListener() {

                @Override

                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Delete Video");
                    builder.setMessage("Once deleted can't be recovered");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            listener.onItemClick(getAdapterPosition());
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                    //listener.onItemClick(getAdapterPosition());
                }
            });
        }
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.struct_vid_xml, parent, false);
        return new VideoViewHolder(view, listener);
    }

    public void setOnItemClickListener(OnItemClickListener clickListener) {
        this.listener = clickListener;
    }

    public Video1(Context context, ArrayList<Video> list) {
        this.context = context;
        this.listVideo = list;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.title.setText(listVideo.get(position).getJudul());
    }


    public interface OnItemClickListener {
        void onItemClick(int position);
    }


}
