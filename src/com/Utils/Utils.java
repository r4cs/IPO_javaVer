package com.Utils;

import com.entity.Background;
import com.entity.Boundary;

import java.util.ArrayList;
import java.util.Arrays;

public class Utils {

    private Position offset = new Position(-740, -640);

    private int velocity;

    private Arrays sprites;

    private Background background;
    private Boundary boundaries;

    private ArrayList<Object> movables = new ArrayList<>(Arrays.asList(background, boundaries));




}
