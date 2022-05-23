package org.kimfri.json.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Meta {
    private String uuid;
    private Timestamp timestamp;
}
