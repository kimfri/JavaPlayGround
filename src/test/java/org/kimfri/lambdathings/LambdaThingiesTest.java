package org.kimfri.lambdathings;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;
import static org.kimfri.lambdathings.LambdaThingies.*;

class LambdaThingiesTest {

    @Test
    void givenName_whenAdding_thenSizeIsOne() {
        //arrange
        LambdaThingies lambdaThingies = new LambdaThingies();
        List<Branch> branchList = new ArrayList<>();

        //act
        lambdaThingies.addNewItemToList("telematic", branchList::add);

        //assert
        assertEquals(1, branchList.size());
    }

    @Test
    void getAStringTrue() {
        LambdaThingies lambdaThingies = new LambdaThingies();
        Optional<String> actualOne = lambdaThingies.getAString(true);
        String actual = actualOne.orElseGet(() -> giveMeAnAlternative());
        System.out.println("true -> actual: " + actual);
    }

    @Test
    void getAStringFalse() {
        LambdaThingies lambdaThingies = new LambdaThingies();
        Optional<String> actualOne = lambdaThingies.getAString(false);
        String actual = actualOne.orElse(giveMeAnAlternative());
        System.out.println("true -> actual: " + actual);

    }

    String giveMeAnAlternative() {
        System.out.println("Inside I'm an alternative");
        return "I'm an alternative";
    }
}