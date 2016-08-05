<!DOCTYPE html>

<html>
<head>
    <title>My App</title>
    <meta charset="UTF 8" />
</head>
<body>
    <?php
        header("200");

        $arrayDatos = array(
            array(
            	"id" => "1",
            	"nombre" => "Tarta de manzana",
            	"precio" => "200",
            	"unidades" => "20",
            	"descripcion" => "Una tarta de manzana sin manzana muy muy buena",
            	"imagen" => "http://static.hogarmania.com/archivos/201602/5317-2-tarta-de-manzana-702-vertical-xl-848x477x80xX.jpg"
            ),
            array(
                "id" => "2",
                "nombre" => "Brujula excursionista",
                "precio" => "50",
                "unidades" => "120",
                "descripcion" => "Defecto: no apunta al norte",
                "imagen" => "http://microrespuestas.com/wp-content/uploads/2013/02/brujula.jpg"
            ),
            array(
                "id" => "3",
                "nombre" => "Casco de buzo",
                "precio" => "30",
                "unidades" => "5",
                "descripcion" => "No sirve para buzear",
                "imagen" => "http://www.tucanmobles.com/imagens/marino/marino9.jpg"
            ),
        );

        print_r(json_encode($arrayDatos));
    ?>
</body>
</html>

