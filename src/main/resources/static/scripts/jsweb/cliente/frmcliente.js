$(document).on("click", "#btnagregar", function(){
    $("#txtnombre").val("");
    $("#txtapellido").val("");
    $("#txtdireccion").val("");
    $("#modalNuevo").modal("show");
});

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/cliente/registrarcliente",
        contentType: "application/json",
        data: JSON.stringify({
            nomcliente:  $("#txtnombre").val(),
            apecliente:  $("#txtapellido").val(),
            descdireccion:  $("#txtdireccion").val()
        }),
        success:function(resultado){
            alert(resultado.mensaje);
        }
    });
    $("#modalNuevo").modal("hide");
})