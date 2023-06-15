package Controlador;

import Datos.arbitro_DAO;
import Datos.jugador_DAO;
import Modelo.arbitro_JB;
import Modelo.jugador_JB;
import Modelo.participante_JB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "participante_Servlet", urlPatterns = {"/participante_Servlet"})
public class participante_Servlet extends HttpServlet {

    participante_JB partiJB = new participante_JB();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //crear instancias para cualquiera de los casos
            jugador_DAO jugaDAO = new jugador_DAO();
            arbitro_DAO arbiDAO = new arbitro_DAO();

            //obtengo cuál es la instancia que se va a crear
            String IsJugador = request.getParameter("jugador");
            String IsArbitro = request.getParameter("arbitro");

            if (IsJugador != null) {

                jugador_JB jugadorJb = new jugador_JB();

                //jugadorJb.setCurp();
                jugadorJb.setNombre(request.getParameter("nombre"));
                jugadorJb.setAp_paterno(request.getParameter("apellido_Pat"));
                jugadorJb.setAp_materno(request.getParameter("apellido_Mat"));
                jugadorJb.setEdad(Integer.parseInt(request.getParameter("edad")));
                jugadorJb.setCampeonatos_jug(Integer.parseInt(request.getParameter("campeonatosJugados")));
                switch (request.getParameter("nacionalidad")){
                    case "EEUU":
                        jugadorJb.setR_nacionalidad(1);
                        jugadorJb.setEquipo_pertenece(1);
                        break;

                    case "Alemania":
                        jugadorJb.setR_nacionalidad(2);
                        jugadorJb.setEquipo_pertenece(2);
                        break;

                    case "Argentina":
                        jugadorJb.setR_nacionalidad(3);
                        jugadorJb.setEquipo_pertenece(3);
                        break;

                    case "Australia":
                        jugadorJb.setR_nacionalidad(4);
                        jugadorJb.setEquipo_pertenece(4);
                        break;

                    case "Brasil":
                        jugadorJb.setR_nacionalidad(5);
                        jugadorJb.setEquipo_pertenece(5);
                        break;

                    case "España":
                        jugadorJb.setR_nacionalidad(6);
                        jugadorJb.setEquipo_pertenece(6);
                        break;

                    case "Francia":
                        jugadorJb.setR_nacionalidad(7);
                        jugadorJb.setEquipo_pertenece(7);
                        break;

                    case "Inglaterra":
                        jugadorJb.setR_nacionalidad(8);
                        jugadorJb.setEquipo_pertenece(8);
                        break;

                    case "Japon":
                        jugadorJb.setR_nacionalidad(9);
                        jugadorJb.setEquipo_pertenece(9);
                        break;

                    case "Mexico":
                        jugadorJb.setR_nacionalidad(10);
                        jugadorJb.setEquipo_pertenece(10);
                        break;

                    case "Nueva Zelanda":
                        jugadorJb.setR_nacionalidad(11);
                        jugadorJb.setEquipo_pertenece(11);
                        break;
                }
                jugadorJb.setEdad(Integer.parseInt(request.getParameter("edad")));
                jugadorJb.setPeso(Float.parseFloat(request.getParameter("altura")));
                jugadorJb.setNivel_juego(Integer.parseInt(request.getParameter("NivelJuego")));

                switch (request.getParameter("posicion")){
                    case "Guardian":
                        jugadorJb.setR_posicion(1);
                        break;

                    case "Golpeador":
                        jugadorJb.setR_posicion(2);
                        break;

                    case "Cazador":
                        jugadorJb.setR_posicion(3);
                        break;

                    case "Buscador":
                        jugadorJb.setR_posicion(4);
                        break;
                }

                jugaDAO.registrar(jugadorJb);
            }

            if (IsArbitro != null) {
                arbitro_JB arbiJb = new arbitro_JB();

                //jugadorJb.setCurp();
                arbiJb.setNombre(request.getParameter("nombre"));
                arbiJb.setAp_paterno(request.getParameter("apellido_Pat"));
                arbiJb.setAp_materno(request.getParameter("apellido_Mat"));
                arbiJb.setEdad(Integer.parseInt(request.getParameter("edad")));
                arbiJb.setCampeonatos_jug(Integer.parseInt(request.getParameter("campeonatosJugados")));

                switch (request.getParameter("nacionalidad")){
                    case "EEUU":
                        arbiJb.setR_nacionalidad(1);
                        break;

                    case "Alemania":
                        arbiJb.setR_nacionalidad(2);
                        break;

                    case "Argentina":
                        arbiJb.setR_nacionalidad(3);
                        break;

                    case "Australia":
                        arbiJb.setR_nacionalidad(4);
                        break;

                    case "Brasil":
                        arbiJb.setR_nacionalidad(5);
                        break;

                    case "España":
                        arbiJb.setR_nacionalidad(6);
                        break;

                    case "Francia":
                        arbiJb.setR_nacionalidad(7);
                        break;

                    case "Inglaterra":
                        arbiJb.setR_nacionalidad(8);
                        break;

                    case "Japon":
                        arbiJb.setR_nacionalidad(9);
                        break;

                    case "Mexico":
                        arbiJb.setR_nacionalidad(10);
                        break;

                    case "Nueva Zelanda":
                        arbiJb.setR_nacionalidad(11);
                        break;
                }

                arbiJb.setEdad(Integer.parseInt(request.getParameter("edad")));
                arbiJb.setPeso(Float.parseFloat(request.getParameter("altura")));
                arbiJb.setDireccion(request.getParameter("direccion"));
                arbiJb.setTel_contac(request.getParameter("telefono"));

                arbiDAO.registrar(arbiJb);

            }

        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }


        RequestDispatcher MyDispatch = request.getRequestDispatcher("/AllParticipantes_Servlet");

        MyDispatch.forward(request, response);
    }
}
