package com.example.myfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private EditText editTextNama, editTextEmail, editTextPassword;
    private Button btnSave;
//    private RecyclerView recyclerView;
    private List<Account> accountList;
//    private RecyclerViewAdapter rvAdapter;
    private DBHelper dbHelper;


    private Fragment listFragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        listFragment = new ListFragment();
        editTextNama = view.findViewById(R.id.editTextNama);
        editTextEmail = view.findViewById(R.id.editTextEmail);
        editTextPassword = view.findViewById(R.id.editTextPassword);
        btnSave = view.findViewById(R.id.btnSave);
//        recyclerView = view.findViewById(R.id.recyclerView);
        accountList = new ArrayList<>();
//        rvAdapter = new RecyclerViewAdapter(accountList);
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
//        recyclerView.setAdapter(rvAdapter);
//
        dbHelper = new DBHelper(requireContext());

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nama = editTextNama.getText().toString();
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                long result = dbHelper.insertData(nama, email, password);

                if (result > 0) {
                    Toast.makeText(requireContext(), "Successfully Saved", Toast.LENGTH_SHORT).show();
                    loadData();
                } else {
                    Toast.makeText(requireContext(), "Failed to Save", Toast.LENGTH_SHORT).show();
                    loadData();
                }

                editTextNama.getText().clear();
                editTextEmail.getText().clear();
                editTextPassword.getText().clear();

            }
        });

        loadData();

        return view;
    }


    private void loadData() {
//        accountList.clear();
//        accountList.addAll(dbHelper.getAllData());
//        rvAdapter.notifyDataSetChanged();

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.sub_fragment_container, listFragment);
        transaction.commit();

    }
}