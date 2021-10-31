let btnSubmit = document.getElementById("btnSubmit");
let txtUsername = document.getElementById("username");
let txtPassword = document.getElementById("password");
let txtEmail = document.getElementById("email");
let txtPhonenumber = document.getElementById("phonenumber");
let lblUsername = document.getElementById("lblUsername");
let lblPassword = document.getElementById("lblPassword");
let lblEmail = document.getElementById("lblEmail");
let lblPhonenumber = document.getElementById("lblPhonenumber");

lblUsername.style.color = "red";
lblPassword.style.color = "red";
lblEmail.style.color = "red";
lblPhonenumber.style.color = "red";

let Comprobaciones = {
    username: false,
    password: false,
    email: false,
    phonenumber: false
};

btnSubmit.disabled = true;


window.addEventListener("load", () => {
    checkUsername();
    checkEmail();
    checkPhoneNumber();
});

txtUsername.addEventListener("change", () =>{
    checkUsername();
});

txtPassword.addEventListener("change", () =>{
    checkPassword();
});

txtEmail.addEventListener("change", () =>{
    checkEmail();
});

txtPhonenumber.addEventListener("change", () =>{
    checkPhoneNumber();
});

let checkInputs = () => {
    if (Comprobaciones.username===true && Comprobaciones.password===true && Comprobaciones.email===true && Comprobaciones.phonenumber===true) btnSubmit.disabled = false;
    else btnSubmit.disabled = true;
};

let checkUsername = () => {
    let text = txtUsername.value;
    if(text.length<15 && text.length>1){
        lblUsername.innerText = "✔️";
        Comprobaciones.username=true;
        checkInputs();
    }else if(text.length<2){
        lblUsername.innerText = "❌¡Introduce un Username mayor a 1 digito!❌";
        Comprobaciones.username=false;
        checkInputs();
    }
    else{
        lblUsername.innerText = "❌¡Introduce un Username menor a 15 digitos!❌";
        Comprobaciones.username=false;
        checkInputs();
    }
};

let checkPassword = () => {
    let password = txtPassword.value;
    if(password.length>4 &&password.length<20){
        lblPassword.innerText = "✔️";
        Comprobaciones.password=true;
        checkInputs();
    }
    else if (password.length<5){
        lblPassword.innerText = "❌¡Introduce una contraseña mayor a 4 digitos!❌";
        Comprobaciones.password=false;
        checkInputs();
    }
    else{
        lblPassword.innerText = "❌¡Introduce una contraseña menor a 20 digitos!❌";
        Comprobaciones.password=false;
        checkInputs();
    }
};

let checkEmail = () => {
    let email = txtEmail.value;
    if(email.length<50 && /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)){
        lblEmail.innerText = "✔️";
        Comprobaciones.email=true;
        checkInputs();
    }else if (!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email))){
        lblEmail.innerText = "❌¡Introduce un email correcto!❌";
        Comprobaciones.email=false;
        checkInputs();
    }
    else{
        lblEmail.innerText = "❌¡Introduce una contraseña menor a 50 digitos!❌";
        Comprobaciones.email=false;
        checkInputs();
    }
};

let checkPhoneNumber = () => {
    let phonenumber = txtPhonenumber.value;
    if(phonenumber.length<10 && /^\+?(6\d{2}|7[1-9]\d{1})\d{6}$/.test(phonenumber)){
        lblPhonenumber.innerText = "✔️";
        Comprobaciones.phonenumber=true;
        checkInputs();
    }else if (!(/^\+?(6\d{2}|7[1-9]\d{1})\d{6}$/.test(phonenumber))){
        lblPhonenumber.innerText = "❌¡Introduce un telefono correcto!❌";
        Comprobaciones.phonenumber=false;
        checkInputs();
    }
    else{
        lblPhonenumber.innerText = "❌¡Introduce telefono de 9 digitos!❌";
        Comprobaciones.phonenumber=false;
        checkInputs();
    }
};
