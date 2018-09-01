package com.example.ay.teacher.mainfour;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.ay.teacher.R;

import java.util.ArrayList;

import me.yaoandy107.ntut_timetable.CourseTableLayout;
import me.yaoandy107.ntut_timetable.model.CourseInfo;
import me.yaoandy107.ntut_timetable.model.StudentCourse;

public class timetable extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timetable);

        CourseTableLayout courseTable = findViewById(R.id.courseTable);
        StudentCourse studentCourse = new StudentCourse();
        ArrayList<CourseInfo> courseInfoList = new ArrayList<>();

        // Add course1 - sample1
        CourseInfo courseInfo1 = new CourseInfo();
        courseInfo1.setName("Course 1");
        courseInfo1.setCourseTime("1 2", "", "4", "", "", "", "");
        courseInfoList.add(courseInfo1);

        // Add course2 - sample2
        CourseInfo courseInfo2 = new CourseInfo();
        courseInfo2.setName("Course 2");
        courseInfo2.setCourseTime(new String[]{"4", "5", "3", "6 7 8", "", "", ""});
        courseInfoList.add(courseInfo2);

        // Set timetable
        studentCourse.setCourseList(courseInfoList);
        courseTable.setStudentCourse(studentCourse);
    }
}
