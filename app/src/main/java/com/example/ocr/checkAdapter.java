package com.example.ocr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;

import com.example.ocr.R;

import java.util.ArrayList;

public class checkAdapter extends BaseAdapter {
    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<String> sample;
    ArrayList<String> checkitems;

    public checkAdapter(Context context, ArrayList<String> data){
        mContext = context;
        sample = data;
        mLayoutInflater = LayoutInflater.from(mContext);
        checkitems = new ArrayList<String>();
    }

    @Override
    public int getCount() {
        return sample.size();
    }

    @Override
    public Object getItem(int position) {
        return sample.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.checkitem, null);
        final CheckBox ch = (CheckBox) view.findViewById(R.id.checkBoxItem);

        ch.setText(sample.get(position));
        ch.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked()){
                    checkitems.add(ch.getText().toString());
                }
                else{
                    checkitems.remove(ch.getText().toString());
                }
            }
        });

        return view;
    }
}
