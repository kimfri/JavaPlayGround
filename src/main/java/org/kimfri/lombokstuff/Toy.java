package org.kimfri.lombokstuff;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.With;

import java.util.List;

@Value
@Builder
@With
public class Toy {
    String name;
    String type;
    @Singular
    List<String> colors;
}
