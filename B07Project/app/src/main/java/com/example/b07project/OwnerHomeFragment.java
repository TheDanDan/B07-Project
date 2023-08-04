package com.example.b07project;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OwnerHomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OwnerHomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerView;
    ArrayList<Item> items;
    OwnerHomeAdapter adapter;

    public OwnerHomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OwnerHomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OwnerHomeFragment newInstance(String param1, String param2) {
        OwnerHomeFragment fragment = new OwnerHomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    String username;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
    }
    private ArrayList<Item> getData()
    {
        ArrayList<Item> list = new ArrayList<>();
        list.add(new Item("Item 1",
                1,
                "This is the first item"));
        list.add(new Item("Item 2",
                2,
                "This is the second item"));
        list.add(new Item("Item 3",
                3,
                "This is the third item"));

        return list;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_owner_home, container, false);

        // Initialize RecyclerView
        recyclerView = rootView.findViewById(R.id.owner_items);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Initialize item list (You can replace this with your actual data source)
        items = getData();

        // Set up the RecyclerView Adapter
        adapter = new OwnerHomeAdapter(items);
        recyclerView.setAdapter(adapter);

        return rootView;
    }
}