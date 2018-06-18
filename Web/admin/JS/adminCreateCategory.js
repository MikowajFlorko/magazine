$('#addCategory').click(function () {
    var name = $('#category').val();

    var newGoods = {
        'name': name,
    };
    $.ajax({
        'url': 'http://localhost:8080/admin/createCategory',
        'type': "PUT",
        'contentType': 'application/json',
        'headers': {
            Token: localStorage.getItem('token')
        },
        'dataType': 'json',
        'data': JSON.stringify(newGoods),
        'success': function (data) {
            alert('Товар додано');
            location.href = 'adminCreateGoods.html'
        }
    });
});
$.ajax({
    'url': 'http://localhost:8080/admin/findAllCategory',
    'type': "GET",
    'contentType': 'application/json',
    'headers': {
        Token: localStorage.getItem('token')
    },
    'success': function (data) {
        for (var key in data) {
            var id = $('#id');
            var name = $('#name');
            var deleteCategory = $('#delete');
            id.append('<ol>' + data[key].id + '</ol>');
            name.append('<ol>' + data[key].name + '</ol>');
            deleteCategory.append('<font size="-1"><ol><button class="delete" value="' + data[key].id + '">Delete</button></ol></font>');

        }
        setClickOnDelete();
    }
})

function setClickOnDelete() {
    $('.delete').click(function () {
        var deleteReq = {
            'id': this.value
        }
        $.ajax({
            'url': 'http://localhost:8080/admin/deleteCategory',
            'type': "DELETE",
            'contentType': 'application/json',
            'headers': {
                Token: localStorage.getItem('token')
            },
            'dataType': 'json',
            'data': JSON.stringify(deleteReq),
            'success': function () {
                location.reload();
            }
        });
    });
}
$('#btnExit').click(function () {
    localStorage.clear();
})
