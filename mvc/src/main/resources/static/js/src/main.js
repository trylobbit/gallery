$(document).ready(function () { //$ nazwa funkcji JQuery, document- cały HTML, .ready to metoda przyjmująca
// w parametrze definicje funkcji ktora sie wykona w momencie załadwoania document
    initialize();
    // showSubMenu();
});


function initialize() {
    // $("#base").find("a").on("click", function (e) {
    //     e.preventDefault();
    //     getBaseContent();
    // });
    // $("#home").find("a").on("click", function (e) {
    //     e.preventDefault();
    //     getHomeContent();
    // });
    // $("#edit").find("a").on("click", function (e) {
    //     e.preventDefault();
    //     getEditContent();
    // })
    // $("#login").find("a").on("click", function (e) {
    //     e.preventDefault();
    //     getLoginContent();
    // })
    // $("#register").find("a").on("click", function (e) {
    //     e.preventDefault();
    //     getRegisterContent();
    // })
}
function getBaseContent() {
    $.get("base", function (data) {
        $("#result").html($(data).find("#result"));
    })
}
function getHomeContent() {
    $.get("home", function (data) {
        $("#result").html($(data).find("#result"));

    })
}
function getEditContent() {
    $.get("edit", function (data) {
        $("#result").html($(data).find("#result"));
    })

}

function getRegisterContent() {
    $.get("register", function (data) {
        $("#result").html($(data).find("#result"));
    })
}


// function getLoginContent() {
//     $.get("login", function (data) {
//         $("#result").html($(data).find("#result"));
//     })
//
// }
// function showSubMenu(){}
// $('.top-menu').hover(
//     function () {
//         $(this).find('.sub-menu').show("slow");
//     },
//     function () {
//         $(this).find('.sub-menu').hide("slow");
//     }
// );
