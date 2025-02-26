package com.example.schoolproject;

import static com.example.schoolproject.HelperDB.USER_NAME;
import static com.example.schoolproject.HelperDB.USER_PHONE;
import static com.example.schoolproject.HelperDB.USER_PWD;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        Button btIntroActivity = view.findViewById(R.id.btIntroActivity);
        EditText etUserNameLogin = view.findViewById(R.id.etUserNameLogin);
        EditText etPwdLogin = view.findViewById(R.id.etPwdLogin);
        Button btLogin = view.findViewById(R.id.btLogin);
        Button btRegisterFragment = view.findViewById(R.id.btRegisterFragment);

        User user = new User("", "");

        btLogin.setOnClickListener(new View.OnClickListener() {
            // Logs-in the user (NOT DONE YET)
            @Override
            public void onClick(View v) {
                user.setUserName(etUserNameLogin.getText().toString());
                user.setUserPwd(etPwdLogin.getText().toString());

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        btIntroActivity.setOnClickListener(new View.OnClickListener() {
           // Navigates to the Intro screen
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), IntroActivity.class);
                startActivity(intent);
            }
        });

        btRegisterFragment.setOnClickListener(new View.OnClickListener() {
            // Navigates to the Register screen
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, new RegisterFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }

    HelperDB helperDB = new HelperDB(getActivity());
}