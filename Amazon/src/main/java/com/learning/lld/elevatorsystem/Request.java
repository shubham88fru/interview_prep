package com.learning.lld.elevatorsystem;

import lombok.Getter;
import lombok.ToString;

@ToString
public class Request {
    @Getter
    private final int sourceFloor;
    @Getter
    private final int destinationFloor;

    public Request(int sourceFloor, int destinationFloor) {
        this.sourceFloor = sourceFloor;
        this.destinationFloor = destinationFloor;
    }


}
