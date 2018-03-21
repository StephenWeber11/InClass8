package com.app.inclass8;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends FragmentActivity implements InformationFragment.InformationFragmentInterface,
        DisplayFragment.DisplayFragmentInterface, EditFragment.EditFragmentInterface {

    Student studentInfo;
    String editinfo= "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //studentInfo =new ArrayList<>();
        getSupportFragmentManager().beginTransaction().add(R.id.layout_container, new InformationFragment() ,"Information_Fragment").commit();

    }


    public void AddStudentInfo(Student student){
        Log.d("Activity3", "inside AddStudentInfo");

        studentInfo =student;
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.layout_container, new DisplayFragment(), "Display_fragment")
                .addToBackStack(null)
                .commit();



    }

    @Override
    public Student getstudentInfo() {
        return studentInfo;
    }

    @Override
    public void EditStudentInfo(String str) {
        editinfo = str;
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.layout_container, new EditFragment(), "Edit_Name_fragment")
                .addToBackStack(null)
                .commit();

    }

    @Override
    public Student getUpdatedStudentInfo() {
        return studentInfo;
    }


    @Override
    public String getEditinfoString() {
        return editinfo;
    }

    @Override
    public Student updatedInformation(Student student) {
        studentInfo = student;

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.layout_container, new DisplayFragment(), "Display_fragment")
                .addToBackStack(null)
                .commit();

        return studentInfo;
    }
}
