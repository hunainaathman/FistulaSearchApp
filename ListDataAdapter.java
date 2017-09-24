package com.example.hunaina.fistulasearchapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hunaina on 4/23/2017.
 */
public class ListDataAdapter extends ArrayAdapter<String>{
    private String[] ids;
    private String[] firstnames;
    private String[] secondnames;
    private String[] lastnames;
    private Activity context;

    public ListDataAdapter(Activity context, String[] ids, String[] firstnames, String[] secondnames, String[] lastnames) {
        super(context, R.layout.listdata_layout, ids);
        this.context = context;
        this.ids = ids;
        this.firstnames = firstnames;
        this.secondnames = secondnames;
        this.lastnames = lastnames;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater(); this.getContext();
            View listViewItem = inflater.inflate(R.layout.listdata_layout, null, true);

            TextView tvid = (TextView)listViewItem.findViewById(R.id.tvid);
            TextView tvfname = (TextView)listViewItem.findViewById(R.id.tvfname);
            TextView tvsname = (TextView)listViewItem.findViewById(R.id.tvsname);
            TextView tvlname = (TextView)listViewItem.findViewById(R.id.tvlname);

        tvid.setText(ids[position]);
        tvfname.setText(firstnames[position]);
        tvsname.setText(secondnames[position]);
        tvlname.setText(lastnames[position]);

        return listViewItem;
    }
}



