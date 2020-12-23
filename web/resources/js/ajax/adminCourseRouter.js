/**
 * 교과목 관리 router
 */
$(document).ready(function () {
    /**
     * GET
     * 2. setup error msg
     */
    /*
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
    });*/
});

/**
 * POST : Create Course
 * uri : /course_api/courses
 */
$('#create_course').on('click',function () {

    var formData = $('#addForm').serializeObject();

    $.ajax({
        url: '/course_api/courses',
        type: "POST",
        data: JSON.stringify(formData) ,
        contentType: "application/json; charset=utf-8;",
        success:function () {
            alert("추가 성공");
            location.href = "/admin/adminCourse";
        },
        error:function (error) {
            alert("추가 실패");
            console.log(error);
        }
    });

});

/**
 * DELETE : delete course by id
 * uri : /course_api/courses/{id}
 *
 */
$('.delete_course').on('click',function () {

    var id = $(this).attr("id");

    console.log(id);

    $.ajax({
        url: '/course_api/courses/'+id,
        type: "DELETE",
        contentType: "application/json; charset=utf-8;",
        dataType: "json",
        success: function(data){
            alert("삭제 성공");
            location.href = "/admin/adminCourse";
        },
        error:function (error) {
            alert("삭제 실패");
            console.log(error);
        }
    });

});

/**
 * PUT : update Course
 * uri : /course_api/courses/{id}
 */
$('#update_course').on('click',function () {

    var formData = $('#addForm').serializeObject();

    $.ajax({
        url: '/course_api/courses/',
        type: "PUT",
        data: JSON.stringify(formData) ,
        contentType: "application/json; charset=utf-8;",
        success:function () {
            alert("추가 성공");
            location.href = "/admin/adminCourse";
        },
        error:function (error) {
            alert("추가 실패");
            console.log(error);
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
