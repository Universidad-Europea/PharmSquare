package dam.pharmaSquare.db;

import dam.db.AccessDB;

public class PharmaSquareDB extends AccessDB {
    private static final String FILE_PATH = "pharmaSquareDB.properties";

    public PharmaSquareDB() {
        super(FILE_PATH);
    }
}
