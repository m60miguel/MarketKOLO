(function($){
    var creado = sessionStorage.getItem("UsuarioCreado");
        if(creado != null ){
             alert("Bienvenido!");
             sessionStorage.removeItem("UsuarioCreado");
        }
    
    $('#submit').text('Login').click(function(event){  
      var usuario = document.getElementById('usuario').value;
      var password = document.getElementById('password').value;
      console.log(usuario + '-' + password);
      $.ajax({
         url: '/MarketPlace/api/proveedores',
         method: 'GET',
         contenType: 'application/json',
         dataType: 'json',
         async: false
      }).done(function(data){
          var usuarioData;
          var passwordData;
          var existe = false;
          for(var i=0;i<data.length;i++){  
                usuarioData =(data[i].usuarioProveedor).toString();
                if(usuarioData == usuario.toString()){
                    existe=true;
                    passwordData=(data[i].passProveedor).toString();
                    if(passwordData == password){
                        sessionStorage.setItem("NombreProveedor", data[i].nombre);
                        sessionStorage.setItem("IdProveedor", data[i].id);
                        window.location.href = './index.html';
                    }
                    else{
                        alert('El password es incorrecto');
                    }
                }                
          }
          if(!existe){
               alert('El usuario no existe');
          }
          
      }).fail(function(xhr,status,error){
          console.log(error);
      });
    });
    
})(jQuery);
