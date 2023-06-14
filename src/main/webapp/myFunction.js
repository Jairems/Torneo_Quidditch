let output = document.getElementById("print1");
let checkboxes = Array.from(document.querySelectorAll("#myTable [type='checkbox']"));
let rows = 3;
let columns = 2;
var MyArray = new Array();

let button = document.querySelector("button");
function myFunction() {
    let n = 0;
    let col = 0;
    checkboxes.map((c,i) =>{

        if(c.checked){n++;
            console.log("el index del checkbox en el array checkboxes:",i)
            console.log("Fila:", ~~(i/columns))
            col = ~~(i/columns);

            console.log("el número de la columna:",i%columns);
        }
    });

    output.innerHTML = col;
}