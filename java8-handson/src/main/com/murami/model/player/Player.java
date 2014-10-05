package com.murami.model.player;

import lombok.Data;
import lombok.Setter;

@Data
public class Player {

    @Setter
    private String firstName;

    @Setter
    private String lastName;

    @Setter
    private int number;

    @Setter
    private Position position;

    public boolean isPlayable() {
        return position.isPlayable();
    }
}
