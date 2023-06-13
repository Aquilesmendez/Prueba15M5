package com.example.pruebafragmento;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.pruebafragmento.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private RadioGroup radioGroup;

    private static final int CORRECT_ANSWER = R.id.option2RadioButton;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView questionTextView = binding.questionTextView;
        radioGroup = binding.radioGroup;
        Button submitButton = binding.submitButton;

        questionTextView.setText(getString(R.string.question_text));

        // Obtener el nombre del argumento

        String name = getArguments().getString("name");
        if (name != null) {
            TextView nameTextView = binding.nameTextView;
            nameTextView.setText(name);
        }

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();

                // Check if the answer is correct
                boolean isCorrect = selectedId == CORRECT_ANSWER;

                Bundle bundle = new Bundle();
                bundle.putBoolean("isCorrect", isCorrect);
                bundle.putString("name", name); // Pasar el nombre al TresFragment

                if (isCorrect) {
                    Navigation.findNavController(v).navigate(R.id.action_SecondFragment_to_ThreeFragment, bundle);
                } else {
                    Navigation.findNavController(v).navigate(R.id.action_SecondFragment_to_FourFragment, bundle);
                }
            }

        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
