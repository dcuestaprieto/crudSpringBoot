$(document).ready(function () {
    //funcion que lista y tiene opcion editar y borrar
    cargarAlumnos();
    //funcion que solo lista los alumnos
    listarAlumnos();
});

async function verificarUsuario(){
    let nombre = document.getElementById("nombre").value;
    let password = document.getElementById("password").value;
    console.log(nombre+" "+ password);

    const request = await fetch('/getAlumno', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const alumnos = await request.json();
}

async function listarAlumnos() {
    const request = await fetch('/listarAlumnos', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const alumnos = await request.json();

    let alumnosArray = '';
    for (let alumno of alumnos) {
        let HTML = '<tr><td>' + alumno.id + '</td>' + '<td>' + alumno.nombre + '</td>' + '<td>' + alumno.nota + '</td></tr>';
        alumnosArray = alumnosArray + HTML;
    }
    document.querySelector('#alumnoslistar tbody').outerHTML = alumnosArray;
}

async function cargarAlumnos() {
    const request = await fetch('/listarAlumnos', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const alumnos = await request.json();

    let alumnosArray = '';
    for (let alumno of alumnos) {
        let HTML = '<tr><td>' + alumno.id + '</td>' + '<td>' + alumno.nombre + '</td>' + '<td>' + alumno.nota + '</td>' +
            '<td><input value="Eliminar" type="button" onclick="eliminar(' + alumno.id + ')"></td>'+
            '<td><input value="Editar" type="button" onclick="editarAlumno(' + alumno.id + ')"></td></tr>';
        alumnosArray = alumnosArray + HTML;
    }
    document.querySelector('#alumnos tbody').outerHTML = alumnosArray;
}

async function editarAlumno(idAlumno){
    let alumno = {};
    alumno.id=idAlumno;
    alumno.nombre = document.getElementById("nombre").value;
    alumno.nota = document.getElementById("nota").value;

    if(alumno.nombre !=="" && alumno.nota !==""){

        const request = await fetch('/editarAlumno/',{
            method: 'PUT',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(alumno)
        });
    }
    location.reload();
}

async function eliminar(id){
    const request = await fetch('/eliminarAlumno/'+ id, {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    location.reload();
}

async function addUsuario(){
    let usuarioNuevo = {};
    usuarioNuevo.nombre = document.getElementById("nombre").value;
    usuarioNuevo.password = document.getElementById("password").value;
    usuarioNuevo.admin = document.getElementById("admin").value;

    if(usuarioNuevo.nombre !=="" && usuarioNuevo.password !==""){

        const request = await fetch('/addUsuario',{
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(usuarioNuevo)
        });
        fetch('/addUsuario')
            .then(res=>{
                if (!res.ok){
                    throw new Error('Error en la solicitud');
                }
                return res.json();
            })
            .then(data=>{
                console.log(data)
            })
            .catch(err=>{
                console.log('error: ',err)
            })
    }
    console.log(usuarioNuevo);

    if (usuarioNuevo.admin==1){
        location.assign("./crud.html");
    }else{
        location.assign("./listar.html")
    }

    //location.reload();
}
async function addAlumno(){
    let alumno = {};
    alumno.nombre = document.getElementById("nombre").value;
    alumno.nota = document.getElementById("nota").value;

    if(alumno.nombre !=="" && alumno.nota !==""){

        const request = await fetch('/addAlumno',{
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(alumno)
        });
    }
    location.reload();
}