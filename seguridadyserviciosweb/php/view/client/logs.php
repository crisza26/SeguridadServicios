<?php
session_start();
$_SESSION['timeout']=time();



?>

<!DOCTYPE html>
<html class="html" lang="es-ES">
 <head>

  <script type="text/javascript">
   if(typeof Muse == "undefined") window.Muse = {}; window.Muse.assets = {"required":["jquery-1.8.3.min.js", "museutils.js", "jquery.musemenu.js", "jquery.watch.js", "logs.css"], "outOfDate":[]};
</script>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
  
  <meta http-equiv="Content-type" content="text/html;charset=UTF-8"/>
  <meta name="generator" content="2014.3.2.295"/>
  <title>Logs</title>
  <!-- CSS -->
  <link rel="stylesheet" type="text/css" href="css/site_global.css?422415861"/>
  <link rel="stylesheet" type="text/css" href="css/master_a-p_g_-maestra.css?419190160"/>
  <link rel="stylesheet" type="text/css" href="css/logs.css?322602332" id="pagesheet"/>

  <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
  <!-- Other scripts -->
  <script type="text/javascript">
   document.documentElement.className += ' js';
</script>
  <!-- JS includes -->
  <!--[if lt IE 9]>
  <script src="scripts/html5shiv.js?4241844378" type="text/javascript"></script>
  <![endif]-->
   </head>
 <body>

  <div class="rounded-corners clearfix" id="page"><!-- group -->
   <div class="clip_frame grpelem" id="u631"><!-- image -->
    <img class="block" id="u631_img" src="images/logpag.gif" alt="" width="69" height="82"/>
   </div>
   <div class="clearfix grpelem" id="pmenuu123"><!-- column -->
    <nav class="MenuBar clearfix grpelem" id="menuu123"><!-- horizontal box -->
     <div class="MenuItemContainer clearfix grpelem" id="u131"><!-- vertical box -->
      <a class="nonblock nontext MenuItem MenuItemWithSubMenu MuseMenuActive clearfix colelem" id="u134" href="index.php"><!-- horizontal box --><div class="MenuItemLabel NoWrap grpelem" id="u135-4"><!-- rasterized frame --><div id="u135-4_clip"><img id="u135-4_img" alt="Puertas" width="166" height="17" src="images/u135-4.png"/></div></div></a>
     </div>
     <div class="MenuItemContainer clearfix grpelem" id="u145"><!-- vertical box -->
      <a class="nonblock nontext MenuItem MenuItemWithSubMenu clearfix colelem" id="u146" href="usuarios-y-permisos.php"><!-- horizontal box --><div class="MenuItemLabel NoWrap grpelem" id="u147-4"><!-- rasterized frame --><div id="u147-4_clip"><img id="u147-4_img" alt="Usuarios y Permisos" width="166" height="17" src="images/u147-4.png"/></div></div></a>
     </div>
     <div class="MenuItemContainer clearfix grpelem" id="u158"><!-- vertical box -->
      <a class="nonblock nontext MenuItem MenuItemWithSubMenu clearfix colelem" id="u161" href="registros.php"><!-- horizontal box --><div class="MenuItemLabel NoWrap grpelem" id="u163-4"><!-- rasterized frame --><div id="u163-4_clip"><img id="u163-4_img" alt="Registros" width="167" height="17" src="images/u163-4.png"/></div></div></a>
     </div>
     <div class="MenuItemContainer clearfix grpelem" id="u586"><!-- vertical box -->
      <a class="nonblock nontext MenuItem MenuItemWithSubMenu clearfix colelem" id="u589" href="logs.php"><!-- horizontal box --><div class="MenuItemLabel NoWrap grpelem" id="u591-4"><!-- rasterized frame --><div id="u591-4_clip"><img id="u591-4_img" alt="Logs" width="167" height="17" src="images/u591-4.png"/></div></div></a>
     </div>
    </nav>


</div>


    

      <div id="info" style="margin-top: 100px;">

      </div>  

      <script>
