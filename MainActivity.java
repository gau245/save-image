package com.example.mycheckbox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CheckInlistenre {


    RecyclerView recycler;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        recycler=findViewById( R.id.recycler);
        setrecyclerview();
    }
    private ArrayList<String> getquantidata(){
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add( "10" );
        arrayList.add( "20" );
        arrayList.add( "30" );
        arrayList.add( "40" );
        arrayList.add( "50" );
        arrayList.add( "60" );
        arrayList.add( "70" );
        arrayList.add( "80" );
        arrayList.add( "90" );
        arrayList.add( "100" );
        arrayList.add( "110" );
        arrayList.add( "120" );
        arrayList.add( "130" );
        arrayList.add( "140" );
        arrayList.add( "150" );
        arrayList.add( "160" );
        return arrayList;

    }
    private void setrecyclerview() {

        recycler.setHasFixedSize( true );
        recycler.setLayoutManager( new LinearLayoutManager( this) );
        myAdapter =new MyAdapter(this,getquantidata(),this );
        recycler.setAdapter(myAdapter);


    }

    @Override
    public void oncheckchange(ArrayList<String> arrayList) {
        Toast.makeText( this, arrayList.toString(), Toast.LENGTH_SHORT ).show();
    }
}
