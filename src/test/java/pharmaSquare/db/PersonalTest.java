package pharmaSquare.db;

import dam.pharmaSquare.db.PharmaSquareDB;
import dam.pharmaSquare.model.Personal;

import java.util.ArrayList;

public class PersonalTest {
    public static void main(String[] args) {
        PharmaSquareDB db = new PharmaSquareDB();

        for (String type : PharmaSquareDB.PERSONAL_SORT_TYPES) {
            System.out.println("--------------------------");
            System.out.println(type);
            printPersonal(db.getPersonal(type));
            System.out.println("--------------------------");
        }
    }


    private static void printPersonal(ArrayList<Personal> personal) {
        for (Personal p : personal) {
            System.out.println(p.getNombre() + "   es     " + p.getCategoria());
        }
    }
}
