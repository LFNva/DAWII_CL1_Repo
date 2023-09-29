$(document).on("click", "#btnagregar", function(){
    $("#txtnomalumno").val("");
    $("#txtapealumno").val("");
    $("#hddidalu").val("0");
    $("#txtprocealumno").val("");
    $("#cboespecialidad").empty();
    $("#switchproducto" ).hide();
    listarCboEspecialidad(0);
    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txtnomalumno").val($(this).attr("data-alunom"));
    $("#txtapealumno").val($(this).attr("data-aluape"));
    $("#hddidalu").val($(this).attr("data-aluid"));
    $("#txtprocealumno").val($(this).attr("data-aluproce"));
    $("#cboespecialidad").empty();
    listarCboEspecialidad($(this).attr("data-aluesp");
    $("#modalNuevo").modal("show");
});

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/alumno/guardarAlumno",
        contentType: "application/json",
        data: JSON.stringify({
            idalumno: $("#hddidalu").val(),
            nomalumno: $("#txtnomproducto").val(),
            apealumno: $("#txtapealumno").val(),
            proce: $("#txtprocealumno").val(),
            idesp: $("#cboespecialidad").val(),
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarAlumnos();
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalNuevo").modal("hide");
});

function listarCboEspecialidad(idesp){
    $.ajax({
        type: "GET",
        url: "/especialidad/listar",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cboespecialidad").append(
                    `<option value="${value.idesp}">${value.nomesp}</option>`
                )
            });
            if(idcategoria > 0){
                $("#cboespecialidad").val(idesp);
            }
        }
    });
}

function listaAlumnos(){
    $.ajax({
        type: "GET",
        url: "/alumno/listarAlumnos",
        dataType: "json",
        success: function(resultado){
            $("#tblalumno > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblalumno > tbody").append("<tr>"+
                    "<td>"+value.idalumno+"</td>"+
                    "<td>"+value.nomalumno+"</td>"+
                    "<td>"+value.apealumno+"</td>"+
                    "<td>"+value.proce+"</td>"+
                    "<td>"+value.especialidad.nomesp+"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-info btnactualizar'"+
                                     "data-aluid='"+value.idalumno+"'"+
                                     "data-alunom='"+value.nomalumno+"'"+
                                     "data-aluape='"+value.apealumno+"'"+
                                     "data-aluproce='"+value.proce+"'"+
                                     "data-aluesp='"+value.especialidad.idesp+"'"+
                                     "><i class='fas fa-edit'></i></button>"+
                    "</td></tr>");
            })
        }
    })
}