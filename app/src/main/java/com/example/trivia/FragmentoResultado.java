package com.example.trivia;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.trivia.databinding.FragmentFragmentoResultadoBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentoResultado#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentoResultado extends Fragment {

FragmentFragmentoResultadoBinding binding3;
String opcion;
FragmentoPregunta fragmentoPregunta;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentoResultado() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentoResultado.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentoResultado newInstance(String param1, String param2) {
        FragmentoResultado fragment = new FragmentoResultado();
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
        getParentFragmentManager().setFragmentResultListener("rpta", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                opcion = result.getString("seleccion");
                if(opcion=="a"){
                    binding3.txtEquivocaste.setText("Opción incorrecta");
                }
                if(opcion=="b"){
                    binding3.txtEquivocaste.setText("Opción incorrecta");
                }
                if(opcion=="c"){
                    binding3.txtEquivocaste.setText("Correcto");
                }
                if(opcion=="d"){
                    binding3.txtEquivocaste.setText("Opción incorrecta");
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding3=FragmentFragmentoResultadoBinding.inflate(getLayoutInflater());

        binding3.btnOtravez.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentoPregunta = new FragmentoPregunta();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,fragmentoPregunta).commit();
            }
        });
        return binding3.getRoot();
    }
}