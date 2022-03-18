package org.kimfri.di.moretests;

import com.google.inject.Inject;

import java.util.Arrays;
import java.util.List;

public class MyWorker {

    private final MyDatas myDatas;

    @Inject
    public MyWorker(MyDatas myDatas) {
        this.myDatas = myDatas;
    }

    public void parse() {
        System.err.println("Inside parse");
        myDatas.addItem(new MyData("id_1", "description"));

    }

    public List<List<List<MyData>>> getMyDatas() {
        return Arrays.asList(myDatas.getAllData());
    }
}
