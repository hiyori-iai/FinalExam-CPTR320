package com.example.finalexam;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Student implements Parcelable{

    private int sid;
    private String firstName, lastName, major;

    public Student (String firstName, String lastName, int sid, String major){
        this.firstName = firstName;
        this.lastName = lastName;
        this.sid = sid;
        this.major = major;
    }
    protected Student(Parcel in) {
        sid = in.readInt();
        firstName = in.readString();
        lastName = in.readString();
        major = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public int getSid() {
        return sid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMajor() {
        return major;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(sid);
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(major);
    }
}
