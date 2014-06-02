package com.tanabe.dh.ui.view;

/**
 * Created by BTanabe on 5/28/2014.
 */
public class CommandLineView implements UserInterface {

    @Override
    public void printError(String errorMessage) {
        System.err.println(errorMessage);
    }

    @Override
    public void printStatusUpdate(String errorMessage) {
        System.out.println(errorMessage);
    }
}
