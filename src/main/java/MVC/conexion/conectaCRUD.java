package MVC.conexion;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@RequestMapping("/conectaCRUD")
@WebServlet(name = "Servlet", value = "/Servlet")
public class conectaCRUD extends HttpServlet {
    @Override
    @RequestMapping("/conecta2")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jdbcURL="jdbc:mysql://localhost:3306/gestionpedidoscrud?useSSL=false";
        String usuario="root";
        String contra="v1234567";
        String driver="com.mysql.cj.jdbc.Driver";

        try {
            PrintWriter out=response.getWriter();
            out.print("Nombre de la BBDD: "+jdbcURL);
            Class.forName(driver);
            Connection miCon= DriverManager.getConnection(jdbcURL,usuario,contra);
            out.print("Conectado");
            miCon.close();


        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
