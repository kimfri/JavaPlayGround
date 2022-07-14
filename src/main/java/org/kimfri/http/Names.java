package org.kimfri.http;

import java.util.ArrayList;
import java.util.List;

public class Names {
    public static void main(String[] args) {
        Names names = new Names();
        names.doit();
    }

    private void doit() {
        final MyHttp myHttp = new MyHttp();
        final List<String> names = getNames();
        final String url = "https://api.agify.io?name=";
        names.stream()
                .map(name -> url + name)
                .forEach(myHttp::getGetHttp);
    }

    private List<String> getNames() {
        List<String> names = new ArrayList<>();
        names.add("Kim");
        names.add("Maria");
        names.add("Wille");
        names.add("Theo");
        names.add("Freddie");
        names.add("Anna");
        names.add("Carl");
        names.add("Anders");
        names.add("Elisabeth");
        names.add("Birgitt");
        names.add("Bengt");
        names.add("Anders");
        names.add("Birgitta");
        names.add("Fredrik");
        names.add("Ebba");
        names.add("Axel");
        names.add("Isac");
        return names;
    }
}
