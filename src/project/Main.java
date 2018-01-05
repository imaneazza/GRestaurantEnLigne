package project;


import Classes.*;
import Metier.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws SQLException {
        MetierRole metr=new MetierRole();
        for(Role r: metr.getAll()){
            System.out.println(r.toString());
        }
    }
}
