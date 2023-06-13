package com.example.pruebafragmento;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FourFragment extends Fragment {

    private Button backButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_four, container, false);

        // Obtener una referencia al botón de regreso
        backButton = rootView.findViewById(R.id.backButton);

        // Establecer un OnClickListener para el botón de regreso
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegar de regreso al SecondFragment
                Navigation.findNavController(v).navigateUp();
            }
        });

        return rootView;
    }
}
