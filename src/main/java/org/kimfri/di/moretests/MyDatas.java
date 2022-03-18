package org.kimfri.di.moretests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyDatas {
    private List<MyData> myDatas = new ArrayList<>();

    public MyDatas() {
    }

    boolean addItem(MyData myData) {
        return myDatas.add(myData);
    }

    List<List<MyData>> getAllData() {
        return Arrays.asList(myDatas);
    }
}
