let btnSubmit = document.getElementById("btnSubmit");
let txtUserOwner = document.getElementById("userowner");
let txtUserSummoner = document.getElementById("usersummoner");
let txtEventName = document.getElementById("eventname");
let txtTema = document.getElementById("tema");
let txtInicio = document.getElementById("starttime");
let txtFin = document.getElementById("endtime");
let txtCoordenadas = document.getElementById("coordinates");
let txtVideomeeting = document.getElementById("videomeeting");
let radioCoordinates = document.getElementById("eventpreferencecoordinates");
let radioVideomeeting = document.getElementById("eventpreferencevideomeeting");

let lblUserOwner = document.getElementById("lblUserOwner");
let lblUserSummoner = document.getElementById("lblUserSummoner");
let lblEventName = document.getElementById("lblEventName");
let lblTema = document.getElementById("lblTema");
let lblInicio = document.getElementById("lblInicio");
let lblFin = document.getElementById("lblFin");
let lblCoordenadas = document.getElementById("lblCoordenadas");
let lblVideomeeting = document.getElementById("lblVideomeeting");

let divCoordenadas = document.getElementById("coorDiv");
let divVideomeeting = document.getElementById("videoDiv");

lblUserOwner.style.color = "red";
lblUserSummoner.style.color = "red";
lblEventName.style.color = "red";
lblTema.style.color = "red";
lblInicio.style.color = "red";
lblFin.style.color = "red";
lblCoordenadas.style.color = "red";
lblVideomeeting.style.color = "red";

let Comprobaciones = {
    userOwner: false,
    userSummoner: false,
    eventName: false,
    tema: false,
    inicio: false,
    fin: false,
    coordenadas: false,
    videomeeting: false,
};

let checkInputs = () => {
    if (Comprobaciones.userOwner===true && Comprobaciones.userSummoner===true && Comprobaciones.eventName===true && Comprobaciones.tema===true && Comprobaciones.inicio===true
        && Comprobaciones.fin===true && Comprobaciones.coordenadas===true && Comprobaciones.videomeeting===true) btnSubmit.disabled = false;
    else btnSubmit.disabled = true;
};

btnSubmit.disabled = true;

window.addEventListener("load", () =>{
    divCoordenadas.style.display = "none";
    divVideomeeting.style.display = "none";

    if (radioCoordinates.checked) divCoordenadas.style.display = "block";
    else if (radioVideomeeting.checked)divVideomeeting.style.display = "block";

});

radioCoordinates.addEventListener("click", () =>{
    divVideomeeting.style.display = "none";
    divCoordenadas.style.display = "block";
    txtVideomeeting.value = "";
    Comprobaciones.coordenadas = false;
    Comprobaciones.videomeeting = false;
});

radioVideomeeting.addEventListener("click", () =>{
    divVideomeeting.style.display = "block";
    divCoordenadas.style.display = "none";
    txtCoordenadas.value = "";
    Comprobaciones.coordenadas = false;
    Comprobaciones.videomeeting = false;
});

txtUserOwner.addEventListener("change", () =>{
    let text = txtUserOwner.value;
    if(text.length<20 && text.length>0){
        lblUserOwner.innerText = "✔️";
        Comprobaciones.userOwner=true;
        checkInputs();
    }else if(text.length<1){
        lblUserOwner.innerText = "❌¡Introduce un ID!❌";
        Comprobaciones.userOwner=false;
        checkInputs();
    }
    else{
        lblUserOwner.innerText = "❌¡Introduce un ID menor a 20 digitos!❌";
        Comprobaciones.userOwner=false;
        checkInputs();
    }
});

txtUserSummoner.addEventListener("change", () =>{
    let text = txtUserSummoner.value;
    if(text.length<20 && text.length>0){
        lblUserSummoner.innerText = "✔️";
        Comprobaciones.userSummoner=true;
        checkInputs();
    }else if(text.length<1){
        lblUserSummoner.innerText = "❌¡Introduce un ID!❌";
        Comprobaciones.userSummoner=false;
        checkInputs();
    }
    else{
        lblUserSummoner.innerText = "❌¡Introduce un ID menor a 20 digitos!❌";
        Comprobaciones.userSummoner=false;
        checkInputs();
    }
});

