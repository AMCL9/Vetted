package com.example.vetted.views;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.vetted.FragmentController.Fragmentinterface;
import com.example.vetted.R;
import com.example.vetted.SharedPreferences.BusinessIdSharedPreferences;
import com.example.vetted.modells.Businesses;

import java.util.ArrayList;
import java.util.Objects;


public class MainFragment extends Fragment {
    private Button mapFragmentButton;
    private ImageView imageView;
    BusinessIdSharedPreferences businessIdSharedPreferences;

    private static final String TAG = "WHY REUNULL?";
    public static final String VETS = "veterinarian";
    public static final String EMERGENCY = "emergency";
    public static final String PET_INSURANCE = "pet insurance";
    public static final String HOLISTIC = "animal holistic";
    public static final String HOSPICE = "pet hospice";
    public static final String PET_THERAPY = "pet therapy";
    public static final String HOSPITAL = "animal hospital";
    public static final String SERVICES = "petservices";
    public static final String TRAINING = "pet training";
    public static final String TRANSPORTATION = "animal transportation";
    public static final String AQUARIUM = "aquarium services";
    public static final String STORE = "pet store";


    private static final String CHOICEVET = "veterinarians";
    private static final String CHOICEEMS = "emergency pet services";
    private static final String CHOICEINSURANCE = "pet insurance";
    private static final String CHOICETHERAPY = "pet therapy";
    private static final String CHOICEHOLISTIC = "holistic pet care";
    private static final String CHOICEHOSPICE = "hospice";
    private static final String CHOICEHOSPITAL = "animal hospitals";
    private static final String CHOICESERVICES = "general pet services";
    private static final String CHOICETRAINING = "animal training";
    private static final String CHOICETRANSPORTATION = "animal transportation";
    private static final String CHOICEAQUARIUM = "aquarium services";
    private static final String CHOICESTORES = "pet Stores";

    public static String userChoice;




    private Fragmentinterface mListener;

    public MainFragment() {

    }


    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

//            businessIdSharedPreferences = new BusinessIdSharedPreferences(Objects.requireNonNull(getActivity()).getSharedPreferences(BusinessIdSharedPreferences.USER_INPUT, Context.MODE_PRIVATE));


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Spinner servicesSpinner = view.findViewById(R.id.service_spinner);
        final Switch switchtoggle = view.findViewById(R.id.switch1);
        imageView = view.findViewById(R.id.animal_main_view);
        mapFragmentButton = view.findViewById(R.id.go);
        mapFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userChoice = String.valueOf(servicesSpinner.getSelectedItem()).toLowerCase();
                Log.d(TAG, "USERCHOICEonClick: " + userChoice);



//                businessIdSharedPreferences.saveUserInput(getPassedTerm(userChoice));
                mListener.update(getPassedTerm(userChoice));
                mListener.passBusinessSearch();
                Log.d(TAG, "onClick:" + getPassedTerm(userChoice));






            }
        });
        Glide.with(this)
                .load(R.drawable.finalvettedtransroundcopy)
                .fitCenter()
                .circleCrop()
                .into(imageView);

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Fragmentinterface) {
            mListener = (Fragmentinterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }


    }

    @Override
    public void onDetach() {
        super.onDetach();
//        mListener = null;
    }


    public String getPassedTerm(String choice) {
        String passedTerm = "";

        if (choice.equals(CHOICEVET)) {
            passedTerm = VETS;
        }
        if (choice.equals(CHOICEEMS)) {
            passedTerm = EMERGENCY;
        }
        if (choice.equals(
                CHOICEINSURANCE)) {
            passedTerm = PET_INSURANCE;
        }
        if (choice.equals(CHOICETHERAPY)) {
            passedTerm = PET_THERAPY;
        }
        if (choice.equals(CHOICEHOLISTIC)) {
            passedTerm = HOLISTIC;
        }
        if (choice.equals(CHOICEHOSPICE)) {
            passedTerm = HOSPICE;
        }
        if (choice.equals(CHOICEHOSPITAL)) {
            passedTerm = HOSPITAL;
        }
        if (choice.equals(CHOICESERVICES)) {
            passedTerm = SERVICES;
        }
        if (choice.equals(CHOICETRAINING)) {
            passedTerm = TRAINING;
        }
        if (choice.equals(CHOICETRANSPORTATION)) {
            passedTerm = TRANSPORTATION;
        }
        if (choice.equals(CHOICEAQUARIUM)) {
            passedTerm = AQUARIUM;
        }
        if (choice.equals(CHOICESTORES)) {
            passedTerm = STORE;
        }


        Log.d(TAG, "getPassedTerm: " + passedTerm);
        return passedTerm;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        userChoice = null;
    }
}
