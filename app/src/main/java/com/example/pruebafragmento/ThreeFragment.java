package com.example.pruebafragmento;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class ThreeFragment extends Fragment {

    private Button backButton;
    private TextView nameTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_three, container, false);

        nameTextView = rootView.findViewById(R.id.nameTextView);

        // Obtener el nombre del argumento
        String name = getArguments().getString("name");
        if (name != null) {
            nameTextView.setText(name);
        }

        backButton = rootView.findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigateUp();
            }
        });

        return rootView;
    }
}
