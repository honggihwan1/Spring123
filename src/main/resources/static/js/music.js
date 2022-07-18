$(document).ready(function(){
    $.getJSON("/api/v1/melon", function(result){
        let html ="";
        $.each(result, function(i, field){
            html += "<tr><td>" + field.rank + "</td>"
            html += "<td>" + field.song + "</td>"
            html += "<td>" + field.gasu + "</td></tr>"
        });
        $("#music").html(html); // musixList.html의 id값
    });
});