<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Participante</title>
    <link rel="stylesheet" href="Mi%20estilo.css">
</head>
<body>
<h2><a href="http://localhost:8080/MundialQuidditch_Edicion_Nopal"><input type="submit" value="Home"></a> </h2>

<form action="/MundialQuidditch_Edicion_Nopal/participante_Servlet" method="post" >

    <h1 style="align-content: center">Alta de participante</h1>
    <p>Nombre: <input type="text" name="nombre"></p>
    <p>Apellido Paterno: <input type="text" name="apellido_Pat"> </p>
    <p>Apellido Materno: <input type="text" name="apellido_Mat"> </p>
    <p>Campeonatos Jugados: <input type="text" name="campeonatosJugados"> </p>
    <p>Nacionalidad: <input type="text" name="nacionalidad" required> </p>
    <p>Edad: <input type="text" name="edad"></p>
    <p>Peso: <input type="text" name="peso"> </p>
    <p>Altura: <input type="text" name="altura"> </p>

    <p>Jugador: <input type="checkbox" name="jugador" id="checkJ" value="hayJugador" onchange="javascript:showContent()" /></p>

    <div id="content" style="display: none;">
        <h3>Jugador</h3>
        <p>Nivel de Juego: <input type="text" name="NivelJuego" placeholder="En escala de 1 a 10"></p>
        <p>Posición: <input type="text" name="posicion"> </p>
    </div>


    <p>Arbitro: <input type="checkbox" name="arbitro" id="checkA" value="hayArbitro" onchange="javascript:showContent2()" /></p>

    <div id="content2" style="display: none;">
        <h3>Arbitro</h3>
        <p>Direccion: <input type="text" name="direccion" placeholder="Direccion con número"></p>
        <p>Teléfono: <input type="text" name="telefono"> </p>
    </div>

    <p><input type="submit" value="Agregar" name="seleccion"></p>
</form>

<script type="text/javascript">
    function showContent() {
        element = document.getElementById("content");
        checkJ = document.getElementById("checkJ");
        checkA = document.getElementById("checkA");

        if (checkJ.checked && !checkA.checked) {
            element.style.display='block';
        }
        else {
            element.style.display='none';
        }
    }
</script>

<script type="text/javascript">
    function showContent2() {
        element = document.getElementById("content2");
        checkA = document.getElementById("checkA");
        checkJ = document.getElementById("checkJ");

        if (checkA.checked && !checkJ.checked) {
            element.style.display='block';
        }
        else {
            element.style.display='none';
        }
    }
</script>
</body>
</html>
