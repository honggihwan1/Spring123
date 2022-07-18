$(document).ready(function(){
        $.getJSON("/api/v1/best", function(result){
            let html ="";
            $.each(result, function(i, field){
                //$("div").append(field + " ");
                //console.log(field.menu);
               // console.log(field['price']);
                //console.log(field.img);


                html += "<td>" + field.menu + "</td>"
                html += "<td>" + field.price + "</td>"
                html += "<td><img src='" + field.img + "'></td>"
            });
            $("#bestmenu").html(html);
        });
});
