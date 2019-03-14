package com.example.zhenyux.lumohack2018.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.zhenyux.lumohack2018.R;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {
    List<String> infos;
    Context self;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile,container,false);

        self = getContext();
        infos = new ArrayList<>();
        populateInfos();
        populateListView();

        return view;
    }
    public void populateListView(){
        MyListViewAdapter adapter = new MyListViewAdapter(self,infos);
        ListView list = view.findViewById(R.id.ProfilelistView);
        list.setAdapter(adapter);
    }

    public class MyListViewAdapter extends ArrayAdapter<String> {
        public MyListViewAdapter(Context context, List<String> strings) {
            super(context, R.layout.mylistviewprofile, strings);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.mylistviewprofile, parent, false);
            }

            TextView info = (TextView) convertView.findViewById(R.id.info);

            info.setText(infos.get(position));

            return convertView;
        }
    }

    public void populateInfos(){
        infos.add("Got up on time for 5 days in a row.\nLost 1 kilogram of weight.\nDidn't skip any meals.\n\nWent for a walk with my dog.\nSaw my niece for the first time in 3 months.\nMy buddy Mark helped me out with the dog shed.");
        infos.add("[3 accomplishments]\n[3 things I'm thankful for]");
    }
}
