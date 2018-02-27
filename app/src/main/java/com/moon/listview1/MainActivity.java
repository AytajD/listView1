package com.moon.listview1;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView list;
    String [] memeTitles;
    String [] memeDescription;
    int[] images = {R.drawable.andrey, R.drawable.zum,  R.drawable.khayala,R.drawable.ivan,R.drawable.leyli,R.drawable.ali,
            R.drawable.andrey, R.drawable.zum,  R.drawable.khayala,R.drawable.ivan,R.drawable.leyli,R.drawable.ali,R.drawable.andrey, R.drawable.zum,
            R.drawable.khayala,R.drawable.ivan,R.drawable.leyli,R.drawable.ali};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res= getResources();
        memeTitles=res.getStringArray(R.array.titles);
        memeDescription=res.getStringArray(R.array.Description);
        list = (ListView) findViewById(R.id.listView);
        myAdapter adapter = new myAdapter(this,memeTitles,images,memeDescription);
        list.setAdapter(adapter);

    }
}
class myAdapter extends ArrayAdapter<String>
{   Context context;
    int [] images;
    String [] titleArray;
    String [] descriptionArray;
    myAdapter(Context c, String[] titles, int imgs[], String[] desc)
    {
        super(c, R.layout.single_row,R.id.textView, titles);
        this.context=c;
        this.images=imgs;
        this.titleArray=titles;
        this.descriptionArray=desc;
    }

    class MyViewHolder
    {
        ImageView myImage;
        TextView myTitle;
        TextView myDescription;
        MyViewHolder(View v)
        {
            myImage = (ImageView) v.findViewById(R.id.imageView);
            myTitle = (TextView) v.findViewById(R.id.textView);
            myDescription = (TextView) v.findViewById(R.id.textView2);
        }
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

              View row = convertView;
        MyViewHolder holder = null;
        if(row == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_row, parent, false);
            holder = new MyViewHolder(row);
            row.setTag(holder);
        }
        else
        {
            holder = (MyViewHolder) row.getTag();
        }

        holder.myImage.setImageResource(images[position]);
        holder.myTitle.setText(titleArray[position]);
       holder. myDescription.setText(descriptionArray[position]);
        return row;
    }
}
