package me.billchambers.app;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        get("/", (req, res) -> {

            return "";
        });

        staticFileLocation("/resources");

        post("/", (req, res) -> "POST REQUEST");


        get("/*", (req, res) -> {
            res.redirect("LINK", 302);
            return "";
        });



    }
}