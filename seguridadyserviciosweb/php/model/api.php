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


        public function getTOTP($id_puerta,$id_user){
                        //insert on mysql

            include 'getconexion.php';

            $ipaddress=$_SERVER['REMOTE_ADDR'];
            $fecha = date("Y-m-d H:i:s");

            
            //print_r($_SERVER);

            //echo "ip".$ipaddress."date".$fecha."id_puerta".$id_puerta."id".$id;
                     //$sql = "select * from tbl_usuario where usuario='$correo'";

            $sql="INSERT INTO tbl_logs(id,id_usuario, ip, fecha, id_puerta) VALUES (NULL,\"".$id_user."\",\"".$ipaddress."\",\"".$fecha."\",\"".$id_puerta."\")";
            //echo $sql;

            /* Consultas de selección que devuelven un conjunto de resultados */
            if ($mysqli->query($sql) == TRUE) {
                //return file_get_contents('TOTP.php');
                return (include 'TOTP.php');
            }
            else{
                return FALSE;
            }
            //printf($mysqli->error);
            //echo("<BR>");
        }

        
        public function logs($dateStart,$dateEnd) {
         include 'getconexion.php';

    $sql = "select * from tbl_logs";
             if ($resultado = $mysqli->query($sql)) {

         $return_arr = array();

      while($row = $resultado->fetch_assoc()) {
        $row_array['usuario'] = $row['id_usuario'];
        $row_array['ip'] = $row['ip'];
        $row_array['fecha'] = $row['fecha'];
        $row_array['puerta'] = $row['id_puerta'];

        array_push($return_arr,$row_array);
        }

    echo json_encode($return_arr);

             }


     //conexiones a BD




         /*Consultas de selección que devuelven un conjunto de resultados
         if ($resultado = $mysqli->query($sql)) {
                $row = $resultado->fetch_assoc();       
                echo json_encode($row);

                 /*while($row = $resultado->fetch_assoc()) {
                        echo " usuario: " . $row["id_usuario"]. " ip: " . $row["ip"]. " fecha: " . $row["fecha"]. " puerta: " . $row["id_puerta"]. "<br>";                
                    }
        }*/

    }

    public function puertas() {

    }
    public function closeSession (){
    //SI EXISTEN VAR SESSION ISSET PHP

            unset($_SESSION['nombre']); // will delete just the name data
            unset($_SESSION['apellido']); // will delete just the name data

            unset($_SESSION['id']); // will delete just the name data
            unset($_SESSION['timeout']); // will delete just the name data
            session_destroy(); // will delete ALL data associated with that user.
            return TRUE;
        }




        public function login ($user,$pass){
            include 'getconexion.php';
    //manejo de sesiones
            session_start();
     //conexiones a BD


            $sql = "select * from tbl_usuario where usuario='$user'";

            /* Consultas de selección que devuelven un conjunto de resultados */
            if ($resultado = $mysqli->query($sql)) {

                if ($resultado->num_rows > 0) {

                    while($row = $resultado->fetch_assoc()) {
                        //echo " - Name: " . $row["nombre"]. " " . $row["apellido"]. "<br>";

        // Start the session
                        //session_start();
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
    
    //$valid= $api->getTOTP("","");
    //echo $valid;


    //$valid= $api->logs("","");
    //echo json_encode($valid);


    /*
    $user="alejo";
    $password = "chipote11";

    $valid= $api->login($user,$password);
    //$valid= $api->closeSession();

    echo($valid);
    */

    ?>
