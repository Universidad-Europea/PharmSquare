package dam.db;

import dam.exception.InvalidDataException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class AccessDB {
    private String driver;
    private String url;

    public AccessDB(String dbFile) {
        String error = null;

        Properties properties = new Properties();
        InputStream is = null;

        try {
            is = new FileInputStream(dbFile);
            properties.load(is);

            if (!validPropertiesFile(properties))
                throw new InvalidDataException("El archivo properties no es válido.");
            this.driver = properties.getProperty("DRIVER");

            String[] paths = properties.getProperty("PATHS").split(":");
            this.url = null;

            Path path;
            for (String p : paths) {
                if (fileExist(p + properties.getProperty("DB_NAME"))) {
                    this.url = properties.getProperty("URL_TYPE") + p + properties.getProperty("DB_NAME");
                    break;
                }
            }
            if (this.url == null)
                throw new InvalidDataException("BBDD no encontrada.");
        }
        catch (FileNotFoundException e) {
            error = "El archivo " + dbFile + " no existe.";
        }
        catch (IOException e) {
            error = "No ha sido posible leer el archivo " + dbFile;
        }
        catch (InvalidDataException e) {
            error = e.getMessage();
        }
        finally {
            try {
                if (is != null) is.close();
            }
            catch (IOException e) {
                error = "Error cerrando el archivo " + dbFile;
            }
        }

        if (error != null)
            throw new InvalidDataException(error);
    }

    /**
     * Obtiene la conexión con la base de datos.
     * @return Connection object con la conexión.
     * @throws ClassNotFoundException Si no se encontró la clase con el driver especificado.
     * @throws SQLException Si la base de datos tiene algún problema obteniendo la conexión.
     */
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        return DriverManager.getConnection(url);
    }

    /**
     * Verifica que todos los campos necesarios para la clase se encuentran en el archivo.properties.
     * @param properties Archivo properties ya listo para su lectura.
     * @return True si es válido, false en caso contrario.
     */
    private static boolean validPropertiesFile(Properties properties) {
        final String[] requiredFields = {"DRIVER", "URL_TYPE", "DB_NAME", "PATHS"};
        for (String s : requiredFields)
            if (properties.getProperty(s) == null)
                return false;
        return true;
    }

    // Help functions

    /**
     * Verifica que el archivo dado como URL existe.
     * @param path Localización del archivo.
     * @return El resultado de la comprobación.
     */
    private static boolean fileExist(String path) {
        Path pathFile = Path.of(path);
        return Files.exists(pathFile);
    }
}

/*

package dam.db;

import dam.exception.InvalidDataException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class AccessDB {
    private static final String DRIVER = "org.sqlite.JDBC";
    private static final String URL_TYPE = "jdbc:sqlite:";
    private String url;

    public AccessDB(String dbFile) {
        String db;
        Properties properties = new Properties();
        InputStream is = null;

        try {
            is = new FileInputStream(dbFile);
            properties.load(is);

            if (!DRIVER.equals(properties.getProperty("DRIVER")))
                throw new InvalidDataException("Invalid database: driver not valid.");
            if (!URL_TYPE.equals(properties.getProperty("URL_TYPE")))
                throw new InvalidDataException("Invalid database: url type not valid.");
            if (properties.getProperty("PATH") == null)
                throw new InvalidDataException("Invalid database: path not valid.");
            String[] path = properties.getProperty("PATH").split(":");
            for (String s : path)

            db = properties.getProperty("DB");
            url = URL_TYPE + db;
        }
        catch (FileNotFoundException e) {
            throw new InvalidDataException("File not found: " + dbFile);
        }
        catch (IOException e) {
            throw new InvalidDataException("Error reading file: " + dbFile);
        }
        finally {
            try {
                if (is != null) is.close();
            }
            catch (IOException e) {
                throw new InvalidDataException("Error closing file: " + dbFile);
            }
        }

    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(url);
    }
}

 */
