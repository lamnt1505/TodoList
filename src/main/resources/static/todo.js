
$(document).ready(function () {
    getAll();
});
function addTodo() {
    var datatodo = {
        "title": $('#titleAddTodo').val(),
        "description": $('#descriptionAddTodo').val(),
        "startdate": $('#startdateAddTodo').val(),
        "duedate": $('#duedateAddTodo').val(),
        "status": $('#statusAddTodo').val(),
        "functions": $('#functionsAddTodo').val()
    };
    $.ajax({
        type: "POST",
        contentType: "application/json",
        dataType: 'json',
        url: "/rest/todo/add",
        data: JSON.stringify(datatodo),
        success: function (result) {
            alert("Add Task Complete!");
            $('#titleAddTodo').val('');
            $('#descriptionAddTodo').val('');
            $('#startdateAddTodo').val('');
            $('#duedateAddTodo').val('');
            $('#statusAddTodo').val('');
            $('#functionsAddTodo').val('');
        },
        error: function (result) {
            alert('failed');
        }
    });
}