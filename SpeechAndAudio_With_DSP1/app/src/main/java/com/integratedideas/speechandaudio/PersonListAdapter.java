package com.integratedideas.speechandaudio;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by user on 2017-06-06.
 */

public class PersonListAdapter extends BaseAdapter {

    private List people;
    private Context context;

    public PersonListAdapter(List people, Context context){
        this.people = people;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.people.size();
    }

    @Override
    public Object getItem(int position) {
        return this.people.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;

        if(convertView==null){
            convertView = new RelativeLayout(context);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
            convertView.setLayoutParams(params);
/*
            TextView tvId = new TextView(context);
            tvId.setPadding(10, 0, 20, 0);
            tvId.setTextColor(Color.rgb(0, 0, 0));
            tvId.setId(R.id.tvId);
            RelativeLayout.LayoutParams params_id = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            tvId.setLayoutParams(params_id);*/

            ImageView tvImage = new ImageView(context);
            tvImage.setPadding(20,0,20,0);
            tvImage.setId(R.id.tvImage);
            RelativeLayout.LayoutParams params_image = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            tvImage.setLayoutParams(params_image);

            TextView tvMusic = new TextView(context);
            tvMusic.setPadding(20, 0, 20, 0);
            tvMusic.setTextColor(Color.rgb(0, 0, 0));
            tvMusic.setId(R.id.tvMusic);
            tvMusic.setTextSize(20);
            RelativeLayout.LayoutParams params_music = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            params_music.addRule(RelativeLayout.RIGHT_OF,R.id.tvImage);
            tvMusic.setLayoutParams(params_music);

            TextView tvMan = new TextView(context);
            tvMan.setPadding(20, 0, 20, 0);
            tvMan.setTextColor(Color.rgb(0, 0, 0));
            tvMan.setId(R.id.tvMan);
            RelativeLayout.LayoutParams params_man = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            params_man.addRule(RelativeLayout.BELOW,R.id.tvMusic);
            params_man.addRule(RelativeLayout.RIGHT_OF,R.id.tvImage);
            tvMan.setLayoutParams(params_man);
/*
            TextView tvGe = new TextView(context);
            tvGe.setPadding(20, 0, 20, 0);
            tvGe.setTextColor(Color.rgb(0, 0, 0));
            tvGe.setId(R.id.tvGe);
            RelativeLayout.LayoutParams params_ge = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            params_ge.addRule(RelativeLayout.RIGHT_OF,R.id.tvMan);
            tvGe.setLayoutParams(params_ge);
*/
            TextView tvMax = new TextView(context);
            tvMax.setPadding(0, 0, 20, 0);
            tvMax.setTextColor(Color.rgb(0, 0, 0));
            tvMax.setId(R.id.tvMax);
            RelativeLayout.LayoutParams params_max = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            params_max.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            params_max.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            tvMax.setLayoutParams(params_max);

            TextView tvMin = new TextView(context);
            tvMin.setPadding(20, 0, 20, 0);
            tvMin.setTextColor(Color.rgb(0, 0, 0));
            tvMin.setId(R.id.tvMin);
            RelativeLayout.LayoutParams params_min = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            params_min.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            params_min.addRule(RelativeLayout.LEFT_OF,R.id.tvMax);
            tvMin.setLayoutParams(params_min);


            //((RelativeLayout) convertView).addView(tvId);
            ((RelativeLayout) convertView).addView(tvImage);
            ((RelativeLayout) convertView).addView(tvMusic);
            ((RelativeLayout) convertView).addView(tvMan);
            //((RelativeLayout) convertView).addView(tvGe);
            ((RelativeLayout) convertView).addView(tvMin);
            ((RelativeLayout) convertView).addView(tvMax);
            holder = new Holder();
           // holder.tvId = tvId;
            holder.tvImage = tvImage;
            holder.tvMusic = tvMusic;
            holder.tvMan = tvMan;
           // holder.tvGe = tvGe;
            holder.tvMin = tvMin;
            holder.tvMax = tvMax;
            convertView.setTag(holder);

        }
        else{
            holder = (Holder)convertView.getTag();
        }
        Person person = (Person) getItem(position);
        //holder.tvId.setText(person.get_id() + "");
        holder.tvImage.setImageResource(R.drawable.ic_music_note);
        holder.tvMusic.setText(person.getMusicName());
        holder.tvMan.setText(person.getManName());
        //holder.tvGe.setText(person.getGeName());
        holder.tvMin.setText(person.getMin() + " ~");
        holder.tvMax.setText(person.getMax() + "");
        return convertView;

    }

    private class Holder {
        public TextView tvId;
        public ImageView tvImage;
        public TextView tvMusic;
        public TextView tvMan;
        public TextView tvGe;
        public TextView tvMin;
        public TextView tvMax;
    }

}
