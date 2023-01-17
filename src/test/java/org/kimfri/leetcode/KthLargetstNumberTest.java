package org.kimfri.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthLargetstNumberTest {

    KthLargetstNumber kthLargetstNumber = new KthLargetstNumber();
    @Test
    void first() {
        String[] nums = new String[] {"3","6","7","10"};
        final String result = kthLargetstNumber.kthLargestNumber(nums, 4);
        assertEquals("3", result);

    }

    @Test
    void second() {
        String[] nums = new String[] {"2","21","12","1"};
        final String result = kthLargetstNumber.kthLargestNumber(nums, 3);
        assertEquals("2", result);
    }

    @Test
    void third() {
        String[] nums = new String[] {"0","0"};
        final String result = kthLargetstNumber.kthLargestNumber(nums, 2);
        assertEquals("0", result);
    }

    @Test
    void fourth() {
        String[] nums = new String[] {"0","1", "1"};
        final String result = kthLargetstNumber.kthLargestNumber(nums, 2);
        assertEquals("1", result);
    }

    @Test
    void fifth() {
        String[] nums = new String[] {"623986800","3","887298","695","794","6888794705","269409","59930972","723091307","726368","8028385786","378585"};
        final String result = kthLargetstNumber.kthLargestNumber(nums, 11);
        assertEquals("695", result);
    }

    @Test
    void sixth() {
        String[] nums = new String[] {"683339452288515879","7846081062003424420",
                "4805719838","4840666580043","83598933472122816064","522940572025909479",
                "615832818268861533","65439878015","499305616484085","97704358112880133",
                "23861207501102","919346676","60618091901581","5914766072","426842450882100996",
                "914353682223943129","97","241413975523149135","8594929955620533",
                "55257775478129","528","5110809","7930848872563942788","758","4",
                "38272299275037314530","9567700","28449892665","2846386557790827231",
                "53222591365177739","703029","3280920242869904137","87236929298425799136",
                "3103886291279"};
        final String result = kthLargetstNumber.kthLargestNumber(nums, 3);
        assertEquals("38272299275037314530", result);
    }
}