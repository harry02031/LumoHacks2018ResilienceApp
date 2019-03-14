package com.example.zhenyux.lumohack2018.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.zhenyux.lumohack2018.R;
import com.example.zhenyux.lumohack2018.classes.Psychiatrist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ResourceFragment extends Fragment {
    List<Psychiatrist> psychiatrists = new ArrayList<Psychiatrist>();
    Context self;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_resource, container,false);

        self = getContext();

        populatListView();

        return view;
    }

    public class MyListViewAdapter extends ArrayAdapter<Psychiatrist> {
        public MyListViewAdapter(Context context, List<Psychiatrist> psychiatrists) {
            super(context, R.layout.mylistviewresource, psychiatrists);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.mylistviewresource, parent, false);
            }

            TextView name = (TextView) convertView.findViewById(R.id.resourceNameId);
            TextView phone = (TextView) convertView.findViewById(R.id.resourcePhoneId);
            TextView address = (TextView) convertView.findViewById(R.id.resourceAddressId);
            TextView distance = (TextView) convertView.findViewById(R.id.resourceDistanceId);
            TextView rating = (TextView) convertView.findViewById(R.id.resourceRatingId);

            Psychiatrist mPsychiatrists = psychiatrists.get(position);

            name.setText(mPsychiatrists.getName());
            phone.setText(mPsychiatrists.getPhoneNumber());
            address.setText(mPsychiatrists.getLocation());
            distance.setText(mPsychiatrists.getDistance());
            rating.setText(mPsychiatrists.getRating());

            return convertView;
        }
    }
    public void populatListView(){
        populatePsychiatrists();
        MyListViewAdapter adapter = new MyListViewAdapter(self,psychiatrists);
        ListView listView = (ListView) view.findViewById(R.id.ResourceslistView);
        listView.setAdapter(adapter);
    }

    public void populatePsychiatrists(){
        Psychiatrist psychiatrist1 = new Psychiatrist("John Smith","777-777-7777","1234 hello street, Coqutilam","5 KM", "5 stars");
        Psychiatrist psychiatrist2 = new Psychiatrist("John Smith","777-777-7777","1234 hello street, Coqutilam","5 KM", "5 stars");
        Psychiatrist psychiatrist3 = new Psychiatrist("John Smith","777-777-7777","1234 hello street, Coqutilam","5 KM", "5 stars");
        Psychiatrist psychiatrist4 = new Psychiatrist("John Smith","777-777-7777","1234 hello street, Coqutilam","5 KM", "5 stars");
        Psychiatrist psychiatrist5 = new Psychiatrist("John Smith","777-777-7777","1234 hello street, Coqutilam","5 KM", "5 stars");
        Psychiatrist psychiatrist6 = new Psychiatrist("John Smith","777-777-7777","1234 hello street, Coqutilam","5 KM", "5 stars");
        Psychiatrist psychiatrist7 = new Psychiatrist("John Smith","777-777-7777","1234 hello street, Coqutilam","5 KM", "5 stars");

        psychiatrists.add(psychiatrist1);
        psychiatrists.add(psychiatrist2);
        psychiatrists.add(psychiatrist3);
        psychiatrists.add(psychiatrist4);
        psychiatrists.add(psychiatrist5);
        psychiatrists.add(psychiatrist6);
        psychiatrists.add(psychiatrist7);


    }

}
