package com.app.inclass8;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;


public class InformationFragment extends Fragment {
    private EditText nameText;
    private EditText emailText;
    private RadioGroup departmentSelection;
    private Student student;
    private Button SubmitInfo;
    private SeekBar seek;
    private String[] mood = new String[1];
    private static final String ARG_PARAM1 = "param1";
    InformationFragmentInterface listner;
    private String[] dept = new String[1];
    ArrayList<Student> studentInfo;


    public InformationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     //* @param param1 Parameter 1.

     * @return A new instance of fragment InformationFragment.
     */
    // TODO: Rename and change types and number of parameters
   /* public static InformationFragment newInstance(Student param1) {
        InformationFragment fragment = new InformationFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, Serializable(param1));
        fragment.setArguments(args);
        return fragment;
    }
*/


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_information, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listner = (InformationFragmentInterface) getActivity();
        /*Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.);
        setSupportActionBar(toolbar);*/
        Student student =new Student();
        nameText = (EditText) getActivity().findViewById(R.id.nameInput);
        emailText =(EditText) getActivity().findViewById(R.id.emailInput);
        departmentSelection = (RadioGroup) getActivity().findViewById(R.id.radioGroup1);
        SubmitInfo =(Button)getActivity().findViewById(R.id.submitButton);



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

        seek = (SeekBar) getActivity().findViewById(R.id.seekBar);

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mood[0] = (progress + "% Positive");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SubmitInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nameText.getText().toString();
                String email = emailText.getText().toString();

                Student student = new Student();
                student.setDepartment(dept[0]);
                student.setEmail(email);
                student.setMood(mood[0]);
                student.setName(name);

                Log.d("Activity3", "Printing Student: " + student.toString());

                Log.d("Activity3", "About to check for missing data");
                if (hasMissingData(student)) {
                    Toast toast = Toast.makeText(InformationFragment.this.getActivity(), "Sorry but you are missing data!", Toast.LENGTH_LONG);
                    Log.d("Activity3", "About to show toast");
                    toast.show();
                }else {
                    Log.d("Activity3", "About to call AddStudentInfo");
                    listner.AddStudentInfo(student);
                }

            }

            private boolean hasMissingData(Student student) {
                if(student.getDepartment() == null || student.getDepartment().length() == 0){
                    return true;
                } else if(student.getEmail() == null || student.getEmail().length() == 0){
                    return true;
                } else if(student.getMood() == null){
                    return true;
                } else if(student.getName() == null){
                    return true;
                } else {
                    return false;
                }

            }
        });


    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }



    public interface InformationFragmentInterface {
        public void AddStudentInfo(Student student);

    }
}
