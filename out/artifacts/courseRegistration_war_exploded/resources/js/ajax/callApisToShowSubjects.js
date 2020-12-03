
//임시로 temp 버튼에 api call 연결
$('#tempBtn').on("click",function () {

    $.ajax({
        url: '/course_api/course',
        type: "GET",
        contentType: "application/json; charset=utf-8;",
        dataType: "json",
        success: function(data){

            alert("조회 성공");
            console.log(data);

            $('#courses').empty();

            if(data != null){
                var content = [];

                for(var i=0; i<data.length; i++){
                    var id = JSON.stringify(data[i].id);

                    content.push("<tr>");
                    content.push("<td>" + JSON.stringify(data[i].year) +"</td>");
                    content.push("<td>" + JSON.stringify(data[i].semester) +"</td>");
                    content.push("<td>" + JSON.stringify(data[i].division).replace(/\"/gi, "") +"</td>");
                    content.push("<td>" + JSON.stringify(data[i].credit) +"</td>");
                    content.push("<td>" + JSON.stringify(data[i].subject).replace(/\"/gi, "") +"</td>");
                    content.push("<td>"
                        +"<a class='showDetails' id='"+id+"' href='#'>"+"<i class=\"fas fa-info-circle\"></i>"+"</a>"
                        +"</td>");
                    content.push("</tr>");
                }

                $('#courses').append(content);
            }

        },
        error: function(error,text){
            alert("조회 실패 (error : " + text + " )");
            console.log(error);
            console.log(text);
        }
    });

});

