package datos;

import domain.PC;

import java.sql.*;
import java.util.*;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;

public class PcDAO {

    private static final String SELECT = "SELECT idPC, procesador, RAM, TargetaVideo FROM pc";
    private static final String INSERT = "INSERT INTO pc (procesador, RAM, TargetaVideo) VALUES (?, ?, ?)";
    private static final String DELETE = "DELETE FROM pc WHERE idpc = ? ";
    private static final String UPDATE = "UPDATE pc SET procesador = ?, RAM = ?, TargetaVideo = ? WHERE idpc = ?";

    public List<PC> Seleccionar() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PC pc = null;
        List<PC> pcS = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {

                int idPC = rs.getInt("idPC");
                String procesador = rs.getString("procesador");
                String RAM = rs.getString("RAM");
                String targetaVideo = rs.getString("TargetaVideo");

                pc = new PC(idPC, procesador, RAM, targetaVideo);

                pcS.add(pc);

            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {

            try {
                Conexion.close(conn);
                Conexion.close(stmt);
                Conexion.close(rs);
            } catch (SQLException e) {

                e.printStackTrace(System.out);

            }


        }

        return pcS;
    }

    public int Registro (PC pc){

        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;

        try {

            conn = getConnection();
            stmt = conn.prepareStatement(INSERT);

            stmt.setString(1, pc.getProcesador());
            stmt.setString(2, pc.getRAM());
            stmt.setString(3, pc.getTargetaVideo());

            registro = stmt.executeUpdate();

            System.out.println("La entidad se ha registrado correctamente");

        } catch (SQLException e) {

            e.printStackTrace(System.out);

        }
        finally {

            try {

                close(stmt);
                close(conn);

            } catch (SQLException e) {

                e.printStackTrace(System.out);

            }


        }


        return registro;
    }

    public int Delete (PC pc){

        Connection conn = null;
        PreparedStatement stmt = null;
        int eliminado = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(DELETE);

            stmt.setInt(1, pc.getIdPC());

            eliminado = stmt.executeUpdate();

            System.out.println("El registro " + pc.getIdPC() + " ah sido borrado");

        } catch (SQLException e) {

            e.printStackTrace(System.out);

        }
        finally {

            try {
                close(stmt);
                close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }

        }

        return eliminado;
    }

    public int Update (PC pc){

        Connection conn = null;
        PreparedStatement stmt = null;
        int actualizado = 0;

        try {

            conn = getConnection();
            stmt = conn.prepareStatement(UPDATE);

            stmt.setString(1, pc.getProcesador());
            stmt.setString(2, pc.getRAM());
            stmt.setString(3, pc.getTargetaVideo());
            stmt.setInt(4, pc.getIdPC());

            actualizado = stmt.executeUpdate();

            System.out.println("el pc numero " + pc.getIdPC() + " se ha actulizado correctamente");

        } catch (SQLException e) {

            e.printStackTrace(System.out);

        }
        finally {

            try {

                close(stmt);
                close(conn);

            } catch (SQLException e) {

                e.printStackTrace(System.out);

            }

        }


        return actualizado;
    }

}
