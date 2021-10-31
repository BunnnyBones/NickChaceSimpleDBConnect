package com.company.controllers;

public class InputValidation {

    private int errorCode;

    //Since the controllers process and handle data I thought input validation belonged here, and not in views or models
    public int validateInput(String title, String date, String rating){

        //Probably redundant since 'nextLine()' in 'promptInput()' in CmdLineView should only return Strings
        //...but this does validate that the inputs are Specifically String variables
        if(!(title instanceof String)){
            return errorCode = 1; //Error code 1
        }

        if(!(date instanceof String)){
            return errorCode = 2; //Error code 2
        }

        if(!(rating instanceof String)){
            return errorCode = 3; //Error code 3
        }

        return errorCode = 0; //No issues
    }

    public int getErrorCode() {
        return errorCode;
    }
}
