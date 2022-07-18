$(document).ready(function(){
        $.getJSON("/api/v1/movie", function(result){
            let html ="";
            $.each(result, function(i, field){
                //$("div").append(field + " ");
                //console.log(field.menu);
               // console.log(field['price']);
                //console.log(field.img);
                html += "<tr></tr><td><img src='" + field.img + "'></td>"
                html += "<td>" + field.tit + "</td></tr>"
            });
            $("#movie").html(html);
        });
});
