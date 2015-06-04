<?php 

 
class controller{

   public $redirect = "php/view/client";
   public $msgerror = "hubo un error en la autenticacion";

    function __construct() {

      $servicio = $_POST['servicio'];
      $user=$_POST['user'];
      $password = $_POST['password'];

       if("login"==$servicio){

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

       }
   }
}
$controller = new controller();
