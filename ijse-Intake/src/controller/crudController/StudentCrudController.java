package controller.crudController;


import utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentCrudController {

    public static ArrayList<String> getAllIds() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT student_Id FROM student");
        ArrayList<String> ids= new ArrayList<>();
        while (result.next()){
            ids.add(result.getString(1));
        }
        return ids;
    }
}
