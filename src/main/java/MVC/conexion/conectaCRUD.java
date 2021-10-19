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
        String jdbcURL="jdbc:postgresql://xllyqtckglwhth:377b05640c26e7ed816cd57c15d371a3836c715088a18e11ad62d9a9dd787fc6@ec2-44-199-26-122.compute-1.amazonaws.com:5432/d9codghc888l1q";
        String usuario="xllyqtckglwhth";
        String contra="377b05640c26e7ed816cd57c15d371a3836c715088a18e11ad62d9a9dd787fc6";
        String driver="org.postgresql.Driver";

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
