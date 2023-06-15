<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
    <title>Quidditch_WorldPal</title>
<link rel="stylesheet" href="Miestilo.css"/>
</head>
<body>
<div class="container">
    <h2>TORNEO MUNDIAL "NOPALERO" DE QUIDDITCH</h2>

    <div id="menuquidditch">
        <ul class="nav">
            <li> <input type="button" value="Participante">
                <ul>
                    <li>
                        <form class="center" action="/MundialQuidditch_Edicion_Nopal" name="" method="get">
                            <input type="submit" value="Ver Participante" name="seleccion" >
                        </form>
                    </li>

                    <li>
                        <form class="center" action="/MundialQuidditch_Edicion_Nopal/Participante/create_participante.jsp" name="Participante_serv" method="get">
                            <input type="submit" value="Registrar Participante" name="seleccion">
                        </form>
                    </li>

                    <li>
                        <form class="center" action="" name="Participante_serv" method="get">
                            <input type="submit" value="Modificar Participante" name="seleccion">
                        </form>
                    </li>

                    <li>
                        <form class="center" action="" name="Participante_serv" method="get">
                            <input type="submit" value="Eliminar Participante" name="seleccion">
                        </form>
                    </li>

                </ul>
            </li>

            <li> <input value="Paises" type="button">
            </li>

            <li> <input value="Estadios" type="button">
                <form class="center" action="">
                    <input type="submit" value="">
                </form>
            </li>
            <li><button></button></li>
            <li><button></button></li>
        </ul>
    </div>
    <br>
    <br>
</div>
</body>
</html>

