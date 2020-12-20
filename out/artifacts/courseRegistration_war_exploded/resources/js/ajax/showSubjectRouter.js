/**
 * GET
 *
 * 1. page load : get all courses
 * 2. setup error msg
 */
$(document).ready(function () {

    $.ajaxSetup({
        error: function(jqXHR, exception) {
            if (jqXHR.status === 0) {
                alert('Not connect.\n Verify Network.');
            }
            else if (jqXHR.status == 400) {
                alert('Server understood the request, but request content was invalid. [400]');
            }
            else if (jqXHR.status == 401) {
                alert('Unauthorized access. [401]');
            }
            else if (jqXHR.status == 403) {
                alert('Forbidden resource can not be accessed. [403]');
            }
            else if (jqXHR.status == 404) {
                alert('Requested page not found. [404]');
            }
            else if (jqXHR.status == 500) {
                alert('Internal server error. [500]');
            }
            else if (jqXHR.status == 503) {
                alert('Service unavailable. [503]');
            }
            else if (exception === 'parsererror') {
                alert('Requested JSON parse failed. [Failed]');
            }
            else if (exception === 'timeout') {
                alert('Time out error. [Timeout]');
            }
            else if (exception === 'abort') {
                alert('Ajax request aborted. [Aborted]');
            }
            else {
                alert('Uncaught Error.n' + jqXHR.responseText);
            }
        }
    });

    $.ajax({
        url: '/course_api/courses',
        type: "GET",
        contentType: "application/json; charset=utf-8;",
        dataType: "json",
        success: function(data){
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

        }
    });

});

/**
 * POST
 *
 * get specific courses : 특정 조건의 교과목 가져오기
 *
 * spring form으로 model에 값을 삽입한 후에 넘겨와야 course json 데이터 파싱가능.
 */
$('#search_subject_btn').on('click',function () {

    var formData = $('#search_form').serializeObject();
    console.log("연도 :" + formData["year"]);
    console.log("학기 : "+formData["semester"]);
    console.log("학과 : " + formData["division"]);
    
    $.ajax({
        url : '/course_api/courses',
        type : "POST",
        data : JSON.stringify(formData),
        contentType : "application/json; charset=utf-8;",
        dataType: "json",
        success:function (data) {
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
        }
    });

});


/**
 * data -> json parse 함수
 *
 * @returns json parsed data
 */
jQuery.fn.serializeObject = function() {
    var obj = null;
    try {
        if(this[0].tagName && this[0].tagName.toUpperCase() == "FORM" ) {
            var arr = this.serializeArray();
            if(arr){ obj = {};
                jQuery.each(arr, function() {
                    obj[this.name] = this.value; });
            }
        }
    }catch(e) {
        alert(e.message);
    }finally {}
    return obj;
};
