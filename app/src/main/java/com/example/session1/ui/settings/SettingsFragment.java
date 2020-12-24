package com.example.session1.ui.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.session1.R;
import com.example.session1.ui.history.HistoryViewModel;

public class SettingsFragment extends Fragment {

    Button exit;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_settings, container, false);

        exit = root.findViewById(R.id.b_exit);

        exit.setOnClickListener(view -> {
            getActivity().finish();
        });

        return root;
    }
}
