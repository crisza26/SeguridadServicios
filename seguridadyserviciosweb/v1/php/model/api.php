<?php 

class servicios{

    protected $self = array();
    public function __construct( /*...*/ ) {
        $args = func_get_args();
        for( $i=0, $n=count($args); $i<$n; $i++ )
            $this->add($args[$i]);
    }
    
    public function __get( /*string*/ $name = null ) {
        return $this->self[$name];
    }
    
    public function logs($dateStart,$dateEnd) {
        echo $dateStart;
    }

    public function puertas() {

    }

    public function login ($user,$pass){
include 'getconexion.php';
//manejo de sesiones
        session_start();
        $_SESSION['timeout']=time();

 //conexiones a BD


        $sql = "select * from tbl_usuario where usuario='$user'";

        /* Consultas de selección que devuelven un conjunto de resultados */
        if ($resultado = $mysqli->query($sql)) {

            if ($resultado->num_rows > 0) {

                while($row = $resultado->fetch_assoc()) {
                    //echo " - Name: " . $row["nombre"]. " " . $row["apellido"]. "<br>";

    // Start the session
                    session_start();
            //variable de session
                    $_SESSION['nombre'] =  $row["nombre"];
                    $_SESSION['apellido'] = $row["apellido"];
                    $_SESSION['id'] = $row['id_usuario'];

                        // output data of each row
                    if($row['contrasenia']==$pass){
                        return TRUE;
                    }
                    else{
                        return FALSE;
                    }
                        
                }

                return TRUE;

                }
                else{
          return FALSE;
                }

        } else {
          return FALSE;
      }
      /* liberar el conjunto de resultados */
      $resultado->close();
  }
}


$api = new servicios();
/*
$user="alejo";
$password = "chipote11";
$valid= $api->login($user,$password);
*/


?>
