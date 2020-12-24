package com.example.session1.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.session1.R;
import com.example.session1.WaitActivity;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    BottomSheetDialog bottomSheetDialog;

    View car1;
    View car2;
    View car3;

    Button book;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);


        View root = inflater.inflate(R.layout.fragment_home, container, false);

        bottomSheetDialog = new BottomSheetDialog(getContext());
        bottomSheetDialog.setContentView(R.layout.home_bottomsheet);

        car1 = root.findViewById(R.id.car1);
        car2 = root.findViewById(R.id.car2);
        car3 = root.findViewById(R.id.car3);

        car1.setOnClickListener(car_onclick);
        car2.setOnClickListener(car_onclick);
        car3.setOnClickListener(car_onclick);

        book = bottomSheetDialog.findViewById(R.id.b_book);

        book.setOnClickListener(view -> {
            Intent intent = new Intent(getContext(), WaitActivity.class);
            startActivity(intent);
        });

        return root;
    }

    View.OnClickListener car_onclick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            bottomSheetDialog.show();
        }
    };
}