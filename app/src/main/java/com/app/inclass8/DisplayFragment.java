package com.app.inclass8;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class DisplayFragment extends Fragment {


    private Student student;
    private TextView displayMood;
    private TextView displayDepartment;
    private TextView displayName;
    private TextView displayEmail;
    private ImageButton editNameBtn;
    private ImageButton editEmailBtn;
    private ImageButton editDeptBtn;
    private ImageButton editMoodBtn;

    DisplayFragmentInterface listner;

    public DisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listner = (DisplayFragmentInterface) getActivity();

        student = listner.getstudentInfo();
        //student = (Student) intent.getSerializableExtra(MainActivity.STUDENT_KEY);

        Log.d("Activity3", "Student Received in display fragment" + student.toString());

        displayName = (TextView) getActivity().findViewById(R.id.DisplayNamebox);
        displayEmail = (TextView) getActivity().findViewById(R.id.DisplayEmailbox);
        displayDepartment = (TextView) getActivity().findViewById(R.id.DisplayDeparmentbox);
        displayMood = (TextView) getActivity().findViewById(R.id.DisplayMoodbox);
        editNameBtn = (ImageButton) getActivity().findViewById(R.id.editNameImageButton);
        editEmailBtn = (ImageButton) getActivity().findViewById(R.id.editEmailImageButton);
        editDeptBtn = (ImageButton) getActivity().findViewById(R.id.editDeptImageButton);
        editMoodBtn = (ImageButton) getActivity().findViewById(R.id.editMoodImageButton);
        displayName.setText(student.getName());
        displayEmail.setText(student.getEmail());
        displayDepartment.setText(student.getDepartment());
        displayMood.setText(student.getMood());

        editNameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Activity3", "Edit name button clicked!" );
                String str = "Name";
                listner.EditStudentInfo(str);
            }
        });

        editEmailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Activity3", "Edit Email button clicked!" );
                String str ="Email";
                listner.EditStudentInfo(str);
            }
        });

        editDeptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Activity3", "Edit Dept button clicked!" );
                String str = "Department";
                 listner.EditStudentInfo(str);
            }
        });

        editMoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Activity3", "Edit Mood button clicked!" );
                String str = "Mood";
                 listner.EditStudentInfo(str);
            }
        });
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    public interface DisplayFragmentInterface {
        // TODO: Update argument type and name
        Student getstudentInfo();
        void EditStudentInfo(String str);
        Student getUpdatedStudentInfo();


    }
}
