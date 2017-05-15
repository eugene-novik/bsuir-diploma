$(document).ready(function () {
    $.post("Show", function (data) {
        var user = JSON.parse(data);
        var name=user.surname + " " + user.name;
        var control=user.control;
        var city=user.city;
        alert(name+control+city);
        $("#name").html(name);
        $("#control").html(control);
        $("#city").html(city);
    });
});