package com.example.mycheckbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Dataviewholder> {
    Context context;
    ArrayList<String> arrayList;
    CheckInlistenre checkInlistenre;

    ArrayList<String> arrayList_0=new ArrayList<>();

    public MyAdapter(Context context, ArrayList<String> arrayList, CheckInlistenre checkInlistenre) {
        this.context = context;
        this.arrayList = arrayList;
        this.checkInlistenre = checkInlistenre;
    }

    @NonNull
    @Override
    public Dataviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from( context ).inflate( R.layout.item_file,parent,false );
        return new Dataviewholder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull Dataviewholder holder, int position) {
        if (arrayList!= null && arrayList.size()>0){
            holder.checkbox.setText( arrayList.get( position ));
            holder.checkbox.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (holder.checkbox.isChecked()){
                        arrayList_0.add( arrayList.get( position ) );
                    }else {
                        arrayList_0.remove( arrayList.get( position ));
                    }
                    checkInlistenre.oncheckchange( arrayList_0 );
                }
            } );

        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class  Dataviewholder extends RecyclerView.ViewHolder {

        CheckBox checkbox;
        TextView text;
        public Dataviewholder(@NonNull View itemView) {
            super( itemView );

            checkbox=itemView.findViewById( R.id.checkbox);
        }
    }
}
