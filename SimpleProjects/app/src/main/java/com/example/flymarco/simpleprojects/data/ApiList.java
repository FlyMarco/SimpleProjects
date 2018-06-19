package com.example.flymarco.simpleprojects.data;

import java.util.Arrays;
import java.util.List;

public class ApiList {

    public List<BaseApi> getData() {
        return sData;
    }

    public BaseApi getCurrentData() {
        if (INDEX_START_ACTIVITY < 0) {
            INDEX_START_ACTIVITY = 0;
        } else if (INDEX_START_ACTIVITY >= sData.size()) {
            INDEX_START_ACTIVITY = sData.size() - 1;
        }

        return sData.get(INDEX_START_ACTIVITY);
    }

    private static int INDEX_START_ACTIVITY = 0;

    private static final List<BaseApi> sData = Arrays.asList(new BaseApi[]{

    });
}
