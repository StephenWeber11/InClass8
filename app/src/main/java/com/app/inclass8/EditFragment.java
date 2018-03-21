package com.app.inclass8;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;


public class EditFragment extends Fragment {
    EditFragmentInterface listner;
    Student student;
    String editinfo;



    public EditFragment() {
        // Required empty public constructor
    }


    public static EditFragment newInstance() {
       return null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listner = (EditFragmentInterface) getActivity();
        editinfo = listner.getEditinfoString();
        student = listner.getstudentInfo();

        if(editinfo=="Mood") {
            final SeekBar seek = getActivity().findViewById(R.id.seekBar);
            seek.setVisibility(View.VISIBLE);
            final String[] mood = new String[1];
            seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    mood[0] = (progress + "% Positive");

                    student.setMood(mood[0]);
                }
                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });

            Button button = getActivity().findViewById(R.id.save_button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listner.updatedInformation(student);
                }
            });
        }

        else if(editinfo=="Department"){
            final RadioGroup departmentSelection = getActivity().findViewById(R.id.radioGroup1);
            departmentSelection.setVisibility(View.VISIBLE);
            final String[] dept = new String[1];

            departmentSelection.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    if(checkedId == R.id.SISradioButton){
                        dept[0] = "SIS";
                    } else if(checkedId == R.id.CSradioButton){
                        dept[0] = "CS";
                    } else if(checkedId == R.id.BIOradioButton){
                        dept[0] = "BIO";
                    } else {
                        dept[0] = "Other";
                    }
                }
            });

            Button button =  getActivity().findViewById(R.id.save_button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    student.setDepartment(dept[0]);
                    listner.updatedInformation(student);
                }
            });
        }

        else if(editinfo=="Name"){
            final EditText nameText = getActivity().findViewById(R.id.NameUpdate);
            nameText.setVisibility(View.VISIBLE);

            Button button = getActivity().findViewById(R.id.save_button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String name = nameText.getText().toString();
                    student.setName(name);
                    listner.updatedInformation(student);
                }
            });
        }

        else if(editinfo=="Email"){
            final EditText emailText = getActivity().findViewById(R.id.EmailUpdate);
            emailText.setVisibility(View.VISIBLE);

            Button button = getActivity().findViewById(R.id.save_button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String email = emailText.getText().toString();
                    student.setEmail(email);
                    listner.updatedInformation(student);

                }
            });
        }

        else {

           // Toast toast = Toast.makeText(EditFragment.this, "OOOPS! Something went wrong! Back to Home!", Toast.LENGTH_LONG);
            //toast.show();

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    public interface EditFragmentInterface {
        public String getEditinfoString();
        public Student updatedInformation(Student student);
        public Student getstudentInfo();

    }
}