txtEventName.addEventListener("change", () =>{
    let text = txtEventName.value;
    if(text.length<15 && text.length>3){
        lblEventName.innerText = "✔️";
        Comprobaciones.eventName=true;
        checkInputs();
    }else if(text.length<4){
        lblEventName.innerText = "❌¡Introduce un nombre de evento mayor a 4 digitos!❌";
        Comprobaciones.eventName=false;
        checkInputs();
    }
    else{
        lblEventName.innerText = "❌¡Introduce un nombre de evento menor a 15 digitos!❌";
        Comprobaciones.eventName=false;
        checkInputs();
    }
});

txtTema.addEventListener("change", () =>{
    let text = txtTema.value;
    if(text.length<15 && text.length>3){
        lblTema.innerText = "✔️";
        Comprobaciones.tema=true;
        checkInputs();
    }else if(text.length<4){
        lblTema.innerText = "❌¡Introduce un nombre de evento mayor a 4 digitos!❌";
        Comprobaciones.tema=false;
        checkInputs();
    }
    else{
        lblTema.innerText = "❌¡Introduce un nombre de evento menor a 15 digitos!❌";
        Comprobaciones.tema=false;
        checkInputs();
    }
});

txtInicio.addEventListener("change", () =>{
    let text2 = txtInicio.value;
    let text = txtFin.value;
    if(text2.length>0 && !(new Date(text) < new Date(text2))){
        lblInicio.innerText = "✔️";
        Comprobaciones.inicio=true;
        checkInputs();
    }
    else if (new Date(text) < new Date(text2)) {
        lblInicio.innerText = "❌¡Elige una fecha de inicio que sea antes de fin!❌";
        Comprobaciones.inicio=false;
        checkInputs();
    }
    else{
        lblInicio.innerText = "❌¡Elige una fecha de inicio!❌";
        Comprobaciones.inicio=false;
        checkInputs();
    }
});

txtFin.addEventListener("change", () =>{
    let text = txtFin.value;
    let text2 = txtInicio.value;
    if(text.length>0 && !(new Date(text) < new Date(text2))){
        lblFin.innerText = "✔️";
        Comprobaciones.fin=true;
        checkInputs();
    }
    else if (new Date(text) < new Date(text2)) {
        lblFin.innerText = "❌¡Elige una fecha de fin que sea después de inicio!❌";
        Comprobaciones.fin=false;
        checkInputs();
    }
    else{
        lblFin.innerText = "❌¡Elige una fecha de fin!❌";
        Comprobaciones.fin=false;
        checkInputs();
    }
});

txtCoordenadas.addEventListener("change", () =>{
    let text = txtCoordenadas.value;
    if(text.length<100 && text.length>9){
        lblCoordenadas.innerText = "✔️";
        Comprobaciones.coordenadas=true;
        Comprobaciones.videomeeting=true;
        checkInputs();
    }else if(text.length<8){
        lblCoordenadas.innerText = "❌¡Introduce unas coordenadas mayor a 9 digitos!❌";
        Comprobaciones.coordenadas=false;
        Comprobaciones.videomeeting=false;
        checkInputs();
    }
    else{
        lblCoordenadas.innerText = "❌¡Introduce unas coordenadas menores a 100 digitos!❌";
        Comprobaciones.coordenadas=false;
        Comprobaciones.videomeeting=false;
        checkInputs();
    }
});

txtVideomeeting.addEventListener("change", () =>{
    let text = txtVideomeeting.value;
    if(text.length<100 && text.length>9){
        lblVideomeeting.innerText = "✔️";
        Comprobaciones.coordenadas=true;
        Comprobaciones.videomeeting=true;
        checkInputs();
    }else if(text.length<8){
        lblVideomeeting.innerText = "❌¡Introduce un enlace mayor a 9 digitos!❌";
        Comprobaciones.coordenadas=false;
        Comprobaciones.videomeeting=false;
        checkInputs();
    }
    else{
        lblVideomeeting.innerText = "❌¡Introduce un enlace menor a 100 digitos!❌";
        Comprobaciones.coordenadas=false;
        Comprobaciones.videomeeting=false;
        checkInputs();
    }
});
