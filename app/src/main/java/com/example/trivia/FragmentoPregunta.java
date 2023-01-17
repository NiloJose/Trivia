package com.example.trivia;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.trivia.databinding.FragmentFragmentoNombreBinding;
import com.example.trivia.databinding.FragmentFragmentoPreguntaBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentoPregunta#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentoPregunta extends Fragment {

String nombre;
FragmentFragmentoPreguntaBinding binding2;
FragmentoResultado fragmentoResultado;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentoPregunta() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentoPregunta.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentoPregunta newInstance(String param1, String param2) {
        FragmentoPregunta fragment = new FragmentoPregunta();
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
        getParentFragmentManager().setFragmentResultListener("key", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                nombre = result.getString("nombre");
                binding2.txtSaludo.setText("Hola "+ nombre+"!! te invito a responder la siguiente pregunta");
    }});}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding2 = FragmentFragmentoPreguntaBinding.inflate(getLayoutInflater());


        binding2.btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentoResultado = new FragmentoResultado();
                Bundle bundle = new Bundle();
                String seleccion = "";

                if (binding2.rb1.isChecked() == true) {
                    seleccion = "a";
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragmentoResultado).commit();
                    ;
                } else if (binding2.rb2.isChecked() == true) {
                    seleccion = "b";
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragmentoResultado).commit();
                    ;
                } else if (binding2.rb3.isChecked() == true) {
                    seleccion = "c";
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragmentoResultado).commit();
                    ;
                } else if (binding2.rb4.isChecked() == true) {
                    seleccion = "d";
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragmentoResultado).commit();
                    ;
                } else
                    Toast.makeText(getActivity(), "Selecciona una respuesta", Toast.LENGTH_SHORT).show();

                bundle.putString("seleccion", seleccion);
                getParentFragmentManager().setFragmentResult("rpta", bundle);
            }
        });
        return binding2.getRoot();
    }
}