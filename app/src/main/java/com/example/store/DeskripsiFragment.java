package com.example.store;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DeskripsiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DeskripsiFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DeskripsiFragment() {
        // Required empty public constructor
    }

    ModelBaju modelyangdipilih;
    public DeskripsiFragment(ModelBaju modelBaju) {
    this.modelyangdipilih = modelBaju;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DeskripsiFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DeskripsiFragment newInstance(String param1, String param2) {
        DeskripsiFragment fragment = new DeskripsiFragment();
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

    ImageView gmbr;
    TextView namabaju,hargabaju;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        namabaju = view.findViewById(R.id.namabaju);
        hargabaju = view.findViewById(R.id.hargabaju);
        gmbr = view.findViewById(R.id.deskaos);
        namabaju.setText(modelyangdipilih.getNamaBaju());
        hargabaju.setText("Rp. "+String.valueOf(modelyangdipilih.getHargaBaju()));
        gmbr.setImageResource(modelyangdipilih.getBajuImg());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_deskripsi, container, false);
    }
}