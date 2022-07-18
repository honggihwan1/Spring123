$(document).ready(function(){
        $("button").click(function(){
            let url = "/api/v1/blogmenu?keyword=" + $("#keyword").val();
             $.getJSON(url, function(result){
                let html ="";
                $.each(result.items, function(i, field){
                    //$("div").append(field + " ");
                    console.log(field.title);
                   // console.log(field['price']);
                    //console.log(field.img);
                    html += "<a href ='" + field.link + "' target='_blank\'>"+ field.title + "</a><br>"
                   // html += "<img src='" + field.img + "'>"
                });
                 $("#bloglist").html(html);
            });
        });
});
