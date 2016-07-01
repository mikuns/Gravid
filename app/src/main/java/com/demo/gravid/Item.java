package com.demo.gravid;

import android.os.Parcel;
        import android.os.Parcelable;

public class Item implements Parcelable{

//    DbBackend dbBackend;
//    String[] terms = dbBackend.Questions();

    public String question;
    public String answer;
    public boolean isExpanded;


    public Item(){}

    public Item(Parcel in){

        question = in.readString();
        answer = in.readString();
        isExpanded = in.readInt() == 1;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeString(answer);
        dest.writeInt(isExpanded ? 1 : 0);
    }

    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>(){
        @Override
        public Item createFromParcel(Parcel source) {
            return new Item(source);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}
