package com.example.trivia;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.trivia.databinding.FragmentFragmentoNombreBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentoNombre#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentoNombre extends Fragment {

private FragmentFragmentoNombreBinding binding1;
FragmentoPregunta fragmentoPregunta;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentoNombre() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentoNombre.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentoNombre newInstance(String param1, String param2) {
        FragmentoNombre fragment = new FragmentoNombre();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding1 = FragmentFragmentoNombreBinding.inflate(getLayoutInflater());

        binding1.btnComenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentoPregunta = new FragmentoPregunta();
                Bundle bundle = new Bundle();
                String nombre = "";
                nombre=binding1.txtNombre.getText().toString();

                if(nombre.isEmpty()){Toast.makeText(getActivity(), "Escribe tu nombre", Toast.LENGTH_SHORT).show();

                }else{bundle.putString("nombre",nombre);
                      getParentFragmentManager().setFragmentResult("key", bundle);
                      getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragmentoPregunta).commit();}
            }
        });
        return binding1.getRoot();
    }
}