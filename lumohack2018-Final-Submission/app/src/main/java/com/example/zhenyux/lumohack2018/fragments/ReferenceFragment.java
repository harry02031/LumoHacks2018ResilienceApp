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

import com.example.zhenyux.lumohack2018.R;

public class ReferenceFragment extends Fragment {
    String[] List = new String[]{"https://www.youtube.com/watch?v=7aLCWbe6Awk&t=341s", "https://www.youtube.com/watch?v=fGcMLu1GJEc",
    "https://drive.google.com/drive/folders/13gfztDZ3UrhKU-h46ybJNsoeDNAGqA8l", "https://drive.google.com/drive/folders/1kg7DqChbYWGDNQ0rH9KthPiKFoTAcg2q"
    ,"https://github.com/codepath/android_guides/wiki/Using-an-ArrayAdapter-with-ListView","https://stackoverflow.com/questions/17237287/how-can-i-wait-for-10-second-without-locking-application-ui-in-android",
    "https://github.com/codepath/android_guides/wiki/Using-a-BaseAdapter-with-ListView"};
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_reference,container,false);
        fillupListView();
        return view;
    }

    private void fillupListView() {
        ListView listView = view.findViewById(R.id.reference_listview);
        ArrayAdapter<String> itemAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, List);
        listView.setAdapter(itemAdapter);
    }
}