$(document).ready(function(){
    //$("#ingresar").click(function(){
        $.post( "../../controller/controller.php", { servicio:"logs"})
      .done(function( data) {
        var obj=jQuery.parseJSON(data);
       // if(obj.error){
          //$("#error").html(obj);
          var msgForIn = '';
          msgForIn='<table class="table table-bordered">';
          msgForIn+='<thead><tr><th>usuario</th><th>ip</th><th>fecha</th><th>puerta</th></tr></thead><tbody>';
          for (var i=0; i<obj.length; i++){
             msgForIn += '<tr><th scope="row">'+obj[i].usuario+'</th><td>'+obj[i].ip+'</td><td>'+obj[i].fecha+'</td><td>'+obj[i].puerta+"</td></tr>";
          }
           msgForIn+='</tbody></table>';
          $("#info").html(msgForIn);
          //alert(msgForIn);
          /*for(var key in obj){
            msgForIn += key.ip+":";
          }
          $("#error").html(msgForIn);
          */
        //}
        //else{
          //alert(obj.location)
          //window.location.assign(obj.location);
        //}
    });
  //  });
});
</script>
   
</div>






  <!-- JS includes -->
  <script type="text/javascript">
   if (document.location.protocol != 'https:') document.write('\x3Cscript src="http://musecdn.businesscatalyst.com/scripts/4.0/jquery-1.8.3.min.js" type="text/javascript">\x3C/script>');
</script>
  <script type="text/javascript">
   window.jQuery || document.write('\x3Cscript src="scripts/jquery-1.8.3.min.js" type="text/javascript">\x3C/script>');
</script>
  <script src="scripts/museutils.js?521960461" type="text/javascript"></script>
  <script src="scripts/jquery.musemenu.js?397543671" type="text/javascript"></script>
  <script src="scripts/jquery.watch.js?56779320" type="text/javascript"></script>
  <!-- Other scripts -->
  <script type="text/javascript">
   $(document).ready(function() { try {
(function(){var a={},b=function(a){if(a.match(/^rgb/))return a=a.replace(/\s+/g,"").match(/([\d\,]+)/gi)[0].split(","),(parseInt(a[0])<<16)+(parseInt(a[1])<<8)+parseInt(a[2]);if(a.match(/^\#/))return parseInt(a.substr(1),16);return 0};(function(){$('link[type="text/css"]').each(function(){var b=($(this).attr("href")||"").match(/\/?css\/([\w\-]+\.css)\?(\d+)/);b&&b[1]&&b[2]&&(a[b[1]]=b[2])})})();(function(){$("body").append('<div class="version" style="display:none; width:1px; height:1px;"></div>');
for(var c=$(".version"),d=0;d<Muse.assets.required.length;){var f=Muse.assets.required[d],g=f.match(/([\w\-\.]+)\.(\w+)$/),k=g&&g[1]?g[1]:null,g=g&&g[2]?g[2]:null;switch(g.toLowerCase()){case "css":k=k.replace(/\W/gi,"_").replace(/^([^a-z])/gi,"_$1");c.addClass(k);var g=b(c.css("color")),h=b(c.css("background-color"));g!=0||h!=0?(Muse.assets.required.splice(d,1),"undefined"!=typeof a[f]&&(g!=a[f]>>>24||h!=(a[f]&16777215))&&Muse.assets.outOfDate.push(f)):d++;c.removeClass(k);break;case "js":k.match(/^jquery-[\d\.]+/gi)&&
typeof $!="undefined"?Muse.assets.required.splice(d,1):d++;break;default:throw Error("Unsupported file type: "+g);}}c.remove();if(Muse.assets.outOfDate.length||Muse.assets.required.length)c="Puede que determinados archivos falten en el servidor o sean incorrectos. Limpie la cache del navegador e inténtelo de nuevo. Si el problema persiste, póngase en contacto con el administrador del sitio web.",(d=location&&location.search&&location.search.match&&location.search.match(/muse_debug/gi))&&Muse.assets.outOfDate.length&&(c+="\nOut of date: "+Muse.assets.outOfDate.join(",")),d&&Muse.assets.required.length&&(c+="\nMissing: "+Muse.assets.required.join(",")),alert(c)})()})();
/* body */
Muse.Utils.transformMarkupToFixBrowserProblemsPreInit();/* body */
Muse.Utils.prepHyperlinks(true);/* body */
Muse.Utils.initWidget('.MenuBar', function(elem) { return $(elem).museMenu(); });/* unifiedNavBar */
Muse.Utils.fullPage('#page');/* 100% height page */
Muse.Utils.showWidgetsWhenReady();/* body */
Muse.Utils.transformMarkupToFixBrowserProblems();/* body */
} catch(e) { if (e && 'function' == typeof e.notify) e.notify(); else Muse.Assert.fail('Error calling selector function:' + e); }});
</script>
   </body>
</html>