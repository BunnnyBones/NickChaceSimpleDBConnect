package com.company.controllers;


import com.company.models.Movie;
import com.company.views.CmdLineView;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String title;
        String date;
        String rating;

        CmdLineView view = new CmdLineView();
        InputValidation iv; //gets passed a InputValidation object from CmdLineView's isValid()

        //Database stuff
        DBConnect db = new DBConnect("movies.db");
        //db.createNewDatabase(); There was no real reason to have this, I think
        db.addTables();


        while(true){
            view.promptInput();
            iv = view.isValid();

            //Handling bad inputs, 0 = nothing wrong
            while(!(iv.getErrorCode() == 0)){
                view.promptInput();
                iv = view.isValid();
            }

                         //data has been validated and inputted

            title = view.getMovieInput();
            date = view.getDateInput();
            rating = view.getRatingInput();


            db.addData(title, date, rating);

                         //Data has been put into Database

            String input = view.wishToContinue();
            while(!(input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no"))){
                view.wrongInput();
                input = view.wishToContinue();
            }

            if(input.equalsIgnoreCase("no")){
                break;
            } //else input = yes, and it will repeat the loop to enter more movies
        }


        ArrayList<Movie> theMovies = db.getData();

        view.displayData(theMovies);

    }
}
