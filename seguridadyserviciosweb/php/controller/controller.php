<?php 

 
class controller{

   public $redirect = "php/view/client";
   public $msgerror = "hubo un error en la autenticacion";

    function __construct() {

      $servicio = $_POST['servicio'];
            
          //$servicio = "logs";

          //prueba getTOTP
        //$servicio="getTOTP";
            
       if("login"==$servicio){
              $user=$_POST['user'];
             $password = $_POST['password'];

            include '../model/api.php';
            //echo "string";
            $valid= $api->login($user,$password);
            //$valid=TRUE;
            if($valid==TRUE){
                $arr = array('location' => $this->redirect);
                echo json_encode($arr);
            }
            else{
                $arr = array('error' => $this->msgerror);
                echo json_encode($arr);
            }
       }
       if("logs"==$servicio){
          include '../model/api.php';
           $valid= $api->logs("","");
           // echo json_encode($valid);
          echo($valid);
               
       }

       if("getTOTP"==$servicio){

           //manejo de sesiones
            session_start();

        include '../model/api.php';

        $id_user="0";
        $id_puerta="0";

            if(isset($_SESSION['id'])){
                $GLOBALS['id_user']=$_SESSION['id'];    
            }

            $valid= $api->getTOTP($id_puerta,$id_user);
           if($valid==FALSE){
              $arr = array('error' =>"hubo un error obteniendo codigo");
              echo json_encode($arr);
           }
           else{
            $arr = array('code' =>$valid);
              echo json_encode($arr);
           }

       }

       if("session-close"==$servicio){
           $valid= $api->closeSession();
           if($valid==TRUE){
                $arr = array('location' =>'../../index.html');
                echo json_encode($arr);
           }
       }
   }
}
$controller = new controller();

