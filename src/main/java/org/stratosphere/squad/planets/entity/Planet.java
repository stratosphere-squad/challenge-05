package org.stratosphere.squad.planets.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Planet {
    @NotNull
    private String name;

    @NotNull
    private String description;

}
