package dam.pharmaSquare.db;

import dam.dataValidation.DataValidation;
import dam.db.AccessDB;
import dam.db.SQLiteQuery;
import dam.exception.InvalidDataException;
import dam.pharmaSquare.model.Personal;
import dam.pharmaSquare.model.persistencia.PPersonal;
import dam.pharmaSquare.view.consultarPersonal.VCheckPersonal;

import java.util.ArrayList;

public class PharmaSquareDB extends AccessDB {
    private static final String FILE_PATH = "pharmaSquareDB.properties";

    /**
     * Criterios de ordenación que pueden tener los empleados en el menu VCheckPersonal
     */
    public static final String[] PERSONAL_FILTERS = {"A-Z", "Z-A", "EMPLEADO", "ADMINISTRATIVO"};

    public PharmaSquareDB() {
        super(FILE_PATH);
    }

    /**
     * Función que permite obtener una lista de personal siguiendo el criterio definido por PERSONAL_FILTERS
     * @param type Filtro a aplicar.
     * @return ArrayList con todos los empleados requeridos.
     * @throws InvalidDataException si el typo no está en el array.
     */
    public ArrayList<Personal> getPersonal(String type) throws InvalidDataException {
        /**
         * Restricciones que aplicar según el tipo de selección indicado.
         * Los valores ya están definidos ya que este paso no genera una inyección de SQL.
         */
        final String[] RESTRICTIONS = {
                String.format("ORDER BY %s ASC;", PPersonal.NOMBRE),
                String.format("ORDER BY %s DESC;", PPersonal.NOMBRE),
                String.format("WHERE %s = '%s';", PPersonal.CATEGORIA, PPersonal.CATEGORIAS_CHK[0]),
                String.format("WHERE %s = '%s';", PPersonal.CATEGORIA, PPersonal.CATEGORIAS_CHK[1])
        };

        if (!DataValidation.isStringIn(type, PERSONAL_FILTERS))
            throw new InvalidDataException("El criterio de búsqueda elegido no es conocido.");

        int index;
        for (index = 0; index < PERSONAL_FILTERS.length; index++)
            if (PERSONAL_FILTERS[index].equals(type))
                break;

        String query = String.format(
          "SELECT * FROM %s %s",
            PPersonal.TABLE_NAME,
            RESTRICTIONS[index]
        );

        return sqlite2personal(SQLiteQuery.get(this, 4, query));
    }

    private static ArrayList<Personal> sqlite2personal(ArrayList<Object[]> data) {
        ArrayList<Personal> personal = new ArrayList<>();
        Personal p;
        for (Object[] r : data) {
            p = new Personal(
                    (String) r[0], // DNI
                    (String) r[1], // Nombre
                    (String) r[2], // Categoria
                    (String) r[3] // Passwd
            );
            personal.add(p);
        }
        return personal;
    }
}
